package com.sky.dis.control;

abstract class WorkerRunnable implements Runnable {
    private boolean enabled;
    
    void setEnabled(boolean value) {
        enabled = value;
    }
    
    protected boolean isEnabled() {
        return enabled;
    }
    
    abstract boolean preRun();
    
    abstract void postRun();
}
