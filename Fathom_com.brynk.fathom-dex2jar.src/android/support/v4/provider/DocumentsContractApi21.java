package android.support.v4.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

class DocumentsContractApi21
{
  private static final String TAG = "DocumentFile";

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

  public static Uri createDirectory(Context paramContext, Uri paramUri, String paramString)
  {
    return createFile(paramContext, paramUri, "vnd.android.document/directory", paramString);
  }

  public static Uri createFile(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    return DocumentsContract.createDocument(paramContext.getContentResolver(), paramUri, paramString1, paramString2);
  }

  public static Uri[] listFiles(Context paramContext, Uri paramUri)
  {
    Object localObject2 = paramContext.getContentResolver();
    Uri localUri = DocumentsContract.buildChildDocumentsUriUsingTree(paramUri, DocumentsContract.getDocumentId(paramUri));
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    paramContext = null;
    try
    {
      localObject2 = ((ContentResolver)localObject2).query(localUri, new String[] { "document_id" }, null, null, null);
      while (true)
      {
        paramContext = (Context)localObject2;
        localObject1 = localObject2;
        if (!((Cursor)localObject2).moveToNext())
          break;
        paramContext = (Context)localObject2;
        localObject1 = localObject2;
        localArrayList.add(DocumentsContract.buildDocumentUriUsingTree(paramUri, ((Cursor)localObject2).getString(0)));
      }
    }
    catch (java.lang.Exception paramUri)
    {
      localObject1 = paramContext;
      Log.w("DocumentFile", "Failed query: " + paramUri);
      closeQuietly(paramContext);
      while (true)
      {
        return (Uri[])localArrayList.toArray(new Uri[localArrayList.size()]);
        closeQuietly((AutoCloseable)localObject2);
      }
    }
    finally
    {
      closeQuietly((AutoCloseable)localObject1);
    }
    throw paramContext;
  }

  public static Uri prepareTreeUri(Uri paramUri)
  {
    return DocumentsContract.buildDocumentUriUsingTree(paramUri, DocumentsContract.getTreeDocumentId(paramUri));
  }

  public static Uri renameTo(Context paramContext, Uri paramUri, String paramString)
  {
    return DocumentsContract.renameDocument(paramContext.getContentResolver(), paramUri, paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.provider.DocumentsContractApi21
 * JD-Core Version:    0.6.0
 */