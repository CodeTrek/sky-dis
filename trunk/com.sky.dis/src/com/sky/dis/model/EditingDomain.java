package com.sky.dis.model;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class EditingDomain {

    private static TransactionalEditingDomain editingDomain;

    private EditingDomain() {
        
    }
    
    public static TransactionalEditingDomain getInstance() {
        
        if (editingDomain == null) {
            editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
        }
        
        return editingDomain;
    }
}
