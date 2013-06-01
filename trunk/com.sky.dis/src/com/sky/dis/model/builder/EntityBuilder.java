package com.sky.dis.model.builder;

import com.sky.dis.om.rpr.Entity;
import com.sky.dis.om.rpr.EntityId;
import com.sky.dis.om.rpr.Orientation;
import com.sky.dis.om.rpr.RprFactory;
import com.sky.dis.om.rpr.WorldLocation;

public class EntityBuilder {
    
    private EntityIdBuilder entityIdBuilder;
    private WorldLocationBuilder worldLocationBuilder;
    private OrientationBuilder orientationBuilder;
    
    private EntityBuilder() {}
    
    public static EntityBuilder obj() {
        return new EntityBuilder();
    }

    public EntityBuilder entityId(EntityIdBuilder value) {
        entityIdBuilder = value;
        return this;
    }
    
    public EntityBuilder worldLocation(WorldLocationBuilder value) {
        worldLocationBuilder = value;
        return this;
    }
    
    public EntityBuilder orientation(OrientationBuilder value) {
        orientationBuilder = value;
        return this;
    }
    
    public Entity build() {
       
        Entity newEntity = RprFactory.eINSTANCE.createEntity();
        EntityId id = entityIdBuilder.build();
        WorldLocation worldLocation = worldLocationBuilder.build();
        Orientation orientation = orientationBuilder.build();
        
        newEntity.setEntityId(id);
        newEntity.setWorldLocation(worldLocation);
        newEntity.setOrientation(orientation);
        
        return newEntity;
    }
}
