package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class FileIoHandler
  implements Runnable
{
  private static final long FILE_TTL = 30000L;
  private static final String TAG = JSPackagerClient.class.getSimpleName();
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private int mNextHandle = 1;
  private final Map<Integer, TtlFileInputStream> mOpenFiles = new HashMap();
  private final Map<String, RequestHandler> mRequestHandlers = new HashMap();

  public FileIoHandler()
  {
    this.mRequestHandlers.put("fopen", new RequestOnlyHandler()
    {
      public void onRequest(@Nullable Object paramObject, Responder paramResponder)
      {
        while (true)
        {
          synchronized (FileIoHandler.this.mOpenFiles)
          {
            try
            {
              localObject = (JSONObject)paramObject;
              if (localObject != null)
                continue;
              throw new Exception("params must be an object { mode: string, filename: string }");
            }
            catch (Exception paramObject)
            {
              paramResponder.error(paramObject.toString());
            }
            return;
            paramObject = ((JSONObject)localObject).optString("mode");
            if (paramObject == null)
              throw new Exception("missing params.mode");
          }
          Object localObject = ((JSONObject)localObject).optString("filename");
          if (localObject == null)
            throw new Exception("missing params.filename");
          if (!paramObject.equals("r"))
            throw new IllegalArgumentException("unsupported mode: " + paramObject);
          paramResponder.respond(Integer.valueOf(FileIoHandler.this.addOpenFile((String)localObject)));
        }
      }
    });
    this.mRequestHandlers.put("fclose", new RequestOnlyHandler()
    {
      public void onRequest(@Nullable Object paramObject, Responder paramResponder)
      {
        while (true)
        {
          FileIoHandler.TtlFileInputStream localTtlFileInputStream;
          synchronized (FileIoHandler.this.mOpenFiles)
          {
            try
            {
              if ((paramObject instanceof Number))
                continue;
              throw new Exception("params must be a file handle");
            }
            catch (Exception paramObject)
            {
              paramResponder.error(paramObject.toString());
            }
            return;
            localTtlFileInputStream = (FileIoHandler.TtlFileInputStream)FileIoHandler.this.mOpenFiles.get(Integer.valueOf(((Integer)paramObject).intValue()));
            if (localTtlFileInputStream == null)
              throw new Exception("invalid file handle, it might have timed out");
          }
          FileIoHandler.this.mOpenFiles.remove(Integer.valueOf(((Integer)paramObject).intValue()));
          localTtlFileInputStream.close();
          paramResponder.respond("");
        }
      }
    });
    this.mRequestHandlers.put("fread", new RequestOnlyHandler()
    {
      public void onRequest(@Nullable Object paramObject, Responder paramResponder)
      {
        while (true)
        {
          int i;
          synchronized (FileIoHandler.this.mOpenFiles)
          {
            try
            {
              paramObject = (JSONObject)paramObject;
              if (paramObject != null)
                continue;
              throw new Exception("params must be an object { file: handle, size: number }");
            }
            catch (Exception paramObject)
            {
              paramResponder.error(paramObject.toString());
            }
            return;
            i = paramObject.optInt("file");
            if (i == 0)
              throw new Exception("invalid or missing file handle");
          }
          int j = paramObject.optInt("size");
          if (j == 0)
            throw new Exception("invalid or missing read size");
          paramObject = (FileIoHandler.TtlFileInputStream)FileIoHandler.this.mOpenFiles.get(Integer.valueOf(i));
          if (paramObject == null)
            throw new Exception("invalid file handle, it might have timed out");
          paramResponder.respond(paramObject.read(j));
        }
      }
    });
  }

  private int addOpenFile(String paramString)
    throws FileNotFoundException
  {
    int i = this.mNextHandle;
    this.mNextHandle = (i + 1);
    this.mOpenFiles.put(Integer.valueOf(i), new TtlFileInputStream(paramString));
    if (this.mOpenFiles.size() == 1)
      this.mHandler.postDelayed(this, 30000L);
    return i;
  }

  public Map<String, RequestHandler> handlers()
  {
    return this.mRequestHandlers;
  }

  public void run()
  {
    synchronized (this.mOpenFiles)
    {
      Iterator localIterator = this.mOpenFiles.values().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          TtlFileInputStream localTtlFileInputStream = (TtlFileInputStream)localIterator.next();
          if (!localTtlFileInputStream.expiredTtl())
            continue;
          localIterator.remove();
          try
          {
            localTtlFileInputStream.close();
          }
          catch (IOException localIOException)
          {
            FLog.e(TAG, "closing expired file failed: " + localIOException.toString());
          }
        }
    }
    if (!this.mOpenFiles.isEmpty())
      this.mHandler.postDelayed(this, 30000L);
    monitorexit;
  }

  private static class TtlFileInputStream
  {
    private final FileInputStream mStream;
    private long mTtl;

    public TtlFileInputStream(String paramString)
      throws FileNotFoundException
    {
      this.mStream = new FileInputStream(paramString);
      this.mTtl = (System.currentTimeMillis() + 30000L);
    }

    private void extendTtl()
    {
      this.mTtl = (System.currentTimeMillis() + 30000L);
    }

    public void close()
      throws IOException
    {
      this.mStream.close();
    }

    public boolean expiredTtl()
    {
      return System.currentTimeMillis() >= this.mTtl;
    }

    public String read(int paramInt)
      throws IOException
    {
      extendTtl();
      byte[] arrayOfByte = new byte[paramInt];
      return Base64.encodeToString(arrayOfByte, 0, this.mStream.read(arrayOfByte), 0);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.packagerconnection.FileIoHandler
 * JD-Core Version:    0.6.0
 */