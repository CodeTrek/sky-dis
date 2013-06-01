package com.sky.dis;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.sky.dis.control.DisControl;
import com.sky.dis.model.EditingDomain;
import com.sky.dis.model.TheWorld;
import com.sky.dis.preferences.PreferenceConstants;
import com.sky.dis.scene.Scene;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

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

    private void initializeSingletons() {
        TheWorld.getInstance();
        EditingDomain.getInstance();
        Scene.getInstance();
    }

    @Override
    public void postStartup() {

        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        int disPort = store.getInt(PreferenceConstants.P_DIS_PORT);
        DisControl.postStartup(disPort);

        initializeSingletons();

        super.postStartup();
    }

    @Override
    public boolean preShutdown() {
        DisControl.preShutdown();
        return super.preShutdown();
    }
}
