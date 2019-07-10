.class final Lcom/facebook/soloader/ExoSoSource$ExoUnpacker$FileBackedInputDsoIterator;
.super Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
.source "ExoSoSource.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "FileBackedInputDsoIterator"
.end annotation


# instance fields
.field private mCurrentDso:I

.field final synthetic this$1:Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;


# direct methods
.method private constructor <init>(Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker$FileBackedInputDsoIterator;->this$1:Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;

    invoke-direct {p0}, Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;Lcom/facebook/soloader/ExoSoSource$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;
    .param p2, "x1"    # Lcom/facebook/soloader/ExoSoSource$1;

    .prologue
    .line 129
    invoke-direct {p0, p1}, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker$FileBackedInputDsoIterator;-><init>(Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;)V

    return-void
.end method


# virtual methods
.method public hasNext()Z
    .locals 2

    .prologue
    .line 134
    iget v0, p0, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker$FileBackedInputDsoIterator;->mCurrentDso:I

    iget-object v1, p0, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker$FileBackedInputDsoIterator;->this$1:Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;

    invoke-static {v1}, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;->access$100(Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;)[Lcom/facebook/soloader/ExoSoSource$FileDso;

    move-result-object v1

    array-length v1, v1

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public next()Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 139
    iget-object v3, p0, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker$FileBackedInputDsoIterator;->this$1:Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;

    invoke-static {v3}, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;->access$100(Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;)[Lcom/facebook/soloader/ExoSoSource$FileDso;

    move-result-object v3

    iget v4, p0, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker$FileBackedInputDsoIterator;->mCurrentDso:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker$FileBackedInputDsoIterator;->mCurrentDso:I

    aget-object v1, v3, v4

    .line 140
    .local v1, "fileDso":Lcom/facebook/soloader/ExoSoSource$FileDso;
    new-instance v0, Ljava/io/FileInputStream;

    iget-object v3, v1, Lcom/facebook/soloader/ExoSoSource$FileDso;->backingFile:Ljava/io/File;

    invoke-direct {v0, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 142
    .local v0, "dsoFile":Ljava/io/FileInputStream;
    :try_start_0
    new-instance v2, Lcom/facebook/soloader/UnpackingSoSource$InputDso;

    invoke-direct {v2, v1, v0}, Lcom/facebook/soloader/UnpackingSoSource$InputDso;-><init>(Lcom/facebook/soloader/UnpackingSoSource$Dso;Ljava/io/InputStream;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 143
    .local v2, "ret":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    const/4 v0, 0x0

    .line 146
    if-eqz v0, :cond_0

    .line 147
    invoke-virtual {v0}, Ljava/io/FileInputStream;->close()V

    :cond_0
    return-object v2

    .line 146
    .end local v2    # "ret":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    :catchall_0
    move-exception v3

    if-eqz v0, :cond_1

    .line 147
    invoke-virtual {v0}, Ljava/io/FileInputStream;->close()V

    :cond_1
    throw v3
.end method
