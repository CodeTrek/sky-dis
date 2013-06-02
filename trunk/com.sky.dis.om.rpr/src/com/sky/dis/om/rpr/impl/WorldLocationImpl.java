/**
 */
package com.sky.dis.om.rpr.impl;

import com.sky.dis.om.rpr.RprPackage;
import com.sky.dis.om.rpr.WorldLocation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>World Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sky.dis.om.rpr.impl.WorldLocationImpl#getX <em>X</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.impl.WorldLocationImpl#getY <em>Y</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.impl.WorldLocationImpl#getZ <em>Z</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.impl.WorldLocationImpl#getEcefString <em>Ecef String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorldLocationImpl extends EObjectImpl implements WorldLocation {
    /**
     * The default value of the '{@link #getX() <em>X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getX()
     * @generated
     * @ordered
     */
    protected static final double X_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getX() <em>X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getX()
     * @generated
     * @ordered
     */
    protected double x = X_EDEFAULT;

    /**
     * The default value of the '{@link #getY() <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getY()
     * @generated
     * @ordered
     */
    protected static final double Y_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getY()
     * @generated
     * @ordered
     */
    protected double y = Y_EDEFAULT;

    /**
     * The default value of the '{@link #getZ() <em>Z</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getZ()
     * @generated
     * @ordered
     */
    protected static final double Z_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getZ() <em>Z</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getZ()
     * @generated
     * @ordered
     */
    protected double z = Z_EDEFAULT;

    /**
     * The default value of the '{@link #getEcefString() <em>Ecef String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEcefString()
     * @generated
     * @ordered
     */
    protected static final String ECEF_STRING_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WorldLocationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RprPackage.Literals.WORLD_LOCATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getX() {
        return x;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setX(double newX) {
        double oldX = x;
        x = newX;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.WORLD_LOCATION__X, oldX, x));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getY() {
        return y;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setY(double newY) {
        double oldY = y;
        y = newY;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.WORLD_LOCATION__Y, oldY, y));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getZ() {
        return z;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setZ(double newZ) {
        double oldZ = z;
        z = newZ;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.WORLD_LOCATION__Z, oldZ, z));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEcefString() {
        String value = String.format("(%.3f, %.3f, %.3f)", getX(), getY(), getZ());
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RprPackage.WORLD_LOCATION__X:
                return getX();
            case RprPackage.WORLD_LOCATION__Y:
                return getY();
            case RprPackage.WORLD_LOCATION__Z:
                return getZ();
            case RprPackage.WORLD_LOCATION__ECEF_STRING:
                return getEcefString();
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
            case RprPackage.WORLD_LOCATION__X:
                setX((Double)newValue);
                return;
            case RprPackage.WORLD_LOCATION__Y:
                setY((Double)newValue);
                return;
            case RprPackage.WORLD_LOCATION__Z:
                setZ((Double)newValue);
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
            case RprPackage.WORLD_LOCATION__X:
                setX(X_EDEFAULT);
                return;
            case RprPackage.WORLD_LOCATION__Y:
                setY(Y_EDEFAULT);
                return;
            case RprPackage.WORLD_LOCATION__Z:
                setZ(Z_EDEFAULT);
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
            case RprPackage.WORLD_LOCATION__X:
                return x != X_EDEFAULT;
            case RprPackage.WORLD_LOCATION__Y:
                return y != Y_EDEFAULT;
            case RprPackage.WORLD_LOCATION__Z:
                return z != Z_EDEFAULT;
            case RprPackage.WORLD_LOCATION__ECEF_STRING:
                return ECEF_STRING_EDEFAULT == null ? getEcefString() != null : !ECEF_STRING_EDEFAULT.equals(getEcefString());
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
        result.append(" (x: ");
        result.append(x);
        result.append(", y: ");
        result.append(y);
        result.append(", z: ");
        result.append(z);
        result.append(')');
        return result.toString();
    }

} //WorldLocationImpl
