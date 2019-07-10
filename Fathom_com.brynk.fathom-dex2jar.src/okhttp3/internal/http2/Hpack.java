package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Hpack
{
  static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
  private static final int PREFIX_4_BITS = 15;
  private static final int PREFIX_5_BITS = 31;
  private static final int PREFIX_6_BITS = 63;
  private static final int PREFIX_7_BITS = 127;
  static final Header[] STATIC_HEADER_TABLE = { new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "") };

  static
  {
    NAME_TO_FIRST_INDEX = nameToFirstIndex();
  }

  static ByteString checkLowercase(ByteString paramByteString)
    throws IOException
  {
    int i = 0;
    int j = paramByteString.size();
    while (i < j)
    {
      int k = paramByteString.getByte(i);
      if ((k >= 65) && (k <= 90))
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + paramByteString.utf8());
      i += 1;
    }
    return paramByteString;
  }

  private static Map<ByteString, Integer> nameToFirstIndex()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
    int i = 0;
    while (i < STATIC_HEADER_TABLE.length)
    {
      if (!localLinkedHashMap.containsKey(STATIC_HEADER_TABLE[i].name))
        localLinkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
      i += 1;
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }

  static final class Reader
  {
    Header[] dynamicTable = new Header[8];
    int dynamicTableByteCount = 0;
    int headerCount = 0;
    private final List<Header> headerList = new ArrayList();
    private final int headerTableSizeSetting;
    private int maxDynamicTableByteCount;
    int nextHeaderIndex = this.dynamicTable.length - 1;
    private final BufferedSource source;

    Reader(int paramInt1, int paramInt2, Source paramSource)
    {
      this.headerTableSizeSetting = paramInt1;
      this.maxDynamicTableByteCount = paramInt2;
      this.source = Okio.buffer(paramSource);
    }

    Reader(int paramInt, Source paramSource)
    {
      this(paramInt, paramInt, paramSource);
    }

    private void adjustDynamicTableByteCount()
    {
      if (this.maxDynamicTableByteCount < this.dynamicTableByteCount)
      {
        if (this.maxDynamicTableByteCount == 0)
          clearDynamicTable();
      }
      else
        return;
      evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
    }

    private void clearDynamicTable()
    {
      Arrays.fill(this.dynamicTable, null);
      this.nextHeaderIndex = (this.dynamicTable.length - 1);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
    }

    private int dynamicTableIndex(int paramInt)
    {
      return this.nextHeaderIndex + 1 + paramInt;
    }

    private int evictToRecoverBytes(int paramInt)
    {
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.dynamicTable.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.nextHeaderIndex) && (j > 0))
        {
          j -= this.dynamicTable[i].hpackSize;
          this.dynamicTableByteCount -= this.dynamicTable[i].hpackSize;
          this.headerCount -= 1;
          paramInt += 1;
          i -= 1;
        }
        System.arraycopy(this.dynamicTable, this.nextHeaderIndex + 1, this.dynamicTable, this.nextHeaderIndex + 1 + paramInt, this.headerCount);
        this.nextHeaderIndex += paramInt;
        i = paramInt;
      }
      return i;
    }

    private ByteString getName(int paramInt)
    {
      if (isStaticHeader(paramInt))
        return Hpack.STATIC_HEADER_TABLE[paramInt].name;
      return this.dynamicTable[dynamicTableIndex(paramInt - Hpack.STATIC_HEADER_TABLE.length)].name;
    }

    private void insertIntoDynamicTable(int paramInt, Header paramHeader)
    {
      this.headerList.add(paramHeader);
      int j = paramHeader.hpackSize;
      int i = j;
      if (paramInt != -1)
        i = j - this.dynamicTable[dynamicTableIndex(paramInt)].hpackSize;
      if (i > this.maxDynamicTableByteCount)
      {
        clearDynamicTable();
        return;
      }
      j = evictToRecoverBytes(this.dynamicTableByteCount + i - this.maxDynamicTableByteCount);
      if (paramInt == -1)
      {
        if (this.headerCount + 1 > this.dynamicTable.length)
        {
          Header[] arrayOfHeader = new Header[this.dynamicTable.length * 2];
          System.arraycopy(this.dynamicTable, 0, arrayOfHeader, this.dynamicTable.length, this.dynamicTable.length);
          this.nextHeaderIndex = (this.dynamicTable.length - 1);
          this.dynamicTable = arrayOfHeader;
        }
        paramInt = this.nextHeaderIndex;
        this.nextHeaderIndex = (paramInt - 1);
        this.dynamicTable[paramInt] = paramHeader;
        this.headerCount += 1;
      }
      while (true)
      {
        this.dynamicTableByteCount += i;
        return;
        int k = dynamicTableIndex(paramInt);
        this.dynamicTable[(paramInt + (k + j))] = paramHeader;
      }
    }

    private boolean isStaticHeader(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= Hpack.STATIC_HEADER_TABLE.length - 1);
    }

    private int readByte()
      throws IOException
    {
      return this.source.readByte() & 0xFF;
    }

    private void readIndexedHeader(int paramInt)
      throws IOException
    {
      if (isStaticHeader(paramInt))
      {
        Header localHeader = Hpack.STATIC_HEADER_TABLE[paramInt];
        this.headerList.add(localHeader);
        return;
      }
      int i = dynamicTableIndex(paramInt - Hpack.STATIC_HEADER_TABLE.length);
      if ((i < 0) || (i > this.dynamicTable.length - 1))
        throw new IOException("Header index too large " + (paramInt + 1));
      this.headerList.add(this.dynamicTable[i]);
    }

    private void readLiteralHeaderWithIncrementalIndexingIndexedName(int paramInt)
      throws IOException
    {
      insertIntoDynamicTable(-1, new Header(getName(paramInt), readByteString()));
    }

    private void readLiteralHeaderWithIncrementalIndexingNewName()
      throws IOException
    {
      insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
    }

    private void readLiteralHeaderWithoutIndexingIndexedName(int paramInt)
      throws IOException
    {
      ByteString localByteString1 = getName(paramInt);
      ByteString localByteString2 = readByteString();
      this.headerList.add(new Header(localByteString1, localByteString2));
    }

    private void readLiteralHeaderWithoutIndexingNewName()
      throws IOException
    {
      ByteString localByteString1 = Hpack.checkLowercase(readByteString());
      ByteString localByteString2 = readByteString();
      this.headerList.add(new Header(localByteString1, localByteString2));
    }

    public List<Header> getAndResetHeaderList()
    {
      ArrayList localArrayList = new ArrayList(this.headerList);
      this.headerList.clear();
      return localArrayList;
    }

    int maxDynamicTableByteCount()
    {
      return this.maxDynamicTableByteCount;
    }

    ByteString readByteString()
      throws IOException
    {
      int j = readByte();
      if ((j & 0x80) == 128);
      for (int i = 1; ; i = 0)
      {
        j = readInt(j, 127);
        if (i == 0)
          break;
        return ByteString.of(Huffman.get().decode(this.source.readByteArray(j)));
      }
      return this.source.readByteString(j);
    }

    void readHeaders()
      throws IOException
    {
      while (!this.source.exhausted())
      {
        int i = this.source.readByte() & 0xFF;
        if (i == 128)
          throw new IOException("index == 0");
        if ((i & 0x80) == 128)
        {
          readIndexedHeader(readInt(i, 127) - 1);
          continue;
        }
        if (i == 64)
        {
          readLiteralHeaderWithIncrementalIndexingNewName();
          continue;
        }
        if ((i & 0x40) == 64)
        {
          readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i, 63) - 1);
          continue;
        }
        if ((i & 0x20) == 32)
        {
          this.maxDynamicTableByteCount = readInt(i, 31);
          if ((this.maxDynamicTableByteCount < 0) || (this.maxDynamicTableByteCount > this.headerTableSizeSetting))
            throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
          adjustDynamicTableByteCount();
          continue;
        }
        if ((i == 16) || (i == 0))
        {
          readLiteralHeaderWithoutIndexingNewName();
          continue;
        }
        readLiteralHeaderWithoutIndexingIndexedName(readInt(i, 15) - 1);
      }
    }

    int readInt(int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 &= paramInt2;
      if (paramInt1 < paramInt2)
        return paramInt1;
      paramInt1 = 0;
      int i;
      while (true)
      {
        i = readByte();
        if ((i & 0x80) == 0)
          break;
        paramInt2 += ((i & 0x7F) << paramInt1);
        paramInt1 += 7;
      }
      return paramInt2 + (i << paramInt1);
    }
  }

  static final class Writer
  {
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    Header[] dynamicTable = new Header[8];
    int dynamicTableByteCount = 0;
    private boolean emitDynamicTableSizeUpdate;
    int headerCount = 0;
    int headerTableSizeSetting;
    int maxDynamicTableByteCount;
    int nextHeaderIndex = this.dynamicTable.length - 1;
    private final Buffer out;
    private int smallestHeaderTableSizeSetting = 2147483647;
    private final boolean useCompression;

    Writer(int paramInt, boolean paramBoolean, Buffer paramBuffer)
    {
      this.headerTableSizeSetting = paramInt;
      this.maxDynamicTableByteCount = paramInt;
      this.useCompression = paramBoolean;
      this.out = paramBuffer;
    }

    Writer(Buffer paramBuffer)
    {
      this(4096, true, paramBuffer);
    }

    private void adjustDynamicTableByteCount()
    {
      if (this.maxDynamicTableByteCount < this.dynamicTableByteCount)
      {
        if (this.maxDynamicTableByteCount == 0)
          clearDynamicTable();
      }
      else
        return;
      evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
    }

    private void clearDynamicTable()
    {
      Arrays.fill(this.dynamicTable, null);
      this.nextHeaderIndex = (this.dynamicTable.length - 1);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
    }

    private int evictToRecoverBytes(int paramInt)
    {
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.dynamicTable.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.nextHeaderIndex) && (j > 0))
        {
          j -= this.dynamicTable[i].hpackSize;
          this.dynamicTableByteCount -= this.dynamicTable[i].hpackSize;
          this.headerCount -= 1;
          paramInt += 1;
          i -= 1;
        }
        System.arraycopy(this.dynamicTable, this.nextHeaderIndex + 1, this.dynamicTable, this.nextHeaderIndex + 1 + paramInt, this.headerCount);
        Arrays.fill(this.dynamicTable, this.nextHeaderIndex + 1, this.nextHeaderIndex + 1 + paramInt, null);
        this.nextHeaderIndex += paramInt;
        i = paramInt;
      }
      return i;
    }

    private void insertIntoDynamicTable(Header paramHeader)
    {
      int i = paramHeader.hpackSize;
      if (i > this.maxDynamicTableByteCount)
      {
        clearDynamicTable();
        return;
      }
      evictToRecoverBytes(this.dynamicTableByteCount + i - this.maxDynamicTableByteCount);
      if (this.headerCount + 1 > this.dynamicTable.length)
      {
        Header[] arrayOfHeader = new Header[this.dynamicTable.length * 2];
        System.arraycopy(this.dynamicTable, 0, arrayOfHeader, this.dynamicTable.length, this.dynamicTable.length);
        this.nextHeaderIndex = (this.dynamicTable.length - 1);
        this.dynamicTable = arrayOfHeader;
      }
      int j = this.nextHeaderIndex;
      this.nextHeaderIndex = (j - 1);
      this.dynamicTable[j] = paramHeader;
      this.headerCount += 1;
      this.dynamicTableByteCount += i;
    }

    void setHeaderTableSizeSetting(int paramInt)
    {
      this.headerTableSizeSetting = paramInt;
      paramInt = Math.min(paramInt, 16384);
      if (this.maxDynamicTableByteCount == paramInt)
        return;
      if (paramInt < this.maxDynamicTableByteCount)
        this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, paramInt);
      this.emitDynamicTableSizeUpdate = true;
      this.maxDynamicTableByteCount = paramInt;
      adjustDynamicTableByteCount();
    }

    void writeByteString(ByteString paramByteString)
      throws IOException
    {
      if ((this.useCompression) && (Huffman.get().encodedLength(paramByteString) < paramByteString.size()))
      {
        Buffer localBuffer = new Buffer();
        Huffman.get().encode(paramByteString, localBuffer);
        paramByteString = localBuffer.readByteString();
        writeInt(paramByteString.size(), 127, 128);
        this.out.write(paramByteString);
        return;
      }
      writeInt(paramByteString.size(), 127, 0);
      this.out.write(paramByteString);
    }

    void writeHeaders(List<Header> paramList)
      throws IOException
    {
      if (this.emitDynamicTableSizeUpdate)
      {
        if (this.smallestHeaderTableSizeSetting < this.maxDynamicTableByteCount)
          writeInt(this.smallestHeaderTableSizeSetting, 31, 32);
        this.emitDynamicTableSizeUpdate = false;
        this.smallestHeaderTableSizeSetting = 2147483647;
        writeInt(this.maxDynamicTableByteCount, 31, 32);
      }
      int k = 0;
      int i2 = paramList.size();
      if (k < i2)
      {
        Header localHeader = (Header)paramList.get(k);
        ByteString localByteString1 = localHeader.name.toAsciiLowercase();
        ByteString localByteString2 = localHeader.value;
        int n = -1;
        int j = -1;
        Integer localInteger = (Integer)Hpack.NAME_TO_FIRST_INDEX.get(localByteString1);
        int i = n;
        int m;
        if (localInteger != null)
        {
          m = localInteger.intValue() + 1;
          i = n;
          j = m;
          if (m > 1)
          {
            i = n;
            j = m;
            if (m < 8)
            {
              if (!Util.equal(Hpack.STATIC_HEADER_TABLE[(m - 1)].value, localByteString2))
                break label309;
              i = m;
              j = m;
            }
          }
        }
        label188: int i1 = i;
        n = j;
        if (i == -1)
        {
          m = this.nextHeaderIndex + 1;
          int i3 = this.dynamicTable.length;
          label214: i1 = i;
          n = j;
          if (m < i3)
          {
            n = j;
            if (!Util.equal(this.dynamicTable[m].name, localByteString1))
              break label365;
            if (!Util.equal(this.dynamicTable[m].value, localByteString2))
              break label343;
            i1 = m - this.nextHeaderIndex + Hpack.STATIC_HEADER_TABLE.length;
            n = j;
          }
        }
        if (i1 != -1)
          writeInt(i1, 127, 128);
        while (true)
        {
          k += 1;
          break;
          label309: i = n;
          j = m;
          if (!Util.equal(Hpack.STATIC_HEADER_TABLE[m].value, localByteString2))
            break label188;
          i = m + 1;
          j = m;
          break label188;
          label343: n = j;
          if (j == -1)
            n = m - this.nextHeaderIndex + Hpack.STATIC_HEADER_TABLE.length;
          label365: m += 1;
          j = n;
          break label214;
          if (n == -1)
          {
            this.out.writeByte(64);
            writeByteString(localByteString1);
            writeByteString(localByteString2);
            insertIntoDynamicTable(localHeader);
            continue;
          }
          if ((localByteString1.startsWith(Header.PSEUDO_PREFIX)) && (!Header.TARGET_AUTHORITY.equals(localByteString1)))
          {
            writeInt(n, 15, 0);
            writeByteString(localByteString2);
            continue;
          }
          writeInt(n, 63, 64);
          writeByteString(localByteString2);
          insertIntoDynamicTable(localHeader);
        }
      }
    }

    void writeInt(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 < paramInt2)
      {
        this.out.writeByte(paramInt3 | paramInt1);
        return;
      }
      this.out.writeByte(paramInt3 | paramInt2);
      paramInt1 -= paramInt2;
      while (paramInt1 >= 128)
      {
        this.out.writeByte(paramInt1 & 0x7F | 0x80);
        paramInt1 >>>= 7;
      }
      this.out.writeByte(paramInt1);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Hpack
 * JD-Core Version:    0.6.0
 */