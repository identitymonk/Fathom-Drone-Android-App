package com.google.android.gms.common.api;

import android.support.annotation.NonNull;

public abstract class TransformedResult<R extends Result>
{
  public abstract void andFinally(@NonNull ResultCallbacks<? super R> paramResultCallbacks);

  @NonNull
  public abstract <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> paramResultTransform);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.TransformedResult
 * JD-Core Version:    0.6.0
 */