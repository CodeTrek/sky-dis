package com.sky.dis.model;

import com.sky.dis.om.rpr.RprFactory;

public class World {
    
    private static World theWorld;
    public static World getInstance() {
        if (theWorld == null) {
            theWorld = newWorld();
        }
        
        return theWorld;
    }
    
    private static World newWorld() {
        return new World();
    }

    @SuppressWarnings("unused")
    private com.sky.dis.om.rpr.World worldData;

    private World() {
        worldData = RprFactory.eINSTANCE.createWorld();
    }
}
