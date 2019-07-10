package com.facebook.cache.common;

import javax.annotation.Nullable;

public abstract interface CacheErrorLogger
{
  public abstract void logError(CacheErrorCategory paramCacheErrorCategory, Class<?> paramClass, String paramString, @Nullable Throwable paramThrowable);

  public static enum CacheErrorCategory
  {
    static
    {
      WRITE_CREATE_TEMPFILE = new CacheErrorCategory("WRITE_CREATE_TEMPFILE", 5);
      WRITE_UPDATE_FILE_NOT_FOUND = new CacheErrorCategory("WRITE_UPDATE_FILE_NOT_FOUND", 6);
      WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND = new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND", 7);
      WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND = new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND", 8);
      WRITE_RENAME_FILE_OTHER = new CacheErrorCategory("WRITE_RENAME_FILE_OTHER", 9);
      WRITE_CREATE_DIR = new CacheErrorCategory("WRITE_CREATE_DIR", 10);
      WRITE_CALLBACK_ERROR = new CacheErrorCategory("WRITE_CALLBACK_ERROR", 11);
      WRITE_INVALID_ENTRY = new CacheErrorCategory("WRITE_INVALID_ENTRY", 12);
      DELETE_FILE = new CacheErrorCategory("DELETE_FILE", 13);
      EVICTION = new CacheErrorCategory("EVICTION", 14);
      GENERIC_IO = new CacheErrorCategory("GENERIC_IO", 15);
      OTHER = new CacheErrorCategory("OTHER", 16);
      $VALUES = new CacheErrorCategory[] { READ_DECODE, READ_FILE, READ_FILE_NOT_FOUND, READ_INVALID_ENTRY, WRITE_ENCODE, WRITE_CREATE_TEMPFILE, WRITE_UPDATE_FILE_NOT_FOUND, WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND, WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND, WRITE_RENAME_FILE_OTHER, WRITE_CREATE_DIR, WRITE_CALLBACK_ERROR, WRITE_INVALID_ENTRY, DELETE_FILE, EVICTION, GENERIC_IO, OTHER };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.CacheErrorLogger
 * JD-Core Version:    0.6.0
 */