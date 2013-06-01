package com.sky.dis.model.builder;

import com.sky.dis.om.rpr.Orientation;
import com.sky.dis.om.rpr.RprFactory;

public class OrientationBuilder {
    
    private float heading;
    private float pitch;
    private float roll;
    
    private OrientationBuilder() {}
    
    public static OrientationBuilder obj() {
        return new OrientationBuilder();
    }
    
    public OrientationBuilder heading(float value) {
        heading = value;
        return this;
    }
    
    public OrientationBuilder pitch(float value) {
        pitch = value;
        return this;
    }
    
    public OrientationBuilder roll(float value) {
        roll = value;
        return this;
    }
    
    public Orientation build() {
        
        Orientation orientation = RprFactory.eINSTANCE.createOrientation();
        
        orientation.setHeading(heading);
        orientation.setPitch(pitch);
        orientation.setRoll(roll);
        
        return orientation;
    }
}
