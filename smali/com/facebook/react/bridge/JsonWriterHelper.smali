.class Lcom/facebook/react/bridge/JsonWriterHelper;
.super Ljava/lang/Object;
.source "JsonWriterHelper.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static listValue(Lcom/facebook/react/bridge/JsonWriter;Ljava/util/List;)V
    .locals 3
    .param p0, "writer"    # Lcom/facebook/react/bridge/JsonWriter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/react/bridge/JsonWriter;",
            "Ljava/util/List",
            "<*>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 40
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<*>;"
    invoke-virtual {p0}, Lcom/facebook/react/bridge/JsonWriter;->beginArray()Lcom/facebook/react/bridge/JsonWriter;

    .line 41
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    .line 42
    .local v0, "item":Ljava/lang/Object;
    invoke-static {p0, v0}, Lcom/facebook/react/bridge/JsonWriterHelper;->objectValue(Lcom/facebook/react/bridge/JsonWriter;Ljava/lang/Object;)V

    goto :goto_0

    .line 44
    .end local v0    # "item":Ljava/lang/Object;
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/bridge/JsonWriter;->endArray()Lcom/facebook/react/bridge/JsonWriter;

    .line 45
    return-void
.end method

.method private static mapValue(Lcom/facebook/react/bridge/JsonWriter;Ljava/util/Map;)V
    .locals 3
    .param p0, "writer"    # Lcom/facebook/react/bridge/JsonWriter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/react/bridge/JsonWriter;",
            "Ljava/util/Map",
            "<**>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<**>;"
    invoke-virtual {p0}, Lcom/facebook/react/bridge/JsonWriter;->beginObject()Lcom/facebook/react/bridge/JsonWriter;

    .line 32
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 33
    .local v0, "entry":Ljava/util/Map$Entry;
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/facebook/react/bridge/JsonWriter;->name(Ljava/lang/String;)Lcom/facebook/react/bridge/JsonWriter;

    .line 34
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-static {p0, v2}, Lcom/facebook/react/bridge/JsonWriterHelper;->value(Lcom/facebook/react/bridge/JsonWriter;Ljava/lang/Object;)V

    goto :goto_0

    .line 36
    .end local v0    # "entry":Ljava/util/Map$Entry;
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/bridge/JsonWriter;->endObject()Lcom/facebook/react/bridge/JsonWriter;

    .line 37
    return-void
.end method

.method private static objectValue(Lcom/facebook/react/bridge/JsonWriter;Ljava/lang/Object;)V
    .locals 3
    .param p0, "writer"    # Lcom/facebook/react/bridge/JsonWriter;
    .param p1, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 48
    if-nez p1, :cond_0

    .line 49
    invoke-virtual {p0}, Lcom/facebook/react/bridge/JsonWriter;->nullValue()Lcom/facebook/react/bridge/JsonWriter;

    .line 59
    .end local p1    # "value":Ljava/lang/Object;
    :goto_0
    return-void

    .line 50
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_0
    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 51
    check-cast p1, Ljava/lang/String;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/facebook/react/bridge/JsonWriter;->value(Ljava/lang/String;)Lcom/facebook/react/bridge/JsonWriter;

    goto :goto_0

    .line 52
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_1
    instance-of v0, p1, Ljava/lang/Number;

    if-eqz v0, :cond_2

    .line 53
    check-cast p1, Ljava/lang/Number;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/facebook/react/bridge/JsonWriter;->value(Ljava/lang/Number;)Lcom/facebook/react/bridge/JsonWriter;

    goto :goto_0

    .line 54
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_2
    instance-of v0, p1, Ljava/lang/Boolean;

    if-eqz v0, :cond_3

    .line 55
    check-cast p1, Ljava/lang/Boolean;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/facebook/react/bridge/JsonWriter;->value(Z)Lcom/facebook/react/bridge/JsonWriter;

    goto :goto_0

    .line 57
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_3
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown value: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static value(Lcom/facebook/react/bridge/JsonWriter;Ljava/lang/Object;)V
    .locals 1
    .param p0, "writer"    # Lcom/facebook/react/bridge/JsonWriter;
    .param p1, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    instance-of v0, p1, Ljava/util/Map;

    if-eqz v0, :cond_0

    .line 22
    check-cast p1, Ljava/util/Map;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-static {p0, p1}, Lcom/facebook/react/bridge/JsonWriterHelper;->mapValue(Lcom/facebook/react/bridge/JsonWriter;Ljava/util/Map;)V

    .line 28
    :goto_0
    return-void

    .line 23
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_0
    instance-of v0, p1, Ljava/util/List;

    if-eqz v0, :cond_1

    .line 24
    check-cast p1, Ljava/util/List;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-static {p0, p1}, Lcom/facebook/react/bridge/JsonWriterHelper;->listValue(Lcom/facebook/react/bridge/JsonWriter;Ljava/util/List;)V

    goto :goto_0

    .line 26
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_1
    invoke-static {p0, p1}, Lcom/facebook/react/bridge/JsonWriterHelper;->objectValue(Lcom/facebook/react/bridge/JsonWriter;Ljava/lang/Object;)V

    goto :goto_0
.end method
