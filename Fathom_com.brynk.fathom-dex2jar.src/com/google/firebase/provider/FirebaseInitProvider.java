package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.FirebaseApp;

public class FirebaseInitProvider extends ContentProvider
{
  private static void zza(@NonNull ProviderInfo paramProviderInfo)
  {
    zzaa.zzb(paramProviderInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
    if ("com.google.firebase.firebaseinitprovider".equals(paramProviderInfo.authority))
      throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
  }

  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    zza(paramProviderInfo);
    super.attachInfo(paramContext, paramProviderInfo);
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }

  @Nullable
  public String getType(Uri paramUri)
  {
    return null;
  }

  @Nullable
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }

  public boolean onCreate()
  {
    if (FirebaseApp.initializeApp(getContext()) == null)
      Log.i("FirebaseInitProvider", "FirebaseApp initialization unsuccessful");
    while (true)
    {
      return false;
      Log.i("FirebaseInitProvider", "FirebaseApp initialization successful");
    }
  }

  @Nullable
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.provider.FirebaseInitProvider
 * JD-Core Version:    0.6.0
 */