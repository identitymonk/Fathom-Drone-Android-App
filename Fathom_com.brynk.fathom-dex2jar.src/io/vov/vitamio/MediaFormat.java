package io.vov.vitamio;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class MediaFormat
{
  public static final String KEY_AAC_PROFILE = "aac-profile";
  public static final String KEY_BIT_RATE = "bitrate";
  public static final String KEY_CHANNEL_COUNT = "channel-count";
  public static final String KEY_CHANNEL_MASK = "channel-mask";
  public static final String KEY_COLOR_FORMAT = "color-format";
  public static final String KEY_DURATION = "durationUs";
  public static final String KEY_FLAC_COMPRESSION_LEVEL = "flac-compression-level";
  public static final String KEY_FRAME_RATE = "frame-rate";
  public static final String KEY_HEIGHT = "height";
  public static final String KEY_IS_ADTS = "is-adts";
  public static final String KEY_IS_AUTOSELECT = "is-autoselect";
  public static final String KEY_IS_DEFAULT = "is-default";
  public static final String KEY_IS_FORCED_SUBTITLE = "is-forced-subtitle";
  public static final String KEY_I_FRAME_INTERVAL = "i-frame-interval";
  public static final String KEY_LANGUAGE = "language";
  public static final String KEY_MAX_HEIGHT = "max-height";
  public static final String KEY_MAX_INPUT_SIZE = "max-input-size";
  public static final String KEY_MAX_WIDTH = "max-width";
  public static final String KEY_MIME = "mime";
  public static final String KEY_PATH = "path";
  public static final String KEY_PUSH_BLANK_BUFFERS_ON_STOP = "push-blank-buffers-on-shutdown";
  public static final String KEY_REPEAT_PREVIOUS_FRAME_AFTER = "repeat-previous-frame-after";
  public static final String KEY_SAMPLE_RATE = "sample-rate";
  public static final String KEY_SLICE_HEIGHT = "slice-height";
  public static final String KEY_STRIDE = "stride";
  public static final String KEY_TITLE = "title";
  public static final String KEY_WIDTH = "width";
  private Map<String, Object> mMap;

  public MediaFormat()
  {
    this.mMap = new HashMap();
  }

  MediaFormat(Map<String, Object> paramMap)
  {
    this.mMap = paramMap;
  }

  public static final MediaFormat createAudioFormat(String paramString, int paramInt1, int paramInt2)
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", paramString);
    localMediaFormat.setInteger("sample-rate", paramInt1);
    localMediaFormat.setInteger("channel-count", paramInt2);
    return localMediaFormat;
  }

  public static final MediaFormat createSubtitleFormat(String paramString1, String paramString2)
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("title", paramString1);
    localMediaFormat.setString("language", paramString2);
    return localMediaFormat;
  }

  public static final MediaFormat createVideoFormat(String paramString, int paramInt1, int paramInt2)
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", paramString);
    localMediaFormat.setInteger("width", paramInt1);
    localMediaFormat.setInteger("height", paramInt2);
    return localMediaFormat;
  }

  public final boolean containsKey(String paramString)
  {
    return this.mMap.containsKey(paramString);
  }

  public final ByteBuffer getByteBuffer(String paramString)
  {
    return (ByteBuffer)this.mMap.get(paramString);
  }

  public final float getFloat(String paramString)
  {
    return ((Float)this.mMap.get(paramString)).floatValue();
  }

  public final int getInteger(String paramString)
  {
    return ((Integer)this.mMap.get(paramString)).intValue();
  }

  public final int getInteger(String paramString, int paramInt)
  {
    try
    {
      int i = getInteger(paramString);
      return i;
    }
    catch (java.lang.NullPointerException paramString)
    {
      return paramInt;
    }
    catch (java.lang.ClassCastException paramString)
    {
    }
    return paramInt;
  }

  public final long getLong(String paramString)
  {
    return ((Long)this.mMap.get(paramString)).longValue();
  }

  Map<String, Object> getMap()
  {
    return this.mMap;
  }

  public final String getString(String paramString)
  {
    return (String)this.mMap.get(paramString);
  }

  public final void setByteBuffer(String paramString, ByteBuffer paramByteBuffer)
  {
    this.mMap.put(paramString, paramByteBuffer);
  }

  public final void setFloat(String paramString, float paramFloat)
  {
    this.mMap.put(paramString, Float.valueOf(paramFloat));
  }

  public final void setInteger(String paramString, int paramInt)
  {
    this.mMap.put(paramString, Integer.valueOf(paramInt));
  }

  public final void setLong(String paramString, long paramLong)
  {
    this.mMap.put(paramString, Long.valueOf(paramLong));
  }

  public final void setString(String paramString1, String paramString2)
  {
    this.mMap.put(paramString1, paramString2);
  }

  public String toString()
  {
    return this.mMap.toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.MediaFormat
 * JD-Core Version:    0.6.0
 */