.class public Lcom/facebook/react/views/view/ReactDrawableHelper;
.super Ljava/lang/Object;
.source "ReactDrawableHelper.java"


# static fields
.field private static final sResolveOutValue:Landroid/util/TypedValue;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    sput-object v0, Lcom/facebook/react/views/view/ReactDrawableHelper;->sResolveOutValue:Landroid/util/TypedValue;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createDrawableFromJSDescription(Landroid/content/Context;Lcom/facebook/react/bridge/ReadableMap;)Landroid/graphics/drawable/Drawable;
    .locals 13
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "drawableDescriptionDict"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    const/16 v12, 0x15

    const/4 v11, 0x0

    const/4 v10, 0x1

    .line 37
    const-string v7, "type"

    invoke-interface {p1, v7}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 38
    .local v5, "type":Ljava/lang/String;
    const-string v7, "ThemeAttrAndroid"

    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 39
    const-string v7, "attribute"

    invoke-interface {p1, v7}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 40
    .local v0, "attr":Ljava/lang/String;
    invoke-static {v0}, Lcom/facebook/react/bridge/SoftAssertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const-string v8, "attr"

    const-string v9, "android"

    invoke-virtual {v7, v0, v8, v9}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 42
    .local v1, "attrID":I
    if-nez v1, :cond_0

    .line 43
    new-instance v7, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Attribute "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " couldn\'t be found in the resource list"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 46
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v7

    sget-object v8, Lcom/facebook/react/views/view/ReactDrawableHelper;->sResolveOutValue:Landroid/util/TypedValue;

    invoke-virtual {v7, v1, v8, v10}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 47
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 48
    .local v6, "version":I
    if-lt v6, v12, :cond_1

    .line 49
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget-object v8, Lcom/facebook/react/views/view/ReactDrawableHelper;->sResolveOutValue:Landroid/util/TypedValue;

    iget v8, v8, Landroid/util/TypedValue;->resourceId:I

    .line 50
    invoke-virtual {p0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Landroid/content/res/Resources;->getDrawable(ILandroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    .line 87
    .end local v0    # "attr":Ljava/lang/String;
    .end local v1    # "attrID":I
    .end local v6    # "version":I
    :goto_0
    return-object v7

    .line 52
    .restart local v0    # "attr":Ljava/lang/String;
    .restart local v1    # "attrID":I
    .restart local v6    # "version":I
    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget-object v8, Lcom/facebook/react/views/view/ReactDrawableHelper;->sResolveOutValue:Landroid/util/TypedValue;

    iget v8, v8, Landroid/util/TypedValue;->resourceId:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    goto :goto_0

    .line 55
    .end local v6    # "version":I
    :cond_2
    new-instance v7, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Attribute "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " couldn\'t be resolved into a drawable"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 58
    .end local v0    # "attr":Ljava/lang/String;
    .end local v1    # "attrID":I
    :cond_3
    const-string v7, "RippleAndroid"

    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_9

    .line 59
    sget v7, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge v7, v12, :cond_4

    .line 60
    new-instance v7, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    const-string v8, "Ripple drawable is not available on android API <21"

    invoke-direct {v7, v8}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 64
    :cond_4
    const-string v7, "color"

    invoke-interface {p1, v7}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_7

    const-string v7, "color"

    .line 65
    invoke-interface {p1, v7}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_7

    .line 66
    const-string v7, "color"

    invoke-interface {p1, v7}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 78
    .local v2, "color":I
    :goto_1
    const/4 v4, 0x0

    .line 79
    .local v4, "mask":Landroid/graphics/drawable/Drawable;
    const-string v7, "borderless"

    invoke-interface {p1, v7}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_5

    const-string v7, "borderless"

    .line 80
    invoke-interface {p1, v7}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_5

    const-string v7, "borderless"

    .line 81
    invoke-interface {p1, v7}, Lcom/facebook/react/bridge/ReadableMap;->getBoolean(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_6

    .line 82
    :cond_5
    new-instance v4, Landroid/graphics/drawable/ColorDrawable;

    .end local v4    # "mask":Landroid/graphics/drawable/Drawable;
    const/4 v7, -0x1

    invoke-direct {v4, v7}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 84
    .restart local v4    # "mask":Landroid/graphics/drawable/Drawable;
    :cond_6
    new-instance v3, Landroid/content/res/ColorStateList;

    new-array v7, v10, [[I

    new-array v8, v11, [I

    aput-object v8, v7, v11

    new-array v8, v10, [I

    aput v2, v8, v11

    invoke-direct {v3, v7, v8}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    .line 87
    .local v3, "colorStateList":Landroid/content/res/ColorStateList;
    new-instance v7, Landroid/graphics/drawable/RippleDrawable;

    const/4 v8, 0x0

    invoke-direct {v7, v3, v8, v4}, Landroid/graphics/drawable/RippleDrawable;-><init>(Landroid/content/res/ColorStateList;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_0

    .line 68
    .end local v2    # "color":I
    .end local v3    # "colorStateList":Landroid/content/res/ColorStateList;
    .end local v4    # "mask":Landroid/graphics/drawable/Drawable;
    :cond_7
    invoke-virtual {p0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v7

    const v8, 0x101042c

    sget-object v9, Lcom/facebook/react/views/view/ReactDrawableHelper;->sResolveOutValue:Landroid/util/TypedValue;

    invoke-virtual {v7, v8, v9, v10}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    move-result v7

    if-eqz v7, :cond_8

    .line 72
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget-object v8, Lcom/facebook/react/views/view/ReactDrawableHelper;->sResolveOutValue:Landroid/util/TypedValue;

    iget v8, v8, Landroid/util/TypedValue;->resourceId:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    .restart local v2    # "color":I
    goto :goto_1

    .line 74
    .end local v2    # "color":I
    :cond_8
    new-instance v7, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    const-string v8, "Attribute colorControlHighlight couldn\'t be resolved into a drawable"

    invoke-direct {v7, v8}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 89
    :cond_9
    new-instance v7, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Invalid type for android drawable: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7
.end method
