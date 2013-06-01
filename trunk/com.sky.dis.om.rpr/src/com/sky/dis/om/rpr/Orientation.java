/**
 */
package com.sky.dis.om.rpr;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Orientation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sky.dis.om.rpr.Orientation#getHeading <em>Heading</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.Orientation#getPitch <em>Pitch</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.Orientation#getRoll <em>Roll</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sky.dis.om.rpr.RprPackage#getOrientation()
 * @model
 * @generated
 */
public interface Orientation extends EObject {
    /**
     * Returns the value of the '<em><b>Heading</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Heading</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Heading</em>' attribute.
     * @see #setHeading(float)
     * @see com.sky.dis.om.rpr.RprPackage#getOrientation_Heading()
     * @model required="true"
     * @generated
     */
    float getHeading();

    /**
     * Sets the value of the '{@link com.sky.dis.om.rpr.Orientation#getHeading <em>Heading</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Heading</em>' attribute.
     * @see #getHeading()
     * @generated
     */
    void setHeading(float value);

    /**
     * Returns the value of the '<em><b>Pitch</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pitch</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pitch</em>' attribute.
     * @see #setPitch(float)
     * @see com.sky.dis.om.rpr.RprPackage#getOrientation_Pitch()
     * @model required="true"
     * @generated
     */
    float getPitch();

    /**
     * Sets the value of the '{@link com.sky.dis.om.rpr.Orientation#getPitch <em>Pitch</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pitch</em>' attribute.
     * @see #getPitch()
     * @generated
     */
    void setPitch(float value);

    /**
     * Returns the value of the '<em><b>Roll</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Roll</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Roll</em>' attribute.
     * @see #setRoll(float)
     * @see com.sky.dis.om.rpr.RprPackage#getOrientation_Roll()
     * @model required="true"
     * @generated
     */
    float getRoll();

    /**
     * Sets the value of the '{@link com.sky.dis.om.rpr.Orientation#getRoll <em>Roll</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Roll</em>' attribute.
     * @see #getRoll()
     * @generated
     */
    void setRoll(float value);

} // Orientation
