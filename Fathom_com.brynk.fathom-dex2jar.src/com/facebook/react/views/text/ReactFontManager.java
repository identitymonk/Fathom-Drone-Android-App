package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactFontManager
{
  private static final String[] EXTENSIONS = { "", "_bold", "_italic", "_bold_italic" };
  private static final String[] FILE_EXTENSIONS = { ".ttf", ".otf" };
  private static final String FONTS_ASSET_PATH = "fonts/";
  private static ReactFontManager sReactFontManagerInstance;
  private Map<String, FontFamily> mFontCache = new HashMap();

  @Nullable
  private static Typeface createTypeface(String paramString, int paramInt, AssetManager paramAssetManager)
  {
    String str = EXTENSIONS[paramInt];
    String[] arrayOfString = FILE_EXTENSIONS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = "fonts/" + paramString + str + (String)localObject;
      try
      {
        localObject = Typeface.createFromAsset(paramAssetManager, (String)localObject);
        return localObject;
      }
      catch (RuntimeException localRuntimeException)
      {
        i += 1;
      }
    }
    return (Typeface)Typeface.create(paramString, paramInt);
  }

  public static ReactFontManager getInstance()
  {
    if (sReactFontManagerInstance == null)
      sReactFontManagerInstance = new ReactFontManager();
    return sReactFontManagerInstance;
  }

  @Nullable
  public Typeface getTypeface(String paramString, int paramInt, AssetManager paramAssetManager)
  {
    Object localObject2 = (FontFamily)this.mFontCache.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new FontFamily(null);
      this.mFontCache.put(paramString, localObject1);
    }
    Typeface localTypeface = ((FontFamily)localObject1).getTypeface(paramInt);
    localObject2 = localTypeface;
    if (localTypeface == null)
    {
      paramString = createTypeface(paramString, paramInt, paramAssetManager);
      localObject2 = paramString;
      if (paramString != null)
      {
        ((FontFamily)localObject1).setTypeface(paramInt, paramString);
        localObject2 = paramString;
      }
    }
    return (Typeface)(Typeface)localObject2;
  }

  public void setTypeface(String paramString, int paramInt, Typeface paramTypeface)
  {
    if (paramTypeface != null)
    {
      FontFamily localFontFamily2 = (FontFamily)this.mFontCache.get(paramString);
      FontFamily localFontFamily1 = localFontFamily2;
      if (localFontFamily2 == null)
      {
        localFontFamily1 = new FontFamily(null);
        this.mFontCache.put(paramString, localFontFamily1);
      }
      localFontFamily1.setTypeface(paramInt, paramTypeface);
    }
  }

  private static class FontFamily
  {
    private SparseArray<Typeface> mTypefaceSparseArray = new SparseArray(4);

    public Typeface getTypeface(int paramInt)
    {
      return (Typeface)this.mTypefaceSparseArray.get(paramInt);
    }

    public void setTypeface(int paramInt, Typeface paramTypeface)
    {
      this.mTypefaceSparseArray.put(paramInt, paramTypeface);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactFontManager
 * JD-Core Version:    0.6.0
 */