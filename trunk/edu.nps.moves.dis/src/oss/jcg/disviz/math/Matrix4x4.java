package oss.jcg.disviz.math;

import edu.nps.moves.math.Vec3f;
import edu.nps.moves.math.Vec4f;

/**
 * Matrix4x4.java Description:  P McKee 5/22/2010
 * 
 * Defines a 4x4 matrix where the 3x3 is the rotational portion of the
 * matrix, the 4th column is the scale multiplier and the 4th row is the
 * translation. All rotations abide by the Right-Hand rule
 * 
 * The ORDER OF ROTATION is Heading (h), Pitch (p) and Roll (r)
 * where: Heading is about the Y-axis
 *        Pitch   is about the Z-axis
 *        Roll    is about the X-axis
 * 
 * the local 4x4 matrix is identified as:
 * 
 *   | m00  m01  m02  m03 |
 *   | m10  m11  m12  m13 |
 *   | m20  m21  m22  m23 |
 *   | m30  m31  m32  m33 |
 *   
 *   where the rotational part is:
 *   | m00  m01  m02 |
 *   | m10  m11  m12 |
 *   | m20  m21  m22 |
 * 
 *   and the scaler part is:
 *   | m03 |
 *   | m13 |
 *   | m23 |
 * 
 *   and the translational part is:
 *   | m30  m31  m32 |
 * 
 */

public class Matrix4x4
{
  private float m[][];

  public Matrix4x4()
  {
    m = new float[4][4];
    makeNull();
  }

  public Matrix4x4(float mat[][])
  {
    m = new float[4][4];
    setMat(mat);
  }

  public Matrix4x4(Matrix4x4 mat)
  {
    m = new float[4][4];
    setMat(mat);
  }

  public Matrix4x4(Quaternion quat)
  {
    m = new float[4][4];
    setByQuat(quat);
    setTranslation(0.0f, 0.0f, 0.0f);
  }

  public Matrix4x4(float hpr[])
  {
    m = new float[4][4];
    setByEulers(hpr);
    setTranslation(0.0f, 0.0f, 0.0f);
  }

  public Matrix4x4(float heading, float pitch, float roll)
  {
    m = new float[4][4];
    setByEulers(heading, pitch, roll);
    setTranslation(0.0f, 0.0f, 0.0f);
  }

  public void print()
  {
    System.out.println("m = " + m[0][0] + ", " + m[0][1] + ", " + m[0][2]
        + ", " + m[0][3] + m[1][0] + ", " + m[1][1] + ", " + m[1][2] + ", "
        + m[1][3] + m[2][0] + ", " + m[2][1] + ", " + m[2][2] + ", " + m[2][3]
        + m[3][0] + ", " + m[3][1] + ", " + m[3][2] + ", " + m[3][3]);
  }

  public void setMatValue(int row, int col, float val)
  {
    if (row < 0 || row > 4 || col < 0 || col > 4)
      return;
    m[row][col] = val;
  }

  public float getMatValue(int row, int col)
  {
    if (row < 0 || row > 4 || col < 0 || col > 4)
      return 0.0f;
    return m[row][col];
  }

  public void setMat(float mat[][])
  {
    m[0][0] = mat[0][0];
    m[0][1] = mat[0][1];
    m[0][2] = mat[0][2];
    m[0][3] = mat[0][3];
    m[1][0] = mat[1][0];
    m[1][1] = mat[1][1];
    m[1][2] = mat[1][2];
    m[1][3] = mat[1][3];
    m[2][0] = mat[2][0];
    m[2][1] = mat[2][1];
    m[2][2] = mat[2][2];
    m[2][3] = mat[2][3];
    m[3][0] = mat[3][0];
    m[3][1] = mat[3][1];
    m[3][2] = mat[3][2];
    m[3][3] = mat[3][3];
  }

  public void getMat(float mat[][])
  {
    mat[0][0] = m[0][0];
    mat[0][1] = m[0][1];
    mat[0][2] = m[0][2];
    mat[0][3] = m[0][3];
    mat[1][0] = m[1][0];
    mat[1][1] = m[1][1];
    mat[1][2] = m[1][2];
    mat[1][3] = m[1][3];
    mat[2][0] = m[2][0];
    mat[2][1] = m[2][1];
    mat[2][2] = m[2][2];
    mat[2][3] = m[2][3];
    mat[3][0] = m[3][0];
    mat[3][1] = m[3][1];
    mat[3][2] = m[3][2];
    mat[3][3] = m[3][3];
  }

  public void setMat(Matrix4x4 mat)
  {
    float mat2[][] = new float[4][4];
    mat.getMat(mat2);
    setMat(mat2);
  }

  public void getMat(Matrix4x4 mat)
  {
    // PPM old way
    // float mat2[][] = new float[4][4];
    // getMat(mat2);
    // mat.setMat(mat2);

    // PPM new way... does it work the same as old way?
    mat.setMat(m);

  }

  public void setByQuat(Quaternion quat)
  {
    quat.getMat3(m);
  }

  public void getQuat(Quaternion quat)
  {
    quat.setMat3(m);
  }

  public void setTranslation(Vec3f translation)
  {
    float trans2[] = new float[3];
    translation.get(trans2);
    setTranslation(trans2[0], trans2[1], trans2[2]);
  }

  public void setTranslation(float translation[])
  {
    setTranslation(translation[0], translation[1], translation[2]);
  }

  public void setTranslation(float x, float y, float z)
  {
    m[3][0] = x;
    m[3][1] = y;
    m[3][2] = z;
  }

  public void getTranslation(Vec3f pos)
  {
    pos.set(m[3][0], m[3][1], m[3][2]);
  }

  public void getTranslation(float pos[])
  {
    pos[0] = m[3][0];
    pos[1] = m[3][1];
    pos[2] = m[3][2];
  }

  public void getTranslation(float x, float y, float z)
  {
    x = m[3][0];
    y = m[3][1];
    z = m[3][2];
  }

  public float ClampUnity(float x)
  {
    if (x > 1.0f)
      return 1.0f;
    if (x < -1.0f)
      return -1.0f;
    return x;
  }

  public boolean equivalent(double lhs, double rhs, double epsilon)
  {
    double delta = rhs - lhs;
    return delta < 0.0 ? delta >= -epsilon : delta <= epsilon;
  }

  public void getEulers(Vec3f hpr)
  {
    float euler[] = new float[3];
    
    getEulers(euler);

    hpr.set(euler);
  }

  public void getEulers(float hpr[])
  {
    // The order of rotation is h(Heading about Y-axis), p(Pitch about Z-axis)
    //     and r(Roll about X-axis)
    // output - angles are computed as radians.

    // Pitch is greater than 89.9 degrees?
    if (m[1][0] > 0.999998)
      hpr[1] = 1.569f;  // set the limit to 89.9 deg
    // Pitch is less than -89.9 degrees?
    else if (m[1][0] < -0.999998)
      hpr[1] = -1.569f;  // set the limit to -89.9 deg
    else
      hpr[1] = (float) Math.asin(m[1][0]);

    // FYI... atan2 checks for zero values.
    hpr[0] = (float) Math.atan2(-m[2][0], m[0][0]);
    hpr[2] = (float) Math.atan2(-m[1][2], m[1][1]);

  }

  public void setByEulers(Vec3f hpr)
  {
    setByEulers(hpr.get(0), hpr.get(1), hpr.get(2));
  }

  public void setByEulers(float hpr[])
  {
    setByEulers(hpr[0], hpr[1], hpr[2]);
  }

  public void setByEulers(float h, float p, float r) // Shoemake
  {
    // Only sets the 3x3 rotational portion of this 4x4 transformation matrix.
    // The translation and scaling values are unaffected. PPM
    // The order of rotation is h(Heading about Y-axis), p(Pitch about Z-axis)
    //     and r(Roll about X-axis)

    float ch, sh, cp, sp, cr, sr;

    ch = (float) Math.cos(h);
    sh = (float) Math.sin(h);
    cp = (float) Math.cos(p);
    sp = (float) Math.sin(p);
    cr = (float) Math.cos(r);
    sr = (float) Math.sin(r);

    m[0][0] = ch * cp;
    m[0][1] = -ch * sp * cr + sh * sr;
    m[0][2] = ch * sp * sr + sh * cr;

    m[1][0] = sp;
    m[1][1] = cp * cr;
    m[1][2] = -cp * sr;

    m[2][0] = -sh * cp;
    m[2][1] = sh * sp * cr + ch * sr;
    m[2][2] = -sh * sp * sr + ch * cr;

     m[3][3] = 1.0f;
  }

  public void makeNull()
  {
    m[0][0] = 0f;
    m[0][1] = 0f;
    m[0][2] = 0f;
    m[0][3] = 0f;
    m[1][0] = 0f;
    m[1][1] = 0f;
    m[1][2] = 0f;
    m[1][3] = 0f;
    m[2][0] = 0f;
    m[2][1] = 0f;
    m[2][2] = 0f;
    m[2][3] = 0f;
    m[3][0] = 0f;
    m[3][1] = 0f;
    m[3][2] = 0f;
    m[3][3] = 0f;
  }

  public void makeIdent()
  {
    m[0][0] = 1f;
    m[0][1] = 0f;
    m[0][2] = 0f;
    m[0][3] = 0f;
    m[1][0] = 0f;
    m[1][1] = 1f;
    m[1][2] = 0f;
    m[1][3] = 0f;
    m[2][0] = 0f;
    m[2][1] = 0f;
    m[2][2] = 1f;
    m[2][3] = 0f;
    m[3][0] = 0f;
    m[3][1] = 0f;
    m[3][2] = 0f;
    m[3][3] = 1f;
  }

  public void xform(Vec4f vec) // math_utils
  {
    float v[] = new float[4];

    vec.get(v);
    vec.set(0, v[0] * m[0][0] + v[1] * m[0][1] + v[2] * m[0][2] + v[3]
        * m[0][3]);
    vec.set(1, v[0] * m[1][0] + v[1] * m[1][1] + v[2] * m[1][2] + v[3]
        * m[1][3]);
    vec.set(2, v[0] * m[2][0] + v[1] * m[2][1] + v[2] * m[2][2] + v[3]
        * m[2][3]);
    vec.set(3, v[0] * m[3][0] + v[1] * m[3][1] + v[2] * m[3][2] + v[3]
        * m[3][3]);
  }

  public void xform(float v[]) // math_utils
  {
    float tmp_v[] = new float[4];

    tmp_v[0] = v[0] * m[0][0] + v[1] * m[0][1] + v[2] * m[0][2] + v[3]
        * m[0][3];
    tmp_v[1] = v[0] * m[1][0] + v[1] * m[1][1] + v[2] * m[1][2] + v[3]
        * m[1][3];
    tmp_v[2] = v[0] * m[2][0] + v[1] * m[2][1] + v[2] * m[2][2] + v[3]
        * m[2][3];
    tmp_v[2] = v[0] * m[3][0] + v[1] * m[3][1] + v[2] * m[3][2] + v[3]
        * m[3][3];
    v[0] = tmp_v[0];
    v[1] = tmp_v[1];
    v[2] = tmp_v[2];
    v[3] = tmp_v[3];
  }

}