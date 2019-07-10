package okio;

import java.util.AbstractList;
import java.util.RandomAccess;

public final class Options extends AbstractList<ByteString>
  implements RandomAccess
{
  final ByteString[] byteStrings;

  private Options(ByteString[] paramArrayOfByteString)
  {
    this.byteStrings = paramArrayOfByteString;
  }

  public static Options of(ByteString[] paramArrayOfByteString)
  {
    return new Options((ByteString[])paramArrayOfByteString.clone());
  }

  public ByteString get(int paramInt)
  {
    return this.byteStrings[paramInt];
  }

  public int size()
  {
    return this.byteStrings.length;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okio.Options
 * JD-Core Version:    0.6.0
 */