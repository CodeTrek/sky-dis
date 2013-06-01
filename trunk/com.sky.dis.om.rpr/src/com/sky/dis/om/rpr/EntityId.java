/**
 */
package com.sky.dis.om.rpr;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sky.dis.om.rpr.EntityId#getSite <em>Site</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.EntityId#getHost <em>Host</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.EntityId#getEntityId <em>Entity Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sky.dis.om.rpr.RprPackage#getEntityId()
 * @model
 * @generated
 */
public interface EntityId extends EObject {
    /**
     * Returns the value of the '<em><b>Site</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Site</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Site</em>' attribute.
     * @see #setSite(short)
     * @see com.sky.dis.om.rpr.RprPackage#getEntityId_Site()
     * @model
     * @generated
     */
    short getSite();

    /**
     * Sets the value of the '{@link com.sky.dis.om.rpr.EntityId#getSite <em>Site</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Site</em>' attribute.
     * @see #getSite()
     * @generated
     */
    void setSite(short value);

    /**
     * Returns the value of the '<em><b>Host</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Host</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Host</em>' attribute.
     * @see #setHost(short)
     * @see com.sky.dis.om.rpr.RprPackage#getEntityId_Host()
     * @model
     * @generated
     */
    short getHost();

    /**
     * Sets the value of the '{@link com.sky.dis.om.rpr.EntityId#getHost <em>Host</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Host</em>' attribute.
     * @see #getHost()
     * @generated
     */
    void setHost(short value);

    /**
     * Returns the value of the '<em><b>Entity Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entity Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entity Id</em>' attribute.
     * @see #setEntityId(short)
     * @see com.sky.dis.om.rpr.RprPackage#getEntityId_EntityId()
     * @model
     * @generated
     */
    short getEntityId();

    /**
     * Sets the value of the '{@link com.sky.dis.om.rpr.EntityId#getEntityId <em>Entity Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Entity Id</em>' attribute.
     * @see #getEntityId()
     * @generated
     */
    void setEntityId(short value);

} // EntityId
