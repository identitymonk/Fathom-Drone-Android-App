package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzagp
{
  public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  public static final Uri aVg = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  public static final Pattern aVh = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  public static final Pattern aVi = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  private static final AtomicBoolean aVj = new AtomicBoolean();
  static HashMap<String, String> aVk;
  private static Object aVl;
  private static boolean aVm;
  static String[] aVn = new String[0];

  public static long getLong(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    paramContentResolver = getString(paramContentResolver, paramString);
    long l = paramLong;
    if (paramContentResolver != null);
    try
    {
      l = Long.parseLong(paramContentResolver);
      return l;
    }
    catch (java.lang.NumberFormatException paramContentResolver)
    {
    }
    return paramLong;
  }

  @Deprecated
  public static String getString(ContentResolver paramContentResolver, String paramString)
  {
    return zza(paramContentResolver, paramString, null);
  }

  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    monitorenter;
    while (true)
    {
      Object localObject2;
      Object localObject1;
      int i;
      try
      {
        zza(paramContentResolver);
        localObject2 = aVl;
        if (!aVk.containsKey(paramString1))
          continue;
        paramContentResolver = (String)aVk.get(paramString1);
        if (paramContentResolver == null)
          continue;
        paramString2 = paramContentResolver;
        return paramString2;
        localObject1 = aVn;
        int j = localObject1.length;
        i = 0;
        if (i >= j)
          break label138;
        if (!paramString1.startsWith(localObject1[i]))
          break label277;
        if ((!aVm) || (aVk.isEmpty()))
        {
          zzc(paramContentResolver, aVn);
          if (aVk.containsKey(paramString1))
          {
            paramContentResolver = (String)aVk.get(paramString1);
            if (paramContentResolver == null)
              continue;
            paramString2 = paramContentResolver;
            return paramString2;
          }
        }
      }
      finally
      {
        monitorexit;
      }
      monitorexit;
      return paramString2;
      label138: monitorexit;
      Cursor localCursor = paramContentResolver.query(CONTENT_URI, null, null, new String[] { paramString1 }, null);
      if (localCursor != null);
      try
      {
        if (!localCursor.moveToFirst())
        {
          zza(localObject2, paramString1, null);
          paramContentResolver = paramString2;
          return paramString2;
        }
        localObject1 = localCursor.getString(1);
        paramContentResolver = (ContentResolver)localObject1;
        if (localObject1 != null)
        {
          paramContentResolver = (ContentResolver)localObject1;
          if (((String)localObject1).equals(paramString2))
            paramContentResolver = paramString2;
        }
        zza(localObject2, paramString1, paramContentResolver);
        if (paramContentResolver != null)
          paramString2 = paramContentResolver;
        paramContentResolver = paramString2;
        return paramString2;
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
      return paramContentResolver;
      label277: i += 1;
    }
  }

  public static Map<String, String> zza(ContentResolver paramContentResolver, String[] paramArrayOfString)
  {
    paramContentResolver = paramContentResolver.query(aVg, null, null, paramArrayOfString, null);
    paramArrayOfString = new TreeMap();
    if (paramContentResolver == null)
      return paramArrayOfString;
    try
    {
      if (paramContentResolver.moveToNext())
        paramArrayOfString.put(paramContentResolver.getString(0), paramContentResolver.getString(1));
    }
    finally
    {
      paramContentResolver.close();
    }
    return paramArrayOfString;
  }

  private static void zza(ContentResolver paramContentResolver)
  {
    if (aVk == null)
    {
      aVj.set(false);
      aVk = new HashMap();
      aVl = new Object();
      aVm = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new ContentObserver(new Handler(Looper.getMainLooper()))
      {
        public void onChange(boolean paramBoolean)
        {
          zzagp.zzcng().set(true);
        }
      });
    }
    do
      return;
    while (!aVj.getAndSet(false));
    aVk.clear();
    aVl = new Object();
    aVm = false;
  }

  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    monitorenter;
    try
    {
      if (paramObject == aVl)
        aVk.put(paramString1, paramString2);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramObject;
  }

  public static void zzb(ContentResolver paramContentResolver, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length == 0)
      return;
    monitorenter;
    while (true)
    {
      try
      {
        zza(paramContentResolver);
        paramArrayOfString = zzk(paramArrayOfString);
        if ((!aVm) || (aVk.isEmpty()))
        {
          zzc(paramContentResolver, aVn);
          return;
        }
      }
      finally
      {
        monitorexit;
      }
      if (paramArrayOfString.length == 0)
        continue;
      zzc(paramContentResolver, paramArrayOfString);
    }
  }

  private static void zzc(ContentResolver paramContentResolver, String[] paramArrayOfString)
  {
    aVk.putAll(zza(paramContentResolver, paramArrayOfString));
    aVm = true;
  }

  private static String[] zzk(String[] paramArrayOfString)
  {
    HashSet localHashSet = new HashSet((aVn.length + paramArrayOfString.length) * 4 / 3 + 1);
    localHashSet.addAll(Arrays.asList(aVn));
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (localHashSet.add(str))
        localArrayList.add(str);
      i += 1;
    }
    if (localArrayList.isEmpty())
      return new String[0];
    aVn = (String[])localHashSet.toArray(new String[localHashSet.size()]);
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzagp
 * JD-Core Version:    0.6.0
 */