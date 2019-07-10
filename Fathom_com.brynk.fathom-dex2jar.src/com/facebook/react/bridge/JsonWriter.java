package com.facebook.react.bridge;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Deque;

public class JsonWriter
  implements Closeable
{
  private final Deque<Scope> mScopes;
  private final Writer mWriter;

  public JsonWriter(Writer paramWriter)
  {
    this.mWriter = paramWriter;
    this.mScopes = new ArrayDeque();
  }

  private void beforeName()
    throws IOException
  {
    Scope localScope = (Scope)this.mScopes.peek();
    switch (1.$SwitchMap$com$facebook$react$bridge$JsonWriter$Scope[localScope.ordinal()])
    {
    default:
      throw new IllegalStateException("Unknown scope: " + localScope);
    case 1:
    case 3:
      throw new IllegalStateException("name not allowed in array");
    case 2:
      replace(Scope.OBJECT);
      return;
    case 4:
    }
    this.mWriter.write(44);
  }

  private void beforeValue()
    throws IOException
  {
    Scope localScope = (Scope)this.mScopes.peek();
    switch (1.$SwitchMap$com$facebook$react$bridge$JsonWriter$Scope[localScope.ordinal()])
    {
    default:
      throw new IllegalStateException("Unknown scope: " + localScope);
    case 1:
      replace(Scope.ARRAY);
    case 4:
      return;
    case 2:
      throw new IllegalArgumentException(Scope.EMPTY_OBJECT.name());
    case 3:
    }
    this.mWriter.write(44);
  }

  private void close(char paramChar)
    throws IOException
  {
    this.mScopes.pop();
    this.mWriter.write(paramChar);
  }

  private void open(Scope paramScope, char paramChar)
    throws IOException
  {
    this.mScopes.push(paramScope);
    this.mWriter.write(paramChar);
  }

  private void replace(Scope paramScope)
  {
    this.mScopes.pop();
    this.mScopes.push(paramScope);
  }

  private void string(String paramString)
    throws IOException
  {
    this.mWriter.write(34);
    int i = 0;
    int j = paramString.length();
    if (i < j)
    {
      int k = paramString.charAt(i);
      switch (k)
      {
      default:
        if (k > 31)
          break;
        this.mWriter.write(String.format("\\u%04x", new Object[] { Integer.valueOf(k) }));
      case 9:
      case 8:
      case 10:
      case 13:
      case 12:
      case 34:
      case 92:
      case 8232:
      case 8233:
      }
      while (true)
      {
        i += 1;
        break;
        this.mWriter.write("\\t");
        continue;
        this.mWriter.write("\\b");
        continue;
        this.mWriter.write("\\n");
        continue;
        this.mWriter.write("\\r");
        continue;
        this.mWriter.write("\\f");
        continue;
        this.mWriter.write(92);
        this.mWriter.write(k);
        continue;
        this.mWriter.write(String.format("\\u%04x", new Object[] { Integer.valueOf(k) }));
        continue;
        this.mWriter.write(k);
      }
    }
    this.mWriter.write(34);
  }

  public JsonWriter beginArray()
    throws IOException
  {
    open(Scope.EMPTY_ARRAY, '[');
    return this;
  }

  public JsonWriter beginObject()
    throws IOException
  {
    open(Scope.EMPTY_OBJECT, '{');
    return this;
  }

  public void close()
    throws IOException
  {
    this.mWriter.close();
  }

  public JsonWriter endArray()
    throws IOException
  {
    close(']');
    return this;
  }

  public JsonWriter endObject()
    throws IOException
  {
    close('}');
    return this;
  }

  public JsonWriter name(String paramString)
    throws IOException
  {
    if (paramString == null)
      throw new NullPointerException("name can not be null");
    beforeName();
    string(paramString);
    this.mWriter.write(58);
    return this;
  }

  public JsonWriter nullValue()
    throws IOException
  {
    beforeValue();
    this.mWriter.write("null");
    return this;
  }

  public JsonWriter rawValue(String paramString)
    throws IOException
  {
    beforeValue();
    this.mWriter.write(paramString);
    return this;
  }

  public JsonWriter value(double paramDouble)
    throws IOException
  {
    beforeValue();
    this.mWriter.append(Double.toString(paramDouble));
    return this;
  }

  public JsonWriter value(long paramLong)
    throws IOException
  {
    beforeValue();
    this.mWriter.write(Long.toString(paramLong));
    return this;
  }

  public JsonWriter value(Number paramNumber)
    throws IOException
  {
    if (paramNumber == null)
      return nullValue();
    beforeValue();
    this.mWriter.append(paramNumber.toString());
    return this;
  }

  public JsonWriter value(String paramString)
    throws IOException
  {
    if (paramString == null)
      return nullValue();
    beforeValue();
    string(paramString);
    return this;
  }

  public JsonWriter value(boolean paramBoolean)
    throws IOException
  {
    beforeValue();
    Writer localWriter = this.mWriter;
    if (paramBoolean);
    for (String str = "true"; ; str = "false")
    {
      localWriter.write(str);
      return this;
    }
  }

  private static enum Scope
  {
    static
    {
      EMPTY_ARRAY = new Scope("EMPTY_ARRAY", 2);
      ARRAY = new Scope("ARRAY", 3);
      $VALUES = new Scope[] { EMPTY_OBJECT, OBJECT, EMPTY_ARRAY, ARRAY };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JsonWriter
 * JD-Core Version:    0.6.0
 */