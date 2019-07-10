package com.google.firebase.appindexing;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appindexing.internal.zzc;
import java.lang.ref.WeakReference;

public abstract class FirebaseAppIndex
{
  public static final String ACTION_UPDATE_INDEX = "com.google.firebase.appindexing.UPDATE_INDEX";
  public static final String APP_INDEXING_API_TAG = "FirebaseAppIndex";
  private static WeakReference<FirebaseAppIndex> aWu;

  public static FirebaseAppIndex getInstance()
  {
    monitorenter;
    try
    {
      if (aWu == null);
      for (FirebaseAppIndex localFirebaseAppIndex = null; ; localFirebaseAppIndex = (FirebaseAppIndex)aWu.get())
      {
        Object localObject2 = localFirebaseAppIndex;
        if (localFirebaseAppIndex == null)
        {
          localObject2 = new zzc(FirebaseApp.getInstance().getApplicationContext());
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

  public abstract Task<Void> remove(String[] paramArrayOfString);

  public abstract Task<Void> removeAll();

  public abstract Task<Void> update(Indexable[] paramArrayOfIndexable);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.FirebaseAppIndex
 * JD-Core Version:    0.6.0
 */