package com.sky.dis.scene;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import com.sky.dis.model.TheWorld;
import com.sky.dis.om.rpr.World;

public class Scene {
    private class WorldListener extends EContentAdapter {

        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);

            System.out.println(notification);
        }
    }

    private static Scene scene;

    public static Scene getInstance() {

        if (scene == null) {
            scene = new Scene();
            World world = TheWorld.getInstance();
            world.eAdapters().add(scene.worldListener);
        }
        
        return scene;
    }

    private WorldListener worldListener;

    private Scene() {
        worldListener = new WorldListener();
    }
}
