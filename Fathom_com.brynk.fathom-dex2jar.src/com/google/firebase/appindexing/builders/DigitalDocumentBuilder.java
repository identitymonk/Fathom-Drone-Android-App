package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;
import java.util.Date;

public final class DigitalDocumentBuilder extends IndexableBuilder<DigitalDocumentBuilder>
{
  DigitalDocumentBuilder()
  {
    super("DigitalDocument");
  }

  DigitalDocumentBuilder(String paramString)
  {
    super(paramString);
  }

  public DigitalDocumentBuilder setAuthor(@NonNull PersonBuilder[] paramArrayOfPersonBuilder)
  {
    return (DigitalDocumentBuilder)put("author", paramArrayOfPersonBuilder);
  }

  public DigitalDocumentBuilder setDateCreated(@NonNull Date paramDate)
  {
    return (DigitalDocumentBuilder)put("dateCreated", new long[] { paramDate.getTime() });
  }

  public DigitalDocumentBuilder setDateModified(@NonNull Date paramDate)
  {
    return (DigitalDocumentBuilder)put("dateModified", new long[] { paramDate.getTime() });
  }

  public DigitalDocumentBuilder setHasDigitalDocumentPermission(@NonNull DigitalDocumentPermissionBuilder[] paramArrayOfDigitalDocumentPermissionBuilder)
  {
    return (DigitalDocumentBuilder)put("hasDigitalDocumentPermission", paramArrayOfDigitalDocumentPermissionBuilder);
  }

  public DigitalDocumentBuilder setText(@NonNull String paramString)
  {
    return (DigitalDocumentBuilder)put("text", new String[] { paramString });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.DigitalDocumentBuilder
 * JD-Core Version:    0.6.0
 */