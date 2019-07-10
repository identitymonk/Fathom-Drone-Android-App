package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;

public final class ConversationBuilder extends IndexableBuilder<ConversationBuilder>
{
  ConversationBuilder()
  {
    super("Conversation");
  }

  public ConversationBuilder setId(@NonNull String paramString)
  {
    return (ConversationBuilder)put("id", new String[] { paramString });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.ConversationBuilder
 * JD-Core Version:    0.6.0
 */