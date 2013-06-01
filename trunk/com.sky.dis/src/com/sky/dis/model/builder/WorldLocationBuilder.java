package com.sky.dis.model.builder;

import com.sky.dis.om.rpr.RprFactory;
import com.sky.dis.om.rpr.WorldLocation;

public class WorldLocationBuilder {
    
    private double x;
    private double y;
    private double z;
    
    private WorldLocationBuilder() {}
    
    public static WorldLocationBuilder obj() {
        return new WorldLocationBuilder();
    }
    
    public WorldLocationBuilder x(double value) {
        x = value;
        return this;
    }
    
    public WorldLocationBuilder y(double value) {
        y = value;
        return this;
    }
    
    public WorldLocationBuilder z(double value) {
        z = value;
        return this;
    }
    
    public WorldLocation build() {
        
        WorldLocation worldLocation = RprFactory.eINSTANCE.createWorldLocation();
        
        worldLocation.setX(x);
        worldLocation.setY(y);
        worldLocation.setZ(z);
        
        return worldLocation;
    }
}
