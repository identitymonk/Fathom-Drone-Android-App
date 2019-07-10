.class public Landroid/support/v7/widget/AppCompatSpinner;
.super Landroid/widget/Spinner;
.source "AppCompatSpinner.java"

# interfaces
.implements Landroid/support/v4/view/TintableBackgroundView;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;,
        Landroid/support/v7/widget/AppCompatSpinner$DropDownAdapter;
    }
.end annotation


# static fields
.field private static final ATTRS_ANDROID_SPINNERMODE:[I

.field private static final IS_AT_LEAST_JB:Z

.field private static final IS_AT_LEAST_M:Z

.field private static final MAX_ITEMS_MEASURED:I = 0xf

.field private static final MODE_DIALOG:I = 0x0

.field private static final MODE_DROPDOWN:I = 0x1

.field private static final MODE_THEME:I = -0x1

.field private static final TAG:Ljava/lang/String; = "AppCompatSpinner"


# instance fields
.field private mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

.field private mDrawableManager:Landroid/support/v7/widget/AppCompatDrawableManager;

.field private mDropDownWidth:I

.field private mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

.field private mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

.field private mPopupContext:Landroid/content/Context;

.field private mPopupSet:Z

.field private mTempAdapter:Landroid/widget/SpinnerAdapter;

.field private final mTempRect:Landroid/graphics/Rect;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 66
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x17

    if-lt v0, v3, :cond_0

    move v0, v1

    :goto_0
    sput-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_M:Z

    .line 67
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x10

    if-lt v0, v3, :cond_1

    move v0, v1

    :goto_1
    sput-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_JB:Z

    .line 69
    new-array v0, v1, [I

    const v1, 0x10102f1

    aput v1, v0, v2

    sput-object v0, Landroid/support/v7/widget/AppCompatSpinner;->ATTRS_ANDROID_SPINNERMODE:[I

    return-void

    :cond_0
    move v0, v2

    .line 66
    goto :goto_0

    :cond_1
    move v0, v2

    .line 67
    goto :goto_1
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 107
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/widget/AppCompatSpinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 108
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mode"    # I

    .prologue
    .line 122
    const/4 v0, 0x0

    sget v1, Landroid/support/v7/appcompat/R$attr;->spinnerStyle:I

    invoke-direct {p0, p1, v0, v1, p2}, Landroid/support/v7/widget/AppCompatSpinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V

    .line 123
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 133
    sget v0, Landroid/support/v7/appcompat/R$attr;->spinnerStyle:I

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/widget/AppCompatSpinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 134
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .prologue
    .line 148
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, p3, v0}, Landroid/support/v7/widget/AppCompatSpinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V

    .line 149
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I
    .param p4, "mode"    # I

    .prologue
    .line 167
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move v4, p4

    invoke-direct/range {v0 .. v5}, Landroid/support/v7/widget/AppCompatSpinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;IILandroid/content/res/Resources$Theme;)V

    .line 168
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;IILandroid/content/res/Resources$Theme;)V
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I
    .param p4, "mode"    # I
    .param p5, "popupTheme"    # Landroid/content/res/Resources$Theme;

    .prologue
    .line 196
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/Spinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 98
    new-instance v9, Landroid/graphics/Rect;

    invoke-direct {v9}, Landroid/graphics/Rect;-><init>()V

    iput-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mTempRect:Landroid/graphics/Rect;

    .line 198
    sget-object v9, Landroid/support/v7/appcompat/R$styleable;->Spinner:[I

    const/4 v10, 0x0

    invoke-static {p1, p2, v9, p3, v10}, Landroid/support/v7/widget/TintTypedArray;->obtainStyledAttributes(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;

    move-result-object v1

    .line 201
    .local v1, "a":Landroid/support/v7/widget/TintTypedArray;
    invoke-static {}, Landroid/support/v7/widget/AppCompatDrawableManager;->get()Landroid/support/v7/widget/AppCompatDrawableManager;

    move-result-object v9

    iput-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mDrawableManager:Landroid/support/v7/widget/AppCompatDrawableManager;

    .line 202
    new-instance v9, Landroid/support/v7/widget/AppCompatBackgroundHelper;

    iget-object v10, p0, Landroid/support/v7/widget/AppCompatSpinner;->mDrawableManager:Landroid/support/v7/widget/AppCompatDrawableManager;

    invoke-direct {v9, p0, v10}, Landroid/support/v7/widget/AppCompatBackgroundHelper;-><init>(Landroid/view/View;Landroid/support/v7/widget/AppCompatDrawableManager;)V

    iput-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    .line 204
    if-eqz p5, :cond_5

    .line 205
    new-instance v9, Landroid/support/v7/view/ContextThemeWrapper;

    move-object/from16 v0, p5

    invoke-direct {v9, p1, v0}, Landroid/support/v7/view/ContextThemeWrapper;-><init>(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V

    iput-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopupContext:Landroid/content/Context;

    .line 217
    :goto_0
    iget-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopupContext:Landroid/content/Context;

    if-eqz v9, :cond_2

    .line 218
    const/4 v9, -0x1

    move/from16 v0, p4

    if-ne v0, v9, :cond_1

    .line 219
    sget v9, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v10, 0xb

    if-lt v9, v10, :cond_9

    .line 221
    const/4 v2, 0x0

    .line 223
    .local v2, "aa":Landroid/content/res/TypedArray;
    :try_start_0
    sget-object v9, Landroid/support/v7/widget/AppCompatSpinner;->ATTRS_ANDROID_SPINNERMODE:[I

    const/4 v10, 0x0

    invoke-virtual {p1, p2, v9, p3, v10}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v2

    .line 225
    const/4 v9, 0x0

    invoke-virtual {v2, v9}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 226
    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual {v2, v9, v10}, Landroid/content/res/TypedArray;->getInt(II)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result p4

    .line 231
    :cond_0
    if-eqz v2, :cond_1

    .line 232
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    .line 241
    .end local v2    # "aa":Landroid/content/res/TypedArray;
    :cond_1
    :goto_1
    const/4 v9, 0x1

    move/from16 v0, p4

    if-ne v0, v9, :cond_2

    .line 242
    new-instance v7, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    iget-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopupContext:Landroid/content/Context;

    invoke-direct {v7, p0, v9, p2, p3}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;-><init>(Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 243
    .local v7, "popup":Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;
    iget-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopupContext:Landroid/content/Context;

    sget-object v10, Landroid/support/v7/appcompat/R$styleable;->Spinner:[I

    const/4 v11, 0x0

    invoke-static {v9, p2, v10, p3, v11}, Landroid/support/v7/widget/TintTypedArray;->obtainStyledAttributes(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;

    move-result-object v6

    .line 245
    .local v6, "pa":Landroid/support/v7/widget/TintTypedArray;
    sget v9, Landroid/support/v7/appcompat/R$styleable;->Spinner_android_dropDownWidth:I

    const/4 v10, -0x2

    invoke-virtual {v6, v9, v10}, Landroid/support/v7/widget/TintTypedArray;->getLayoutDimension(II)I

    move-result v9

    iput v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mDropDownWidth:I

    .line 247
    sget v9, Landroid/support/v7/appcompat/R$styleable;->Spinner_android_popupBackground:I

    invoke-virtual {v6, v9}, Landroid/support/v7/widget/TintTypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 249
    sget v9, Landroid/support/v7/appcompat/R$styleable;->Spinner_android_prompt:I

    invoke-virtual {v1, v9}, Landroid/support/v7/widget/TintTypedArray;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->setPromptText(Ljava/lang/CharSequence;)V

    .line 250
    invoke-virtual {v6}, Landroid/support/v7/widget/TintTypedArray;->recycle()V

    .line 252
    iput-object v7, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    .line 253
    new-instance v9, Landroid/support/v7/widget/AppCompatSpinner$1;

    invoke-direct {v9, p0, p0, v7}, Landroid/support/v7/widget/AppCompatSpinner$1;-><init>(Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;)V

    iput-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

    .line 270
    .end local v6    # "pa":Landroid/support/v7/widget/TintTypedArray;
    .end local v7    # "popup":Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;
    :cond_2
    sget v9, Landroid/support/v7/appcompat/R$styleable;->Spinner_android_entries:I

    invoke-virtual {v1, v9}, Landroid/support/v7/widget/TintTypedArray;->getTextArray(I)[Ljava/lang/CharSequence;

    move-result-object v5

    .line 271
    .local v5, "entries":[Ljava/lang/CharSequence;
    if-eqz v5, :cond_3

    .line 272
    new-instance v3, Landroid/widget/ArrayAdapter;

    const v9, 0x1090008

    invoke-direct {v3, p1, v9, v5}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 274
    .local v3, "adapter":Landroid/widget/ArrayAdapter;, "Landroid/widget/ArrayAdapter<Ljava/lang/CharSequence;>;"
    sget v9, Landroid/support/v7/appcompat/R$layout;->support_simple_spinner_dropdown_item:I

    invoke-virtual {v3, v9}, Landroid/widget/ArrayAdapter;->setDropDownViewResource(I)V

    .line 275
    invoke-virtual {p0, v3}, Landroid/support/v7/widget/AppCompatSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 278
    .end local v3    # "adapter":Landroid/widget/ArrayAdapter;, "Landroid/widget/ArrayAdapter<Ljava/lang/CharSequence;>;"
    :cond_3
    invoke-virtual {v1}, Landroid/support/v7/widget/TintTypedArray;->recycle()V

    .line 280
    const/4 v9, 0x1

    iput-boolean v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopupSet:Z

    .line 284
    iget-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mTempAdapter:Landroid/widget/SpinnerAdapter;

    if-eqz v9, :cond_4

    .line 285
    iget-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mTempAdapter:Landroid/widget/SpinnerAdapter;

    invoke-virtual {p0, v9}, Landroid/support/v7/widget/AppCompatSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 286
    const/4 v9, 0x0

    iput-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mTempAdapter:Landroid/widget/SpinnerAdapter;

    .line 289
    :cond_4
    iget-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    invoke-virtual {v9, p2, p3}, Landroid/support/v7/widget/AppCompatBackgroundHelper;->loadFromAttributes(Landroid/util/AttributeSet;I)V

    .line 290
    return-void

    .line 207
    .end local v5    # "entries":[Ljava/lang/CharSequence;
    :cond_5
    sget v9, Landroid/support/v7/appcompat/R$styleable;->Spinner_popupTheme:I

    const/4 v10, 0x0

    invoke-virtual {v1, v9, v10}, Landroid/support/v7/widget/TintTypedArray;->getResourceId(II)I

    move-result v8

    .line 208
    .local v8, "popupThemeResId":I
    if-eqz v8, :cond_6

    .line 209
    new-instance v9, Landroid/support/v7/view/ContextThemeWrapper;

    invoke-direct {v9, p1, v8}, Landroid/support/v7/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    iput-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopupContext:Landroid/content/Context;

    goto/16 :goto_0

    .line 213
    :cond_6
    sget-boolean v9, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_M:Z

    if-nez v9, :cond_7

    move-object v9, p1

    :goto_2
    iput-object v9, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopupContext:Landroid/content/Context;

    goto/16 :goto_0

    :cond_7
    const/4 v9, 0x0

    goto :goto_2

    .line 228
    .end local v8    # "popupThemeResId":I
    .restart local v2    # "aa":Landroid/content/res/TypedArray;
    :catch_0
    move-exception v4

    .line 229
    .local v4, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v9, "AppCompatSpinner"

    const-string v10, "Could not read android:spinnerMode"

    invoke-static {v9, v10, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 231
    if-eqz v2, :cond_1

    .line 232
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    goto/16 :goto_1

    .line 231
    .end local v4    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v9

    if-eqz v2, :cond_8

    .line 232
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    :cond_8
    throw v9

    .line 237
    .end local v2    # "aa":Landroid/content/res/TypedArray;
    :cond_9
    const/16 p4, 0x1

    goto/16 :goto_1
.end method

.method static synthetic access$000(Landroid/support/v7/widget/AppCompatSpinner;)Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/AppCompatSpinner;

    .prologue
    .line 64
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    return-object v0
.end method

.method static synthetic access$100()Z
    .locals 1

    .prologue
    .line 64
    sget-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_M:Z

    return v0
.end method

.method static synthetic access$300(Landroid/support/v7/widget/AppCompatSpinner;)Landroid/graphics/Rect;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/AppCompatSpinner;

    .prologue
    .line 64
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mTempRect:Landroid/graphics/Rect;

    return-object v0
.end method

.method static synthetic access$400(Landroid/support/v7/widget/AppCompatSpinner;)I
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/AppCompatSpinner;

    .prologue
    .line 64
    iget v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mDropDownWidth:I

    return v0
.end method

.method static synthetic access$500(Landroid/support/v7/widget/AppCompatSpinner;Landroid/widget/SpinnerAdapter;Landroid/graphics/drawable/Drawable;)I
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/AppCompatSpinner;
    .param p1, "x1"    # Landroid/widget/SpinnerAdapter;
    .param p2, "x2"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 64
    invoke-direct {p0, p1, p2}, Landroid/support/v7/widget/AppCompatSpinner;->compatMeasureContentWidth(Landroid/widget/SpinnerAdapter;Landroid/graphics/drawable/Drawable;)I

    move-result v0

    return v0
.end method

.method private compatMeasureContentWidth(Landroid/widget/SpinnerAdapter;Landroid/graphics/drawable/Drawable;)I
    .locals 13
    .param p1, "adapter"    # Landroid/widget/SpinnerAdapter;
    .param p2, "background"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 536
    if-nez p1, :cond_1

    .line 537
    const/4 v8, 0x0

    .line 576
    :cond_0
    :goto_0
    return v8

    .line 540
    :cond_1
    const/4 v8, 0x0

    .line 541
    .local v8, "width":I
    const/4 v5, 0x0

    .line 542
    .local v5, "itemView":Landroid/view/View;
    const/4 v4, 0x0

    .line 543
    .local v4, "itemType":I
    invoke-virtual {p0}, Landroid/support/v7/widget/AppCompatSpinner;->getMeasuredWidth()I

    move-result v10

    const/4 v11, 0x0

    invoke-static {v10, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v9

    .line 545
    .local v9, "widthMeasureSpec":I
    invoke-virtual {p0}, Landroid/support/v7/widget/AppCompatSpinner;->getMeasuredHeight()I

    move-result v10

    const/4 v11, 0x0

    invoke-static {v10, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    .line 550
    .local v2, "heightMeasureSpec":I
    const/4 v10, 0x0

    invoke-virtual {p0}, Landroid/support/v7/widget/AppCompatSpinner;->getSelectedItemPosition()I

    move-result v11

    invoke-static {v10, v11}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 551
    .local v7, "start":I
    invoke-interface {p1}, Landroid/widget/SpinnerAdapter;->getCount()I

    move-result v10

    add-int/lit8 v11, v7, 0xf

    invoke-static {v10, v11}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 552
    .local v1, "end":I
    sub-int v0, v1, v7

    .line 553
    .local v0, "count":I
    const/4 v10, 0x0

    rsub-int/lit8 v11, v0, 0xf

    sub-int v11, v7, v11

    invoke-static {v10, v11}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 554
    move v3, v7

    .local v3, "i":I
    :goto_1
    if-ge v3, v1, :cond_4

    .line 555
    invoke-interface {p1, v3}, Landroid/widget/SpinnerAdapter;->getItemViewType(I)I

    move-result v6

    .line 556
    .local v6, "positionType":I
    if-eq v6, v4, :cond_2

    .line 557
    move v4, v6

    .line 558
    const/4 v5, 0x0

    .line 560
    :cond_2
    invoke-interface {p1, v3, v5, p0}, Landroid/widget/SpinnerAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    .line 561
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    if-nez v10, :cond_3

    .line 562
    new-instance v10, Landroid/view/ViewGroup$LayoutParams;

    const/4 v11, -0x2

    const/4 v12, -0x2

    invoke-direct {v10, v11, v12}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v5, v10}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 566
    :cond_3
    invoke-virtual {v5, v9, v2}, Landroid/view/View;->measure(II)V

    .line 567
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredWidth()I

    move-result v10

    invoke-static {v8, v10}, Ljava/lang/Math;->max(II)I

    move-result v8

    .line 554
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 571
    .end local v6    # "positionType":I
    :cond_4
    if-eqz p2, :cond_0

    .line 572
    iget-object v10, p0, Landroid/support/v7/widget/AppCompatSpinner;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {p2, v10}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 573
    iget-object v10, p0, Landroid/support/v7/widget/AppCompatSpinner;->mTempRect:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->left:I

    iget-object v11, p0, Landroid/support/v7/widget/AppCompatSpinner;->mTempRect:Landroid/graphics/Rect;

    iget v11, v11, Landroid/graphics/Rect;->right:I

    add-int/2addr v10, v11

    add-int/2addr v8, v10

    goto :goto_0
.end method


# virtual methods
.method protected drawableStateChanged()V
    .locals 1

    .prologue
    .line 529
    invoke-super {p0}, Landroid/widget/Spinner;->drawableStateChanged()V

    .line 530
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    if-eqz v0, :cond_0

    .line 531
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    invoke-virtual {v0}, Landroid/support/v7/widget/AppCompatBackgroundHelper;->applySupportBackgroundTint()V

    .line 533
    :cond_0
    return-void
.end method

.method public getDropDownHorizontalOffset()I
    .locals 1

    .prologue
    .line 357
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_0

    .line 358
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->getHorizontalOffset()I

    move-result v0

    .line 362
    :goto_0
    return v0

    .line 359
    :cond_0
    sget-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_JB:Z

    if-eqz v0, :cond_1

    .line 360
    invoke-super {p0}, Landroid/widget/Spinner;->getDropDownHorizontalOffset()I

    move-result v0

    goto :goto_0

    .line 362
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getDropDownVerticalOffset()I
    .locals 1

    .prologue
    .line 334
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_0

    .line 335
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->getVerticalOffset()I

    move-result v0

    .line 339
    :goto_0
    return v0

    .line 336
    :cond_0
    sget-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_JB:Z

    if-eqz v0, :cond_1

    .line 337
    invoke-super {p0}, Landroid/widget/Spinner;->getDropDownVerticalOffset()I

    move-result v0

    goto :goto_0

    .line 339
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getDropDownWidth()I
    .locals 1

    .prologue
    .line 374
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_0

    .line 375
    iget v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mDropDownWidth:I

    .line 379
    :goto_0
    return v0

    .line 376
    :cond_0
    sget-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_JB:Z

    if-eqz v0, :cond_1

    .line 377
    invoke-super {p0}, Landroid/widget/Spinner;->getDropDownWidth()I

    move-result v0

    goto :goto_0

    .line 379
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPopupBackground()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_0

    .line 318
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 322
    :goto_0
    return-object v0

    .line 319
    :cond_0
    sget-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_JB:Z

    if-eqz v0, :cond_1

    .line 320
    invoke-super {p0}, Landroid/widget/Spinner;->getPopupBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    .line 322
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPopupContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 296
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_0

    .line 297
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopupContext:Landroid/content/Context;

    .line 301
    :goto_0
    return-object v0

    .line 298
    :cond_0
    sget-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_M:Z

    if-eqz v0, :cond_1

    .line 299
    invoke-super {p0}, Landroid/widget/Spinner;->getPopupContext()Landroid/content/Context;

    move-result-object v0

    goto :goto_0

    .line 301
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPrompt()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 454
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->getHintText()Ljava/lang/CharSequence;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0}, Landroid/widget/Spinner;->getPrompt()Ljava/lang/CharSequence;

    move-result-object v0

    goto :goto_0
.end method

.method public getSupportBackgroundTintList()Landroid/content/res/ColorStateList;
    .locals 1
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation

    .prologue
    .line 496
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    invoke-virtual {v0}, Landroid/support/v7/widget/AppCompatBackgroundHelper;->getSupportBackgroundTintList()Landroid/content/res/ColorStateList;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSupportBackgroundTintMode()Landroid/graphics/PorterDuff$Mode;
    .locals 1
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation

    .prologue
    .line 523
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    invoke-virtual {v0}, Landroid/support/v7/widget/AppCompatBackgroundHelper;->getSupportBackgroundTintMode()Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 401
    invoke-super {p0}, Landroid/widget/Spinner;->onDetachedFromWindow()V

    .line 403
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 404
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->dismiss()V

    .line 406
    :cond_0
    return-void
.end method

.method protected onMeasure(II)V
    .locals 3
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 418
    invoke-super {p0, p1, p2}, Landroid/widget/Spinner;->onMeasure(II)V

    .line 420
    iget-object v1, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v1, :cond_0

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    const/high16 v2, -0x80000000

    if-ne v1, v2, :cond_0

    .line 421
    invoke-virtual {p0}, Landroid/support/v7/widget/AppCompatSpinner;->getMeasuredWidth()I

    move-result v0

    .line 422
    .local v0, "measuredWidth":I
    invoke-virtual {p0}, Landroid/support/v7/widget/AppCompatSpinner;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v1

    invoke-virtual {p0}, Landroid/support/v7/widget/AppCompatSpinner;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Landroid/support/v7/widget/AppCompatSpinner;->compatMeasureContentWidth(Landroid/widget/SpinnerAdapter;Landroid/graphics/drawable/Drawable;)I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v1

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v1

    invoke-virtual {p0}, Landroid/support/v7/widget/AppCompatSpinner;->getMeasuredHeight()I

    move-result v2

    invoke-virtual {p0, v1, v2}, Landroid/support/v7/widget/AppCompatSpinner;->setMeasuredDimension(II)V

    .line 427
    .end local v0    # "measuredWidth":I
    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 410
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

    invoke-virtual {v0, p0, p1}, Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 411
    const/4 v0, 0x1

    .line 413
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/Spinner;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public performClick()Z
    .locals 1

    .prologue
    .line 431
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_1

    .line 433
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->isShowing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 434
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->show()V

    .line 436
    :cond_0
    const/4 v0, 0x1

    .line 440
    :goto_0
    return v0

    :cond_1
    invoke-super {p0}, Landroid/widget/Spinner;->performClick()Z

    move-result v0

    goto :goto_0
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0

    .prologue
    .line 64
    check-cast p1, Landroid/widget/SpinnerAdapter;

    invoke-virtual {p0, p1}, Landroid/support/v7/widget/AppCompatSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/SpinnerAdapter;)V
    .locals 4
    .param p1, "adapter"    # Landroid/widget/SpinnerAdapter;

    .prologue
    .line 386
    iget-boolean v1, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopupSet:Z

    if-nez v1, :cond_1

    .line 387
    iput-object p1, p0, Landroid/support/v7/widget/AppCompatSpinner;->mTempAdapter:Landroid/widget/SpinnerAdapter;

    .line 397
    :cond_0
    :goto_0
    return-void

    .line 391
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 393
    iget-object v1, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v1, :cond_0

    .line 394
    iget-object v1, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopupContext:Landroid/content/Context;

    if-nez v1, :cond_2

    invoke-virtual {p0}, Landroid/support/v7/widget/AppCompatSpinner;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 395
    .local v0, "popupContext":Landroid/content/Context;
    :goto_1
    iget-object v1, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    new-instance v2, Landroid/support/v7/widget/AppCompatSpinner$DropDownAdapter;

    invoke-virtual {v0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v3

    invoke-direct {v2, p1, v3}, Landroid/support/v7/widget/AppCompatSpinner$DropDownAdapter;-><init>(Landroid/widget/SpinnerAdapter;Landroid/content/res/Resources$Theme;)V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->setAdapter(Landroid/widget/ListAdapter;)V

    goto :goto_0

    .line 394
    .end local v0    # "popupContext":Landroid/content/Context;
    :cond_2
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopupContext:Landroid/content/Context;

    goto :goto_1
.end method

.method public setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 467
    invoke-super {p0, p1}, Landroid/widget/Spinner;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 468
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    if-eqz v0, :cond_0

    .line 469
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/AppCompatBackgroundHelper;->onSetBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 471
    :cond_0
    return-void
.end method

.method public setBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I
        .annotation build Landroid/support/annotation/DrawableRes;
        .end annotation
    .end param

    .prologue
    .line 459
    invoke-super {p0, p1}, Landroid/widget/Spinner;->setBackgroundResource(I)V

    .line 460
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    if-eqz v0, :cond_0

    .line 461
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/AppCompatBackgroundHelper;->onSetBackgroundResource(I)V

    .line 463
    :cond_0
    return-void
.end method

.method public setDropDownHorizontalOffset(I)V
    .locals 1
    .param p1, "pixels"    # I

    .prologue
    .line 343
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_1

    .line 344
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->setHorizontalOffset(I)V

    .line 348
    :cond_0
    :goto_0
    return-void

    .line 345
    :cond_1
    sget-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_JB:Z

    if-eqz v0, :cond_0

    .line 346
    invoke-super {p0, p1}, Landroid/widget/Spinner;->setDropDownHorizontalOffset(I)V

    goto :goto_0
.end method

.method public setDropDownVerticalOffset(I)V
    .locals 1
    .param p1, "pixels"    # I

    .prologue
    .line 326
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_1

    .line 327
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->setVerticalOffset(I)V

    .line 331
    :cond_0
    :goto_0
    return-void

    .line 328
    :cond_1
    sget-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_JB:Z

    if-eqz v0, :cond_0

    .line 329
    invoke-super {p0, p1}, Landroid/widget/Spinner;->setDropDownVerticalOffset(I)V

    goto :goto_0
.end method

.method public setDropDownWidth(I)V
    .locals 1
    .param p1, "pixels"    # I

    .prologue
    .line 366
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_1

    .line 367
    iput p1, p0, Landroid/support/v7/widget/AppCompatSpinner;->mDropDownWidth:I

    .line 371
    :cond_0
    :goto_0
    return-void

    .line 368
    :cond_1
    sget-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_JB:Z

    if-eqz v0, :cond_0

    .line 369
    invoke-super {p0, p1}, Landroid/widget/Spinner;->setDropDownWidth(I)V

    goto :goto_0
.end method

.method public setPopupBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 305
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_1

    .line 306
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 310
    :cond_0
    :goto_0
    return-void

    .line 307
    :cond_1
    sget-boolean v0, Landroid/support/v7/widget/AppCompatSpinner;->IS_AT_LEAST_JB:Z

    if-eqz v0, :cond_0

    .line 308
    invoke-super {p0, p1}, Landroid/widget/Spinner;->setPopupBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public setPopupBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I
        .annotation build Landroid/support/annotation/DrawableRes;
        .end annotation
    .end param

    .prologue
    .line 313
    invoke-virtual {p0}, Landroid/support/v7/widget/AppCompatSpinner;->getPopupContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Landroid/support/v4/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/AppCompatSpinner;->setPopupBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 314
    return-void
.end method

.method public setPrompt(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "prompt"    # Ljava/lang/CharSequence;

    .prologue
    .line 445
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    if-eqz v0, :cond_0

    .line 446
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mPopup:Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;->setPromptText(Ljava/lang/CharSequence;)V

    .line 450
    :goto_0
    return-void

    .line 448
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/Spinner;->setPrompt(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public setSupportBackgroundTintList(Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p1, "tint"    # Landroid/content/res/ColorStateList;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 482
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    if-eqz v0, :cond_0

    .line 483
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/AppCompatBackgroundHelper;->setSupportBackgroundTintList(Landroid/content/res/ColorStateList;)V

    .line 485
    :cond_0
    return-void
.end method

.method public setSupportBackgroundTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 509
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    if-eqz v0, :cond_0

    .line 510
    iget-object v0, p0, Landroid/support/v7/widget/AppCompatSpinner;->mBackgroundTintHelper:Landroid/support/v7/widget/AppCompatBackgroundHelper;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/AppCompatBackgroundHelper;->setSupportBackgroundTintMode(Landroid/graphics/PorterDuff$Mode;)V

    .line 512
    :cond_0
    return-void
.end method
