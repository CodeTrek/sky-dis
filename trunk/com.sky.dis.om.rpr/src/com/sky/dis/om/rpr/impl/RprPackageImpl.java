/**
 */
package com.sky.dis.om.rpr.impl;

import com.sky.dis.om.rpr.Entity;
import com.sky.dis.om.rpr.EntityId;
import com.sky.dis.om.rpr.Orientation;
import com.sky.dis.om.rpr.RprFactory;
import com.sky.dis.om.rpr.RprPackage;
import com.sky.dis.om.rpr.World;
import com.sky.dis.om.rpr.WorldLocation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RprPackageImpl extends EPackageImpl implements RprPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass worldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass entityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass entityIdEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass worldLocationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass orientationEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see com.sky.dis.om.rpr.RprPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private RprPackageImpl() {
        super(eNS_URI, RprFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link RprPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static RprPackage init() {
        if (isInited) return (RprPackage)EPackage.Registry.INSTANCE.getEPackage(RprPackage.eNS_URI);

        // Obtain or create and register package
        RprPackageImpl theRprPackage = (RprPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RprPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RprPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theRprPackage.createPackageContents();

        // Initialize created meta-data
        theRprPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theRprPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(RprPackage.eNS_URI, theRprPackage);
        return theRprPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWorld() {
        return worldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWorld_Entities() {
        return (EReference)worldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEntity() {
        return entityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEntity_EntityId() {
        return (EReference)entityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEntity_WorldLocation() {
        return (EReference)entityEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEntity_Orientation() {
        return (EReference)entityEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEntityId() {
        return entityIdEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEntityId_Site() {
        return (EAttribute)entityIdEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEntityId_Host() {
        return (EAttribute)entityIdEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEntityId_EntityId() {
        return (EAttribute)entityIdEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWorldLocation() {
        return worldLocationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWorldLocation_X() {
        return (EAttribute)worldLocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWorldLocation_Y() {
        return (EAttribute)worldLocationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWorldLocation_Z() {
        return (EAttribute)worldLocationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOrientation() {
        return orientationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOrientation_Heading() {
        return (EAttribute)orientationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOrientation_Pitch() {
        return (EAttribute)orientationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOrientation_Roll() {
        return (EAttribute)orientationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RprFactory getRprFactory() {
        return (RprFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        worldEClass = createEClass(WORLD);
        createEReference(worldEClass, WORLD__ENTITIES);

        entityEClass = createEClass(ENTITY);
        createEReference(entityEClass, ENTITY__ENTITY_ID);
        createEReference(entityEClass, ENTITY__WORLD_LOCATION);
        createEReference(entityEClass, ENTITY__ORIENTATION);

        entityIdEClass = createEClass(ENTITY_ID);
        createEAttribute(entityIdEClass, ENTITY_ID__SITE);
        createEAttribute(entityIdEClass, ENTITY_ID__HOST);
        createEAttribute(entityIdEClass, ENTITY_ID__ENTITY_ID);

        worldLocationEClass = createEClass(WORLD_LOCATION);
        createEAttribute(worldLocationEClass, WORLD_LOCATION__X);
        createEAttribute(worldLocationEClass, WORLD_LOCATION__Y);
        createEAttribute(worldLocationEClass, WORLD_LOCATION__Z);

        orientationEClass = createEClass(ORIENTATION);
        createEAttribute(orientationEClass, ORIENTATION__HEADING);
        createEAttribute(orientationEClass, ORIENTATION__PITCH);
        createEAttribute(orientationEClass, ORIENTATION__ROLL);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(worldEClass, World.class, "World", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWorld_Entities(), this.getEntity(), null, "entities", null, 0, -1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEntity_EntityId(), this.getEntityId(), null, "entityId", null, 1, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEntity_WorldLocation(), this.getWorldLocation(), null, "worldLocation", null, 1, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEntity_Orientation(), this.getOrientation(), null, "orientation", null, 1, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(entityIdEClass, EntityId.class, "EntityId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEntityId_Site(), ecorePackage.getEShort(), "site", null, 0, 1, EntityId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEntityId_Host(), ecorePackage.getEShort(), "host", null, 0, 1, EntityId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEntityId_EntityId(), ecorePackage.getEShort(), "entityId", null, 0, 1, EntityId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(worldLocationEClass, WorldLocation.class, "WorldLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWorldLocation_X(), ecorePackage.getEDouble(), "x", null, 1, 1, WorldLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorldLocation_Y(), ecorePackage.getEDouble(), "y", null, 1, 1, WorldLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorldLocation_Z(), ecorePackage.getEDouble(), "z", null, 1, 1, WorldLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(orientationEClass, Orientation.class, "Orientation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOrientation_Heading(), ecorePackage.getEFloat(), "heading", null, 1, 1, Orientation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOrientation_Pitch(), ecorePackage.getEFloat(), "pitch", null, 1, 1, Orientation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOrientation_Roll(), ecorePackage.getEFloat(), "roll", null, 1, 1, Orientation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //RprPackageImpl
