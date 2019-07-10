package com.google.firebase.appindexing;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.appindexing.internal.ActionImpl;
import com.google.firebase.appindexing.internal.ActionImpl.MetadataImpl;
import com.google.firebase.appindexing.internal.zzl;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract interface Action
{
  public static class Builder
  {
    public static final String ACTIVATE_ACTION = "ActivateAction";
    public static final String ADD_ACTION = "AddAction";
    public static final String BOOKMARK_ACTION = "BookmarkAction";
    public static final String COMMENT_ACTION = "CommentAction";
    public static final String LIKE_ACTION = "LikeAction";
    public static final String LISTEN_ACTION = "ListenAction";
    public static final String SEND_ACTION = "SendAction";
    public static final String SHARE_ACTION = "ShareAction";
    public static final String STATUS_TYPE_ACTIVE = "http://schema.org/ActiveActionStatus";
    public static final String STATUS_TYPE_COMPLETED = "http://schema.org/CompletedActionStatus";
    public static final String STATUS_TYPE_FAILED = "http://schema.org/FailedActionStatus";
    public static final String VIEW_ACTION = "ViewAction";
    public static final String WATCH_ACTION = "WatchAction";
    private final String aWl;
    private String aWm;
    private String aWn;
    private String aWo;
    private ActionImpl.MetadataImpl aWp = Action.Metadata.aWr;
    private String aWq;

    public Builder(String paramString)
    {
      this.aWl = paramString;
    }

    public Action build()
    {
      zzaa.zzb(this.aWm, "setObject is required before calling build().");
      zzaa.zzb(this.aWn, "setObject is required before calling build().");
      return new ActionImpl(this.aWl, this.aWm, this.aWn, this.aWo, this.aWp, this.aWq);
    }

    public Builder setActionStatus(@StatusType String paramString)
    {
      zzaa.zzy(paramString);
      this.aWq = paramString;
      return this;
    }

    public Builder setMetadata(@NonNull Action.Metadata.Builder paramBuilder)
    {
      zzaa.zzy(paramBuilder);
      this.aWp = paramBuilder.zzcny();
      return this;
    }

    public Builder setObject(@NonNull String paramString1, @NonNull String paramString2)
      throws FirebaseAppIndexingInvalidArgumentException
    {
      zzaa.zzy(paramString1);
      zzl.zzrs(paramString2);
      this.aWm = paramString1;
      this.aWn = paramString2;
      return this;
    }

    public Builder setObject(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
      throws FirebaseAppIndexingInvalidArgumentException
    {
      zzaa.zzy(paramString1);
      zzl.zzrs(paramString2);
      zzl.zzrt(paramString3);
      this.aWm = paramString1;
      this.aWn = paramString2;
      this.aWo = paramString3;
      return this;
    }

    @Retention(RetentionPolicy.CLASS)
    public static @interface StatusType
    {
    }
  }

  public static abstract interface Metadata
  {
    public static final ActionImpl.MetadataImpl aWr = new Builder().zzcny();

    public static class Builder
    {
      private boolean aWs = true;
      private boolean aWt = false;

      public Builder setUpload(boolean paramBoolean)
      {
        this.aWs = paramBoolean;
        return this;
      }

      public ActionImpl.MetadataImpl zzcny()
      {
        return new ActionImpl.MetadataImpl(this.aWs, null, null, null, false);
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.Action
 * JD-Core Version:    0.6.0
 */