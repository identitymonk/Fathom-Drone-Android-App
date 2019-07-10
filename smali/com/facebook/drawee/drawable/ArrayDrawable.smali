.class public Lcom/facebook/drawee/drawable/ArrayDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "ArrayDrawable.java"

# interfaces
.implements Landroid/graphics/drawable/Drawable$Callback;
.implements Lcom/facebook/drawee/drawable/TransformCallback;
.implements Lcom/facebook/drawee/drawable/TransformAwareDrawable;


# instance fields
.field private final mDrawableParents:[Lcom/facebook/drawee/drawable/DrawableParent;

.field private final mDrawableProperties:Lcom/facebook/drawee/drawable/DrawableProperties;

.field private mIsMutated:Z

.field private mIsStateful:Z

.field private mIsStatefulCalculated:Z

.field private final mLayers:[Landroid/graphics/drawable/Drawable;

.field private final mTmpRect:Landroid/graphics/Rect;

.field private mTransformCallback:Lcom/facebook/drawee/drawable/TransformCallback;


# direct methods
.method public constructor <init>([Landroid/graphics/drawable/Drawable;)V
    .locals 3
    .param p1, "layers"    # [Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v2, 0x0

    .line 57
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 37
    new-instance v1, Lcom/facebook/drawee/drawable/DrawableProperties;

    invoke-direct {v1}, Lcom/facebook/drawee/drawable/DrawableProperties;-><init>()V

    iput-object v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mDrawableProperties:Lcom/facebook/drawee/drawable/DrawableProperties;

    .line 45
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    iput-object v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mTmpRect:Landroid/graphics/Rect;

    .line 48
    iput-boolean v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsStateful:Z

    .line 49
    iput-boolean v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsStatefulCalculated:Z

    .line 51
    iput-boolean v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsMutated:Z

    .line 58
    invoke-static {p1}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    iput-object p1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    .line 60
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 61
    iget-object v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v1, v1, v0

    invoke-static {v1, p0, p0}, Lcom/facebook/drawee/drawable/DrawableUtils;->setCallbacks(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;Lcom/facebook/drawee/drawable/TransformCallback;)V

    .line 60
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 63
    :cond_0
    iget-object v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v1, v1

    new-array v1, v1, [Lcom/facebook/drawee/drawable/DrawableParent;

    iput-object v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mDrawableParents:[Lcom/facebook/drawee/drawable/DrawableParent;

    .line 64
    return-void
.end method

.method private createDrawableParentForIndex(I)Lcom/facebook/drawee/drawable/DrawableParent;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 307
    new-instance v0, Lcom/facebook/drawee/drawable/ArrayDrawable$1;

    invoke-direct {v0, p0, p1}, Lcom/facebook/drawee/drawable/ArrayDrawable$1;-><init>(Lcom/facebook/drawee/drawable/ArrayDrawable;I)V

    return-object v0
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 183
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 184
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v2, v1

    .line 185
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 186
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 183
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 189
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    return-void
.end method

.method public getDrawable(I)Landroid/graphics/drawable/Drawable;
    .locals 3
    .param p1, "index"    # I
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 81
    if-ltz p1, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 82
    iget-object v0, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v0, v0

    if-ge p1, v0, :cond_1

    :goto_1
    invoke-static {v1}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 83
    iget-object v0, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v0, p1

    return-object v0

    :cond_0
    move v0, v2

    .line 81
    goto :goto_0

    :cond_1
    move v1, v2

    .line 82
    goto :goto_1
.end method

.method public getDrawableParentForIndex(I)Lcom/facebook/drawee/drawable/DrawableParent;
    .locals 3
    .param p1, "index"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 298
    if-ltz p1, :cond_1

    move v0, v1

    :goto_0
    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 299
    iget-object v0, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mDrawableParents:[Lcom/facebook/drawee/drawable/DrawableParent;

    array-length v0, v0

    if-ge p1, v0, :cond_2

    :goto_1
    invoke-static {v1}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 300
    iget-object v0, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mDrawableParents:[Lcom/facebook/drawee/drawable/DrawableParent;

    aget-object v0, v0, p1

    if-nez v0, :cond_0

    .line 301
    iget-object v0, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mDrawableParents:[Lcom/facebook/drawee/drawable/DrawableParent;

    invoke-direct {p0, p1}, Lcom/facebook/drawee/drawable/ArrayDrawable;->createDrawableParentForIndex(I)Lcom/facebook/drawee/drawable/DrawableParent;

    move-result-object v1

    aput-object v1, v0, p1

    .line 303
    :cond_0
    iget-object v0, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mDrawableParents:[Lcom/facebook/drawee/drawable/DrawableParent;

    aget-object v0, v0, p1

    return-object v0

    :cond_1
    move v0, v2

    .line 298
    goto :goto_0

    :cond_2
    move v1, v2

    .line 299
    goto :goto_1
.end method

.method public getIntrinsicHeight()I
    .locals 4

    .prologue
    .line 124
    const/4 v1, -0x1

    .line 125
    .local v1, "height":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v3, v3

    if-ge v2, v3, :cond_1

    .line 126
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v3, v2

    .line 127
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 128
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v3

    invoke-static {v1, v3}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 125
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 131
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    if-lez v1, :cond_2

    .end local v1    # "height":I
    :goto_1
    return v1

    .restart local v1    # "height":I
    :cond_2
    const/4 v1, -0x1

    goto :goto_1
.end method

.method public getIntrinsicWidth()I
    .locals 4

    .prologue
    .line 112
    const/4 v2, -0x1

    .line 113
    .local v2, "width":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v3, v3

    if-ge v1, v3, :cond_1

    .line 114
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v3, v1

    .line 115
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 116
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 113
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 119
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    if-lez v2, :cond_2

    .end local v2    # "width":I
    :goto_1
    return v2

    .restart local v2    # "width":I
    :cond_2
    const/4 v2, -0x1

    goto :goto_1
.end method

.method public getNumberOfLayers()I
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v0, v0

    return v0
.end method

.method public getOpacity()I
    .locals 4

    .prologue
    .line 225
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v3, v3

    if-nez v3, :cond_1

    .line 226
    const/4 v2, -0x2

    .line 235
    :cond_0
    return v2

    .line 228
    :cond_1
    const/4 v2, -0x1

    .line 229
    .local v2, "opacity":I
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v3, v3

    if-ge v1, v3, :cond_0

    .line 230
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v3, v1

    .line 231
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_2

    .line 232
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v3

    invoke-static {v2, v3}, Landroid/graphics/drawable/Drawable;->resolveOpacity(II)I

    move-result v2

    .line 229
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public getPadding(Landroid/graphics/Rect;)Z
    .locals 5
    .param p1, "padding"    # Landroid/graphics/Rect;

    .prologue
    const/4 v3, 0x0

    .line 193
    iput v3, p1, Landroid/graphics/Rect;->left:I

    .line 194
    iput v3, p1, Landroid/graphics/Rect;->top:I

    .line 195
    iput v3, p1, Landroid/graphics/Rect;->right:I

    .line 196
    iput v3, p1, Landroid/graphics/Rect;->bottom:I

    .line 197
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mTmpRect:Landroid/graphics/Rect;

    .line 198
    .local v2, "rect":Landroid/graphics/Rect;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v3, v3

    if-ge v1, v3, :cond_1

    .line 199
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v3, v1

    .line 200
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 201
    invoke-virtual {v0, v2}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 202
    iget v3, p1, Landroid/graphics/Rect;->left:I

    iget v4, v2, Landroid/graphics/Rect;->left:I

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    iput v3, p1, Landroid/graphics/Rect;->left:I

    .line 203
    iget v3, p1, Landroid/graphics/Rect;->top:I

    iget v4, v2, Landroid/graphics/Rect;->top:I

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    iput v3, p1, Landroid/graphics/Rect;->top:I

    .line 204
    iget v3, p1, Landroid/graphics/Rect;->right:I

    iget v4, v2, Landroid/graphics/Rect;->right:I

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    iput v3, p1, Landroid/graphics/Rect;->right:I

    .line 205
    iget v3, p1, Landroid/graphics/Rect;->bottom:I

    iget v4, v2, Landroid/graphics/Rect;->bottom:I

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    iput v3, p1, Landroid/graphics/Rect;->bottom:I

    .line 198
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 208
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    const/4 v3, 0x1

    return v3
.end method

.method public getRootBounds(Landroid/graphics/RectF;)V
    .locals 1
    .param p1, "bounds"    # Landroid/graphics/RectF;

    .prologue
    .line 362
    iget-object v0, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mTransformCallback:Lcom/facebook/drawee/drawable/TransformCallback;

    if-eqz v0, :cond_0

    .line 363
    iget-object v0, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mTransformCallback:Lcom/facebook/drawee/drawable/TransformCallback;

    invoke-interface {v0, p1}, Lcom/facebook/drawee/drawable/TransformCallback;->getRootBounds(Landroid/graphics/RectF;)V

    .line 367
    :goto_0
    return-void

    .line 365
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/drawee/drawable/ArrayDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/graphics/RectF;->set(Landroid/graphics/Rect;)V

    goto :goto_0
.end method

.method public getTransform(Landroid/graphics/Matrix;)V
    .locals 1
    .param p1, "transform"    # Landroid/graphics/Matrix;

    .prologue
    .line 353
    iget-object v0, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mTransformCallback:Lcom/facebook/drawee/drawable/TransformCallback;

    if-eqz v0, :cond_0

    .line 354
    iget-object v0, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mTransformCallback:Lcom/facebook/drawee/drawable/TransformCallback;

    invoke-interface {v0, p1}, Lcom/facebook/drawee/drawable/TransformCallback;->getTransform(Landroid/graphics/Matrix;)V

    .line 358
    :goto_0
    return-void

    .line 356
    :cond_0
    invoke-virtual {p1}, Landroid/graphics/Matrix;->reset()V

    goto :goto_0
.end method

.method public invalidateDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "who"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 326
    invoke-virtual {p0}, Lcom/facebook/drawee/drawable/ArrayDrawable;->invalidateSelf()V

    .line 327
    return-void
.end method

.method public isStateful()Z
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 146
    iget-boolean v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsStatefulCalculated:Z

    if-nez v2, :cond_2

    .line 147
    iput-boolean v4, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsStateful:Z

    .line 148
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 149
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v2, v1

    .line 150
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    iget-boolean v5, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsStateful:Z

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v2

    if-eqz v2, :cond_0

    move v2, v3

    :goto_1
    or-int/2addr v2, v5

    iput-boolean v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsStateful:Z

    .line 148
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    move v2, v4

    .line 150
    goto :goto_1

    .line 152
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    iput-boolean v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsStatefulCalculated:Z

    .line 154
    .end local v1    # "i":I
    :cond_2
    iget-boolean v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsStateful:Z

    return v2
.end method

.method public mutate()Landroid/graphics/drawable/Drawable;
    .locals 3

    .prologue
    .line 213
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 214
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v2, v1

    .line 215
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 216
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    .line 213
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 219
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsMutated:Z

    .line 220
    return-object p0
.end method

.method protected onBoundsChange(Landroid/graphics/Rect;)V
    .locals 3
    .param p1, "bounds"    # Landroid/graphics/Rect;

    .prologue
    .line 136
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 137
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v2, v1

    .line 138
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 139
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 136
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 142
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    return-void
.end method

.method protected onLevelChange(I)Z
    .locals 4
    .param p1, "level"    # I

    .prologue
    .line 171
    const/4 v2, 0x0

    .line 172
    .local v2, "levelChanged":Z
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v3, v3

    if-ge v1, v3, :cond_1

    .line 173
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v3, v1

    .line 174
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setLevel(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 175
    const/4 v2, 0x1

    .line 172
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 178
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    return v2
.end method

.method protected onStateChange([I)Z
    .locals 4
    .param p1, "state"    # [I

    .prologue
    .line 159
    const/4 v2, 0x0

    .line 160
    .local v2, "stateChanged":Z
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v3, v3

    if-ge v1, v3, :cond_1

    .line 161
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v3, v1

    .line 162
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 163
    const/4 v2, 0x1

    .line 160
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 166
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    return v2
.end method

.method public scheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V
    .locals 1
    .param p1, "who"    # Landroid/graphics/drawable/Drawable;
    .param p2, "what"    # Ljava/lang/Runnable;
    .param p3, "when"    # J

    .prologue
    .line 331
    invoke-virtual {p0, p2, p3, p4}, Lcom/facebook/drawee/drawable/ArrayDrawable;->scheduleSelf(Ljava/lang/Runnable;J)V

    .line 332
    return-void
.end method

.method public setAlpha(I)V
    .locals 3
    .param p1, "alpha"    # I

    .prologue
    .line 240
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mDrawableProperties:Lcom/facebook/drawee/drawable/DrawableProperties;

    invoke-virtual {v2, p1}, Lcom/facebook/drawee/drawable/DrawableProperties;->setAlpha(I)V

    .line 241
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 242
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v2, v1

    .line 243
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 244
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 241
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 247
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 3
    .param p1, "colorFilter"    # Landroid/graphics/ColorFilter;

    .prologue
    .line 251
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mDrawableProperties:Lcom/facebook/drawee/drawable/DrawableProperties;

    invoke-virtual {v2, p1}, Lcom/facebook/drawee/drawable/DrawableProperties;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 252
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 253
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v2, v1

    .line 254
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 255
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 252
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 258
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    return-void
.end method

.method public setDither(Z)V
    .locals 3
    .param p1, "dither"    # Z

    .prologue
    .line 262
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mDrawableProperties:Lcom/facebook/drawee/drawable/DrawableProperties;

    invoke-virtual {v2, p1}, Lcom/facebook/drawee/drawable/DrawableProperties;->setDither(Z)V

    .line 263
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 264
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v2, v1

    .line 265
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 266
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setDither(Z)V

    .line 263
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 269
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    return-void
.end method

.method public setDrawable(ILandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    .locals 5
    .param p1, "index"    # I
    .param p2, "drawable"    # Landroid/graphics/drawable/Drawable;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 89
    if-ltz p1, :cond_2

    move v1, v2

    :goto_0
    invoke-static {v1}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 90
    iget-object v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v1, v1

    if-ge p1, v1, :cond_3

    :goto_1
    invoke-static {v2}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 91
    iget-object v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v1, p1

    .line 92
    .local v0, "oldDrawable":Landroid/graphics/drawable/Drawable;
    if-eq p2, v0, :cond_1

    .line 93
    if-eqz p2, :cond_0

    iget-boolean v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsMutated:Z

    if-eqz v1, :cond_0

    .line 94
    invoke-virtual {p2}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    .line 97
    :cond_0
    iget-object v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v1, v1, p1

    invoke-static {v1, v4, v4}, Lcom/facebook/drawee/drawable/DrawableUtils;->setCallbacks(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;Lcom/facebook/drawee/drawable/TransformCallback;)V

    .line 98
    invoke-static {p2, v4, v4}, Lcom/facebook/drawee/drawable/DrawableUtils;->setCallbacks(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;Lcom/facebook/drawee/drawable/TransformCallback;)V

    .line 99
    iget-object v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mDrawableProperties:Lcom/facebook/drawee/drawable/DrawableProperties;

    invoke-static {p2, v1}, Lcom/facebook/drawee/drawable/DrawableUtils;->setDrawableProperties(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/DrawableProperties;)V

    .line 100
    invoke-static {p2, p0}, Lcom/facebook/drawee/drawable/DrawableUtils;->copyProperties(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 101
    invoke-static {p2, p0, p0}, Lcom/facebook/drawee/drawable/DrawableUtils;->setCallbacks(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;Lcom/facebook/drawee/drawable/TransformCallback;)V

    .line 102
    iput-boolean v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mIsStatefulCalculated:Z

    .line 103
    iget-object v1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aput-object p2, v1, p1

    .line 104
    invoke-virtual {p0}, Lcom/facebook/drawee/drawable/ArrayDrawable;->invalidateSelf()V

    .line 106
    :cond_1
    return-object v0

    .end local v0    # "oldDrawable":Landroid/graphics/drawable/Drawable;
    :cond_2
    move v1, v3

    .line 89
    goto :goto_0

    :cond_3
    move v2, v3

    .line 90
    goto :goto_1
.end method

.method public setFilterBitmap(Z)V
    .locals 3
    .param p1, "filterBitmap"    # Z

    .prologue
    .line 273
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mDrawableProperties:Lcom/facebook/drawee/drawable/DrawableProperties;

    invoke-virtual {v2, p1}, Lcom/facebook/drawee/drawable/DrawableProperties;->setFilterBitmap(Z)V

    .line 274
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 275
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v2, v1

    .line 276
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 277
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setFilterBitmap(Z)V

    .line 274
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 280
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    return-void
.end method

.method public setHotspot(FF)V
    .locals 3
    .param p1, "x"    # F
    .param p2, "y"    # F
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    .line 372
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 373
    iget-object v2, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v2, v1

    .line 374
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 375
    invoke-virtual {v0, p1, p2}, Landroid/graphics/drawable/Drawable;->setHotspot(FF)V

    .line 372
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 378
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    return-void
.end method

.method public setTransformCallback(Lcom/facebook/drawee/drawable/TransformCallback;)V
    .locals 0
    .param p1, "transformCallback"    # Lcom/facebook/drawee/drawable/TransformCallback;

    .prologue
    .line 344
    iput-object p1, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mTransformCallback:Lcom/facebook/drawee/drawable/TransformCallback;

    .line 345
    return-void
.end method

.method public setVisible(ZZ)Z
    .locals 4
    .param p1, "visible"    # Z
    .param p2, "restart"    # Z

    .prologue
    .line 284
    invoke-super {p0, p1, p2}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    move-result v0

    .line 285
    .local v0, "changed":Z
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    array-length v3, v3

    if-ge v2, v3, :cond_1

    .line 286
    iget-object v3, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;->mLayers:[Landroid/graphics/drawable/Drawable;

    aget-object v1, v3, v2

    .line 287
    .local v1, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v1, :cond_0

    .line 288
    invoke-virtual {v1, p1, p2}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    .line 285
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 291
    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    return v0
.end method

.method public unscheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "who"    # Landroid/graphics/drawable/Drawable;
    .param p2, "what"    # Ljava/lang/Runnable;

    .prologue
    .line 336
    invoke-virtual {p0, p2}, Lcom/facebook/drawee/drawable/ArrayDrawable;->unscheduleSelf(Ljava/lang/Runnable;)V

    .line 337
    return-void
.end method
