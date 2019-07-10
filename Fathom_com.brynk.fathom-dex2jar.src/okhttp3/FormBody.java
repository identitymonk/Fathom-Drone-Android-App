package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody extends RequestBody
{
  private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
  private final List<String> encodedNames;
  private final List<String> encodedValues;

  FormBody(List<String> paramList1, List<String> paramList2)
  {
    this.encodedNames = Util.immutableList(paramList1);
    this.encodedValues = Util.immutableList(paramList2);
  }

  private long writeOrCountBytes(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    long l = 0L;
    if (paramBoolean);
    for (paramBufferedSink = new Buffer(); ; paramBufferedSink = paramBufferedSink.buffer())
    {
      int i = 0;
      int j = this.encodedNames.size();
      while (i < j)
      {
        if (i > 0)
          paramBufferedSink.writeByte(38);
        paramBufferedSink.writeUtf8((String)this.encodedNames.get(i));
        paramBufferedSink.writeByte(61);
        paramBufferedSink.writeUtf8((String)this.encodedValues.get(i));
        i += 1;
      }
    }
    if (paramBoolean)
    {
      l = paramBufferedSink.size();
      paramBufferedSink.clear();
    }
    return l;
  }

  public long contentLength()
  {
    return writeOrCountBytes(null, true);
  }

  public MediaType contentType()
  {
    return CONTENT_TYPE;
  }

  public String encodedName(int paramInt)
  {
    return (String)this.encodedNames.get(paramInt);
  }

  public String encodedValue(int paramInt)
  {
    return (String)this.encodedValues.get(paramInt);
  }

  public String name(int paramInt)
  {
    return HttpUrl.percentDecode(encodedName(paramInt), true);
  }

  public int size()
  {
    return this.encodedNames.size();
  }

  public String value(int paramInt)
  {
    return HttpUrl.percentDecode(encodedValue(paramInt), true);
  }

  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    writeOrCountBytes(paramBufferedSink, false);
  }

  public static final class Builder
  {
    private final List<String> names = new ArrayList();
    private final List<String> values = new ArrayList();

    public Builder add(String paramString1, String paramString2)
    {
      this.names.add(HttpUrl.canonicalize(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
      this.values.add(HttpUrl.canonicalize(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
      return this;
    }

    public Builder addEncoded(String paramString1, String paramString2)
    {
      this.names.add(HttpUrl.canonicalize(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
      this.values.add(HttpUrl.canonicalize(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
      return this;
    }

    public FormBody build()
    {
      return new FormBody(this.names, this.values);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.FormBody
 * JD-Core Version:    0.6.0
 */