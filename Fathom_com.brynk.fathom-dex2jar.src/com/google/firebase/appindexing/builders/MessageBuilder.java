package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import java.util.Date;

public final class MessageBuilder extends IndexableBuilder<MessageBuilder>
{
  MessageBuilder()
  {
    super("Message");
  }

  MessageBuilder(String paramString)
  {
    super(paramString);
  }

  public MessageBuilder setDateRead(@NonNull Date paramDate)
  {
    zzaa.zzy(paramDate);
    return (MessageBuilder)put("dateRead", new long[] { paramDate.getTime() });
  }

  public MessageBuilder setDateReceived(@NonNull Date paramDate)
  {
    zzaa.zzy(paramDate);
    return (MessageBuilder)put("dateReceived", new long[] { paramDate.getTime() });
  }

  public MessageBuilder setDateSent(@NonNull Date paramDate)
  {
    zzaa.zzy(paramDate);
    return (MessageBuilder)put("dateSent", new long[] { paramDate.getTime() });
  }

  public MessageBuilder setIsPartOf(@NonNull ConversationBuilder[] paramArrayOfConversationBuilder)
  {
    return (MessageBuilder)put("isPartOf", paramArrayOfConversationBuilder);
  }

  public MessageBuilder setMessageAttachment(@NonNull DigitalDocumentBuilder[] paramArrayOfDigitalDocumentBuilder)
  {
    return (MessageBuilder)put("messageAttachment", paramArrayOfDigitalDocumentBuilder);
  }

  public MessageBuilder setRecipient(@NonNull PersonBuilder[] paramArrayOfPersonBuilder)
  {
    return (MessageBuilder)put("recipient", paramArrayOfPersonBuilder);
  }

  public MessageBuilder setSender(@NonNull PersonBuilder paramPersonBuilder)
  {
    return (MessageBuilder)put("sender", new PersonBuilder[] { paramPersonBuilder });
  }

  public MessageBuilder setText(@NonNull String paramString)
  {
    return (MessageBuilder)put("text", new String[] { paramString });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.MessageBuilder
 * JD-Core Version:    0.6.0
 */