package com.sky.dis.cmd;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.HandlerEvent;

import com.sky.dis.Activator;


public abstract class AbstractCommand extends AbstractHandler implements IStateDrivenItem {
    public AbstractCommand() {
        Activator.getDefault().addStateDrivenItem(this);
    }

    @Override
    public void dispose() {
        Activator.getDefault().removeStateDrivenItem(this);
    }

    @Override
    public boolean isHandled() {
        return true;
    }

    @Override
    public void update() {
        fireHandlerChanged(new HandlerEvent(this, true, false));
    }
}
