/**
 */
package com.sky.dis.om.rpr;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.sky.dis.om.rpr.RprFactory
 * @model kind="package"
 * @generated
 */
public interface RprPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "rpr";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "htp:///com/sky/dis/om/rpr.ecore/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "com.sky.dis.om.rpr";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    RprPackage eINSTANCE = com.sky.dis.om.rpr.impl.RprPackageImpl.init();

    /**
     * The meta object id for the '{@link com.sky.dis.om.rpr.impl.WorldImpl <em>World</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sky.dis.om.rpr.impl.WorldImpl
     * @see com.sky.dis.om.rpr.impl.RprPackageImpl#getWorld()
     * @generated
     */
    int WORLD = 0;

    /**
     * The feature id for the '<em><b>Entities</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__ENTITIES = 0;

    /**
     * The number of structural features of the '<em>World</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link com.sky.dis.om.rpr.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sky.dis.om.rpr.impl.EntityImpl
     * @see com.sky.dis.om.rpr.impl.RprPackageImpl#getEntity()
     * @generated
     */
    int ENTITY = 1;

    /**
     * The feature id for the '<em><b>Entity Id</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY__ENTITY_ID = 0;

    /**
     * The feature id for the '<em><b>World Location</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY__WORLD_LOCATION = 1;

    /**
     * The feature id for the '<em><b>Orientation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY__ORIENTATION = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY__NAME = 3;

    /**
     * The number of structural features of the '<em>Entity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link com.sky.dis.om.rpr.impl.EntityIdImpl <em>Entity Id</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sky.dis.om.rpr.impl.EntityIdImpl
     * @see com.sky.dis.om.rpr.impl.RprPackageImpl#getEntityId()
     * @generated
     */
    int ENTITY_ID = 2;

    /**
     * The feature id for the '<em><b>Site</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY_ID__SITE = 0;

    /**
     * The feature id for the '<em><b>Host</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY_ID__HOST = 1;

    /**
     * The feature id for the '<em><b>Entity Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY_ID__ENTITY_ID = 2;

    /**
     * The number of structural features of the '<em>Entity Id</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY_ID_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link com.sky.dis.om.rpr.impl.WorldLocationImpl <em>World Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sky.dis.om.rpr.impl.WorldLocationImpl
     * @see com.sky.dis.om.rpr.impl.RprPackageImpl#getWorldLocation()
     * @generated
     */
    int WORLD_LOCATION = 3;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD_LOCATION__X = 0;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD_LOCATION__Y = 1;

    /**
     * The feature id for the '<em><b>Z</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD_LOCATION__Z = 2;

    /**
     * The feature id for the '<em><b>Ecef String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD_LOCATION__ECEF_STRING = 3;

    /**
     * The number of structural features of the '<em>World Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD_LOCATION_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link com.sky.dis.om.rpr.impl.OrientationImpl <em>Orientation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sky.dis.om.rpr.impl.OrientationImpl
     * @see com.sky.dis.om.rpr.impl.RprPackageImpl#getOrientation()
     * @generated
     */
    int ORIENTATION = 4;

    /**
     * The feature id for the '<em><b>Heading</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORIENTATION__HEADING = 0;

    /**
     * The feature id for the '<em><b>Pitch</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORIENTATION__PITCH = 1;

    /**
     * The feature id for the '<em><b>Roll</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORIENTATION__ROLL = 2;

    /**
     * The number of structural features of the '<em>Orientation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORIENTATION_FEATURE_COUNT = 3;


    /**
     * Returns the meta object for class '{@link com.sky.dis.om.rpr.World <em>World</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>World</em>'.
     * @see com.sky.dis.om.rpr.World
     * @generated
     */
    EClass getWorld();

    /**
     * Returns the meta object for the containment reference list '{@link com.sky.dis.om.rpr.World#getEntities <em>Entities</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Entities</em>'.
     * @see com.sky.dis.om.rpr.World#getEntities()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_Entities();

    /**
     * Returns the meta object for class '{@link com.sky.dis.om.rpr.Entity <em>Entity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Entity</em>'.
     * @see com.sky.dis.om.rpr.Entity
     * @generated
     */
    EClass getEntity();

    /**
     * Returns the meta object for the containment reference '{@link com.sky.dis.om.rpr.Entity#getEntityId <em>Entity Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Entity Id</em>'.
     * @see com.sky.dis.om.rpr.Entity#getEntityId()
     * @see #getEntity()
     * @generated
     */
    EReference getEntity_EntityId();

    /**
     * Returns the meta object for the containment reference '{@link com.sky.dis.om.rpr.Entity#getWorldLocation <em>World Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>World Location</em>'.
     * @see com.sky.dis.om.rpr.Entity#getWorldLocation()
     * @see #getEntity()
     * @generated
     */
    EReference getEntity_WorldLocation();

    /**
     * Returns the meta object for the containment reference '{@link com.sky.dis.om.rpr.Entity#getOrientation <em>Orientation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Orientation</em>'.
     * @see com.sky.dis.om.rpr.Entity#getOrientation()
     * @see #getEntity()
     * @generated
     */
    EReference getEntity_Orientation();

    /**
     * Returns the meta object for the attribute '{@link com.sky.dis.om.rpr.Entity#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.sky.dis.om.rpr.Entity#getName()
     * @see #getEntity()
     * @generated
     */
    EAttribute getEntity_Name();

    /**
     * Returns the meta object for class '{@link com.sky.dis.om.rpr.EntityId <em>Entity Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Entity Id</em>'.
     * @see com.sky.dis.om.rpr.EntityId
     * @generated
     */
    EClass getEntityId();

    /**
     * Returns the meta object for the attribute '{@link com.sky.dis.om.rpr.EntityId#getSite <em>Site</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Site</em>'.
     * @see com.sky.dis.om.rpr.EntityId#getSite()
     * @see #getEntityId()
     * @generated
     */
    EAttribute getEntityId_Site();

    /**
     * Returns the meta object for the attribute '{@link com.sky.dis.om.rpr.EntityId#getHost <em>Host</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Host</em>'.
     * @see com.sky.dis.om.rpr.EntityId#getHost()
     * @see #getEntityId()
     * @generated
     */
    EAttribute getEntityId_Host();

    /**
     * Returns the meta object for the attribute '{@link com.sky.dis.om.rpr.EntityId#getEntityId <em>Entity Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Entity Id</em>'.
     * @see com.sky.dis.om.rpr.EntityId#getEntityId()
     * @see #getEntityId()
     * @generated
     */
    EAttribute getEntityId_EntityId();

    /**
     * Returns the meta object for class '{@link com.sky.dis.om.rpr.WorldLocation <em>World Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>World Location</em>'.
     * @see com.sky.dis.om.rpr.WorldLocation
     * @generated
     */
    EClass getWorldLocation();

    /**
     * Returns the meta object for the attribute '{@link com.sky.dis.om.rpr.WorldLocation#getX <em>X</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>X</em>'.
     * @see com.sky.dis.om.rpr.WorldLocation#getX()
     * @see #getWorldLocation()
     * @generated
     */
    EAttribute getWorldLocation_X();

    /**
     * Returns the meta object for the attribute '{@link com.sky.dis.om.rpr.WorldLocation#getY <em>Y</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Y</em>'.
     * @see com.sky.dis.om.rpr.WorldLocation#getY()
     * @see #getWorldLocation()
     * @generated
     */
    EAttribute getWorldLocation_Y();

    /**
     * Returns the meta object for the attribute '{@link com.sky.dis.om.rpr.WorldLocation#getZ <em>Z</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Z</em>'.
     * @see com.sky.dis.om.rpr.WorldLocation#getZ()
     * @see #getWorldLocation()
     * @generated
     */
    EAttribute getWorldLocation_Z();

    /**
     * Returns the meta object for the attribute '{@link com.sky.dis.om.rpr.WorldLocation#getEcefString <em>Ecef String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ecef String</em>'.
     * @see com.sky.dis.om.rpr.WorldLocation#getEcefString()
     * @see #getWorldLocation()
     * @generated
     */
    EAttribute getWorldLocation_EcefString();

    /**
     * Returns the meta object for class '{@link com.sky.dis.om.rpr.Orientation <em>Orientation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Orientation</em>'.
     * @see com.sky.dis.om.rpr.Orientation
     * @generated
     */
    EClass getOrientation();

    /**
     * Returns the meta object for the attribute '{@link com.sky.dis.om.rpr.Orientation#getHeading <em>Heading</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Heading</em>'.
     * @see com.sky.dis.om.rpr.Orientation#getHeading()
     * @see #getOrientation()
     * @generated
     */
    EAttribute getOrientation_Heading();

    /**
     * Returns the meta object for the attribute '{@link com.sky.dis.om.rpr.Orientation#getPitch <em>Pitch</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pitch</em>'.
     * @see com.sky.dis.om.rpr.Orientation#getPitch()
     * @see #getOrientation()
     * @generated
     */
    EAttribute getOrientation_Pitch();

    /**
     * Returns the meta object for the attribute '{@link com.sky.dis.om.rpr.Orientation#getRoll <em>Roll</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Roll</em>'.
     * @see com.sky.dis.om.rpr.Orientation#getRoll()
     * @see #getOrientation()
     * @generated
     */
    EAttribute getOrientation_Roll();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    RprFactory getRprFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link com.sky.dis.om.rpr.impl.WorldImpl <em>World</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sky.dis.om.rpr.impl.WorldImpl
         * @see com.sky.dis.om.rpr.impl.RprPackageImpl#getWorld()
         * @generated
         */
        EClass WORLD = eINSTANCE.getWorld();

        /**
         * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__ENTITIES = eINSTANCE.getWorld_Entities();

        /**
         * The meta object literal for the '{@link com.sky.dis.om.rpr.impl.EntityImpl <em>Entity</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sky.dis.om.rpr.impl.EntityImpl
         * @see com.sky.dis.om.rpr.impl.RprPackageImpl#getEntity()
         * @generated
         */
        EClass ENTITY = eINSTANCE.getEntity();

        /**
         * The meta object literal for the '<em><b>Entity Id</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ENTITY__ENTITY_ID = eINSTANCE.getEntity_EntityId();

        /**
         * The meta object literal for the '<em><b>World Location</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ENTITY__WORLD_LOCATION = eINSTANCE.getEntity_WorldLocation();

        /**
         * The meta object literal for the '<em><b>Orientation</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ENTITY__ORIENTATION = eINSTANCE.getEntity_Orientation();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

        /**
         * The meta object literal for the '{@link com.sky.dis.om.rpr.impl.EntityIdImpl <em>Entity Id</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sky.dis.om.rpr.impl.EntityIdImpl
         * @see com.sky.dis.om.rpr.impl.RprPackageImpl#getEntityId()
         * @generated
         */
        EClass ENTITY_ID = eINSTANCE.getEntityId();

        /**
         * The meta object literal for the '<em><b>Site</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ENTITY_ID__SITE = eINSTANCE.getEntityId_Site();

        /**
         * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ENTITY_ID__HOST = eINSTANCE.getEntityId_Host();

        /**
         * The meta object literal for the '<em><b>Entity Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ENTITY_ID__ENTITY_ID = eINSTANCE.getEntityId_EntityId();

        /**
         * The meta object literal for the '{@link com.sky.dis.om.rpr.impl.WorldLocationImpl <em>World Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sky.dis.om.rpr.impl.WorldLocationImpl
         * @see com.sky.dis.om.rpr.impl.RprPackageImpl#getWorldLocation()
         * @generated
         */
        EClass WORLD_LOCATION = eINSTANCE.getWorldLocation();

        /**
         * The meta object literal for the '<em><b>X</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WORLD_LOCATION__X = eINSTANCE.getWorldLocation_X();

        /**
         * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WORLD_LOCATION__Y = eINSTANCE.getWorldLocation_Y();

        /**
         * The meta object literal for the '<em><b>Z</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WORLD_LOCATION__Z = eINSTANCE.getWorldLocation_Z();

        /**
         * The meta object literal for the '<em><b>Ecef String</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WORLD_LOCATION__ECEF_STRING = eINSTANCE.getWorldLocation_EcefString();

        /**
         * The meta object literal for the '{@link com.sky.dis.om.rpr.impl.OrientationImpl <em>Orientation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sky.dis.om.rpr.impl.OrientationImpl
         * @see com.sky.dis.om.rpr.impl.RprPackageImpl#getOrientation()
         * @generated
         */
        EClass ORIENTATION = eINSTANCE.getOrientation();

        /**
         * The meta object literal for the '<em><b>Heading</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ORIENTATION__HEADING = eINSTANCE.getOrientation_Heading();

        /**
         * The meta object literal for the '<em><b>Pitch</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ORIENTATION__PITCH = eINSTANCE.getOrientation_Pitch();

        /**
         * The meta object literal for the '<em><b>Roll</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ORIENTATION__ROLL = eINSTANCE.getOrientation_Roll();

    }

} //RprPackage
