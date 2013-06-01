package com.sky.dis.control;

class WorkerThread {
    private WorkerRunnable runnable;
    private Thread workerThread = null;

    WorkerThread(WorkerRunnable runnable) {
        this.runnable = runnable;
    }

    private boolean isRunning() {
        return (workerThread != null);
    }

    boolean start() {
        if (isRunning()) {
            return true;
        }

        if (!runnable.preRun()) {
            return false;
        }

        runnable.setEnabled(true);

        workerThread = new Thread(runnable);

        workerThread.start();

        return true;
    }

    void stop() {
        if (!isRunning()) {
            return;
        }

        runnable.setEnabled(false);

        try {
            workerThread.join();
        } catch (InterruptedException e) {
        }

        runnable.postRun();

        workerThread = null;
    }
}
