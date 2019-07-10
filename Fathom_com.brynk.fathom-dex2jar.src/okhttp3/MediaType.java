package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType
{
  private static final Pattern PARAMETER;
  private static final String QUOTED = "\"([^\"]*)\"";
  private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private final String charset;
  private final String mediaType;
  private final String subtype;
  private final String type;

  static
  {
    PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  }

  private MediaType(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mediaType = paramString1;
    this.type = paramString2;
    this.subtype = paramString3;
    this.charset = paramString4;
  }

  public static MediaType parse(String paramString)
  {
    Object localObject1 = TYPE_SUBTYPE.matcher(paramString);
    if (!((Matcher)localObject1).lookingAt());
    String str1;
    String str2;
    Object localObject2;
    while (true)
    {
      return null;
      str1 = ((Matcher)localObject1).group(1).toLowerCase(Locale.US);
      str2 = ((Matcher)localObject1).group(2).toLowerCase(Locale.US);
      localObject2 = null;
      Matcher localMatcher = PARAMETER.matcher(paramString);
      int i = ((Matcher)localObject1).end();
      if (i >= paramString.length())
        break;
      localMatcher.region(i, paramString.length());
      if (!localMatcher.lookingAt())
        continue;
      String str3 = localMatcher.group(1);
      localObject1 = localObject2;
      if (str3 != null)
      {
        if (str3.equalsIgnoreCase("charset"))
          break label124;
        localObject1 = localObject2;
      }
      while (true)
      {
        i = localMatcher.end();
        localObject2 = localObject1;
        break;
        label124: localObject1 = localMatcher.group(2);
        if (localObject1 != null)
          if ((((String)localObject1).startsWith("'")) && (((String)localObject1).endsWith("'")) && (((String)localObject1).length() > 2))
            localObject1 = ((String)localObject1).substring(1, ((String)localObject1).length() - 1);
        while ((localObject2 != null) && (!((String)localObject1).equalsIgnoreCase(localObject2)))
        {
          throw new IllegalArgumentException("Multiple different charsets: " + paramString);
          continue;
          localObject1 = localMatcher.group(3);
        }
      }
    }
    return (MediaType)new MediaType(paramString, str1, str2, localObject2);
  }

  public Charset charset()
  {
    if (this.charset != null)
      return Charset.forName(this.charset);
    return null;
  }

  public Charset charset(Charset paramCharset)
  {
    if (this.charset != null)
      paramCharset = Charset.forName(this.charset);
    return paramCharset;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof MediaType)) && (((MediaType)paramObject).mediaType.equals(this.mediaType));
  }

  public int hashCode()
  {
    return this.mediaType.hashCode();
  }

  public String subtype()
  {
    return this.subtype;
  }

  public String toString()
  {
    return this.mediaType;
  }

  public String type()
  {
    return this.type;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.MediaType
 * JD-Core Version:    0.6.0
 */