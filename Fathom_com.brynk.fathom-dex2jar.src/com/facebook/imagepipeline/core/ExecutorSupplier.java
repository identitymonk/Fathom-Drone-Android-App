package com.facebook.imagepipeline.core;

import java.util.concurrent.Executor;

public abstract interface ExecutorSupplier
{
  public abstract Executor forBackgroundTasks();

  public abstract Executor forDecode();

  public abstract Executor forLightweightBackgroundTasks();

  public abstract Executor forLocalStorageRead();

  public abstract Executor forLocalStorageWrite();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.ExecutorSupplier
 * JD-Core Version:    0.6.0
 */