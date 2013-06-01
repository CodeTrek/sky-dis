/**
 */
package com.sky.dis.om.rpr.impl;

import com.sky.dis.om.rpr.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RprFactoryImpl extends EFactoryImpl implements RprFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static RprFactory init() {
        try {
            RprFactory theRprFactory = (RprFactory)EPackage.Registry.INSTANCE.getEFactory("htp:///com/sky/dis/om/rpr.ecore/1.0"); 
            if (theRprFactory != null) {
                return theRprFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new RprFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RprFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case RprPackage.WORLD: return createWorld();
            case RprPackage.ENTITY: return createEntity();
            case RprPackage.ENTITY_ID: return createEntityId();
            case RprPackage.WORLD_LOCATION: return createWorldLocation();
            case RprPackage.ORIENTATION: return createOrientation();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public World createWorld() {
        WorldImpl world = new WorldImpl();
        return world;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Entity createEntity() {
        EntityImpl entity = new EntityImpl();
        return entity;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EntityId createEntityId() {
        EntityIdImpl entityId = new EntityIdImpl();
        return entityId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WorldLocation createWorldLocation() {
        WorldLocationImpl worldLocation = new WorldLocationImpl();
        return worldLocation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Orientation createOrientation() {
        OrientationImpl orientation = new OrientationImpl();
        return orientation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RprPackage getRprPackage() {
        return (RprPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static RprPackage getPackage() {
        return RprPackage.eINSTANCE;
    }

} //RprFactoryImpl
