package com.facebook.jni;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReference;

public class DestructorThread
{
  private static DestructorList sDestructorList;
  private static DestructorStack sDestructorStack = new DestructorStack(null);
  private static ReferenceQueue sReferenceQueue = new ReferenceQueue();
  private static Thread sThread;

  static
  {
    sDestructorList = new DestructorList();
    sThread = new Thread("HybridData DestructorThread")
    {
      public void run()
      {
        while (true)
          try
          {
            DestructorThread.Destructor localDestructor = (DestructorThread.Destructor)DestructorThread.sReferenceQueue.remove();
            localDestructor.destruct();
            if (DestructorThread.Destructor.access$300(localDestructor) != null)
              continue;
            DestructorThread.sDestructorStack.transferAllToList();
            DestructorThread.DestructorList.access$400(localDestructor);
            continue;
          }
          catch (InterruptedException localInterruptedException)
          {
          }
      }
    };
    sThread.start();
  }

  public static abstract class Destructor extends PhantomReference<Object>
  {
    private Destructor next;
    private Destructor previous;

    private Destructor()
    {
      super(DestructorThread.sReferenceQueue);
    }

    Destructor(Object paramObject)
    {
      super(DestructorThread.sReferenceQueue);
      DestructorThread.sDestructorStack.push(this);
    }

    abstract void destruct();
  }

  private static class DestructorList
  {
    private DestructorThread.Destructor mHead = new DestructorThread.Terminus(null);

    public DestructorList()
    {
      DestructorThread.Destructor.access$602(this.mHead, new DestructorThread.Terminus(null));
      DestructorThread.Destructor.access$302(this.mHead.next, this.mHead);
    }

    private static void drop(DestructorThread.Destructor paramDestructor)
    {
      DestructorThread.Destructor.access$302(paramDestructor.next, paramDestructor.previous);
      DestructorThread.Destructor.access$602(paramDestructor.previous, paramDestructor.next);
    }

    public void enqueue(DestructorThread.Destructor paramDestructor)
    {
      DestructorThread.Destructor.access$602(paramDestructor, this.mHead.next);
      DestructorThread.Destructor.access$602(this.mHead, paramDestructor);
      DestructorThread.Destructor.access$302(paramDestructor.next, paramDestructor);
      DestructorThread.Destructor.access$302(paramDestructor, this.mHead);
    }
  }

  private static class DestructorStack
  {
    private AtomicReference<DestructorThread.Destructor> mHead = new AtomicReference();

    public void push(DestructorThread.Destructor paramDestructor)
    {
      DestructorThread.Destructor localDestructor;
      do
      {
        localDestructor = (DestructorThread.Destructor)this.mHead.get();
        DestructorThread.Destructor.access$602(paramDestructor, localDestructor);
      }
      while (!this.mHead.compareAndSet(localDestructor, paramDestructor));
    }

    public void transferAllToList()
    {
      DestructorThread.Destructor localDestructor;
      for (Object localObject = (DestructorThread.Destructor)this.mHead.getAndSet(null); localObject != null; localObject = localDestructor)
      {
        localDestructor = ((DestructorThread.Destructor)localObject).next;
        DestructorThread.sDestructorList.enqueue((DestructorThread.Destructor)localObject);
      }
    }
  }

  private static class Terminus extends DestructorThread.Destructor
  {
    private Terminus()
    {
      super();
    }

    void destruct()
    {
      throw new IllegalStateException("Cannot destroy Terminus Destructor.");
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.jni.DestructorThread
 * JD-Core Version:    0.6.0
 */