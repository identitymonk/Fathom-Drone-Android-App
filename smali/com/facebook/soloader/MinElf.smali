.class public final Lcom/facebook/soloader/MinElf;
.super Ljava/lang/Object;
.source "MinElf.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/soloader/MinElf$ElfError;
    }
.end annotation


# static fields
.field public static final DT_NEEDED:I = 0x1

.field public static final DT_NULL:I = 0x0

.field public static final DT_STRTAB:I = 0x5

.field public static final ELF_MAGIC:I = 0x464c457f

.field public static final PN_XNUM:I = 0xffff

.field public static final PT_DYNAMIC:I = 0x2

.field public static final PT_LOAD:I = 0x1


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 286
    return-void
.end method

.method public static extract_DT_NEEDED(Ljava/io/File;)[Ljava/lang/String;
    .locals 2
    .param p0, "elfFile"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 40
    new-instance v0, Ljava/io/FileInputStream;

    invoke-direct {v0, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 42
    .local v0, "is":Ljava/io/FileInputStream;
    :try_start_0
    invoke-virtual {v0}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v1

    invoke-static {v1}, Lcom/facebook/soloader/MinElf;->extract_DT_NEEDED(Ljava/nio/channels/FileChannel;)[Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 44
    invoke-virtual {v0}, Ljava/io/FileInputStream;->close()V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Ljava/io/FileInputStream;->close()V

    throw v1
.end method

.method public static extract_DT_NEEDED(Ljava/nio/channels/FileChannel;)[Ljava/lang/String;
    .locals 46
    .param p0, "fc"    # Ljava/nio/channels/FileChannel;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 62
    const/16 v25, 0x8

    invoke-static/range {v25 .. v25}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v4

    .line 66
    .local v4, "bb":Ljava/nio/ByteBuffer;
    sget-object v25, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    move-object/from16 v0, v25

    invoke-virtual {v4, v0}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 67
    const-wide/16 v42, 0x0

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v42

    const-wide/32 v44, 0x464c457f

    cmp-long v25, v42, v44

    if-eqz v25, :cond_0

    .line 68
    new-instance v25, Lcom/facebook/soloader/MinElf$ElfError;

    const-string v42, "file is not ELF"

    move-object/from16 v0, v25

    move-object/from16 v1, v42

    invoke-direct {v0, v1}, Lcom/facebook/soloader/MinElf$ElfError;-><init>(Ljava/lang/String;)V

    throw v25

    .line 71
    :cond_0
    const-wide/16 v42, 0x4

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu8(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)S

    move-result v25

    const/16 v42, 0x1

    move/from16 v0, v25

    move/from16 v1, v42

    if-ne v0, v1, :cond_4

    const/16 v22, 0x1

    .line 72
    .local v22, "is32":Z
    :goto_0
    const-wide/16 v42, 0x5

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu8(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)S

    move-result v25

    const/16 v42, 0x2

    move/from16 v0, v25

    move/from16 v1, v42

    if-ne v0, v1, :cond_1

    .line 73
    sget-object v25, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    move-object/from16 v0, v25

    invoke-virtual {v4, v0}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 80
    :cond_1
    if-eqz v22, :cond_5

    const-wide/16 v42, 0x1c

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v16

    .line 84
    .local v16, "e_phoff":J
    :goto_1
    if-eqz v22, :cond_6

    const-wide/16 v42, 0x2c

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu16(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)I

    move-result v25

    move/from16 v0, v25

    int-to-long v14, v0

    .line 88
    .local v14, "e_phnum":J
    :goto_2
    if-eqz v22, :cond_7

    const-wide/16 v42, 0x2a

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu16(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)I

    move-result v5

    .line 92
    .local v5, "e_phentsize":I
    :goto_3
    const-wide/32 v42, 0xffff

    cmp-long v25, v14, v42

    if-nez v25, :cond_2

    .line 94
    if-eqz v22, :cond_8

    const-wide/16 v42, 0x20

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v18

    .line 98
    .local v18, "e_shoff":J
    :goto_4
    if-eqz v22, :cond_9

    const-wide/16 v42, 0x1c

    add-long v42, v42, v18

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v40

    .line 102
    .local v40, "sh_info":J
    :goto_5
    move-wide/from16 v14, v40

    .line 105
    .end local v18    # "e_shoff":J
    .end local v40    # "sh_info":J
    :cond_2
    const-wide/16 v12, 0x0

    .line 106
    .local v12, "dynStart":J
    move-wide/from16 v36, v16

    .line 108
    .local v36, "phdr":J
    const-wide/16 v20, 0x0

    .local v20, "i":J
    :goto_6
    cmp-long v25, v20, v14

    if-gez v25, :cond_3

    .line 109
    if-eqz v22, :cond_a

    const-wide/16 v42, 0x0

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v32

    .line 113
    .local v32, "p_type":J
    :goto_7
    const-wide/16 v42, 0x2

    cmp-long v25, v32, v42

    if-nez v25, :cond_c

    .line 114
    if-eqz v22, :cond_b

    const-wide/16 v42, 0x4

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v30

    .line 118
    .local v30, "p_offset":J
    :goto_8
    move-wide/from16 v12, v30

    .line 125
    .end local v30    # "p_offset":J
    .end local v32    # "p_type":J
    :cond_3
    const-wide/16 v42, 0x0

    cmp-long v25, v12, v42

    if-nez v25, :cond_d

    .line 126
    new-instance v25, Lcom/facebook/soloader/MinElf$ElfError;

    const-string v42, "ELF file does not contain dynamic linking information"

    move-object/from16 v0, v25

    move-object/from16 v1, v42

    invoke-direct {v0, v1}, Lcom/facebook/soloader/MinElf$ElfError;-><init>(Ljava/lang/String;)V

    throw v25

    .line 71
    .end local v5    # "e_phentsize":I
    .end local v12    # "dynStart":J
    .end local v14    # "e_phnum":J
    .end local v16    # "e_phoff":J
    .end local v20    # "i":J
    .end local v22    # "is32":Z
    .end local v36    # "phdr":J
    :cond_4
    const/16 v22, 0x0

    goto/16 :goto_0

    .line 80
    .restart local v22    # "is32":Z
    :cond_5
    const-wide/16 v42, 0x20

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->get64(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v16

    goto/16 :goto_1

    .line 84
    .restart local v16    # "e_phoff":J
    :cond_6
    const-wide/16 v42, 0x38

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu16(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)I

    move-result v25

    move/from16 v0, v25

    int-to-long v14, v0

    goto/16 :goto_2

    .line 88
    .restart local v14    # "e_phnum":J
    :cond_7
    const-wide/16 v42, 0x36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu16(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)I

    move-result v5

    goto/16 :goto_3

    .line 94
    .restart local v5    # "e_phentsize":I
    :cond_8
    const-wide/16 v42, 0x28

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->get64(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v18

    goto/16 :goto_4

    .line 98
    .restart local v18    # "e_shoff":J
    :cond_9
    const-wide/16 v42, 0x2c

    add-long v42, v42, v18

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v40

    goto/16 :goto_5

    .line 109
    .end local v18    # "e_shoff":J
    .restart local v12    # "dynStart":J
    .restart local v20    # "i":J
    .restart local v36    # "phdr":J
    :cond_a
    const-wide/16 v42, 0x0

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v32

    goto :goto_7

    .line 114
    .restart local v32    # "p_type":J
    :cond_b
    const-wide/16 v42, 0x8

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->get64(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v30

    goto :goto_8

    .line 122
    :cond_c
    int-to-long v0, v5

    move-wide/from16 v42, v0

    add-long v36, v36, v42

    .line 108
    const-wide/16 v42, 0x1

    add-long v20, v20, v42

    goto/16 :goto_6

    .line 134
    .end local v32    # "p_type":J
    :cond_d
    const/16 v24, 0x0

    .line 135
    .local v24, "nr_DT_NEEDED":I
    move-wide v10, v12

    .line 136
    .local v10, "dyn":J
    const-wide/16 v38, 0x0

    .line 139
    .local v38, "ptr_DT_STRTAB":J
    :cond_e
    if-eqz v22, :cond_f

    const-wide/16 v42, 0x0

    add-long v42, v42, v10

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v6

    .line 143
    .local v6, "d_tag":J
    :goto_9
    const-wide/16 v42, 0x1

    cmp-long v25, v6, v42

    if-nez v25, :cond_12

    .line 144
    const v25, 0x7fffffff

    move/from16 v0, v24

    move/from16 v1, v25

    if-ne v0, v1, :cond_10

    .line 145
    new-instance v25, Lcom/facebook/soloader/MinElf$ElfError;

    const-string v42, "malformed DT_NEEDED section"

    move-object/from16 v0, v25

    move-object/from16 v1, v42

    invoke-direct {v0, v1}, Lcom/facebook/soloader/MinElf$ElfError;-><init>(Ljava/lang/String;)V

    throw v25

    .line 139
    .end local v6    # "d_tag":J
    :cond_f
    const-wide/16 v42, 0x0

    add-long v42, v42, v10

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->get64(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v6

    goto :goto_9

    .line 148
    .restart local v6    # "d_tag":J
    :cond_10
    add-int/lit8 v24, v24, 0x1

    .line 155
    :cond_11
    :goto_a
    if-eqz v22, :cond_14

    const-wide/16 v42, 0x8

    :goto_b
    add-long v10, v10, v42

    .line 156
    const-wide/16 v42, 0x0

    cmp-long v25, v6, v42

    if-nez v25, :cond_e

    .line 158
    const-wide/16 v42, 0x0

    cmp-long v25, v38, v42

    if-nez v25, :cond_15

    .line 159
    new-instance v25, Lcom/facebook/soloader/MinElf$ElfError;

    const-string v42, "Dynamic section string-table not found"

    move-object/from16 v0, v25

    move-object/from16 v1, v42

    invoke-direct {v0, v1}, Lcom/facebook/soloader/MinElf$ElfError;-><init>(Ljava/lang/String;)V

    throw v25

    .line 149
    :cond_12
    const-wide/16 v42, 0x5

    cmp-long v25, v6, v42

    if-nez v25, :cond_11

    .line 150
    if-eqz v22, :cond_13

    const-wide/16 v42, 0x4

    add-long v42, v42, v10

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v38

    :goto_c
    goto :goto_a

    :cond_13
    const-wide/16 v42, 0x8

    add-long v42, v42, v10

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->get64(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v38

    goto :goto_c

    .line 155
    :cond_14
    const-wide/16 v42, 0x10

    goto :goto_b

    .line 164
    :cond_15
    const-wide/16 v26, 0x0

    .line 165
    .local v26, "off_DT_STRTAB":J
    move-wide/from16 v36, v16

    .line 167
    const/16 v20, 0x0

    .local v20, "i":I
    :goto_d
    move/from16 v0, v20

    int-to-long v0, v0

    move-wide/from16 v42, v0

    cmp-long v25, v42, v14

    if-gez v25, :cond_16

    .line 168
    if-eqz v22, :cond_17

    const-wide/16 v42, 0x0

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v32

    .line 172
    .restart local v32    # "p_type":J
    :goto_e
    const-wide/16 v42, 0x1

    cmp-long v25, v32, v42

    if-nez v25, :cond_1b

    .line 173
    if-eqz v22, :cond_18

    const-wide/16 v42, 0x8

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v34

    .line 177
    .local v34, "p_vaddr":J
    :goto_f
    if-eqz v22, :cond_19

    const-wide/16 v42, 0x14

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v28

    .line 181
    .local v28, "p_memsz":J
    :goto_10
    cmp-long v25, v34, v38

    if-gtz v25, :cond_1b

    add-long v42, v34, v28

    cmp-long v25, v38, v42

    if-gez v25, :cond_1b

    .line 182
    if-eqz v22, :cond_1a

    const-wide/16 v42, 0x4

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v30

    .line 186
    .restart local v30    # "p_offset":J
    :goto_11
    sub-long v42, v38, v34

    add-long v26, v30, v42

    .line 194
    .end local v28    # "p_memsz":J
    .end local v30    # "p_offset":J
    .end local v32    # "p_type":J
    .end local v34    # "p_vaddr":J
    :cond_16
    const-wide/16 v42, 0x0

    cmp-long v25, v26, v42

    if-nez v25, :cond_1c

    .line 195
    new-instance v25, Lcom/facebook/soloader/MinElf$ElfError;

    const-string v42, "did not find file offset of DT_STRTAB table"

    move-object/from16 v0, v25

    move-object/from16 v1, v42

    invoke-direct {v0, v1}, Lcom/facebook/soloader/MinElf$ElfError;-><init>(Ljava/lang/String;)V

    throw v25

    .line 168
    :cond_17
    const-wide/16 v42, 0x0

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v32

    goto :goto_e

    .line 173
    .restart local v32    # "p_type":J
    :cond_18
    const-wide/16 v42, 0x10

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->get64(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v34

    goto :goto_f

    .line 177
    .restart local v34    # "p_vaddr":J
    :cond_19
    const-wide/16 v42, 0x28

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->get64(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v28

    goto :goto_10

    .line 182
    .restart local v28    # "p_memsz":J
    :cond_1a
    const-wide/16 v42, 0x8

    add-long v42, v42, v36

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->get64(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v30

    goto :goto_11

    .line 191
    .end local v28    # "p_memsz":J
    .end local v34    # "p_vaddr":J
    :cond_1b
    int-to-long v0, v5

    move-wide/from16 v42, v0

    add-long v36, v36, v42

    .line 167
    add-int/lit8 v20, v20, 0x1

    goto/16 :goto_d

    .line 198
    .end local v32    # "p_type":J
    :cond_1c
    move/from16 v0, v24

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v23, v0

    .line 200
    .local v23, "needed":[Ljava/lang/String;
    const/16 v24, 0x0

    .line 201
    move-wide v10, v12

    .line 204
    :cond_1d
    if-eqz v22, :cond_1e

    const-wide/16 v42, 0x0

    add-long v42, v42, v10

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v6

    .line 208
    :goto_12
    const-wide/16 v42, 0x1

    cmp-long v25, v6, v42

    if-nez v25, :cond_21

    .line 209
    if-eqz v22, :cond_1f

    const-wide/16 v42, 0x4

    add-long v42, v42, v10

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v8

    .line 213
    .local v8, "d_val":J
    :goto_13
    add-long v42, v26, v8

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->getSz(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)Ljava/lang/String;

    move-result-object v25

    aput-object v25, v23, v24

    .line 214
    const v25, 0x7fffffff

    move/from16 v0, v24

    move/from16 v1, v25

    if-ne v0, v1, :cond_20

    .line 215
    new-instance v25, Lcom/facebook/soloader/MinElf$ElfError;

    const-string v42, "malformed DT_NEEDED section"

    move-object/from16 v0, v25

    move-object/from16 v1, v42

    invoke-direct {v0, v1}, Lcom/facebook/soloader/MinElf$ElfError;-><init>(Ljava/lang/String;)V

    throw v25

    .line 204
    .end local v8    # "d_val":J
    :cond_1e
    const-wide/16 v42, 0x0

    add-long v42, v42, v10

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->get64(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v6

    goto :goto_12

    .line 209
    :cond_1f
    const-wide/16 v42, 0x8

    add-long v42, v42, v10

    move-object/from16 v0, p0

    move-wide/from16 v1, v42

    invoke-static {v0, v4, v1, v2}, Lcom/facebook/soloader/MinElf;->get64(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J

    move-result-wide v8

    goto :goto_13

    .line 218
    .restart local v8    # "d_val":J
    :cond_20
    add-int/lit8 v24, v24, 0x1

    .line 221
    .end local v8    # "d_val":J
    :cond_21
    if-eqz v22, :cond_22

    const-wide/16 v42, 0x8

    :goto_14
    add-long v10, v10, v42

    .line 222
    const-wide/16 v42, 0x0

    cmp-long v25, v6, v42

    if-nez v25, :cond_1d

    .line 224
    move-object/from16 v0, v23

    array-length v0, v0

    move/from16 v25, v0

    move/from16 v0, v24

    move/from16 v1, v25

    if-eq v0, v1, :cond_23

    .line 225
    new-instance v25, Lcom/facebook/soloader/MinElf$ElfError;

    const-string v42, "malformed DT_NEEDED section"

    move-object/from16 v0, v25

    move-object/from16 v1, v42

    invoke-direct {v0, v1}, Lcom/facebook/soloader/MinElf$ElfError;-><init>(Ljava/lang/String;)V

    throw v25

    .line 221
    :cond_22
    const-wide/16 v42, 0x10

    goto :goto_14

    .line 228
    :cond_23
    return-object v23
.end method

.method private static get64(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J
    .locals 2
    .param p0, "fc"    # Ljava/nio/channels/FileChannel;
    .param p1, "bb"    # Ljava/nio/ByteBuffer;
    .param p2, "offset"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 264
    const/16 v0, 0x8

    invoke-static {p0, p1, v0, p2, p3}, Lcom/facebook/soloader/MinElf;->read(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;IJ)V

    .line 265
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->getLong()J

    move-result-wide v0

    return-wide v0
.end method

.method private static getSz(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)Ljava/lang/String;
    .locals 6
    .param p0, "fc"    # Ljava/nio/channels/FileChannel;
    .param p1, "bb"    # Ljava/nio/ByteBuffer;
    .param p2, "offset"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 233
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 235
    .local v1, "sb":Ljava/lang/StringBuilder;
    :goto_0
    const-wide/16 v4, 0x1

    add-long v2, p2, v4

    .end local p2    # "offset":J
    .local v2, "offset":J
    invoke-static {p0, p1, p2, p3}, Lcom/facebook/soloader/MinElf;->getu8(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)S

    move-result v0

    .local v0, "b":S
    if-eqz v0, :cond_0

    .line 236
    int-to-char v4, v0

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-wide p2, v2

    .end local v2    # "offset":J
    .restart local p2    # "offset":J
    goto :goto_0

    .line 239
    .end local p2    # "offset":J
    .restart local v2    # "offset":J
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method private static getu16(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)I
    .locals 2
    .param p0, "fc"    # Ljava/nio/channels/FileChannel;
    .param p1, "bb"    # Ljava/nio/ByteBuffer;
    .param p2, "offset"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 276
    const/4 v0, 0x2

    invoke-static {p0, p1, v0, p2, p3}, Lcom/facebook/soloader/MinElf;->read(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;IJ)V

    .line 277
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->getShort()S

    move-result v0

    const v1, 0xffff

    and-int/2addr v0, v1

    return v0
.end method

.method private static getu32(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)J
    .locals 4
    .param p0, "fc"    # Ljava/nio/channels/FileChannel;
    .param p1, "bb"    # Ljava/nio/ByteBuffer;
    .param p2, "offset"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 270
    const/4 v0, 0x4

    invoke-static {p0, p1, v0, p2, p3}, Lcom/facebook/soloader/MinElf;->read(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;IJ)V

    .line 271
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->getInt()I

    move-result v0

    int-to-long v0, v0

    const-wide v2, 0xffffffffL

    and-long/2addr v0, v2

    return-wide v0
.end method

.method private static getu8(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;J)S
    .locals 2
    .param p0, "fc"    # Ljava/nio/channels/FileChannel;
    .param p1, "bb"    # Ljava/nio/ByteBuffer;
    .param p2, "offset"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 282
    const/4 v0, 0x1

    invoke-static {p0, p1, v0, p2, p3}, Lcom/facebook/soloader/MinElf;->read(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;IJ)V

    .line 283
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->get()B

    move-result v0

    and-int/lit16 v0, v0, 0xff

    int-to-short v0, v0

    return v0
.end method

.method private static read(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;IJ)V
    .locals 5
    .param p0, "fc"    # Ljava/nio/channels/FileChannel;
    .param p1, "bb"    # Ljava/nio/ByteBuffer;
    .param p2, "sz"    # I
    .param p3, "offset"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 244
    invoke-virtual {p1, v4}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 245
    invoke-virtual {p1, p2}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 247
    :goto_0
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v1

    if-lez v1, :cond_0

    .line 248
    invoke-virtual {p0, p1, p3, p4}, Ljava/nio/channels/FileChannel;->read(Ljava/nio/ByteBuffer;J)I

    move-result v0

    .line 249
    .local v0, "numBytesRead":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 255
    .end local v0    # "numBytesRead":I
    :cond_0
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v1

    if-lez v1, :cond_2

    .line 256
    new-instance v1, Lcom/facebook/soloader/MinElf$ElfError;

    const-string v2, "ELF file truncated"

    invoke-direct {v1, v2}, Lcom/facebook/soloader/MinElf$ElfError;-><init>(Ljava/lang/String;)V

    throw v1

    .line 252
    .restart local v0    # "numBytesRead":I
    :cond_1
    int-to-long v2, v0

    add-long/2addr p3, v2

    .line 253
    goto :goto_0

    .line 259
    .end local v0    # "numBytesRead":I
    :cond_2
    invoke-virtual {p1, v4}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 260
    return-void
.end method
