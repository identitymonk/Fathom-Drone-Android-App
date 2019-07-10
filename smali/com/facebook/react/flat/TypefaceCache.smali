.class final Lcom/facebook/react/flat/TypefaceCache;
.super Ljava/lang/Object;
.source "TypefaceCache.java"


# static fields
.field private static final EXTENSIONS:[Ljava/lang/String;

.field private static final FILE_EXTENSIONS:[Ljava/lang/String;

.field private static final FONTFAMILY_CACHE:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "[",
            "Landroid/graphics/Typeface;",
            ">;"
        }
    .end annotation
.end field

.field private static final FONTS_ASSET_PATH:Ljava/lang/String; = "fonts/"

.field private static final MAX_STYLES:I = 0x4

.field private static final TYPEFACE_CACHE:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/graphics/Typeface;",
            "[",
            "Landroid/graphics/Typeface;",
            ">;"
        }
    .end annotation
.end field

.field private static sAssetManager:Landroid/content/res/AssetManager;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 29
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/TypefaceCache;->FONTFAMILY_CACHE:Ljava/util/HashMap;

    .line 30
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/TypefaceCache;->TYPEFACE_CACHE:Ljava/util/HashMap;

    .line 32
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

    sput-object v0, Lcom/facebook/react/flat/TypefaceCache;->EXTENSIONS:[Ljava/lang/String;

    .line 37
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, ".ttf"

    aput-object v1, v0, v3

    const-string v1, ".otf"

    aput-object v1, v0, v4

    sput-object v0, Lcom/facebook/react/flat/TypefaceCache;->FILE_EXTENSIONS:[Ljava/lang/String;

    .line 40
    const/4 v0, 0x0

    sput-object v0, Lcom/facebook/react/flat/TypefaceCache;->sAssetManager:Landroid/content/res/AssetManager;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static createTypeface(Ljava/lang/String;I)Landroid/graphics/Typeface;
    .locals 10
    .param p0, "fontFamilyName"    # Ljava/lang/String;
    .param p1, "style"    # I

    .prologue
    .line 67
    sget-object v6, Lcom/facebook/react/flat/TypefaceCache;->EXTENSIONS:[Ljava/lang/String;

    aget-object v1, v6, p1

    .line 68
    .local v1, "extension":Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;

    const/16 v7, 0x20

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v7, "fonts/"

    .line 69
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 70
    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 71
    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 72
    .local v4, "fileNameBuffer":Ljava/lang/StringBuilder;
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    .line 73
    .local v5, "length":I
    sget-object v7, Lcom/facebook/react/flat/TypefaceCache;->FILE_EXTENSIONS:[Ljava/lang/String;

    array-length v8, v7

    const/4 v6, 0x0

    :goto_0
    if-ge v6, v8, :cond_0

    aget-object v2, v7, v6

    .line 74
    .local v2, "fileExtension":Ljava/lang/String;
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 76
    .local v3, "fileName":Ljava/lang/String;
    :try_start_0
    sget-object v9, Lcom/facebook/react/flat/TypefaceCache;->sAssetManager:Landroid/content/res/AssetManager;

    invoke-static {v9, v3}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 83
    .end local v2    # "fileExtension":Ljava/lang/String;
    .end local v3    # "fileName":Ljava/lang/String;
    :goto_1
    return-object v6

    .line 77
    .restart local v2    # "fileExtension":Ljava/lang/String;
    .restart local v3    # "fileName":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 80
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 73
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 83
    .end local v0    # "e":Ljava/lang/RuntimeException;
    .end local v2    # "fileExtension":Ljava/lang/String;
    .end local v3    # "fileName":Ljava/lang/String;
    :cond_0
    invoke-static {p0, p1}, Landroid/graphics/Typeface;->create(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v6

    invoke-static {v6}, Lcom/facebook/infer/annotation/Assertions;->assumeNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/graphics/Typeface;

    goto :goto_1
.end method

.method public static getTypeface(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    .locals 2
    .param p0, "typeface"    # Landroid/graphics/Typeface;
    .param p1, "style"    # I

    .prologue
    .line 90
    if-nez p0, :cond_0

    .line 91
    invoke-static {p1}, Landroid/graphics/Typeface;->defaultFromStyle(I)Landroid/graphics/Typeface;

    move-result-object p0

    .line 115
    .end local p0    # "typeface":Landroid/graphics/Typeface;
    :goto_0
    return-object p0

    .line 94
    .restart local p0    # "typeface":Landroid/graphics/Typeface;
    :cond_0
    sget-object v1, Lcom/facebook/react/flat/TypefaceCache;->TYPEFACE_CACHE:Ljava/util/HashMap;

    invoke-virtual {v1, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/graphics/Typeface;

    .line 95
    .local v0, "cache":[Landroid/graphics/Typeface;
    if-nez v0, :cond_2

    .line 105
    const/4 v1, 0x4

    new-array v0, v1, [Landroid/graphics/Typeface;

    .line 106
    invoke-virtual {p0}, Landroid/graphics/Typeface;->getStyle()I

    move-result v1

    aput-object p0, v0, v1

    .line 112
    :cond_1
    invoke-static {p0, p1}, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;

    move-result-object p0

    .line 113
    aput-object p0, v0, p1

    .line 114
    sget-object v1, Lcom/facebook/react/flat/TypefaceCache;->TYPEFACE_CACHE:Ljava/util/HashMap;

    invoke-virtual {v1, p0, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 107
    :cond_2
    aget-object v1, v0, p1

    if-eqz v1, :cond_1

    .line 109
    aget-object p0, v0, p1

    goto :goto_0
.end method

.method public static getTypeface(Ljava/lang/String;I)Landroid/graphics/Typeface;
    .locals 3
    .param p0, "fontFamily"    # Ljava/lang/String;
    .param p1, "style"    # I

    .prologue
    .line 50
    sget-object v2, Lcom/facebook/react/flat/TypefaceCache;->FONTFAMILY_CACHE:Ljava/util/HashMap;

    invoke-virtual {v2, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/graphics/Typeface;

    .line 51
    .local v0, "cache":[Landroid/graphics/Typeface;
    if-nez v0, :cond_1

    .line 53
    const/4 v2, 0x4

    new-array v0, v2, [Landroid/graphics/Typeface;

    .line 54
    sget-object v2, Lcom/facebook/react/flat/TypefaceCache;->FONTFAMILY_CACHE:Ljava/util/HashMap;

    invoke-virtual {v2, p0, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 60
    :cond_0
    invoke-static {p0, p1}, Lcom/facebook/react/flat/TypefaceCache;->createTypeface(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v1

    .line 61
    .local v1, "typeface":Landroid/graphics/Typeface;
    aput-object v1, v0, p1

    .line 62
    sget-object v2, Lcom/facebook/react/flat/TypefaceCache;->TYPEFACE_CACHE:Ljava/util/HashMap;

    invoke-virtual {v2, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    .end local v1    # "typeface":Landroid/graphics/Typeface;
    :goto_0
    return-object v1

    .line 55
    :cond_1
    aget-object v2, v0, p1

    if-eqz v2, :cond_0

    .line 57
    aget-object v1, v0, p1

    goto :goto_0
.end method

.method public static setAssetManager(Landroid/content/res/AssetManager;)V
    .locals 0
    .param p0, "assetManager"    # Landroid/content/res/AssetManager;

    .prologue
    .line 43
    sput-object p0, Lcom/facebook/react/flat/TypefaceCache;->sAssetManager:Landroid/content/res/AssetManager;

    .line 44
    return-void
.end method
