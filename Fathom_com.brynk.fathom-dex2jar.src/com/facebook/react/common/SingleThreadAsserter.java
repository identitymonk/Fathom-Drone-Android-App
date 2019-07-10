package com.facebook.react.common;

import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

public class SingleThreadAsserter
{

  @Nullable
  private Thread mThread = null;

  public void assertNow()
  {
    Thread localThread = Thread.currentThread();
    if (this.mThread == null)
      this.mThread = localThread;
    if (this.mThread == localThread);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool);
      return;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.common.SingleThreadAsserter
 * JD-Core Version:    0.6.0
 */