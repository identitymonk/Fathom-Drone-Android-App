package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;

public final class MusicAlbumBuilder extends IndexableBuilder<MusicAlbumBuilder>
{
  MusicAlbumBuilder()
  {
    super("MusicAlbum");
  }

  public MusicAlbumBuilder setByArtist(@NonNull MusicGroupBuilder paramMusicGroupBuilder)
  {
    return (MusicAlbumBuilder)put("byArtist", new MusicGroupBuilder[] { paramMusicGroupBuilder });
  }

  public MusicAlbumBuilder setNumTracks(int paramInt)
  {
    return (MusicAlbumBuilder)put("numTracks", new long[] { paramInt });
  }

  public MusicAlbumBuilder setTrack(@NonNull MusicRecordingBuilder[] paramArrayOfMusicRecordingBuilder)
  {
    return (MusicAlbumBuilder)put("track", paramArrayOfMusicRecordingBuilder);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.MusicAlbumBuilder
 * JD-Core Version:    0.6.0
 */