.class final Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;
.super Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
.source "ExoSoSource.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/soloader/ExoSoSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "ExoUnpacker"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/soloader/ExoSoSource$ExoUnpacker$FileBackedInputDsoIterator;
    }
.end annotation


# instance fields
.field private final mDsos:[Lcom/facebook/soloader/ExoSoSource$FileDso;

.field final synthetic this$0:Lcom/facebook/soloader/ExoSoSource;


# direct methods
.method constructor <init>(Lcom/facebook/soloader/ExoSoSource;)V
    .locals 28
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;->this$0:Lcom/facebook/soloader/ExoSoSource;

    invoke-direct/range {p0 .. p0}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;-><init>()V

    .line 60
    move-object/from16 v0, p1

    iget-object v8, v0, Lcom/facebook/soloader/ExoSoSource;->mContext:Landroid/content/Context;

    .line 61
    .local v8, "context":Landroid/content/Context;
    new-instance v9, Ljava/io/File;

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "/data/local/tmp/exopackage/"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual {v8}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "/native-libs/"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-direct {v9, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 66
    .local v9, "exoDir":Ljava/io/File;
    new-instance v18, Ljava/util/ArrayList;

    invoke-direct/range {v18 .. v18}, Ljava/util/ArrayList;-><init>()V

    .line 68
    .local v18, "providedLibraries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/facebook/soloader/ExoSoSource$FileDso;>;"
    invoke-static {}, Lcom/facebook/soloader/SysUtil;->getSupportedAbis()[Ljava/lang/String;

    move-result-object v5

    .local v5, "arr$":[Ljava/lang/String;
    array-length v14, v5

    .local v14, "len$":I
    const/4 v13, 0x0

    .local v13, "i$":I
    :goto_0
    if-ge v13, v14, :cond_e

    aget-object v3, v5, v13

    .line 69
    .local v3, "abi":Ljava/lang/String;
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v9, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 70
    .local v4, "abiDir":Ljava/io/File;
    invoke-virtual {v4}, Ljava/io/File;->isDirectory()Z

    move-result v22

    if-nez v22, :cond_1

    .line 68
    :cond_0
    :goto_1
    add-int/lit8 v13, v13, 0x1

    goto :goto_0

    .line 74
    :cond_1
    new-instance v16, Ljava/io/File;

    const-string v22, "metadata.txt"

    move-object/from16 v0, v16

    move-object/from16 v1, v22

    invoke-direct {v0, v4, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 75
    .local v16, "metadataFileName":Ljava/io/File;
    invoke-virtual/range {v16 .. v16}, Ljava/io/File;->isFile()Z

    move-result v22

    if-eqz v22, :cond_0

    .line 79
    new-instance v11, Ljava/io/FileReader;

    move-object/from16 v0, v16

    invoke-direct {v11, v0}, Ljava/io/FileReader;-><init>(Ljava/io/File;)V

    .local v11, "fr":Ljava/io/FileReader;
    const/16 v24, 0x0

    .line 80
    :try_start_0
    new-instance v7, Ljava/io/BufferedReader;

    invoke-direct {v7, v11}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_3

    .line 79
    .local v7, "br":Ljava/io/BufferedReader;
    const/16 v23, 0x0

    .line 82
    :cond_2
    :goto_2
    :try_start_1
    invoke-virtual {v7}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v15

    .local v15, "line":Ljava/lang/String;
    if-eqz v15, :cond_8

    .line 83
    invoke-virtual {v15}, Ljava/lang/String;->length()I

    move-result v22

    if-eqz v22, :cond_2

    .line 87
    const/16 v22, 0x20

    move/from16 v0, v22

    invoke-virtual {v15, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v19

    .line 88
    .local v19, "sep":I
    const/16 v22, -0x1

    move/from16 v0, v19

    move/from16 v1, v22

    if-ne v0, v1, :cond_5

    .line 89
    new-instance v22, Ljava/lang/RuntimeException;

    new-instance v25, Ljava/lang/StringBuilder;

    invoke-direct/range {v25 .. v25}, Ljava/lang/StringBuilder;-><init>()V

    const-string v26, "illegal line in exopackage metadata: ["

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    move-object/from16 v0, v25

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    const-string v26, "]"

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v22
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    .line 79
    .end local v15    # "line":Ljava/lang/String;
    .end local v19    # "sep":I
    :catch_0
    move-exception v22

    :try_start_2
    throw v22
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 113
    :catchall_0
    move-exception v23

    move-object/from16 v27, v23

    move-object/from16 v23, v22

    move-object/from16 v22, v27

    :goto_3
    if-eqz v7, :cond_3

    if-eqz v23, :cond_b

    :try_start_3
    invoke-virtual {v7}, Ljava/io/BufferedReader;->close()V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_4
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    :cond_3
    :goto_4
    :try_start_4
    throw v22
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    .line 79
    .end local v7    # "br":Ljava/io/BufferedReader;
    :catch_1
    move-exception v22

    :try_start_5
    throw v22
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 113
    :catchall_1
    move-exception v23

    move-object/from16 v27, v23

    move-object/from16 v23, v22

    move-object/from16 v22, v27

    :goto_5
    if-eqz v11, :cond_4

    if-eqz v23, :cond_d

    :try_start_6
    invoke-virtual {v11}, Ljava/io/FileReader;->close()V
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_5

    :cond_4
    :goto_6
    throw v22

    .line 92
    .restart local v7    # "br":Ljava/io/BufferedReader;
    .restart local v15    # "line":Ljava/lang/String;
    .restart local v19    # "sep":I
    :cond_5
    :try_start_7
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v25, 0x0

    move/from16 v0, v25

    move/from16 v1, v19

    invoke-virtual {v15, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v25

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v25, ".so"

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    .line 93
    .local v20, "soName":Ljava/lang/String;
    invoke-virtual/range {v18 .. v18}, Ljava/util/ArrayList;->size()I

    move-result v17

    .line 94
    .local v17, "nrAlreadyProvided":I
    const/4 v10, 0x0

    .line 95
    .local v10, "found":Z
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_7
    move/from16 v0, v17

    if-ge v12, v0, :cond_6

    .line 96
    move-object/from16 v0, v18

    invoke-virtual {v0, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v22

    check-cast v22, Lcom/facebook/soloader/ExoSoSource$FileDso;

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/facebook/soloader/ExoSoSource$FileDso;->name:Ljava/lang/String;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v22

    if-eqz v22, :cond_7

    .line 97
    const/4 v10, 0x1

    .line 102
    :cond_6
    if-nez v10, :cond_2

    .line 106
    add-int/lit8 v22, v19, 0x1

    move/from16 v0, v22

    invoke-virtual {v15, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v6

    .line 107
    .local v6, "backingFileBaseName":Ljava/lang/String;
    new-instance v22, Lcom/facebook/soloader/ExoSoSource$FileDso;

    new-instance v25, Ljava/io/File;

    move-object/from16 v0, v25

    invoke-direct {v0, v4, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    move-object/from16 v2, v25

    invoke-direct {v0, v1, v6, v2}, Lcom/facebook/soloader/ExoSoSource$FileDso;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_7
    .catch Ljava/lang/Throwable; {:try_start_7 .. :try_end_7} :catch_0
    .catchall {:try_start_7 .. :try_end_7} :catchall_2

    goto/16 :goto_2

    .line 113
    .end local v6    # "backingFileBaseName":Ljava/lang/String;
    .end local v10    # "found":Z
    .end local v12    # "i":I
    .end local v15    # "line":Ljava/lang/String;
    .end local v17    # "nrAlreadyProvided":I
    .end local v19    # "sep":I
    .end local v20    # "soName":Ljava/lang/String;
    :catchall_2
    move-exception v22

    goto/16 :goto_3

    .line 95
    .restart local v10    # "found":Z
    .restart local v12    # "i":I
    .restart local v15    # "line":Ljava/lang/String;
    .restart local v17    # "nrAlreadyProvided":I
    .restart local v19    # "sep":I
    .restart local v20    # "soName":Ljava/lang/String;
    :cond_7
    add-int/lit8 v12, v12, 0x1

    goto :goto_7

    .line 113
    .end local v10    # "found":Z
    .end local v12    # "i":I
    .end local v17    # "nrAlreadyProvided":I
    .end local v19    # "sep":I
    .end local v20    # "soName":Ljava/lang/String;
    :cond_8
    if-eqz v7, :cond_9

    if-eqz v23, :cond_a

    :try_start_8
    invoke-virtual {v7}, Ljava/io/BufferedReader;->close()V
    :try_end_8
    .catch Ljava/lang/Throwable; {:try_start_8 .. :try_end_8} :catch_3
    .catchall {:try_start_8 .. :try_end_8} :catchall_3

    :cond_9
    :goto_8
    if-eqz v11, :cond_0

    if-eqz v24, :cond_c

    :try_start_9
    invoke-virtual {v11}, Ljava/io/FileReader;->close()V
    :try_end_9
    .catch Ljava/lang/Throwable; {:try_start_9 .. :try_end_9} :catch_2

    goto/16 :goto_1

    :catch_2
    move-exception v21

    .local v21, "x2":Ljava/lang/Throwable;
    move-object/from16 v0, v24

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto/16 :goto_1

    .end local v21    # "x2":Ljava/lang/Throwable;
    :catch_3
    move-exception v21

    .restart local v21    # "x2":Ljava/lang/Throwable;
    :try_start_a
    move-object/from16 v0, v23

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_8

    .end local v7    # "br":Ljava/io/BufferedReader;
    .end local v15    # "line":Ljava/lang/String;
    .end local v21    # "x2":Ljava/lang/Throwable;
    :catchall_3
    move-exception v22

    move-object/from16 v23, v24

    goto/16 :goto_5

    .restart local v7    # "br":Ljava/io/BufferedReader;
    .restart local v15    # "line":Ljava/lang/String;
    :cond_a
    invoke-virtual {v7}, Ljava/io/BufferedReader;->close()V

    goto :goto_8

    .end local v15    # "line":Ljava/lang/String;
    :catch_4
    move-exception v21

    .restart local v21    # "x2":Ljava/lang/Throwable;
    move-object/from16 v0, v23

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto/16 :goto_4

    .end local v21    # "x2":Ljava/lang/Throwable;
    :cond_b
    invoke-virtual {v7}, Ljava/io/BufferedReader;->close()V
    :try_end_a
    .catch Ljava/lang/Throwable; {:try_start_a .. :try_end_a} :catch_1
    .catchall {:try_start_a .. :try_end_a} :catchall_3

    goto/16 :goto_4

    .restart local v15    # "line":Ljava/lang/String;
    :cond_c
    invoke-virtual {v11}, Ljava/io/FileReader;->close()V

    goto/16 :goto_1

    .end local v7    # "br":Ljava/io/BufferedReader;
    .end local v15    # "line":Ljava/lang/String;
    :catch_5
    move-exception v21

    .restart local v21    # "x2":Ljava/lang/Throwable;
    move-object/from16 v0, v23

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto/16 :goto_6

    .end local v21    # "x2":Ljava/lang/Throwable;
    :cond_d
    invoke-virtual {v11}, Ljava/io/FileReader;->close()V

    goto/16 :goto_6

    .line 116
    .end local v3    # "abi":Ljava/lang/String;
    .end local v4    # "abiDir":Ljava/io/File;
    .end local v11    # "fr":Ljava/io/FileReader;
    .end local v16    # "metadataFileName":Ljava/io/File;
    :cond_e
    invoke-virtual/range {v18 .. v18}, Ljava/util/ArrayList;->size()I

    move-result v22

    move/from16 v0, v22

    new-array v0, v0, [Lcom/facebook/soloader/ExoSoSource$FileDso;

    move-object/from16 v22, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v22

    check-cast v22, [Lcom/facebook/soloader/ExoSoSource$FileDso;

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;->mDsos:[Lcom/facebook/soloader/ExoSoSource$FileDso;

    .line 117
    return-void
.end method

.method static synthetic access$100(Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;)[Lcom/facebook/soloader/ExoSoSource$FileDso;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;->mDsos:[Lcom/facebook/soloader/ExoSoSource$FileDso;

    return-object v0
.end method


# virtual methods
.method protected getDsoManifest()Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 121
    new-instance v0, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;

    iget-object v1, p0, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;->mDsos:[Lcom/facebook/soloader/ExoSoSource$FileDso;

    invoke-direct {v0, v1}, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;-><init>([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V

    return-object v0
.end method

.method protected openDsoIterator()Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 126
    new-instance v0, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker$FileBackedInputDsoIterator;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/facebook/soloader/ExoSoSource$ExoUnpacker$FileBackedInputDsoIterator;-><init>(Lcom/facebook/soloader/ExoSoSource$ExoUnpacker;Lcom/facebook/soloader/ExoSoSource$1;)V

    return-object v0
.end method
