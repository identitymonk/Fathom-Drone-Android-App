.class public Lcom/facebook/react/views/image/ReactImageView;
.super Lcom/facebook/drawee/view/GenericDraweeView;
.source "ReactImageView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;
    }
.end annotation


# static fields
.field public static final REMOTE_IMAGE_FADE_DURATION_MS:I = 0x12c

.field private static sComputedCornerRadii:[F

.field private static final sInverse:Landroid/graphics/Matrix;

.field private static final sMatrix:Landroid/graphics/Matrix;


# instance fields
.field private mBorderColor:I

.field private mBorderCornerRadii:[F
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mBorderRadius:F

.field private mBorderWidth:F

.field private mCachedImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mCallerContext:Ljava/lang/Object;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mControllerForTesting:Lcom/facebook/drawee/controller/ControllerListener;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mDraweeControllerBuilder:Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

.field private mFadeDurationMs:I

.field private mGlobalImageLoadListener:Lcom/facebook/react/views/image/GlobalImageLoadListener;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mHeaders:Lcom/facebook/react/bridge/ReadableMap;

.field private mImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mIsDirty:Z

.field private mIterativeBoxBlurPostProcessor:Lcom/facebook/imagepipeline/postprocessors/IterativeBoxBlurPostProcessor;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mLoadingImageDrawable:Landroid/graphics/drawable/Drawable;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mOverlayColor:I

.field private mProgressiveRenderingEnabled:Z

.field private mResizeMethod:Lcom/facebook/react/views/image/ImageResizeMethod;

.field private final mRoundedCornerPostprocessor:Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;

.field private mScaleType:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

.field private final mSources:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/facebook/react/views/imagehelper/ImageSource;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 72
    const/4 v0, 0x4

    new-array v0, v0, [F

    sput-object v0, Lcom/facebook/react/views/image/ReactImageView;->sComputedCornerRadii:[F

    .line 85
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    sput-object v0, Lcom/facebook/react/views/image/ReactImageView;->sMatrix:Landroid/graphics/Matrix;

    .line 86
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    sput-object v0, Lcom/facebook/react/views/image/ReactImageView;->sInverse:Landroid/graphics/Matrix;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;Lcom/facebook/react/views/image/GlobalImageLoadListener;Ljava/lang/Object;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "draweeControllerBuilder"    # Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    .param p3, "globalImageLoadListener"    # Lcom/facebook/react/views/image/GlobalImageLoadListener;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "callerContext"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 181
    invoke-static {p1}, Lcom/facebook/react/views/image/ReactImageView;->buildHierarchy(Landroid/content/Context;)Lcom/facebook/drawee/generic/GenericDraweeHierarchy;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/facebook/drawee/view/GenericDraweeView;-><init>(Landroid/content/Context;Lcom/facebook/drawee/generic/GenericDraweeHierarchy;)V

    .line 87
    sget-object v0, Lcom/facebook/react/views/image/ImageResizeMethod;->AUTO:Lcom/facebook/react/views/image/ImageResizeMethod;

    iput-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mResizeMethod:Lcom/facebook/react/views/image/ImageResizeMethod;

    .line 154
    const/high16 v0, 0x7fc00000    # Float.NaN

    iput v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderRadius:F

    .line 165
    const/4 v0, -0x1

    iput v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mFadeDurationMs:I

    .line 182
    invoke-static {}, Lcom/facebook/react/views/image/ImageResizeMode;->defaultValue()Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mScaleType:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    .line 183
    iput-object p2, p0, Lcom/facebook/react/views/image/ReactImageView;->mDraweeControllerBuilder:Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    .line 184
    new-instance v0, Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;-><init>(Lcom/facebook/react/views/image/ReactImageView;Lcom/facebook/react/views/image/ReactImageView$1;)V

    iput-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mRoundedCornerPostprocessor:Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;

    .line 185
    iput-object p3, p0, Lcom/facebook/react/views/image/ReactImageView;->mGlobalImageLoadListener:Lcom/facebook/react/views/image/GlobalImageLoadListener;

    .line 186
    iput-object p4, p0, Lcom/facebook/react/views/image/ReactImageView;->mCallerContext:Ljava/lang/Object;

    .line 187
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mSources:Ljava/util/List;

    .line 188
    return-void
.end method

.method static synthetic access$000()Landroid/graphics/Matrix;
    .locals 1

    .prologue
    .line 68
    sget-object v0, Lcom/facebook/react/views/image/ReactImageView;->sMatrix:Landroid/graphics/Matrix;

    return-object v0
.end method

.method static synthetic access$100(Lcom/facebook/react/views/image/ReactImageView;)Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/views/image/ReactImageView;

    .prologue
    .line 68
    iget-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mScaleType:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    return-object v0
.end method

.method static synthetic access$200()Landroid/graphics/Matrix;
    .locals 1

    .prologue
    .line 68
    sget-object v0, Lcom/facebook/react/views/image/ReactImageView;->sInverse:Landroid/graphics/Matrix;

    return-object v0
.end method

.method static synthetic access$300()[F
    .locals 1

    .prologue
    .line 68
    sget-object v0, Lcom/facebook/react/views/image/ReactImageView;->sComputedCornerRadii:[F

    return-object v0
.end method

.method static synthetic access$400(Lcom/facebook/react/views/image/ReactImageView;[F)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/views/image/ReactImageView;
    .param p1, "x1"    # [F

    .prologue
    .line 68
    invoke-direct {p0, p1}, Lcom/facebook/react/views/image/ReactImageView;->cornerRadii([F)V

    return-void
.end method

.method static synthetic access$600(Lcom/facebook/react/views/image/ReactImageView;)Lcom/facebook/react/views/imagehelper/ImageSource;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/views/image/ReactImageView;

    .prologue
    .line 68
    iget-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    return-object v0
.end method

.method private static buildHierarchy(Landroid/content/Context;)Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 171
    new-instance v0, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;-><init>(Landroid/content/res/Resources;)V

    const/4 v1, 0x0

    .line 172
    invoke-static {v1}, Lcom/facebook/drawee/generic/RoundingParams;->fromCornersRadius(F)Lcom/facebook/drawee/generic/RoundingParams;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setRoundingParams(Lcom/facebook/drawee/generic/RoundingParams;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;

    move-result-object v0

    .line 173
    invoke-virtual {v0}, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->build()Lcom/facebook/drawee/generic/GenericDraweeHierarchy;

    move-result-object v0

    return-object v0
.end method

.method private cornerRadii([F)V
    .locals 6
    .param p1, "computedCorners"    # [F

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 334
    iget v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderRadius:F

    invoke-static {v1}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v1

    if-nez v1, :cond_1

    iget v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderRadius:F

    .line 336
    .local v0, "defaultBorderRadius":F
    :goto_0
    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    aget v1, v1, v2

    invoke-static {v1}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    aget v1, v1, v2

    :goto_1
    aput v1, p1, v2

    .line 337
    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    aget v1, v1, v3

    invoke-static {v1}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v1

    if-nez v1, :cond_3

    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    aget v1, v1, v3

    :goto_2
    aput v1, p1, v3

    .line 338
    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    aget v1, v1, v4

    invoke-static {v1}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v1

    if-nez v1, :cond_4

    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    aget v1, v1, v4

    :goto_3
    aput v1, p1, v4

    .line 339
    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    aget v1, v1, v5

    invoke-static {v1}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    aget v0, v1, v5

    .end local v0    # "defaultBorderRadius":F
    :cond_0
    aput v0, p1, v5

    .line 340
    return-void

    .line 334
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .restart local v0    # "defaultBorderRadius":F
    :cond_2
    move v1, v0

    .line 336
    goto :goto_1

    :cond_3
    move v1, v0

    .line 337
    goto :goto_2

    :cond_4
    move v1, v0

    .line 338
    goto :goto_3
.end method

.method private hasMultipleSources()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 487
    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mSources:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-le v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setSourceImage()V
    .locals 4

    .prologue
    .line 491
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    .line 492
    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mSources:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 504
    :goto_0
    return-void

    .line 495
    :cond_0
    invoke-direct {p0}, Lcom/facebook/react/views/image/ReactImageView;->hasMultipleSources()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 497
    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getWidth()I

    move-result v1

    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getHeight()I

    move-result v2

    iget-object v3, p0, Lcom/facebook/react/views/image/ReactImageView;->mSources:Ljava/util/List;

    invoke-static {v1, v2, v3}, Lcom/facebook/react/views/imagehelper/MultiSourceHelper;->getBestSourceForSize(IILjava/util/List;)Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;

    move-result-object v0

    .line 498
    .local v0, "multiSource":Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;
    invoke-virtual {v0}, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;->getBestResult()Lcom/facebook/react/views/imagehelper/ImageSource;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    .line 499
    invoke-virtual {v0}, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;->getBestResultInCache()Lcom/facebook/react/views/imagehelper/ImageSource;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mCachedImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    goto :goto_0

    .line 503
    .end local v0    # "multiSource":Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;
    :cond_1
    iget-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mSources:Ljava/util/List;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/views/imagehelper/ImageSource;

    iput-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    goto :goto_0
.end method

.method private shouldResize(Lcom/facebook/react/views/imagehelper/ImageSource;)Z
    .locals 4
    .param p1, "imageSource"    # Lcom/facebook/react/views/imagehelper/ImageSource;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 510
    iget-object v2, p0, Lcom/facebook/react/views/image/ReactImageView;->mResizeMethod:Lcom/facebook/react/views/image/ImageResizeMethod;

    sget-object v3, Lcom/facebook/react/views/image/ImageResizeMethod;->AUTO:Lcom/facebook/react/views/image/ImageResizeMethod;

    if-ne v2, v3, :cond_2

    .line 512
    invoke-virtual {p1}, Lcom/facebook/react/views/imagehelper/ImageSource;->getUri()Landroid/net/Uri;

    move-result-object v2

    invoke-static {v2}, Lcom/facebook/common/util/UriUtil;->isLocalContentUri(Landroid/net/Uri;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 513
    invoke-virtual {p1}, Lcom/facebook/react/views/imagehelper/ImageSource;->getUri()Landroid/net/Uri;

    move-result-object v2

    invoke-static {v2}, Lcom/facebook/common/util/UriUtil;->isLocalFileUri(Landroid/net/Uri;)Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    move v0, v1

    .line 517
    :cond_1
    :goto_0
    return v0

    .line 514
    :cond_2
    iget-object v2, p0, Lcom/facebook/react/views/image/ReactImageView;->mResizeMethod:Lcom/facebook/react/views/image/ImageResizeMethod;

    sget-object v3, Lcom/facebook/react/views/image/ImageResizeMethod;->RESIZE:Lcom/facebook/react/views/image/ImageResizeMethod;

    if-ne v2, v3, :cond_1

    move v0, v1

    .line 515
    goto :goto_0
.end method

.method private warnImageSource(Ljava/lang/String;)V
    .locals 0
    .param p1, "uri"    # Ljava/lang/String;

    .prologue
    .line 528
    return-void
.end method


# virtual methods
.method public hasOverlappingRendering()Z
    .locals 1

    .prologue
    .line 483
    const/4 v0, 0x0

    return v0
.end method

.method public maybeUpdateView()V
    .locals 15

    .prologue
    .line 347
    iget-boolean v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    if-nez v10, :cond_1

    .line 460
    :cond_0
    :goto_0
    return-void

    .line 351
    :cond_1
    invoke-direct {p0}, Lcom/facebook/react/views/image/ReactImageView;->hasMultipleSources()Z

    move-result v10

    if-eqz v10, :cond_2

    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getWidth()I

    move-result v10

    if-lez v10, :cond_0

    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getHeight()I

    move-result v10

    if-lez v10, :cond_0

    .line 356
    :cond_2
    invoke-direct {p0}, Lcom/facebook/react/views/image/ReactImageView;->setSourceImage()V

    .line 357
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    if-eqz v10, :cond_0

    .line 361
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    invoke-direct {p0, v10}, Lcom/facebook/react/views/image/ReactImageView;->shouldResize(Lcom/facebook/react/views/imagehelper/ImageSource;)Z

    move-result v2

    .line 362
    .local v2, "doResize":Z
    if-eqz v2, :cond_3

    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getWidth()I

    move-result v10

    if-lez v10, :cond_0

    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getHeight()I

    move-result v10

    if-lez v10, :cond_0

    .line 367
    :cond_3
    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;

    move-result-object v3

    check-cast v3, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;

    .line 368
    .local v3, "hierarchy":Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mScaleType:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    invoke-virtual {v3, v10}, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setActualImageScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V

    .line 370
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mLoadingImageDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v10, :cond_4

    .line 371
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mLoadingImageDrawable:Landroid/graphics/drawable/Drawable;

    sget-object v11, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    invoke-virtual {v3, v10, v11}, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setPlaceholderImage(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V

    .line 374
    :cond_4
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mScaleType:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    sget-object v11, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    if-eq v10, v11, :cond_9

    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mScaleType:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    sget-object v11, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->FOCUS_CROP:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    if-eq v10, v11, :cond_9

    const/4 v9, 0x1

    .line 378
    .local v9, "usePostprocessorScaling":Z
    :goto_1
    invoke-virtual {v3}, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->getRoundingParams()Lcom/facebook/drawee/generic/RoundingParams;

    move-result-object v8

    .line 380
    .local v8, "roundingParams":Lcom/facebook/drawee/generic/RoundingParams;
    if-eqz v9, :cond_a

    .line 381
    const/4 v10, 0x0

    invoke-virtual {v8, v10}, Lcom/facebook/drawee/generic/RoundingParams;->setCornersRadius(F)Lcom/facebook/drawee/generic/RoundingParams;

    .line 388
    :goto_2
    iget v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderColor:I

    iget v11, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderWidth:F

    invoke-virtual {v8, v10, v11}, Lcom/facebook/drawee/generic/RoundingParams;->setBorder(IF)Lcom/facebook/drawee/generic/RoundingParams;

    .line 389
    iget v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mOverlayColor:I

    if-eqz v10, :cond_b

    .line 390
    iget v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mOverlayColor:I

    invoke-virtual {v8, v10}, Lcom/facebook/drawee/generic/RoundingParams;->setOverlayColor(I)Lcom/facebook/drawee/generic/RoundingParams;

    .line 395
    :goto_3
    invoke-virtual {v3, v8}, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setRoundingParams(Lcom/facebook/drawee/generic/RoundingParams;)V

    .line 396
    iget v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mFadeDurationMs:I

    if-ltz v10, :cond_c

    iget v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mFadeDurationMs:I

    :goto_4
    invoke-virtual {v3, v10}, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setFadeDuration(I)V

    .line 402
    const/4 v6, 0x0

    .line 403
    .local v6, "postprocessor":Lcom/facebook/imagepipeline/request/Postprocessor;
    if-eqz v9, :cond_e

    .line 404
    iget-object v6, p0, Lcom/facebook/react/views/image/ReactImageView;->mRoundedCornerPostprocessor:Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;

    .line 409
    :cond_5
    :goto_5
    if-eqz v2, :cond_f

    new-instance v7, Lcom/facebook/imagepipeline/common/ResizeOptions;

    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getWidth()I

    move-result v10

    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getHeight()I

    move-result v11

    invoke-direct {v7, v10, v11}, Lcom/facebook/imagepipeline/common/ResizeOptions;-><init>(II)V

    .line 411
    .local v7, "resizeOptions":Lcom/facebook/imagepipeline/common/ResizeOptions;
    :goto_6
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    invoke-virtual {v10}, Lcom/facebook/react/views/imagehelper/ImageSource;->getUri()Landroid/net/Uri;

    move-result-object v10

    invoke-static {v10}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->newBuilderWithSource(Landroid/net/Uri;)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;

    move-result-object v10

    .line 412
    invoke-virtual {v10, v6}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->setPostprocessor(Lcom/facebook/imagepipeline/request/Postprocessor;)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;

    move-result-object v10

    .line 413
    invoke-virtual {v10, v7}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->setResizeOptions(Lcom/facebook/imagepipeline/common/ResizeOptions;)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;

    move-result-object v10

    const/4 v11, 0x1

    .line 414
    invoke-virtual {v10, v11}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->setAutoRotateEnabled(Z)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;

    move-result-object v10

    iget-boolean v11, p0, Lcom/facebook/react/views/image/ReactImageView;->mProgressiveRenderingEnabled:Z

    .line 415
    invoke-virtual {v10, v11}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->setProgressiveRenderingEnabled(Z)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;

    move-result-object v5

    .line 417
    .local v5, "imageRequestBuilder":Lcom/facebook/imagepipeline/request/ImageRequestBuilder;
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mHeaders:Lcom/facebook/react/bridge/ReadableMap;

    invoke-static {v5, v10}, Lcom/facebook/react/modules/fresco/ReactNetworkImageRequest;->fromBuilderWithHeaders(Lcom/facebook/imagepipeline/request/ImageRequestBuilder;Lcom/facebook/react/bridge/ReadableMap;)Lcom/facebook/react/modules/fresco/ReactNetworkImageRequest;

    move-result-object v4

    .line 419
    .local v4, "imageRequest":Lcom/facebook/imagepipeline/request/ImageRequest;
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mGlobalImageLoadListener:Lcom/facebook/react/views/image/GlobalImageLoadListener;

    if-eqz v10, :cond_6

    .line 420
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mGlobalImageLoadListener:Lcom/facebook/react/views/image/GlobalImageLoadListener;

    iget-object v11, p0, Lcom/facebook/react/views/image/ReactImageView;->mImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    invoke-virtual {v11}, Lcom/facebook/react/views/imagehelper/ImageSource;->getUri()Landroid/net/Uri;

    move-result-object v11

    invoke-interface {v10, v11}, Lcom/facebook/react/views/image/GlobalImageLoadListener;->onLoadAttempt(Landroid/net/Uri;)V

    .line 424
    :cond_6
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mDraweeControllerBuilder:Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    invoke-virtual {v10}, Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;->reset()Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    .line 426
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mDraweeControllerBuilder:Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    const/4 v11, 0x1

    .line 427
    invoke-virtual {v10, v11}, Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;->setAutoPlayAnimations(Z)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/facebook/react/views/image/ReactImageView;->mCallerContext:Ljava/lang/Object;

    .line 428
    invoke-virtual {v10, v11}, Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;->setCallerContext(Ljava/lang/Object;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    move-result-object v10

    .line 429
    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    move-result-object v10

    .line 430
    invoke-virtual {v10, v4}, Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;->setImageRequest(Ljava/lang/Object;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    .line 432
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mCachedImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    if-eqz v10, :cond_7

    .line 433
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mCachedImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    .line 434
    invoke-virtual {v10}, Lcom/facebook/react/views/imagehelper/ImageSource;->getUri()Landroid/net/Uri;

    move-result-object v10

    invoke-static {v10}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->newBuilderWithSource(Landroid/net/Uri;)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;

    move-result-object v10

    .line 435
    invoke-virtual {v10, v6}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->setPostprocessor(Lcom/facebook/imagepipeline/request/Postprocessor;)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;

    move-result-object v10

    .line 436
    invoke-virtual {v10, v7}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->setResizeOptions(Lcom/facebook/imagepipeline/common/ResizeOptions;)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;

    move-result-object v10

    const/4 v11, 0x1

    .line 437
    invoke-virtual {v10, v11}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->setAutoRotateEnabled(Z)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;

    move-result-object v10

    iget-boolean v11, p0, Lcom/facebook/react/views/image/ReactImageView;->mProgressiveRenderingEnabled:Z

    .line 438
    invoke-virtual {v10, v11}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->setProgressiveRenderingEnabled(Z)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;

    move-result-object v10

    .line 439
    invoke-virtual {v10}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->build()Lcom/facebook/imagepipeline/request/ImageRequest;

    move-result-object v0

    .line 440
    .local v0, "cachedImageRequest":Lcom/facebook/imagepipeline/request/ImageRequest;
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mDraweeControllerBuilder:Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    invoke-virtual {v10, v0}, Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;->setLowResImageRequest(Ljava/lang/Object;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    .line 443
    .end local v0    # "cachedImageRequest":Lcom/facebook/imagepipeline/request/ImageRequest;
    :cond_7
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    if-eqz v10, :cond_10

    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mControllerForTesting:Lcom/facebook/drawee/controller/ControllerListener;

    if-eqz v10, :cond_10

    .line 444
    new-instance v1, Lcom/facebook/drawee/controller/ForwardingControllerListener;

    invoke-direct {v1}, Lcom/facebook/drawee/controller/ForwardingControllerListener;-><init>()V

    .line 445
    .local v1, "combinedListener":Lcom/facebook/drawee/controller/ForwardingControllerListener;
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    invoke-virtual {v1, v10}, Lcom/facebook/drawee/controller/ForwardingControllerListener;->addListener(Lcom/facebook/drawee/controller/ControllerListener;)V

    .line 446
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mControllerForTesting:Lcom/facebook/drawee/controller/ControllerListener;

    invoke-virtual {v1, v10}, Lcom/facebook/drawee/controller/ForwardingControllerListener;->addListener(Lcom/facebook/drawee/controller/ControllerListener;)V

    .line 447
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mDraweeControllerBuilder:Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    invoke-virtual {v10, v1}, Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;->setControllerListener(Lcom/facebook/drawee/controller/ControllerListener;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    .line 454
    .end local v1    # "combinedListener":Lcom/facebook/drawee/controller/ForwardingControllerListener;
    :cond_8
    :goto_7
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mDraweeControllerBuilder:Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    invoke-virtual {v10}, Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;

    move-result-object v10

    invoke-virtual {p0, v10}, Lcom/facebook/react/views/image/ReactImageView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V

    .line 455
    const/4 v10, 0x0

    iput-boolean v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 459
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mDraweeControllerBuilder:Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    invoke-virtual {v10}, Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;->reset()Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    goto/16 :goto_0

    .line 374
    .end local v4    # "imageRequest":Lcom/facebook/imagepipeline/request/ImageRequest;
    .end local v5    # "imageRequestBuilder":Lcom/facebook/imagepipeline/request/ImageRequestBuilder;
    .end local v6    # "postprocessor":Lcom/facebook/imagepipeline/request/Postprocessor;
    .end local v7    # "resizeOptions":Lcom/facebook/imagepipeline/common/ResizeOptions;
    .end local v8    # "roundingParams":Lcom/facebook/drawee/generic/RoundingParams;
    .end local v9    # "usePostprocessorScaling":Z
    :cond_9
    const/4 v9, 0x0

    goto/16 :goto_1

    .line 383
    .restart local v8    # "roundingParams":Lcom/facebook/drawee/generic/RoundingParams;
    .restart local v9    # "usePostprocessorScaling":Z
    :cond_a
    sget-object v10, Lcom/facebook/react/views/image/ReactImageView;->sComputedCornerRadii:[F

    invoke-direct {p0, v10}, Lcom/facebook/react/views/image/ReactImageView;->cornerRadii([F)V

    .line 385
    sget-object v10, Lcom/facebook/react/views/image/ReactImageView;->sComputedCornerRadii:[F

    const/4 v11, 0x0

    aget v10, v10, v11

    sget-object v11, Lcom/facebook/react/views/image/ReactImageView;->sComputedCornerRadii:[F

    const/4 v12, 0x1

    aget v11, v11, v12

    sget-object v12, Lcom/facebook/react/views/image/ReactImageView;->sComputedCornerRadii:[F

    const/4 v13, 0x2

    aget v12, v12, v13

    sget-object v13, Lcom/facebook/react/views/image/ReactImageView;->sComputedCornerRadii:[F

    const/4 v14, 0x3

    aget v13, v13, v14

    invoke-virtual {v8, v10, v11, v12, v13}, Lcom/facebook/drawee/generic/RoundingParams;->setCornersRadii(FFFF)Lcom/facebook/drawee/generic/RoundingParams;

    goto/16 :goto_2

    .line 393
    :cond_b
    sget-object v10, Lcom/facebook/drawee/generic/RoundingParams$RoundingMethod;->BITMAP_ONLY:Lcom/facebook/drawee/generic/RoundingParams$RoundingMethod;

    invoke-virtual {v8, v10}, Lcom/facebook/drawee/generic/RoundingParams;->setRoundingMethod(Lcom/facebook/drawee/generic/RoundingParams$RoundingMethod;)Lcom/facebook/drawee/generic/RoundingParams;

    goto/16 :goto_3

    .line 396
    :cond_c
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mImageSource:Lcom/facebook/react/views/imagehelper/ImageSource;

    .line 399
    invoke-virtual {v10}, Lcom/facebook/react/views/imagehelper/ImageSource;->isResource()Z

    move-result v10

    if-eqz v10, :cond_d

    const/4 v10, 0x0

    goto/16 :goto_4

    :cond_d
    const/16 v10, 0x12c

    goto/16 :goto_4

    .line 405
    .restart local v6    # "postprocessor":Lcom/facebook/imagepipeline/request/Postprocessor;
    :cond_e
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mIterativeBoxBlurPostProcessor:Lcom/facebook/imagepipeline/postprocessors/IterativeBoxBlurPostProcessor;

    if-eqz v10, :cond_5

    .line 406
    iget-object v6, p0, Lcom/facebook/react/views/image/ReactImageView;->mIterativeBoxBlurPostProcessor:Lcom/facebook/imagepipeline/postprocessors/IterativeBoxBlurPostProcessor;

    goto/16 :goto_5

    .line 409
    :cond_f
    const/4 v7, 0x0

    goto/16 :goto_6

    .line 448
    .restart local v4    # "imageRequest":Lcom/facebook/imagepipeline/request/ImageRequest;
    .restart local v5    # "imageRequestBuilder":Lcom/facebook/imagepipeline/request/ImageRequestBuilder;
    .restart local v7    # "resizeOptions":Lcom/facebook/imagepipeline/common/ResizeOptions;
    :cond_10
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mControllerForTesting:Lcom/facebook/drawee/controller/ControllerListener;

    if-eqz v10, :cond_11

    .line 449
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mDraweeControllerBuilder:Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    iget-object v11, p0, Lcom/facebook/react/views/image/ReactImageView;->mControllerForTesting:Lcom/facebook/drawee/controller/ControllerListener;

    invoke-virtual {v10, v11}, Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;->setControllerListener(Lcom/facebook/drawee/controller/ControllerListener;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    goto :goto_7

    .line 450
    :cond_11
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    if-eqz v10, :cond_8

    .line 451
    iget-object v10, p0, Lcom/facebook/react/views/image/ReactImageView;->mDraweeControllerBuilder:Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    iget-object v11, p0, Lcom/facebook/react/views/image/ReactImageView;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    invoke-virtual {v10, v11}, Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;->setControllerListener(Lcom/facebook/drawee/controller/ControllerListener;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    goto :goto_7
.end method

.method protected onSizeChanged(IIII)V
    .locals 1
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 471
    invoke-super {p0, p1, p2, p3, p4}, Lcom/facebook/drawee/view/GenericDraweeView;->onSizeChanged(IIII)V

    .line 472
    if-lez p1, :cond_1

    if-lez p2, :cond_1

    .line 473
    iget-boolean v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/facebook/react/views/image/ReactImageView;->hasMultipleSources()Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_0
    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 474
    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->maybeUpdateView()V

    .line 476
    :cond_1
    return-void

    .line 473
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setBlurRadius(F)V
    .locals 2
    .param p1, "blurRadius"    # F

    .prologue
    .line 232
    const/4 v0, 0x0

    cmpl-float v0, p1, v0

    if-nez v0, :cond_0

    .line 233
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIterativeBoxBlurPostProcessor:Lcom/facebook/imagepipeline/postprocessors/IterativeBoxBlurPostProcessor;

    .line 238
    :goto_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 239
    return-void

    .line 235
    :cond_0
    new-instance v0, Lcom/facebook/imagepipeline/postprocessors/IterativeBoxBlurPostProcessor;

    .line 236
    invoke-static {p1}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(F)F

    move-result v1

    float-to-int v1, v1

    invoke-direct {v0, v1}, Lcom/facebook/imagepipeline/postprocessors/IterativeBoxBlurPostProcessor;-><init>(I)V

    iput-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIterativeBoxBlurPostProcessor:Lcom/facebook/imagepipeline/postprocessors/IterativeBoxBlurPostProcessor;

    goto :goto_0
.end method

.method public setBorderColor(I)V
    .locals 1
    .param p1, "borderColor"    # I

    .prologue
    .line 242
    iput p1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderColor:I

    .line 243
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 244
    return-void
.end method

.method public setBorderRadius(F)V
    .locals 1
    .param p1, "borderRadius"    # F

    .prologue
    .line 257
    iget v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderRadius:F

    invoke-static {v0, p1}, Lcom/facebook/react/uimanager/FloatUtil;->floatsEqual(FF)Z

    move-result v0

    if-nez v0, :cond_0

    .line 258
    iput p1, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderRadius:F

    .line 259
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 261
    :cond_0
    return-void
.end method

.method public setBorderRadius(FI)V
    .locals 2
    .param p1, "borderRadius"    # F
    .param p2, "position"    # I

    .prologue
    .line 264
    iget-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    if-nez v0, :cond_0

    .line 265
    const/4 v0, 0x4

    new-array v0, v0, [F

    iput-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    .line 266
    iget-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    const/high16 v1, 0x7fc00000    # Float.NaN

    invoke-static {v0, v1}, Ljava/util/Arrays;->fill([FF)V

    .line 269
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    aget v0, v0, p2

    invoke-static {v0, p1}, Lcom/facebook/react/uimanager/FloatUtil;->floatsEqual(FF)Z

    move-result v0

    if-nez v0, :cond_1

    .line 270
    iget-object v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderCornerRadii:[F

    aput p1, v0, p2

    .line 271
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 273
    :cond_1
    return-void
.end method

.method public setBorderWidth(F)V
    .locals 1
    .param p1, "borderWidth"    # F

    .prologue
    .line 252
    invoke-static {p1}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(F)F

    move-result v0

    iput v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mBorderWidth:F

    .line 253
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 254
    return-void
.end method

.method public setControllerListener(Lcom/facebook/drawee/controller/ControllerListener;)V
    .locals 1
    .param p1, "controllerListener"    # Lcom/facebook/drawee/controller/ControllerListener;

    .prologue
    .line 464
    iput-object p1, p0, Lcom/facebook/react/views/image/ReactImageView;->mControllerForTesting:Lcom/facebook/drawee/controller/ControllerListener;

    .line 465
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 466
    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->maybeUpdateView()V

    .line 467
    return-void
.end method

.method public setFadeDuration(I)V
    .locals 0
    .param p1, "durationMs"    # I

    .prologue
    .line 329
    iput p1, p0, Lcom/facebook/react/views/image/ReactImageView;->mFadeDurationMs:I

    .line 331
    return-void
.end method

.method public setHeaders(Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 0
    .param p1, "headers"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    .line 343
    iput-object p1, p0, Lcom/facebook/react/views/image/ReactImageView;->mHeaders:Lcom/facebook/react/bridge/ReadableMap;

    .line 344
    return-void
.end method

.method public setLoadingIndicatorSource(Ljava/lang/String;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 317
    invoke-static {}, Lcom/facebook/react/views/imagehelper/ResourceDrawableIdHelper;->getInstance()Lcom/facebook/react/views/imagehelper/ResourceDrawableIdHelper;

    move-result-object v1

    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2, p1}, Lcom/facebook/react/views/imagehelper/ResourceDrawableIdHelper;->getResourceDrawable(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 318
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    new-instance v1, Lcom/facebook/drawee/drawable/AutoRotateDrawable;

    const/16 v2, 0x3e8

    invoke-direct {v1, v0, v2}, Lcom/facebook/drawee/drawable/AutoRotateDrawable;-><init>(Landroid/graphics/drawable/Drawable;I)V

    :goto_0
    iput-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mLoadingImageDrawable:Landroid/graphics/drawable/Drawable;

    .line 320
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 321
    return-void

    .line 318
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setOverlayColor(I)V
    .locals 1
    .param p1, "overlayColor"    # I

    .prologue
    .line 247
    iput p1, p0, Lcom/facebook/react/views/image/ReactImageView;->mOverlayColor:I

    .line 248
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 249
    return-void
.end method

.method public setProgressiveRenderingEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 324
    iput-boolean p1, p0, Lcom/facebook/react/views/image/ReactImageView;->mProgressiveRenderingEnabled:Z

    .line 326
    return-void
.end method

.method public setResizeMethod(Lcom/facebook/react/views/image/ImageResizeMethod;)V
    .locals 1
    .param p1, "resizeMethod"    # Lcom/facebook/react/views/image/ImageResizeMethod;

    .prologue
    .line 281
    iput-object p1, p0, Lcom/facebook/react/views/image/ReactImageView;->mResizeMethod:Lcom/facebook/react/views/image/ImageResizeMethod;

    .line 282
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 283
    return-void
.end method

.method public setScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V
    .locals 1
    .param p1, "scaleType"    # Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    .prologue
    .line 276
    iput-object p1, p0, Lcom/facebook/react/views/image/ReactImageView;->mScaleType:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    .line 277
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 278
    return-void
.end method

.method public setShouldNotifyLoadEvents(Z)V
    .locals 3
    .param p1, "shouldNotify"    # Z

    .prologue
    .line 191
    if-nez p1, :cond_0

    .line 192
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    .line 228
    :goto_0
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 229
    return-void

    .line 194
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/bridge/ReactContext;

    const-class v2, Lcom/facebook/react/uimanager/UIManagerModule;

    .line 195
    invoke-virtual {v1, v2}, Lcom/facebook/react/bridge/ReactContext;->getNativeModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-virtual {v1}, Lcom/facebook/react/uimanager/UIManagerModule;->getEventDispatcher()Lcom/facebook/react/uimanager/events/EventDispatcher;

    move-result-object v0

    .line 197
    .local v0, "mEventDispatcher":Lcom/facebook/react/uimanager/events/EventDispatcher;
    new-instance v1, Lcom/facebook/react/views/image/ReactImageView$1;

    invoke-direct {v1, p0, v0}, Lcom/facebook/react/views/image/ReactImageView$1;-><init>(Lcom/facebook/react/views/image/ReactImageView;Lcom/facebook/react/uimanager/events/EventDispatcher;)V

    iput-object v1, p0, Lcom/facebook/react/views/image/ReactImageView;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    goto :goto_0
.end method

.method public setSource(Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 10
    .param p1, "sources"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v9, 0x1

    .line 286
    iget-object v2, p0, Lcom/facebook/react/views/image/ReactImageView;->mSources:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 287
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    if-eqz v2, :cond_0

    .line 289
    invoke-interface {p1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    if-ne v2, v9, :cond_1

    .line 290
    const/4 v2, 0x0

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableArray;->getMap(I)Lcom/facebook/react/bridge/ReadableMap;

    move-result-object v8

    .line 291
    .local v8, "source":Lcom/facebook/react/bridge/ReadableMap;
    const-string v2, "uri"

    invoke-interface {v8, v2}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 292
    .local v3, "uri":Ljava/lang/String;
    new-instance v1, Lcom/facebook/react/views/imagehelper/ImageSource;

    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2, v3}, Lcom/facebook/react/views/imagehelper/ImageSource;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 293
    .local v1, "imageSource":Lcom/facebook/react/views/imagehelper/ImageSource;
    iget-object v2, p0, Lcom/facebook/react/views/image/ReactImageView;->mSources:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 294
    sget-object v2, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-virtual {v1}, Lcom/facebook/react/views/imagehelper/ImageSource;->getUri()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 295
    invoke-direct {p0, v3}, Lcom/facebook/react/views/image/ReactImageView;->warnImageSource(Ljava/lang/String;)V

    .line 313
    .end local v1    # "imageSource":Lcom/facebook/react/views/imagehelper/ImageSource;
    .end local v3    # "uri":Ljava/lang/String;
    .end local v8    # "source":Lcom/facebook/react/bridge/ReadableMap;
    :cond_0
    iput-boolean v9, p0, Lcom/facebook/react/views/image/ReactImageView;->mIsDirty:Z

    .line 314
    return-void

    .line 298
    :cond_1
    const/4 v0, 0x0

    .local v0, "idx":I
    :goto_0
    invoke-interface {p1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 299
    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableArray;->getMap(I)Lcom/facebook/react/bridge/ReadableMap;

    move-result-object v8

    .line 300
    .restart local v8    # "source":Lcom/facebook/react/bridge/ReadableMap;
    const-string v2, "uri"

    invoke-interface {v8, v2}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 301
    .restart local v3    # "uri":Ljava/lang/String;
    new-instance v1, Lcom/facebook/react/views/imagehelper/ImageSource;

    .line 302
    invoke-virtual {p0}, Lcom/facebook/react/views/image/ReactImageView;->getContext()Landroid/content/Context;

    move-result-object v2

    const-string v4, "width"

    .line 304
    invoke-interface {v8, v4}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    const-string v6, "height"

    .line 305
    invoke-interface {v8, v6}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v6

    invoke-direct/range {v1 .. v7}, Lcom/facebook/react/views/imagehelper/ImageSource;-><init>(Landroid/content/Context;Ljava/lang/String;DD)V

    .line 306
    .restart local v1    # "imageSource":Lcom/facebook/react/views/imagehelper/ImageSource;
    iget-object v2, p0, Lcom/facebook/react/views/image/ReactImageView;->mSources:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 307
    sget-object v2, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-virtual {v1}, Lcom/facebook/react/views/imagehelper/ImageSource;->getUri()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 308
    invoke-direct {p0, v3}, Lcom/facebook/react/views/image/ReactImageView;->warnImageSource(Ljava/lang/String;)V

    .line 298
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method
