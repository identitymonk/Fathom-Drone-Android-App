package com.google.firebase.appindexing.builders;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.Indexable.Metadata;
import com.google.firebase.appindexing.Indexable.Metadata.Builder;
import com.google.firebase.appindexing.internal.Thing;
import com.google.firebase.appindexing.internal.Thing.Metadata;
import com.google.firebase.appindexing.internal.zzg;
import java.util.Arrays;

public abstract class IndexableBuilder<T extends IndexableBuilder<?>>
{
  Thing.Metadata aWz;
  final Bundle he;
  String zzae;
  final String zzcpo;

  protected IndexableBuilder(@NonNull String paramString)
  {
    zzaa.zzy(paramString);
    zzaa.zzib(paramString);
    this.he = new Bundle();
    this.zzcpo = paramString;
  }

  private T zza(@NonNull String paramString, @NonNull Thing[] paramArrayOfThing)
  {
    zzaa.zzy(paramString);
    zzaa.zzy(paramArrayOfThing);
    if (paramArrayOfThing.length > 0)
    {
      int i = 0;
      int j = 0;
      if (i < paramArrayOfThing.length)
      {
        paramArrayOfThing[j] = paramArrayOfThing[i];
        if (paramArrayOfThing[i] == null)
          zzg.zzrr(58 + "Thing at " + i + " is null and is ignored by put method.");
        while (true)
        {
          i += 1;
          break;
          j += 1;
        }
      }
      if (j > 0)
      {
        paramArrayOfThing = (Thing[])Arrays.copyOfRange(paramArrayOfThing, 0, j);
        this.he.putParcelableArray(paramString, (Parcelable[])zzd(paramArrayOfThing));
      }
    }
    while (true)
    {
      return zzcoa();
      zzg.zzrr("Thing array is empty and is ignored by put method.");
    }
  }

  private static boolean[] zza(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean.length < 100)
      return paramArrayOfBoolean;
    zzg.zzrr("Input Array of elements is too big, cutting off.");
    return Arrays.copyOf(paramArrayOfBoolean, 100);
  }

  private static long[] zzb(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong.length < 100)
      return paramArrayOfLong;
    zzg.zzrr("Input Array of elements is too big, cutting off.");
    return Arrays.copyOf(paramArrayOfLong, 100);
  }

  private T zzcoa()
  {
    return this;
  }

  private static <S> S[] zzd(S[] paramArrayOfS)
  {
    if (paramArrayOfS.length < 100)
      return paramArrayOfS;
    zzg.zzrr("Input Array of elements is too big, cutting off.");
    return Arrays.copyOf(paramArrayOfS, 100);
  }

  @KeepName
  public final Indexable build()
  {
    Bundle localBundle = new Bundle(this.he);
    if (this.aWz == null);
    for (Thing.Metadata localMetadata = Indexable.Metadata.aWv; ; localMetadata = this.aWz)
      return new Thing(localBundle, localMetadata, this.zzae, this.zzcpo);
  }

  @KeepName
  public T put(@NonNull String paramString, @NonNull long[] paramArrayOfLong)
  {
    zzaa.zzy(paramString);
    zzaa.zzy(paramArrayOfLong);
    if (paramArrayOfLong.length > 0)
      this.he.putLongArray(paramString, zzb(paramArrayOfLong));
    while (true)
    {
      return zzcoa();
      zzg.zzrr("Long array is empty and is ignored by put method.");
    }
  }

  @KeepName
  public T put(@NonNull String paramString, @NonNull Indexable[] paramArrayOfIndexable)
    throws FirebaseAppIndexingInvalidArgumentException
  {
    zzaa.zzy(paramString);
    zzaa.zzy(paramArrayOfIndexable);
    Thing[] arrayOfThing = new Thing[paramArrayOfIndexable.length];
    int i = 0;
    while (i < paramArrayOfIndexable.length)
    {
      if ((paramArrayOfIndexable[i] != null) && (!(paramArrayOfIndexable[i] instanceof Thing)))
        throw new FirebaseAppIndexingInvalidArgumentException("Invalid Indexable encountered. Use Indexable.Builder or convenience methods under Indexables to create the Indexable.");
      arrayOfThing[i] = ((Thing)paramArrayOfIndexable[i]);
      i += 1;
    }
    zza(paramString, arrayOfThing);
    return zzcoa();
  }

  protected <S extends IndexableBuilder> T put(@NonNull String paramString, @NonNull S[] paramArrayOfS)
  {
    zzaa.zzy(paramString);
    zzaa.zzy(paramArrayOfS);
    if (paramArrayOfS.length > 0)
    {
      Thing[] arrayOfThing = new Thing[paramArrayOfS.length];
      int i = 0;
      if (i < paramArrayOfS.length)
      {
        if (paramArrayOfS[i] == null)
          zzg.zzrr(60 + "Builder at " + i + " is null and is ignored by put method.");
        while (true)
        {
          i += 1;
          break;
          arrayOfThing[i] = ((Thing)paramArrayOfS[i].build());
        }
      }
      if (arrayOfThing.length > 0)
        zza(paramString, arrayOfThing);
    }
    while (true)
    {
      return zzcoa();
      zzg.zzrr("Builder array is empty and is ignored by put method.");
    }
  }

  @KeepName
  public T put(@NonNull String paramString, @NonNull String[] paramArrayOfString)
  {
    zzaa.zzy(paramString);
    zzaa.zzy(paramArrayOfString);
    if (paramArrayOfString.length > 0)
    {
      int i = 0;
      int j = 0;
      if (i < Math.min(paramArrayOfString.length, 100))
      {
        paramArrayOfString[j] = paramArrayOfString[i];
        if (paramArrayOfString[i] == null)
          zzg.zzrr(59 + "String at " + i + " is null and is ignored by put method.");
        while (true)
        {
          i += 1;
          break;
          if (paramArrayOfString[j].length() > 20000)
          {
            zzg.zzrr(53 + "String at " + i + " is too long, truncating string.");
            paramArrayOfString[j] = paramArrayOfString[j].substring(0, 20000);
          }
          j += 1;
        }
      }
      if (j > 0)
      {
        paramArrayOfString = (String[])Arrays.copyOfRange(paramArrayOfString, 0, j);
        this.he.putStringArray(paramString, (String[])zzd(paramArrayOfString));
      }
    }
    while (true)
    {
      return zzcoa();
      zzg.zzrr("String array is empty and is ignored by put method.");
    }
  }

  @KeepName
  public T put(@NonNull String paramString, @NonNull boolean[] paramArrayOfBoolean)
  {
    zzaa.zzy(paramString);
    zzaa.zzy(paramArrayOfBoolean);
    if (paramArrayOfBoolean.length > 0)
      this.he.putBooleanArray(paramString, zza(paramArrayOfBoolean));
    while (true)
    {
      return zzcoa();
      zzg.zzrr("Boolean array is empty and is ignored by put method.");
    }
  }

  @KeepName
  public final T setDescription(@NonNull String paramString)
  {
    zzaa.zzy(paramString);
    return put("description", new String[] { paramString });
  }

  @KeepName
  public final T setImage(@NonNull String paramString)
  {
    zzaa.zzy(paramString);
    return put("image", new String[] { paramString });
  }

  @KeepName
  public T setMetadata(@NonNull Indexable.Metadata.Builder paramBuilder)
  {
    if (this.aWz == null);
    for (boolean bool = true; ; bool = false)
    {
      zzaa.zza(bool, "setMetadata may only be called once");
      zzaa.zzy(paramBuilder);
      this.aWz = paramBuilder.zzcnz();
      return zzcoa();
    }
  }

  @KeepName
  public final T setName(@NonNull String paramString)
  {
    zzaa.zzy(paramString);
    return put("name", new String[] { paramString });
  }

  @KeepName
  public final T setSameAs(@NonNull String paramString)
  {
    zzaa.zzy(paramString);
    return put("sameAs", new String[] { paramString });
  }

  @KeepName
  public final T setUrl(@NonNull String paramString)
  {
    zzaa.zzy(paramString);
    this.zzae = paramString;
    return zzcoa();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.IndexableBuilder
 * JD-Core Version:    0.6.0
 */