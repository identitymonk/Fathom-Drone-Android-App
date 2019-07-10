.class public final Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
.super Ljava/lang/Object;
.source "UnpackingSoSource.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/soloader/UnpackingSoSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "DsoManifest"
.end annotation


# instance fields
.field public final dsos:[Lcom/facebook/soloader/UnpackingSoSource$Dso;


# direct methods
.method public constructor <init>([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V
    .locals 0
    .param p1, "dsos"    # [Lcom/facebook/soloader/UnpackingSoSource$Dso;

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    iput-object p1, p0, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;->dsos:[Lcom/facebook/soloader/UnpackingSoSource$Dso;

    .line 65
    return-void
.end method

.method static final read(Ljava/io/DataInput;)Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .locals 7
    .param p0, "xdi"    # Ljava/io/DataInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 71
    invoke-interface {p0}, Ljava/io/DataInput;->readByte()B

    move-result v3

    .line 72
    .local v3, "version":I
    const/4 v4, 0x1

    if-eq v3, v4, :cond_0

    .line 73
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "wrong dso manifest version"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 76
    :cond_0
    invoke-interface {p0}, Ljava/io/DataInput;->readInt()I

    move-result v2

    .line 77
    .local v2, "nrDso":I
    if-gez v2, :cond_1

    .line 78
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "illegal number of shared libraries"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 81
    :cond_1
    new-array v0, v2, [Lcom/facebook/soloader/UnpackingSoSource$Dso;

    .line 82
    .local v0, "dsos":[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_2

    .line 83
    new-instance v4, Lcom/facebook/soloader/UnpackingSoSource$Dso;

    invoke-interface {p0}, Ljava/io/DataInput;->readUTF()Ljava/lang/String;

    move-result-object v5

    invoke-interface {p0}, Ljava/io/DataInput;->readUTF()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/facebook/soloader/UnpackingSoSource$Dso;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v4, v0, v1

    .line 82
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 85
    :cond_2
    new-instance v4, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;

    invoke-direct {v4, v0}, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;-><init>([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V

    return-object v4
.end method


# virtual methods
.method public final write(Ljava/io/DataOutput;)V
    .locals 2
    .param p1, "xdo"    # Ljava/io/DataOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 89
    const/4 v1, 0x1

    invoke-interface {p1, v1}, Ljava/io/DataOutput;->writeByte(I)V

    .line 90
    iget-object v1, p0, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;->dsos:[Lcom/facebook/soloader/UnpackingSoSource$Dso;

    array-length v1, v1

    invoke-interface {p1, v1}, Ljava/io/DataOutput;->writeInt(I)V

    .line 91
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;->dsos:[Lcom/facebook/soloader/UnpackingSoSource$Dso;

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 92
    iget-object v1, p0, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;->dsos:[Lcom/facebook/soloader/UnpackingSoSource$Dso;

    aget-object v1, v1, v0

    iget-object v1, v1, Lcom/facebook/soloader/UnpackingSoSource$Dso;->name:Ljava/lang/String;

    invoke-interface {p1, v1}, Ljava/io/DataOutput;->writeUTF(Ljava/lang/String;)V

    .line 93
    iget-object v1, p0, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;->dsos:[Lcom/facebook/soloader/UnpackingSoSource$Dso;

    aget-object v1, v1, v0

    iget-object v1, v1, Lcom/facebook/soloader/UnpackingSoSource$Dso;->hash:Ljava/lang/String;

    invoke-interface {p1, v1}, Ljava/io/DataOutput;->writeUTF(Ljava/lang/String;)V

    .line 91
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 95
    :cond_0
    return-void
.end method
