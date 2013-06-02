/**
 */
package com.sky.dis.om.rpr.impl;

import com.sky.dis.om.rpr.Entity;
import com.sky.dis.om.rpr.EntityId;
import com.sky.dis.om.rpr.Orientation;
import com.sky.dis.om.rpr.RprPackage;
import com.sky.dis.om.rpr.WorldLocation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sky.dis.om.rpr.impl.EntityImpl#getEntityId <em>Entity Id</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.impl.EntityImpl#getWorldLocation <em>World Location</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.impl.EntityImpl#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link com.sky.dis.om.rpr.impl.EntityImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityImpl extends EObjectImpl implements Entity {
    /**
     * The cached value of the '{@link #getEntityId() <em>Entity Id</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntityId()
     * @generated
     * @ordered
     */
    protected EntityId entityId;

    /**
     * The cached value of the '{@link #getWorldLocation() <em>World Location</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWorldLocation()
     * @generated
     * @ordered
     */
    protected WorldLocation worldLocation;

    /**
     * The cached value of the '{@link #getOrientation() <em>Orientation</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrientation()
     * @generated
     * @ordered
     */
    protected Orientation orientation;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EntityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RprPackage.Literals.ENTITY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EntityId getEntityId() {
        return entityId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEntityId(EntityId newEntityId, NotificationChain msgs) {
        EntityId oldEntityId = entityId;
        entityId = newEntityId;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RprPackage.ENTITY__ENTITY_ID, oldEntityId, newEntityId);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEntityId(EntityId newEntityId) {
        if (newEntityId != entityId) {
            NotificationChain msgs = null;
            if (entityId != null)
                msgs = ((InternalEObject)entityId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RprPackage.ENTITY__ENTITY_ID, null, msgs);
            if (newEntityId != null)
                msgs = ((InternalEObject)newEntityId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RprPackage.ENTITY__ENTITY_ID, null, msgs);
            msgs = basicSetEntityId(newEntityId, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.ENTITY__ENTITY_ID, newEntityId, newEntityId));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WorldLocation getWorldLocation() {
        return worldLocation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetWorldLocation(WorldLocation newWorldLocation, NotificationChain msgs) {
        WorldLocation oldWorldLocation = worldLocation;
        worldLocation = newWorldLocation;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RprPackage.ENTITY__WORLD_LOCATION, oldWorldLocation, newWorldLocation);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWorldLocation(WorldLocation newWorldLocation) {
        if (newWorldLocation != worldLocation) {
            NotificationChain msgs = null;
            if (worldLocation != null)
                msgs = ((InternalEObject)worldLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RprPackage.ENTITY__WORLD_LOCATION, null, msgs);
            if (newWorldLocation != null)
                msgs = ((InternalEObject)newWorldLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RprPackage.ENTITY__WORLD_LOCATION, null, msgs);
            msgs = basicSetWorldLocation(newWorldLocation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.ENTITY__WORLD_LOCATION, newWorldLocation, newWorldLocation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOrientation(Orientation newOrientation, NotificationChain msgs) {
        Orientation oldOrientation = orientation;
        orientation = newOrientation;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RprPackage.ENTITY__ORIENTATION, oldOrientation, newOrientation);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOrientation(Orientation newOrientation) {
        if (newOrientation != orientation) {
            NotificationChain msgs = null;
            if (orientation != null)
                msgs = ((InternalEObject)orientation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RprPackage.ENTITY__ORIENTATION, null, msgs);
            if (newOrientation != null)
                msgs = ((InternalEObject)newOrientation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RprPackage.ENTITY__ORIENTATION, null, msgs);
            msgs = basicSetOrientation(newOrientation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RprPackage.ENTITY__ORIENTATION, newOrientation, newOrientation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String getName() {
       
        EntityId id = getEntityId();
        
        if (id == null) {
            return "unnamed";
        }
        
        String name = id.getSite() + "." + id.getHost() + "." + id.getEntityId();
        
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RprPackage.ENTITY__ENTITY_ID:
                return basicSetEntityId(null, msgs);
            case RprPackage.ENTITY__WORLD_LOCATION:
                return basicSetWorldLocation(null, msgs);
            case RprPackage.ENTITY__ORIENTATION:
                return basicSetOrientation(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RprPackage.ENTITY__ENTITY_ID:
                return getEntityId();
            case RprPackage.ENTITY__WORLD_LOCATION:
                return getWorldLocation();
            case RprPackage.ENTITY__ORIENTATION:
                return getOrientation();
            case RprPackage.ENTITY__NAME:
                return getName();
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
            case RprPackage.ENTITY__ENTITY_ID:
                setEntityId((EntityId)newValue);
                return;
            case RprPackage.ENTITY__WORLD_LOCATION:
                setWorldLocation((WorldLocation)newValue);
                return;
            case RprPackage.ENTITY__ORIENTATION:
                setOrientation((Orientation)newValue);
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
            case RprPackage.ENTITY__ENTITY_ID:
                setEntityId((EntityId)null);
                return;
            case RprPackage.ENTITY__WORLD_LOCATION:
                setWorldLocation((WorldLocation)null);
                return;
            case RprPackage.ENTITY__ORIENTATION:
                setOrientation((Orientation)null);
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
            case RprPackage.ENTITY__ENTITY_ID:
                return entityId != null;
            case RprPackage.ENTITY__WORLD_LOCATION:
                return worldLocation != null;
            case RprPackage.ENTITY__ORIENTATION:
                return orientation != null;
            case RprPackage.ENTITY__NAME:
                return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
        }
        return super.eIsSet(featureID);
    }

} //EntityImpl
