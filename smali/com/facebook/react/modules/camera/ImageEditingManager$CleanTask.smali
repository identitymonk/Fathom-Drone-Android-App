.class Lcom/facebook/react/modules/camera/ImageEditingManager$CleanTask;
.super Lcom/facebook/react/bridge/GuardedAsyncTask;
.source "ImageEditingManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/camera/ImageEditingManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CleanTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/bridge/GuardedAsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method private constructor <init>(Lcom/facebook/react/bridge/ReactContext;)V
    .locals 0
    .param p1, "context"    # Lcom/facebook/react/bridge/ReactContext;

    .prologue
    .line 127
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/GuardedAsyncTask;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    .line 128
    iput-object p1, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CleanTask;->mContext:Landroid/content/Context;

    .line 129
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/modules/camera/ImageEditingManager$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/bridge/ReactContext;
    .param p2, "x1"    # Lcom/facebook/react/modules/camera/ImageEditingManager$1;

    .prologue
    .line 123
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/camera/ImageEditingManager$CleanTask;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    return-void
.end method

.method private cleanDirectory(Ljava/io/File;)V
    .locals 4
    .param p1, "directory"    # Ljava/io/File;

    .prologue
    .line 141
    new-instance v2, Lcom/facebook/react/modules/camera/ImageEditingManager$CleanTask$1;

    invoke-direct {v2, p0}, Lcom/facebook/react/modules/camera/ImageEditingManager$CleanTask$1;-><init>(Lcom/facebook/react/modules/camera/ImageEditingManager$CleanTask;)V

    invoke-virtual {p1, v2}, Ljava/io/File;->listFiles(Ljava/io/FilenameFilter;)[Ljava/io/File;

    move-result-object v1

    .line 148
    .local v1, "toDelete":[Ljava/io/File;
    if-eqz v1, :cond_0

    .line 149
    array-length v3, v1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v0, v1, v2

    .line 150
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 149
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 153
    .end local v0    # "file":Ljava/io/File;
    :cond_0
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackgroundGuarded([Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 123
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/facebook/react/modules/camera/ImageEditingManager$CleanTask;->doInBackgroundGuarded([Ljava/lang/Void;)V

    return-void
.end method

.method protected varargs doInBackgroundGuarded([Ljava/lang/Void;)V
    .locals 2
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 133
    iget-object v1, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CleanTask;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/facebook/react/modules/camera/ImageEditingManager$CleanTask;->cleanDirectory(Ljava/io/File;)V

    .line 134
    iget-object v1, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CleanTask;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getExternalCacheDir()Ljava/io/File;

    move-result-object v0

    .line 135
    .local v0, "externalCacheDir":Ljava/io/File;
    if-eqz v0, :cond_0

    .line 136
    invoke-direct {p0, v0}, Lcom/facebook/react/modules/camera/ImageEditingManager$CleanTask;->cleanDirectory(Ljava/io/File;)V

    .line 138
    :cond_0
    return-void
.end method
