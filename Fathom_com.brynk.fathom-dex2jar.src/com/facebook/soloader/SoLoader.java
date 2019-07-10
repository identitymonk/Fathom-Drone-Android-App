package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public class SoLoader
{
  static final boolean DEBUG = false;
  public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
  public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
  private static String SO_STORE_NAME_MAIN;
  static final boolean SYSTRACE_LIBRARY_LOADING = false;
  static final String TAG = "SoLoader";
  private static int sFlags;
  private static final Set<String> sLoadedLibraries;

  @Nullable
  private static StrictMode.ThreadPolicy sOldPolicy;

  @Nullable
  private static SoSource[] sSoSources = null;

  static
  {
    sLoadedLibraries = new HashSet();
    sOldPolicy = null;
    SO_STORE_NAME_MAIN = "lib-main";
  }

  private static void assertInitialized()
  {
    if (sSoSources == null)
      throw new RuntimeException("SoLoader.init() not yet called");
  }

  public static void init(Context paramContext, int paramInt)
    throws IOException
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskWrites();
    try
    {
      initImpl(paramContext, paramInt);
      return;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
    throw paramContext;
  }

  public static void init(Context paramContext, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
      i = 1;
    try
    {
      while (true)
      {
        init(paramContext, i);
        return;
        i = 0;
      }
    }
    catch (IOException paramContext)
    {
    }
    throw new RuntimeException(paramContext);
  }

  private static void initImpl(Context paramContext, int paramInt)
    throws IOException
  {
    monitorenter;
    while (true)
    {
      ArrayList localArrayList;
      Object localObject;
      int i;
      try
      {
        if (sSoSources != null)
          break label279;
        sFlags = paramInt;
        localArrayList = new ArrayList();
        String str = System.getenv("LD_LIBRARY_PATH");
        localObject = str;
        if (str != null)
          continue;
        localObject = "/vendor/lib:/system/lib";
        localObject = ((String)localObject).split(":");
        i = 0;
        if (i >= localObject.length)
          continue;
        localArrayList.add(new DirectorySoSource(new File(localObject[i]), 2));
        i += 1;
        continue;
        if (paramContext == null)
          continue;
        if ((paramInt & 0x1) == 0)
          continue;
        localArrayList.add(0, new ExoSoSource(paramContext, SO_STORE_NAME_MAIN));
        paramContext = (SoSource[])localArrayList.toArray(new SoSource[localArrayList.size()]);
        int j = makePrepareFlags();
        paramInt = paramContext.length;
        i = paramInt - 1;
        if (paramInt <= 0)
          break label275;
        paramContext[i].prepare(j);
        paramInt = i;
        continue;
        localObject = paramContext.getApplicationInfo();
        if (((((ApplicationInfo)localObject).flags & 0x1) != 0) && ((((ApplicationInfo)localObject).flags & 0x80) == 0))
        {
          paramInt = 1;
          break label283;
          localArrayList.add(0, new ApkSoSource(paramContext, SO_STORE_NAME_MAIN, paramInt));
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      paramInt = 0;
      label275: label279: label283: 
      while (paramInt == 0)
      {
        i = 1;
        paramInt = 0;
        if (Build.VERSION.SDK_INT <= 17)
          paramInt = 0x0 | 0x1;
        localArrayList.add(0, new DirectorySoSource(new File(((ApplicationInfo)localObject).nativeLibraryDir), paramInt));
        paramInt = i;
        break;
        sSoSources = paramContext;
        monitorexit;
        return;
      }
      paramInt = 0;
    }
  }

  // ERROR //
  public static void loadLibrary(String paramString)
    throws UnsatisfiedLinkError
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 34	com/facebook/soloader/SoLoader:sSoSources	[Lcom/facebook/soloader/SoSource;
    //   6: ifnonnull +19 -> 25
    //   9: ldc 171
    //   11: ldc 173
    //   13: invokestatic 176	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifeq +18 -> 37
    //   22: invokestatic 181	com/facebook/soloader/SoLoader:assertInitialized	()V
    //   25: aload_0
    //   26: invokestatic 184	java/lang/System:mapLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   29: iconst_0
    //   30: invokestatic 188	com/facebook/soloader/SoLoader:loadLibraryBySoName	(Ljava/lang/String;I)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: invokestatic 190	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   41: goto -8 -> 33
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    //   50: astore_0
    //   51: new 52	java/lang/RuntimeException
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 81	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   59: athrow
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 194	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +21 -> 88
    //   70: aload_1
    //   71: ldc 196
    //   73: invokevirtual 200	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   76: ifeq +12 -> 88
    //   79: new 6	com/facebook/soloader/SoLoader$WrongAbiError
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 201	com/facebook/soloader/SoLoader$WrongAbiError:<init>	(Ljava/lang/Throwable;)V
    //   87: athrow
    //   88: aload_0
    //   89: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   3	25	44	finally
    //   25	33	44	finally
    //   37	41	44	finally
    //   51	60	44	finally
    //   61	66	44	finally
    //   70	88	44	finally
    //   88	90	44	finally
    //   25	33	50	java/io/IOException
    //   25	33	60	java/lang/UnsatisfiedLinkError
  }

  public static void loadLibraryBySoName(String paramString, int paramInt)
    throws IOException
  {
    int i;
    if (sLoadedLibraries.contains(paramString))
      i = 1;
    int k;
    while (true)
    {
      k = i;
      int j;
      if (i == 0)
      {
        j = 0;
        if (sOldPolicy == null)
        {
          sOldPolicy = StrictMode.allowThreadDiskReads();
          j = 1;
        }
        k = 0;
        label40: if (i != 0);
      }
      try
      {
        if (k < sSoSources.length)
        {
          i = sSoSources[k].loadLibrary(paramString, paramInt);
          k += 1;
          break label40;
          i = 0;
          continue;
        }
        k = i;
        if (j != 0)
        {
          StrictMode.setThreadPolicy(sOldPolicy);
          sOldPolicy = null;
          k = i;
        }
        if (k != 0)
          break;
        throw new UnsatisfiedLinkError("couldn't find DSO to load: " + paramString);
      }
      finally
      {
        if (j != 0)
        {
          StrictMode.setThreadPolicy(sOldPolicy);
          sOldPolicy = null;
        }
      }
    }
    if (k == 1)
      sLoadedLibraries.add(paramString);
  }

  public static String makeLdLibraryPath()
  {
    monitorenter;
    try
    {
      assertInitialized();
      Object localObject1 = new ArrayList();
      SoSource[] arrayOfSoSource = sSoSources;
      int i = 0;
      while (i < arrayOfSoSource.length)
      {
        arrayOfSoSource[i].addToLdLibraryPath((Collection)localObject1);
        i += 1;
      }
      localObject1 = TextUtils.join(":", (Iterable)localObject1);
      return localObject1;
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  private static int makePrepareFlags()
  {
    int i = 0;
    if ((sFlags & 0x2) != 0)
      i = 0x0 | 0x1;
    return i;
  }

  public static void prependSoSource(SoSource paramSoSource)
    throws IOException
  {
    monitorenter;
    try
    {
      assertInitialized();
      paramSoSource.prepare(makePrepareFlags());
      SoSource[] arrayOfSoSource = new SoSource[sSoSources.length + 1];
      arrayOfSoSource[0] = paramSoSource;
      System.arraycopy(sSoSources, 0, arrayOfSoSource, 1, sSoSources.length);
      sSoSources = arrayOfSoSource;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramSoSource;
  }

  public static void setInTestMode()
  {
    sSoSources = new SoSource[] { new NoopSoSource() };
  }

  public static File unpackLibraryAndDependencies(String paramString)
    throws UnsatisfiedLinkError
  {
    assertInitialized();
    try
    {
      paramString = unpackLibraryBySoName(System.mapLibraryName(paramString));
      return paramString;
    }
    catch (IOException paramString)
    {
    }
    throw new RuntimeException(paramString);
  }

  static File unpackLibraryBySoName(String paramString)
    throws IOException
  {
    int i = 0;
    while (i < sSoSources.length)
    {
      File localFile = sSoSources[i].unpackLibrary(paramString);
      if (localFile != null)
        return localFile;
      i += 1;
    }
    throw new FileNotFoundException(paramString);
  }

  public static final class WrongAbiError extends UnsatisfiedLinkError
  {
    WrongAbiError(Throwable paramThrowable)
    {
      super();
      initCause(paramThrowable);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.soloader.SoLoader
 * JD-Core Version:    0.6.0
 */