package com.sky.dis.control;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;

import com.sky.dis.Activator;

import edu.nps.moves.dis.FastEntityStatePdu;
import edu.nps.moves.dis.Pdu;
import edu.nps.moves.disenum.PduType;
import edu.nps.moves.disutil.PduFactory;

public class DisIoRunnable extends WorkerRunnable {
    private static final int IO_TIMEOUT_MS = 500;
    private static final int MAX_PDU_SIZE_BYTES = 8192;

    private BlockingQueue<DisPduEvent> eventQueue;
    private DatagramPacket packet;
    private PduFactory pduFactory;
    private int port;
    private DatagramSocket socket = null;

    DisIoRunnable(int port, BlockingQueue<DisPduEvent> eventQueue) {
        this.port = port;
        this.eventQueue = eventQueue;
    }

    @Override
    public void run() {
        while (isEnabled()) {
            try {
                socket.receive(packet);
            } catch (SocketTimeoutException e) {
                continue;
            } catch (IOException e) {
                // TODO: Send exception message to the data processor.
                Activator.getDefault().logException(e);
                break;
            }

            ByteBuffer byteBuffer = ByteBuffer.wrap(packet.getData());
            Pdu pdu = pduFactory.createPdu(byteBuffer);

            // Not a recognized PDU?
            if (pdu == null) {
                continue;
            }

            // Not an entity state PDU?
            if (!isEntityStatePdu(pdu)) {
                continue;
            }

            // Notify the client.
            eventQueue.offer(new EntityStateEvent((FastEntityStatePdu) pdu));
        }

        socket.close();
        socket = null;
    }

    private boolean isEntityStatePdu(Pdu pdu) {
        return (pdu.getPduType() == PduType.ENTITY_STATE.value);
    }

    @Override
    void postRun() {
        packet = null;
        pduFactory = null;
    }

    @Override
    boolean preRun() {
        // Open a socket to receive DIS pdus
        try {
            socket = new DatagramSocket(null);
            socket.setReuseAddress(true);
            socket.setSoTimeout(IO_TIMEOUT_MS);
            socket.bind(new InetSocketAddress(port));
        } catch (SocketException e) {
            socket = null;
            e.printStackTrace();
            return false;
        }

        pduFactory = new PduFactory(true);
        byte[] buffer = new byte[MAX_PDU_SIZE_BYTES];
        packet = new DatagramPacket(buffer, buffer.length);

        return true;
    }
}
