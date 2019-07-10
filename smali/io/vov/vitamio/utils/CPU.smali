.class public Lio/vov/vitamio/utils/CPU;
.super Ljava/lang/Object;
.source "CPU.java"


# static fields
.field public static final FEATURE_ARM_NEON:I = 0x20

.field public static final FEATURE_ARM_V5TE:I = 0x1

.field public static final FEATURE_ARM_V6:I = 0x2

.field public static final FEATURE_ARM_V7A:I = 0x8

.field public static final FEATURE_ARM_VFP:I = 0x4

.field public static final FEATURE_ARM_VFPV3:I = 0x10

.field public static final FEATURE_MIPS:I = 0x80

.field public static final FEATURE_X86:I = 0x40

.field private static cachedFeature:I

.field private static cachedFeatureString:Ljava/lang/String;

.field private static final cpuinfo:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    .line 30
    const/4 v0, -0x1

    sput v0, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    .line 31
    const/4 v0, 0x0

    sput-object v0, Lio/vov/vitamio/utils/CPU;->cachedFeatureString:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getCachedFeature()I
    .locals 5

    .prologue
    .line 142
    sget-object v1, Lio/vov/vitamio/utils/CPU;->cachedFeatureString:Ljava/lang/String;

    if-nez v1, :cond_8

    .line 143
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 144
    .local v0, "sb":Ljava/lang/StringBuffer;
    sget v1, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    and-int/lit8 v1, v1, 0x1

    if-lez v1, :cond_0

    .line 145
    const-string v1, "V5TE "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 146
    :cond_0
    sget v1, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    and-int/lit8 v1, v1, 0x2

    if-lez v1, :cond_1

    .line 147
    const-string v1, "V6 "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 148
    :cond_1
    sget v1, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    and-int/lit8 v1, v1, 0x4

    if-lez v1, :cond_2

    .line 149
    const-string v1, "VFP "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 150
    :cond_2
    sget v1, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    and-int/lit8 v1, v1, 0x8

    if-lez v1, :cond_3

    .line 151
    const-string v1, "V7A "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 152
    :cond_3
    sget v1, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    and-int/lit8 v1, v1, 0x10

    if-lez v1, :cond_4

    .line 153
    const-string v1, "VFPV3 "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 154
    :cond_4
    sget v1, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    and-int/lit8 v1, v1, 0x20

    if-lez v1, :cond_5

    .line 155
    const-string v1, "NEON "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 156
    :cond_5
    sget v1, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    and-int/lit8 v1, v1, 0x40

    if-lez v1, :cond_6

    .line 157
    const-string v1, "X86 "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 158
    :cond_6
    sget v1, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    and-int/lit16 v1, v1, 0x80

    if-lez v1, :cond_7

    .line 159
    const-string v1, "MIPS "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 160
    :cond_7
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lio/vov/vitamio/utils/CPU;->cachedFeatureString:Ljava/lang/String;

    .line 162
    :cond_8
    const-string v1, "GET CPU FATURE: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    sget-object v4, Lio/vov/vitamio/utils/CPU;->cachedFeatureString:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 163
    sget v1, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    return v1
.end method

.method public static getFeature()I
    .locals 19

    .prologue
    .line 47
    sget v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    if-lez v14, :cond_0

    .line 48
    invoke-static {}, Lio/vov/vitamio/utils/CPU;->getCachedFeature()I

    move-result v14

    .line 138
    :goto_0
    return v14

    .line 50
    :cond_0
    const/4 v14, 0x1

    sput v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    .line 52
    sget-object v14, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    invoke-interface {v14}, Ljava/util/Map;->isEmpty()Z

    move-result v14

    if-eqz v14, :cond_2

    .line 53
    const/4 v1, 0x0

    .line 55
    .local v1, "bis":Ljava/io/BufferedReader;
    :try_start_0
    new-instance v2, Ljava/io/BufferedReader;

    new-instance v14, Ljava/io/FileReader;

    new-instance v15, Ljava/io/File;

    const-string v16, "/proc/cpuinfo"

    invoke-direct/range {v15 .. v16}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-direct {v14, v15}, Ljava/io/FileReader;-><init>(Ljava/io/File;)V

    invoke-direct {v2, v14}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_5
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 58
    .end local v1    # "bis":Ljava/io/BufferedReader;
    .local v2, "bis":Ljava/io/BufferedReader;
    :cond_1
    :goto_1
    :try_start_1
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v9

    .local v9, "line":Ljava/lang/String;
    if-eqz v9, :cond_3

    .line 59
    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v14

    const-string v15, ""

    invoke-virtual {v14, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-nez v14, :cond_1

    .line 60
    const-string v14, ":"

    invoke-virtual {v9, v14}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    .line 61
    .local v11, "pairs":[Ljava/lang/String;
    array-length v14, v11

    const/4 v15, 0x1

    if-le v14, v15, :cond_1

    .line 62
    sget-object v14, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    const/4 v15, 0x0

    aget-object v15, v11, v15

    invoke-virtual {v15}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v15

    const/16 v16, 0x1

    aget-object v16, v11, v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v16

    invoke-interface/range {v14 .. v16}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    .line 65
    .end local v9    # "line":Ljava/lang/String;
    .end local v11    # "pairs":[Ljava/lang/String;
    :catch_0
    move-exception v3

    move-object v1, v2

    .line 66
    .end local v2    # "bis":Ljava/io/BufferedReader;
    .restart local v1    # "bis":Ljava/io/BufferedReader;
    .local v3, "e":Ljava/lang/Exception;
    :goto_2
    :try_start_2
    const-string v14, "getCPUFeature"

    invoke-static {v14, v3}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 69
    if-eqz v1, :cond_2

    .line 70
    :try_start_3
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    .line 77
    .end local v3    # "e":Ljava/lang/Exception;
    :cond_2
    :goto_3
    sget-object v14, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    .end local v1    # "bis":Ljava/io/BufferedReader;
    invoke-interface {v14}, Ljava/util/Map;->isEmpty()Z

    move-result v14

    if-nez v14, :cond_e

    .line 78
    sget-object v14, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    invoke-interface {v14}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v14

    invoke-interface {v14}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v14

    .local v8, "key":Ljava/lang/String;
    :goto_4
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_5

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    .end local v8    # "key":Ljava/lang/String;
    check-cast v8, Ljava/lang/String;

    .line 79
    .restart local v8    # "key":Ljava/lang/String;
    const-string v15, "%s:%s"

    const/16 v16, 0x2

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    aput-object v8, v16, v17

    const/16 v17, 0x1

    sget-object v18, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    move-object/from16 v0, v18

    invoke-interface {v0, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v15 .. v16}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_4

    .line 69
    .end local v8    # "key":Ljava/lang/String;
    .restart local v2    # "bis":Ljava/io/BufferedReader;
    .restart local v9    # "line":Ljava/lang/String;
    :cond_3
    if-eqz v2, :cond_2

    .line 70
    :try_start_4
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_3

    .line 71
    :catch_1
    move-exception v3

    .line 72
    .local v3, "e":Ljava/io/IOException;
    const-string v14, "getCPUFeature"

    invoke-static {v14, v3}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_3

    .line 71
    .end local v2    # "bis":Ljava/io/BufferedReader;
    .end local v9    # "line":Ljava/lang/String;
    .restart local v1    # "bis":Ljava/io/BufferedReader;
    .local v3, "e":Ljava/lang/Exception;
    :catch_2
    move-exception v3

    .line 72
    .local v3, "e":Ljava/io/IOException;
    const-string v14, "getCPUFeature"

    invoke-static {v14, v3}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_3

    .line 68
    .end local v3    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v14

    .line 69
    :goto_5
    if-eqz v1, :cond_4

    .line 70
    :try_start_5
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 73
    :cond_4
    :goto_6
    throw v14

    .line 71
    :catch_3
    move-exception v3

    .line 72
    .restart local v3    # "e":Ljava/io/IOException;
    const-string v15, "getCPUFeature"

    invoke-static {v15, v3}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_6

    .line 81
    .end local v1    # "bis":Ljava/io/BufferedReader;
    .end local v3    # "e":Ljava/io/IOException;
    .restart local v8    # "key":Ljava/lang/String;
    :cond_5
    const/4 v5, 0x0

    .line 82
    .local v5, "hasARMv6":Z
    const/4 v6, 0x0

    .line 84
    .local v6, "hasARMv7":Z
    sget-object v14, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    .end local v8    # "key":Ljava/lang/String;
    const-string v15, "CPU architecture"

    invoke-interface {v14, v15}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 85
    .local v12, "val":Ljava/lang/String;
    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_12

    .line 87
    :try_start_6
    invoke-static {v12}, Lio/vov/vitamio/utils/StringUtils;->convertToInt(Ljava/lang/String;)I

    move-result v7

    .line 88
    .local v7, "i":I
    const-string v14, "CPU architecture: %s"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_6
    .catch Ljava/lang/NumberFormatException; {:try_start_6 .. :try_end_6} :catch_4

    .line 89
    const/4 v14, 0x7

    if-lt v7, v14, :cond_f

    .line 90
    const/4 v5, 0x1

    .line 91
    const/4 v6, 0x1

    .line 100
    .end local v7    # "i":I
    :cond_6
    :goto_7
    sget-object v14, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    const-string v15, "Processor"

    invoke-interface {v14, v15}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    .end local v12    # "val":Ljava/lang/String;
    check-cast v12, Ljava/lang/String;

    .line 101
    .restart local v12    # "val":Ljava/lang/String;
    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-eqz v14, :cond_7

    .line 102
    sget-object v14, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    const-string v15, "model name"

    invoke-interface {v14, v15}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    .end local v12    # "val":Ljava/lang/String;
    check-cast v12, Ljava/lang/String;

    .line 104
    .restart local v12    # "val":Ljava/lang/String;
    :cond_7
    if-eqz v12, :cond_9

    const-string v14, "(v7l)"

    invoke-virtual {v12, v14}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_8

    const-string v14, "ARMv7"

    invoke-virtual {v12, v14}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v14

    if-eqz v14, :cond_9

    .line 105
    :cond_8
    const/4 v5, 0x1

    .line 106
    const/4 v6, 0x1

    .line 108
    :cond_9
    if-eqz v12, :cond_b

    const-string v14, "(v6l)"

    invoke-virtual {v12, v14}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_a

    const-string v14, "ARMv6"

    invoke-virtual {v12, v14}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v14

    if-eqz v14, :cond_b

    .line 109
    :cond_a
    const/4 v5, 0x1

    .line 110
    const/4 v6, 0x0

    .line 113
    :cond_b
    if-eqz v5, :cond_c

    .line 114
    sget v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    or-int/lit8 v14, v14, 0x2

    sput v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    .line 115
    :cond_c
    if-eqz v6, :cond_d

    .line 116
    sget v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    or-int/lit8 v14, v14, 0x8

    sput v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    .line 118
    :cond_d
    sget-object v14, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    const-string v15, "Features"

    invoke-interface {v14, v15}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    .end local v12    # "val":Ljava/lang/String;
    check-cast v12, Ljava/lang/String;

    .line 119
    .restart local v12    # "val":Ljava/lang/String;
    if-eqz v12, :cond_e

    .line 120
    const-string v14, "neon"

    invoke-virtual {v12, v14}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v14

    if-eqz v14, :cond_10

    .line 121
    sget v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    or-int/lit8 v14, v14, 0x34

    sput v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    .line 138
    :cond_e
    :goto_8
    invoke-static {}, Lio/vov/vitamio/utils/CPU;->getCachedFeature()I

    move-result v14

    goto/16 :goto_0

    .line 92
    .restart local v7    # "i":I
    :cond_f
    const/4 v14, 0x6

    if-lt v7, v14, :cond_6

    .line 93
    const/4 v5, 0x1

    .line 94
    const/4 v6, 0x0

    goto :goto_7

    .line 96
    .end local v7    # "i":I
    :catch_4
    move-exception v4

    .line 97
    .local v4, "ex":Ljava/lang/NumberFormatException;
    const-string v14, "getCPUFeature"

    invoke-static {v14, v4}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_7

    .line 122
    .end local v4    # "ex":Ljava/lang/NumberFormatException;
    :cond_10
    const-string v14, "vfpv3"

    invoke-virtual {v12, v14}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v14

    if-eqz v14, :cond_11

    .line 123
    sget v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    or-int/lit8 v14, v14, 0x14

    sput v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    goto :goto_8

    .line 124
    :cond_11
    const-string v14, "vfp"

    invoke-virtual {v12, v14}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v14

    if-eqz v14, :cond_e

    .line 125
    sget v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    or-int/lit8 v14, v14, 0x4

    sput v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    goto :goto_8

    .line 128
    :cond_12
    sget-object v14, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    const-string v15, "vendor_id"

    invoke-interface {v14, v15}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 129
    .local v13, "vendor_id":Ljava/lang/String;
    sget-object v14, Lio/vov/vitamio/utils/CPU;->cpuinfo:Ljava/util/Map;

    const-string v15, "cpu model"

    invoke-interface {v14, v15}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 130
    .local v10, "mips":Ljava/lang/String;
    invoke-static {v13}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_13

    const-string v14, "GenuineIntel"

    invoke-virtual {v13, v14}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v14

    if-eqz v14, :cond_13

    .line 131
    sget v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    or-int/lit8 v14, v14, 0x40

    sput v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    goto :goto_8

    .line 132
    :cond_13
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_e

    const-string v14, "MIPS"

    invoke-virtual {v10, v14}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v14

    if-eqz v14, :cond_e

    .line 133
    sget v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    or-int/lit16 v14, v14, 0x80

    sput v14, Lio/vov/vitamio/utils/CPU;->cachedFeature:I

    goto :goto_8

    .line 68
    .end local v5    # "hasARMv6":Z
    .end local v6    # "hasARMv7":Z
    .end local v10    # "mips":Ljava/lang/String;
    .end local v12    # "val":Ljava/lang/String;
    .end local v13    # "vendor_id":Ljava/lang/String;
    .restart local v2    # "bis":Ljava/io/BufferedReader;
    :catchall_1
    move-exception v14

    move-object v1, v2

    .end local v2    # "bis":Ljava/io/BufferedReader;
    .restart local v1    # "bis":Ljava/io/BufferedReader;
    goto/16 :goto_5

    .line 65
    :catch_5
    move-exception v3

    goto/16 :goto_2
.end method

.method public static getFeatureString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    invoke-static {}, Lio/vov/vitamio/utils/CPU;->getFeature()I

    .line 43
    sget-object v0, Lio/vov/vitamio/utils/CPU;->cachedFeatureString:Ljava/lang/String;

    return-object v0
.end method

.method public static isDroidXDroid2()Z
    .locals 2

    .prologue
    .line 167
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, "DROIDX"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, "DROID2"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "shadow"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "droid2"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
