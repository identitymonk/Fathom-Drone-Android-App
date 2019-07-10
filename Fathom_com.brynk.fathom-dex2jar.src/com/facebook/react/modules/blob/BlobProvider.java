package com.facebook.react.modules.blob;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

public final class BlobProvider extends ContentProvider
{
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
    return true;
  }

  // ERROR //
  public android.os.ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws java.io.FileNotFoundException
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 27
    //   3: invokevirtual 33	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +47 -> 53
    //   9: new 23	java/io/FileNotFoundException
    //   12: dup
    //   13: new 35	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   20: ldc 38
    //   22: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 48	android/net/Uri:toString	()Ljava/lang/String;
    //   29: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 50
    //   34: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 52
    //   43: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 56	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   52: athrow
    //   53: aconst_null
    //   54: astore_2
    //   55: aload_0
    //   56: invokevirtual 60	com/facebook/react/modules/blob/BlobProvider:getContext	()Landroid/content/Context;
    //   59: invokevirtual 65	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   62: astore_3
    //   63: aload_3
    //   64: instanceof 67
    //   67: ifeq +27 -> 94
    //   70: aload_3
    //   71: checkcast 67	com/facebook/react/ReactApplication
    //   74: invokeinterface 71 1 0
    //   79: invokevirtual 77	com/facebook/react/ReactNativeHost:getReactInstanceManager	()Lcom/facebook/react/ReactInstanceManager;
    //   82: invokevirtual 83	com/facebook/react/ReactInstanceManager:getCurrentReactContext	()Lcom/facebook/react/bridge/ReactContext;
    //   85: ldc 85
    //   87: invokevirtual 91	com/facebook/react/bridge/ReactContext:getNativeModule	(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;
    //   90: checkcast 85	com/facebook/react/modules/blob/BlobModule
    //   93: astore_2
    //   94: aload_2
    //   95: ifnonnull +13 -> 108
    //   98: new 93	java/lang/RuntimeException
    //   101: dup
    //   102: ldc 95
    //   104: invokespecial 96	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   107: athrow
    //   108: aload_2
    //   109: aload_1
    //   110: invokevirtual 100	com/facebook/react/modules/blob/BlobModule:resolve	(Landroid/net/Uri;)[B
    //   113: astore_2
    //   114: aload_2
    //   115: ifnonnull +38 -> 153
    //   118: new 23	java/io/FileNotFoundException
    //   121: dup
    //   122: new 35	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   129: ldc 38
    //   131: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_1
    //   135: invokevirtual 48	android/net/Uri:toString	()Ljava/lang/String;
    //   138: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 102
    //   143: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokespecial 56	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   152: athrow
    //   153: invokestatic 108	android/os/ParcelFileDescriptor:createPipe	()[Landroid/os/ParcelFileDescriptor;
    //   156: astore_3
    //   157: aload_3
    //   158: iconst_0
    //   159: aaload
    //   160: astore_1
    //   161: new 110	android/os/ParcelFileDescriptor$AutoCloseOutputStream
    //   164: dup
    //   165: aload_3
    //   166: iconst_1
    //   167: aaload
    //   168: invokespecial 113	android/os/ParcelFileDescriptor$AutoCloseOutputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   171: astore_3
    //   172: aload_3
    //   173: aload_2
    //   174: invokevirtual 119	java/io/OutputStream:write	([B)V
    //   177: aload_3
    //   178: invokevirtual 122	java/io/OutputStream:close	()V
    //   181: aload_1
    //   182: areturn
    //   183: astore_1
    //   184: aconst_null
    //   185: areturn
    //   186: astore_1
    //   187: aconst_null
    //   188: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   153	157	183	java/io/IOException
    //   172	181	186	java/io/IOException
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
 * Qualified Name:     com.facebook.react.modules.blob.BlobProvider
 * JD-Core Version:    0.6.0
 */