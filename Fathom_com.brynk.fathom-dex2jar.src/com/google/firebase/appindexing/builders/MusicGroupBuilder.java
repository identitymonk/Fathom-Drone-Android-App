package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;

public final class MusicGroupBuilder extends IndexableBuilder<MusicGroupBuilder>
{
  MusicGroupBuilder()
  {
    super("MusicGroup");
  }

  public MusicGroupBuilder setAlbum(@NonNull MusicAlbumBuilder[] paramArrayOfMusicAlbumBuilder)
  {
    return (MusicGroupBuilder)put("album", paramArrayOfMusicAlbumBuilder);
  }

  public MusicGroupBuilder setGenre(@NonNull String paramString)
  {
    return (MusicGroupBuilder)put("genre", new String[] { paramString });
  }

  public MusicGroupBuilder setTrack(@NonNull MusicRecordingBuilder[] paramArrayOfMusicRecordingBuilder)
  {
    return (MusicGroupBuilder)put("track", paramArrayOfMusicRecordingBuilder);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.MusicGroupBuilder
 * JD-Core Version:    0.6.0
 */