/**
 */
package com.sky.dis.om.rpr;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sky.dis.om.rpr.Entity#getEntityId <em>Entity Id</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.Entity#getWorldLocation <em>World Location</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.Entity#getOrientation <em>Orientation</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sky.dis.om.rpr.RprPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends EObject {
    /**
     * Returns the value of the '<em><b>Entity Id</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entity Id</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entity Id</em>' containment reference.
     * @see #setEntityId(EntityId)
     * @see com.sky.dis.om.rpr.RprPackage#getEntity_EntityId()
     * @model containment="true" required="true"
     * @generated
     */
    EntityId getEntityId();

    /**
     * Sets the value of the '{@link com.sky.dis.om.rpr.Entity#getEntityId <em>Entity Id</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Entity Id</em>' containment reference.
     * @see #getEntityId()
     * @generated
     */
    void setEntityId(EntityId value);

    /**
     * Returns the value of the '<em><b>World Location</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>World Location</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>World Location</em>' containment reference.
     * @see #setWorldLocation(WorldLocation)
     * @see com.sky.dis.om.rpr.RprPackage#getEntity_WorldLocation()
     * @model containment="true" required="true"
     * @generated
     */
    WorldLocation getWorldLocation();

    /**
     * Sets the value of the '{@link com.sky.dis.om.rpr.Entity#getWorldLocation <em>World Location</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>World Location</em>' containment reference.
     * @see #getWorldLocation()
     * @generated
     */
    void setWorldLocation(WorldLocation value);

    /**
     * Returns the value of the '<em><b>Orientation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Orientation</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Orientation</em>' containment reference.
     * @see #setOrientation(Orientation)
     * @see com.sky.dis.om.rpr.RprPackage#getEntity_Orientation()
     * @model containment="true" required="true"
     * @generated
     */
    Orientation getOrientation();

    /**
     * Sets the value of the '{@link com.sky.dis.om.rpr.Entity#getOrientation <em>Orientation</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Orientation</em>' containment reference.
     * @see #getOrientation()
     * @generated
     */
    void setOrientation(Orientation value);

} // Entity
