.class Lcom/facebook/react/bridge/JavaOnlyMap$1;
.super Ljava/lang/Object;
.source "JavaOnlyMap.java"

# interfaces
.implements Lcom/facebook/react/bridge/ReadableMapKeySetIterator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/bridge/JavaOnlyMap;->keySetIterator()Lcom/facebook/react/bridge/ReadableMapKeySetIterator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field mIterator:Ljava/util/Iterator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Iterator",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/facebook/react/bridge/JavaOnlyMap;


# direct methods
.method constructor <init>(Lcom/facebook/react/bridge/JavaOnlyMap;)V
    .locals 1
    .param p1, "this$0"    # Lcom/facebook/react/bridge/JavaOnlyMap;

    .prologue
    .line 121
    iput-object p1, p0, Lcom/facebook/react/bridge/JavaOnlyMap$1;->this$0:Lcom/facebook/react/bridge/JavaOnlyMap;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 122
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyMap$1;->this$0:Lcom/facebook/react/bridge/JavaOnlyMap;

    invoke-static {v0}, Lcom/facebook/react/bridge/JavaOnlyMap;->access$000(Lcom/facebook/react/bridge/JavaOnlyMap;)Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyMap$1;->mIterator:Ljava/util/Iterator;

    return-void
.end method


# virtual methods
.method public hasNextKey()Z
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyMap$1;->mIterator:Ljava/util/Iterator;

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    return v0
.end method

.method public nextKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyMap$1;->mIterator:Ljava/util/Iterator;

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method
