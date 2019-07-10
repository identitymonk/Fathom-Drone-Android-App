package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.Method;

public final class RouteException extends RuntimeException
{
  private static final Method addSuppressedExceptionMethod;
  private IOException lastException;

  static
  {
    try
    {
      Method localMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      addSuppressedExceptionMethod = localMethod;
      return;
    }
    catch (Exception localObject)
    {
      while (true)
        Object localObject = null;
    }
  }

  public RouteException(IOException paramIOException)
  {
    super(paramIOException);
    this.lastException = paramIOException;
  }

  private void addSuppressedIfPossible(IOException paramIOException1, IOException paramIOException2)
  {
    if (addSuppressedExceptionMethod != null);
    try
    {
      addSuppressedExceptionMethod.invoke(paramIOException1, new Object[] { paramIOException2 });
      return;
    }
    catch (java.lang.IllegalAccessException paramIOException1)
    {
      return;
    }
    catch (java.lang.reflect.InvocationTargetException paramIOException1)
    {
    }
  }

  public void addConnectException(IOException paramIOException)
  {
    addSuppressedIfPossible(paramIOException, this.lastException);
    this.lastException = paramIOException;
  }

  public IOException getLastConnectException()
  {
    return this.lastException;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.connection.RouteException
 * JD-Core Version:    0.6.0
 */