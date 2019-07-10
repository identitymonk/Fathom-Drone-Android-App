package com.facebook.drawee.components;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class DraweeEventTracker
{
  private static final int MAX_EVENTS_TO_TRACK = 20;
  private static boolean sEnabled;
  private static final DraweeEventTracker sInstance = new DraweeEventTracker();
  private final Queue<Event> mEventQueue = new ArrayBlockingQueue(20);

  static
  {
    sEnabled = true;
  }

  public static void disable()
  {
    sEnabled = false;
  }

  public static DraweeEventTracker newInstance()
  {
    if (sEnabled)
      return new DraweeEventTracker();
    return sInstance;
  }

  public void recordEvent(Event paramEvent)
  {
    if (!sEnabled)
      return;
    if (this.mEventQueue.size() + 1 > 20)
      this.mEventQueue.poll();
    this.mEventQueue.add(paramEvent);
  }

  public String toString()
  {
    return this.mEventQueue.toString();
  }

  public static enum Event
  {
    static
    {
      ON_CLEAR_HIERARCHY = new Event("ON_CLEAR_HIERARCHY", 1);
      ON_SET_CONTROLLER = new Event("ON_SET_CONTROLLER", 2);
      ON_CLEAR_OLD_CONTROLLER = new Event("ON_CLEAR_OLD_CONTROLLER", 3);
      ON_CLEAR_CONTROLLER = new Event("ON_CLEAR_CONTROLLER", 4);
      ON_INIT_CONTROLLER = new Event("ON_INIT_CONTROLLER", 5);
      ON_ATTACH_CONTROLLER = new Event("ON_ATTACH_CONTROLLER", 6);
      ON_DETACH_CONTROLLER = new Event("ON_DETACH_CONTROLLER", 7);
      ON_RELEASE_CONTROLLER = new Event("ON_RELEASE_CONTROLLER", 8);
      ON_DATASOURCE_SUBMIT = new Event("ON_DATASOURCE_SUBMIT", 9);
      ON_DATASOURCE_RESULT = new Event("ON_DATASOURCE_RESULT", 10);
      ON_DATASOURCE_RESULT_INT = new Event("ON_DATASOURCE_RESULT_INT", 11);
      ON_DATASOURCE_FAILURE = new Event("ON_DATASOURCE_FAILURE", 12);
      ON_DATASOURCE_FAILURE_INT = new Event("ON_DATASOURCE_FAILURE_INT", 13);
      ON_HOLDER_ATTACH = new Event("ON_HOLDER_ATTACH", 14);
      ON_HOLDER_DETACH = new Event("ON_HOLDER_DETACH", 15);
      ON_DRAWABLE_SHOW = new Event("ON_DRAWABLE_SHOW", 16);
      ON_DRAWABLE_HIDE = new Event("ON_DRAWABLE_HIDE", 17);
      ON_ACTIVITY_START = new Event("ON_ACTIVITY_START", 18);
      ON_ACTIVITY_STOP = new Event("ON_ACTIVITY_STOP", 19);
      ON_RUN_CLEAR_CONTROLLER = new Event("ON_RUN_CLEAR_CONTROLLER", 20);
      ON_SCHEDULE_CLEAR_CONTROLLER = new Event("ON_SCHEDULE_CLEAR_CONTROLLER", 21);
      ON_SAME_CONTROLLER_SKIPPED = new Event("ON_SAME_CONTROLLER_SKIPPED", 22);
      ON_SUBMIT_CACHE_HIT = new Event("ON_SUBMIT_CACHE_HIT", 23);
      $VALUES = new Event[] { ON_SET_HIERARCHY, ON_CLEAR_HIERARCHY, ON_SET_CONTROLLER, ON_CLEAR_OLD_CONTROLLER, ON_CLEAR_CONTROLLER, ON_INIT_CONTROLLER, ON_ATTACH_CONTROLLER, ON_DETACH_CONTROLLER, ON_RELEASE_CONTROLLER, ON_DATASOURCE_SUBMIT, ON_DATASOURCE_RESULT, ON_DATASOURCE_RESULT_INT, ON_DATASOURCE_FAILURE, ON_DATASOURCE_FAILURE_INT, ON_HOLDER_ATTACH, ON_HOLDER_DETACH, ON_DRAWABLE_SHOW, ON_DRAWABLE_HIDE, ON_ACTIVITY_START, ON_ACTIVITY_STOP, ON_RUN_CLEAR_CONTROLLER, ON_SCHEDULE_CLEAR_CONTROLLER, ON_SAME_CONTROLLER_SKIPPED, ON_SUBMIT_CACHE_HIT };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.components.DraweeEventTracker
 * JD-Core Version:    0.6.0
 */