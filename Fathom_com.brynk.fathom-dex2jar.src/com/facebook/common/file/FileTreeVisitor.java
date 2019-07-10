package com.facebook.common.file;

import java.io.File;

public abstract interface FileTreeVisitor
{
  public abstract void postVisitDirectory(File paramFile);

  public abstract void preVisitDirectory(File paramFile);

  public abstract void visitFile(File paramFile);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.file.FileTreeVisitor
 * JD-Core Version:    0.6.0
 */