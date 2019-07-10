package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser
{
  private int beg;
  private char[] chars;
  private int cur;
  private final String dn;
  private int end;
  private final int length;
  private int pos;

  public DistinguishedNameParser(X500Principal paramX500Principal)
  {
    this.dn = paramX500Principal.getName("RFC2253");
    this.length = this.dn.length();
  }

  private String escapedAV()
  {
    this.beg = this.pos;
    this.end = this.pos;
    do
    {
      while (true)
      {
        if (this.pos >= this.length)
          return new String(this.chars, this.beg, this.end - this.beg);
        switch (this.chars[this.pos])
        {
        default:
          arrayOfChar = this.chars;
          i = this.end;
          this.end = (i + 1);
          arrayOfChar[i] = this.chars[this.pos];
          this.pos += 1;
          break;
        case '+':
        case ',':
        case ';':
          return new String(this.chars, this.beg, this.end - this.beg);
        case '\\':
          arrayOfChar = this.chars;
          i = this.end;
          this.end = (i + 1);
          arrayOfChar[i] = getEscaped();
          this.pos += 1;
        case ' ':
        }
      }
      this.cur = this.end;
      this.pos += 1;
      char[] arrayOfChar = this.chars;
      int i = this.end;
      this.end = (i + 1);
      arrayOfChar[i] = ' ';
      while ((this.pos < this.length) && (this.chars[this.pos] == ' '))
      {
        arrayOfChar = this.chars;
        i = this.end;
        this.end = (i + 1);
        arrayOfChar[i] = ' ';
        this.pos += 1;
      }
    }
    while ((this.pos != this.length) && (this.chars[this.pos] != ',') && (this.chars[this.pos] != '+') && (this.chars[this.pos] != ';'));
    return new String(this.chars, this.beg, this.cur - this.beg);
  }

  private int getByte(int paramInt)
  {
    if (paramInt + 1 >= this.length)
      throw new IllegalStateException("Malformed DN: " + this.dn);
    int i = this.chars[paramInt];
    if ((i >= 48) && (i <= 57))
    {
      i -= 48;
      paramInt = this.chars[(paramInt + 1)];
      if ((paramInt < 48) || (paramInt > 57))
        break label166;
      paramInt -= 48;
    }
    while (true)
    {
      return (i << 4) + paramInt;
      if ((i >= 97) && (i <= 102))
      {
        i -= 87;
        break;
      }
      if ((i >= 65) && (i <= 70))
      {
        i -= 55;
        break;
      }
      throw new IllegalStateException("Malformed DN: " + this.dn);
      label166: if ((paramInt >= 97) && (paramInt <= 102))
      {
        paramInt -= 87;
        continue;
      }
      if ((paramInt < 65) || (paramInt > 70))
        break label206;
      paramInt -= 55;
    }
    label206: throw new IllegalStateException("Malformed DN: " + this.dn);
  }

  private char getEscaped()
  {
    this.pos += 1;
    if (this.pos == this.length)
      throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    switch (this.chars[this.pos])
    {
    default:
      return getUTF8();
    case ' ':
    case '"':
    case '#':
    case '%':
    case '*':
    case '+':
    case ',':
    case ';':
    case '<':
    case '=':
    case '>':
    case '\\':
    case '_':
    }
    return this.chars[this.pos];
  }

  private char getUTF8()
  {
    int j = 63;
    int k = getByte(this.pos);
    this.pos += 1;
    int i;
    if (k < 128)
      i = (char)k;
    do
    {
      do
      {
        return i;
        i = j;
      }
      while (k < 192);
      i = j;
    }
    while (k > 247);
    int m;
    if (k <= 223)
    {
      m = 1;
      k &= 31;
    }
    int n;
    while (true)
    {
      int i1 = 0;
      n = k;
      k = i1;
      while (true)
      {
        if (k >= m)
          break label214;
        this.pos += 1;
        i = j;
        if (this.pos == this.length)
          break;
        i = j;
        if (this.chars[this.pos] != '\\')
          break;
        this.pos += 1;
        i1 = getByte(this.pos);
        this.pos += 1;
        i = j;
        if ((i1 & 0xC0) != 128)
          break;
        n = (n << 6) + (i1 & 0x3F);
        k += 1;
      }
      if (k <= 239)
      {
        m = 2;
        k &= 15;
        continue;
      }
      m = 3;
      k &= 7;
    }
    label214: return (char)n;
  }

  private String hexAV()
  {
    if (this.pos + 4 >= this.length)
      throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    this.beg = this.pos;
    this.pos += 1;
    int k;
    while (true)
    {
      if ((this.pos == this.length) || (this.chars[this.pos] == '+') || (this.chars[this.pos] == ',') || (this.chars[this.pos] == ';'))
        this.end = this.pos;
      while (true)
      {
        k = this.end - this.beg;
        if ((k >= 5) && ((k & 0x1) != 0))
          break label307;
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        if (this.chars[this.pos] != ' ')
          break;
        this.end = this.pos;
        this.pos += 1;
        while ((this.pos < this.length) && (this.chars[this.pos] == ' '))
          this.pos += 1;
      }
      if ((this.chars[this.pos] >= 'A') && (this.chars[this.pos] <= 'F'))
      {
        localObject = this.chars;
        i = this.pos;
        localObject[i] = (char)(localObject[i] + ' ');
      }
      this.pos += 1;
    }
    label307: Object localObject = new byte[k / 2];
    int i = 0;
    int j = this.beg + 1;
    while (i < localObject.length)
    {
      localObject[i] = (byte)getByte(j);
      j += 2;
      i += 1;
    }
    return (String)new String(this.chars, this.beg, k);
  }

  private String nextAT()
  {
    while ((this.pos < this.length) && (this.chars[this.pos] == ' '))
      this.pos += 1;
    if (this.pos == this.length)
      return null;
    this.beg = this.pos;
    this.pos += 1;
    while ((this.pos < this.length) && (this.chars[this.pos] != '=') && (this.chars[this.pos] != ' '))
      this.pos += 1;
    if (this.pos >= this.length)
      throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    this.end = this.pos;
    if (this.chars[this.pos] == ' ')
    {
      while ((this.pos < this.length) && (this.chars[this.pos] != '=') && (this.chars[this.pos] == ' '))
        this.pos += 1;
      if ((this.chars[this.pos] != '=') || (this.pos == this.length))
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }
    this.pos += 1;
    while ((this.pos < this.length) && (this.chars[this.pos] == ' '))
      this.pos += 1;
    if ((this.end - this.beg > 4) && (this.chars[(this.beg + 3)] == '.') && ((this.chars[this.beg] == 'O') || (this.chars[this.beg] == 'o')) && ((this.chars[(this.beg + 1)] == 'I') || (this.chars[(this.beg + 1)] == 'i')) && ((this.chars[(this.beg + 2)] == 'D') || (this.chars[(this.beg + 2)] == 'd')))
      this.beg += 4;
    return new String(this.chars, this.beg, this.end - this.beg);
  }

  private String quotedAV()
  {
    this.pos += 1;
    this.beg = this.pos;
    this.end = this.beg;
    if (this.pos == this.length)
      throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    if (this.chars[this.pos] == '"')
    {
      this.pos += 1;
      while ((this.pos < this.length) && (this.chars[this.pos] == ' '))
        this.pos += 1;
    }
    if (this.chars[this.pos] == '\\')
      this.chars[this.end] = getEscaped();
    while (true)
    {
      this.pos += 1;
      this.end += 1;
      break;
      this.chars[this.end] = this.chars[this.pos];
    }
    return new String(this.chars, this.beg, this.end - this.beg);
  }

  public String findMostSpecific(String paramString)
  {
    this.pos = 0;
    this.beg = 0;
    this.end = 0;
    this.cur = 0;
    this.chars = this.dn.toCharArray();
    String str1 = nextAT();
    String str2 = str1;
    if (str1 == null)
    {
      str1 = null;
      return str1;
    }
    str1 = "";
    if (this.pos == this.length)
      return null;
    switch (this.chars[this.pos])
    {
    default:
      str1 = escapedAV();
    case '+':
    case ',':
    case ';':
    case '"':
    case '#':
    }
    while (!paramString.equalsIgnoreCase(str2))
    {
      if (this.pos < this.length)
        break label162;
      return null;
      str1 = quotedAV();
      continue;
      str1 = hexAV();
    }
    label162: if ((this.chars[this.pos] == ',') || (this.chars[this.pos] == ';'));
    do
    {
      this.pos += 1;
      str1 = nextAT();
      str2 = str1;
      if (str1 != null)
        break;
      throw new IllegalStateException("Malformed DN: " + this.dn);
    }
    while (this.chars[this.pos] == '+');
    throw new IllegalStateException("Malformed DN: " + this.dn);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.tls.DistinguishedNameParser
 * JD-Core Version:    0.6.0
 */