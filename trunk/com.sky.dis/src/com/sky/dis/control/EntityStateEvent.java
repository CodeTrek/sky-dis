package com.sky.dis.control;

import edu.nps.moves.dis.FastEntityStatePdu;

public class EntityStateEvent implements DisPduEvent {

    public EntityStateEvent(FastEntityStatePdu pdu) {
        System.out.println("Entity: " + pdu.getSite() + "." + pdu.getExerciseID() + "." + pdu.getEntity());
    }
}
