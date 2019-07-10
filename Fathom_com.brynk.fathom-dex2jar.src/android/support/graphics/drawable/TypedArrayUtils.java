package android.support.graphics.drawable;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

class TypedArrayUtils
{
  private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

  public static boolean getNamedBoolean(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, boolean paramBoolean)
  {
    if (!hasAttribute(paramXmlPullParser, paramString))
      return paramBoolean;
    return paramTypedArray.getBoolean(paramInt, paramBoolean);
  }

  public static int getNamedColor(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString))
      return paramInt2;
    return paramTypedArray.getColor(paramInt1, paramInt2);
  }

  public static float getNamedFloat(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, float paramFloat)
  {
    if (!hasAttribute(paramXmlPullParser, paramString))
      return paramFloat;
    return paramTypedArray.getFloat(paramInt, paramFloat);
  }

  public static int getNamedInt(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString))
      return paramInt2;
    return paramTypedArray.getInt(paramInt1, paramInt2);
  }

  public static boolean hasAttribute(XmlPullParser paramXmlPullParser, String paramString)
  {
    return paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.graphics.drawable.TypedArrayUtils
 * JD-Core Version:    0.6.0
 */