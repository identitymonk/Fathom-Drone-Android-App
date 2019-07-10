package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class zzaqp
  implements Closeable
{
  private static final char[] bro = ")]}'\n".toCharArray();
  private int[] brA;
  private boolean brp = false;
  private final char[] brq = new char[1024];
  private int brr = 0;
  private int brs = 0;
  private int brt = 0;
  private long bru;
  private int brv;
  private String brw;
  private int[] brx = new int[32];
  private int bry = 0;
  private String[] brz;
  private final Reader in;
  private int limit = 0;
  private int pos = 0;

  static
  {
    zzapu.bph = new zzapu()
    {
      public void zzi(zzaqp paramzzaqp)
        throws IOException
      {
        if ((paramzzaqp instanceof zzaqf))
        {
          ((zzaqf)paramzzaqp).bt();
          return;
        }
        int j = zzaqp.zzag(paramzzaqp);
        int i = j;
        if (j == 0)
          i = zzaqp.zzah(paramzzaqp);
        if (i == 13)
        {
          zzaqp.zza(paramzzaqp, 9);
          return;
        }
        if (i == 12)
        {
          zzaqp.zza(paramzzaqp, 8);
          return;
        }
        if (i == 14)
        {
          zzaqp.zza(paramzzaqp, 10);
          return;
        }
        String str = String.valueOf(paramzzaqp.bq());
        i = zzaqp.zzai(paramzzaqp);
        j = zzaqp.zzaj(paramzzaqp);
        paramzzaqp = paramzzaqp.getPath();
        throw new IllegalStateException(String.valueOf(str).length() + 70 + String.valueOf(paramzzaqp).length() + "Expected a name but was " + str + " " + " at line " + i + " column " + j + " path " + paramzzaqp);
      }
    };
  }

  public zzaqp(Reader paramReader)
  {
    int[] arrayOfInt = this.brx;
    int i = this.bry;
    this.bry = (i + 1);
    arrayOfInt[i] = 6;
    this.brz = new String[32];
    this.brA = new int[32];
    if (paramReader == null)
      throw new NullPointerException("in == null");
    this.in = paramReader;
  }

  private int bD()
    throws IOException
  {
    int i = this.brx[(this.bry - 1)];
    if (i == 1)
    {
      this.brx[(this.bry - 1)] = 2;
      switch (zzdi(true))
      {
      default:
        this.pos -= 1;
        if (this.bry == 1)
          bI();
        i = bE();
        if (i == 0)
          break;
      case 93:
      case 44:
      case 59:
      case 39:
      case 34:
      case 91:
      case 123:
      }
    }
    int j;
    do
    {
      return i;
      if (i == 2)
      {
        switch (zzdi(true))
        {
        case 44:
        default:
          throw zzuv("Unterminated array");
        case 93:
          this.brt = 4;
          return 4;
        case 59:
        }
        bI();
        break;
      }
      if ((i == 3) || (i == 5))
      {
        this.brx[(this.bry - 1)] = 4;
        if (i == 5)
          switch (zzdi(true))
          {
          default:
            throw zzuv("Unterminated object");
          case 125:
            this.brt = 2;
            return 2;
          case 59:
            bI();
          case 44:
          }
        j = zzdi(true);
        switch (j)
        {
        default:
          bI();
          this.pos -= 1;
          if (!zzc((char)j))
            break;
          this.brt = 14;
          return 14;
        case 34:
          this.brt = 13;
          return 13;
        case 39:
          bI();
          this.brt = 12;
          return 12;
        case 125:
          if (i != 5)
          {
            this.brt = 2;
            return 2;
          }
          throw zzuv("Expected name");
        }
        throw zzuv("Expected name");
      }
      if (i == 4)
      {
        this.brx[(this.bry - 1)] = 5;
        switch (zzdi(true))
        {
        case 58:
        case 59:
        case 60:
        default:
          throw zzuv("Expected ':'");
        case 61:
        }
        bI();
        if (((this.pos >= this.limit) && (!zzago(1))) || (this.brq[this.pos] != '>'))
          break;
        this.pos += 1;
        break;
      }
      if (i == 6)
      {
        if (this.brp)
          bL();
        this.brx[(this.bry - 1)] = 7;
        break;
      }
      if (i == 7)
      {
        if (zzdi(false) == -1)
        {
          this.brt = 17;
          return 17;
        }
        bI();
        this.pos -= 1;
        break;
      }
      if (i != 8)
        break;
      throw new IllegalStateException("JsonReader is closed");
      if (i == 1)
      {
        this.brt = 4;
        return 4;
      }
      if ((i == 1) || (i == 2))
      {
        bI();
        this.pos -= 1;
        this.brt = 7;
        return 7;
      }
      throw zzuv("Unexpected value");
      bI();
      this.brt = 8;
      return 8;
      if (this.bry == 1)
        bI();
      this.brt = 9;
      return 9;
      this.brt = 3;
      return 3;
      this.brt = 1;
      return 1;
      j = bF();
      i = j;
    }
    while (j != 0);
    if (!zzc(this.brq[this.pos]))
      throw zzuv("Expected value");
    bI();
    this.brt = 10;
    return 10;
  }

  private int bE()
    throws IOException
  {
    int i = this.brq[this.pos];
    String str2;
    String str1;
    int k;
    int j;
    if ((i == 116) || (i == 84))
    {
      str2 = "true";
      str1 = "TRUE";
      i = 5;
      k = str2.length();
      j = 1;
    }
    while (true)
    {
      if (j >= k)
        break label168;
      if ((this.pos + j >= this.limit) && (!zzago(j + 1)))
      {
        return 0;
        if ((i == 102) || (i == 70))
        {
          str2 = "false";
          str1 = "FALSE";
          i = 6;
          break;
        }
        if ((i == 110) || (i == 78))
        {
          str2 = "null";
          str1 = "NULL";
          i = 7;
          break;
        }
        return 0;
      }
      int m = this.brq[(this.pos + j)];
      if ((m != str2.charAt(j)) && (m != str1.charAt(j)))
        return 0;
      j += 1;
    }
    label168: if (((this.pos + k < this.limit) || (zzago(k + 1))) && (zzc(this.brq[(this.pos + k)])))
      return 0;
    this.pos += k;
    this.brt = i;
    return i;
  }

  private int bF()
    throws IOException
  {
    char[] arrayOfChar = this.brq;
    int i2 = this.pos;
    int n = this.limit;
    long l1 = 0L;
    int i = 0;
    int j = 1;
    int k = 0;
    int m = 0;
    int i3 = n;
    int i1 = i3;
    n = i2;
    if (i2 + m == i3)
    {
      if (m == arrayOfChar.length)
        return 0;
      if (zzago(m + 1));
    }
    label101: char c;
    while (true)
    {
      if ((k != 2) || (j == 0) || ((l1 == -9223372036854775808L) && (i == 0)))
        break label520;
      if (i == 0)
        break label512;
      this.bru = l1;
      this.pos += m;
      this.brt = 15;
      return 15;
      n = this.pos;
      i1 = this.limit;
      c = arrayOfChar[(n + m)];
      switch (c)
      {
      default:
        if ((c < '0') || (c > '9'))
        {
          if (!zzc(c))
            continue;
          return 0;
        }
      case '-':
        if (k == 0)
        {
          i = 1;
          k = 1;
        }
      case '+':
      case 'E':
      case 'e':
      case '.':
      }
    }
    while (true)
    {
      int i4 = m + 1;
      m = k;
      i3 = i1;
      i2 = n;
      k = i;
      i = m;
      m = i4;
      break;
      if (k == 5)
      {
        i2 = 6;
        k = i;
        i = i2;
        continue;
      }
      return 0;
      if (k == 5)
      {
        i2 = 6;
        k = i;
        i = i2;
        continue;
      }
      return 0;
      if ((k == 2) || (k == 4))
      {
        i2 = 5;
        k = i;
        i = i2;
        continue;
      }
      return 0;
      if (k == 2)
      {
        i2 = 3;
        k = i;
        i = i2;
        continue;
      }
      return 0;
      if ((k == 1) || (k == 0))
      {
        l1 = -(c - '0');
        i2 = 2;
        k = i;
        i = i2;
        continue;
      }
      if (k == 2)
      {
        if (l1 == 0L)
          return 0;
        long l2 = 10L * l1 - (c - '0');
        if ((l1 > -922337203685477580L) || ((l1 == -922337203685477580L) && (l2 < l1)));
        for (i3 = 1; ; i3 = 0)
        {
          i2 = i;
          l1 = l2;
          j = i3 & j;
          i = k;
          k = i2;
          break;
        }
      }
      if (k == 3)
      {
        i2 = 4;
        k = i;
        i = i2;
        continue;
      }
      if ((k == 5) || (k == 6))
      {
        i2 = 7;
        k = i;
        i = i2;
        continue;
        label512: l1 = -l1;
        break label101;
        label520: if ((k == 2) || (k == 4) || (k == 7))
        {
          this.brv = m;
          this.brt = 16;
          return 16;
        }
        return 0;
      }
      i2 = i;
      i = k;
      k = i2;
    }
  }

  private String bG()
    throws IOException
  {
    Object localObject1 = null;
    int i = 0;
    while (true)
    {
      Object localObject2;
      int j;
      if (this.pos + i < this.limit)
      {
        localObject2 = localObject1;
        j = i;
        switch (this.brq[(this.pos + i)])
        {
        default:
          i += 1;
          break;
        case '#':
        case '/':
        case ';':
        case '=':
        case '\\':
          bI();
          j = i;
          localObject2 = localObject1;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
        case ',':
        case ':':
        case '[':
        case ']':
        case '{':
        case '}':
          label188: if (localObject2 != null);
        }
      }
      for (localObject1 = new String(this.brq, this.pos, j); ; localObject1 = ((StringBuilder)localObject2).toString())
      {
        this.pos = (j + this.pos);
        return localObject1;
        if (i < this.brq.length)
        {
          localObject2 = localObject1;
          j = i;
          if (!zzago(i + 1))
            break label188;
          break;
        }
        localObject2 = localObject1;
        if (localObject1 == null)
          localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.brq, this.pos, i);
        this.pos = (i + this.pos);
        if (zzago(1))
          break label327;
        j = 0;
        break label188;
        ((StringBuilder)localObject2).append(this.brq, this.pos, j);
      }
      label327: i = 0;
      localObject1 = localObject2;
    }
  }

  private void bH()
    throws IOException
  {
    do
    {
      int i = 0;
      while (this.pos + i < this.limit)
        switch (this.brq[(this.pos + i)])
        {
        default:
          i += 1;
          break;
        case '#':
        case '/':
        case ';':
        case '=':
        case '\\':
          bI();
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
        case ',':
        case ':':
        case '[':
        case ']':
        case '{':
        case '}':
          this.pos = (i + this.pos);
          return;
        }
      this.pos = (i + this.pos);
    }
    while (zzago(1));
  }

  private void bI()
    throws IOException
  {
    if (!this.brp)
      throw zzuv("Use JsonReader.setLenient(true) to accept malformed JSON");
  }

  private void bJ()
    throws IOException
  {
    int i;
    do
    {
      if ((this.pos < this.limit) || (zzago(1)))
      {
        char[] arrayOfChar = this.brq;
        i = this.pos;
        this.pos = (i + 1);
        i = arrayOfChar[i];
        if (i != 10)
          continue;
        this.brr += 1;
        this.brs = this.pos;
      }
      return;
    }
    while (i != 13);
  }

  private char bK()
    throws IOException
  {
    if ((this.pos == this.limit) && (!zzago(1)))
      throw zzuv("Unterminated escape sequence");
    Object localObject = this.brq;
    int j = this.pos;
    this.pos = (j + 1);
    int i = localObject[j];
    switch (i)
    {
    default:
      return i;
    case 117:
      if ((this.pos + 4 > this.limit) && (!zzago(4)))
        throw zzuv("Unterminated escape sequence");
      int k = this.pos;
      i = 0;
      j = k;
      if (j < k + 4)
      {
        int m = this.brq[j];
        int n = (char)(i << 4);
        if ((m >= 48) && (m <= 57))
          i = (char)(n + (m - 48));
        while (true)
        {
          j += 1;
          break;
          if ((m >= 97) && (m <= 102))
          {
            i = (char)(n + (m - 97 + 10));
            continue;
          }
          if ((m < 65) || (m > 70))
            break label267;
          i = (char)(n + (m - 65 + 10));
        }
        localObject = String.valueOf(new String(this.brq, this.pos, 4));
        if (((String)localObject).length() != 0);
        for (localObject = "\\u".concat((String)localObject); ; localObject = new String("\\u"))
          throw new NumberFormatException((String)localObject);
      }
      this.pos += 4;
      return i;
    case 116:
      return '\t';
    case 98:
      return '\b';
    case 110:
      return '\n';
    case 114:
      return '\r';
    case 102:
      label267: return '\f';
    case 10:
    }
    this.brr += 1;
    this.brs = this.pos;
    return i;
  }

  private void bL()
    throws IOException
  {
    zzdi(true);
    this.pos -= 1;
    if ((this.pos + bro.length > this.limit) && (!zzago(bro.length)))
      return;
    int i = 0;
    while (true)
    {
      if (i >= bro.length)
        break label80;
      if (this.brq[(this.pos + i)] != bro[i])
        break;
      i += 1;
    }
    label80: this.pos += bro.length;
  }

  private int getColumnNumber()
  {
    return this.pos - this.brs + 1;
  }

  private int getLineNumber()
  {
    return this.brr + 1;
  }

  private void zzagn(int paramInt)
  {
    if (this.bry == this.brx.length)
    {
      arrayOfInt1 = new int[this.bry * 2];
      int[] arrayOfInt2 = new int[this.bry * 2];
      String[] arrayOfString = new String[this.bry * 2];
      System.arraycopy(this.brx, 0, arrayOfInt1, 0, this.bry);
      System.arraycopy(this.brA, 0, arrayOfInt2, 0, this.bry);
      System.arraycopy(this.brz, 0, arrayOfString, 0, this.bry);
      this.brx = arrayOfInt1;
      this.brA = arrayOfInt2;
      this.brz = arrayOfString;
    }
    int[] arrayOfInt1 = this.brx;
    int i = this.bry;
    this.bry = (i + 1);
    arrayOfInt1[i] = paramInt;
  }

  private boolean zzago(int paramInt)
    throws IOException
  {
    int k = 0;
    char[] arrayOfChar = this.brq;
    this.brs -= this.pos;
    if (this.limit != this.pos)
    {
      this.limit -= this.pos;
      System.arraycopy(arrayOfChar, this.pos, arrayOfChar, 0, this.limit);
    }
    while (true)
    {
      this.pos = 0;
      int j;
      while (true)
      {
        int i = this.in.read(arrayOfChar, this.limit, arrayOfChar.length - this.limit);
        j = k;
        if (i == -1)
          break;
        this.limit = (i + this.limit);
        i = paramInt;
        if (this.brr == 0)
        {
          i = paramInt;
          if (this.brs == 0)
          {
            i = paramInt;
            if (this.limit > 0)
            {
              i = paramInt;
              if (arrayOfChar[0] == 65279)
              {
                this.pos += 1;
                this.brs += 1;
                i = paramInt + 1;
              }
            }
          }
        }
        paramInt = i;
        if (this.limit < i)
          continue;
        j = 1;
      }
      return j;
      this.limit = 0;
    }
  }

  private boolean zzc(char paramChar)
    throws IOException
  {
    switch (paramChar)
    {
    default:
      return true;
    case '#':
    case '/':
    case ';':
    case '=':
    case '\\':
      bI();
    case '\t':
    case '\n':
    case '\f':
    case '\r':
    case ' ':
    case ',':
    case ':':
    case '[':
    case ']':
    case '{':
    case '}':
    }
    return false;
  }

  private String zzd(char paramChar)
    throws IOException
  {
    char[] arrayOfChar = this.brq;
    StringBuilder localStringBuilder = new StringBuilder();
    do
    {
      int k = this.pos;
      int j = this.limit;
      int i = k;
      if (i < j)
      {
        int i1 = i + 1;
        char c = arrayOfChar[i];
        if (c == paramChar)
        {
          this.pos = i1;
          localStringBuilder.append(arrayOfChar, k, i1 - k - 1);
          return localStringBuilder.toString();
        }
        int n;
        int m;
        if (c == '\\')
        {
          this.pos = i1;
          localStringBuilder.append(arrayOfChar, k, i1 - k - 1);
          localStringBuilder.append(bK());
          n = this.pos;
          m = this.limit;
          i = n;
        }
        while (true)
        {
          k = n;
          j = m;
          break;
          n = k;
          m = j;
          i = i1;
          if (c != '\n')
            continue;
          this.brr += 1;
          this.brs = i1;
          n = k;
          m = j;
          i = i1;
        }
      }
      localStringBuilder.append(arrayOfChar, k, i - k);
      this.pos = i;
    }
    while (zzago(1));
    throw zzuv("Unterminated string");
  }

  private int zzdi(boolean paramBoolean)
    throws IOException
  {
    Object localObject = this.brq;
    int i = this.pos;
    int j = this.limit;
    while (true)
    {
      int k = j;
      int m = i;
      if (i == j)
      {
        this.pos = i;
        if (!zzago(1))
        {
          if (paramBoolean)
          {
            localObject = String.valueOf("End of input at line ");
            i = getLineNumber();
            j = getColumnNumber();
            throw new EOFException(String.valueOf(localObject).length() + 30 + (String)localObject + i + " column " + j);
          }
        }
        else
        {
          m = this.pos;
          k = this.limit;
        }
      }
      else
      {
        i = m + 1;
        j = localObject[m];
        if (j == 10)
        {
          this.brr += 1;
          this.brs = i;
          j = k;
          continue;
        }
        if ((j == 32) || (j == 13))
          break label385;
        if (j == 9)
        {
          j = k;
          continue;
        }
        if (j == 47)
        {
          this.pos = i;
          if (i == k)
          {
            this.pos -= 1;
            boolean bool = zzago(2);
            this.pos += 1;
            if (!bool)
              return j;
          }
          bI();
          switch (localObject[this.pos])
          {
          default:
            return j;
          case '*':
            this.pos += 1;
            if (!zzuu("*/"))
              throw zzuv("Unterminated comment");
            i = this.pos + 2;
            j = this.limit;
            break;
          case '/':
            this.pos += 1;
            bJ();
            i = this.pos;
            j = this.limit;
            break;
          }
        }
        if (j == 35)
        {
          this.pos = i;
          bI();
          bJ();
          i = this.pos;
          j = this.limit;
          continue;
        }
        this.pos = i;
        return j;
      }
      return -1;
      label385: j = k;
    }
  }

  private void zze(char paramChar)
    throws IOException
  {
    char[] arrayOfChar = this.brq;
    do
    {
      int i = this.pos;
      int j = this.limit;
      if (i < j)
      {
        int m = i + 1;
        char c = arrayOfChar[i];
        if (c == paramChar)
        {
          this.pos = m;
          return;
        }
        int k;
        if (c == '\\')
        {
          this.pos = m;
          bK();
          i = this.pos;
          k = this.limit;
        }
        while (true)
        {
          j = k;
          break;
          k = j;
          i = m;
          if (c != '\n')
            continue;
          this.brr += 1;
          this.brs = m;
          k = j;
          i = m;
        }
      }
      this.pos = i;
    }
    while (zzago(1));
    throw zzuv("Unterminated string");
  }

  private boolean zzuu(String paramString)
    throws IOException
  {
    int k = 0;
    int j;
    while (true)
      if (this.pos + paramString.length() > this.limit)
      {
        j = k;
        if (!zzago(paramString.length()))
          break;
      }
      else
      {
        if (this.brq[this.pos] == '\n')
        {
          this.brr += 1;
          this.brs = (this.pos + 1);
          this.pos += 1;
          continue;
        }
        int i = 0;
        while (true)
        {
          if (i >= paramString.length())
            break label116;
          if (this.brq[(this.pos + i)] != paramString.charAt(i))
            break;
          i += 1;
        }
        label116: j = 1;
      }
    return j;
  }

  private IOException zzuv(String paramString)
    throws IOException
  {
    int i = getLineNumber();
    int j = getColumnNumber();
    String str = getPath();
    throw new zzaqs(String.valueOf(paramString).length() + 45 + String.valueOf(str).length() + paramString + " at line " + i + " column " + j + " path " + str);
  }

  public void beginArray()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    if (i == 3)
    {
      zzagn(1);
      this.brA[(this.bry - 1)] = 0;
      this.brt = 0;
      return;
    }
    String str1 = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    String str2 = getPath();
    throw new IllegalStateException(String.valueOf(str1).length() + 74 + String.valueOf(str2).length() + "Expected BEGIN_ARRAY but was " + str1 + " at line " + i + " column " + j + " path " + str2);
  }

  public void beginObject()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    if (i == 1)
    {
      zzagn(3);
      this.brt = 0;
      return;
    }
    String str1 = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    String str2 = getPath();
    throw new IllegalStateException(String.valueOf(str1).length() + 75 + String.valueOf(str2).length() + "Expected BEGIN_OBJECT but was " + str1 + " at line " + i + " column " + j + " path " + str2);
  }

  public zzaqq bq()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    switch (i)
    {
    default:
      throw new AssertionError();
    case 1:
      return zzaqq.brD;
    case 2:
      return zzaqq.brE;
    case 3:
      return zzaqq.brB;
    case 4:
      return zzaqq.brC;
    case 12:
    case 13:
    case 14:
      return zzaqq.brF;
    case 5:
    case 6:
      return zzaqq.brI;
    case 7:
      return zzaqq.brJ;
    case 8:
    case 9:
    case 10:
    case 11:
      return zzaqq.brG;
    case 15:
    case 16:
      return zzaqq.brH;
    case 17:
    }
    return zzaqq.brK;
  }

  public void close()
    throws IOException
  {
    this.brt = 0;
    this.brx[0] = 8;
    this.bry = 1;
    this.in.close();
  }

  public void endArray()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    if (i == 4)
    {
      this.bry -= 1;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      this.brt = 0;
      return;
    }
    Object localObject = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    String str = getPath();
    throw new IllegalStateException(String.valueOf(localObject).length() + 72 + String.valueOf(str).length() + "Expected END_ARRAY but was " + (String)localObject + " at line " + i + " column " + j + " path " + str);
  }

  public void endObject()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    if (i == 2)
    {
      this.bry -= 1;
      this.brz[this.bry] = null;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      this.brt = 0;
      return;
    }
    Object localObject = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    String str = getPath();
    throw new IllegalStateException(String.valueOf(localObject).length() + 73 + String.valueOf(str).length() + "Expected END_OBJECT but was " + (String)localObject + " at line " + i + " column " + j + " path " + str);
  }

  public String getPath()
  {
    StringBuilder localStringBuilder = new StringBuilder().append('$');
    int i = 0;
    int j = this.bry;
    if (i < j)
    {
      switch (this.brx[i])
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      while (true)
      {
        i += 1;
        break;
        localStringBuilder.append('[').append(this.brA[i]).append(']');
        continue;
        localStringBuilder.append('.');
        if (this.brz[i] == null)
          continue;
        localStringBuilder.append(this.brz[i]);
      }
    }
    return localStringBuilder.toString();
  }

  public boolean hasNext()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    return (i != 2) && (i != 4);
  }

  public final boolean isLenient()
  {
    return this.brp;
  }

  public boolean nextBoolean()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    if (i == 5)
    {
      this.brt = 0;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      return true;
    }
    if (i == 6)
    {
      this.brt = 0;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      return false;
    }
    Object localObject = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    String str = getPath();
    throw new IllegalStateException(String.valueOf(localObject).length() + 72 + String.valueOf(str).length() + "Expected a boolean but was " + (String)localObject + " at line " + i + " column " + j + " path " + str);
  }

  public double nextDouble()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    if (i == 15)
    {
      this.brt = 0;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      return this.bru;
    }
    if (i == 16)
    {
      this.brw = new String(this.brq, this.pos, this.brv);
      this.pos += this.brv;
    }
    double d;
    while (true)
    {
      this.brt = 11;
      d = Double.parseDouble(this.brw);
      if ((this.brp) || ((!Double.isNaN(d)) && (!Double.isInfinite(d))))
        break;
      i = getLineNumber();
      j = getColumnNumber();
      localObject = getPath();
      throw new zzaqs(String.valueOf(localObject).length() + 102 + "JSON forbids NaN and infinities: " + d + " at line " + i + " column " + j + " path " + (String)localObject);
      if ((i == 8) || (i == 9))
      {
        if (i == 8);
        for (char c = '\''; ; c = '"')
        {
          this.brw = zzd(c);
          break;
        }
      }
      if (i == 10)
      {
        this.brw = bG();
        continue;
      }
      if (i == 11)
        continue;
      localObject = String.valueOf(bq());
      i = getLineNumber();
      j = getColumnNumber();
      String str = getPath();
      throw new IllegalStateException(String.valueOf(localObject).length() + 71 + String.valueOf(str).length() + "Expected a double but was " + (String)localObject + " at line " + i + " column " + j + " path " + str);
    }
    this.brw = null;
    this.brt = 0;
    Object localObject = this.brA;
    i = this.bry - 1;
    localObject[i] += 1;
    return d;
  }

  public int nextInt()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    Object localObject1;
    if (i == 15)
    {
      i = (int)this.bru;
      if (this.bru != i)
      {
        long l = this.bru;
        i = getLineNumber();
        j = getColumnNumber();
        localObject1 = getPath();
        throw new NumberFormatException(String.valueOf(localObject1).length() + 89 + "Expected an int but was " + l + " at line " + i + " column " + j + " path " + (String)localObject1);
      }
      this.brt = 0;
      localObject1 = this.brA;
      j = this.bry - 1;
      localObject1[j] += 1;
      return i;
    }
    String str;
    if (i == 16)
    {
      this.brw = new String(this.brq, this.pos, this.brv);
      this.pos += this.brv;
      this.brt = 11;
      double d = Double.parseDouble(this.brw);
      i = (int)d;
      if (i != d)
      {
        localObject1 = this.brw;
        i = getLineNumber();
        j = getColumnNumber();
        str = getPath();
        throw new NumberFormatException(String.valueOf(localObject1).length() + 69 + String.valueOf(str).length() + "Expected an int but was " + (String)localObject1 + " at line " + i + " column " + j + " path " + str);
      }
    }
    else
    {
      if ((i == 8) || (i == 9))
      {
        if (i == 8);
        for (char c = '\''; ; c = '"')
        {
          this.brw = zzd(c);
          try
          {
            i = Integer.parseInt(this.brw);
            this.brt = 0;
            localObject1 = this.brA;
            j = this.bry - 1;
            localObject1[j] += 1;
            return i;
          }
          catch (NumberFormatException localNumberFormatException)
          {
          }
          break;
        }
      }
      localObject2 = String.valueOf(bq());
      i = getLineNumber();
      j = getColumnNumber();
      str = getPath();
      throw new IllegalStateException(String.valueOf(localObject2).length() + 69 + String.valueOf(str).length() + "Expected an int but was " + (String)localObject2 + " at line " + i + " column " + j + " path " + str);
    }
    this.brw = null;
    this.brt = 0;
    Object localObject2 = this.brA;
    j = this.bry - 1;
    localObject2[j] += 1;
    return i;
  }

  public long nextLong()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    Object localObject1;
    if (i == 15)
    {
      this.brt = 0;
      localObject1 = this.brA;
      i = this.bry - 1;
      localObject1[i] += 1;
      return this.bru;
    }
    long l;
    String str;
    if (i == 16)
    {
      this.brw = new String(this.brq, this.pos, this.brv);
      this.pos += this.brv;
      this.brt = 11;
      double d = Double.parseDouble(this.brw);
      l = ()d;
      if (l != d)
      {
        localObject1 = this.brw;
        i = getLineNumber();
        j = getColumnNumber();
        str = getPath();
        throw new NumberFormatException(String.valueOf(localObject1).length() + 69 + String.valueOf(str).length() + "Expected a long but was " + (String)localObject1 + " at line " + i + " column " + j + " path " + str);
      }
    }
    else
    {
      if ((i == 8) || (i == 9))
      {
        if (i == 8);
        for (char c = '\''; ; c = '"')
        {
          this.brw = zzd(c);
          try
          {
            l = Long.parseLong(this.brw);
            this.brt = 0;
            localObject1 = this.brA;
            i = this.bry - 1;
            localObject1[i] += 1;
            return l;
          }
          catch (NumberFormatException localNumberFormatException)
          {
          }
          break;
        }
      }
      localObject2 = String.valueOf(bq());
      i = getLineNumber();
      j = getColumnNumber();
      str = getPath();
      throw new IllegalStateException(String.valueOf(localObject2).length() + 69 + String.valueOf(str).length() + "Expected a long but was " + (String)localObject2 + " at line " + i + " column " + j + " path " + str);
    }
    this.brw = null;
    this.brt = 0;
    Object localObject2 = this.brA;
    i = this.bry - 1;
    localObject2[i] += 1;
    return l;
  }

  public String nextName()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    if (i == 14)
      str1 = bG();
    while (true)
    {
      this.brt = 0;
      this.brz[(this.bry - 1)] = str1;
      return str1;
      if (i == 12)
      {
        str1 = zzd('\'');
        continue;
      }
      if (i != 13)
        break;
      str1 = zzd('"');
    }
    String str1 = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    String str2 = getPath();
    throw new IllegalStateException(String.valueOf(str1).length() + 69 + String.valueOf(str2).length() + "Expected a name but was " + str1 + " at line " + i + " column " + j + " path " + str2);
  }

  public void nextNull()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    if (i == 7)
    {
      this.brt = 0;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      return;
    }
    Object localObject = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    String str = getPath();
    throw new IllegalStateException(String.valueOf(localObject).length() + 67 + String.valueOf(str).length() + "Expected null but was " + (String)localObject + " at line " + i + " column " + j + " path " + str);
  }

  public String nextString()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0)
      i = bD();
    if (i == 10)
      str = bG();
    while (true)
    {
      this.brt = 0;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      return str;
      if (i == 8)
      {
        str = zzd('\'');
        continue;
      }
      if (i == 9)
      {
        str = zzd('"');
        continue;
      }
      if (i == 11)
      {
        str = this.brw;
        this.brw = null;
        continue;
      }
      if (i == 15)
      {
        str = Long.toString(this.bru);
        continue;
      }
      if (i != 16)
        break;
      str = new String(this.brq, this.pos, this.brv);
      this.pos += this.brv;
    }
    String str = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    Object localObject = getPath();
    throw new IllegalStateException(String.valueOf(str).length() + 71 + String.valueOf(localObject).length() + "Expected a string but was " + str + " at line " + i + " column " + j + " path " + (String)localObject);
  }

  public final void setLenient(boolean paramBoolean)
  {
    this.brp = paramBoolean;
  }

  public void skipValue()
    throws IOException
  {
    int j = 0;
    int i = this.brt;
    int k = i;
    if (i == 0)
      k = bD();
    if (k == 3)
    {
      zzagn(1);
      i = j + 1;
    }
    while (true)
    {
      this.brt = 0;
      j = i;
      if (i != 0)
        break;
      int[] arrayOfInt = this.brA;
      i = this.bry - 1;
      arrayOfInt[i] += 1;
      this.brz[(this.bry - 1)] = "null";
      return;
      if (k == 1)
      {
        zzagn(3);
        i = j + 1;
        continue;
      }
      if (k == 4)
      {
        this.bry -= 1;
        i = j - 1;
        continue;
      }
      if (k == 2)
      {
        this.bry -= 1;
        i = j - 1;
        continue;
      }
      if ((k == 14) || (k == 10))
      {
        bH();
        i = j;
        continue;
      }
      if ((k == 8) || (k == 12))
      {
        zze('\'');
        i = j;
        continue;
      }
      if ((k == 9) || (k == 13))
      {
        zze('"');
        i = j;
        continue;
      }
      i = j;
      if (k != 16)
        continue;
      this.pos += this.brv;
      i = j;
    }
  }

  public String toString()
  {
    String str = String.valueOf(getClass().getSimpleName());
    int i = getLineNumber();
    int j = getColumnNumber();
    return String.valueOf(str).length() + 39 + str + " at line " + i + " column " + j;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqp
 * JD-Core Version:    0.6.0
 */