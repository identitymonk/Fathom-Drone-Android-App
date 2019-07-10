package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.Indexable.Builder;

public final class Indexables
{
  public static ConversationBuilder conversationBuilder()
  {
    return new ConversationBuilder();
  }

  public static DigitalDocumentBuilder digitalDocumentBuilder()
  {
    return new DigitalDocumentBuilder();
  }

  public static DigitalDocumentPermissionBuilder digitalDocumentPermissionBuilder()
  {
    return new DigitalDocumentPermissionBuilder();
  }

  public static MessageBuilder emailMessageBuilder()
  {
    return new MessageBuilder("EmailMessage");
  }

  public static MessageBuilder messageBuilder()
  {
    return new MessageBuilder();
  }

  public static MusicAlbumBuilder musicAlbumBuilder()
  {
    return new MusicAlbumBuilder();
  }

  public static MusicGroupBuilder musicGroupBuilder()
  {
    return new MusicGroupBuilder();
  }

  public static MusicPlaylistBuilder musicPlaylistBuilder()
  {
    return new MusicPlaylistBuilder();
  }

  public static MusicRecordingBuilder musicRecordingBuilder()
  {
    return new MusicRecordingBuilder();
  }

  public static Indexable newSimple(@NonNull String paramString1, @NonNull String paramString2)
  {
    zzaa.zzy(paramString1);
    zzaa.zzy(paramString2);
    return ((Indexable.Builder)((Indexable.Builder)new Indexable.Builder().setUrl(paramString2)).setName(paramString1)).build();
  }

  public static DigitalDocumentBuilder noteDigitalDocumentBuilder()
  {
    return new DigitalDocumentBuilder("NoteDigitalDocument");
  }

  public static PersonBuilder personBuilder()
  {
    return new PersonBuilder();
  }

  public static DigitalDocumentBuilder presentationDigitalDocumentBuilder()
  {
    return new DigitalDocumentBuilder("PresentationDigitalDocument");
  }

  public static DigitalDocumentBuilder spreadsheetDigitalDocumentBuilder()
  {
    return new DigitalDocumentBuilder("SpreadsheetDigitalDocument");
  }

  public static DigitalDocumentBuilder textDigitalDocumentBuilder()
  {
    return new DigitalDocumentBuilder("TextDigitalDocument");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.Indexables
 * JD-Core Version:    0.6.0
 */