package okhttp3.internal.cache;

import J;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class DiskLruCache
  implements Closeable, Flushable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  static final Pattern LEGAL_KEY_PATTERN;
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Runnable cleanupRunnable = new Runnable()
  {
    public void run()
    {
      int i = 1;
      synchronized (DiskLruCache.this)
      {
        if (!DiskLruCache.this.initialized)
        {
          if ((i | DiskLruCache.this.closed) != 0)
            return;
        }
        else
          i = 0;
      }
      try
      {
        DiskLruCache.this.trimToSize();
      }
      catch (IOException localIOException2)
      {
        try
        {
          while (true)
          {
            if (DiskLruCache.this.journalRebuildRequired())
            {
              DiskLruCache.this.rebuildJournal();
              DiskLruCache.this.redundantOpCount = 0;
            }
            monitorexit;
            return;
            localObject = finally;
            monitorexit;
            throw localObject;
            localIOException1 = localIOException1;
            DiskLruCache.this.mostRecentTrimFailed = true;
          }
        }
        catch (IOException localIOException2)
        {
          while (true)
          {
            DiskLruCache.this.mostRecentRebuildFailed = true;
            DiskLruCache.this.journalWriter = Okio.buffer(Okio.blackhole());
          }
        }
      }
    }
  };
  boolean closed;
  final File directory;
  private final Executor executor;
  final FileSystem fileSystem;
  boolean hasJournalErrors;
  boolean initialized;
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  BufferedSink journalWriter;
  final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private long maxSize;
  boolean mostRecentRebuildFailed;
  boolean mostRecentTrimFailed;
  private long nextSequenceNumber = 0L;
  int redundantOpCount;
  private long size = 0L;
  final int valueCount;

  static
  {
    if (!DiskLruCache.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
      return;
    }
  }

  DiskLruCache(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong, Executor paramExecutor)
  {
    this.fileSystem = paramFileSystem;
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
    this.executor = paramExecutor;
  }

  private void checkNotClosed()
  {
    monitorenter;
    try
    {
      if (isClosed())
        throw new IllegalStateException("cache is closed");
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public static DiskLruCache create(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("maxSize <= 0");
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("valueCount <= 0");
    return new DiskLruCache(paramFileSystem, paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
  }

  private BufferedSink newJournalWriter()
    throws FileNotFoundException
  {
    return Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile))
    {
      static
      {
        if (!DiskLruCache.class.desiredAssertionStatus());
        for (boolean bool = true; ; bool = false)
        {
          $assertionsDisabled = bool;
          return;
        }
      }

      protected void onException(IOException paramIOException)
      {
        assert (Thread.holdsLock(DiskLruCache.this));
        DiskLruCache.this.hasJournalErrors = true;
      }
    });
  }

  private void processJournal()
    throws IOException
  {
    this.fileSystem.delete(this.journalFileTmp);
    Iterator localIterator = this.lruEntries.values().iterator();
    while (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      if (localEntry.currentEditor == null)
      {
        i = 0;
        while (i < this.valueCount)
        {
          this.size += localEntry.lengths[i];
          i += 1;
        }
        continue;
      }
      localEntry.currentEditor = null;
      int i = 0;
      while (i < this.valueCount)
      {
        this.fileSystem.delete(localEntry.cleanFiles[i]);
        this.fileSystem.delete(localEntry.dirtyFiles[i]);
        i += 1;
      }
      localIterator.remove();
    }
  }

  // ERROR //
  private void readJournal()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 129	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   4: aload_0
    //   5: getfield 140	okhttp3/internal/cache/DiskLruCache:journalFile	Ljava/io/File;
    //   8: invokeinterface 267 2 0
    //   13: invokestatic 270	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 276 1 0
    //   23: astore_3
    //   24: aload_2
    //   25: invokeinterface 276 1 0
    //   30: astore 4
    //   32: aload_2
    //   33: invokeinterface 276 1 0
    //   38: astore 5
    //   40: aload_2
    //   41: invokeinterface 276 1 0
    //   46: astore 6
    //   48: aload_2
    //   49: invokeinterface 276 1 0
    //   54: astore 7
    //   56: ldc 50
    //   58: aload_3
    //   59: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifeq +54 -> 116
    //   65: ldc 57
    //   67: aload 4
    //   69: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifeq +44 -> 116
    //   75: aload_0
    //   76: getfield 133	okhttp3/internal/cache/DiskLruCache:appVersion	I
    //   79: invokestatic 288	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   82: aload 5
    //   84: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +29 -> 116
    //   90: aload_0
    //   91: getfield 146	okhttp3/internal/cache/DiskLruCache:valueCount	I
    //   94: invokestatic 288	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   97: aload 6
    //   99: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq +14 -> 116
    //   105: ldc_w 290
    //   108: aload 7
    //   110: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifne +77 -> 190
    //   116: new 219	java/io/IOException
    //   119: dup
    //   120: new 292	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 295
    //   130: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_3
    //   134: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 301
    //   140: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 4
    //   145: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 301
    //   151: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 6
    //   156: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 301
    //   162: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 7
    //   167: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 303
    //   173: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokespecial 306	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   182: athrow
    //   183: astore_3
    //   184: aload_2
    //   185: invokestatic 310	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   188: aload_3
    //   189: athrow
    //   190: iconst_0
    //   191: istore_1
    //   192: aload_0
    //   193: aload_2
    //   194: invokeinterface 276 1 0
    //   199: invokespecial 313	okhttp3/internal/cache/DiskLruCache:readJournalLine	(Ljava/lang/String;)V
    //   202: iload_1
    //   203: iconst_1
    //   204: iadd
    //   205: istore_1
    //   206: goto -14 -> 192
    //   209: astore_3
    //   210: aload_0
    //   211: iload_1
    //   212: aload_0
    //   213: getfield 120	okhttp3/internal/cache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   216: invokevirtual 316	java/util/LinkedHashMap:size	()I
    //   219: isub
    //   220: putfield 318	okhttp3/internal/cache/DiskLruCache:redundantOpCount	I
    //   223: aload_2
    //   224: invokeinterface 321 1 0
    //   229: ifne +12 -> 241
    //   232: aload_0
    //   233: invokevirtual 324	okhttp3/internal/cache/DiskLruCache:rebuildJournal	()V
    //   236: aload_2
    //   237: invokestatic 310	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   240: return
    //   241: aload_0
    //   242: aload_0
    //   243: invokespecial 326	okhttp3/internal/cache/DiskLruCache:newJournalWriter	()Lokio/BufferedSink;
    //   246: putfield 328	okhttp3/internal/cache/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   249: goto -13 -> 236
    //
    // Exception table:
    //   from	to	target	type
    //   17	116	183	finally
    //   116	183	183	finally
    //   192	202	183	finally
    //   210	236	183	finally
    //   241	249	183	finally
    //   192	202	209	java/io/EOFException
  }

  private void readJournalLine(String paramString)
    throws IOException
  {
    int i = paramString.indexOf(' ');
    if (i == -1)
      throw new IOException("unexpected journal line: " + paramString);
    int j = i + 1;
    int k = paramString.indexOf(' ', j);
    Object localObject2;
    Object localObject1;
    if (k == -1)
    {
      localObject2 = paramString.substring(j);
      localObject1 = localObject2;
      if (i != "REMOVE".length())
        break label112;
      localObject1 = localObject2;
      if (!paramString.startsWith("REMOVE"))
        break label112;
      this.lruEntries.remove(localObject2);
    }
    label112: 
    do
    {
      return;
      localObject1 = paramString.substring(j, k);
      Entry localEntry = (Entry)this.lruEntries.get(localObject1);
      localObject2 = localEntry;
      if (localEntry == null)
      {
        localObject2 = new Entry((String)localObject1);
        this.lruEntries.put(localObject1, localObject2);
      }
      if ((k != -1) && (i == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        ((Entry)localObject2).readable = true;
        ((Entry)localObject2).currentEditor = null;
        ((Entry)localObject2).setLengths(paramString);
        return;
      }
      if ((k != -1) || (i != "DIRTY".length()) || (!paramString.startsWith("DIRTY")))
        continue;
      ((Entry)localObject2).currentEditor = new Editor((Entry)localObject2);
      return;
    }
    while ((k == -1) && (i == "READ".length()) && (paramString.startsWith("READ")));
    throw new IOException("unexpected journal line: " + paramString);
  }

  private void validateKey(String paramString)
  {
    if (!LEGAL_KEY_PATTERN.matcher(paramString).matches())
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + paramString + "\"");
  }

  public void close()
    throws IOException
  {
    monitorenter;
    while (true)
    {
      int i;
      try
      {
        if ((this.initialized) && (!this.closed))
          continue;
        this.closed = true;
        return;
        Entry[] arrayOfEntry = (Entry[])this.lruEntries.values().toArray(new Entry[this.lruEntries.size()]);
        int j = arrayOfEntry.length;
        i = 0;
        if (i >= j)
          continue;
        Entry localEntry = arrayOfEntry[i];
        if (localEntry.currentEditor != null)
        {
          localEntry.currentEditor.abort();
          break label115;
          trimToSize();
          this.journalWriter.close();
          this.journalWriter = null;
          this.closed = true;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      label115: i += 1;
    }
  }

  void completeEdit(Editor paramEditor, boolean paramBoolean)
    throws IOException
  {
    monitorenter;
    Entry localEntry;
    try
    {
      localEntry = paramEditor.entry;
      if (localEntry.currentEditor != paramEditor)
        throw new IllegalStateException();
    }
    finally
    {
      monitorexit;
    }
    if ((paramBoolean) && (!localEntry.readable))
    {
      i = 0;
      while (i < this.valueCount)
      {
        if (paramEditor.written[i] == 0)
        {
          paramEditor.abort();
          throw new IllegalStateException("Newly created entry didn't create value for index " + i);
        }
        if (!this.fileSystem.exists(localEntry.dirtyFiles[i]))
        {
          paramEditor.abort();
          monitorexit;
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    while (true)
    {
      long l1;
      if (i < this.valueCount)
      {
        paramEditor = localEntry.dirtyFiles[i];
        if (paramBoolean)
        {
          if (this.fileSystem.exists(paramEditor))
          {
            File localFile = localEntry.cleanFiles[i];
            this.fileSystem.rename(paramEditor, localFile);
            l1 = localEntry.lengths[i];
            long l2 = this.fileSystem.size(localFile);
            localEntry.lengths[i] = l2;
            this.size = (this.size - l1 + l2);
          }
        }
        else
          this.fileSystem.delete(paramEditor);
      }
      else
      {
        this.redundantOpCount += 1;
        localEntry.currentEditor = null;
        if ((localEntry.readable | paramBoolean))
        {
          localEntry.readable = true;
          this.journalWriter.writeUtf8("CLEAN").writeByte(32);
          this.journalWriter.writeUtf8(localEntry.key);
          localEntry.writeLengths(this.journalWriter);
          this.journalWriter.writeByte(10);
          if (paramBoolean)
          {
            l1 = this.nextSequenceNumber;
            this.nextSequenceNumber = (1L + l1);
            localEntry.sequenceNumber = l1;
          }
        }
        while (true)
        {
          this.journalWriter.flush();
          if ((this.size <= this.maxSize) && (!journalRebuildRequired()))
            break;
          this.executor.execute(this.cleanupRunnable);
          break;
          this.lruEntries.remove(localEntry.key);
          this.journalWriter.writeUtf8("REMOVE").writeByte(32);
          this.journalWriter.writeUtf8(localEntry.key);
          this.journalWriter.writeByte(10);
        }
      }
      i += 1;
    }
  }

  public void delete()
    throws IOException
  {
    close();
    this.fileSystem.deleteContents(this.directory);
  }

  public Editor edit(String paramString)
    throws IOException
  {
    return edit(paramString, -1L);
  }

  Editor edit(String paramString, long paramLong)
    throws IOException
  {
    Object localObject2 = null;
    monitorenter;
    while (true)
    {
      Entry localEntry;
      try
      {
        initialize();
        checkNotClosed();
        validateKey(paramString);
        localEntry = (Entry)this.lruEntries.get(paramString);
        if (paramLong == -1L)
          continue;
        localObject1 = localObject2;
        if (localEntry == null)
          continue;
        long l = localEntry.sequenceNumber;
        if (l == paramLong)
          continue;
        localObject1 = localObject2;
        return localObject1;
        if (localEntry == null)
          continue;
        localObject1 = localObject2;
        if (localEntry.currentEditor != null)
          continue;
        if ((this.mostRecentTrimFailed) || (this.mostRecentRebuildFailed))
        {
          this.executor.execute(this.cleanupRunnable);
          localObject1 = localObject2;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      this.journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(paramString).writeByte(10);
      this.journalWriter.flush();
      Object localObject1 = localObject2;
      if (this.hasJournalErrors)
        continue;
      localObject1 = localEntry;
      if (localEntry == null)
      {
        localObject1 = new Entry(paramString);
        this.lruEntries.put(paramString, localObject1);
      }
      paramString = new Editor((Entry)localObject1);
      ((Entry)localObject1).currentEditor = paramString;
      localObject1 = paramString;
    }
  }

  public void evictAll()
    throws IOException
  {
    int i = 0;
    monitorenter;
    try
    {
      initialize();
      Entry[] arrayOfEntry = (Entry[])this.lruEntries.values().toArray(new Entry[this.lruEntries.size()]);
      int j = arrayOfEntry.length;
      while (i < j)
      {
        removeEntry(arrayOfEntry[i]);
        i += 1;
      }
      this.mostRecentTrimFailed = false;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void flush()
    throws IOException
  {
    monitorenter;
    try
    {
      boolean bool = this.initialized;
      if (!bool);
      while (true)
      {
        return;
        checkNotClosed();
        trimToSize();
        this.journalWriter.flush();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public Snapshot get(String paramString)
    throws IOException
  {
    monitorenter;
    try
    {
      initialize();
      checkNotClosed();
      validateKey(paramString);
      Object localObject = (Entry)this.lruEntries.get(paramString);
      if (localObject != null)
      {
        boolean bool = ((Entry)localObject).readable;
        if (bool);
      }
      else
      {
        paramString = null;
      }
      while (true)
      {
        return paramString;
        localObject = ((Entry)localObject).snapshot();
        if (localObject == null)
        {
          paramString = null;
          continue;
        }
        this.redundantOpCount += 1;
        this.journalWriter.writeUtf8("READ").writeByte(32).writeUtf8(paramString).writeByte(10);
        paramString = (String)localObject;
        if (!journalRebuildRequired())
          continue;
        this.executor.execute(this.cleanupRunnable);
        paramString = (String)localObject;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramString;
  }

  public File getDirectory()
  {
    return this.directory;
  }

  public long getMaxSize()
  {
    monitorenter;
    try
    {
      long l = this.maxSize;
      monitorexit;
      return l;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void initialize()
    throws IOException
  {
    monitorenter;
    try
    {
      if ((!$assertionsDisabled) && (!Thread.holdsLock(this)))
        throw new AssertionError();
    }
    finally
    {
      monitorexit;
    }
    boolean bool = this.initialized;
    if (bool);
    while (true)
    {
      monitorexit;
      return;
      if (this.fileSystem.exists(this.journalFileBackup))
      {
        if (this.fileSystem.exists(this.journalFile))
          this.fileSystem.delete(this.journalFileBackup);
      }
      else
      {
        bool = this.fileSystem.exists(this.journalFile);
        if (bool)
          try
          {
            readJournal();
            processJournal();
            this.initialized = true;
          }
          catch (IOException localIOException)
          {
            Platform.get().log(5, "DiskLruCache " + this.directory + " is corrupt: " + localIOException.getMessage() + ", removing", localIOException);
          }
      }
      try
      {
        delete();
        this.closed = false;
        rebuildJournal();
        this.initialized = true;
        continue;
        this.fileSystem.rename(this.journalFileBackup, this.journalFile);
      }
      finally
      {
        this.closed = false;
      }
    }
  }

  public boolean isClosed()
  {
    monitorenter;
    try
    {
      boolean bool = this.closed;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  boolean journalRebuildRequired()
  {
    return (this.redundantOpCount >= 2000) && (this.redundantOpCount >= this.lruEntries.size());
  }

  void rebuildJournal()
    throws IOException
  {
    monitorenter;
    while (true)
    {
      Entry localEntry;
      try
      {
        if (this.journalWriter == null)
          continue;
        this.journalWriter.close();
        BufferedSink localBufferedSink1 = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
        try
        {
          localBufferedSink1.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
          localBufferedSink1.writeUtf8("1").writeByte(10);
          localBufferedSink1.writeDecimalLong(this.appVersion).writeByte(10);
          localBufferedSink1.writeDecimalLong(this.valueCount).writeByte(10);
          localBufferedSink1.writeByte(10);
          Iterator localIterator = this.lruEntries.values().iterator();
          if (!localIterator.hasNext())
            break;
          localEntry = (Entry)localIterator.next();
          if (localEntry.currentEditor != null)
          {
            localBufferedSink1.writeUtf8("DIRTY").writeByte(32);
            localBufferedSink1.writeUtf8(localEntry.key);
            localBufferedSink1.writeByte(10);
            continue;
          }
        }
        finally
        {
          localBufferedSink1.close();
        }
      }
      finally
      {
        monitorexit;
      }
      localBufferedSink2.writeUtf8("CLEAN").writeByte(32);
      localBufferedSink2.writeUtf8(localEntry.key);
      localEntry.writeLengths(localBufferedSink2);
      localBufferedSink2.writeByte(10);
    }
    localBufferedSink2.close();
    if (this.fileSystem.exists(this.journalFile))
      this.fileSystem.rename(this.journalFile, this.journalFileBackup);
    this.fileSystem.rename(this.journalFileTmp, this.journalFile);
    this.fileSystem.delete(this.journalFileBackup);
    this.journalWriter = newJournalWriter();
    this.hasJournalErrors = false;
    this.mostRecentRebuildFailed = false;
    monitorexit;
  }

  public boolean remove(String paramString)
    throws IOException
  {
    int i = 0;
    monitorenter;
    try
    {
      initialize();
      checkNotClosed();
      validateKey(paramString);
      paramString = (Entry)this.lruEntries.get(paramString);
      if (paramString == null);
      while (true)
      {
        return i;
        boolean bool = removeEntry(paramString);
        i = bool;
        if (!bool)
          continue;
        i = bool;
        if (this.size > this.maxSize)
          continue;
        this.mostRecentTrimFailed = false;
        i = bool;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramString;
  }

  boolean removeEntry(Entry paramEntry)
    throws IOException
  {
    if (paramEntry.currentEditor != null)
      paramEntry.currentEditor.detach();
    int i = 0;
    while (i < this.valueCount)
    {
      this.fileSystem.delete(paramEntry.cleanFiles[i]);
      this.size -= paramEntry.lengths[i];
      paramEntry.lengths[i] = 0L;
      i += 1;
    }
    this.redundantOpCount += 1;
    this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(paramEntry.key).writeByte(10);
    this.lruEntries.remove(paramEntry.key);
    if (journalRebuildRequired())
      this.executor.execute(this.cleanupRunnable);
    return true;
  }

  public void setMaxSize(long paramLong)
  {
    monitorenter;
    try
    {
      this.maxSize = paramLong;
      if (this.initialized)
        this.executor.execute(this.cleanupRunnable);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public long size()
    throws IOException
  {
    monitorenter;
    try
    {
      initialize();
      long l = this.size;
      monitorexit;
      return l;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public Iterator<Snapshot> snapshots()
    throws IOException
  {
    monitorenter;
    try
    {
      initialize();
      3 local3 = new Iterator()
      {
        final Iterator<DiskLruCache.Entry> delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
        DiskLruCache.Snapshot nextSnapshot;
        DiskLruCache.Snapshot removeSnapshot;

        public boolean hasNext()
        {
          if (this.nextSnapshot != null)
            return true;
          synchronized (DiskLruCache.this)
          {
            if (DiskLruCache.this.closed)
              return false;
            while (this.delegate.hasNext())
            {
              DiskLruCache.Snapshot localSnapshot = ((DiskLruCache.Entry)this.delegate.next()).snapshot();
              if (localSnapshot == null)
                continue;
              this.nextSnapshot = localSnapshot;
              return true;
            }
          }
          monitorexit;
          return false;
        }

        public DiskLruCache.Snapshot next()
        {
          if (!hasNext())
            throw new NoSuchElementException();
          this.removeSnapshot = this.nextSnapshot;
          this.nextSnapshot = null;
          return this.removeSnapshot;
        }

        // ERROR //
        public void remove()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 76	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
          //   4: ifnonnull +13 -> 17
          //   7: new 81	java/lang/IllegalStateException
          //   10: dup
          //   11: ldc 83
          //   13: invokespecial 86	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
          //   16: athrow
          //   17: aload_0
          //   18: getfield 24	okhttp3/internal/cache/DiskLruCache$3:this$0	Lokhttp3/internal/cache/DiskLruCache;
          //   21: aload_0
          //   22: getfield 76	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
          //   25: invokestatic 92	okhttp3/internal/cache/DiskLruCache$Snapshot:access$000	(Lokhttp3/internal/cache/DiskLruCache$Snapshot;)Ljava/lang/String;
          //   28: invokevirtual 95	okhttp3/internal/cache/DiskLruCache:remove	(Ljava/lang/String;)Z
          //   31: pop
          //   32: aload_0
          //   33: aconst_null
          //   34: putfield 76	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
          //   37: return
          //   38: astore_1
          //   39: aload_0
          //   40: aconst_null
          //   41: putfield 76	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
          //   44: return
          //   45: astore_1
          //   46: aload_0
          //   47: aconst_null
          //   48: putfield 76	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
          //   51: aload_1
          //   52: athrow
          //
          // Exception table:
          //   from	to	target	type
          //   17	32	38	java/io/IOException
          //   17	32	45	finally
        }
      };
      monitorexit;
      return local3;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void trimToSize()
    throws IOException
  {
    while (this.size > this.maxSize)
      removeEntry((Entry)this.lruEntries.values().iterator().next());
    this.mostRecentTrimFailed = false;
  }

  public final class Editor
  {
    private boolean done;
    final DiskLruCache.Entry entry;
    final boolean[] written;

    Editor(DiskLruCache.Entry arg2)
    {
      Object localObject;
      this.entry = localObject;
      if (localObject.readable);
      for (this$1 = null; ; this$1 = new boolean[DiskLruCache.this.valueCount])
      {
        this.written = DiskLruCache.this;
        return;
      }
    }

    public void abort()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (this.done)
          throw new IllegalStateException();
      }
      if (this.entry.currentEditor == this)
        DiskLruCache.this.completeEdit(this, false);
      this.done = true;
      monitorexit;
    }

    public void abortUnlessCommitted()
    {
      synchronized (DiskLruCache.this)
      {
        if (!this.done)
        {
          Editor localEditor = this.entry.currentEditor;
          if (localEditor != this);
        }
      }
      try
      {
        DiskLruCache.this.completeEdit(this, false);
        label36: monitorexit;
        return;
        localObject = finally;
        monitorexit;
        throw localObject;
      }
      catch (IOException localIOException)
      {
        break label36;
      }
    }

    public void commit()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (this.done)
          throw new IllegalStateException();
      }
      if (this.entry.currentEditor == this)
        DiskLruCache.this.completeEdit(this, true);
      this.done = true;
      monitorexit;
    }

    void detach()
    {
      int i;
      if (this.entry.currentEditor == this)
        i = 0;
      while (true)
      {
        if (i < DiskLruCache.this.valueCount);
        try
        {
          DiskLruCache.this.fileSystem.delete(this.entry.dirtyFiles[i]);
          label45: i += 1;
          continue;
          this.entry.currentEditor = null;
          return;
        }
        catch (IOException localIOException)
        {
          break label45;
        }
      }
    }

    public Sink newSink(int paramInt)
    {
      synchronized (DiskLruCache.this)
      {
        if (this.done)
          throw new IllegalStateException();
      }
      if (this.entry.currentEditor != this)
      {
        localObject2 = Okio.blackhole();
        monitorexit;
        return localObject2;
      }
      if (!this.entry.readable)
        this.written[paramInt] = true;
      Object localObject2 = this.entry.dirtyFiles[paramInt];
      Sink localSink;
      try
      {
        localObject2 = DiskLruCache.this.fileSystem.sink((File)localObject2);
        localObject2 = new FaultHidingSink((Sink)localObject2)
        {
          protected void onException(IOException arg1)
          {
            synchronized (DiskLruCache.this)
            {
              DiskLruCache.Editor.this.detach();
              return;
            }
          }
        };
        monitorexit;
        return localObject2;
      }
      catch (FileNotFoundException localSink)
      {
        localSink = Okio.blackhole();
        monitorexit;
      }
      return (Sink)localSink;
    }

    public Source newSource(int paramInt)
    {
      synchronized (DiskLruCache.this)
      {
        if (this.done)
          throw new IllegalStateException();
      }
      if ((!this.entry.readable) || (this.entry.currentEditor != this))
      {
        monitorexit;
        return null;
      }
      try
      {
        Source localSource = DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[paramInt]);
        monitorexit;
        return localSource;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        monitorexit;
      }
      return null;
    }
  }

  private final class Entry
  {
    final File[] cleanFiles;
    DiskLruCache.Editor currentEditor;
    final File[] dirtyFiles;
    final String key;
    final long[] lengths;
    boolean readable;
    long sequenceNumber;

    Entry(String arg2)
    {
      this.key = ((String)localObject);
      this.lengths = new long[DiskLruCache.this.valueCount];
      this.cleanFiles = new File[DiskLruCache.this.valueCount];
      this.dirtyFiles = new File[DiskLruCache.this.valueCount];
      Object localObject = new StringBuilder((String)localObject).append('.');
      int j = ((StringBuilder)localObject).length();
      int i = 0;
      while (i < DiskLruCache.this.valueCount)
      {
        ((StringBuilder)localObject).append(i);
        this.cleanFiles[i] = new File(DiskLruCache.this.directory, ((StringBuilder)localObject).toString());
        ((StringBuilder)localObject).append(".tmp");
        this.dirtyFiles[i] = new File(DiskLruCache.this.directory, ((StringBuilder)localObject).toString());
        ((StringBuilder)localObject).setLength(j);
        i += 1;
      }
    }

    private IOException invalidLengths(String[] paramArrayOfString)
      throws IOException
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }

    void setLengths(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length != DiskLruCache.this.valueCount)
        throw invalidLengths(paramArrayOfString);
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.lengths[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw invalidLengths(paramArrayOfString);
      }
    }

    DiskLruCache.Snapshot snapshot()
    {
      if (!Thread.holdsLock(DiskLruCache.this))
        throw new AssertionError();
      Source[] arrayOfSource = new Source[DiskLruCache.this.valueCount];
      Object localObject = (long[])this.lengths.clone();
      int i = 0;
      try
      {
        while (i < DiskLruCache.this.valueCount)
        {
          arrayOfSource[i] = DiskLruCache.this.fileSystem.source(this.cleanFiles[i]);
          i += 1;
        }
        localObject = new DiskLruCache.Snapshot(DiskLruCache.this, this.key, this.sequenceNumber, arrayOfSource, localObject);
        return localObject;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        i = 0;
        while ((i < DiskLruCache.this.valueCount) && (arrayOfSource[i] != null))
        {
          Util.closeQuietly(arrayOfSource[i]);
          i += 1;
        }
      }
      try
      {
        DiskLruCache.this.removeEntry(this);
        label147: return null;
      }
      catch (IOException localIOException)
      {
        break label147;
      }
    }

    void writeLengths(BufferedSink paramBufferedSink)
      throws IOException
    {
      long[] arrayOfLong = this.lengths;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        paramBufferedSink.writeByte(32).writeDecimalLong(l);
        i += 1;
      }
    }
  }

  public final class Snapshot
    implements Closeable
  {
    private final String key;
    private final long[] lengths;
    private final long sequenceNumber;
    private final Source[] sources;

    Snapshot(String paramLong, long arg3, Source[] paramArrayOfLong, long[] arg6)
    {
      this.key = paramLong;
      this.sequenceNumber = ???;
      this.sources = paramArrayOfLong;
      Object localObject;
      this.lengths = localObject;
    }

    public void close()
    {
      Source[] arrayOfSource = this.sources;
      int j = arrayOfSource.length;
      int i = 0;
      while (i < j)
      {
        Util.closeQuietly(arrayOfSource[i]);
        i += 1;
      }
    }

    public DiskLruCache.Editor edit()
      throws IOException
    {
      return DiskLruCache.this.edit(this.key, this.sequenceNumber);
    }

    public long getLength(int paramInt)
    {
      return this.lengths[paramInt];
    }

    public Source getSource(int paramInt)
    {
      return this.sources[paramInt];
    }

    public String key()
    {
      return this.key;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache
 * JD-Core Version:    0.6.0
 */