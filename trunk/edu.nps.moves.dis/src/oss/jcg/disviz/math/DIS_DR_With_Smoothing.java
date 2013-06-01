package oss.jcg.disviz.math;

import edu.nps.moves.math.Vec3f;

public class DIS_DR_With_Smoothing
{

  private int DR_NONE = 0;
  @SuppressWarnings("unused")
  private int DR_STATIC = 1;
  @SuppressWarnings("unused")
  private int DR_VELOCITY_ONLY = 2;
  private int DR_VELOCITY_AND_ACCELERATION = 5;

  // / The update mode - whether to actually move the player or to just
  // calculate.
  // eUpdateMode* mUpdateMode;

  private boolean positionInitiated = false;
  private boolean rotationInitiated = false;
  private boolean updated = false;
  private boolean positionUpdated = false;
  private  boolean rotationUpdated = false;
  @SuppressWarnings("unused")
  private boolean flying = false;
  // if the rotation has been resolved to the last updated version.
  private  boolean rotationResolved = true;

  // /the simulation time this was last updated.
  private float lastKnownPosUpdatedTime;
  private float lastRotationUpdatedTime;

  // /This should be fairly clear.
  private float averageTimeBetweenPosUpdates;
  private float averageTimeBetweenRotationUpdates;

  // /The maximum amount of time to use when smoothing Pos.
  private float maxPosSmoothingTime;
  // /The maximum amount of time to use when smoothing rotation.
  private float maxRotationSmoothingTime;

  // /the amount of time since this player started smoothing.
  private float posElapsedTimeSinceUpdate;
  private float rotationElapsedTimeSinceUpdate;

  // /the end amount of time to use when smoothing the Pos. At this point, the
  // blend should be finished.
  private float posEndSmoothingTime;
  // /the end amount of time to use when smoothing the rotation. At this point,
  // the blend should be finished.
  private float rotationEndSmoothingTime;

  // /Last known position of this player.
  private Vec3f lastKnownPos = new Vec3f();

  // /The Dead-Reckoned position prior to the last update.
  private Vec3f posBeforeLastUpdate = new Vec3f();
  // Current Dead Reckoned Position
  private Vec3f currentDeadReckonedPos = new Vec3f();

  // /last known orientation (vector)
  private Vec3f lastRotation = new Vec3f();
  // /last known orientation (matrix)
  private Matrix4x4 lastRotationMatrix = new Matrix4x4();
  // /last known orientation (quaternion)
  private Quaternion lastQuatRotation = new Quaternion();
  // /dead reckoned attitude quaternion prior update
  private Quaternion rotQuatBeforeLastUpdate = new Quaternion();
  // /current dead reckoned attitude quaternion
  private Quaternion currentDeadReckonedRotation = new Quaternion();
  private Vec3f currentDrRotation = new Vec3f();

  // / The velocity vector.
  private Vec3f lastVelocity = new Vec3f();
  private Vec3f velocityBeforeLastUpdate = new Vec3f(); // / The velocity we were using just before
                                   // we got an update

  // / The acceleration vector.
  private Vec3f accelVector = new Vec3f();

  // /The angular velocity vector.
  private Vec3f angularVelocityVector = new Vec3f();

  // The Dead Reckoning Matrix
  @SuppressWarnings("unused")
  private Matrix4x4 deadReckoningMatrix = new Matrix4x4();

  private int minDRAlgorithm;
  @SuppressWarnings("unused")
  private int groundClampingType;

  public boolean IsUpdated()
  {
    return updated;
  }

  public void ClearUpdated()
  {
    updated = false;
    positionUpdated = false;
    rotationUpdated = false;
  }

  public boolean IsPosUpdated()
  {
    return positionUpdated;
  }

  public boolean IsRotationUpdated()
  {
    return rotationUpdated;
  }

  public DIS_DR_With_Smoothing()
  {

    maxPosSmoothingTime = 8.0f;
    maxRotationSmoothingTime = 2.0f;
    posEndSmoothingTime = 0.f;
    rotationEndSmoothingTime = 0.f;
    averageTimeBetweenPosUpdates = 0.f;
    averageTimeBetweenRotationUpdates = 0.f;
    lastKnownPosUpdatedTime = 0.f;
    lastRotationUpdatedTime = 0.f;
    posElapsedTimeSinceUpdate = 0.f;
    rotationElapsedTimeSinceUpdate = 0.f;

    minDRAlgorithm = DR_NONE;
    
  }// DIS_DR_With_Smoothing

  // ////////////////////////////////////////////////////////////////////
  public void SetDeadReckoningAlgorithm(int newAlgorithm)
  {
    if (minDRAlgorithm == newAlgorithm)
      return;
    minDRAlgorithm = newAlgorithm;
    updated = true;
  }

  // ////////////////////////////////////////////////////////////////////
  public void SetLastPosUpdatedTime(float newUpdatedTime)
  {
    // the average of the last average and the current time since an update.
    averageTimeBetweenPosUpdates = 0.5f
        * ((newUpdatedTime - lastKnownPosUpdatedTime)
        + averageTimeBetweenPosUpdates);
    lastKnownPosUpdatedTime = newUpdatedTime;
  }

  // ////////////////////////////////////////////////////////////////////
  public void SetLastRotationUpdatedTime(float newUpdatedTime)
  {
    // the average of the last average and the current time since an update.
    averageTimeBetweenRotationUpdates = 0.5f
        * ((newUpdatedTime - lastRotationUpdatedTime)
        + averageTimeBetweenRotationUpdates);
    lastRotationUpdatedTime = newUpdatedTime;
  }

  public void SetPosElapsedTimeSinceUpdate(float value)
  {
    posElapsedTimeSinceUpdate = value;
  }

  public float GetPosElapsedTimeSinceUpdate()
  {
    return posElapsedTimeSinceUpdate;
  }

  public void SetRotationElapsedTimeSinceUpdate(float value)
  {
    rotationElapsedTimeSinceUpdate = value;
  }

  public float GetRotationElapsedTimeSinceUpdate()
  {
    return rotationElapsedTimeSinceUpdate;
  }

  public void SetRotationResolved(boolean resolved)
  {
    rotationResolved = resolved;
  }

  // ////////////////////////////////////////////////////////////////////
  public void SetLastKnownPos(Vec3f pos)
  {
    // If multiple updates are received before the DR component
    // is able to process them, i.e. in the same frame, it can result in a
    // jitter/warp
    // this if fixes the jitter.
    if (!positionUpdated)
    {
      if (positionInitiated)
      {
        posBeforeLastUpdate.set(currentDeadReckonedPos);
      }
      else
      {
        posBeforeLastUpdate.set(pos);
      }
    }

    positionInitiated = true;
    lastKnownPos.set(pos);
    posElapsedTimeSinceUpdate = 0.0f;
    positionUpdated = true;
    updated = true;
  }

  // ////////////////////////////////////////////////////////////////////
  public void SetLastKnownRotation(Vec3f hpr)
  {
    Matrix4x4 xform = new Matrix4x4();
    xform.setByEulers(hpr.get(0), hpr.get(1), hpr.get(2));
    xform.getMat(lastRotationMatrix);
    // If multiple updates are received before the DR component
    // is able to process them, i.e. in the same frame, it can result in a
    // jitter/warp
    // this if fixes the jitter.
    if (!rotationUpdated)
    {
      if (rotationInitiated)
      {
        rotQuatBeforeLastUpdate.setQuat(currentDeadReckonedRotation);
      }
      else
      {
        lastRotationMatrix.getQuat(rotQuatBeforeLastUpdate);
      }
    }
    lastRotation.set(hpr);
    lastRotationMatrix.getQuat(lastQuatRotation);
    rotationElapsedTimeSinceUpdate = 0.0f;
    rotationInitiated = true;
    rotationUpdated = true;
    updated = true;
  }

  // ////////////////////////////////////////////////////////////////////
  public void SetLastKnownVelocity(Vec3f vel)
  {
    // This technically suffers from the same jitter problem as the rotation and
    // Pos, but
    // because the velocity takes time to change anyway, and because if updates
    // are coming in frequently
    // velocity blending won't do much, there is no need to fix it.
    velocityBeforeLastUpdate.set(lastVelocity);
    lastVelocity.set(vel);
    posElapsedTimeSinceUpdate = 0.0f;
    // If velocity is updated, the effect is the same as if the trans was
    // updated
    positionUpdated = true;
    updated = true;
  }

  // ////////////////////////////////////////////////////////////////////
  public void SetLastKnownAcceleration(Vec3f acc)
  {
    accelVector.set(acc);
    updated = true;
  }

  // ////////////////////////////////////////////////////////////////////
  public void SetLastKnownAngularVelocity(Vec3f wvel)
  {
    angularVelocityVector.set(wvel);
    updated = true;
  }

  public Vec3f GetCurrentDeadReckonedPos()
  {
    Vec3f pos = new Vec3f();
    pos.set(currentDeadReckonedPos);
    return pos;
  }

  public Vec3f GetCurrentDeadReckonedRotation()
  {
    Vec3f rot = new Vec3f();
    rot.set(currentDrRotation);
    return rot;
  }

  public void SetCurrentDeadReckonedPos(Vec3f pos)
  {
    currentDeadReckonedPos.set(pos);
  }

  public void SetCurrentDeadReckonedRotation(Vec3f hpr)
  {
    currentDrRotation.set(hpr);
  }

  // ///////////////////////////////////////////////////////////////////////////////
  public boolean DoDR(Matrix4x4 playerXform)
  {
    boolean returnValue = false; // indicates we changed the transform
    // if (IsFlying())
    // groundClampingType = GC_NONE;
    // //else if (GetGroundClampingData().GetAdjustRotationToGround())
    // // groundClampingType = GC_RANGED;
    // //else
    // // groundClampingType = GC_INTERMITTENT_SAVE_OFFSET;
    //
    // if (GetDeadReckoningAlgorithm() == DR_STATIC)
    // {
    // if (IsUpdated())
    // {
    // DRStatic(playerXform);
    // returnValue = true;
    // }
    // }
    // else if (GetDeadReckoningAlgorithm() != DR_NONE)
    {
      returnValue = DRVelocityAcceleration(playerXform);
    }

    return returnValue;
  }

  // ////////////////////////////////////////////////////////////////////
  public void DRStatic(Matrix4x4 xform)
  {

    xform.setMat(lastRotationMatrix);
    xform.setTranslation(lastKnownPos);

    posBeforeLastUpdate.set(lastKnownPos);
    rotQuatBeforeLastUpdate.setQuat(lastQuatRotation);

    rotationResolved = true;

    currentDeadReckonedPos.set(lastKnownPos);
    xform.getEulers(currentDrRotation);
    lastRotationMatrix.getQuat(currentDeadReckonedRotation);
  }

  // ////////////////////////////////////////////////////////////////////
  public boolean DRVelocityAcceleration(Matrix4x4 xform)
  {
    boolean returnValue = false; // indicates that we made a change to the
                                 // transform
    Vec3f pos = new Vec3f();
    xform.getTranslation(pos);
    // osg::Matrix rot;
    // xform.GetRotation(rot);

    Vec3f unclampedPos = new Vec3f();
    unclampedPos.set(pos);

    // removed because the transform is now initialized to the
    // the current DR'd position.
    // if (!flying)
    // unclampedPos.z() = lastKnownPos.z();

    // avoid the sqrtf by using length2.
    // we went to see if all this dr and ground clamping stuff has to be done.
    if (IsUpdated()
        || lastKnownPos != unclampedPos
        || !rotationResolved
        || lastVelocity.length() > 1e-2f
        || (minDRAlgorithm == DR_VELOCITY_AND_ACCELERATION && accelVector
            .length() > 1e-2f)
        || (minDRAlgorithm == DR_VELOCITY_AND_ACCELERATION && angularVelocityVector
            .length() > 1e-5f))
    {
      // if we got an update, then we need to recalculate our smoothing
      if (IsUpdated())
      {
        CalculateSmoothingTimes(pos);
      }

      // RESOLVE ROTATION
      DeadReckonTheRotation(xform);

      // POSITION SMOOTHING
      DeadReckonThePosition(pos);
      xform.setTranslation(pos);

      returnValue = true;
    }

    return returnValue;
  }

  // ////////////////////////////////////////////////////////////////////
  public void CalculateSmoothingTimes(Vec3f Pos)
  {
    // ROTATION
    if (maxRotationSmoothingTime < averageTimeBetweenRotationUpdates)
      rotationEndSmoothingTime = maxRotationSmoothingTime;
    else
      rotationEndSmoothingTime = averageTimeBetweenRotationUpdates;

    Quaternion quatDiff = new Quaternion();
    quatDiff.sub(lastQuatRotation, currentDeadReckonedRotation);

    // For angular acceleration, do a similar compare
    if (minDRAlgorithm == DR_VELOCITY_AND_ACCELERATION
        && (angularVelocityVector.length() * (rotationEndSmoothingTime * rotationEndSmoothingTime)) < 0.1 * (quatDiff
            .length()))
    {
       rotationEndSmoothingTime = Math.min(1.0f, averageTimeBetweenRotationUpdates);
    }

    // Pos
    if (maxPosSmoothingTime < averageTimeBetweenPosUpdates)
      posEndSmoothingTime = maxPosSmoothingTime;
    else
      posEndSmoothingTime = averageTimeBetweenPosUpdates;

    Vec3f posDiff = new Vec3f();
    posDiff.sub(lastKnownPos, Pos);

    // Order of magnitude check - if the entity could not possibly get to the
    // new position
    // in max smoothing time based on the magnitude of it's velocity, then
    // smooth quicker (ie 1 second).
    if (lastVelocity.length() * (posEndSmoothingTime * posEndSmoothingTime) < posDiff
        .length())
      posEndSmoothingTime = Math.min(1.0f, posEndSmoothingTime);
  }

  // ////////////////////////////////////////////////////////////////////
  public void DeadReckonTheRotation(Matrix4x4 xform)
  {
    Quaternion newRot = new Quaternion();
    Quaternion drQuat = new Quaternion();
    drQuat.setQuat(lastQuatRotation); // velocity only just uses the last.
    boolean isRotationChangedByAccel = false;
    Quaternion startRotation = new Quaternion();
    startRotation.setQuat(rotQuatBeforeLastUpdate);

    if (!rotationResolved) // rotationResolved is never set when using Accel
    {

      // For vel and Accel, we use the angular velocity to compute a dead
      // reckoning matrix to slerp to
      // assuming that we have an angular velocity at all...
      if (minDRAlgorithm == DR_VELOCITY_AND_ACCELERATION
          && angularVelocityVector.length() < 1e-6)
      {
        // if we're here, we had some sort of change, however small
        isRotationChangedByAccel = true;

        // Compute The change in the rotation based Dead Reckoning matrix
        // The Dead Reckoning Matrix
        Matrix4x4 angularRotation = new Matrix4x4();
        ComputeRotationChangeWithAngularVelocity(
            rotationElapsedTimeSinceUpdate, angularRotation);

        // Expected DR'ed rotation - Take the last rot and add the change over
        // time
        Quaternion angularRotAsQuat = new Quaternion();
        angularRotation.getQuat(angularRotAsQuat);
        drQuat.mult(angularRotAsQuat, lastQuatRotation); // The current DR'ed
                                                          // rotation

        // Previous DR'ed rotation - same, but uses where we were before the
        // last update, so we can smooth it out...
        startRotation.mult(angularRotAsQuat, rotQuatBeforeLastUpdate); // The
                                                                        // current
                                                                        // DR'ed
                                                                        // rotation

        // New hpr computation
        // Matrix4f drRot = angularRotation * lastRotationMatrix;
        // ////dtUtil::MatrixUtil::Print(mComputedAngularRotationMatrix);
        // Compute change in rotation as quaternion representation
        // drRot.get(drQuat);
        // Quaternion rotationChange = drQuat - lastQuatRotation;
        // isRotationChangedByAccel = rotationChange.length2() > 1e-6;
        // Matrix4f drStartRot = angularRotation * lastRotationMatrix;
        // startRotation = rotQuatBeforeLastUpdate + rotationChange;
      }

      // If there is a difference in the rotations and we still have time to
      // smooth, then
      // slerp between the two quats: 1) the old rotation plus the expected
      // change using angular
      // velocity and 2) the desired new rotation
      if ((rotationEndSmoothingTime > 0.0f)
          && (rotationElapsedTimeSinceUpdate < rotationEndSmoothingTime))
      {
        float smoothingFactor = rotationElapsedTimeSinceUpdate
            / rotationEndSmoothingTime;
        // PPM dtUtil::Clamp(smoothingFactor, 0.0f, 1.0f);
        newRot.slerp(startRotation, drQuat, smoothingFactor, 0); // ?? make sure
                                                                 // this works.
                                                                 // PPM
      }
      else
      // Either smoothing time is done or the current rotation equals the
      // desired rotation
      {
        newRot.setQuat(drQuat);
        rotationResolved = !isRotationChangedByAccel; // true;
      }

      // we finished DR, so update the rotation values on the helper and
      // transform
      xform.setByQuat(newRot);
      currentDeadReckonedRotation.setQuat(newRot);

      xform.getEulers(currentDrRotation);

      // std::cout << " DeadReckonTheRotation current rot "
      // << osg::RadiansToDegrees(currentDrRotation[0]) << "  "
      // << osg::RadiansToDegrees(currentDrRotation[1]) << "  "
      // << osg::RadiansToDegrees(currentDrRotation[2]) << std::endl;

    }
  }

  // ////////////////////////////////////////////////////////////////////
  public void ComputeRotationChangeWithAngularVelocity(double deltaTime,
      Matrix4x4 result)
  {
    // mComputedAngularRotationMatrix
    if (angularVelocityVector.length() < 1e-6)
    {
      result.makeIdent();
    }
    else
    {

      double w = angularVelocityVector.length();
      float ww[] = new float[3];
      angularVelocityVector.get(ww);

      double omega00 = 0;
      double omega01 = -ww[2];
      double omega02 = ww[1];
      double omega03 = 0;

      double omega10 = ww[2];
      double omega11 = 0;
      double omega12 = -ww[0];
      double omega13 = 0;

      double omega20 = -ww[1];
      double omega21 = ww[0];
      double omega22 = 0;
      double omega23 = 0;

      double ww00 = ww[0] * ww[0];
      double ww01 = ww[0] * ww[1];
      double ww02 = ww[0] * ww[2];
      double ww03 = 0;

      double ww10 = ww[1] * ww[0];
      double ww11 = ww[1] * ww[1];
      double ww12 = ww[1] * ww[2];
      double ww13 = 0;

      double ww20 = ww[2] * ww[0];
      double ww21 = ww[2] * ww[1];
      double ww22 = ww[2] * ww[2];
      double ww23 = 0;

      double c1 = (1 - Math.cos(w * deltaTime)) / (w * w);
      double c2 = Math.cos(w * deltaTime);
      double c3 = -Math.sin(w * deltaTime) / w;

      float newMat[][] = new float[4][4];
      newMat[0][0] = (float) (c1 * ww00 + c2 * 1 + c3 * omega00);
      newMat[0][1] = (float) (c1 * ww01 + c2 * 0 + c3 * omega01);
      newMat[0][2] = (float) (c1 * ww02 + c2 * 0 + c3 * omega02);
      newMat[0][3] = (float) (c1 * ww03 + c2 * 0 + c3 * omega03);
      newMat[1][0] = (float) (c1 * ww10 + c2 * 0 + c3 * omega10);
      newMat[1][1] = (float) (c1 * ww11 + c2 * 1 + c3 * omega11);
      newMat[1][2] = (float) (c1 * ww12 + c2 * 0 + c3 * omega12);
      newMat[1][3] = (float) (c1 * ww13 + c2 * 0 + c3 * omega13);
      newMat[2][0] = (float) (c1 * ww20 + c2 * 0 + c3 * omega20);
      newMat[2][1] = (float) (c1 * ww21 + c2 * 0 + c3 * omega21);
      newMat[2][2] = (float) (c1 * ww22 + c2 * 1 + c3 * omega22);
      newMat[2][3] = (float) (c1 * ww23 + c2 * 0 + c3 * omega23);
      newMat[3][0] = 0f;
      newMat[3][1] = 0f;
      newMat[3][2] = 0f;
      newMat[3][3] = 1f;

      result.setMat(newMat);
    }
  }

  // ////////////////////////////////////////////////////////////////////
  public void DeadReckonThePosition(Vec3f pos)
  {

    Vec3f accelerationEffect = new Vec3f();
    accelerationEffect.set(0.0f, 0.0f, 0.0f);

    if (minDRAlgorithm == DR_VELOCITY_AND_ACCELERATION)
    {
      accelerationEffect.set(accelVector);
      accelerationEffect.scale(0.5f * posElapsedTimeSinceUpdate
          * posElapsedTimeSinceUpdate);
    }

    // COMPUTE BLENDED VELOCITY - this smooths out some of the harsh blends. We
    // do
    // it in a fraction of the time of the Pos else we get big overblown curves.
    Vec3f blendedVelocity = new Vec3f();
    blendedVelocity.set(lastVelocity);
    
    float velBlendTime = posEndSmoothingTime / 3.0f;
    if ((velBlendTime > 0.0f) && (posElapsedTimeSinceUpdate < velBlendTime))
    {
      float smoothingFactor = posElapsedTimeSinceUpdate / velBlendTime;
      blendedVelocity.set(velocityBeforeLastUpdate);
      blendedVelocity.scale(1.0F - smoothingFactor);
      Vec3f tempVel = new Vec3f();
      tempVel.set(lastVelocity);
      tempVel.scale(smoothingFactor);
      blendedVelocity.add(tempVel);
    }
    else
      blendedVelocity.set(lastVelocity);

    // True - meaning as if we just used the best known position & velocity.
    Vec3f truePositionChange = new Vec3f();
    // Blended - meaning using the last velocity & actual drawn position.
    Vec3f blendedPositionChange = new Vec3f();

    // COMPUTE CHANGE IN POSITION
    truePositionChange.set(lastVelocity);
    truePositionChange.scale(posElapsedTimeSinceUpdate);
    truePositionChange.add(accelerationEffect);
    blendedPositionChange.set(blendedVelocity);
    blendedPositionChange.scale(posElapsedTimeSinceUpdate);
    blendedPositionChange.add(accelerationEffect);

    Vec3f drPos = new Vec3f();
    drPos.add(lastKnownPos, truePositionChange);

    // If we still have time left in our smoothing, then
    // blend the positions.
    if ((posEndSmoothingTime > 0.0f)
        && (posElapsedTimeSinceUpdate < posEndSmoothingTime))
    {
      pos.add(posBeforeLastUpdate, blendedPositionChange);
      float smoothingFactor = posElapsedTimeSinceUpdate / posEndSmoothingTime;
      // a bit of smoothing.
      drPos.sub(pos);
      drPos.scale(smoothingFactor);
      pos.add(drPos);
    }
    else
    // Out of time or no move, so just set it.
    {
      pos.set(drPos);
    }

    currentDeadReckonedPos.set(pos);
  }

}// DIS_DR_Smoothing