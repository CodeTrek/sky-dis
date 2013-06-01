package com.sky.dis.cmd;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import com.sky.dis.Activator;
import com.sky.dis.control.DisControl;


public class StartDisCmd extends AbstractCommand implements IHandler {
    @Override
    public boolean isEnabled() {
        return (!DisControl.getInstance().isRunning());
    }

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        DisControl.getInstance().start();
        Activator.getDefault().updateHandlers();
        return null;
    }
}