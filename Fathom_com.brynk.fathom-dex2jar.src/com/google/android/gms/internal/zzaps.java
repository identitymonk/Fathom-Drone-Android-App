package com.google.android.gms.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class zzaps
{
  private final Map<Type, zzaou<?>> bop;

  public zzaps(Map<Type, zzaou<?>> paramMap)
  {
    this.bop = paramMap;
  }

  private <T> zzapx<T> zzc(Type paramType, Class<? super T> paramClass)
  {
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (SortedSet.class.isAssignableFrom(paramClass))
        return new zzapx()
        {
          public T bj()
          {
            return new TreeSet();
          }
        };
      if (EnumSet.class.isAssignableFrom(paramClass))
        return new zzapx(paramType)
        {
          public T bj()
          {
            if ((this.boQ instanceof ParameterizedType))
            {
              localObject = ((ParameterizedType)this.boQ).getActualTypeArguments()[0];
              if ((localObject instanceof Class))
                return EnumSet.noneOf((Class)localObject);
              localObject = String.valueOf(this.boQ.toString());
              if (((String)localObject).length() != 0);
              for (localObject = "Invalid EnumSet type: ".concat((String)localObject); ; localObject = new String("Invalid EnumSet type: "))
                throw new zzaoz((String)localObject);
            }
            Object localObject = String.valueOf(this.boQ.toString());
            if (((String)localObject).length() != 0);
            for (localObject = "Invalid EnumSet type: ".concat((String)localObject); ; localObject = new String("Invalid EnumSet type: "))
              throw new zzaoz((String)localObject);
          }
        };
      if (Set.class.isAssignableFrom(paramClass))
        return new zzapx()
        {
          public T bj()
          {
            return new LinkedHashSet();
          }
        };
      if (Queue.class.isAssignableFrom(paramClass))
        return new zzapx()
        {
          public T bj()
          {
            return new LinkedList();
          }
        };
      return new zzapx()
      {
        public T bj()
        {
          return new ArrayList();
        }
      };
    }
    if (Map.class.isAssignableFrom(paramClass))
    {
      if (SortedMap.class.isAssignableFrom(paramClass))
        return new zzapx()
        {
          public T bj()
          {
            return new TreeMap();
          }
        };
      if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(zzaqo.zzl(((ParameterizedType)paramType).getActualTypeArguments()[0]).bB())))
        return new zzapx()
        {
          public T bj()
          {
            return new LinkedHashMap();
          }
        };
      return new zzapx()
      {
        public T bj()
        {
          return new zzapw();
        }
      };
    }
    return null;
  }

  private <T> zzapx<T> zzd(Type paramType, Class<? super T> paramClass)
  {
    return new zzapx(paramClass, paramType)
    {
      private final zzaqa boS = zzaqa.bo();

      public T bj()
      {
        String str;
        try
        {
          Object localObject = this.boS.zzf(this.boT);
          return localObject;
        }
        catch (Exception localException)
        {
          str = String.valueOf(this.boQ);
        }
        throw new RuntimeException(String.valueOf(str).length() + 116 + "Unable to invoke no-args constructor for " + str + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", localException);
      }
    };
  }

  private <T> zzapx<T> zzl(Class<? super T> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      if (!paramClass.isAccessible())
        paramClass.setAccessible(true);
      paramClass = new zzapx(paramClass)
      {
        public T bj()
        {
          try
          {
            Object localObject = this.boV.newInstance(null);
            return localObject;
          }
          catch (InstantiationException localInstantiationException)
          {
            str = String.valueOf(this.boV);
            throw new RuntimeException(String.valueOf(str).length() + 30 + "Failed to invoke " + str + " with no args", localInstantiationException);
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            String str = String.valueOf(this.boV);
            throw new RuntimeException(String.valueOf(str).length() + 30 + "Failed to invoke " + str + " with no args", localInvocationTargetException.getTargetException());
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
          }
          throw new AssertionError(localIllegalAccessException);
        }
      };
      return paramClass;
    }
    catch (java.lang.NoSuchMethodException paramClass)
    {
    }
    return null;
  }

  public String toString()
  {
    return this.bop.toString();
  }

  public <T> zzapx<T> zzb(zzaqo<T> paramzzaqo)
  {
    Type localType = paramzzaqo.bC();
    Class localClass = paramzzaqo.bB();
    paramzzaqo = (zzaou)this.bop.get(localType);
    if (paramzzaqo != null)
      paramzzaqo = new zzapx(paramzzaqo, localType)
      {
        public T bj()
        {
          return this.boP.zza(this.boQ);
        }
      };
    zzapx localzzapx;
    do
    {
      do
      {
        return paramzzaqo;
        paramzzaqo = (zzaou)this.bop.get(localClass);
        if (paramzzaqo != null)
          return new zzapx(paramzzaqo, localType)
          {
            public T bj()
            {
              return this.boU.zza(this.boQ);
            }
          };
        localzzapx = zzl(localClass);
        paramzzaqo = localzzapx;
      }
      while (localzzapx != null);
      localzzapx = zzc(localType, localClass);
      paramzzaqo = localzzapx;
    }
    while (localzzapx != null);
    return zzd(localType, localClass);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaps
 * JD-Core Version:    0.6.0
 */