package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;

public class Thing
{
  final Bundle he;

  Thing(Bundle paramBundle)
  {
    this.he = paramBundle;
  }

  public Bundle zzahu()
  {
    return this.he;
  }

  public static class Builder
  {
    final Bundle hf = new Bundle();

    public Thing build()
    {
      return new Thing(this.hf);
    }

    public Builder put(String paramString, Thing paramThing)
    {
      zzaa.zzy(paramString);
      if (paramThing != null)
        this.hf.putParcelable(paramString, paramThing.he);
      return this;
    }

    public Builder put(String paramString1, String paramString2)
    {
      zzaa.zzy(paramString1);
      if (paramString2 != null)
        this.hf.putString(paramString1, paramString2);
      return this;
    }

    public Builder put(String paramString, boolean paramBoolean)
    {
      zzaa.zzy(paramString);
      this.hf.putBoolean(paramString, paramBoolean);
      return this;
    }

    public Builder put(String paramString, Thing[] paramArrayOfThing)
    {
      zzaa.zzy(paramString);
      if (paramArrayOfThing != null)
      {
        ArrayList localArrayList = new ArrayList();
        int j = paramArrayOfThing.length;
        int i = 0;
        while (i < j)
        {
          Thing localThing = paramArrayOfThing[i];
          if (localThing != null)
            localArrayList.add(localThing.he);
          i += 1;
        }
        this.hf.putParcelableArray(paramString, (Parcelable[])localArrayList.toArray(new Bundle[localArrayList.size()]));
      }
      return this;
    }

    public Builder put(String paramString, String[] paramArrayOfString)
    {
      zzaa.zzy(paramString);
      if (paramArrayOfString != null)
        this.hf.putStringArray(paramString, paramArrayOfString);
      return this;
    }

    public Builder setDescription(String paramString)
    {
      put("description", paramString);
      return this;
    }

    public Builder setId(String paramString)
    {
      if (paramString != null)
        put("id", paramString);
      return this;
    }

    public Builder setName(String paramString)
    {
      zzaa.zzy(paramString);
      put("name", paramString);
      return this;
    }

    public Builder setType(String paramString)
    {
      put("type", paramString);
      return this;
    }

    public Builder setUrl(Uri paramUri)
    {
      zzaa.zzy(paramUri);
      put("url", paramUri.toString());
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appindexing.Thing
 * JD-Core Version:    0.6.0
 */