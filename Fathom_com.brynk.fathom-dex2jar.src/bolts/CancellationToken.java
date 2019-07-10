package bolts;

import java.util.Locale;
import java.util.concurrent.CancellationException;

public class CancellationToken
{
  private final CancellationTokenSource tokenSource;

  CancellationToken(CancellationTokenSource paramCancellationTokenSource)
  {
    this.tokenSource = paramCancellationTokenSource;
  }

  public boolean isCancellationRequested()
  {
    return this.tokenSource.isCancellationRequested();
  }

  public CancellationTokenRegistration register(Runnable paramRunnable)
  {
    return this.tokenSource.register(paramRunnable);
  }

  public void throwIfCancellationRequested()
    throws CancellationException
  {
    this.tokenSource.throwIfCancellationRequested();
  }

  public String toString()
  {
    return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.tokenSource.isCancellationRequested()) });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     bolts.CancellationToken
 * JD-Core Version:    0.6.0
 */