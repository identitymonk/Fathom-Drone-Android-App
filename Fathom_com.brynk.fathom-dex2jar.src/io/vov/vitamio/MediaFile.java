package io.vov.vitamio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MediaFile
{
  public static final int FILE_TYPE_3GPP = 703;
  public static final int FILE_TYPE_3GPP2 = 704;
  public static final int FILE_TYPE_AAC = 8;
  public static final int FILE_TYPE_AMR = 4;
  public static final int FILE_TYPE_APE = 13;
  public static final int FILE_TYPE_ASF = 706;
  public static final int FILE_TYPE_AVS = 717;
  public static final int FILE_TYPE_AWB = 5;
  public static final int FILE_TYPE_DIVX = 713;
  public static final int FILE_TYPE_DVD = 712;
  public static final int FILE_TYPE_FLAC = 14;
  public static final int FILE_TYPE_FLV = 709;
  public static final int FILE_TYPE_IMY = 12;
  public static final int FILE_TYPE_M4A = 2;
  public static final int FILE_TYPE_M4V = 702;
  public static final int FILE_TYPE_MID = 10;
  public static final int FILE_TYPE_MKA = 9;
  public static final int FILE_TYPE_MKV = 707;
  public static final int FILE_TYPE_MOV = 710;
  public static final int FILE_TYPE_MP2TS = 708;
  public static final int FILE_TYPE_MP3 = 1;
  public static final int FILE_TYPE_MP4 = 701;
  public static final int FILE_TYPE_OGG = 7;
  public static final int FILE_TYPE_OGV = 714;
  public static final int FILE_TYPE_RAW = 719;
  public static final int FILE_TYPE_RM = 711;
  public static final int FILE_TYPE_SMF = 11;
  public static final int FILE_TYPE_SWF = 718;
  public static final int FILE_TYPE_VIVO = 715;
  public static final int FILE_TYPE_WAV = 3;
  public static final int FILE_TYPE_WMA = 6;
  public static final int FILE_TYPE_WMV = 705;
  public static final int FILE_TYPE_WTV = 716;
  private static final int FIRST_AUDIO_FILE_TYPE = 1;
  private static final int FIRST_VIDEO_FILE_TYPE = 701;
  private static final int LAST_AUDIO_FILE_TYPE = 14;
  private static final int LAST_VIDEO_FILE_TYPE = 719;
  protected static final String sFileExtensions;
  private static HashMap<String, MediaFileType> sFileTypeMap = new HashMap();
  private static HashMap<String, Integer> sMimeTypeMap = new HashMap();

  static
  {
    addFileType("M1V", 701, "video/mpeg");
    addFileType("MP2", 701, "video/mpeg");
    addFileType("MPE", 701, "video/mpeg");
    addFileType("MPG", 701, "video/mpeg");
    addFileType("MPEG", 701, "video/mpeg");
    addFileType("MP4", 701, "video/mp4");
    addFileType("M4V", 702, "video/mp4");
    addFileType("3GP", 703, "video/3gpp");
    addFileType("3GPP", 703, "video/3gpp");
    addFileType("3G2", 704, "video/3gpp2");
    addFileType("3GPP2", 704, "video/3gpp2");
    addFileType("MKV", 707, "video/x-matroska");
    addFileType("WEBM", 707, "video/x-matroska");
    addFileType("MTS", 708, "video/mp2ts");
    addFileType("TS", 708, "video/mp2ts");
    addFileType("TP", 708, "video/mp2ts");
    addFileType("WMV", 705, "video/x-ms-wmv");
    addFileType("ASF", 706, "video/x-ms-asf");
    addFileType("ASX", 706, "video/x-ms-asf");
    addFileType("FLV", 709, "video/x-flv");
    addFileType("F4V", 709, "video/x-flv");
    addFileType("HLV", 709, "video/x-flv");
    addFileType("MOV", 710, "video/quicktime");
    addFileType("QT", 710, "video/quicktime");
    addFileType("RM", 711, "video/x-pn-realvideo");
    addFileType("RMVB", 711, "video/x-pn-realvideo");
    addFileType("VOB", 712, "video/dvd");
    addFileType("DAT", 712, "video/dvd");
    addFileType("AVI", 713, "video/x-divx");
    addFileType("OGV", 714, "video/ogg");
    addFileType("OGG", 714, "video/ogg");
    addFileType("VIV", 715, "video/vnd.vivo");
    addFileType("VIVO", 715, "video/vnd.vivo");
    addFileType("WTV", 716, "video/wtv");
    addFileType("AVS", 717, "video/avs-video");
    addFileType("SWF", 718, "video/x-shockwave-flash");
    addFileType("YUV", 719, "video/x-raw-yuv");
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = sFileTypeMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      localStringBuilder.append((String)localIterator.next());
    }
    sFileExtensions = localStringBuilder.toString();
  }

  static void addFileType(String paramString1, int paramInt, String paramString2)
  {
    sFileTypeMap.put(paramString1, new MediaFileType(paramInt, paramString2));
    sMimeTypeMap.put(paramString2, Integer.valueOf(paramInt));
  }

  public static MediaFileType getFileType(String paramString)
  {
    int i = paramString.lastIndexOf(".");
    if (i < 0)
      return null;
    return (MediaFileType)sFileTypeMap.get(paramString.substring(i + 1).toUpperCase());
  }

  public static int getFileTypeForMimeType(String paramString)
  {
    paramString = (Integer)sMimeTypeMap.get(paramString);
    if (paramString == null)
      return 0;
    return paramString.intValue();
  }

  public static boolean isAudioFileType(int paramInt)
  {
    return (paramInt >= 1) && (paramInt <= 14);
  }

  public static boolean isVideoFileType(int paramInt)
  {
    return (paramInt >= 701) && (paramInt <= 719);
  }

  protected static class MediaFileType
  {
    int fileType;
    String mimeType;

    MediaFileType(int paramInt, String paramString)
    {
      this.fileType = paramInt;
      this.mimeType = paramString;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.MediaFile
 * JD-Core Version:    0.6.0
 */