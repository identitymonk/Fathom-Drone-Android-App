package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import java.lang.reflect.Constructor;
import java.util.List;

class ParceledListSliceAdapterApi21
{
  private static Constructor sConstructor;

  static
  {
    try
    {
      sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(new Class[] { List.class });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label22: break label22;
    }
  }

  static Object newInstance(List<MediaBrowser.MediaItem> paramList)
  {
    try
    {
      paramList = sConstructor.newInstance(new Object[] { paramList });
      return paramList;
    }
    catch (java.lang.InstantiationException paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    catch (java.lang.IllegalAccessException paramList)
    {
      break label18;
    }
    catch (java.lang.reflect.InvocationTargetException paramList)
    {
      label18: break label18;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.media.ParceledListSliceAdapterApi21
 * JD-Core Version:    0.6.0
 */