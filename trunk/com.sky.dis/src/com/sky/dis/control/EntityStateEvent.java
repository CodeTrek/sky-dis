package com.sky.dis.control;

import edu.nps.moves.dis.FastEntityStatePdu;

public class EntityStateEvent implements DisPduEvent {
    
    private FastEntityStatePdu pdu;

    EntityStateEvent(FastEntityStatePdu pdu) {
        this.pdu = pdu;
    }
    
    FastEntityStatePdu getPdu() {
        return pdu;
    }
}
