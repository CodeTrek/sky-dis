package com.sky.dis.model;

import com.sky.dis.om.rpr.RprFactory;
import com.sky.dis.om.rpr.World;

public class TheWorld {
    
    private static World world;
    
    public static World getInstance() {
        if (world == null) {
            world = RprFactory.eINSTANCE.createWorld();
        }
        
        return world;
    }

    private TheWorld() {
    }
}
