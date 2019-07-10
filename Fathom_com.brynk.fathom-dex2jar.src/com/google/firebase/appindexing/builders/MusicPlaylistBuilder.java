package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;

public class MusicPlaylistBuilder extends IndexableBuilder<MusicPlaylistBuilder>
{
  MusicPlaylistBuilder()
  {
    super("MusicPlaylist");
  }

  public MusicPlaylistBuilder setNumTracks(int paramInt)
  {
    return (MusicPlaylistBuilder)put("numTracks", new long[] { paramInt });
  }

  public MusicPlaylistBuilder setTrack(@NonNull MusicRecordingBuilder[] paramArrayOfMusicRecordingBuilder)
  {
    return (MusicPlaylistBuilder)put("track", paramArrayOfMusicRecordingBuilder);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.MusicPlaylistBuilder
 * JD-Core Version:    0.6.0
 */