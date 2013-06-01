package com.sky.dis.model;

import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.sky.dis.om.rpr.Entity;
import com.sky.dis.om.rpr.EntityId;
import com.sky.dis.om.rpr.World;

public class Query {

    public static Entity findEntityById(final World world, final int site, final int host, final int entityId) {
        if (world == null) {
            return null;
        }

        TransactionalEditingDomain editingDomain = EditingDomain.getInstance();

        Entity entity = null;

        try {
            entity = (Entity) editingDomain.runExclusive(new RunnableWithResult.Impl<Entity>() {

                @Override
                public void run() {

                    for (Entity entity : world.getEntities()) {

                        EntityId id = entity.getEntityId();

                        if (isSameId(id, site, host, entityId)) {
                            setResult(entity);
                            break;
                        }
                    }

                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return entity;
    }

    public static boolean isSameId(EntityId id, int site, int host, int entityId) {

        if (id.getSite() != site) {
            return false;
        }

        if (id.getHost() != host) {
            return false;
        }

        if (id.getEntityId() != entityId) {
            return false;
        }

        return true;
    }
}
