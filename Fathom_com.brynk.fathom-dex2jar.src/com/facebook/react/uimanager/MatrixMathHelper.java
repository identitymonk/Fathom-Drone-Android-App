package com.facebook.react.uimanager;

import com.facebook.infer.annotation.Assertions;
import java.lang.reflect.Array;

public class MatrixMathHelper
{
  private static final double EPSILON = 1.E-005D;

  public static void applyPerspective(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[11] = (-1.0D / paramDouble);
  }

  public static void applyRotateX(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[5] = Math.cos(paramDouble);
    paramArrayOfDouble[6] = Math.sin(paramDouble);
    paramArrayOfDouble[9] = (-Math.sin(paramDouble));
    paramArrayOfDouble[10] = Math.cos(paramDouble);
  }

  public static void applyRotateY(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[0] = Math.cos(paramDouble);
    paramArrayOfDouble[2] = (-Math.sin(paramDouble));
    paramArrayOfDouble[8] = Math.sin(paramDouble);
    paramArrayOfDouble[10] = Math.cos(paramDouble);
  }

  public static void applyRotateZ(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[0] = Math.cos(paramDouble);
    paramArrayOfDouble[1] = Math.sin(paramDouble);
    paramArrayOfDouble[4] = (-Math.sin(paramDouble));
    paramArrayOfDouble[5] = Math.cos(paramDouble);
  }

  public static void applyScaleX(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[0] = paramDouble;
  }

  public static void applyScaleY(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[5] = paramDouble;
  }

  public static void applyScaleZ(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[10] = paramDouble;
  }

  public static void applySkewX(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[4] = Math.tan(paramDouble);
  }

  public static void applySkewY(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[1] = Math.tan(paramDouble);
  }

  public static void applyTranslate2D(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2)
  {
    paramArrayOfDouble[12] = paramDouble1;
    paramArrayOfDouble[13] = paramDouble2;
  }

  public static void applyTranslate3D(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    paramArrayOfDouble[12] = paramDouble1;
    paramArrayOfDouble[13] = paramDouble2;
    paramArrayOfDouble[14] = paramDouble3;
  }

  public static double[] createIdentityMatrix()
  {
    double[] arrayOfDouble = new double[16];
    resetIdentityMatrix(arrayOfDouble);
    return arrayOfDouble;
  }

  public static void decomposeMatrix(double[] paramArrayOfDouble, MatrixDecompositionContext paramMatrixDecompositionContext)
  {
    boolean bool;
    double[] arrayOfDouble2;
    double[] arrayOfDouble1;
    double[] arrayOfDouble3;
    if (paramArrayOfDouble.length == 16)
    {
      bool = true;
      Assertions.assertCondition(bool);
      arrayOfDouble2 = paramMatrixDecompositionContext.perspective;
      arrayOfDouble1 = paramMatrixDecompositionContext.scale;
      localObject = paramMatrixDecompositionContext.skew;
      arrayOfDouble3 = paramMatrixDecompositionContext.translation;
      paramMatrixDecompositionContext = paramMatrixDecompositionContext.rotationDegrees;
      if (!isZero(paramArrayOfDouble[15]))
        break label61;
    }
    label61: double[][] arrayOfDouble;
    double[] arrayOfDouble4;
    double d1;
    do
    {
      return;
      bool = false;
      break;
      arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
      arrayOfDouble4 = new double[16];
      i = 0;
      while (i < 4)
      {
        int j = 0;
        while (j < 4)
        {
          d1 = paramArrayOfDouble[(i * 4 + j)] / paramArrayOfDouble[15];
          arrayOfDouble[i][j] = d1;
          if (j == 3)
            d1 = 0.0D;
          arrayOfDouble4[(i * 4 + j)] = d1;
          j += 1;
        }
        i += 1;
      }
      arrayOfDouble4[15] = 1.0D;
    }
    while (isZero(determinant(arrayOfDouble4)));
    if ((!isZero(arrayOfDouble[0][3])) || (!isZero(arrayOfDouble[1][3])) || (!isZero(arrayOfDouble[2][3])))
    {
      d1 = arrayOfDouble[0][3];
      double d2 = arrayOfDouble[1][3];
      double d3 = arrayOfDouble[2][3];
      double d4 = arrayOfDouble[3][3];
      paramArrayOfDouble = transpose(inverse(arrayOfDouble4));
      multiplyVectorByMatrix(new double[] { d1, d2, d3, d4 }, paramArrayOfDouble, arrayOfDouble2);
    }
    while (true)
    {
      i = 0;
      while (i < 3)
      {
        arrayOfDouble3[i] = arrayOfDouble[3][i];
        i += 1;
      }
      arrayOfDouble2[2] = 0.0D;
      arrayOfDouble2[1] = 0.0D;
      arrayOfDouble2[0] = 0.0D;
      arrayOfDouble2[3] = 1.0D;
    }
    paramArrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { 3, 3 });
    int i = 0;
    while (i < 3)
    {
      paramArrayOfDouble[i][0] = arrayOfDouble[i][0];
      paramArrayOfDouble[i][1] = arrayOfDouble[i][1];
      paramArrayOfDouble[i][2] = arrayOfDouble[i][2];
      i += 1;
    }
    arrayOfDouble1[0] = v3Length(paramArrayOfDouble[0]);
    paramArrayOfDouble[0] = v3Normalize(paramArrayOfDouble[0], arrayOfDouble1[0]);
    localObject[0] = v3Dot(paramArrayOfDouble[0], paramArrayOfDouble[1]);
    paramArrayOfDouble[1] = v3Combine(paramArrayOfDouble[1], paramArrayOfDouble[0], 1.0D, -localObject[0]);
    localObject[0] = v3Dot(paramArrayOfDouble[0], paramArrayOfDouble[1]);
    paramArrayOfDouble[1] = v3Combine(paramArrayOfDouble[1], paramArrayOfDouble[0], 1.0D, -localObject[0]);
    arrayOfDouble1[1] = v3Length(paramArrayOfDouble[1]);
    paramArrayOfDouble[1] = v3Normalize(paramArrayOfDouble[1], arrayOfDouble1[1]);
    localObject[0] /= arrayOfDouble1[1];
    localObject[1] = v3Dot(paramArrayOfDouble[0], paramArrayOfDouble[2]);
    paramArrayOfDouble[2] = v3Combine(paramArrayOfDouble[2], paramArrayOfDouble[0], 1.0D, -localObject[1]);
    localObject[2] = v3Dot(paramArrayOfDouble[1], paramArrayOfDouble[2]);
    paramArrayOfDouble[2] = v3Combine(paramArrayOfDouble[2], paramArrayOfDouble[1], 1.0D, -localObject[2]);
    arrayOfDouble1[2] = v3Length(paramArrayOfDouble[2]);
    paramArrayOfDouble[2] = v3Normalize(paramArrayOfDouble[2], arrayOfDouble1[2]);
    localObject[1] /= arrayOfDouble1[2];
    localObject[2] /= arrayOfDouble1[2];
    Object localObject = v3Cross(paramArrayOfDouble[1], paramArrayOfDouble[2]);
    if (v3Dot(paramArrayOfDouble[0], localObject) < 0.0D)
    {
      i = 0;
      while (i < 3)
      {
        arrayOfDouble1[i] *= -1.0D;
        localObject = paramArrayOfDouble[i];
        localObject[0] *= -1.0D;
        localObject = paramArrayOfDouble[i];
        localObject[1] *= -1.0D;
        localObject = paramArrayOfDouble[i];
        localObject[2] *= -1.0D;
        i += 1;
      }
    }
    paramMatrixDecompositionContext[0] = roundTo3Places(-Math.atan2(paramArrayOfDouble[2][1], paramArrayOfDouble[2][2]) * 57.295779513082323D);
    paramMatrixDecompositionContext[1] = roundTo3Places(-Math.atan2(-paramArrayOfDouble[2][0], Math.sqrt(paramArrayOfDouble[2][1] * paramArrayOfDouble[2][1] + paramArrayOfDouble[2][2] * paramArrayOfDouble[2][2])) * 57.295779513082323D);
    paramMatrixDecompositionContext[2] = roundTo3Places(-Math.atan2(paramArrayOfDouble[1][0], paramArrayOfDouble[0][0]) * 57.295779513082323D);
  }

  public static double degreesToRadians(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }

  public static double determinant(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[0];
    double d2 = paramArrayOfDouble[1];
    double d3 = paramArrayOfDouble[2];
    double d4 = paramArrayOfDouble[3];
    double d5 = paramArrayOfDouble[4];
    double d6 = paramArrayOfDouble[5];
    double d7 = paramArrayOfDouble[6];
    double d8 = paramArrayOfDouble[7];
    double d9 = paramArrayOfDouble[8];
    double d10 = paramArrayOfDouble[9];
    double d11 = paramArrayOfDouble[10];
    double d12 = paramArrayOfDouble[11];
    double d13 = paramArrayOfDouble[12];
    double d14 = paramArrayOfDouble[13];
    double d15 = paramArrayOfDouble[14];
    double d16 = paramArrayOfDouble[15];
    return d4 * d7 * d10 * d13 - d3 * d8 * d10 * d13 - d4 * d6 * d11 * d13 + d2 * d8 * d11 * d13 + d3 * d6 * d12 * d13 - d2 * d7 * d12 * d13 - d4 * d7 * d9 * d14 + d3 * d8 * d9 * d14 + d4 * d5 * d11 * d14 - d1 * d8 * d11 * d14 - d3 * d5 * d12 * d14 + d1 * d7 * d12 * d14 + d4 * d6 * d9 * d15 - d2 * d8 * d9 * d15 - d4 * d5 * d10 * d15 + d1 * d8 * d10 * d15 + d2 * d5 * d12 * d15 - d1 * d6 * d12 * d15 - d3 * d6 * d9 * d16 + d2 * d7 * d9 * d16 + d3 * d5 * d10 * d16 - d1 * d7 * d10 * d16 - d2 * d5 * d11 * d16 + d1 * d6 * d11 * d16;
  }

  public static double[] inverse(double[] paramArrayOfDouble)
  {
    double d1 = determinant(paramArrayOfDouble);
    if (isZero(d1))
      return paramArrayOfDouble;
    double d2 = paramArrayOfDouble[0];
    double d3 = paramArrayOfDouble[1];
    double d4 = paramArrayOfDouble[2];
    double d5 = paramArrayOfDouble[3];
    double d6 = paramArrayOfDouble[4];
    double d7 = paramArrayOfDouble[5];
    double d8 = paramArrayOfDouble[6];
    double d9 = paramArrayOfDouble[7];
    double d10 = paramArrayOfDouble[8];
    double d11 = paramArrayOfDouble[9];
    double d12 = paramArrayOfDouble[10];
    double d13 = paramArrayOfDouble[11];
    double d14 = paramArrayOfDouble[12];
    double d15 = paramArrayOfDouble[13];
    double d16 = paramArrayOfDouble[14];
    double d17 = paramArrayOfDouble[15];
    return new double[] { (d8 * d13 * d15 - d9 * d12 * d15 + d9 * d11 * d16 - d7 * d13 * d16 - d8 * d11 * d17 + d7 * d12 * d17) / d1, (d5 * d12 * d15 - d4 * d13 * d15 - d5 * d11 * d16 + d3 * d13 * d16 + d4 * d11 * d17 - d3 * d12 * d17) / d1, (d4 * d9 * d15 - d5 * d8 * d15 + d5 * d7 * d16 - d3 * d9 * d16 - d4 * d7 * d17 + d3 * d8 * d17) / d1, (d5 * d8 * d11 - d4 * d9 * d11 - d5 * d7 * d12 + d3 * d9 * d12 + d4 * d7 * d13 - d3 * d8 * d13) / d1, (d9 * d12 * d14 - d8 * d13 * d14 - d9 * d10 * d16 + d6 * d13 * d16 + d8 * d10 * d17 - d6 * d12 * d17) / d1, (d4 * d13 * d14 - d5 * d12 * d14 + d5 * d10 * d16 - d2 * d13 * d16 - d4 * d10 * d17 + d2 * d12 * d17) / d1, (d5 * d8 * d14 - d4 * d9 * d14 - d5 * d6 * d16 + d2 * d9 * d16 + d4 * d6 * d17 - d2 * d8 * d17) / d1, (d4 * d9 * d10 - d5 * d8 * d10 + d5 * d6 * d12 - d2 * d9 * d12 - d4 * d6 * d13 + d2 * d8 * d13) / d1, (d7 * d13 * d14 - d9 * d11 * d14 + d9 * d10 * d15 - d6 * d13 * d15 - d7 * d10 * d17 + d6 * d11 * d17) / d1, (d5 * d11 * d14 - d3 * d13 * d14 - d5 * d10 * d15 + d2 * d13 * d15 + d3 * d10 * d17 - d2 * d11 * d17) / d1, (d3 * d9 * d14 - d5 * d7 * d14 + d5 * d6 * d15 - d2 * d9 * d15 - d3 * d6 * d17 + d2 * d7 * d17) / d1, (d5 * d7 * d10 - d3 * d9 * d10 - d5 * d6 * d11 + d2 * d9 * d11 + d3 * d6 * d13 - d2 * d7 * d13) / d1, (d8 * d11 * d14 - d7 * d12 * d14 - d8 * d10 * d15 + d6 * d12 * d15 + d7 * d10 * d16 - d6 * d11 * d16) / d1, (d3 * d12 * d14 - d4 * d11 * d14 + d4 * d10 * d15 - d2 * d12 * d15 - d3 * d10 * d16 + d2 * d11 * d16) / d1, (d4 * d7 * d14 - d3 * d8 * d14 - d4 * d6 * d15 + d2 * d8 * d15 + d3 * d6 * d16 - d2 * d7 * d16) / d1, (d3 * d8 * d10 - d4 * d7 * d10 + d4 * d6 * d11 - d2 * d8 * d11 - d3 * d6 * d12 + d2 * d7 * d12) / d1 };
  }

  private static boolean isZero(double paramDouble)
  {
    if (Double.isNaN(paramDouble));
    do
      return false;
    while (Math.abs(paramDouble) >= 1.E-005D);
    return true;
  }

  public static void multiplyInto(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3)
  {
    double d1 = paramArrayOfDouble2[0];
    double d2 = paramArrayOfDouble2[1];
    double d3 = paramArrayOfDouble2[2];
    double d4 = paramArrayOfDouble2[3];
    double d5 = paramArrayOfDouble2[4];
    double d6 = paramArrayOfDouble2[5];
    double d7 = paramArrayOfDouble2[6];
    double d8 = paramArrayOfDouble2[7];
    double d9 = paramArrayOfDouble2[8];
    double d10 = paramArrayOfDouble2[9];
    double d11 = paramArrayOfDouble2[10];
    double d12 = paramArrayOfDouble2[11];
    double d13 = paramArrayOfDouble2[12];
    double d14 = paramArrayOfDouble2[13];
    double d15 = paramArrayOfDouble2[14];
    double d16 = paramArrayOfDouble2[15];
    double d17 = paramArrayOfDouble3[0];
    double d18 = paramArrayOfDouble3[1];
    double d19 = paramArrayOfDouble3[2];
    double d20 = paramArrayOfDouble3[3];
    paramArrayOfDouble1[0] = (d17 * d1 + d18 * d5 + d19 * d9 + d20 * d13);
    paramArrayOfDouble1[1] = (d17 * d2 + d18 * d6 + d19 * d10 + d20 * d14);
    paramArrayOfDouble1[2] = (d17 * d3 + d18 * d7 + d19 * d11 + d20 * d15);
    paramArrayOfDouble1[3] = (d17 * d4 + d18 * d8 + d19 * d12 + d20 * d16);
    d17 = paramArrayOfDouble3[4];
    d18 = paramArrayOfDouble3[5];
    d19 = paramArrayOfDouble3[6];
    d20 = paramArrayOfDouble3[7];
    paramArrayOfDouble1[4] = (d17 * d1 + d18 * d5 + d19 * d9 + d20 * d13);
    paramArrayOfDouble1[5] = (d17 * d2 + d18 * d6 + d19 * d10 + d20 * d14);
    paramArrayOfDouble1[6] = (d17 * d3 + d18 * d7 + d19 * d11 + d20 * d15);
    paramArrayOfDouble1[7] = (d17 * d4 + d18 * d8 + d19 * d12 + d20 * d16);
    d17 = paramArrayOfDouble3[8];
    d18 = paramArrayOfDouble3[9];
    d19 = paramArrayOfDouble3[10];
    d20 = paramArrayOfDouble3[11];
    paramArrayOfDouble1[8] = (d17 * d1 + d18 * d5 + d19 * d9 + d20 * d13);
    paramArrayOfDouble1[9] = (d17 * d2 + d18 * d6 + d19 * d10 + d20 * d14);
    paramArrayOfDouble1[10] = (d17 * d3 + d18 * d7 + d19 * d11 + d20 * d15);
    paramArrayOfDouble1[11] = (d17 * d4 + d18 * d8 + d19 * d12 + d20 * d16);
    d17 = paramArrayOfDouble3[12];
    d18 = paramArrayOfDouble3[13];
    d19 = paramArrayOfDouble3[14];
    d20 = paramArrayOfDouble3[15];
    paramArrayOfDouble1[12] = (d17 * d1 + d18 * d5 + d19 * d9 + d20 * d13);
    paramArrayOfDouble1[13] = (d17 * d2 + d18 * d6 + d19 * d10 + d20 * d14);
    paramArrayOfDouble1[14] = (d17 * d3 + d18 * d7 + d19 * d11 + d20 * d15);
    paramArrayOfDouble1[15] = (d17 * d4 + d18 * d8 + d19 * d12 + d20 * d16);
  }

  public static void multiplyVectorByMatrix(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3)
  {
    double d1 = paramArrayOfDouble1[0];
    double d2 = paramArrayOfDouble1[1];
    double d3 = paramArrayOfDouble1[2];
    double d4 = paramArrayOfDouble1[3];
    paramArrayOfDouble3[0] = (paramArrayOfDouble2[0] * d1 + paramArrayOfDouble2[4] * d2 + paramArrayOfDouble2[8] * d3 + paramArrayOfDouble2[12] * d4);
    paramArrayOfDouble3[1] = (paramArrayOfDouble2[1] * d1 + paramArrayOfDouble2[5] * d2 + paramArrayOfDouble2[9] * d3 + paramArrayOfDouble2[13] * d4);
    paramArrayOfDouble3[2] = (paramArrayOfDouble2[2] * d1 + paramArrayOfDouble2[6] * d2 + paramArrayOfDouble2[10] * d3 + paramArrayOfDouble2[14] * d4);
    paramArrayOfDouble3[3] = (paramArrayOfDouble2[3] * d1 + paramArrayOfDouble2[7] * d2 + paramArrayOfDouble2[11] * d3 + paramArrayOfDouble2[15] * d4);
  }

  public static void resetIdentityMatrix(double[] paramArrayOfDouble)
  {
    paramArrayOfDouble[14] = 0.0D;
    paramArrayOfDouble[13] = 0.0D;
    paramArrayOfDouble[12] = 0.0D;
    paramArrayOfDouble[11] = 0.0D;
    paramArrayOfDouble[9] = 0.0D;
    paramArrayOfDouble[8] = 0.0D;
    paramArrayOfDouble[7] = 0.0D;
    paramArrayOfDouble[6] = 0.0D;
    paramArrayOfDouble[4] = 0.0D;
    paramArrayOfDouble[3] = 0.0D;
    paramArrayOfDouble[2] = 0.0D;
    paramArrayOfDouble[1] = 0.0D;
    paramArrayOfDouble[15] = 1.0D;
    paramArrayOfDouble[10] = 1.0D;
    paramArrayOfDouble[5] = 1.0D;
    paramArrayOfDouble[0] = 1.0D;
  }

  public static double roundTo3Places(double paramDouble)
  {
    return Math.round(1000.0D * paramDouble) * 0.001D;
  }

  public static double[] transpose(double[] paramArrayOfDouble)
  {
    return new double[] { paramArrayOfDouble[0], paramArrayOfDouble[4], paramArrayOfDouble[8], paramArrayOfDouble[12], paramArrayOfDouble[1], paramArrayOfDouble[5], paramArrayOfDouble[9], paramArrayOfDouble[13], paramArrayOfDouble[2], paramArrayOfDouble[6], paramArrayOfDouble[10], paramArrayOfDouble[14], paramArrayOfDouble[3], paramArrayOfDouble[7], paramArrayOfDouble[11], paramArrayOfDouble[15] };
  }

  public static double[] v3Combine(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double paramDouble1, double paramDouble2)
  {
    return new double[] { paramArrayOfDouble1[0] * paramDouble1 + paramArrayOfDouble2[0] * paramDouble2, paramArrayOfDouble1[1] * paramDouble1 + paramArrayOfDouble2[1] * paramDouble2, paramArrayOfDouble1[2] * paramDouble1 + paramArrayOfDouble2[2] * paramDouble2 };
  }

  public static double[] v3Cross(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    return new double[] { paramArrayOfDouble1[1] * paramArrayOfDouble2[2] - paramArrayOfDouble1[2] * paramArrayOfDouble2[1], paramArrayOfDouble1[2] * paramArrayOfDouble2[0] - paramArrayOfDouble1[0] * paramArrayOfDouble2[2], paramArrayOfDouble1[0] * paramArrayOfDouble2[1] - paramArrayOfDouble1[1] * paramArrayOfDouble2[0] };
  }

  public static double v3Dot(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    return paramArrayOfDouble1[0] * paramArrayOfDouble2[0] + paramArrayOfDouble1[1] * paramArrayOfDouble2[1] + paramArrayOfDouble1[2] * paramArrayOfDouble2[2];
  }

  public static double v3Length(double[] paramArrayOfDouble)
  {
    return Math.sqrt(paramArrayOfDouble[0] * paramArrayOfDouble[0] + paramArrayOfDouble[1] * paramArrayOfDouble[1] + paramArrayOfDouble[2] * paramArrayOfDouble[2]);
  }

  public static double[] v3Normalize(double[] paramArrayOfDouble, double paramDouble)
  {
    double d = paramDouble;
    if (isZero(paramDouble))
      d = v3Length(paramArrayOfDouble);
    paramDouble = 1.0D / d;
    return new double[] { paramArrayOfDouble[0] * paramDouble, paramArrayOfDouble[1] * paramDouble, paramArrayOfDouble[2] * paramDouble };
  }

  public static class MatrixDecompositionContext
  {
    double[] perspective = new double[4];
    double[] rotationDegrees = new double[3];
    double[] scale = new double[3];
    double[] skew = new double[3];
    double[] translation = new double[3];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.MatrixMathHelper
 * JD-Core Version:    0.6.0
 */