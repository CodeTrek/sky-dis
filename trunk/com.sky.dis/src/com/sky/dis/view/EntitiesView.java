package com.sky.dis.view;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.sky.dis.model.EditingDomain;
import com.sky.dis.model.ItemProvider;

public class EntitiesView extends ViewPart {

    public static final String ID = "com.sky.dis.view.EntitiesView"; //$NON-NLS-1$
    private TreeViewer treeViewer;

    public EntitiesView() {
    }

    /**
     * Create contents of the view part.
     * 
     * @param parent
     */
    @Override
    public void createPartControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new FillLayout(SWT.HORIZONTAL));

        treeViewer = new TreeViewer(container, SWT.BORDER);

        treeViewer.setContentProvider(ItemProvider.getInstance().newContentProvider());
        treeViewer.setLabelProvider(ItemProvider.getInstance().newLabelProvider());
        treeViewer.setInput(EditingDomain.getInstance().getResourceSet());
    }

    @Override
    public void setFocus() {
        treeViewer.getTree().setFocus();
    }
}
