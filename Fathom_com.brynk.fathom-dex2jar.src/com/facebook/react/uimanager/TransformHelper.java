package com.facebook.react.uimanager;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;

public class TransformHelper
{
  private static ThreadLocal<double[]> sHelperMatrix = new ThreadLocal()
  {
    protected double[] initialValue()
    {
      return new double[16];
    }
  };

  private static double convertToRadians(ReadableMap paramReadableMap, String paramString)
  {
    int j = 1;
    int i = 1;
    double d;
    if (paramReadableMap.getType(paramString) == ReadableType.String)
    {
      paramString = paramReadableMap.getString(paramString);
      if (paramString.endsWith("rad"))
      {
        paramReadableMap = paramString.substring(0, paramString.length() - 3);
        d = Float.parseFloat(paramReadableMap);
      }
    }
    while (true)
    {
      if (i == 0)
        break label105;
      return d;
      paramReadableMap = paramString;
      if (!paramString.endsWith("deg"))
        break;
      i = 0;
      paramReadableMap = paramString.substring(0, paramString.length() - 3);
      break;
      d = paramReadableMap.getDouble(paramString);
      i = j;
    }
    label105: return MatrixMathHelper.degreesToRadians(d);
  }

  public static void processTransform(ReadableArray paramReadableArray, double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble = (double[])sHelperMatrix.get();
    MatrixMathHelper.resetIdentityMatrix(paramArrayOfDouble);
    int i = 0;
    int k = paramReadableArray.size();
    if (i < k)
    {
      Object localObject = paramReadableArray.getMap(i);
      String str = ((ReadableMap)localObject).keySetIterator().nextKey();
      MatrixMathHelper.resetIdentityMatrix(arrayOfDouble);
      if ("matrix".equals(str))
      {
        localObject = ((ReadableMap)localObject).getArray(str);
        int j = 0;
        while (j < 16)
        {
          arrayOfDouble[j] = ((ReadableArray)localObject).getDouble(j);
          j += 1;
        }
      }
      if ("perspective".equals(str))
        MatrixMathHelper.applyPerspective(arrayOfDouble, ((ReadableMap)localObject).getDouble(str));
      while (true)
      {
        MatrixMathHelper.multiplyInto(paramArrayOfDouble, paramArrayOfDouble, arrayOfDouble);
        i += 1;
        break;
        if ("rotateX".equals(str))
        {
          MatrixMathHelper.applyRotateX(arrayOfDouble, convertToRadians((ReadableMap)localObject, str));
          continue;
        }
        if ("rotateY".equals(str))
        {
          MatrixMathHelper.applyRotateY(arrayOfDouble, convertToRadians((ReadableMap)localObject, str));
          continue;
        }
        if (("rotate".equals(str)) || ("rotateZ".equals(str)))
        {
          MatrixMathHelper.applyRotateZ(arrayOfDouble, convertToRadians((ReadableMap)localObject, str));
          continue;
        }
        double d1;
        if ("scale".equals(str))
        {
          d1 = ((ReadableMap)localObject).getDouble(str);
          MatrixMathHelper.applyScaleX(arrayOfDouble, d1);
          MatrixMathHelper.applyScaleY(arrayOfDouble, d1);
          continue;
        }
        if ("scaleX".equals(str))
        {
          MatrixMathHelper.applyScaleX(arrayOfDouble, ((ReadableMap)localObject).getDouble(str));
          continue;
        }
        if ("scaleY".equals(str))
        {
          MatrixMathHelper.applyScaleY(arrayOfDouble, ((ReadableMap)localObject).getDouble(str));
          continue;
        }
        if ("translate".equals(str))
        {
          localObject = ((ReadableMap)localObject).getArray(str);
          double d2 = ((ReadableArray)localObject).getDouble(0);
          double d3 = ((ReadableArray)localObject).getDouble(1);
          if (((ReadableArray)localObject).size() > 2)
            d1 = ((ReadableArray)localObject).getDouble(2);
          while (true)
          {
            MatrixMathHelper.applyTranslate3D(arrayOfDouble, d2, d3, d1);
            break;
            d1 = 0.0D;
          }
        }
        if ("translateX".equals(str))
        {
          MatrixMathHelper.applyTranslate2D(arrayOfDouble, ((ReadableMap)localObject).getDouble(str), 0.0D);
          continue;
        }
        if ("translateY".equals(str))
        {
          MatrixMathHelper.applyTranslate2D(arrayOfDouble, 0.0D, ((ReadableMap)localObject).getDouble(str));
          continue;
        }
        if ("skewX".equals(str))
        {
          MatrixMathHelper.applySkewX(arrayOfDouble, convertToRadians((ReadableMap)localObject, str));
          continue;
        }
        if (!"skewY".equals(str))
          break label515;
        MatrixMathHelper.applySkewY(arrayOfDouble, convertToRadians((ReadableMap)localObject, str));
      }
      label515: throw new JSApplicationIllegalArgumentException("Unsupported transform type: " + str);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.TransformHelper
 * JD-Core Version:    0.6.0
 */