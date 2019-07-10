package okhttp3;

import okhttp3.internal.Util;

public final class Challenge
{
  private final String realm;
  private final String scheme;

  public Challenge(String paramString1, String paramString2)
  {
    this.scheme = paramString1;
    this.realm = paramString2;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Challenge)) && (Util.equal(this.scheme, ((Challenge)paramObject).scheme)) && (Util.equal(this.realm, ((Challenge)paramObject).realm));
  }

  public int hashCode()
  {
    int j = 0;
    if (this.realm != null);
    for (int i = this.realm.hashCode(); ; i = 0)
    {
      if (this.scheme != null)
        j = this.scheme.hashCode();
      return (i + 899) * 31 + j;
    }
  }

  public String realm()
  {
    return this.realm;
  }

  public String scheme()
  {
    return this.scheme;
  }

  public String toString()
  {
    return this.scheme + " realm=\"" + this.realm + "\"";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Challenge
 * JD-Core Version:    0.6.0
 */