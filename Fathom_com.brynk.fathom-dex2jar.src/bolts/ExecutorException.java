package bolts;

public class ExecutorException extends RuntimeException
{
  public ExecutorException(Exception paramException)
  {
    super("An exception was thrown by an Executor", paramException);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     bolts.ExecutorException
 * JD-Core Version:    0.6.0
 */