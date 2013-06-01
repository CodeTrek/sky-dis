/**
 */
package com.sky.dis.om.rpr.impl;

import com.sky.dis.om.rpr.EntityId;
import com.sky.dis.om.rpr.RprPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sky.dis.om.rpr.impl.EntityIdImpl#getSite <em>Site</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.impl.EntityIdImpl#getHost <em>Host</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.impl.EntityIdImpl#getEntityId <em>Entity Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityIdImpl extends EObjectImpl implements EntityId {
    /**
     * The default value of the '{@link #getSite() <em>Site</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSite()
     * @generated
     * @ordered
     */
    protected static final short SITE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSite() <em>Site</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSite()
     * @generated
     * @ordered
     */
    protected short site = SITE_EDEFAULT;

    /**
     * The default value of the '{@link #getHost() <em>Host</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHost()
     * @generated
     * @ordered
     */
    protected static final short HOST_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getHost() <em>Host</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHost()
     * @generated
     * @ordered
     */
    protected short host = HOST_EDEFAULT;

    /**
     * The default value of the '{@link #getEntityId() <em>Entity Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntityId()
     * @generated
     * @ordered
     */
    protected static final short ENTITY_ID_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getEntityId() <em>Entity Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntityId()
     * @generated
     * @ordered
     */
    protected short entityId = ENTITY_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EntityIdImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RprPackage.Literals.ENTITY_ID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getSite() {
        return site;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSite(short newSite) {
        short oldSite = site;
        site = newSite;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.ENTITY_ID__SITE, oldSite, site));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getHost() {
        return host;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHost(short newHost) {
        short oldHost = host;
        host = newHost;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.ENTITY_ID__HOST, oldHost, host));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getEntityId() {
        return entityId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEntityId(short newEntityId) {
        short oldEntityId = entityId;
        entityId = newEntityId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.ENTITY_ID__ENTITY_ID, oldEntityId, entityId));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RprPackage.ENTITY_ID__SITE:
                return getSite();
            case RprPackage.ENTITY_ID__HOST:
                return getHost();
            case RprPackage.ENTITY_ID__ENTITY_ID:
                return getEntityId();
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
            case RprPackage.ENTITY_ID__SITE:
                setSite((Short)newValue);
                return;
            case RprPackage.ENTITY_ID__HOST:
                setHost((Short)newValue);
                return;
            case RprPackage.ENTITY_ID__ENTITY_ID:
                setEntityId((Short)newValue);
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
            case RprPackage.ENTITY_ID__SITE:
                setSite(SITE_EDEFAULT);
                return;
            case RprPackage.ENTITY_ID__HOST:
                setHost(HOST_EDEFAULT);
                return;
            case RprPackage.ENTITY_ID__ENTITY_ID:
                setEntityId(ENTITY_ID_EDEFAULT);
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
            case RprPackage.ENTITY_ID__SITE:
                return site != SITE_EDEFAULT;
            case RprPackage.ENTITY_ID__HOST:
                return host != HOST_EDEFAULT;
            case RprPackage.ENTITY_ID__ENTITY_ID:
                return entityId != ENTITY_ID_EDEFAULT;
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
        result.append(" (site: ");
        result.append(site);
        result.append(", host: ");
        result.append(host);
        result.append(", entityId: ");
        result.append(entityId);
        result.append(')');
        return result.toString();
    }

} //EntityIdImpl
