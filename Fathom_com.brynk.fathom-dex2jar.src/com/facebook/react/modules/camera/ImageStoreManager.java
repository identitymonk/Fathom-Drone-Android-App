package com.facebook.react.modules.camera;

import android.os.AsyncTask;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.io.Closeable;

@ReactModule(name="ImageStoreManager")
public class ImageStoreManager extends ReactContextBaseJavaModule
{
  private static final int BUFFER_SIZE = 8192;

  public ImageStoreManager(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private static void closeQuietly(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (java.io.IOException paramCloseable)
    {
    }
  }

  @ReactMethod
  public void getBase64ForTag(String paramString, Callback paramCallback1, Callback paramCallback2)
  {
    new GetBase64Task(getReactApplicationContext(), paramString, paramCallback1, paramCallback2, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public String getName()
  {
    return "ImageStoreManager";
  }

  private class GetBase64Task extends GuardedAsyncTask<Void, Void>
  {
    private final Callback mError;
    private final Callback mSuccess;
    private final String mUri;

    private GetBase64Task(ReactContext paramString, String paramCallback1, Callback paramCallback2, Callback arg5)
    {
      super();
      this.mUri = paramCallback1;
      this.mSuccess = paramCallback2;
      Object localObject;
      this.mError = localObject;
    }

    // ERROR //
    protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	com/facebook/react/modules/camera/ImageStoreManager$GetBase64Task:this$0	Lcom/facebook/react/modules/camera/ImageStoreManager;
      //   4: invokestatic 47	com/facebook/react/modules/camera/ImageStoreManager:access$100	(Lcom/facebook/react/modules/camera/ImageStoreManager;)Lcom/facebook/react/bridge/ReactApplicationContext;
      //   7: invokevirtual 53	com/facebook/react/bridge/ReactApplicationContext:getContentResolver	()Landroid/content/ContentResolver;
      //   10: aload_0
      //   11: getfield 24	com/facebook/react/modules/camera/ImageStoreManager$GetBase64Task:mUri	Ljava/lang/String;
      //   14: invokestatic 59	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   17: invokevirtual 65	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
      //   20: astore_1
      //   21: new 67	java/io/ByteArrayOutputStream
      //   24: dup
      //   25: invokespecial 70	java/io/ByteArrayOutputStream:<init>	()V
      //   28: astore 4
      //   30: new 72	android/util/Base64OutputStream
      //   33: dup
      //   34: aload 4
      //   36: iconst_0
      //   37: invokespecial 75	android/util/Base64OutputStream:<init>	(Ljava/io/OutputStream;I)V
      //   40: astore_3
      //   41: sipush 8192
      //   44: newarray byte
      //   46: astore 5
      //   48: aload_1
      //   49: aload 5
      //   51: invokevirtual 81	java/io/InputStream:read	([B)I
      //   54: istore_2
      //   55: iload_2
      //   56: iconst_m1
      //   57: if_icmple +46 -> 103
      //   60: aload_3
      //   61: aload 5
      //   63: iconst_0
      //   64: iload_2
      //   65: invokevirtual 85	android/util/Base64OutputStream:write	([BII)V
      //   68: goto -20 -> 48
      //   71: astore 4
      //   73: aload_0
      //   74: getfield 28	com/facebook/react/modules/camera/ImageStoreManager$GetBase64Task:mError	Lcom/facebook/react/bridge/Callback;
      //   77: iconst_1
      //   78: anewarray 87	java/lang/Object
      //   81: dup
      //   82: iconst_0
      //   83: aload 4
      //   85: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
      //   88: aastore
      //   89: invokeinterface 96 2 0
      //   94: aload_1
      //   95: invokestatic 100	com/facebook/react/modules/camera/ImageStoreManager:access$200	(Ljava/io/Closeable;)V
      //   98: aload_3
      //   99: invokestatic 100	com/facebook/react/modules/camera/ImageStoreManager:access$200	(Ljava/io/Closeable;)V
      //   102: return
      //   103: aload_0
      //   104: getfield 26	com/facebook/react/modules/camera/ImageStoreManager$GetBase64Task:mSuccess	Lcom/facebook/react/bridge/Callback;
      //   107: iconst_1
      //   108: anewarray 87	java/lang/Object
      //   111: dup
      //   112: iconst_0
      //   113: aload 4
      //   115: invokevirtual 103	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
      //   118: aastore
      //   119: invokeinterface 96 2 0
      //   124: aload_1
      //   125: invokestatic 100	com/facebook/react/modules/camera/ImageStoreManager:access$200	(Ljava/io/Closeable;)V
      //   128: aload_3
      //   129: invokestatic 100	com/facebook/react/modules/camera/ImageStoreManager:access$200	(Ljava/io/Closeable;)V
      //   132: return
      //   133: astore_1
      //   134: aload_0
      //   135: getfield 28	com/facebook/react/modules/camera/ImageStoreManager$GetBase64Task:mError	Lcom/facebook/react/bridge/Callback;
      //   138: iconst_1
      //   139: anewarray 87	java/lang/Object
      //   142: dup
      //   143: iconst_0
      //   144: aload_1
      //   145: invokevirtual 104	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
      //   148: aastore
      //   149: invokeinterface 96 2 0
      //   154: return
      //   155: astore 4
      //   157: aload_1
      //   158: invokestatic 100	com/facebook/react/modules/camera/ImageStoreManager:access$200	(Ljava/io/Closeable;)V
      //   161: aload_3
      //   162: invokestatic 100	com/facebook/react/modules/camera/ImageStoreManager:access$200	(Ljava/io/Closeable;)V
      //   165: aload 4
      //   167: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   48	55	71	java/io/IOException
      //   60	68	71	java/io/IOException
      //   103	124	71	java/io/IOException
      //   0	48	133	java/io/FileNotFoundException
      //   94	102	133	java/io/FileNotFoundException
      //   124	132	133	java/io/FileNotFoundException
      //   157	168	133	java/io/FileNotFoundException
      //   48	55	155	finally
      //   60	68	155	finally
      //   73	94	155	finally
      //   103	124	155	finally
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.camera.ImageStoreManager
 * JD-Core Version:    0.6.0
 */