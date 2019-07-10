package com.facebook.cache.disk;

import android.os.Environment;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.file.FileUtils.CreateDirectoryException;
import com.facebook.common.file.FileUtils.ParentDirNotFoundException;
import com.facebook.common.file.FileUtils.RenameException;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class DefaultDiskStorage
  implements DiskStorage
{
  private static final String CONTENT_FILE_EXTENSION = ".cnt";
  private static final String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
  private static final int SHARDING_BUCKET_COUNT = 100;
  private static final Class<?> TAG = DefaultDiskStorage.class;
  private static final String TEMP_FILE_EXTENSION = ".tmp";
  static final long TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30L);
  private final CacheErrorLogger mCacheErrorLogger;
  private final Clock mClock;
  private final boolean mIsExternal;
  private final File mRootDirectory;
  private final File mVersionDirectory;

  public DefaultDiskStorage(File paramFile, int paramInt, CacheErrorLogger paramCacheErrorLogger)
  {
    Preconditions.checkNotNull(paramFile);
    this.mRootDirectory = paramFile;
    this.mIsExternal = isExternal(paramFile, paramCacheErrorLogger);
    this.mVersionDirectory = new File(this.mRootDirectory, getVersionSubdirectoryName(paramInt));
    this.mCacheErrorLogger = paramCacheErrorLogger;
    recreateDirectoryIfVersionChanges();
    this.mClock = SystemClock.get();
  }

  private long doRemove(File paramFile)
  {
    long l;
    if (!paramFile.exists())
      l = 0L;
    do
    {
      return l;
      l = paramFile.length();
    }
    while (paramFile.delete());
    return -1L;
  }

  private DiskStorage.DiskDumpInfoEntry dumpCacheEntry(DiskStorage.Entry paramEntry)
    throws IOException
  {
    EntryImpl localEntryImpl = (EntryImpl)paramEntry;
    String str1 = "";
    byte[] arrayOfByte = localEntryImpl.getResource().read();
    String str2 = typeOfBytes(arrayOfByte);
    paramEntry = str1;
    if (str2.equals("undefined"))
    {
      paramEntry = str1;
      if (arrayOfByte.length >= 4)
        paramEntry = String.format((Locale)null, "0x%02X 0x%02X 0x%02X 0x%02X", new Object[] { Byte.valueOf(arrayOfByte[0]), Byte.valueOf(arrayOfByte[1]), Byte.valueOf(arrayOfByte[2]), Byte.valueOf(arrayOfByte[3]) });
    }
    return new DiskStorage.DiskDumpInfoEntry(localEntryImpl.getResource().getFile().getPath(), str2, (float)localEntryImpl.getSize(), paramEntry);
  }

  private String getFilename(String paramString)
  {
    paramString = new FileInfo(FileType.CONTENT, paramString, null);
    return paramString.toPath(getSubdirectoryPath(paramString.resourceId));
  }

  private FileInfo getShardFileInfo(File paramFile)
  {
    FileInfo localFileInfo = FileInfo.fromFile(paramFile);
    if (localFileInfo == null)
      return null;
    if (getSubdirectory(localFileInfo.resourceId).equals(paramFile.getParentFile()));
    for (paramFile = localFileInfo; ; paramFile = null)
      return paramFile;
  }

  private File getSubdirectory(String paramString)
  {
    return new File(getSubdirectoryPath(paramString));
  }

  private String getSubdirectoryPath(String paramString)
  {
    int i = Math.abs(paramString.hashCode() % 100);
    return this.mVersionDirectory + File.separator + String.valueOf(i);
  }

  @VisibleForTesting
  static String getVersionSubdirectoryName(int paramInt)
  {
    return String.format((Locale)null, "%s.ols%d.%d", new Object[] { "v2", Integer.valueOf(100), Integer.valueOf(paramInt) });
  }

  private static boolean isExternal(File paramFile, CacheErrorLogger paramCacheErrorLogger)
  {
    int j = 0;
    File localFile = null;
    try
    {
      Object localObject = Environment.getExternalStorageDirectory();
      int i = j;
      if (localObject != null)
        localObject = ((File)localObject).toString();
      try
      {
        paramFile = paramFile.getCanonicalPath();
        localFile = paramFile;
        boolean bool = paramFile.contains((CharSequence)localObject);
        i = j;
        if (bool)
          i = 1;
        return i;
      }
      catch (IOException paramFile)
      {
        paramCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.OTHER, TAG, "failed to read folder to check if external: " + localFile, paramFile);
        return false;
      }
    }
    catch (java.lang.Exception paramFile)
    {
      paramCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.OTHER, TAG, "failed to get the external storage directory!", paramFile);
    }
    return false;
  }

  private void mkdirs(File paramFile, String paramString)
    throws IOException
  {
    try
    {
      FileUtils.mkdirs(paramFile);
      return;
    }
    catch (FileUtils.CreateDirectoryException paramFile)
    {
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, paramString, paramFile);
    }
    throw paramFile;
  }

  private boolean query(String paramString, boolean paramBoolean)
  {
    paramString = getContentFileFor(paramString);
    boolean bool = paramString.exists();
    if ((paramBoolean) && (bool))
      paramString.setLastModified(this.mClock.now());
    return bool;
  }

  private void recreateDirectoryIfVersionChanges()
  {
    int i = 0;
    if (!this.mRootDirectory.exists())
      i = 1;
    while (true)
    {
      if (i != 0);
      try
      {
        FileUtils.mkdirs(this.mVersionDirectory);
        return;
        if (this.mVersionDirectory.exists())
          continue;
        i = 1;
        FileTree.deleteRecursively(this.mRootDirectory);
      }
      catch (FileUtils.CreateDirectoryException localCreateDirectoryException)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "version directory could not be created: " + this.mVersionDirectory, null);
      }
    }
  }

  private String typeOfBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 2)
    {
      if ((paramArrayOfByte[0] == -1) && (paramArrayOfByte[1] == -40))
        return "jpg";
      if ((paramArrayOfByte[0] == -119) && (paramArrayOfByte[1] == 80))
        return "png";
      if ((paramArrayOfByte[0] == 82) && (paramArrayOfByte[1] == 73))
        return "webp";
      if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73))
        return "gif";
    }
    return "undefined";
  }

  public void clearAll()
  {
    FileTree.deleteContents(this.mRootDirectory);
  }

  public boolean contains(String paramString, Object paramObject)
  {
    return query(paramString, false);
  }

  @VisibleForTesting
  File getContentFileFor(String paramString)
  {
    return new File(getFilename(paramString));
  }

  public DiskStorage.DiskDumpInfo getDumpInfo()
    throws IOException
  {
    Object localObject = getEntries();
    DiskStorage.DiskDumpInfo localDiskDumpInfo = new DiskStorage.DiskDumpInfo();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DiskStorage.DiskDumpInfoEntry localDiskDumpInfoEntry = dumpCacheEntry((DiskStorage.Entry)((Iterator)localObject).next());
      String str = localDiskDumpInfoEntry.type;
      if (!localDiskDumpInfo.typeCounts.containsKey(str))
        localDiskDumpInfo.typeCounts.put(str, Integer.valueOf(0));
      localDiskDumpInfo.typeCounts.put(str, Integer.valueOf(((Integer)localDiskDumpInfo.typeCounts.get(str)).intValue() + 1));
      localDiskDumpInfo.entries.add(localDiskDumpInfoEntry);
    }
    return (DiskStorage.DiskDumpInfo)localDiskDumpInfo;
  }

  public List<DiskStorage.Entry> getEntries()
    throws IOException
  {
    EntriesCollector localEntriesCollector = new EntriesCollector(null);
    FileTree.walkFileTree(this.mVersionDirectory, localEntriesCollector);
    return localEntriesCollector.getEntries();
  }

  public BinaryResource getResource(String paramString, Object paramObject)
  {
    paramString = getContentFileFor(paramString);
    if (paramString.exists())
    {
      paramString.setLastModified(this.mClock.now());
      return FileBinaryResource.createOrNull(paramString);
    }
    return null;
  }

  public String getStorageName()
  {
    String str = this.mRootDirectory.getAbsolutePath();
    return "_" + str.substring(str.lastIndexOf('/') + 1, str.length()) + "_" + str.hashCode();
  }

  public DiskStorage.Inserter insert(String paramString, Object paramObject)
    throws IOException
  {
    paramObject = new FileInfo(FileType.TEMP, paramString, null);
    File localFile = getSubdirectory(paramObject.resourceId);
    if (!localFile.exists())
      mkdirs(localFile, "insert");
    try
    {
      paramString = new InserterImpl(paramString, paramObject.createTempFile(localFile));
      return paramString;
    }
    catch (IOException paramString)
    {
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "insert", paramString);
    }
    throw paramString;
  }

  public boolean isEnabled()
  {
    return true;
  }

  public boolean isExternal()
  {
    return this.mIsExternal;
  }

  public void purgeUnexpectedResources()
  {
    FileTree.walkFileTree(this.mRootDirectory, new PurgingVisitor(null));
  }

  public long remove(DiskStorage.Entry paramEntry)
  {
    return doRemove(((EntryImpl)paramEntry).getResource().getFile());
  }

  public long remove(String paramString)
  {
    return doRemove(getContentFileFor(paramString));
  }

  public boolean touch(String paramString, Object paramObject)
  {
    return query(paramString, true);
  }

  private class EntriesCollector
    implements FileTreeVisitor
  {
    private final List<DiskStorage.Entry> result = new ArrayList();

    private EntriesCollector()
    {
    }

    public List<DiskStorage.Entry> getEntries()
    {
      return Collections.unmodifiableList(this.result);
    }

    public void postVisitDirectory(File paramFile)
    {
    }

    public void preVisitDirectory(File paramFile)
    {
    }

    public void visitFile(File paramFile)
    {
      DefaultDiskStorage.FileInfo localFileInfo = DefaultDiskStorage.this.getShardFileInfo(paramFile);
      if ((localFileInfo != null) && (localFileInfo.type == DefaultDiskStorage.FileType.CONTENT))
        this.result.add(new DefaultDiskStorage.EntryImpl(localFileInfo.resourceId, paramFile, null));
    }
  }

  @VisibleForTesting
  static class EntryImpl
    implements DiskStorage.Entry
  {
    private final String id;
    private final FileBinaryResource resource;
    private long size;
    private long timestamp;

    private EntryImpl(String paramString, File paramFile)
    {
      Preconditions.checkNotNull(paramFile);
      this.id = ((String)Preconditions.checkNotNull(paramString));
      this.resource = FileBinaryResource.createOrNull(paramFile);
      this.size = -1L;
      this.timestamp = -1L;
    }

    public String getId()
    {
      return this.id;
    }

    public FileBinaryResource getResource()
    {
      return this.resource;
    }

    public long getSize()
    {
      if (this.size < 0L)
        this.size = this.resource.size();
      return this.size;
    }

    public long getTimestamp()
    {
      if (this.timestamp < 0L)
        this.timestamp = this.resource.getFile().lastModified();
      return this.timestamp;
    }
  }

  private static class FileInfo
  {
    public final String resourceId;
    public final DefaultDiskStorage.FileType type;

    private FileInfo(DefaultDiskStorage.FileType paramFileType, String paramString)
    {
      this.type = paramFileType;
      this.resourceId = paramString;
    }

    @Nullable
    public static FileInfo fromFile(File paramFile)
    {
      paramFile = paramFile.getName();
      int i = paramFile.lastIndexOf('.');
      if (i <= 0);
      DefaultDiskStorage.FileType localFileType;
      while (true)
      {
        return null;
        localFileType = DefaultDiskStorage.FileType.fromExtension(paramFile.substring(i));
        if (localFileType == null)
          continue;
        String str = paramFile.substring(0, i);
        paramFile = str;
        if (!localFileType.equals(DefaultDiskStorage.FileType.TEMP))
          break;
        i = str.lastIndexOf('.');
        if (i <= 0)
          continue;
        paramFile = str.substring(0, i);
      }
      return new FileInfo(localFileType, paramFile);
    }

    public File createTempFile(File paramFile)
      throws IOException
    {
      return File.createTempFile(this.resourceId + ".", ".tmp", paramFile);
    }

    public String toPath(String paramString)
    {
      return paramString + File.separator + this.resourceId + this.type.extension;
    }

    public String toString()
    {
      return this.type + "(" + this.resourceId + ")";
    }
  }

  private static enum FileType
  {
    public final String extension;

    static
    {
      $VALUES = new FileType[] { CONTENT, TEMP };
    }

    private FileType(String paramString)
    {
      this.extension = paramString;
    }

    public static FileType fromExtension(String paramString)
    {
      if (".cnt".equals(paramString))
        return CONTENT;
      if (".tmp".equals(paramString))
        return TEMP;
      return null;
    }
  }

  private static class IncompleteFileException extends IOException
  {
    public final long actual;
    public final long expected;

    public IncompleteFileException(long paramLong1, long paramLong2)
    {
      super();
      this.expected = paramLong1;
      this.actual = paramLong2;
    }
  }

  @VisibleForTesting
  class InserterImpl
    implements DiskStorage.Inserter
  {
    private final String mResourceId;

    @VisibleForTesting
    final File mTemporaryFile;

    public InserterImpl(String paramFile, File arg3)
    {
      this.mResourceId = paramFile;
      Object localObject;
      this.mTemporaryFile = localObject;
    }

    public boolean cleanUp()
    {
      return (!this.mTemporaryFile.exists()) || (this.mTemporaryFile.delete());
    }

    public BinaryResource commit(Object paramObject)
      throws IOException
    {
      paramObject = DefaultDiskStorage.this.getContentFileFor(this.mResourceId);
      try
      {
        FileUtils.rename(this.mTemporaryFile, paramObject);
        if (paramObject.exists())
          paramObject.setLastModified(DefaultDiskStorage.this.mClock.now());
        return FileBinaryResource.createOrNull(paramObject);
      }
      catch (FileUtils.RenameException localRenameException)
      {
        paramObject = localRenameException.getCause();
        if (paramObject != null)
          break label84;
      }
      paramObject = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
      while (true)
      {
        DefaultDiskStorage.this.mCacheErrorLogger.logError(paramObject, DefaultDiskStorage.TAG, "commit", localRenameException);
        throw localRenameException;
        label84: if ((paramObject instanceof FileUtils.ParentDirNotFoundException))
        {
          paramObject = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
          continue;
        }
        if ((paramObject instanceof FileNotFoundException))
        {
          paramObject = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
          continue;
        }
        paramObject = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
      }
    }

    // ERROR //
    public void writeData(com.facebook.cache.common.WriterCallback paramWriterCallback, Object paramObject)
      throws IOException
    {
      // Byte code:
      //   0: new 114	java/io/FileOutputStream
      //   3: dup
      //   4: aload_0
      //   5: getfield 27	com/facebook/cache/disk/DefaultDiskStorage$InserterImpl:mTemporaryFile	Ljava/io/File;
      //   8: invokespecial 117	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   11: astore_2
      //   12: new 119	com/facebook/common/internal/CountingOutputStream
      //   15: dup
      //   16: aload_2
      //   17: invokespecial 122	com/facebook/common/internal/CountingOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   20: astore 5
      //   22: aload_1
      //   23: aload 5
      //   25: invokeinterface 127 2 0
      //   30: aload 5
      //   32: invokevirtual 130	com/facebook/common/internal/CountingOutputStream:flush	()V
      //   35: aload 5
      //   37: invokevirtual 133	com/facebook/common/internal/CountingOutputStream:getCount	()J
      //   40: lstore_3
      //   41: aload_2
      //   42: invokevirtual 136	java/io/FileOutputStream:close	()V
      //   45: aload_0
      //   46: getfield 27	com/facebook/cache/disk/DefaultDiskStorage$InserterImpl:mTemporaryFile	Ljava/io/File;
      //   49: invokevirtual 139	java/io/File:length	()J
      //   52: lload_3
      //   53: lcmp
      //   54: ifeq +50 -> 104
      //   57: new 141	com/facebook/cache/disk/DefaultDiskStorage$IncompleteFileException
      //   60: dup
      //   61: lload_3
      //   62: aload_0
      //   63: getfield 27	com/facebook/cache/disk/DefaultDiskStorage$InserterImpl:mTemporaryFile	Ljava/io/File;
      //   66: invokevirtual 139	java/io/File:length	()J
      //   69: invokespecial 144	com/facebook/cache/disk/DefaultDiskStorage$IncompleteFileException:<init>	(JJ)V
      //   72: athrow
      //   73: astore_1
      //   74: aload_0
      //   75: getfield 20	com/facebook/cache/disk/DefaultDiskStorage$InserterImpl:this$0	Lcom/facebook/cache/disk/DefaultDiskStorage;
      //   78: invokestatic 88	com/facebook/cache/disk/DefaultDiskStorage:access$900	(Lcom/facebook/cache/disk/DefaultDiskStorage;)Lcom/facebook/cache/common/CacheErrorLogger;
      //   81: getstatic 147	com/facebook/cache/common/CacheErrorLogger$CacheErrorCategory:WRITE_UPDATE_FILE_NOT_FOUND	Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;
      //   84: invokestatic 92	com/facebook/cache/disk/DefaultDiskStorage:access$800	()Ljava/lang/Class;
      //   87: ldc 149
      //   89: aload_1
      //   90: invokeinterface 99 5 0
      //   95: aload_1
      //   96: athrow
      //   97: astore_1
      //   98: aload_2
      //   99: invokevirtual 136	java/io/FileOutputStream:close	()V
      //   102: aload_1
      //   103: athrow
      //   104: return
      //
      // Exception table:
      //   from	to	target	type
      //   0	12	73	java/io/FileNotFoundException
      //   12	41	97	finally
    }
  }

  private class PurgingVisitor
    implements FileTreeVisitor
  {
    private boolean insideBaseDirectory;

    private PurgingVisitor()
    {
    }

    private boolean isExpectedFile(File paramFile)
    {
      boolean bool = false;
      DefaultDiskStorage.FileInfo localFileInfo = DefaultDiskStorage.this.getShardFileInfo(paramFile);
      if (localFileInfo == null)
        return false;
      if (localFileInfo.type == DefaultDiskStorage.FileType.TEMP)
        return isRecentFile(paramFile);
      if (localFileInfo.type == DefaultDiskStorage.FileType.CONTENT)
        bool = true;
      Preconditions.checkState(bool);
      return true;
    }

    private boolean isRecentFile(File paramFile)
    {
      return paramFile.lastModified() > DefaultDiskStorage.this.mClock.now() - DefaultDiskStorage.TEMP_FILE_LIFETIME_MS;
    }

    public void postVisitDirectory(File paramFile)
    {
      if ((!DefaultDiskStorage.this.mRootDirectory.equals(paramFile)) && (!this.insideBaseDirectory))
        paramFile.delete();
      if ((this.insideBaseDirectory) && (paramFile.equals(DefaultDiskStorage.this.mVersionDirectory)))
        this.insideBaseDirectory = false;
    }

    public void preVisitDirectory(File paramFile)
    {
      if ((!this.insideBaseDirectory) && (paramFile.equals(DefaultDiskStorage.this.mVersionDirectory)))
        this.insideBaseDirectory = true;
    }

    public void visitFile(File paramFile)
    {
      if ((!this.insideBaseDirectory) || (!isExpectedFile(paramFile)))
        paramFile.delete();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.disk.DefaultDiskStorage
 * JD-Core Version:    0.6.0
 */