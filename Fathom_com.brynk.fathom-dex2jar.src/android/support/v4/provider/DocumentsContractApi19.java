package android.support.v4.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

class DocumentsContractApi19
{
  private static final String TAG = "DocumentFile";

  public static boolean canRead(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) != 0);
    do
      return false;
    while (TextUtils.isEmpty(getRawType(paramContext, paramUri)));
    return true;
  }

  public static boolean canWrite(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) != 0);
    String str;
    int i;
    do
    {
      do
      {
        return false;
        str = getRawType(paramContext, paramUri);
        i = queryForInt(paramContext, paramUri, "flags", 0);
      }
      while (TextUtils.isEmpty(str));
      if ((i & 0x4) != 0)
        return true;
      if (("vnd.android.document/directory".equals(str)) && ((i & 0x8) != 0))
        return true;
    }
    while ((TextUtils.isEmpty(str)) || ((i & 0x2) == 0));
    return true;
  }

  private static void closeQuietly(AutoCloseable paramAutoCloseable)
  {
    if (paramAutoCloseable != null);
    try
    {
      paramAutoCloseable.close();
      return;
    }
    catch (java.lang.RuntimeException paramAutoCloseable)
    {
      throw paramAutoCloseable;
    }
    catch (java.lang.Exception paramAutoCloseable)
    {
    }
  }

  public static boolean delete(Context paramContext, Uri paramUri)
  {
    return DocumentsContract.deleteDocument(paramContext.getContentResolver(), paramUri);
  }

  public static boolean exists(Context paramContext, Uri paramUri)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject = null;
    paramContext = null;
    try
    {
      paramUri = localContentResolver.query(paramUri, new String[] { "document_id" }, null, null, null);
      paramContext = paramUri;
      localObject = paramUri;
      int i = paramUri.getCount();
      if (i > 0);
      for (int j = 1; ; j = 0)
      {
        closeQuietly(paramUri);
        return j;
      }
    }
    catch (java.lang.Exception paramUri)
    {
      localObject = paramContext;
      Log.w("DocumentFile", "Failed query: " + paramUri);
      closeQuietly(paramContext);
      return false;
    }
    finally
    {
      closeQuietly((AutoCloseable)localObject);
    }
    throw paramContext;
  }

  public static String getName(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "_display_name", null);
  }

  private static String getRawType(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "mime_type", null);
  }

  public static String getType(Context paramContext, Uri paramUri)
  {
    paramUri = getRawType(paramContext, paramUri);
    paramContext = paramUri;
    if ("vnd.android.document/directory".equals(paramUri))
      paramContext = null;
    return paramContext;
  }

  public static boolean isDirectory(Context paramContext, Uri paramUri)
  {
    return "vnd.android.document/directory".equals(getRawType(paramContext, paramUri));
  }

  public static boolean isDocumentUri(Context paramContext, Uri paramUri)
  {
    return DocumentsContract.isDocumentUri(paramContext, paramUri);
  }

  public static boolean isFile(Context paramContext, Uri paramUri)
  {
    paramContext = getRawType(paramContext, paramUri);
    return (!"vnd.android.document/directory".equals(paramContext)) && (!TextUtils.isEmpty(paramContext));
  }

  public static long lastModified(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "last_modified", 0L);
  }

  public static long length(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "_size", 0L);
  }

  private static int queryForInt(Context paramContext, Uri paramUri, String paramString, int paramInt)
  {
    return (int)queryForLong(paramContext, paramUri, paramString, paramInt);
  }

  private static long queryForLong(Context paramContext, Uri paramUri, String paramString, long paramLong)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject = null;
    paramContext = null;
    try
    {
      paramUri = localContentResolver.query(paramUri, new String[] { paramString }, null, null, null);
      paramContext = paramUri;
      localObject = paramUri;
      if (paramUri.moveToFirst())
      {
        paramContext = paramUri;
        localObject = paramUri;
        if (!paramUri.isNull(0))
        {
          paramContext = paramUri;
          localObject = paramUri;
          long l = paramUri.getLong(0);
          closeQuietly(paramUri);
          return l;
        }
      }
      closeQuietly(paramUri);
      return paramLong;
    }
    catch (java.lang.Exception paramUri)
    {
      localObject = paramContext;
      Log.w("DocumentFile", "Failed query: " + paramUri);
      closeQuietly(paramContext);
      return paramLong;
    }
    finally
    {
      closeQuietly((AutoCloseable)localObject);
    }
    throw paramContext;
  }

  private static String queryForString(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject = null;
    paramContext = null;
    try
    {
      paramUri = localContentResolver.query(paramUri, new String[] { paramString1 }, null, null, null);
      paramContext = paramUri;
      localObject = paramUri;
      if (paramUri.moveToFirst())
      {
        paramContext = paramUri;
        localObject = paramUri;
        if (!paramUri.isNull(0))
        {
          paramContext = paramUri;
          localObject = paramUri;
          paramString1 = paramUri.getString(0);
          closeQuietly(paramUri);
          return paramString1;
        }
      }
      closeQuietly(paramUri);
      return paramString2;
    }
    catch (java.lang.Exception paramUri)
    {
      localObject = paramContext;
      Log.w("DocumentFile", "Failed query: " + paramUri);
      closeQuietly(paramContext);
      return paramString2;
    }
    finally
    {
      closeQuietly((AutoCloseable)localObject);
    }
    throw paramContext;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.provider.DocumentsContractApi19
 * JD-Core Version:    0.6.0
 */