package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;
import com.google.firebase.appindexing.Action;
import com.google.firebase.appindexing.Action.Builder;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;

public final class Actions
{
  public static Action newView(@NonNull String paramString1, @NonNull String paramString2)
    throws FirebaseAppIndexingInvalidArgumentException
  {
    return new Action.Builder("ViewAction").setObject(paramString1, paramString2).build();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.Actions
 * JD-Core Version:    0.6.0
 */