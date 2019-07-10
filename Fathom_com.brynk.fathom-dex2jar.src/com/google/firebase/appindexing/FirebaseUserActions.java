package com.google.firebase.appindexing;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appindexing.internal.zze;
import java.lang.ref.WeakReference;

public abstract class FirebaseUserActions
{
  public static final String APP_INDEXING_API_TAG = "FirebaseUserActions";
  private static WeakReference<FirebaseUserActions> aWu;

  public static FirebaseUserActions getInstance()
  {
    monitorenter;
    try
    {
      if (aWu == null);
      for (FirebaseUserActions localFirebaseUserActions = null; ; localFirebaseUserActions = (FirebaseUserActions)aWu.get())
      {
        Object localObject2 = localFirebaseUserActions;
        if (localFirebaseUserActions == null)
        {
          localObject2 = new zze(FirebaseApp.getInstance().getApplicationContext());
          aWu = new WeakReference(localObject2);
        }
        return localObject2;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public abstract Task<Void> end(Action paramAction);

  public abstract Task<Void> start(Action paramAction);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.FirebaseUserActions
 * JD-Core Version:    0.6.0
 */