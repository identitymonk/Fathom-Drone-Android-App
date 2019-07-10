package com.google.firebase.appindexing;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzase.zza;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.Thing.Metadata;

public abstract interface Indexable
{
  public static final int MAX_BYTE_SIZE = 30000;
  public static final int MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL = 1000;
  public static final int MAX_NESTING_DEPTH = 5;
  public static final int MAX_NUMBER_OF_FIELDS = 20;
  public static final int MAX_REPEATED_SIZE = 100;
  public static final int MAX_STRING_LENGTH = 20000;
  public static final int MAX_URL_LENGTH = 256;

  public static class Builder extends IndexableBuilder<Builder>
  {
    public Builder()
    {
      this("Thing");
    }

    public Builder(@NonNull String paramString)
    {
      super();
    }
  }

  public static abstract interface Metadata
  {
    public static final Thing.Metadata aWv = new Builder().zzcnz();

    public static final class Builder
    {
      private static final zzase.zza aWw = new zzase.zza();
      private boolean aWx = aWw.btZ;
      private String aWy = aWw.bua;
      private int zzavt = aWw.score;

      public Builder setScore(int paramInt)
      {
        if (paramInt >= 0);
        for (boolean bool = true; ; bool = false)
        {
          zzaa.zzb(bool, 53 + "Negative score values are invalid. Value: " + paramInt);
          this.zzavt = paramInt;
          return this;
        }
      }

      public Builder setWorksOffline(boolean paramBoolean)
      {
        this.aWx = paramBoolean;
        return this;
      }

      public Thing.Metadata zzcnz()
      {
        return new Thing.Metadata(this.aWx, this.zzavt, this.aWy);
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.Indexable
 * JD-Core Version:    0.6.0
 */