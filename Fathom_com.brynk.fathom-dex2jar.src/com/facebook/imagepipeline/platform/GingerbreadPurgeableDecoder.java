package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.MemoryFile;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import java.io.FileDescriptor;
import java.lang.reflect.Method;

public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder
{
  private static Method sGetFileDescriptorMethod;

  // ERROR //
  private static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, @javax.annotation.Nullable byte[] paramArrayOfByte)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +125 -> 126
    //   4: iconst_0
    //   5: istore_3
    //   6: new 18	android/os/MemoryFile
    //   9: dup
    //   10: aconst_null
    //   11: iload_1
    //   12: iload_3
    //   13: iadd
    //   14: invokespecial 21	android/os/MemoryFile:<init>	(Ljava/lang/String;I)V
    //   17: astore 9
    //   19: aload 9
    //   21: iconst_0
    //   22: invokevirtual 25	android/os/MemoryFile:allowPurging	(Z)Z
    //   25: pop
    //   26: aconst_null
    //   27: astore 8
    //   29: aconst_null
    //   30: astore 7
    //   32: aconst_null
    //   33: astore 4
    //   35: aconst_null
    //   36: astore 6
    //   38: new 27	com/facebook/common/memory/PooledByteBufferInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokevirtual 33	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   46: checkcast 35	com/facebook/common/memory/PooledByteBuffer
    //   49: invokespecial 38	com/facebook/common/memory/PooledByteBufferInputStream:<init>	(Lcom/facebook/common/memory/PooledByteBuffer;)V
    //   52: astore 5
    //   54: new 40	com/facebook/common/streams/LimitedInputStream
    //   57: dup
    //   58: aload 5
    //   60: iload_1
    //   61: invokespecial 43	com/facebook/common/streams/LimitedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   64: astore 8
    //   66: aload 9
    //   68: invokevirtual 47	android/os/MemoryFile:getOutputStream	()Ljava/io/OutputStream;
    //   71: astore 6
    //   73: aload 6
    //   75: astore 4
    //   77: aload 8
    //   79: aload 6
    //   81: invokestatic 53	com/facebook/common/internal/ByteStreams:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   84: pop2
    //   85: aload_2
    //   86: ifnull +17 -> 103
    //   89: aload 6
    //   91: astore 4
    //   93: aload 9
    //   95: aload_2
    //   96: iconst_0
    //   97: iload_1
    //   98: aload_2
    //   99: arraylength
    //   100: invokevirtual 57	android/os/MemoryFile:writeBytes	([BIII)V
    //   103: aload_0
    //   104: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   107: aload 5
    //   109: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   112: aload 8
    //   114: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   117: aload 6
    //   119: iconst_1
    //   120: invokestatic 71	com/facebook/common/internal/Closeables:close	(Ljava/io/Closeable;Z)V
    //   123: aload 9
    //   125: areturn
    //   126: aload_2
    //   127: arraylength
    //   128: istore_3
    //   129: goto -123 -> 6
    //   132: astore 4
    //   134: aload 8
    //   136: astore_2
    //   137: aload 7
    //   139: astore 5
    //   141: aload_0
    //   142: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   145: aload_2
    //   146: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   149: aload 5
    //   151: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   154: aload 6
    //   156: iconst_1
    //   157: invokestatic 71	com/facebook/common/internal/Closeables:close	(Ljava/io/Closeable;Z)V
    //   160: aload 4
    //   162: athrow
    //   163: astore 4
    //   165: aload 5
    //   167: astore_2
    //   168: aload 7
    //   170: astore 5
    //   172: goto -31 -> 141
    //   175: astore 7
    //   177: aload 8
    //   179: astore 6
    //   181: aload 5
    //   183: astore_2
    //   184: aload 6
    //   186: astore 5
    //   188: aload 4
    //   190: astore 6
    //   192: aload 7
    //   194: astore 4
    //   196: goto -55 -> 141
    //
    // Exception table:
    //   from	to	target	type
    //   38	54	132	finally
    //   54	66	163	finally
    //   66	73	175	finally
    //   77	85	175	finally
    //   93	103	175	finally
  }

  private Method getFileDescriptorMethod()
  {
    monitorenter;
    try
    {
      Method localMethod = sGetFileDescriptorMethod;
      if (localMethod == null);
      try
      {
        sGetFileDescriptorMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
        localMethod = sGetFileDescriptorMethod;
        monitorexit;
        return localMethod;
      }
      catch (Exception localException)
      {
        throw Throwables.propagate(localException);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private FileDescriptor getMemoryFileDescriptor(MemoryFile paramMemoryFile)
  {
    try
    {
      paramMemoryFile = (FileDescriptor)getFileDescriptorMethod().invoke(paramMemoryFile, new Object[0]);
      return paramMemoryFile;
    }
    catch (Exception paramMemoryFile)
    {
    }
    throw Throwables.propagate(paramMemoryFile);
  }

  protected Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, BitmapFactory.Options paramOptions)
  {
    return decodeFileDescriptorAsPurgeable(paramCloseableReference, ((PooledByteBuffer)paramCloseableReference.get()).size(), null, paramOptions);
  }

  protected Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, byte[] paramArrayOfByte, BitmapFactory.Options paramOptions)
  {
    Object localObject = null;
    CloseableReference<PooledByteBuffer> localCloseableReference = null;
    try
    {
      paramCloseableReference = copyToMemoryFile(paramCloseableReference, paramInt, paramArrayOfByte);
      localCloseableReference = paramCloseableReference;
      localObject = paramCloseableReference;
      paramArrayOfByte = getMemoryFileDescriptor(paramCloseableReference);
      localCloseableReference = paramCloseableReference;
      localObject = paramCloseableReference;
      paramArrayOfByte = (Bitmap)Preconditions.checkNotNull(WebpSupportStatus.sWebpBitmapFactory.decodeFileDescriptor(paramArrayOfByte, null, paramOptions), "BitmapFactory returned null");
      if (paramCloseableReference != null)
        paramCloseableReference.close();
      return paramArrayOfByte;
    }
    catch (java.io.IOException paramCloseableReference)
    {
      localObject = localCloseableReference;
      throw Throwables.propagate(paramCloseableReference);
    }
    finally
    {
      if (localObject != null)
        ((MemoryFile)localObject).close();
    }
    throw paramCloseableReference;
  }

  protected Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions)
  {
    if (endsWithEOI(paramCloseableReference, paramInt));
    for (byte[] arrayOfByte = null; ; arrayOfByte = EOI)
      return decodeFileDescriptorAsPurgeable(paramCloseableReference, paramInt, arrayOfByte, paramOptions);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder
 * JD-Core Version:    0.6.0
 */