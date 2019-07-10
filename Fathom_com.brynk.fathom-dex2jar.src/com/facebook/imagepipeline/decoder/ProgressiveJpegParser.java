package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;

public class ProgressiveJpegParser
{
  private static final int BUFFER_SIZE = 16384;
  private static final int NOT_A_JPEG = 6;
  private static final int READ_FIRST_JPEG_BYTE = 0;
  private static final int READ_MARKER_FIRST_BYTE_OR_ENTROPY_DATA = 2;
  private static final int READ_MARKER_SECOND_BYTE = 3;
  private static final int READ_SECOND_JPEG_BYTE = 1;
  private static final int READ_SIZE_FIRST_BYTE = 4;
  private static final int READ_SIZE_SECOND_BYTE = 5;
  private int mBestScanEndOffset;
  private int mBestScanNumber;
  private final ByteArrayPool mByteArrayPool;
  private int mBytesParsed;
  private boolean mEndMarkerRead;
  private int mLastByteRead;
  private int mNextFullScanNumber;
  private int mParserState;

  public ProgressiveJpegParser(ByteArrayPool paramByteArrayPool)
  {
    this.mByteArrayPool = ((ByteArrayPool)Preconditions.checkNotNull(paramByteArrayPool));
    this.mBytesParsed = 0;
    this.mLastByteRead = 0;
    this.mNextFullScanNumber = 0;
    this.mBestScanEndOffset = 0;
    this.mBestScanNumber = 0;
    this.mParserState = 0;
  }

  private boolean doParseMoreData(InputStream paramInputStream)
  {
    int i = this.mBestScanNumber;
    while (true)
      try
      {
        if (this.mParserState == 6)
          continue;
        j = paramInputStream.read();
        if (j == -1)
          continue;
        this.mBytesParsed += 1;
        switch (this.mParserState)
        {
        case 0:
          Preconditions.checkState(false);
          this.mLastByteRead = j;
          continue;
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
      }
      catch (IOException paramInputStream)
      {
        int j;
        Throwables.propagate(paramInputStream);
        if ((this.mParserState != 6) && (this.mBestScanNumber != i))
        {
          return true;
          if (j != 255)
            continue;
          this.mParserState = 1;
          continue;
          this.mParserState = 6;
          continue;
          if (j != 216)
            continue;
          this.mParserState = 2;
          continue;
          this.mParserState = 6;
          continue;
          if (j != 255)
            continue;
          this.mParserState = 3;
          continue;
          if (j != 255)
            continue;
          this.mParserState = 3;
          continue;
          if (j != 0)
            continue;
          this.mParserState = 2;
          continue;
          if (j != 217)
            continue;
          this.mEndMarkerRead = true;
          newScanOrImageEndFound(this.mBytesParsed - 2);
          this.mParserState = 2;
          continue;
          if (j != 218)
            continue;
          newScanOrImageEndFound(this.mBytesParsed - 2);
          if (!doesMarkerStartSegment(j))
            continue;
          this.mParserState = 4;
          continue;
          this.mParserState = 2;
          continue;
          this.mParserState = 5;
          continue;
          int k = (this.mLastByteRead << 8) + j - 2;
          StreamUtil.skip(paramInputStream, k);
          this.mBytesParsed += k;
          this.mParserState = 2;
          continue;
        }
        return false;
      }
  }

  private static boolean doesMarkerStartSegment(int paramInt)
  {
    int i = 1;
    if (paramInt == 1);
    do
      return false;
    while ((paramInt >= 208) && (paramInt <= 215));
    if ((paramInt != 217) && (paramInt != 216));
    while (true)
    {
      return i;
      i = 0;
    }
  }

  private void newScanOrImageEndFound(int paramInt)
  {
    if (this.mNextFullScanNumber > 0)
      this.mBestScanEndOffset = paramInt;
    paramInt = this.mNextFullScanNumber;
    this.mNextFullScanNumber = (paramInt + 1);
    this.mBestScanNumber = paramInt;
  }

  public int getBestScanEndOffset()
  {
    return this.mBestScanEndOffset;
  }

  public int getBestScanNumber()
  {
    return this.mBestScanNumber;
  }

  public boolean isEndMarkerRead()
  {
    return this.mEndMarkerRead;
  }

  public boolean isJpeg()
  {
    return (this.mBytesParsed > 1) && (this.mParserState != 6);
  }

  public boolean parseMoreData(EncodedImage paramEncodedImage)
  {
    if (this.mParserState == 6)
      return false;
    if (paramEncodedImage.getSize() <= this.mBytesParsed)
      return false;
    paramEncodedImage = new PooledByteArrayBufferedInputStream(paramEncodedImage.getInputStream(), (byte[])this.mByteArrayPool.get(16384), this.mByteArrayPool);
    try
    {
      StreamUtil.skip(paramEncodedImage, this.mBytesParsed);
      boolean bool = doParseMoreData(paramEncodedImage);
      return bool;
    }
    catch (IOException localIOException)
    {
      Throwables.propagate(localIOException);
      return false;
    }
    finally
    {
      Closeables.closeQuietly(paramEncodedImage);
    }
    throw localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.decoder.ProgressiveJpegParser
 * JD-Core Version:    0.6.0
 */