.class public Lio/vov/vitamio/widget/MediaController;
.super Landroid/widget/FrameLayout;
.source "MediaController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;,
        Lio/vov/vitamio/widget/MediaController$OnHiddenListener;,
        Lio/vov/vitamio/widget/MediaController$OnShownListener;
    }
.end annotation


# static fields
.field private static final FADE_OUT:I = 0x1

.field private static final SHOW_PROGRESS:I = 0x2

.field private static final sDefaultTimeout:I = 0xbb8


# instance fields
.field private mAM:Landroid/media/AudioManager;

.field private mAnchor:Landroid/view/View;

.field private mAnimStyle:I

.field private mContext:Landroid/content/Context;

.field private mCurrentTime:Landroid/widget/TextView;

.field private mDragging:Z

.field private mDuration:J

.field private mEndTime:Landroid/widget/TextView;

.field private mFileName:Landroid/widget/TextView;

.field private mFromXml:Z

.field private mHandler:Landroid/os/Handler;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "HandlerLeak"
        }
    .end annotation
.end field

.field private mHiddenListener:Lio/vov/vitamio/widget/MediaController$OnHiddenListener;

.field private mInfoView:Lio/vov/vitamio/widget/OutlineTextView;

.field private mInstantSeeking:Z

.field private mPauseButton:Landroid/widget/ImageButton;

.field private mPauseListener:Landroid/view/View$OnClickListener;

.field private mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

.field private mProgress:Landroid/widget/SeekBar;

.field private mRoot:Landroid/view/View;

.field private mSeekListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

.field private mShowing:Z

.field private mShownListener:Lio/vov/vitamio/widget/MediaController$OnShownListener;

.field private mTitle:Ljava/lang/String;

.field private mWindow:Landroid/widget/PopupWindow;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 176
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 94
    iput-boolean v0, p0, Lio/vov/vitamio/widget/MediaController;->mInstantSeeking:Z

    .line 95
    iput-boolean v0, p0, Lio/vov/vitamio/widget/MediaController;->mFromXml:Z

    .line 100
    new-instance v0, Lio/vov/vitamio/widget/MediaController$1;

    invoke-direct {v0, p0}, Lio/vov/vitamio/widget/MediaController$1;-><init>(Lio/vov/vitamio/widget/MediaController;)V

    iput-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mHandler:Landroid/os/Handler;

    .line 120
    new-instance v0, Lio/vov/vitamio/widget/MediaController$2;

    invoke-direct {v0, p0}, Lio/vov/vitamio/widget/MediaController$2;-><init>(Lio/vov/vitamio/widget/MediaController;)V

    iput-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPauseListener:Landroid/view/View$OnClickListener;

    .line 126
    new-instance v0, Lio/vov/vitamio/widget/MediaController$3;

    invoke-direct {v0, p0}, Lio/vov/vitamio/widget/MediaController$3;-><init>(Lio/vov/vitamio/widget/MediaController;)V

    iput-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mSeekListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    .line 177
    iget-boolean v0, p0, Lio/vov/vitamio/widget/MediaController;->mFromXml:Z

    if-nez v0, :cond_0

    invoke-direct {p0, p1}, Lio/vov/vitamio/widget/MediaController;->initController(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 178
    invoke-direct {p0}, Lio/vov/vitamio/widget/MediaController;->initFloatingWindow()V

    .line 179
    :cond_0
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v0, 0x0

    .line 169
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 94
    iput-boolean v0, p0, Lio/vov/vitamio/widget/MediaController;->mInstantSeeking:Z

    .line 95
    iput-boolean v0, p0, Lio/vov/vitamio/widget/MediaController;->mFromXml:Z

    .line 100
    new-instance v0, Lio/vov/vitamio/widget/MediaController$1;

    invoke-direct {v0, p0}, Lio/vov/vitamio/widget/MediaController$1;-><init>(Lio/vov/vitamio/widget/MediaController;)V

    iput-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mHandler:Landroid/os/Handler;

    .line 120
    new-instance v0, Lio/vov/vitamio/widget/MediaController$2;

    invoke-direct {v0, p0}, Lio/vov/vitamio/widget/MediaController$2;-><init>(Lio/vov/vitamio/widget/MediaController;)V

    iput-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPauseListener:Landroid/view/View$OnClickListener;

    .line 126
    new-instance v0, Lio/vov/vitamio/widget/MediaController$3;

    invoke-direct {v0, p0}, Lio/vov/vitamio/widget/MediaController$3;-><init>(Lio/vov/vitamio/widget/MediaController;)V

    iput-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mSeekListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    .line 170
    iput-object p0, p0, Lio/vov/vitamio/widget/MediaController;->mRoot:Landroid/view/View;

    .line 171
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/vov/vitamio/widget/MediaController;->mFromXml:Z

    .line 172
    invoke-direct {p0, p1}, Lio/vov/vitamio/widget/MediaController;->initController(Landroid/content/Context;)Z

    .line 173
    return-void
.end method

.method static synthetic access$000(Lio/vov/vitamio/widget/MediaController;)J
    .locals 2
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    invoke-direct {p0}, Lio/vov/vitamio/widget/MediaController;->setProgress()J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$100(Lio/vov/vitamio/widget/MediaController;)Z
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    iget-boolean v0, p0, Lio/vov/vitamio/widget/MediaController;->mDragging:Z

    return v0
.end method

.method static synthetic access$1000(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    return-object v0
.end method

.method static synthetic access$102(Lio/vov/vitamio/widget/MediaController;Z)Z
    .locals 0
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;
    .param p1, "x1"    # Z

    .prologue
    .line 76
    iput-boolean p1, p0, Lio/vov/vitamio/widget/MediaController;->mDragging:Z

    return p1
.end method

.method static synthetic access$1100(Lio/vov/vitamio/widget/MediaController;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mCurrentTime:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$200(Lio/vov/vitamio/widget/MediaController;)Z
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    iget-boolean v0, p0, Lio/vov/vitamio/widget/MediaController;->mShowing:Z

    return v0
.end method

.method static synthetic access$300(Lio/vov/vitamio/widget/MediaController;)V
    .locals 0
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    invoke-direct {p0}, Lio/vov/vitamio/widget/MediaController;->updatePausePlay()V

    return-void
.end method

.method static synthetic access$400(Lio/vov/vitamio/widget/MediaController;)V
    .locals 0
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    invoke-direct {p0}, Lio/vov/vitamio/widget/MediaController;->doPauseResume()V

    return-void
.end method

.method static synthetic access$500(Lio/vov/vitamio/widget/MediaController;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$600(Lio/vov/vitamio/widget/MediaController;)Z
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    iget-boolean v0, p0, Lio/vov/vitamio/widget/MediaController;->mInstantSeeking:Z

    return v0
.end method

.method static synthetic access$700(Lio/vov/vitamio/widget/MediaController;)Landroid/media/AudioManager;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mAM:Landroid/media/AudioManager;

    return-object v0
.end method

.method static synthetic access$800(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/OutlineTextView;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mInfoView:Lio/vov/vitamio/widget/OutlineTextView;

    return-object v0
.end method

.method static synthetic access$900(Lio/vov/vitamio/widget/MediaController;)J
    .locals 2
    .param p0, "x0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 76
    iget-wide v0, p0, Lio/vov/vitamio/widget/MediaController;->mDuration:J

    return-wide v0
.end method

.method private doPauseResume()V
    .locals 1

    .prologue
    .line 463
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    invoke-interface {v0}, Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 464
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    invoke-interface {v0}, Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;->pause()V

    .line 467
    :goto_0
    invoke-direct {p0}, Lio/vov/vitamio/widget/MediaController;->updatePausePlay()V

    .line 468
    return-void

    .line 466
    :cond_0
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    invoke-interface {v0}, Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;->start()V

    goto :goto_0
.end method

.method private initController(Landroid/content/Context;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 182
    iput-object p1, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    .line 183
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    const-string v1, "audio"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    iput-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mAM:Landroid/media/AudioManager;

    .line 184
    const/4 v0, 0x1

    return v0
.end method

.method private initControllerView(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 243
    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "mediacontroller_play_pause"

    const-string v3, "id"

    iget-object v4, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    iput-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    .line 244
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    if-eqz v1, :cond_0

    .line 245
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    invoke-virtual {v1}, Landroid/widget/ImageButton;->requestFocus()Z

    .line 246
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mPauseListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 249
    :cond_0
    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "mediacontroller_seekbar"

    const-string v3, "id"

    iget-object v4, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/SeekBar;

    iput-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mProgress:Landroid/widget/SeekBar;

    .line 250
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mProgress:Landroid/widget/SeekBar;

    if-eqz v1, :cond_2

    .line 251
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mProgress:Landroid/widget/SeekBar;

    instance-of v1, v1, Landroid/widget/SeekBar;

    if-eqz v1, :cond_1

    .line 252
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mProgress:Landroid/widget/SeekBar;

    .line 253
    .local v0, "seeker":Landroid/widget/SeekBar;
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mSeekListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 255
    .end local v0    # "seeker":Landroid/widget/SeekBar;
    :cond_1
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mProgress:Landroid/widget/SeekBar;

    const/16 v2, 0x3e8

    invoke-virtual {v1, v2}, Landroid/widget/SeekBar;->setMax(I)V

    .line 258
    :cond_2
    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "mediacontroller_time_total"

    const-string v3, "id"

    iget-object v4, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mEndTime:Landroid/widget/TextView;

    .line 259
    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "mediacontroller_time_current"

    const-string v3, "id"

    iget-object v4, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mCurrentTime:Landroid/widget/TextView;

    .line 260
    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "mediacontroller_file_name"

    const-string v3, "id"

    iget-object v4, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mFileName:Landroid/widget/TextView;

    .line 261
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mFileName:Landroid/widget/TextView;

    if-eqz v1, :cond_3

    .line 262
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mFileName:Landroid/widget/TextView;

    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mTitle:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 263
    :cond_3
    return-void
.end method

.method private initFloatingWindow()V
    .locals 2

    .prologue
    .line 194
    new-instance v0, Landroid/widget/PopupWindow;

    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/PopupWindow;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mWindow:Landroid/widget/PopupWindow;

    .line 195
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mWindow:Landroid/widget/PopupWindow;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setFocusable(Z)V

    .line 196
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mWindow:Landroid/widget/PopupWindow;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 197
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mWindow:Landroid/widget/PopupWindow;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V

    .line 198
    const/high16 v0, 0x1030000

    iput v0, p0, Lio/vov/vitamio/widget/MediaController;->mAnimStyle:I

    .line 199
    return-void
.end method

.method private setProgress()J
    .locals 10

    .prologue
    const-wide/16 v8, 0x0

    .line 392
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    if-eqz v3, :cond_0

    iget-boolean v3, p0, Lio/vov/vitamio/widget/MediaController;->mDragging:Z

    if-eqz v3, :cond_2

    :cond_0
    move-wide v6, v8

    .line 413
    :cond_1
    :goto_0
    return-wide v6

    .line 395
    :cond_2
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    invoke-interface {v3}, Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;->getCurrentPosition()J

    move-result-wide v6

    .line 396
    .local v6, "position":J
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    invoke-interface {v3}, Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;->getDuration()J

    move-result-wide v0

    .line 397
    .local v0, "duration":J
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mProgress:Landroid/widget/SeekBar;

    if-eqz v3, :cond_4

    .line 398
    cmp-long v3, v0, v8

    if-lez v3, :cond_3

    .line 399
    const-wide/16 v8, 0x3e8

    mul-long/2addr v8, v6

    div-long v4, v8, v0

    .line 400
    .local v4, "pos":J
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mProgress:Landroid/widget/SeekBar;

    long-to-int v8, v4

    invoke-virtual {v3, v8}, Landroid/widget/SeekBar;->setProgress(I)V

    .line 402
    .end local v4    # "pos":J
    :cond_3
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    invoke-interface {v3}, Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;->getBufferPercentage()I

    move-result v2

    .line 403
    .local v2, "percent":I
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mProgress:Landroid/widget/SeekBar;

    mul-int/lit8 v8, v2, 0xa

    invoke-virtual {v3, v8}, Landroid/widget/SeekBar;->setSecondaryProgress(I)V

    .line 406
    .end local v2    # "percent":I
    :cond_4
    iput-wide v0, p0, Lio/vov/vitamio/widget/MediaController;->mDuration:J

    .line 408
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mEndTime:Landroid/widget/TextView;

    if-eqz v3, :cond_5

    .line 409
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mEndTime:Landroid/widget/TextView;

    iget-wide v8, p0, Lio/vov/vitamio/widget/MediaController;->mDuration:J

    invoke-static {v8, v9}, Lio/vov/vitamio/utils/StringUtils;->generateTime(J)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 410
    :cond_5
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mCurrentTime:Landroid/widget/TextView;

    if-eqz v3, :cond_1

    .line 411
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mCurrentTime:Landroid/widget/TextView;

    invoke-static {v6, v7}, Lio/vov/vitamio/utils/StringUtils;->generateTime(J)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method private updatePausePlay()V
    .locals 5

    .prologue
    .line 453
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mRoot:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    if-nez v0, :cond_1

    .line 460
    :cond_0
    :goto_0
    return-void

    .line 456
    :cond_1
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    invoke-interface {v0}, Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 457
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "mediacontroller_pause"

    const-string v3, "drawable"

    iget-object v4, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto :goto_0

    .line 459
    :cond_2
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "mediacontroller_play"

    const-string v3, "drawable"

    iget-object v4, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto :goto_0
.end method


# virtual methods
.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/16 v3, 0xbb8

    const/4 v1, 0x1

    .line 430
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    .line 431
    .local v0, "keyCode":I
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v2

    if-nez v2, :cond_2

    const/16 v2, 0x4f

    if-eq v0, v2, :cond_0

    const/16 v2, 0x55

    if-eq v0, v2, :cond_0

    const/16 v2, 0x3e

    if-ne v0, v2, :cond_2

    .line 432
    :cond_0
    invoke-direct {p0}, Lio/vov/vitamio/widget/MediaController;->doPauseResume()V

    .line 433
    invoke-virtual {p0, v3}, Lio/vov/vitamio/widget/MediaController;->show(I)V

    .line 434
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    if-eqz v2, :cond_1

    .line 435
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    invoke-virtual {v2}, Landroid/widget/ImageButton;->requestFocus()Z

    .line 449
    :cond_1
    :goto_0
    return v1

    .line 437
    :cond_2
    const/16 v2, 0x56

    if-ne v0, v2, :cond_3

    .line 438
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    invoke-interface {v2}, Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;->isPlaying()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 439
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    invoke-interface {v2}, Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;->pause()V

    .line 440
    invoke-direct {p0}, Lio/vov/vitamio/widget/MediaController;->updatePausePlay()V

    goto :goto_0

    .line 443
    :cond_3
    const/4 v2, 0x4

    if-eq v0, v2, :cond_4

    const/16 v2, 0x52

    if-ne v0, v2, :cond_5

    .line 444
    :cond_4
    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->hide()V

    goto :goto_0

    .line 447
    :cond_5
    invoke-virtual {p0, v3}, Lio/vov/vitamio/widget/MediaController;->show(I)V

    .line 449
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0
.end method

.method public hide()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 364
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mAnchor:Landroid/view/View;

    if-nez v1, :cond_1

    .line 381
    :cond_0
    :goto_0
    return-void

    .line 367
    :cond_1
    iget-boolean v1, p0, Lio/vov/vitamio/widget/MediaController;->mShowing:Z

    if-eqz v1, :cond_0

    .line 369
    :try_start_0
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mHandler:Landroid/os/Handler;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroid/os/Handler;->removeMessages(I)V

    .line 370
    iget-boolean v1, p0, Lio/vov/vitamio/widget/MediaController;->mFromXml:Z

    if-eqz v1, :cond_2

    .line 371
    const/16 v1, 0x8

    invoke-virtual {p0, v1}, Lio/vov/vitamio/widget/MediaController;->setVisibility(I)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 377
    :goto_1
    iput-boolean v3, p0, Lio/vov/vitamio/widget/MediaController;->mShowing:Z

    .line 378
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mHiddenListener:Lio/vov/vitamio/widget/MediaController$OnHiddenListener;

    if-eqz v1, :cond_0

    .line 379
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mHiddenListener:Lio/vov/vitamio/widget/MediaController$OnHiddenListener;

    invoke-interface {v1}, Lio/vov/vitamio/widget/MediaController$OnHiddenListener;->onHidden()V

    goto :goto_0

    .line 373
    :cond_2
    :try_start_1
    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v1}, Landroid/widget/PopupWindow;->dismiss()V
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 374
    :catch_0
    move-exception v0

    .line 375
    .local v0, "ex":Ljava/lang/IllegalArgumentException;
    const-string v1, "MediaController already removed"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method public isShowing()Z
    .locals 1

    .prologue
    .line 360
    iget-boolean v0, p0, Lio/vov/vitamio/widget/MediaController;->mShowing:Z

    return v0
.end method

.method protected makeControllerView()Landroid/view/View;
    .locals 5

    .prologue
    .line 239
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "mediacontroller"

    const-string v3, "layout"

    iget-object v4, p0, Lio/vov/vitamio/widget/MediaController;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1, p0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onFinishInflate()V
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mRoot:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 190
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mRoot:Landroid/view/View;

    invoke-direct {p0, v0}, Lio/vov/vitamio/widget/MediaController;->initControllerView(Landroid/view/View;)V

    .line 191
    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 418
    const/16 v0, 0xbb8

    invoke-virtual {p0, v0}, Lio/vov/vitamio/widget/MediaController;->show(I)V

    .line 419
    const/4 v0, 0x1

    return v0
.end method

.method public onTrackballEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 424
    const/16 v0, 0xbb8

    invoke-virtual {p0, v0}, Lio/vov/vitamio/widget/MediaController;->show(I)V

    .line 425
    const/4 v0, 0x0

    return v0
.end method

.method public setAnchorView(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 221
    iput-object p1, p0, Lio/vov/vitamio/widget/MediaController;->mAnchor:Landroid/view/View;

    .line 222
    iget-boolean v0, p0, Lio/vov/vitamio/widget/MediaController;->mFromXml:Z

    if-nez v0, :cond_0

    .line 223
    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->removeAllViews()V

    .line 224
    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->makeControllerView()Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mRoot:Landroid/view/View;

    .line 225
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mWindow:Landroid/widget/PopupWindow;

    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mRoot:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setContentView(Landroid/view/View;)V

    .line 226
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mWindow:Landroid/widget/PopupWindow;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 227
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mWindow:Landroid/widget/PopupWindow;

    const/4 v1, -0x2

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 229
    :cond_0
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mRoot:Landroid/view/View;

    invoke-direct {p0, v0}, Lio/vov/vitamio/widget/MediaController;->initControllerView(Landroid/view/View;)V

    .line 230
    return-void
.end method

.method public setAnimationStyle(I)V
    .locals 0
    .param p1, "animationStyle"    # I

    .prologue
    .line 319
    iput p1, p0, Lio/vov/vitamio/widget/MediaController;->mAnimStyle:I

    .line 320
    return-void
.end method

.method public setEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 472
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    if-eqz v0, :cond_0

    .line 473
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 474
    :cond_0
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mProgress:Landroid/widget/SeekBar;

    if-eqz v0, :cond_1

    .line 475
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mProgress:Landroid/widget/SeekBar;

    invoke-virtual {v0, p1}, Landroid/widget/SeekBar;->setEnabled(Z)V

    .line 476
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->setEnabled(Z)V

    .line 477
    return-void
.end method

.method public setFileName(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 289
    iput-object p1, p0, Lio/vov/vitamio/widget/MediaController;->mTitle:Ljava/lang/String;

    .line 290
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mFileName:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 291
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController;->mFileName:Landroid/widget/TextView;

    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController;->mTitle:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 292
    :cond_0
    return-void
.end method

.method public setInfoView(Lio/vov/vitamio/widget/OutlineTextView;)V
    .locals 0
    .param p1, "v"    # Lio/vov/vitamio/widget/OutlineTextView;

    .prologue
    .line 301
    iput-object p1, p0, Lio/vov/vitamio/widget/MediaController;->mInfoView:Lio/vov/vitamio/widget/OutlineTextView;

    .line 302
    return-void
.end method

.method public setInstantSeeking(Z)V
    .locals 0
    .param p1, "seekWhenDragging"    # Z

    .prologue
    .line 276
    iput-boolean p1, p0, Lio/vov/vitamio/widget/MediaController;->mInstantSeeking:Z

    .line 277
    return-void
.end method

.method public setMediaPlayer(Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;)V
    .locals 0
    .param p1, "player"    # Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    .prologue
    .line 266
    iput-object p1, p0, Lio/vov/vitamio/widget/MediaController;->mPlayer:Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    .line 267
    invoke-direct {p0}, Lio/vov/vitamio/widget/MediaController;->updatePausePlay()V

    .line 268
    return-void
.end method

.method public setOnHiddenListener(Lio/vov/vitamio/widget/MediaController$OnHiddenListener;)V
    .locals 0
    .param p1, "l"    # Lio/vov/vitamio/widget/MediaController$OnHiddenListener;

    .prologue
    .line 388
    iput-object p1, p0, Lio/vov/vitamio/widget/MediaController;->mHiddenListener:Lio/vov/vitamio/widget/MediaController$OnHiddenListener;

    .line 389
    return-void
.end method

.method public setOnShownListener(Lio/vov/vitamio/widget/MediaController$OnShownListener;)V
    .locals 0
    .param p1, "l"    # Lio/vov/vitamio/widget/MediaController$OnShownListener;

    .prologue
    .line 384
    iput-object p1, p0, Lio/vov/vitamio/widget/MediaController;->mShownListener:Lio/vov/vitamio/widget/MediaController$OnShownListener;

    .line 385
    return-void
.end method

.method public setWindowLayoutType()V
    .locals 7
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 203
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xe

    if-lt v2, v3, :cond_0

    .line 205
    :try_start_0
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mAnchor:Landroid/view/View;

    const/16 v3, 0x200

    invoke-virtual {v2, v3}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 206
    const-class v2, Landroid/widget/PopupWindow;

    const-string v3, "setWindowLayoutType"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    sget-object v6, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 207
    .local v1, "setWindowLayoutType":Ljava/lang/reflect/Method;
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mWindow:Landroid/widget/PopupWindow;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const/16 v5, 0x3eb

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 212
    .end local v1    # "setWindowLayoutType":Ljava/lang/reflect/Method;
    :cond_0
    :goto_0
    return-void

    .line 208
    :catch_0
    move-exception v0

    .line 209
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "setWindowLayoutType"

    invoke-static {v2, v0}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public show()V
    .locals 1

    .prologue
    .line 280
    const/16 v0, 0xbb8

    invoke-virtual {p0, v0}, Lio/vov/vitamio/widget/MediaController;->show(I)V

    .line 281
    return-void
.end method

.method public show(I)V
    .locals 10
    .param p1, "timeout"    # I

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 330
    iget-boolean v2, p0, Lio/vov/vitamio/widget/MediaController;->mShowing:Z

    if-nez v2, :cond_1

    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mAnchor:Landroid/view/View;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mAnchor:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 331
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    if-eqz v2, :cond_0

    .line 332
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mPauseButton:Landroid/widget/ImageButton;

    invoke-virtual {v2}, Landroid/widget/ImageButton;->requestFocus()Z

    .line 334
    :cond_0
    iget-boolean v2, p0, Lio/vov/vitamio/widget/MediaController;->mFromXml:Z

    if-eqz v2, :cond_3

    .line 335
    invoke-virtual {p0, v8}, Lio/vov/vitamio/widget/MediaController;->setVisibility(I)V

    .line 346
    :goto_0
    iput-boolean v7, p0, Lio/vov/vitamio/widget/MediaController;->mShowing:Z

    .line 347
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mShownListener:Lio/vov/vitamio/widget/MediaController$OnShownListener;

    if-eqz v2, :cond_1

    .line 348
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mShownListener:Lio/vov/vitamio/widget/MediaController$OnShownListener;

    invoke-interface {v2}, Lio/vov/vitamio/widget/MediaController$OnShownListener;->onShown()V

    .line 350
    :cond_1
    invoke-direct {p0}, Lio/vov/vitamio/widget/MediaController;->updatePausePlay()V

    .line 351
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2, v9}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 353
    if-eqz p1, :cond_2

    .line 354
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2, v7}, Landroid/os/Handler;->removeMessages(I)V

    .line 355
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mHandler:Landroid/os/Handler;

    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v7}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    int-to-long v4, p1

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 357
    :cond_2
    return-void

    .line 337
    :cond_3
    new-array v1, v9, [I

    .line 339
    .local v1, "location":[I
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mAnchor:Landroid/view/View;

    invoke-virtual {v2, v1}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 340
    new-instance v0, Landroid/graphics/Rect;

    aget v2, v1, v8

    aget v3, v1, v7

    aget v4, v1, v8

    iget-object v5, p0, Lio/vov/vitamio/widget/MediaController;->mAnchor:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getWidth()I

    move-result v5

    add-int/2addr v4, v5

    aget v5, v1, v7

    iget-object v6, p0, Lio/vov/vitamio/widget/MediaController;->mAnchor:Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->getHeight()I

    move-result v6

    add-int/2addr v5, v6

    invoke-direct {v0, v2, v3, v4, v5}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 342
    .local v0, "anchorRect":Landroid/graphics/Rect;
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mWindow:Landroid/widget/PopupWindow;

    iget v3, p0, Lio/vov/vitamio/widget/MediaController;->mAnimStyle:I

    invoke-virtual {v2, v3}, Landroid/widget/PopupWindow;->setAnimationStyle(I)V

    .line 343
    invoke-virtual {p0}, Lio/vov/vitamio/widget/MediaController;->setWindowLayoutType()V

    .line 344
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController;->mWindow:Landroid/widget/PopupWindow;

    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController;->mAnchor:Landroid/view/View;

    iget v4, v0, Landroid/graphics/Rect;->left:I

    iget v5, v0, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {v2, v3, v8, v4, v5}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    goto :goto_0
.end method
