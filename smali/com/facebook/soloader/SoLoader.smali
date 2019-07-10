.class public Lcom/facebook/soloader/SoLoader;
.super Ljava/lang/Object;
.source "SoLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/soloader/SoLoader$WrongAbiError;
    }
.end annotation


# static fields
.field static final DEBUG:Z = false

.field public static final SOLOADER_ALLOW_ASYNC_INIT:I = 0x2

.field public static final SOLOADER_ENABLE_EXOPACKAGE:I = 0x1

.field private static SO_STORE_NAME_MAIN:Ljava/lang/String; = null

.field static final SYSTRACE_LIBRARY_LOADING:Z = false

.field static final TAG:Ljava/lang/String; = "SoLoader"

.field private static sFlags:I

.field private static final sLoadedLibraries:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static sOldPolicy:Landroid/os/StrictMode$ThreadPolicy;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private static sSoSources:[Lcom/facebook/soloader/SoSource;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 64
    sput-object v1, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    .line 69
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/facebook/soloader/SoLoader;->sLoadedLibraries:Ljava/util/Set;

    .line 74
    sput-object v1, Lcom/facebook/soloader/SoLoader;->sOldPolicy:Landroid/os/StrictMode$ThreadPolicy;

    .line 79
    const-string v0, "lib-main"

    sput-object v0, Lcom/facebook/soloader/SoLoader;->SO_STORE_NAME_MAIN:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 217
    return-void
.end method

.method private static assertInitialized()V
    .locals 2

    .prologue
    .line 334
    sget-object v0, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    if-nez v0, :cond_0

    .line 335
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "SoLoader.init() not yet called"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 337
    :cond_0
    return-void
.end method

.method public static init(Landroid/content/Context;I)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 103
    invoke-static {}, Landroid/os/StrictMode;->allowThreadDiskWrites()Landroid/os/StrictMode$ThreadPolicy;

    move-result-object v0

    .line 105
    .local v0, "oldPolicy":Landroid/os/StrictMode$ThreadPolicy;
    :try_start_0
    invoke-static {p0, p1}, Lcom/facebook/soloader/SoLoader;->initImpl(Landroid/content/Context;I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 107
    invoke-static {v0}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    .line 109
    return-void

    .line 107
    :catchall_0
    move-exception v1

    invoke-static {v0}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    throw v1
.end method

.method public static init(Landroid/content/Context;Z)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "nativeExopackage"    # Z

    .prologue
    .line 116
    if-eqz p1, :cond_0

    const/4 v1, 0x1

    :goto_0
    :try_start_0
    invoke-static {p0, v1}, Lcom/facebook/soloader/SoLoader;->init(Landroid/content/Context;I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 120
    return-void

    .line 116
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 117
    :catch_0
    move-exception v0

    .line 118
    .local v0, "ex":Ljava/io/IOException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private static declared-synchronized initImpl(Landroid/content/Context;I)V
    .locals 20
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 123
    const-class v17, Lcom/facebook/soloader/SoLoader;

    monitor-enter v17

    :try_start_0
    sget-object v16, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    if-nez v16, :cond_8

    .line 124
    sput p1, Lcom/facebook/soloader/SoLoader;->sFlags:I

    .line 126
    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    .line 132
    .local v13, "soSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/facebook/soloader/SoSource;>;"
    const-string v16, "LD_LIBRARY_PATH"

    invoke-static/range {v16 .. v16}, Ljava/lang/System;->getenv(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 133
    .local v3, "LD_LIBRARY_PATH":Ljava/lang/String;
    if-nez v3, :cond_0

    .line 134
    const-string v3, "/vendor/lib:/system/lib"

    .line 137
    :cond_0
    const-string v16, ":"

    move-object/from16 v0, v16

    invoke-virtual {v3, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v14

    .line 138
    .local v14, "systemLibraryDirectories":[Ljava/lang/String;
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    array-length v0, v14

    move/from16 v16, v0

    move/from16 v0, v16

    if-ge v7, v0, :cond_1

    .line 142
    new-instance v15, Ljava/io/File;

    aget-object v16, v14, v7

    invoke-direct/range {v15 .. v16}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 143
    .local v15, "systemSoDirectory":Ljava/io/File;
    new-instance v16, Lcom/facebook/soloader/DirectorySoSource;

    const/16 v18, 0x2

    move-object/from16 v0, v16

    move/from16 v1, v18

    invoke-direct {v0, v15, v1}, Lcom/facebook/soloader/DirectorySoSource;-><init>(Ljava/io/File;I)V

    move-object/from16 v0, v16

    invoke-virtual {v13, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 138
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 155
    .end local v15    # "systemSoDirectory":Ljava/io/File;
    :cond_1
    if-eqz p0, :cond_2

    .line 160
    and-int/lit8 v16, p1, 0x1

    if-eqz v16, :cond_3

    .line 161
    const/16 v16, 0x0

    new-instance v18, Lcom/facebook/soloader/ExoSoSource;

    sget-object v19, Lcom/facebook/soloader/SoLoader;->SO_STORE_NAME_MAIN:Ljava/lang/String;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/facebook/soloader/ExoSoSource;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    move/from16 v0, v16

    move-object/from16 v1, v18

    invoke-virtual {v13, v0, v1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 193
    :cond_2
    :goto_1
    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v16

    move/from16 v0, v16

    new-array v0, v0, [Lcom/facebook/soloader/SoSource;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v13, v0}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Lcom/facebook/soloader/SoSource;

    .line 194
    .local v6, "finalSoSources":[Lcom/facebook/soloader/SoSource;
    invoke-static {}, Lcom/facebook/soloader/SoLoader;->makePrepareFlags()I

    move-result v12

    .line 195
    .local v12, "prepareFlags":I
    array-length v7, v6

    move v8, v7

    .end local v7    # "i":I
    .local v8, "i":I
    :goto_2
    add-int/lit8 v7, v8, -0x1

    .end local v8    # "i":I
    .restart local v7    # "i":I
    if-lez v8, :cond_7

    .line 196
    aget-object v16, v6, v7

    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Lcom/facebook/soloader/SoSource;->prepare(I)V

    move v8, v7

    .end local v7    # "i":I
    .restart local v8    # "i":I
    goto :goto_2

    .line 163
    .end local v6    # "finalSoSources":[Lcom/facebook/soloader/SoSource;
    .end local v8    # "i":I
    .end local v12    # "prepareFlags":I
    .restart local v7    # "i":I
    :cond_3
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v5

    .line 164
    .local v5, "applicationInfo":Landroid/content/pm/ApplicationInfo;
    iget v0, v5, Landroid/content/pm/ApplicationInfo;->flags:I

    move/from16 v16, v0

    and-int/lit8 v16, v16, 0x1

    if-eqz v16, :cond_4

    iget v0, v5, Landroid/content/pm/ApplicationInfo;->flags:I

    move/from16 v16, v0

    move/from16 v0, v16

    and-int/lit16 v0, v0, 0x80

    move/from16 v16, v0

    if-nez v16, :cond_4

    const/4 v9, 0x1

    .line 168
    .local v9, "isSystemApplication":Z
    :goto_3
    if-eqz v9, :cond_5

    .line 169
    const/4 v4, 0x0

    .line 189
    .local v4, "apkSoSourceFlags":I
    :goto_4
    const/16 v16, 0x0

    new-instance v18, Lcom/facebook/soloader/ApkSoSource;

    sget-object v19, Lcom/facebook/soloader/SoLoader;->SO_STORE_NAME_MAIN:Ljava/lang/String;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2, v4}, Lcom/facebook/soloader/ApkSoSource;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    move/from16 v0, v16

    move-object/from16 v1, v18

    invoke-virtual {v13, v0, v1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 123
    .end local v3    # "LD_LIBRARY_PATH":Ljava/lang/String;
    .end local v4    # "apkSoSourceFlags":I
    .end local v5    # "applicationInfo":Landroid/content/pm/ApplicationInfo;
    .end local v7    # "i":I
    .end local v9    # "isSystemApplication":Z
    .end local v13    # "soSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/facebook/soloader/SoSource;>;"
    .end local v14    # "systemLibraryDirectories":[Ljava/lang/String;
    :catchall_0
    move-exception v16

    monitor-exit v17

    throw v16

    .line 164
    .restart local v3    # "LD_LIBRARY_PATH":Ljava/lang/String;
    .restart local v5    # "applicationInfo":Landroid/content/pm/ApplicationInfo;
    .restart local v7    # "i":I
    .restart local v13    # "soSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/facebook/soloader/SoSource;>;"
    .restart local v14    # "systemLibraryDirectories":[Ljava/lang/String;
    :cond_4
    const/4 v9, 0x0

    goto :goto_3

    .line 171
    .restart local v9    # "isSystemApplication":Z
    :cond_5
    const/4 v4, 0x1

    .line 172
    .restart local v4    # "apkSoSourceFlags":I
    const/4 v11, 0x0

    .line 179
    .local v11, "ourSoSourceFlags":I
    :try_start_1
    sget v16, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v18, 0x11

    move/from16 v0, v16

    move/from16 v1, v18

    if-gt v0, v1, :cond_6

    .line 180
    or-int/lit8 v11, v11, 0x1

    .line 183
    :cond_6
    new-instance v10, Lcom/facebook/soloader/DirectorySoSource;

    new-instance v16, Ljava/io/File;

    iget-object v0, v5, Landroid/content/pm/ApplicationInfo;->nativeLibraryDir:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v16

    invoke-direct {v10, v0, v11}, Lcom/facebook/soloader/DirectorySoSource;-><init>(Ljava/io/File;I)V

    .line 186
    .local v10, "ourSoSource":Lcom/facebook/soloader/SoSource;
    const/16 v16, 0x0

    move/from16 v0, v16

    invoke-virtual {v13, v0, v10}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    goto :goto_4

    .line 198
    .end local v4    # "apkSoSourceFlags":I
    .end local v5    # "applicationInfo":Landroid/content/pm/ApplicationInfo;
    .end local v9    # "isSystemApplication":Z
    .end local v10    # "ourSoSource":Lcom/facebook/soloader/SoSource;
    .end local v11    # "ourSoSourceFlags":I
    .restart local v6    # "finalSoSources":[Lcom/facebook/soloader/SoSource;
    .restart local v12    # "prepareFlags":I
    :cond_7
    sput-object v6, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 200
    .end local v3    # "LD_LIBRARY_PATH":Ljava/lang/String;
    .end local v6    # "finalSoSources":[Lcom/facebook/soloader/SoSource;
    .end local v7    # "i":I
    .end local v12    # "prepareFlags":I
    .end local v13    # "soSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/facebook/soloader/SoSource;>;"
    .end local v14    # "systemLibraryDirectories":[Ljava/lang/String;
    :cond_8
    monitor-exit v17

    return-void
.end method

.method public static declared-synchronized loadLibrary(Ljava/lang/String;)V
    .locals 5
    .param p0, "shortName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsatisfiedLinkError;
        }
    .end annotation

    .prologue
    .line 232
    const-class v3, Lcom/facebook/soloader/SoLoader;

    monitor-enter v3

    :try_start_0
    sget-object v2, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    if-nez v2, :cond_0

    .line 236
    const-string v2, "http://www.android.com/"

    const-string v4, "java.vendor.url"

    invoke-static {v4}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 238
    invoke-static {}, Lcom/facebook/soloader/SoLoader;->assertInitialized()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 247
    :cond_0
    :try_start_1
    invoke-static {p0}, Ljava/lang/System;->mapLibraryName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    invoke-static {v2, v4}, Lcom/facebook/soloader/SoLoader;->loadLibraryBySoName(Ljava/lang/String;I)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 257
    :goto_0
    monitor-exit v3

    return-void

    .line 241
    :cond_1
    :try_start_2
    invoke-static {p0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 232
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2

    .line 248
    :catch_0
    move-exception v0

    .line 249
    .local v0, "ex":Ljava/io/IOException;
    :try_start_3
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 250
    .end local v0    # "ex":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 251
    .local v0, "ex":Ljava/lang/UnsatisfiedLinkError;
    invoke-virtual {v0}, Ljava/lang/UnsatisfiedLinkError;->getMessage()Ljava/lang/String;

    move-result-object v1

    .line 252
    .local v1, "message":Ljava/lang/String;
    if-eqz v1, :cond_2

    const-string v2, "unexpected e_machine:"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 253
    new-instance v2, Lcom/facebook/soloader/SoLoader$WrongAbiError;

    invoke-direct {v2, v0}, Lcom/facebook/soloader/SoLoader$WrongAbiError;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 255
    :cond_2
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0
.end method

.method public static loadLibraryBySoName(Ljava/lang/String;I)V
    .locals 6
    .param p0, "soName"    # Ljava/lang/String;
    .param p1, "loadFlags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    const/4 v3, 0x1

    .line 279
    sget-object v4, Lcom/facebook/soloader/SoLoader;->sLoadedLibraries:Ljava/util/Set;

    invoke-interface {v4, p0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    move v2, v3

    .line 283
    .local v2, "result":I
    :goto_0
    if-nez v2, :cond_3

    .line 287
    const/4 v1, 0x0

    .line 288
    .local v1, "restoreOldPolicy":Z
    sget-object v4, Lcom/facebook/soloader/SoLoader;->sOldPolicy:Landroid/os/StrictMode$ThreadPolicy;

    if-nez v4, :cond_0

    .line 289
    invoke-static {}, Landroid/os/StrictMode;->allowThreadDiskReads()Landroid/os/StrictMode$ThreadPolicy;

    move-result-object v4

    sput-object v4, Lcom/facebook/soloader/SoLoader;->sOldPolicy:Landroid/os/StrictMode$ThreadPolicy;

    .line 290
    const/4 v1, 0x1

    .line 298
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-nez v2, :cond_2

    :try_start_0
    sget-object v4, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    array-length v4, v4

    if-ge v0, v4, :cond_2

    .line 299
    sget-object v4, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    aget-object v4, v4, v0

    invoke-virtual {v4, p0, p1}, Lcom/facebook/soloader/SoSource;->loadLibrary(Ljava/lang/String;I)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    .line 298
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 279
    .end local v0    # "i":I
    .end local v1    # "restoreOldPolicy":Z
    .end local v2    # "result":I
    :cond_1
    const/4 v2, 0x0

    goto :goto_0

    .line 306
    .restart local v0    # "i":I
    .restart local v1    # "restoreOldPolicy":Z
    .restart local v2    # "result":I
    :cond_2
    if-eqz v1, :cond_3

    .line 307
    sget-object v4, Lcom/facebook/soloader/SoLoader;->sOldPolicy:Landroid/os/StrictMode$ThreadPolicy;

    invoke-static {v4}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    .line 308
    sput-object v5, Lcom/facebook/soloader/SoLoader;->sOldPolicy:Landroid/os/StrictMode$ThreadPolicy;

    .line 313
    .end local v0    # "i":I
    .end local v1    # "restoreOldPolicy":Z
    :cond_3
    if-nez v2, :cond_5

    .line 314
    new-instance v3, Ljava/lang/UnsatisfiedLinkError;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "couldn\'t find DSO to load: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/UnsatisfiedLinkError;-><init>(Ljava/lang/String;)V

    throw v3

    .line 302
    .restart local v0    # "i":I
    .restart local v1    # "restoreOldPolicy":Z
    :catchall_0
    move-exception v3

    .line 306
    if-eqz v1, :cond_4

    .line 307
    sget-object v4, Lcom/facebook/soloader/SoLoader;->sOldPolicy:Landroid/os/StrictMode$ThreadPolicy;

    invoke-static {v4}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    .line 308
    sput-object v5, Lcom/facebook/soloader/SoLoader;->sOldPolicy:Landroid/os/StrictMode$ThreadPolicy;

    :cond_4
    throw v3

    .line 317
    .end local v0    # "i":I
    .end local v1    # "restoreOldPolicy":Z
    :cond_5
    if-ne v2, v3, :cond_6

    .line 318
    sget-object v3, Lcom/facebook/soloader/SoLoader;->sLoadedLibraries:Ljava/util/Set;

    invoke-interface {v3, p0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 320
    :cond_6
    return-void
.end method

.method public static declared-synchronized makeLdLibraryPath()Ljava/lang/String;
    .locals 5

    .prologue
    .line 359
    const-class v4, Lcom/facebook/soloader/SoLoader;

    monitor-enter v4

    :try_start_0
    invoke-static {}, Lcom/facebook/soloader/SoLoader;->assertInitialized()V

    .line 360
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 361
    .local v1, "pathElements":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    sget-object v2, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    .line 362
    .local v2, "soSources":[Lcom/facebook/soloader/SoSource;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v3, v2

    if-ge v0, v3, :cond_0

    .line 363
    aget-object v3, v2, v0

    invoke-virtual {v3, v1}, Lcom/facebook/soloader/SoSource;->addToLdLibraryPath(Ljava/util/Collection;)V

    .line 362
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 365
    :cond_0
    const-string v3, ":"

    invoke-static {v3, v1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    monitor-exit v4

    return-object v3

    .line 359
    .end local v0    # "i":I
    .end local v2    # "soSources":[Lcom/facebook/soloader/SoSource;
    :catchall_0
    move-exception v3

    monitor-exit v4

    throw v3
.end method

.method private static makePrepareFlags()I
    .locals 2

    .prologue
    .line 203
    const/4 v0, 0x0

    .line 204
    .local v0, "prepareFlags":I
    sget v1, Lcom/facebook/soloader/SoLoader;->sFlags:I

    and-int/lit8 v1, v1, 0x2

    if-eqz v1, :cond_0

    .line 205
    or-int/lit8 v0, v0, 0x1

    .line 207
    :cond_0
    return v0
.end method

.method public static declared-synchronized prependSoSource(Lcom/facebook/soloader/SoSource;)V
    .locals 6
    .param p0, "extraSoSource"    # Lcom/facebook/soloader/SoSource;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 346
    const-class v2, Lcom/facebook/soloader/SoLoader;

    monitor-enter v2

    :try_start_0
    invoke-static {}, Lcom/facebook/soloader/SoLoader;->assertInitialized()V

    .line 347
    invoke-static {}, Lcom/facebook/soloader/SoLoader;->makePrepareFlags()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/facebook/soloader/SoSource;->prepare(I)V

    .line 348
    sget-object v1, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    array-length v1, v1

    add-int/lit8 v1, v1, 0x1

    new-array v0, v1, [Lcom/facebook/soloader/SoSource;

    .line 349
    .local v0, "newSoSources":[Lcom/facebook/soloader/SoSource;
    const/4 v1, 0x0

    aput-object p0, v0, v1

    .line 350
    sget-object v1, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    const/4 v3, 0x0

    const/4 v4, 0x1

    sget-object v5, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    array-length v5, v5

    invoke-static {v1, v3, v0, v4, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 351
    sput-object v0, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 352
    monitor-exit v2

    return-void

    .line 346
    .end local v0    # "newSoSources":[Lcom/facebook/soloader/SoSource;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static setInTestMode()V
    .locals 3

    .prologue
    .line 214
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/facebook/soloader/SoSource;

    const/4 v1, 0x0

    new-instance v2, Lcom/facebook/soloader/NoopSoSource;

    invoke-direct {v2}, Lcom/facebook/soloader/NoopSoSource;-><init>()V

    aput-object v2, v0, v1

    sput-object v0, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    .line 215
    return-void
.end method

.method public static unpackLibraryAndDependencies(Ljava/lang/String;)Ljava/io/File;
    .locals 2
    .param p0, "shortName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsatisfiedLinkError;
        }
    .end annotation

    .prologue
    .line 270
    invoke-static {}, Lcom/facebook/soloader/SoLoader;->assertInitialized()V

    .line 272
    :try_start_0
    invoke-static {p0}, Ljava/lang/System;->mapLibraryName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/facebook/soloader/SoLoader;->unpackLibraryBySoName(Ljava/lang/String;)Ljava/io/File;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 273
    :catch_0
    move-exception v0

    .line 274
    .local v0, "ex":Ljava/io/IOException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method static unpackLibraryBySoName(Ljava/lang/String;)Ljava/io/File;
    .locals 3
    .param p0, "soName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 323
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v2, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    array-length v2, v2

    if-ge v0, v2, :cond_1

    .line 324
    sget-object v2, Lcom/facebook/soloader/SoLoader;->sSoSources:[Lcom/facebook/soloader/SoSource;

    aget-object v2, v2, v0

    invoke-virtual {v2, p0}, Lcom/facebook/soloader/SoSource;->unpackLibrary(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    .line 325
    .local v1, "unpacked":Ljava/io/File;
    if-eqz v1, :cond_0

    .line 326
    return-object v1

    .line 323
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 330
    .end local v1    # "unpacked":Ljava/io/File;
    :cond_1
    new-instance v2, Ljava/io/FileNotFoundException;

    invoke-direct {v2, p0}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v2
.end method
