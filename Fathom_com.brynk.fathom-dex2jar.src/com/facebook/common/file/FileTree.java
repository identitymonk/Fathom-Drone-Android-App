package com.facebook.common.file;

import java.io.File;

public class FileTree
{
  public static boolean deleteContents(File paramFile)
  {
    paramFile = paramFile.listFiles();
    int k = 1;
    boolean bool = true;
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (true)
      {
        k = bool;
        if (i >= j)
          break;
        bool &= deleteRecursively(paramFile[i]);
        i += 1;
      }
    }
    return k;
  }

  public static boolean deleteRecursively(File paramFile)
  {
    if (paramFile.isDirectory())
      deleteContents(paramFile);
    return paramFile.delete();
  }

  public static void walkFileTree(File paramFile, FileTreeVisitor paramFileTreeVisitor)
  {
    paramFileTreeVisitor.preVisitDirectory(paramFile);
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory())
          walkFileTree(localFile, paramFileTreeVisitor);
        while (true)
        {
          i += 1;
          break;
          paramFileTreeVisitor.visitFile(localFile);
        }
      }
    }
    paramFileTreeVisitor.postVisitDirectory(paramFile);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.file.FileTree
 * JD-Core Version:    0.6.0
 */