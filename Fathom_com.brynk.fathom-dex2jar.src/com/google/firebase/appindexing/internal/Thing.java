package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;
import com.google.firebase.appindexing.Indexable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;

public final class Thing extends AbstractSafeParcelable
  implements ReflectedParcelable, Indexable
{
  public static final Parcelable.Creator<Thing> CREATOR = new zzj();
  private final Metadata aWz;
  private final Bundle he;
  public final int mVersionCode;
  private final String zzboa;
  private final String zzcpo;

  public Thing(int paramInt, Bundle paramBundle, Metadata paramMetadata, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.he = paramBundle;
    this.aWz = paramMetadata;
    this.zzboa = paramString1;
    this.zzcpo = paramString2;
    this.he.setClassLoader(getClass().getClassLoader());
  }

  public Thing(@NonNull Bundle paramBundle, @NonNull Metadata paramMetadata, String paramString1, @NonNull String paramString2)
  {
    this.mVersionCode = 6;
    this.he = paramBundle;
    this.aWz = paramMetadata;
    this.zzboa = paramString1;
    this.zzcpo = paramString2;
  }

  public String getId()
  {
    return this.zzboa;
  }

  public String getType()
  {
    return this.zzcpo;
  }

  public int getVersionCode()
  {
    return this.mVersionCode;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(zzcoo()).append(" { ");
    Object localObject2 = localStringBuilder.append("{ id: ");
    Object localObject1;
    int i;
    if (getId() == null)
    {
      localObject1 = "<null> } ";
      ((StringBuilder)localObject2).append((String)localObject1);
      localStringBuilder.append("Properties { ");
      localObject1 = this.he.keySet();
      localObject1 = (String[])((Set)localObject1).toArray(new String[((Set)localObject1).size()]);
      Arrays.sort(localObject1);
      int k = localObject1.length;
      i = 0;
      label102: if (i >= k)
        break label303;
      localObject2 = localObject1[i];
      localStringBuilder.append("{ key: '").append((String)localObject2).append("' value: ");
      localObject2 = this.he.get((String)localObject2);
      if (localObject2 != null)
        break label219;
      localStringBuilder.append("<null>");
    }
    while (true)
    {
      localStringBuilder.append(" } ");
      i += 1;
      break label102;
      localObject1 = String.valueOf(getId());
      localObject1 = String.valueOf(localObject1).length() + 5 + "'" + (String)localObject1 + "' } ";
      break;
      label219: if (localObject2.getClass().isArray())
      {
        localStringBuilder.append("[ ");
        int j = 0;
        while (j < Array.getLength(localObject2))
        {
          localStringBuilder.append("'").append(Array.get(localObject2, j)).append("' ");
          j += 1;
        }
        localStringBuilder.append("]");
        continue;
      }
      localStringBuilder.append(localObject2.toString());
    }
    label303: localStringBuilder.append("} ");
    localStringBuilder.append("Metadata { ");
    localStringBuilder.append(this.aWz.toString());
    localStringBuilder.append(" } ");
    localStringBuilder.append("}");
    return (String)(String)localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }

  public Bundle zzahu()
  {
    return this.he;
  }

  public Metadata zzcon()
  {
    return this.aWz;
  }

  public String zzcoo()
  {
    if (this.zzcpo.equals("Thing"))
      return "Indexable";
    return this.zzcpo;
  }

  public static class Metadata extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<Metadata> CREATOR = new zzh();
    private final boolean aWx;
    private String aWy;
    public final int mVersionCode;
    private int zzavt;

    Metadata(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
    {
      this.mVersionCode = paramInt1;
      this.aWx = paramBoolean;
      this.zzavt = paramInt2;
      this.aWy = paramString;
    }

    public Metadata(boolean paramBoolean, int paramInt, String paramString)
    {
      this.mVersionCode = 1;
      this.aWx = paramBoolean;
      this.zzavt = paramInt;
      this.aWy = paramString;
    }

    public boolean equals(Object paramObject)
    {
      int j = 0;
      int i = j;
      if ((paramObject instanceof Metadata))
      {
        paramObject = (Metadata)paramObject;
        i = j;
        if (zzz.equal(Boolean.valueOf(this.aWx), Boolean.valueOf(paramObject.aWx)))
        {
          i = j;
          if (zzz.equal(Integer.valueOf(this.zzavt), Integer.valueOf(paramObject.zzavt)))
          {
            i = j;
            if (zzz.equal(this.aWy, paramObject.aWy))
              i = 1;
          }
        }
      }
      return i;
    }

    public int getScore()
    {
      return this.zzavt;
    }

    public int hashCode()
    {
      return zzz.hashCode(new Object[] { Boolean.valueOf(this.aWx), Integer.valueOf(this.zzavt), this.aWy });
    }

    public String toString()
    {
      String str = "";
      if (!zzcoq().isEmpty())
      {
        str = String.valueOf(zzcoq());
        if (str.length() == 0)
          break label88;
      }
      label88: for (str = ", accountEmail: ".concat(str); ; str = new String(", accountEmail: "))
      {
        boolean bool = zzcop();
        int i = getScore();
        return String.valueOf(str).length() + 39 + "worksOffline: " + bool + ", score: " + i + str;
      }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzh.zza(this, paramParcel, paramInt);
    }

    public boolean zzcop()
    {
      return this.aWx;
    }

    public String zzcoq()
    {
      return this.aWy;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.Thing
 * JD-Core Version:    0.6.0
 */