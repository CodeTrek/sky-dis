package com.sky.dis.control;

public class DisControl {

    private static DisControl disControl;

    public static DisControl getInstance() {
        if (disControl == null) {
            disControl = new DisControl();
        }

        return disControl;
    }
    
    public static void postStartup(int port) {
        disControl = getInstance();
        disControl.init(port);
    }
    
    public static void preShutdown() {
        if (disControl == null) {
            return;
        }

        disControl.stop();

        return;
    }

    private WorkerThread disIoThread;

    private WorkerThread disPduAdapterThread;

    private DisPduEventQueue disPduEventQueue;

    private int port;

    private DisControl() {
    }

    private void init(int port) {
        this.port = port;
    }

    public boolean isRunning() {
        return (disPduEventQueue != null);
    }

    public void start() {
        if (isRunning()) {
            return;
        }

        disPduEventQueue = new DisPduEventQueue();

        DisIoRunnable disIoRunnable = new DisIoRunnable(port, disPduEventQueue);
        disIoThread = new WorkerThread(disIoRunnable);

        DisPduToRprModelAdapter disPduAdapterRunnable = new DisPduToRprModelAdapter(disPduEventQueue);
        disPduAdapterThread = new WorkerThread(disPduAdapterRunnable);

        if (disIoThread.start()) {
            if (!disPduAdapterThread.start()) {
                disIoThread.stop();
                disPduEventQueue = null;
            }
        }
    }

    public void stop() {
        if (!isRunning()) {
            return;
        }

        disPduAdapterThread.stop();
        disIoThread.stop();
        disPduEventQueue.clear();

        disPduEventQueue = null;
    }
}
