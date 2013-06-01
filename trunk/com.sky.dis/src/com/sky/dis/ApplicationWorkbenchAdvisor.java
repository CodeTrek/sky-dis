package com.sky.dis;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.sky.dis.control.DisControl;
import com.sky.dis.preferences.PreferenceConstants;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

    @Override
    public boolean preShutdown() {
        DisControl.preShutdown();
        return super.preShutdown();
    }

    @Override
    public void postStartup() {
        
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        int disPort = store.getInt(PreferenceConstants.P_DIS_PORT);
        DisControl.postStartup(disPort);
        
        super.postStartup();
    }

    private static final String PERSPECTIVE_ID = "com.sky.dis.perspective"; //$NON-NLS-1$

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

    public String getInitialWindowPerspectiveId() {
        return PERSPECTIVE_ID;
    }

    @Override
    public void initialize(IWorkbenchConfigurer configurer) {
        configurer.setSaveAndRestore(true);
        super.initialize(configurer);
    }
}
