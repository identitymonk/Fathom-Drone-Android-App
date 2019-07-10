.class public Lcom/facebook/react/devsupport/StackTraceHelper;
.super Ljava/lang/Object;
.source "StackTraceHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;
    }
.end annotation


# static fields
.field public static final COLUMN_KEY:Ljava/lang/String; = "column"

.field public static final LINE_NUMBER_KEY:Ljava/lang/String; = "lineNumber"

.field private static final STACK_FRAME_PATTERN:Ljava/util/regex/Pattern;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const-string v0, "^(?:(.*?)@)?(.*?)\\:([0-9]+)\\:([0-9]+)$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/facebook/react/devsupport/StackTraceHelper;->STACK_FRAME_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    return-void
.end method

.method public static convertJavaStackTrace(Ljava/lang/Throwable;)[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    .locals 10
    .param p0, "exception"    # Ljava/lang/Throwable;

    .prologue
    .line 198
    invoke-virtual {p0}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v9

    .line 199
    .local v9, "stackTrace":[Ljava/lang/StackTraceElement;
    array-length v0, v9

    new-array v8, v0, [Lcom/facebook/react/devsupport/interfaces/StackFrame;

    .line 200
    .local v8, "result":[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    array-length v0, v9

    if-ge v7, v0, :cond_0

    .line 201
    new-instance v0, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;

    aget-object v1, v9, v7

    .line 202
    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v1

    aget-object v2, v9, v7

    .line 203
    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getFileName()Ljava/lang/String;

    move-result-object v2

    aget-object v3, v9, v7

    .line 204
    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v3

    aget-object v4, v9, v7

    .line 205
    invoke-virtual {v4}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v4

    const/4 v5, -0x1

    const/4 v6, 0x0

    invoke-direct/range {v0 .. v6}, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/facebook/react/devsupport/StackTraceHelper$1;)V

    aput-object v0, v8, v7

    .line 200
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 208
    :cond_0
    return-object v8
.end method

.method public static convertJsStackTrace(Lcom/facebook/react/bridge/ReadableArray;)[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    .locals 17
    .param p0, "stack"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 121
    if-eqz p0, :cond_3

    invoke-interface/range {p0 .. p0}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v15

    .line 122
    .local v15, "size":I
    :goto_0
    new-array v14, v15, [Lcom/facebook/react/devsupport/interfaces/StackFrame;

    .line 123
    .local v14, "result":[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    const/4 v13, 0x0

    .local v13, "i":I
    :goto_1
    if-ge v13, v15, :cond_5

    .line 124
    move-object/from16 v0, p0

    invoke-interface {v0, v13}, Lcom/facebook/react/bridge/ReadableArray;->getType(I)Lcom/facebook/react/bridge/ReadableType;

    move-result-object v16

    .line 125
    .local v16, "type":Lcom/facebook/react/bridge/ReadableType;
    sget-object v1, Lcom/facebook/react/bridge/ReadableType;->Map:Lcom/facebook/react/bridge/ReadableType;

    move-object/from16 v0, v16

    if-ne v0, v1, :cond_4

    .line 126
    move-object/from16 v0, p0

    invoke-interface {v0, v13}, Lcom/facebook/react/bridge/ReadableArray;->getMap(I)Lcom/facebook/react/bridge/ReadableMap;

    move-result-object v12

    .line 127
    .local v12, "frame":Lcom/facebook/react/bridge/ReadableMap;
    const-string v1, "methodName"

    invoke-interface {v12, v1}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 128
    .local v3, "methodName":Ljava/lang/String;
    const-string v1, "file"

    invoke-interface {v12, v1}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 129
    .local v2, "fileName":Ljava/lang/String;
    const/4 v4, -0x1

    .line 130
    .local v4, "lineNumber":I
    const-string v1, "lineNumber"

    invoke-interface {v12, v1}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "lineNumber"

    invoke-interface {v12, v1}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 131
    const-string v1, "lineNumber"

    invoke-interface {v12, v1}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v4

    .line 133
    :cond_0
    const/4 v5, -0x1

    .line 134
    .local v5, "columnNumber":I
    const-string v1, "column"

    invoke-interface {v12, v1}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string v1, "column"

    invoke-interface {v12, v1}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 135
    const-string v1, "column"

    invoke-interface {v12, v1}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v5

    .line 137
    :cond_1
    new-instance v1, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;

    const/4 v6, 0x0

    invoke-direct/range {v1 .. v6}, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;-><init>(Ljava/lang/String;Ljava/lang/String;IILcom/facebook/react/devsupport/StackTraceHelper$1;)V

    aput-object v1, v14, v13

    .line 123
    .end local v2    # "fileName":Ljava/lang/String;
    .end local v3    # "methodName":Ljava/lang/String;
    .end local v4    # "lineNumber":I
    .end local v5    # "columnNumber":I
    .end local v12    # "frame":Lcom/facebook/react/bridge/ReadableMap;
    :cond_2
    :goto_2
    add-int/lit8 v13, v13, 0x1

    goto :goto_1

    .line 121
    .end local v13    # "i":I
    .end local v14    # "result":[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    .end local v15    # "size":I
    .end local v16    # "type":Lcom/facebook/react/bridge/ReadableType;
    :cond_3
    const/4 v15, 0x0

    goto :goto_0

    .line 138
    .restart local v13    # "i":I
    .restart local v14    # "result":[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    .restart local v15    # "size":I
    .restart local v16    # "type":Lcom/facebook/react/bridge/ReadableType;
    :cond_4
    sget-object v1, Lcom/facebook/react/bridge/ReadableType;->String:Lcom/facebook/react/bridge/ReadableType;

    move-object/from16 v0, v16

    if-ne v0, v1, :cond_2

    .line 139
    new-instance v6, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;

    const/4 v7, 0x0

    move-object/from16 v0, p0

    invoke-interface {v0, v13}, Lcom/facebook/react/bridge/ReadableArray;->getString(I)Ljava/lang/String;

    move-result-object v8

    const/4 v9, -0x1

    const/4 v10, -0x1

    const/4 v11, 0x0

    invoke-direct/range {v6 .. v11}, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;-><init>(Ljava/lang/String;Ljava/lang/String;IILcom/facebook/react/devsupport/StackTraceHelper$1;)V

    aput-object v6, v14, v13

    goto :goto_2

    .line 142
    .end local v16    # "type":Lcom/facebook/react/bridge/ReadableType;
    :cond_5
    return-object v14
.end method

.method public static convertJsStackTrace(Ljava/lang/String;)[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    .locals 15
    .param p0, "stack"    # Ljava/lang/String;

    .prologue
    const/4 v14, 0x1

    const/4 v7, -0x1

    const/4 v5, 0x0

    .line 177
    const-string v0, "\n"

    invoke-virtual {p0, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v13

    .line 178
    .local v13, "stackTrace":[Ljava/lang/String;
    array-length v0, v13

    new-array v12, v0, [Lcom/facebook/react/devsupport/interfaces/StackFrame;

    .line 179
    .local v12, "result":[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_0
    array-length v0, v13

    if-ge v10, v0, :cond_2

    .line 180
    sget-object v0, Lcom/facebook/react/devsupport/StackTraceHelper;->STACK_FRAME_PATTERN:Ljava/util/regex/Pattern;

    aget-object v1, v13, v10

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v11

    .line 181
    .local v11, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v11}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 182
    new-instance v0, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;

    const/4 v1, 0x2

    .line 183
    invoke-virtual {v11, v1}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v1

    .line 184
    invoke-virtual {v11, v14}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_0

    const-string v2, "(unknown)"

    :goto_1
    const/4 v3, 0x3

    .line 185
    invoke-virtual {v11, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    const/4 v4, 0x4

    .line 186
    invoke-virtual {v11, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    invoke-direct/range {v0 .. v5}, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;-><init>(Ljava/lang/String;Ljava/lang/String;IILcom/facebook/react/devsupport/StackTraceHelper$1;)V

    aput-object v0, v12, v10

    .line 179
    :goto_2
    add-int/lit8 v10, v10, 0x1

    goto :goto_0

    .line 184
    :cond_0
    invoke-virtual {v11, v14}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 188
    :cond_1
    new-instance v4, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;

    aget-object v6, v13, v10

    move v8, v7

    move-object v9, v5

    invoke-direct/range {v4 .. v9}, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;-><init>(Ljava/lang/String;Ljava/lang/String;IILcom/facebook/react/devsupport/StackTraceHelper$1;)V

    aput-object v4, v12, v10

    goto :goto_2

    .line 191
    .end local v11    # "matcher":Ljava/util/regex/Matcher;
    :cond_2
    return-object v12
.end method

.method public static convertJsStackTrace(Lorg/json/JSONArray;)[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    .locals 11
    .param p0, "stack"    # Lorg/json/JSONArray;

    .prologue
    .line 150
    if-eqz p0, :cond_2

    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v10

    .line 151
    .local v10, "size":I
    :goto_0
    new-array v9, v10, [Lcom/facebook/react/devsupport/interfaces/StackFrame;

    .line 153
    .local v9, "result":[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_1
    if-ge v8, v10, :cond_3

    .line 154
    :try_start_0
    invoke-virtual {p0, v8}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v7

    .line 155
    .local v7, "frame":Lorg/json/JSONObject;
    const-string v0, "methodName"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 156
    .local v2, "methodName":Ljava/lang/String;
    const-string v0, "file"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 157
    .local v1, "fileName":Ljava/lang/String;
    const/4 v3, -0x1

    .line 158
    .local v3, "lineNumber":I
    const-string v0, "lineNumber"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "lineNumber"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 159
    const-string v0, "lineNumber"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v3

    .line 161
    :cond_0
    const/4 v4, -0x1

    .line 162
    .local v4, "columnNumber":I
    const-string v0, "column"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "column"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 163
    const-string v0, "column"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    .line 165
    :cond_1
    new-instance v0, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/facebook/react/devsupport/StackTraceHelper$StackFrameImpl;-><init>(Ljava/lang/String;Ljava/lang/String;IILcom/facebook/react/devsupport/StackTraceHelper$1;)V

    aput-object v0, v9, v8
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 153
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 150
    .end local v1    # "fileName":Ljava/lang/String;
    .end local v2    # "methodName":Ljava/lang/String;
    .end local v3    # "lineNumber":I
    .end local v4    # "columnNumber":I
    .end local v7    # "frame":Lorg/json/JSONObject;
    .end local v8    # "i":I
    .end local v9    # "result":[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    .end local v10    # "size":I
    :cond_2
    const/4 v10, 0x0

    goto :goto_0

    .line 167
    .restart local v8    # "i":I
    .restart local v9    # "result":[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    .restart local v10    # "size":I
    :catch_0
    move-exception v6

    .line 168
    .local v6, "exception":Lorg/json/JSONException;
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0, v6}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v0

    .line 170
    .end local v6    # "exception":Lorg/json/JSONException;
    :cond_3
    return-object v9
.end method

.method public static formatFrameSource(Lcom/facebook/react/devsupport/interfaces/StackFrame;)Ljava/lang/String;
    .locals 4
    .param p0, "frame"    # Lcom/facebook/react/devsupport/interfaces/StackFrame;

    .prologue
    .line 215
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 216
    .local v2, "lineInfo":Ljava/lang/StringBuilder;
    invoke-interface {p0}, Lcom/facebook/react/devsupport/interfaces/StackFrame;->getFileName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 217
    invoke-interface {p0}, Lcom/facebook/react/devsupport/interfaces/StackFrame;->getLine()I

    move-result v1

    .line 218
    .local v1, "line":I
    if-lez v1, :cond_0

    .line 219
    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 220
    invoke-interface {p0}, Lcom/facebook/react/devsupport/interfaces/StackFrame;->getColumn()I

    move-result v0

    .line 221
    .local v0, "column":I
    if-lez v0, :cond_0

    .line 222
    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 225
    .end local v0    # "column":I
    :cond_0
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public static formatStackTrace(Ljava/lang/String;[Lcom/facebook/react/devsupport/interfaces/StackFrame;)Ljava/lang/String;
    .locals 6
    .param p0, "title"    # Ljava/lang/String;
    .param p1, "stack"    # [Lcom/facebook/react/devsupport/interfaces/StackFrame;

    .prologue
    .line 232
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 233
    .local v1, "stackTrace":Ljava/lang/StringBuilder;
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 234
    array-length v3, p1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v0, p1, v2

    .line 235
    .local v0, "frame":Lcom/facebook/react/devsupport/interfaces/StackFrame;
    invoke-interface {v0}, Lcom/facebook/react/devsupport/interfaces/StackFrame;->getMethod()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n"

    .line 236
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "    "

    .line 237
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 238
    invoke-static {v0}, Lcom/facebook/react/devsupport/StackTraceHelper;->formatFrameSource(Lcom/facebook/react/devsupport/interfaces/StackFrame;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n"

    .line 239
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 234
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 242
    .end local v0    # "frame":Lcom/facebook/react/devsupport/interfaces/StackFrame;
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
