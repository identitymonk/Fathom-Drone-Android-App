package javax.annotation.meta;

public enum When
{
  static
  {
    MAYBE = new When("MAYBE", 2);
    NEVER = new When("NEVER", 3);
    $VALUES = new When[] { ALWAYS, UNKNOWN, MAYBE, NEVER };
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     javax.annotation.meta.When
 * JD-Core Version:    0.6.0
 */