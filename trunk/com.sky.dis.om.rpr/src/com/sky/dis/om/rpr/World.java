/**
 */
package com.sky.dis.om.rpr;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sky.dis.om.rpr.World#getEntities <em>Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sky.dis.om.rpr.RprPackage#getWorld()
 * @model
 * @generated
 */
public interface World extends EObject {
    /**
     * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
     * The list contents are of type {@link com.sky.dis.om.rpr.Entity}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entities</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entities</em>' containment reference list.
     * @see com.sky.dis.om.rpr.RprPackage#getWorld_Entities()
     * @model containment="true"
     * @generated
     */
    EList<Entity> getEntities();

} // World
