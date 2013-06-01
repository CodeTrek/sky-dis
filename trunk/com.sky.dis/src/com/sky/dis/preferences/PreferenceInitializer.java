package com.sky.dis.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.sky.dis.Activator;


public class PreferenceInitializer extends AbstractPreferenceInitializer {

    @Override
    public void initializeDefaultPreferences() {
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        store.setDefault(PreferenceConstants.P_DIS_IP_ADDRESS, "127.0.0.1");
        store.setDefault(PreferenceConstants.P_DIS_PORT, "3000");
    }

}
