.class Lcom/facebook/cache/disk/DefaultDiskStorage$EntriesCollector;
.super Ljava/lang/Object;
.source "DefaultDiskStorage.java"

# interfaces
.implements Lcom/facebook/common/file/FileTreeVisitor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/cache/disk/DefaultDiskStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "EntriesCollector"
.end annotation


# instance fields
.field private final result:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/facebook/cache/disk/DiskStorage$Entry;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/facebook/cache/disk/DefaultDiskStorage;


# direct methods
.method private constructor <init>(Lcom/facebook/cache/disk/DefaultDiskStorage;)V
    .locals 1

    .prologue
    .line 248
    iput-object p1, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$EntriesCollector;->this$0:Lcom/facebook/cache/disk/DefaultDiskStorage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 250
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$EntriesCollector;->result:Ljava/util/List;

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/cache/disk/DefaultDiskStorage;Lcom/facebook/cache/disk/DefaultDiskStorage$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/cache/disk/DefaultDiskStorage;
    .param p2, "x1"    # Lcom/facebook/cache/disk/DefaultDiskStorage$1;

    .prologue
    .line 248
    invoke-direct {p0, p1}, Lcom/facebook/cache/disk/DefaultDiskStorage$EntriesCollector;-><init>(Lcom/facebook/cache/disk/DefaultDiskStorage;)V

    return-void
.end method


# virtual methods
.method public getEntries()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/facebook/cache/disk/DiskStorage$Entry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 270
    iget-object v0, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$EntriesCollector;->result:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public postVisitDirectory(Ljava/io/File;)V
    .locals 0
    .param p1, "directory"    # Ljava/io/File;

    .prologue
    .line 266
    return-void
.end method

.method public preVisitDirectory(Ljava/io/File;)V
    .locals 0
    .param p1, "directory"    # Ljava/io/File;

    .prologue
    .line 254
    return-void
.end method

.method public visitFile(Ljava/io/File;)V
    .locals 5
    .param p1, "file"    # Ljava/io/File;

    .prologue
    .line 258
    iget-object v1, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$EntriesCollector;->this$0:Lcom/facebook/cache/disk/DefaultDiskStorage;

    invoke-static {v1, p1}, Lcom/facebook/cache/disk/DefaultDiskStorage;->access$000(Lcom/facebook/cache/disk/DefaultDiskStorage;Ljava/io/File;)Lcom/facebook/cache/disk/DefaultDiskStorage$FileInfo;

    move-result-object v0

    .line 259
    .local v0, "info":Lcom/facebook/cache/disk/DefaultDiskStorage$FileInfo;
    if-eqz v0, :cond_0

    iget-object v1, v0, Lcom/facebook/cache/disk/DefaultDiskStorage$FileInfo;->type:Lcom/facebook/cache/disk/DefaultDiskStorage$FileType;

    sget-object v2, Lcom/facebook/cache/disk/DefaultDiskStorage$FileType;->CONTENT:Lcom/facebook/cache/disk/DefaultDiskStorage$FileType;

    if-ne v1, v2, :cond_0

    .line 260
    iget-object v1, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$EntriesCollector;->result:Ljava/util/List;

    new-instance v2, Lcom/facebook/cache/disk/DefaultDiskStorage$EntryImpl;

    iget-object v3, v0, Lcom/facebook/cache/disk/DefaultDiskStorage$FileInfo;->resourceId:Ljava/lang/String;

    const/4 v4, 0x0

    invoke-direct {v2, v3, p1, v4}, Lcom/facebook/cache/disk/DefaultDiskStorage$EntryImpl;-><init>(Ljava/lang/String;Ljava/io/File;Lcom/facebook/cache/disk/DefaultDiskStorage$1;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 262
    :cond_0
    return-void
.end method
