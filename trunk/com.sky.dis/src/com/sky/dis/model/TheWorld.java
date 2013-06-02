package com.sky.dis.model;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;

import com.sky.dis.om.rpr.RprFactory;
import com.sky.dis.om.rpr.World;

public class TheWorld {

    private static World world;

    public static World getInstance() {
        if (world == null) {
            // Create the world and add it as a resource.
            world = RprFactory.eINSTANCE.createWorld();

            Resource worldResource = EditingDomain.getInstance().getResourceSet()
                            .createResource(URI.createURI("world"));

            Command cmd = new AddCommand(EditingDomain.getInstance(), worldResource.getContents(), world);

            if ((cmd != null) && cmd.canExecute()) {

                EditingDomain.getInstance().getCommandStack().execute(cmd);
                EditingDomain.getInstance().getCommandStack().flush();
            }
        }

        return world;
    }

    private TheWorld() {
    }
}
