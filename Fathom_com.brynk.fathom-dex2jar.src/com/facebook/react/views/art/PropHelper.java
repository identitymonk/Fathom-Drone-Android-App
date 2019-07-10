package com.facebook.react.views.art;

import com.facebook.react.bridge.ReadableArray;
import javax.annotation.Nullable;

class PropHelper
{
  static int toFloatArray(ReadableArray paramReadableArray, float[] paramArrayOfFloat)
  {
    if (paramReadableArray.size() > paramArrayOfFloat.length);
    for (int i = paramArrayOfFloat.length; ; i = paramReadableArray.size())
    {
      int j = 0;
      while (j < i)
      {
        paramArrayOfFloat[j] = (float)paramReadableArray.getDouble(j);
        j += 1;
      }
    }
    return paramReadableArray.size();
  }

  @Nullable
  static float[] toFloatArray(@Nullable ReadableArray paramReadableArray)
  {
    if (paramReadableArray != null)
    {
      float[] arrayOfFloat = new float[paramReadableArray.size()];
      toFloatArray(paramReadableArray, arrayOfFloat);
      return arrayOfFloat;
    }
    return null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.PropHelper
 * JD-Core Version:    0.6.0
 */