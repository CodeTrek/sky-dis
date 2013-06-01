/**
 */
package com.sky.dis.om.rpr;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sky.dis.om.rpr.RprPackage
 * @generated
 */
public interface RprFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    RprFactory eINSTANCE = com.sky.dis.om.rpr.impl.RprFactoryImpl.init();

    /**
     * Returns a new object of class '<em>World</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>World</em>'.
     * @generated
     */
    World createWorld();

    /**
     * Returns a new object of class '<em>Entity</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Entity</em>'.
     * @generated
     */
    Entity createEntity();

    /**
     * Returns a new object of class '<em>Entity Id</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Entity Id</em>'.
     * @generated
     */
    EntityId createEntityId();

    /**
     * Returns a new object of class '<em>World Location</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>World Location</em>'.
     * @generated
     */
    WorldLocation createWorldLocation();

    /**
     * Returns a new object of class '<em>Orientation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Orientation</em>'.
     * @generated
     */
    Orientation createOrientation();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    RprPackage getRprPackage();

} //RprFactory
