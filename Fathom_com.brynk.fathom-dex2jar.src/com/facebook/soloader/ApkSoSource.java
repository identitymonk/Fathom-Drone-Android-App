package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;

public class ApkSoSource extends ExtractFromZipSoSource
{
  private static final byte APK_SIGNATURE_VERSION = 1;
  public static final int PREFER_ANDROID_LIBS_DIRECTORY = 1;
  private static final String TAG = "ApkSoSource";
  private final int mFlags;

  public ApkSoSource(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, new File(paramContext.getApplicationInfo().sourceDir), "^lib/([^/]+)/([^/]+\\.so)$");
    this.mFlags = paramInt;
  }

  protected byte[] getDepsBlock()
    throws IOException
  {
    return SysUtil.makeApkDepBlock(this.mZipFileName);
  }

  protected UnpackingSoSource.Unpacker makeUnpacker()
    throws IOException
  {
    return new ApkUnpacker();
  }

  protected class ApkUnpacker extends ExtractFromZipSoSource.ZipUnpacker
  {
    private final int mFlags = ApkSoSource.this.mFlags;
    private File mLibDir = new File(ApkSoSource.this.mContext.getApplicationInfo().nativeLibraryDir);

    ApkUnpacker()
      throws IOException
    {
      super();
    }

    protected boolean shouldExtract(ZipEntry paramZipEntry, String paramString)
    {
      String str = paramZipEntry.getName();
      if ((this.mFlags & 0x1) == 0)
      {
        Log.d("ApkSoSource", "allowing consideration of " + str + ": self-extraction preferred");
        return true;
      }
      File localFile = new File(this.mLibDir, paramString);
      if (!localFile.isFile())
      {
        Log.d("ApkSoSource", String.format("allowing considering of %s: %s not in system lib dir", new Object[] { str, paramString }));
        return true;
      }
      long l1 = localFile.length();
      long l2 = paramZipEntry.getSize();
      if (l1 != l2)
      {
        Log.d("ApkSoSource", String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", new Object[] { localFile, Long.valueOf(l1), Long.valueOf(l2) }));
        return true;
      }
      Log.d("ApkSoSource", "not allowing consideration of " + str + ": deferring to libdir");
      return false;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.soloader.ApkSoSource
 * JD-Core Version:    0.6.0
 */