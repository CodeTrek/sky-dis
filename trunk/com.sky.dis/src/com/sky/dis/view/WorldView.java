package com.sky.dis.view;

import gov.nasa.worldwind.Model;
import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.layers.LatLonGraticuleLayer;
import gov.nasa.worldwind.util.StatusBar;
import gov.nasa.worldwindx.examples.util.LayerManagerLayer;

import java.awt.BorderLayout;
import java.awt.Panel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class WorldView extends ViewPart {

    /**
     * The ID of the view as specified by the extension.
     */
    public static final String ID = "com.sky.dis.view.WorldView";

    private Composite viewComposite = null;

    private WorldWindowGLCanvas worldCanvas = null;

    private java.awt.Frame worldFrame = null;

    private Panel worldPanel;

    public WorldView() {
    }

    @Override
    public void createPartControl(Composite parent) {
        viewComposite = new Composite(parent, SWT.EMBEDDED);
        viewComposite.setLayoutData(new GridData(GridData.FILL_BOTH));

        worldFrame = SWT_AWT.new_Frame(viewComposite);
        worldPanel = new java.awt.Panel(new java.awt.BorderLayout());

        worldFrame.add(worldPanel);

        worldCanvas = new WorldWindowGLCanvas();

        Model m = (Model) WorldWind.createConfigurationComponent(AVKey.MODEL_CLASS_NAME);
        m.setShowWireframeExterior(false);
        m.setShowWireframeInterior(false);
        m.setShowTessellationBoundingVolumes(false);

        LatLonGraticuleLayer llaLayer = new LatLonGraticuleLayer();
        llaLayer.setEnabled(false);

        m.getLayers().add(llaLayer);

        // Add the layer manager layer to the model layer list
        LayerManagerLayer layerManager = new LayerManagerLayer(worldCanvas);
        layerManager.setEnabled(false);
        m.getLayers().add(layerManager);

        worldCanvas.setModel(m);

        worldCanvas.setVisible(true);

        worldPanel.add(worldCanvas, BorderLayout.CENTER);

        StatusBar statusBar = new StatusBar();
        worldPanel.add(statusBar, BorderLayout.PAGE_END);
        statusBar.setEventSource(worldCanvas);

        parent.setLayoutData(new GridData(GridData.FILL_BOTH));
    }

    /**
     * Passing the focus request to the viewer's control.
     */
    public void setFocus() {
        worldCanvas.requestFocus();
        worldCanvas.redraw();
    }
}