/*
    Copyright (c) 2013 Jay Graham

    Distributed under the MIT License (see accompanying file LICENSE_1_0_0.txt
    or http://www.opensource.org/licenses/mit-license.php)
 */

package com.sky.dis.scene;

import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.event.RenderingEvent;
import gov.nasa.worldwind.event.RenderingListener;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;

import com.sky.dis.Activator;
import com.sky.dis.model.EditingDomain;
import com.sky.dis.model.TheWorld;
import com.sky.dis.om.rpr.Entity;
import com.sky.dis.om.rpr.RprPackage;
import com.sky.dis.om.rpr.World;

public class Scene implements RenderingListener {
    private class WorldListener extends EContentAdapter {

        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);

            EObject notifier = (EObject) notification.getNotifier();

            // Entity update?
            if (notifier.eClass().getClassifierID() == RprPackage.ENTITY) {
                updateEntity((Entity) notification.getNotifier());
            } else {
                EStructuralFeature feature = (EStructuralFeature) notification.getFeature();

                // Not a feature change?
                if (feature == null) {
                    return;
                }

                int featureId = feature.getFeatureID();

                if (featureId == RprPackage.WORLD__ENTITIES) {
                    // Adding a new entity?
                    if (notification.getNewValue() != null) {
                        addEntity((Entity) notification.getNewValue());

                        // Removing an entity?
                    } else if (notification.getOldValue() != null) {
                        removeEntity((Entity) notification.getOldValue());
                    }
                }
            }
        }
    }

    public static final int MAX_QUEUE_SIZE = 6000;

    private static Scene scene;

    public static Scene getInstance() {

        if (scene == null) {
            scene = new Scene();
            World world = TheWorld.getInstance();
            world.eAdapters().add(scene.worldListener);
        }

        return scene;
    }

    private Map<String, IActor> actors;
    private ArrayBlockingQueue<IActor> addActorQueue;
    private ForceIdLayer forceIdLayer;

    private ArrayBlockingQueue<String> removeActorQueue;

    private ArrayBlockingQueue<IActor> updateActorQueue;

    private WorldWindowGLCanvas worldCanvas;

    private WorldListener worldListener;

    private Scene() {
        worldListener = new WorldListener();
        actors = new HashMap<String, IActor>();
        addActorQueue = new ArrayBlockingQueue<IActor>(MAX_QUEUE_SIZE);
        updateActorQueue = new ArrayBlockingQueue<IActor>(4 * MAX_QUEUE_SIZE);
        removeActorQueue = new ArrayBlockingQueue<String>(MAX_QUEUE_SIZE);
    }

    public void addToWorldView(WorldWindowGLCanvas worldCanvas) {
        this.worldCanvas = worldCanvas;
        worldCanvas.addRenderingListener(this);

        forceIdLayer = new ForceIdLayer();
        worldCanvas.getModel().getLayers().add(forceIdLayer);
    }

    public void removeFromWorldView() {
        worldCanvas.removeRenderingListener(this);
        forceIdLayer = null;
        worldCanvas = null;
    }

    @Override
    public void stageChanged(RenderingEvent renderingEvent) {
        switch (renderingEvent.getStage()) {
        case RenderingEvent.BEFORE_RENDERING:
            addActors();
            removeActors();
            updateActors();
            break;
        case RenderingEvent.BEFORE_BUFFER_SWAP:
            break;
        case RenderingEvent.AFTER_BUFFER_SWAP:
            break;
        }
    }

    private void addActors() {
        IActor actor = addActorQueue.poll();

        while (actor != null) {
            addActorToScene(actor);
            actor = addActorQueue.poll();
        }
    }

    private void addActorToScene(IActor actor) {
        actors.put(actor.getId(), actor);
    }

    private void addEntity(final Entity entity) {
        try {
            EditingDomain.getInstance().runExclusive(new Runnable() {

                @Override
                public void run() {
                    if (worldCanvas == null) {
                        return;
                    }

                    Actor actor = new Actor(entity, worldCanvas.getModel().getGlobe());
                    addActorQueue.offer(actor);
                }
            });
        } catch (InterruptedException e) {
            Activator.getDefault().logException(e);
        }
    }

    private void removeActors() {
        String actorId = removeActorQueue.poll();

        while (actorId != null) {
            actors.remove(actorId);
            actorId = removeActorQueue.poll();
        }
    }

    private void removeEntity(final Entity entity) {
        try {
            EditingDomain.getInstance().runExclusive(new Runnable() {

                @Override
                public void run() {
                    removeActorQueue.offer(entity.getEntityId().toString());
                }
            });
        } catch (InterruptedException e) {
            Activator.getDefault().logException(e);
        }
    }

    private void updateActors() {
        IActor updateActor = updateActorQueue.poll();

        while (updateActor != null) {
            Actor actor = (Actor) actors.get(updateActor.getId());

            if (actor != null) {
                actor.update(updateActor);
            } else {
                addActorToScene(updateActor);
            }

            updateActor = updateActorQueue.poll();
        }
    }

    private void updateEntity(final Entity entity) {

        try {
            EditingDomain.getInstance().runExclusive(new Runnable() {

                @Override
                public void run() {
                    if (worldCanvas == null) {
                        return;
                    }
                    IActor actor = new Actor(entity, worldCanvas.getModel().getGlobe());
                    updateActorQueue.offer(actor);
                    worldCanvas.redraw();
                }
            });
        } catch (InterruptedException e) {
            Activator.getDefault().logException(e);
        }
    }

    Collection<IActor> getActors() {
        return actors.values();
    }

}
