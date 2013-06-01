package com.sky.dis.model.builder;

import com.sky.dis.om.rpr.EntityId;
import com.sky.dis.om.rpr.RprFactory;

public class EntityIdBuilder {
    private short site;
    private short host;
    private short entityId;
    
    private EntityIdBuilder() {}
    
    public static EntityIdBuilder obj() {
        return new EntityIdBuilder();
    }
    
    public EntityIdBuilder site(short value) {
        site = value;
        return this;
    }
    
    public EntityIdBuilder host(short value) {
        host = value;
        return this;
    }
    
    public EntityIdBuilder entityId(short value) {
        entityId = value;
        return this;
    }
    
    public EntityId build() {
        EntityId newEntityId = RprFactory.eINSTANCE.createEntityId();
        newEntityId.setSite(site);
        
        newEntityId.setHost(host);
        newEntityId.setEntityId(entityId);
        
        return newEntityId;
    }
}
