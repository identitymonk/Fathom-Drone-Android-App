package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;

public final class MusicRecordingBuilder extends IndexableBuilder<MusicRecordingBuilder>
{
  MusicRecordingBuilder()
  {
    super("MusicRecording");
  }

  public MusicRecordingBuilder setByArtist(@NonNull MusicGroupBuilder paramMusicGroupBuilder)
  {
    return (MusicRecordingBuilder)put("byArtist", new MusicGroupBuilder[] { paramMusicGroupBuilder });
  }

  public MusicRecordingBuilder setDuration(int paramInt)
  {
    return (MusicRecordingBuilder)put("duration", new long[] { paramInt });
  }

  public MusicRecordingBuilder setInAlbum(@NonNull MusicAlbumBuilder paramMusicAlbumBuilder)
  {
    return (MusicRecordingBuilder)put("inAlbum", new MusicAlbumBuilder[] { paramMusicAlbumBuilder });
  }

  public MusicRecordingBuilder setInPlaylist(@NonNull MusicPlaylistBuilder[] paramArrayOfMusicPlaylistBuilder)
  {
    return (MusicRecordingBuilder)put("inPlaylist", paramArrayOfMusicPlaylistBuilder);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.MusicRecordingBuilder
 * JD-Core Version:    0.6.0
 */