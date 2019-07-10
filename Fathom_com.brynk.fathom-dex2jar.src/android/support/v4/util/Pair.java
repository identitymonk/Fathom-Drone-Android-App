package android.support.v4.util;

public class Pair<F, S>
{
  public final F first;
  public final S second;

  public Pair(F paramF, S paramS)
  {
    this.first = paramF;
    this.second = paramS;
  }

  public static <A, B> Pair<A, B> create(A paramA, B paramB)
  {
    return new Pair(paramA, paramB);
  }

  private static boolean objectsEqual(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Pair));
    do
    {
      return false;
      paramObject = (Pair)paramObject;
    }
    while ((!objectsEqual(paramObject.first, this.first)) || (!objectsEqual(paramObject.second, this.second)));
    return true;
  }

  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.first == null)
    {
      i = 0;
      if (this.second != null)
        break label33;
    }
    while (true)
    {
      return i ^ j;
      i = this.first.hashCode();
      break;
      label33: j = this.second.hashCode();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.util.Pair
 * JD-Core Version:    0.6.0
 */