package com.sky.dis.control;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import edu.nps.moves.dis.FastEntityStatePdu;

public class DisPduToRprModelAdapter extends WorkerRunnable {
    private BlockingQueue<DisPduEvent> eventQueue;
    private static final int TIME_OUT_MS = 250;

    public DisPduToRprModelAdapter(BlockingQueue<DisPduEvent> eventQueue) {
        this.eventQueue = eventQueue;
    }

    @Override
    public void run() {
        while (isEnabled()) {
            EntityStateEvent pduEvent = null;
            try {
                pduEvent = (EntityStateEvent) eventQueue.poll(TIME_OUT_MS, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                break;
            }
            if (pduEvent != null) {
                FastEntityStatePdu pdu = pduEvent.getPdu();
                System.out.println("Process entity: " + pdu.getSite() + "." + pdu.getExerciseID() + "."
                                + pdu.getEntity());
            }
        }
    }

    @Override
    boolean preRun() {
        return true;
    }

    @Override
    void postRun() {
    }
}