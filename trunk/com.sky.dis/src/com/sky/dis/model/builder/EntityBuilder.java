package com.sky.dis.model.builder;

import com.sky.dis.om.rpr.Entity;
import com.sky.dis.om.rpr.EntityId;
import com.sky.dis.om.rpr.RprFactory;

public class EntityBuilder {
    
    private EntityIdBuilder entityIdBuilder;
    
    private EntityBuilder() {}
    
    public static EntityBuilder obj() {
        return new EntityBuilder();
    }

    public EntityBuilder entityId(EntityIdBuilder value) {
        entityIdBuilder = value;
        return this;
    }
    
    public EntityBuilder worldLocation() {
        return this;
    }
    
    public EntityBuilder orientation() {
        return this;
    }
    
    public Entity build() {
       
        Entity newEntity = RprFactory.eINSTANCE.createEntity();
        EntityId id = entityIdBuilder.build();
        
        newEntity.setEntityId(id);
        
        return newEntity;
    }
}
