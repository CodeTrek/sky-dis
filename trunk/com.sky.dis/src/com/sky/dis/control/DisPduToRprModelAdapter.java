package com.sky.dis.control;

import java.util.Collections;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.sky.dis.Activator;
import com.sky.dis.model.EditingDomain;
import com.sky.dis.model.Query;
import com.sky.dis.model.TheWorld;
import com.sky.dis.model.builder.EntityBuilder;
import com.sky.dis.model.builder.EntityIdBuilder;
import com.sky.dis.model.builder.OrientationBuilder;
import com.sky.dis.model.builder.WorldLocationBuilder;
import com.sky.dis.om.rpr.Entity;
import com.sky.dis.om.rpr.RprPackage;

import edu.nps.moves.dis.FastEntityStatePdu;

public class DisPduToRprModelAdapter extends WorkerRunnable {
    private static final int TIME_OUT_MS = 250;
    private BlockingQueue<DisPduEvent> eventQueue;

    public DisPduToRprModelAdapter(BlockingQueue<DisPduEvent> eventQueue) {
        this.eventQueue = eventQueue;
    }

    @Override
    public void run() {
        while (isEnabled()) {
            EntityStateEvent pduEvent = null;
            try {
                pduEvent = (EntityStateEvent) eventQueue.poll(TIME_OUT_MS, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                break;
            }
            if (pduEvent != null) {
                FastEntityStatePdu pdu = pduEvent.getPdu();
                handlePduEvent(pdu);
            }
        }
    }

    private void handlePduEvent(FastEntityStatePdu pdu) {
        Entity entity = Query.findEntityById(TheWorld.getInstance(), pdu.getSite(), pdu.getApplication(),
                        pdu.getEntity());

        if (entity != null) {
            update(entity, pdu);
        } else {
            newEntity(pdu);
        }
    }

    private void newEntity(FastEntityStatePdu pdu) {
        Entity entity = EntityBuilder
                        .obj()
                        .entityId(EntityIdBuilder.obj().site((short) pdu.getSite()).host((short) pdu.getApplication())
                                        .entityId((short) pdu.getEntity()))
                        .worldLocation(WorldLocationBuilder.obj().x(pdu.getXLocation()).y(pdu.getYLocation())
                                        .z(pdu.getZLocation()))
                        .orientation(OrientationBuilder.obj().heading(pdu.getPsi()).pitch(pdu.getTheta())
                                        .roll(pdu.getPhi())).build();

        TransactionalEditingDomain ed = EditingDomain.getInstance();

        Command cmd = AddCommand.create(ed, TheWorld.getInstance(), RprPackage.Literals.WORLD__ENTITIES, entity);

        if ((cmd != null) && cmd.canExecute()) {
            TransactionalCommandStack tstack = (TransactionalCommandStack) ed.getCommandStack();
            try {
                tstack.execute(cmd, Collections.EMPTY_MAP);
            } catch (InterruptedException e) {
                Activator.getDefault().logException(e);
            } catch (RollbackException e) {
                Activator.getDefault().logException(e);
            }

            ed.getCommandStack().flush();
        }
    }

    private void update(Entity entity, FastEntityStatePdu pdu) {
        TransactionalEditingDomain ed = EditingDomain.getInstance();

        WorldLocationBuilder worldLocation = WorldLocationBuilder.obj().x(pdu.getXLocation()).y(pdu.getYLocation())
                        .z(pdu.getZLocation());

        OrientationBuilder orientation = OrientationBuilder.obj().heading(pdu.getPsi()).pitch(pdu.getTheta())
                        .roll(pdu.getPhi());

        Command setWorldLocation = SetCommand.create(ed, entity, RprPackage.Literals.ENTITY__WORLD_LOCATION,
                        worldLocation.build());

        Command setOrientation = SetCommand.create(ed, entity, RprPackage.Literals.ENTITY__ORIENTATION,
                        orientation.build());

        TransactionalCommandStack tstack = (TransactionalCommandStack) ed.getCommandStack();

        if ((setWorldLocation != null) && setWorldLocation.canExecute()) {
            try {
                tstack.execute(setWorldLocation, Collections.EMPTY_MAP);
            } catch (InterruptedException e) {
                Activator.getDefault().logException(e);
            } catch (RollbackException e) {
                Activator.getDefault().logException(e);
            }
        }

        if ((setOrientation != null) && setOrientation.canExecute()) {
            try {
                tstack.execute(setOrientation, Collections.EMPTY_MAP);
            } catch (InterruptedException e) {
                Activator.getDefault().logException(e);
            } catch (RollbackException e) {
                Activator.getDefault().logException(e);
            }
        }
    }

    @Override
    void postRun() {
    }

    @Override
    boolean preRun() {
        return true;
    }
}