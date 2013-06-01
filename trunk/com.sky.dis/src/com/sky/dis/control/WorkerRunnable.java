package com.sky.dis.control;

abstract class WorkerRunnable implements Runnable {
    private boolean enabled;
    
    protected boolean isEnabled() {
        return enabled;
    }
    
    abstract void postRun();
    
    abstract boolean preRun();
    
    void setEnabled(boolean value) {
        enabled = value;
    }
}
