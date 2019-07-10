package com.facebook.react.flat;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.facebook.infer.annotation.Assertions;
import java.util.HashMap;
import javax.annotation.Nullable;

final class TypefaceCache
{
  private static final String[] EXTENSIONS;
  private static final String[] FILE_EXTENSIONS;
  private static final HashMap<String, Typeface[]> FONTFAMILY_CACHE = new HashMap();
  private static final String FONTS_ASSET_PATH = "fonts/";
  private static final int MAX_STYLES = 4;
  private static final HashMap<Typeface, Typeface[]> TYPEFACE_CACHE = new HashMap();

  @Nullable
  private static AssetManager sAssetManager;

  static
  {
    EXTENSIONS = new String[] { "", "_bold", "_italic", "_bold_italic" };
    FILE_EXTENSIONS = new String[] { ".ttf", ".otf" };
    sAssetManager = null;
  }

  private static Typeface createTypeface(String paramString, int paramInt)
  {
    Object localObject1 = EXTENSIONS[paramInt];
    localObject1 = new StringBuilder(32).append("fonts/").append(paramString).append((String)localObject1);
    int j = ((StringBuilder)localObject1).length();
    String[] arrayOfString = FILE_EXTENSIONS;
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      Object localObject2 = arrayOfString[i];
      try
      {
        localObject2 = Typeface.createFromAsset(sAssetManager, (String)localObject2);
        return localObject2;
      }
      catch (RuntimeException localRuntimeException)
      {
        ((StringBuilder)localObject1).setLength(j);
        i += 1;
      }
    }
    return (Typeface)(Typeface)(Typeface)Assertions.assumeNotNull(Typeface.create(paramString, paramInt));
  }

  public static Typeface getTypeface(Typeface paramTypeface, int paramInt)
  {
    if (paramTypeface == null)
      return Typeface.defaultFromStyle(paramInt);
    Typeface[] arrayOfTypeface2 = (Typeface[])TYPEFACE_CACHE.get(paramTypeface);
    Typeface[] arrayOfTypeface1;
    if (arrayOfTypeface2 == null)
    {
      arrayOfTypeface1 = new Typeface[4];
      arrayOfTypeface1[paramTypeface.getStyle()] = paramTypeface;
    }
    do
    {
      paramTypeface = Typeface.create(paramTypeface, paramInt);
      arrayOfTypeface1[paramInt] = paramTypeface;
      TYPEFACE_CACHE.put(paramTypeface, arrayOfTypeface1);
      return paramTypeface;
      arrayOfTypeface1 = arrayOfTypeface2;
    }
    while (arrayOfTypeface2[paramInt] == null);
    return arrayOfTypeface2[paramInt];
  }

  public static Typeface getTypeface(String paramString, int paramInt)
  {
    Typeface[] arrayOfTypeface2 = (Typeface[])FONTFAMILY_CACHE.get(paramString);
    Typeface[] arrayOfTypeface1;
    if (arrayOfTypeface2 == null)
    {
      arrayOfTypeface1 = new Typeface[4];
      FONTFAMILY_CACHE.put(paramString, arrayOfTypeface1);
    }
    do
    {
      paramString = createTypeface(paramString, paramInt);
      arrayOfTypeface1[paramInt] = paramString;
      TYPEFACE_CACHE.put(paramString, arrayOfTypeface1);
      return paramString;
      arrayOfTypeface1 = arrayOfTypeface2;
    }
    while (arrayOfTypeface2[paramInt] == null);
    return arrayOfTypeface2[paramInt];
  }

  public static void setAssetManager(AssetManager paramAssetManager)
  {
    sAssetManager = paramAssetManager;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.TypefaceCache
 * JD-Core Version:    0.6.0
 */