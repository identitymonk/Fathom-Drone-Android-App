package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

public abstract interface Continuation<TResult, TContinuationResult>
{
  public abstract TContinuationResult then(@NonNull Task<TResult> paramTask)
    throws Exception;
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.Continuation
 * JD-Core Version:    0.6.0
 */