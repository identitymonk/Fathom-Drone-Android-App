package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR = new zzb();
  final int mVersionCode;
  private final Uri sa;
  private final int zzakh;
  private final int zzaki;

  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.sa = paramUri;
    this.zzakh = paramInt2;
    this.zzaki = paramInt3;
  }

  public WebImage(Uri paramUri)
    throws IllegalArgumentException
  {
    this(paramUri, 0, 0);
  }

  public WebImage(Uri paramUri, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    this(1, paramUri, paramInt1, paramInt2);
    if (paramUri == null)
      throw new IllegalArgumentException("url cannot be null");
    if ((paramInt1 < 0) || (paramInt2 < 0))
      throw new IllegalArgumentException("width and height must not be negative");
  }

  public WebImage(JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    this(zzp(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }

  private static Uri zzp(JSONObject paramJSONObject)
  {
    Uri localUri = null;
    if (paramJSONObject.has("url"));
    try
    {
      localUri = Uri.parse(paramJSONObject.getString("url"));
      return localUri;
    }
    catch (JSONException paramJSONObject)
    {
    }
    return null;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof WebImage)))
        return false;
      paramObject = (WebImage)paramObject;
    }
    while ((zzz.equal(this.sa, paramObject.sa)) && (this.zzakh == paramObject.zzakh) && (this.zzaki == paramObject.zzaki));
    return false;
  }

  public int getHeight()
  {
    return this.zzaki;
  }

  public Uri getUrl()
  {
    return this.sa;
  }

  public int getWidth()
  {
    return this.zzakh;
  }

  public int hashCode()
  {
    return zzz.hashCode(new Object[] { this.sa, Integer.valueOf(this.zzakh), Integer.valueOf(this.zzaki) });
  }

  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.sa.toString());
      localJSONObject.put("width", this.zzakh);
      localJSONObject.put("height", this.zzaki);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  public String toString()
  {
    return String.format(Locale.US, "Image %dx%d %s", new Object[] { Integer.valueOf(this.zzakh), Integer.valueOf(this.zzaki), this.sa.toString() });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.WebImage
 * JD-Core Version:    0.6.0
 */