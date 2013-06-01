package com.sky.dis.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;

import com.sky.dis.Activator;

public class DisConfigurationPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public DisConfigurationPage() {
        super(GRID);
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
        setDescription("DIS network parameters");
    }

    @Override
    public void createFieldEditors() {
        addField(new StringFieldEditor(PreferenceConstants.P_DIS_IP_ADDRESS, "IP Address:", getFieldEditorParent()));
        addField(new IntegerFieldEditor(PreferenceConstants.P_DIS_PORT, "Port:", getFieldEditorParent()));
    }

    @Override
    public void init(IWorkbench workbench) {
    }

}