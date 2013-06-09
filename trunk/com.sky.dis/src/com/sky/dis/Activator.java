/*
    Copyright (c) 2013 Jay Graham

    Distributed under the MIT License (see accompanying file LICENSE_1_0_0.txt
    or http://www.opensource.org/licenses/mit-license.php)
 */

package com.sky.dis;

import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sky.dis.cmd.IStateDrivenItem;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sky.dis";

    // The shared instance
    private static Activator plugin;

    private static final String UNEXPECTED_EXCEPTION = "unexpected exception";

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given plug-in
     * relative path
     * 
     * @param path
     *            the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    private Vector<IStateDrivenItem> cmdHandlers = new Vector<IStateDrivenItem>();

    private MessageConsole messageConsole;

    private MessageConsoleStream messageStream;

    public Activator() {
    }

    public void addStateDrivenItem(IStateDrivenItem item) {
        if (cmdHandlers.contains(item)) {
            return;
        }

        cmdHandlers.add(item);
    }

    public MessageConsoleStream getMessageConsoleStream() {
        return messageStream;
    }

    public void logException(Throwable e) {
        getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, UNEXPECTED_EXCEPTION, e));
    }

    public void logInfo(String msg) {
        getLog().log(new Status(IStatus.INFO, PLUGIN_ID, msg));
    }

    public void logWarning(String msg) {
        getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, msg));
    }

    public void removeStateDrivenItem(IStateDrivenItem item) {
        cmdHandlers.remove(item);
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;

        messageConsole = new MessageConsole("DisViz Message Console", null);
        messageStream = messageConsole.newMessageStream();

        ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { messageConsole });
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    public void updateHandlers() {
        for (IStateDrivenItem handler : cmdHandlers) {
            handler.update();
        }
    }
}
