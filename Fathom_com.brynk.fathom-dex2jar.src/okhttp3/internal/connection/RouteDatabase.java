package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

public final class RouteDatabase
{
  private final Set<Route> failedRoutes = new LinkedHashSet();

  public void connected(Route paramRoute)
  {
    monitorenter;
    try
    {
      this.failedRoutes.remove(paramRoute);
      monitorexit;
      return;
    }
    finally
    {
      paramRoute = finally;
      monitorexit;
    }
    throw paramRoute;
  }

  public void failed(Route paramRoute)
  {
    monitorenter;
    try
    {
      this.failedRoutes.add(paramRoute);
      monitorexit;
      return;
    }
    finally
    {
      paramRoute = finally;
      monitorexit;
    }
    throw paramRoute;
  }

  public boolean shouldPostpone(Route paramRoute)
  {
    monitorenter;
    try
    {
      boolean bool = this.failedRoutes.contains(paramRoute);
      monitorexit;
      return bool;
    }
    finally
    {
      paramRoute = finally;
      monitorexit;
    }
    throw paramRoute;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.connection.RouteDatabase
 * JD-Core Version:    0.6.0
 */