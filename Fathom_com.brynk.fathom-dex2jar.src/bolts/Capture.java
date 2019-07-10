package bolts;

public class Capture<T>
{
  private T value;

  public Capture()
  {
  }

  public Capture(T paramT)
  {
    this.value = paramT;
  }

  public T get()
  {
    return this.value;
  }

  public void set(T paramT)
  {
    this.value = paramT;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     bolts.Capture
 * JD-Core Version:    0.6.0
 */