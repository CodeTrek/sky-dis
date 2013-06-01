package com.sky.dis.control;

import java.util.concurrent.BlockingQueue;

public class DisPduToRprModelAdapter extends WorkerRunnable {
    private BlockingQueue<DisPduEvent> eventQueue;

    public DisPduToRprModelAdapter(BlockingQueue<DisPduEvent> eventQueue) {
        this.eventQueue = eventQueue;
    }

    @Override
    public void run() {
        while (this.isEnabled()) {
            if (eventQueue.peek() != null) {
                eventQueue.poll();
                System.out.println("DisPduToRprModelAdapter process next event...");
            }
            
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
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