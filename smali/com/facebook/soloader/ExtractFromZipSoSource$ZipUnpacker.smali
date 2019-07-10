.class public Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;
.super Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
.source "ExtractFromZipSoSource.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/soloader/ExtractFromZipSoSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "ZipUnpacker"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker$ZipBackedInputDsoIterator;
    }
.end annotation


# instance fields
.field private mDsos:[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;

.field private final mZipFile:Ljava/util/zip/ZipFile;

.field final synthetic this$0:Lcom/facebook/soloader/ExtractFromZipSoSource;


# direct methods
.method constructor <init>(Lcom/facebook/soloader/ExtractFromZipSoSource;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 56
    iput-object p1, p0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->this$0:Lcom/facebook/soloader/ExtractFromZipSoSource;

    invoke-direct {p0}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;-><init>()V

    .line 57
    new-instance v0, Ljava/util/zip/ZipFile;

    iget-object v1, p1, Lcom/facebook/soloader/ExtractFromZipSoSource;->mZipFileName:Ljava/io/File;

    invoke-direct {v0, v1}, Ljava/util/zip/ZipFile;-><init>(Ljava/io/File;)V

    iput-object v0, p0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->mZipFile:Ljava/util/zip/ZipFile;

    .line 58
    return-void
.end method

.method static synthetic access$100(Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;)[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->mDsos:[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;

    return-object v0
.end method

.method static synthetic access$200(Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;)Ljava/util/zip/ZipFile;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->mZipFile:Ljava/util/zip/ZipFile;

    return-object v0
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 118
    iget-object v0, p0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->mZipFile:Ljava/util/zip/ZipFile;

    invoke-virtual {v0}, Ljava/util/zip/ZipFile;->close()V

    .line 119
    return-void
.end method

.method final ensureDsos()[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    .locals 22

    .prologue
    .line 61
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->mDsos:[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;

    move-object/from16 v20, v0

    if-nez v20, :cond_7

    .line 62
    new-instance v14, Ljava/util/HashMap;

    invoke-direct {v14}, Ljava/util/HashMap;-><init>()V

    .line 63
    .local v14, "providedLibraries":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->this$0:Lcom/facebook/soloader/ExtractFromZipSoSource;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget-object v0, v0, Lcom/facebook/soloader/ExtractFromZipSoSource;->mZipSearchPattern:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-static/range {v20 .. v20}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v19

    .line 64
    .local v19, "zipSearchPattern":Ljava/util/regex/Pattern;
    invoke-static {}, Lcom/facebook/soloader/SysUtil;->getSupportedAbis()[Ljava/lang/String;

    move-result-object v17

    .line 65
    .local v17, "supportedAbis":[Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->mZipFile:Ljava/util/zip/ZipFile;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Ljava/util/zip/ZipFile;->entries()Ljava/util/Enumeration;

    move-result-object v5

    .line 66
    .local v5, "entries":Ljava/util/Enumeration;, "Ljava/util/Enumeration<+Ljava/util/zip/ZipEntry;>;"
    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v20

    if-eqz v20, :cond_2

    .line 67
    invoke-interface {v5}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/zip/ZipEntry;

    .line 68
    .local v6, "entry":Ljava/util/zip/ZipEntry;
    invoke-virtual {v6}, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v12

    .line 69
    .local v12, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v12}, Ljava/util/regex/Matcher;->matches()Z

    move-result v20

    if-eqz v20, :cond_0

    .line 70
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-virtual {v12, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v11

    .line 71
    .local v11, "libraryAbi":Ljava/lang/String;
    const/16 v20, 0x2

    move/from16 v0, v20

    invoke-virtual {v12, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v16

    .line 72
    .local v16, "soName":Ljava/lang/String;
    move-object/from16 v0, v17

    invoke-static {v0, v11}, Lcom/facebook/soloader/SysUtil;->findAbiScore([Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    .line 73
    .local v3, "abiScore":I
    if-ltz v3, :cond_0

    .line 74
    move-object/from16 v0, v16

    invoke-virtual {v14, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;

    .line 75
    .local v15, "so":Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    if-eqz v15, :cond_1

    iget v0, v15, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;->abiScore:I

    move/from16 v20, v0

    move/from16 v0, v20

    if-ge v3, v0, :cond_0

    .line 76
    :cond_1
    new-instance v20, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;

    move-object/from16 v0, v20

    move-object/from16 v1, v16

    invoke-direct {v0, v1, v6, v3}, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;-><init>(Ljava/lang/String;Ljava/util/zip/ZipEntry;I)V

    move-object/from16 v0, v16

    move-object/from16 v1, v20

    invoke-virtual {v14, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 82
    .end local v3    # "abiScore":I
    .end local v6    # "entry":Ljava/util/zip/ZipEntry;
    .end local v11    # "libraryAbi":Ljava/lang/String;
    .end local v12    # "m":Ljava/util/regex/Matcher;
    .end local v15    # "so":Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    .end local v16    # "soName":Ljava/lang/String;
    :cond_2
    invoke-virtual {v14}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v20

    invoke-virtual {v14}, Ljava/util/HashMap;->size()I

    move-result v21

    move/from16 v0, v21

    new-array v0, v0, [Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;

    move-object/from16 v21, v0

    invoke-interface/range {v20 .. v21}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;

    .line 83
    .local v4, "dsos":[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    invoke-static {v4}, Ljava/util/Arrays;->sort([Ljava/lang/Object;)V

    .line 84
    const/4 v13, 0x0

    .line 85
    .local v13, "nrFilteredDsos":I
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_1
    array-length v0, v4

    move/from16 v20, v0

    move/from16 v0, v20

    if-ge v8, v0, :cond_4

    .line 86
    aget-object v18, v4, v8

    .line 87
    .local v18, "zd":Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;->backingEntry:Ljava/util/zip/ZipEntry;

    move-object/from16 v20, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;->name:Ljava/lang/String;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    move-object/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->shouldExtract(Ljava/util/zip/ZipEntry;Ljava/lang/String;)Z

    move-result v20

    if-eqz v20, :cond_3

    .line 88
    add-int/lit8 v13, v13, 0x1

    .line 85
    :goto_2
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 90
    :cond_3
    const/16 v20, 0x0

    aput-object v20, v4, v8

    goto :goto_2

    .line 93
    .end local v18    # "zd":Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    :cond_4
    new-array v7, v13, [Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;

    .line 94
    .local v7, "filteredDsos":[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    const/4 v8, 0x0

    const/4 v9, 0x0

    .local v9, "j":I
    :goto_3
    array-length v0, v4

    move/from16 v20, v0

    move/from16 v0, v20

    if-ge v8, v0, :cond_6

    .line 95
    aget-object v18, v4, v8

    .line 96
    .restart local v18    # "zd":Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    if-eqz v18, :cond_5

    .line 97
    add-int/lit8 v10, v9, 0x1

    .end local v9    # "j":I
    .local v10, "j":I
    aput-object v18, v7, v9

    move v9, v10

    .line 94
    .end local v10    # "j":I
    .restart local v9    # "j":I
    :cond_5
    add-int/lit8 v8, v8, 0x1

    goto :goto_3

    .line 100
    .end local v18    # "zd":Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    :cond_6
    move-object/from16 v0, p0

    iput-object v7, v0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->mDsos:[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;

    .line 102
    .end local v4    # "dsos":[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    .end local v5    # "entries":Ljava/util/Enumeration;, "Ljava/util/Enumeration<+Ljava/util/zip/ZipEntry;>;"
    .end local v7    # "filteredDsos":[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;
    .end local v8    # "i":I
    .end local v9    # "j":I
    .end local v13    # "nrFilteredDsos":I
    .end local v14    # "providedLibraries":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;>;"
    .end local v17    # "supportedAbis":[Ljava/lang/String;
    .end local v19    # "zipSearchPattern":Ljava/util/regex/Pattern;
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->mDsos:[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;

    move-object/from16 v20, v0

    return-object v20
.end method

.method protected final getDsoManifest()Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 123
    new-instance v0, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;

    invoke-virtual {p0}, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;->ensureDsos()[Lcom/facebook/soloader/ExtractFromZipSoSource$ZipDso;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;-><init>([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V

    return-object v0
.end method

.method protected final openDsoIterator()Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 128
    new-instance v0, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker$ZipBackedInputDsoIterator;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker$ZipBackedInputDsoIterator;-><init>(Lcom/facebook/soloader/ExtractFromZipSoSource$ZipUnpacker;Lcom/facebook/soloader/ExtractFromZipSoSource$1;)V

    return-object v0
.end method

.method protected shouldExtract(Ljava/util/zip/ZipEntry;Ljava/lang/String;)Z
    .locals 1
    .param p1, "ze"    # Ljava/util/zip/ZipEntry;
    .param p2, "soName"    # Ljava/lang/String;

    .prologue
    .line 113
    const/4 v0, 0x1

    return v0
.end method
