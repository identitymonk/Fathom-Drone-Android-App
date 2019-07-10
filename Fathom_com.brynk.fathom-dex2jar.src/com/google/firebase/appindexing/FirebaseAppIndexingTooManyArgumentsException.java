package com.google.firebase.appindexing;

import android.support.annotation.NonNull;

public class FirebaseAppIndexingTooManyArgumentsException extends FirebaseAppIndexingException
{
  public FirebaseAppIndexingTooManyArgumentsException()
  {
    super("Too many Indexables provided. Try splitting them in batches.");
  }

  public FirebaseAppIndexingTooManyArgumentsException(@NonNull String paramString)
  {
    super(paramString);
  }

  public FirebaseAppIndexingTooManyArgumentsException(@NonNull String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.FirebaseAppIndexingTooManyArgumentsException
 * JD-Core Version:    0.6.0
 */