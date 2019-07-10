.class public Lcom/facebook/react/views/text/ReactFontManager;
.super Ljava/lang/Object;
.source "ReactFontManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/views/text/ReactFontManager$FontFamily;
    }
.end annotation


# static fields
.field private static final EXTENSIONS:[Ljava/lang/String;

.field private static final FILE_EXTENSIONS:[Ljava/lang/String;

.field private static final FONTS_ASSET_PATH:Ljava/lang/String; = "fonts/"

.field private static sReactFontManagerInstance:Lcom/facebook/react/views/text/ReactFontManager;


# instance fields
.field private mFontCache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/facebook/react/views/text/ReactFontManager$FontFamily;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 30
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, ""

    aput-object v1, v0, v3

    const-string v1, "_bold"

    aput-object v1, v0, v4

    const-string v1, "_italic"

    aput-object v1, v0, v5

    const/4 v1, 0x3

    const-string v2, "_bold_italic"

    aput-object v2, v0, v1

    sput-object v0, Lcom/facebook/react/views/text/ReactFontManager;->EXTENSIONS:[Ljava/lang/String;

    .line 35
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, ".ttf"

    aput-object v1, v0, v3

    const-string v1, ".otf"

    aput-object v1, v0, v4

    sput-object v0, Lcom/facebook/react/views/text/ReactFontManager;->FILE_EXTENSIONS:[Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/views/text/ReactFontManager;->mFontCache:Ljava/util/Map;

    .line 44
    return-void
.end method

.method private static createTypeface(Ljava/lang/String;ILandroid/content/res/AssetManager;)Landroid/graphics/Typeface;
    .locals 8
    .param p0, "fontFamilyName"    # Ljava/lang/String;
    .param p1, "style"    # I
    .param p2, "assetManager"    # Landroid/content/res/AssetManager;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 99
    sget-object v3, Lcom/facebook/react/views/text/ReactFontManager;->EXTENSIONS:[Ljava/lang/String;

    aget-object v0, v3, p1

    .line 100
    .local v0, "extension":Ljava/lang/String;
    sget-object v4, Lcom/facebook/react/views/text/ReactFontManager;->FILE_EXTENSIONS:[Ljava/lang/String;

    array-length v5, v4

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v5, :cond_0

    aget-object v1, v4, v3

    .line 101
    .local v1, "fileExtension":Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "fonts/"

    .line 102
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 103
    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 104
    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 105
    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 106
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 108
    .local v2, "fileName":Ljava/lang/String;
    :try_start_0
    invoke-static {p2, v2}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 115
    .end local v1    # "fileExtension":Ljava/lang/String;
    .end local v2    # "fileName":Ljava/lang/String;
    :goto_1
    return-object v3

    .line 109
    .restart local v1    # "fileExtension":Ljava/lang/String;
    .restart local v2    # "fileName":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 100
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 115
    .end local v1    # "fileExtension":Ljava/lang/String;
    .end local v2    # "fileName":Ljava/lang/String;
    :cond_0
    invoke-static {p0, p1}, Landroid/graphics/Typeface;->create(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v3

    goto :goto_1
.end method

.method public static getInstance()Lcom/facebook/react/views/text/ReactFontManager;
    .locals 1

    .prologue
    .line 47
    sget-object v0, Lcom/facebook/react/views/text/ReactFontManager;->sReactFontManagerInstance:Lcom/facebook/react/views/text/ReactFontManager;

    if-nez v0, :cond_0

    .line 48
    new-instance v0, Lcom/facebook/react/views/text/ReactFontManager;

    invoke-direct {v0}, Lcom/facebook/react/views/text/ReactFontManager;-><init>()V

    sput-object v0, Lcom/facebook/react/views/text/ReactFontManager;->sReactFontManagerInstance:Lcom/facebook/react/views/text/ReactFontManager;

    .line 50
    :cond_0
    sget-object v0, Lcom/facebook/react/views/text/ReactFontManager;->sReactFontManagerInstance:Lcom/facebook/react/views/text/ReactFontManager;

    return-object v0
.end method


# virtual methods
.method public getTypeface(Ljava/lang/String;ILandroid/content/res/AssetManager;)Landroid/graphics/Typeface;
    .locals 3
    .param p1, "fontFamilyName"    # Ljava/lang/String;
    .param p2, "style"    # I
    .param p3, "assetManager"    # Landroid/content/res/AssetManager;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 58
    iget-object v2, p0, Lcom/facebook/react/views/text/ReactFontManager;->mFontCache:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;

    .line 59
    .local v0, "fontFamily":Lcom/facebook/react/views/text/ReactFontManager$FontFamily;
    if-nez v0, :cond_0

    .line 60
    new-instance v0, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;

    .end local v0    # "fontFamily":Lcom/facebook/react/views/text/ReactFontManager$FontFamily;
    const/4 v2, 0x0

    invoke-direct {v0, v2}, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;-><init>(Lcom/facebook/react/views/text/ReactFontManager$1;)V

    .line 61
    .restart local v0    # "fontFamily":Lcom/facebook/react/views/text/ReactFontManager$FontFamily;
    iget-object v2, p0, Lcom/facebook/react/views/text/ReactFontManager;->mFontCache:Ljava/util/Map;

    invoke-interface {v2, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    :cond_0
    invoke-virtual {v0, p2}, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;->getTypeface(I)Landroid/graphics/Typeface;

    move-result-object v1

    .line 65
    .local v1, "typeface":Landroid/graphics/Typeface;
    if-nez v1, :cond_1

    .line 66
    invoke-static {p1, p2, p3}, Lcom/facebook/react/views/text/ReactFontManager;->createTypeface(Ljava/lang/String;ILandroid/content/res/AssetManager;)Landroid/graphics/Typeface;

    move-result-object v1

    .line 67
    if-eqz v1, :cond_1

    .line 68
    invoke-virtual {v0, p2, v1}, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;->setTypeface(ILandroid/graphics/Typeface;)V

    .line 72
    :cond_1
    return-object v1
.end method

.method public setTypeface(Ljava/lang/String;ILandroid/graphics/Typeface;)V
    .locals 2
    .param p1, "fontFamilyName"    # Ljava/lang/String;
    .param p2, "style"    # I
    .param p3, "typeface"    # Landroid/graphics/Typeface;

    .prologue
    .line 84
    if-eqz p3, :cond_1

    .line 85
    iget-object v1, p0, Lcom/facebook/react/views/text/ReactFontManager;->mFontCache:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;

    .line 86
    .local v0, "fontFamily":Lcom/facebook/react/views/text/ReactFontManager$FontFamily;
    if-nez v0, :cond_0

    .line 87
    new-instance v0, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;

    .end local v0    # "fontFamily":Lcom/facebook/react/views/text/ReactFontManager$FontFamily;
    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;-><init>(Lcom/facebook/react/views/text/ReactFontManager$1;)V

    .line 88
    .restart local v0    # "fontFamily":Lcom/facebook/react/views/text/ReactFontManager$FontFamily;
    iget-object v1, p0, Lcom/facebook/react/views/text/ReactFontManager;->mFontCache:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    :cond_0
    invoke-virtual {v0, p2, p3}, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;->setTypeface(ILandroid/graphics/Typeface;)V

    .line 92
    .end local v0    # "fontFamily":Lcom/facebook/react/views/text/ReactFontManager$FontFamily;
    :cond_1
    return-void
.end method
