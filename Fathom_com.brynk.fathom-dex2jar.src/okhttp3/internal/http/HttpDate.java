package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.Util;

public final class HttpDate
{
  private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;
  private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
  public static final long MAX_DATE = 253402300799999L;
  private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = new ThreadLocal()
  {
    protected DateFormat initialValue()
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
      localSimpleDateFormat.setLenient(false);
      localSimpleDateFormat.setTimeZone(Util.UTC);
      return localSimpleDateFormat;
    }
  };

  static
  {
    BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = new String[] { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z" };
    BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length];
  }

  public static String format(Date paramDate)
  {
    return ((DateFormat)STANDARD_DATE_FORMAT.get()).format(paramDate);
  }

  public static Date parse(String paramString)
  {
    Object localObject;
    if (paramString.length() == 0)
      localObject = null;
    ParsePosition localParsePosition;
    do
    {
      return localObject;
      localParsePosition = new ParsePosition(0);
      localObject = ((DateFormat)STANDARD_DATE_FORMAT.get()).parse(paramString, localParsePosition);
    }
    while (localParsePosition.getIndex() == paramString.length());
    String[] arrayOfString = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
    monitorenter;
    int i = 0;
    while (true)
    {
      try
      {
        int j = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length;
        if (i >= j)
          break;
        DateFormat localDateFormat = BROWSER_COMPATIBLE_DATE_FORMATS[i];
        localObject = localDateFormat;
        if (localDateFormat != null)
          continue;
        localObject = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], Locale.US);
        ((DateFormat)localObject).setTimeZone(Util.UTC);
        BROWSER_COMPATIBLE_DATE_FORMATS[i] = localObject;
        localParsePosition.setIndex(0);
        localObject = ((DateFormat)localObject).parse(paramString, localParsePosition);
        if (localParsePosition.getIndex() != 0)
          return localObject;
      }
      finally
      {
        monitorexit;
      }
      i += 1;
    }
    monitorexit;
    return (Date)null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http.HttpDate
 * JD-Core Version:    0.6.0
 */