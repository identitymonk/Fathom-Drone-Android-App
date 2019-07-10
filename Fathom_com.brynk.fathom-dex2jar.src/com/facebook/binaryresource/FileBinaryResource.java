package com.facebook.binaryresource;

import com.facebook.common.internal.Files;
import com.facebook.common.internal.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileBinaryResource
  implements BinaryResource
{
  private final File mFile;

  private FileBinaryResource(File paramFile)
  {
    this.mFile = ((File)Preconditions.checkNotNull(paramFile));
  }

  public static FileBinaryResource createOrNull(File paramFile)
  {
    if (paramFile != null)
      return new FileBinaryResource(paramFile);
    return null;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof FileBinaryResource)))
      return false;
    paramObject = (FileBinaryResource)paramObject;
    return this.mFile.equals(paramObject.mFile);
  }

  public File getFile()
  {
    return this.mFile;
  }

  public int hashCode()
  {
    return this.mFile.hashCode();
  }

  public InputStream openStream()
    throws IOException
  {
    return new FileInputStream(this.mFile);
  }

  public byte[] read()
    throws IOException
  {
    return Files.toByteArray(this.mFile);
  }

  public long size()
  {
    return this.mFile.length();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.binaryresource.FileBinaryResource
 * JD-Core Version:    0.6.0
 */