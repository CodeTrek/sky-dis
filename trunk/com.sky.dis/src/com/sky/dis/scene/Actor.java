/*
    Copyright (c) 2013 Jay Graham

    Distributed under the MIT License (see accompanying file LICENSE_1_0_0.txt
    or http://www.opensource.org/licenses/mit-license.php)
*/

package com.sky.dis.scene;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.geom.Vec4;
import gov.nasa.worldwind.globes.Globe;

import com.sky.dis.om.rpr.Entity;

public class Actor implements IActor {

    private String id;

    private Position position;

    public Actor(Entity entity, Globe globe) {

        // Convert from DIS XYZ to world wind XYZ
        // Note:
        // ww.x = dis.y : index 1
        // ww.y = dis.z : index 2
        // ww.z = dis.x : index 0

        final Vec4 wwXyzPos = new Vec4(entity.getWorldLocation().getY(), entity.getWorldLocation().getZ(), entity
                        .getWorldLocation().getX());

        // Compute lat, lon, alt position
        position = globe.computePositionFromPoint(wwXyzPos);

        id = entity.getEntityId().toString();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return getId() + ", " + position;
    }

    void update(IActor updateActor) {
        position = updateActor.getPosition();
    }
}
