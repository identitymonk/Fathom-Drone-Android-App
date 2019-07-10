package com.facebook.react.devsupport;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public class MultipartStreamReader
{
  private static final String CRLF = "\r\n";
  private final String mBoundary;
  private final BufferedSource mSource;

  public MultipartStreamReader(BufferedSource paramBufferedSource, String paramString)
  {
    this.mSource = paramBufferedSource;
    this.mBoundary = paramString;
  }

  private void emitChunk(Buffer paramBuffer, boolean paramBoolean, ChunkCallback paramChunkCallback)
    throws IOException
  {
    ByteString localByteString = ByteString.encodeUtf8("\r\n\r\n");
    long l = paramBuffer.indexOf(localByteString);
    if (l == -1L)
    {
      paramChunkCallback.execute(null, paramBuffer, paramBoolean);
      return;
    }
    Buffer localBuffer1 = new Buffer();
    Buffer localBuffer2 = new Buffer();
    paramBuffer.read(localBuffer1, l);
    paramBuffer.skip(localByteString.size());
    paramBuffer.readAll(localBuffer2);
    paramChunkCallback.execute(parseHeaders(localBuffer1), localBuffer2, paramBoolean);
  }

  private Map<String, String> parseHeaders(Buffer paramBuffer)
  {
    HashMap localHashMap = new HashMap();
    paramBuffer = paramBuffer.readUtf8().split("\r\n");
    int j = paramBuffer.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramBuffer[i];
      int k = localObject.indexOf(":");
      if (k == -1);
      while (true)
      {
        i += 1;
        break;
        localHashMap.put(localObject.substring(0, k).trim(), localObject.substring(k + 1).trim());
      }
    }
    return localHashMap;
  }

  public boolean readAllParts(ChunkCallback paramChunkCallback)
    throws IOException
  {
    ByteString localByteString1 = ByteString.encodeUtf8("\r\n--" + this.mBoundary + "\r\n");
    ByteString localByteString2 = ByteString.encodeUtf8("\r\n--" + this.mBoundary + "--" + "\r\n");
    long l2 = 0L;
    long l1 = 0L;
    Buffer localBuffer1 = new Buffer();
    while (true)
    {
      boolean bool = false;
      long l4 = Math.max(l1 - localByteString2.size(), l2);
      long l3 = localBuffer1.indexOf(localByteString1, l4);
      l1 = l3;
      if (l3 == -1L)
      {
        bool = true;
        l1 = localBuffer1.indexOf(localByteString2, l4);
      }
      if (l1 == -1L)
      {
        l1 = localBuffer1.size();
        if (this.mSource.read(localBuffer1, 4096) <= 0L)
          return false;
      }
      if (l2 > 0L)
      {
        Buffer localBuffer2 = new Buffer();
        localBuffer1.skip(l2);
        localBuffer1.read(localBuffer2, l1 - l2);
        emitChunk(localBuffer2, bool, paramChunkCallback);
      }
      while (bool)
      {
        return true;
        localBuffer1.skip(l1);
      }
      l2 = localByteString1.size();
      l1 = l2;
    }
  }

  public static abstract interface ChunkCallback
  {
    public abstract void execute(Map<String, String> paramMap, Buffer paramBuffer, boolean paramBoolean)
      throws IOException;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.MultipartStreamReader
 * JD-Core Version:    0.6.0
 */