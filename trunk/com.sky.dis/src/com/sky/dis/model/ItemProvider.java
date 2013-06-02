package com.sky.dis.model;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;

import com.sky.dis.om.rpr.provider.RprItemProviderAdapterFactory;

public class ItemProvider {

    private static ItemProvider itemProvider;

    public static ItemProvider getInstance() {

        if (itemProvider == null) {
            itemProvider = new ItemProvider();
        }

        return itemProvider;
    }

    private ComposedAdapterFactory adapterFactory;

    private ItemProvider() {
        adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new RprItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
    }

    public TransactionalAdapterFactoryContentProvider newContentProvider() {
        TransactionalEditingDomain ed = EditingDomain.getInstance();

        TransactionalAdapterFactoryContentProvider contentProvider = new TransactionalAdapterFactoryContentProvider(ed,
                        adapterFactory);

        return contentProvider;
    }

    public TransactionalAdapterFactoryLabelProvider newLabelProvider() {
        TransactionalEditingDomain ed = EditingDomain.getInstance();

        TransactionalAdapterFactoryLabelProvider labelProvider = new TransactionalAdapterFactoryLabelProvider(ed,
                        adapterFactory);

        return labelProvider;
    }
}
