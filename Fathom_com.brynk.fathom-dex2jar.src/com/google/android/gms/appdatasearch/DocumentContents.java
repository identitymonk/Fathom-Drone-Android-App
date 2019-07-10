package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class DocumentContents extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DocumentContents> CREATOR = new zzb();
  public final Account account;
  final DocumentSection[] gd;
  public final String ge;
  public final boolean gf;
  final int mVersionCode;

  DocumentContents(int paramInt, DocumentSection[] paramArrayOfDocumentSection, String paramString, boolean paramBoolean, Account paramAccount)
  {
    this.mVersionCode = paramInt;
    this.gd = paramArrayOfDocumentSection;
    this.ge = paramString;
    this.gf = paramBoolean;
    this.account = paramAccount;
  }

  DocumentContents(String paramString, boolean paramBoolean, Account paramAccount, DocumentSection[] paramArrayOfDocumentSection)
  {
    this(1, paramArrayOfDocumentSection, paramString, paramBoolean, paramAccount);
    if (paramArrayOfDocumentSection != null)
    {
      paramString = new BitSet(zzh.zzahq());
      int i = 0;
      while (i < paramArrayOfDocumentSection.length)
      {
        int j = paramArrayOfDocumentSection[i].gq;
        if (j != -1)
        {
          if (paramString.get(j))
          {
            paramString = String.valueOf(zzh.zzcn(j));
            if (paramString.length() != 0);
            for (paramString = "Duplicate global search section type ".concat(paramString); ; paramString = new String("Duplicate global search section type "))
              throw new IllegalArgumentException(paramString);
          }
          paramString.set(j);
        }
        i += 1;
      }
    }
  }

  public boolean equals(Object paramObject)
  {
    int j = 0;
    int i = j;
    if ((paramObject instanceof DocumentContents))
    {
      paramObject = (DocumentContents)paramObject;
      i = j;
      if (zzz.equal(this.ge, paramObject.ge))
      {
        i = j;
        if (zzz.equal(Boolean.valueOf(this.gf), Boolean.valueOf(paramObject.gf)))
        {
          i = j;
          if (zzz.equal(this.account, paramObject.account))
          {
            i = j;
            if (Arrays.equals(zzahn(), paramObject.zzahn()))
              i = 1;
          }
        }
      }
    }
    return i;
  }

  public int hashCode()
  {
    return zzz.hashCode(new Object[] { this.ge, Boolean.valueOf(this.gf), this.account, Integer.valueOf(Arrays.hashCode(this.gd)) });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }

  public DocumentSection[] zzahn()
  {
    return this.gd;
  }

  public static class zza
  {
    private List<DocumentSection> gg;
    private String gh;
    private boolean gi;
    private Account gj;

    public zza zza(DocumentSection paramDocumentSection)
    {
      if ((this.gg == null) && (paramDocumentSection != null))
        this.gg = new ArrayList();
      if (paramDocumentSection != null)
        this.gg.add(paramDocumentSection);
      return this;
    }

    public DocumentContents zzaho()
    {
      String str = this.gh;
      boolean bool = this.gi;
      Account localAccount = this.gj;
      if (this.gg != null);
      for (DocumentSection[] arrayOfDocumentSection = (DocumentSection[])this.gg.toArray(new DocumentSection[this.gg.size()]); ; arrayOfDocumentSection = null)
        return new DocumentContents(str, bool, localAccount, arrayOfDocumentSection);
    }

    public zza zzay(boolean paramBoolean)
    {
      this.gi = paramBoolean;
      return this;
    }

    public zza zzb(Account paramAccount)
    {
      this.gj = paramAccount;
      return this;
    }

    public zza zzfp(String paramString)
    {
      this.gh = paramString;
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.DocumentContents
 * JD-Core Version:    0.6.0
 */