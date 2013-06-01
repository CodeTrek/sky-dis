/**
 */
package com.sky.dis.om.rpr.impl;

import com.sky.dis.om.rpr.Orientation;
import com.sky.dis.om.rpr.RprPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Orientation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sky.dis.om.rpr.impl.OrientationImpl#getHeading <em>Heading</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.impl.OrientationImpl#getPitch <em>Pitch</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.impl.OrientationImpl#getRoll <em>Roll</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrientationImpl extends EObjectImpl implements Orientation {
    /**
     * The default value of the '{@link #getHeading() <em>Heading</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeading()
     * @generated
     * @ordered
     */
    protected static final float HEADING_EDEFAULT = 0.0F;

    /**
     * The cached value of the '{@link #getHeading() <em>Heading</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeading()
     * @generated
     * @ordered
     */
    protected float heading = HEADING_EDEFAULT;

    /**
     * The default value of the '{@link #getPitch() <em>Pitch</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPitch()
     * @generated
     * @ordered
     */
    protected static final float PITCH_EDEFAULT = 0.0F;

    /**
     * The cached value of the '{@link #getPitch() <em>Pitch</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPitch()
     * @generated
     * @ordered
     */
    protected float pitch = PITCH_EDEFAULT;

    /**
     * The default value of the '{@link #getRoll() <em>Roll</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRoll()
     * @generated
     * @ordered
     */
    protected static final float ROLL_EDEFAULT = 0.0F;

    /**
     * The cached value of the '{@link #getRoll() <em>Roll</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRoll()
     * @generated
     * @ordered
     */
    protected float roll = ROLL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OrientationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RprPackage.Literals.ORIENTATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public float getHeading() {
        return heading;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHeading(float newHeading) {
        float oldHeading = heading;
        heading = newHeading;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.ORIENTATION__HEADING, oldHeading, heading));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public float getPitch() {
        return pitch;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPitch(float newPitch) {
        float oldPitch = pitch;
        pitch = newPitch;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.ORIENTATION__PITCH, oldPitch, pitch));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public float getRoll() {
        return roll;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRoll(float newRoll) {
        float oldRoll = roll;
        roll = newRoll;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.ORIENTATION__ROLL, oldRoll, roll));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RprPackage.ORIENTATION__HEADING:
                return getHeading();
            case RprPackage.ORIENTATION__PITCH:
                return getPitch();
            case RprPackage.ORIENTATION__ROLL:
                return getRoll();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case RprPackage.ORIENTATION__HEADING:
                setHeading((Float)newValue);
                return;
            case RprPackage.ORIENTATION__PITCH:
                setPitch((Float)newValue);
                return;
            case RprPackage.ORIENTATION__ROLL:
                setRoll((Float)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case RprPackage.ORIENTATION__HEADING:
                setHeading(HEADING_EDEFAULT);
                return;
            case RprPackage.ORIENTATION__PITCH:
                setPitch(PITCH_EDEFAULT);
                return;
            case RprPackage.ORIENTATION__ROLL:
                setRoll(ROLL_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case RprPackage.ORIENTATION__HEADING:
                return heading != HEADING_EDEFAULT;
            case RprPackage.ORIENTATION__PITCH:
                return pitch != PITCH_EDEFAULT;
            case RprPackage.ORIENTATION__ROLL:
                return roll != ROLL_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (heading: ");
        result.append(heading);
        result.append(", pitch: ");
        result.append(pitch);
        result.append(", roll: ");
        result.append(roll);
        result.append(')');
        return result.toString();
    }

} //OrientationImpl
