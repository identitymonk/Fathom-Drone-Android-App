package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;

public final class DigitalDocumentPermissionBuilder extends IndexableBuilder<DigitalDocumentPermissionBuilder>
{
  public static final String COMMENT_PERMISSION = "CommentPermission";
  public static final String READ_PERMISSION = "ReadPermission";
  public static final String WRITE_PERMISSION = "WritePermission";

  DigitalDocumentPermissionBuilder()
  {
    super("DigitalDocumentPermission");
  }

  public DigitalDocumentPermissionBuilder setGrantee(@NonNull PersonBuilder[] paramArrayOfPersonBuilder)
  {
    return (DigitalDocumentPermissionBuilder)put("grantee", paramArrayOfPersonBuilder);
  }

  public DigitalDocumentPermissionBuilder setPermissionType(@NonNull String paramString)
  {
    return (DigitalDocumentPermissionBuilder)put("permissionType", new String[] { paramString });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.DigitalDocumentPermissionBuilder
 * JD-Core Version:    0.6.0
 */