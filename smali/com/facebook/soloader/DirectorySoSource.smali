.class public Lcom/facebook/soloader/DirectorySoSource;
.super Lcom/facebook/soloader/SoSource;
.source "DirectorySoSource.java"


# static fields
.field public static final ON_LD_LIBRARY_PATH:I = 0x2

.field public static final RESOLVE_DEPENDENCIES:I = 0x1


# instance fields
.field protected final flags:I

.field protected final soDirectory:Ljava/io/File;


# direct methods
.method public constructor <init>(Ljava/io/File;I)V
    .locals 0
    .param p1, "soDirectory"    # Ljava/io/File;
    .param p2, "flags"    # I

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/facebook/soloader/SoSource;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/facebook/soloader/DirectorySoSource;->soDirectory:Ljava/io/File;

    .line 37
    iput p2, p0, Lcom/facebook/soloader/DirectorySoSource;->flags:I

    .line 38
    return-void
.end method

.method private static getDependencies(Ljava/io/File;)[Ljava/lang/String;
    .locals 1
    .param p0, "soFile"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 80
    :try_start_0
    invoke-static {p0}, Lcom/facebook/soloader/MinElf;->extract_DT_NEEDED(Ljava/io/File;)[Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    return-object v0

    .line 82
    :catchall_0
    move-exception v0

    throw v0
.end method


# virtual methods
.method public addToLdLibraryPath(Ljava/util/Collection;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 100
    .local p1, "paths":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/facebook/soloader/DirectorySoSource;->soDirectory:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 101
    return-void
.end method

.method public loadLibrary(Ljava/lang/String;I)I
    .locals 1
    .param p1, "soName"    # Ljava/lang/String;
    .param p2, "loadFlags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 42
    iget-object v0, p0, Lcom/facebook/soloader/DirectorySoSource;->soDirectory:Ljava/io/File;

    invoke-virtual {p0, p1, p2, v0}, Lcom/facebook/soloader/DirectorySoSource;->loadLibraryFrom(Ljava/lang/String;ILjava/io/File;)I

    move-result v0

    return v0
.end method

.method protected loadLibraryFrom(Ljava/lang/String;ILjava/io/File;)I
    .locals 5
    .param p1, "soName"    # Ljava/lang/String;
    .param p2, "loadFlags"    # I
    .param p3, "libDir"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 47
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, p3, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 48
    .local v3, "soFile":Ljava/io/File;
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 49
    const/4 v4, 0x0

    .line 72
    :goto_0
    return v4

    .line 52
    :cond_0
    and-int/lit8 v4, p2, 0x1

    if-eqz v4, :cond_1

    iget v4, p0, Lcom/facebook/soloader/DirectorySoSource;->flags:I

    and-int/lit8 v4, v4, 0x2

    if-eqz v4, :cond_1

    .line 54
    const/4 v4, 0x2

    goto :goto_0

    .line 57
    :cond_1
    iget v4, p0, Lcom/facebook/soloader/DirectorySoSource;->flags:I

    and-int/lit8 v4, v4, 0x1

    if-eqz v4, :cond_3

    .line 58
    invoke-static {v3}, Lcom/facebook/soloader/DirectorySoSource;->getDependencies(Ljava/io/File;)[Ljava/lang/String;

    move-result-object v0

    .line 59
    .local v0, "dependencies":[Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v4, v0

    if-ge v2, v4, :cond_3

    .line 60
    aget-object v1, v0, v2

    .line 61
    .local v1, "dependency":Ljava/lang/String;
    const-string v4, "/"

    invoke-virtual {v1, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 59
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 65
    :cond_2
    or-int/lit8 v4, p2, 0x1

    invoke-static {v1, v4}, Lcom/facebook/soloader/SoLoader;->loadLibraryBySoName(Ljava/lang/String;I)V

    goto :goto_2

    .line 71
    .end local v0    # "dependencies":[Ljava/lang/String;
    .end local v1    # "dependency":Ljava/lang/String;
    .end local v2    # "i":I
    :cond_3
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/System;->load(Ljava/lang/String;)V

    .line 72
    const/4 v4, 0x1

    goto :goto_0
.end method

.method public unpackLibrary(Ljava/lang/String;)Ljava/io/File;
    .locals 2
    .param p1, "soName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 90
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/facebook/soloader/DirectorySoSource;->soDirectory:Ljava/io/File;

    invoke-direct {v0, v1, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 91
    .local v0, "soFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 95
    .end local v0    # "soFile":Ljava/io/File;
    :goto_0
    return-object v0

    .restart local v0    # "soFile":Ljava/io/File;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
