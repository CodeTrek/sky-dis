package com.sky.dis;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;
import com.sky.dis.view.WorldView;

public class Perspective implements IPerspectiveFactory {

    public void createInitialLayout(IPageLayout layout) {
        layout.setEditorAreaVisible(false);

        layout.addView(com.sky.dis.view.WorldView.ID, IPageLayout.BOTTOM, 0.05f, IPageLayout.ID_EDITOR_AREA);

        layout.addView(IConsoleConstants.ID_CONSOLE_VIEW, IPageLayout.BOTTOM, 0.75f, com.sky.dis.view.WorldView.ID);
        layout.addView("com.sky.dis.view.EntitiesView", IPageLayout.LEFT, 0.28f, WorldView.ID);
    }
}
