package com.google.android.gms.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class zzaqa
{
  public static zzaqa bo()
  {
    try
    {
      Object localObject1 = Class.forName("sun.misc.Unsafe");
      Object localObject4 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject4).setAccessible(true);
      localObject4 = ((Field)localObject4).get(null);
      localObject1 = new zzaqa(((Class)localObject1).getMethod("allocateInstance", new Class[] { Class.class }), localObject4)
      {
        public <T> T zzf(Class<T> paramClass)
          throws Exception
        {
          return this.bpC.invoke(this.bpD, new Object[] { paramClass });
        }
      };
      return localObject1;
    }
    catch (Exception localException3)
    {
      try
      {
        Object localObject2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
        ((Method)localObject2).setAccessible(true);
        int i = ((Integer)((Method)localObject2).invoke(null, new Object[] { Object.class })).intValue();
        localObject2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
        ((Method)localObject2).setAccessible(true);
        localObject2 = new zzaqa((Method)localObject2, i)
        {
          public <T> T zzf(Class<T> paramClass)
            throws Exception
          {
            return this.bpE.invoke(null, new Object[] { paramClass, Integer.valueOf(this.bpF) });
          }
        };
        return localObject2;
      }
      catch (Exception localException3)
      {
        try
        {
          Object localObject3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
          ((Method)localObject3).setAccessible(true);
          localObject3 = new zzaqa((Method)localObject3)
          {
            public <T> T zzf(Class<T> paramClass)
              throws Exception
            {
              return this.bpE.invoke(null, new Object[] { paramClass, Object.class });
            }
          };
          return localObject3;
        }
        catch (Exception localException3)
        {
        }
      }
    }
    return (zzaqa)(zzaqa)(zzaqa)(zzaqa)new zzaqa()
    {
      public <T> T zzf(Class<T> paramClass)
      {
        paramClass = String.valueOf(paramClass);
        throw new UnsupportedOperationException(String.valueOf(paramClass).length() + 16 + "Cannot allocate " + paramClass);
      }
    };
  }

  public abstract <T> T zzf(Class<T> paramClass)
    throws Exception;
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqa
 * JD-Core Version:    0.6.0
 */