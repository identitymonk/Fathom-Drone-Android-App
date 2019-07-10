package bolts;

class UnobservedErrorNotifier
{
  private Task<?> task;

  public UnobservedErrorNotifier(Task<?> paramTask)
  {
    this.task = paramTask;
  }

  protected void finalize()
    throws Throwable
  {
    try
    {
      Task localTask = this.task;
      if (localTask != null)
      {
        Task.UnobservedExceptionHandler localUnobservedExceptionHandler = Task.getUnobservedExceptionHandler();
        if (localUnobservedExceptionHandler != null)
          localUnobservedExceptionHandler.unobservedException(localTask, new UnobservedTaskException(localTask.getError()));
      }
      return;
    }
    finally
    {
      super.finalize();
    }
    throw localObject;
  }

  public void setObserved()
  {
    this.task = null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     bolts.UnobservedErrorNotifier
 * JD-Core Version:    0.6.0
 */