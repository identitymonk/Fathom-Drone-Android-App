package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzasb
{
  private static void zza(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
    throws IllegalAccessException, InvocationTargetException
  {
    if (paramObject == null);
    while (true)
    {
      return;
      if (!(paramObject instanceof zzasa))
        break;
      int m = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1).append(zzuz(paramString)).append(" <\n");
        paramStringBuffer1.append("  ");
      }
      Class localClass = paramObject.getClass();
      Object localObject1 = localClass.getFields();
      int n = localObject1.length;
      int i = 0;
      Object localObject4;
      if (i < n)
      {
        Object localObject5 = localObject1[i];
        j = localObject5.getModifiers();
        localObject3 = localObject5.getName();
        if ("cachedSize".equals(localObject3));
        while (true)
        {
          i += 1;
          break;
          if (((j & 0x1) != 1) || ((j & 0x8) == 8) || (((String)localObject3).startsWith("_")) || (((String)localObject3).endsWith("_")))
            continue;
          localObject4 = localObject5.getType();
          localObject5 = localObject5.get(paramObject);
          if (((Class)localObject4).isArray())
          {
            if (((Class)localObject4).getComponentType() == Byte.TYPE)
            {
              zza((String)localObject3, localObject5, paramStringBuffer1, paramStringBuffer2);
              continue;
            }
            if (localObject5 == null);
            for (j = 0; ; j = Array.getLength(localObject5))
            {
              int k = 0;
              while (k < j)
              {
                zza((String)localObject3, Array.get(localObject5, k), paramStringBuffer1, paramStringBuffer2);
                k += 1;
              }
              break;
            }
          }
          zza((String)localObject3, localObject5, paramStringBuffer1, paramStringBuffer2);
        }
      }
      Object localObject3 = localClass.getMethods();
      int j = localObject3.length;
      i = 0;
      while (true)
        if (i < j)
        {
          localObject1 = localObject3[i].getName();
          if (((String)localObject1).startsWith("set"))
            localObject4 = ((String)localObject1).substring(3);
          try
          {
            localObject1 = String.valueOf(localObject4);
            if (((String)localObject1).length() != 0);
            for (localObject1 = "has".concat((String)localObject1); ; localObject1 = new String("has"))
            {
              localObject1 = localClass.getMethod((String)localObject1, new Class[0]);
              if (((Boolean)((Method)localObject1).invoke(paramObject, new Object[0])).booleanValue())
                break label396;
              i += 1;
              break;
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            while (true)
            {
              continue;
              try
              {
                label396: Object localObject2 = String.valueOf(localObject4);
                if (((String)localObject2).length() != 0);
                for (localObject2 = "get".concat((String)localObject2); ; localObject2 = new String("get"))
                {
                  localObject2 = localClass.getMethod((String)localObject2, new Class[0]);
                  zza((String)localObject4, ((Method)localObject2).invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
                  break;
                }
              }
              catch (NoSuchMethodException localNoSuchMethodException2)
              {
              }
            }
          }
        }
      if (paramString == null)
        continue;
      paramStringBuffer1.setLength(m);
      paramStringBuffer2.append(paramStringBuffer1).append(">\n");
      return;
    }
    paramString = zzuz(paramString);
    paramStringBuffer2.append(paramStringBuffer1).append(paramString).append(": ");
    if ((paramObject instanceof String))
    {
      paramString = zzgj((String)paramObject);
      paramStringBuffer2.append("\"").append(paramString).append("\"");
    }
    while (true)
    {
      paramStringBuffer2.append("\n");
      return;
      if ((paramObject instanceof byte[]))
      {
        zza((byte[])paramObject, paramStringBuffer2);
        continue;
      }
      paramStringBuffer2.append(paramObject);
    }
  }

  private static void zza(byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    if (paramArrayOfByte == null)
    {
      paramStringBuffer.append("\"\"");
      return;
    }
    paramStringBuffer.append('"');
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      if ((j == 92) || (j == 34))
        paramStringBuffer.append('\\').append((char)j);
      while (true)
      {
        i += 1;
        break;
        if ((j >= 32) && (j < 127))
        {
          paramStringBuffer.append((char)j);
          continue;
        }
        paramStringBuffer.append(String.format("\\%03o", new Object[] { Integer.valueOf(j) }));
      }
    }
    paramStringBuffer.append('"');
  }

  public static <T extends zzasa> String zzg(T paramT)
  {
    if (paramT == null)
      return "";
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      zza(null, paramT, new StringBuffer(), localStringBuffer);
      return localStringBuffer.toString();
    }
    catch (IllegalAccessException paramT)
    {
      paramT = String.valueOf(paramT.getMessage());
      if (paramT.length() != 0)
        return "Error printing proto: ".concat(paramT);
      return new String("Error printing proto: ");
    }
    catch (InvocationTargetException paramT)
    {
      paramT = String.valueOf(paramT.getMessage());
      if (paramT.length() != 0)
        return "Error printing proto: ".concat(paramT);
    }
    return new String("Error printing proto: ");
  }

  private static String zzgj(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      str = paramString;
      if (paramString.length() > 200)
        str = String.valueOf(paramString.substring(0, 200)).concat("[...]");
    }
    return zzii(str);
  }

  private static String zzii(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\''))
        localStringBuilder.append(c);
      while (true)
      {
        i += 1;
        break;
        localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      }
    }
    return localStringBuilder.toString();
  }

  private static String zzuz(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (i == 0)
        localStringBuffer.append(Character.toLowerCase(c));
      while (true)
      {
        i += 1;
        break;
        if (Character.isUpperCase(c))
        {
          localStringBuffer.append('_').append(Character.toLowerCase(c));
          continue;
        }
        localStringBuffer.append(c);
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzasb
 * JD-Core Version:    0.6.0
 */