.class Lcom/facebook/cache/disk/DefaultEntryEvictionComparatorSupplier$1;
.super Ljava/lang/Object;
.source "DefaultEntryEvictionComparatorSupplier.java"

# interfaces
.implements Lcom/facebook/cache/disk/EntryEvictionComparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/cache/disk/DefaultEntryEvictionComparatorSupplier;->get()Lcom/facebook/cache/disk/EntryEvictionComparator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/cache/disk/DefaultEntryEvictionComparatorSupplier;


# direct methods
.method constructor <init>(Lcom/facebook/cache/disk/DefaultEntryEvictionComparatorSupplier;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/cache/disk/DefaultEntryEvictionComparatorSupplier;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/facebook/cache/disk/DefaultEntryEvictionComparatorSupplier$1;->this$0:Lcom/facebook/cache/disk/DefaultEntryEvictionComparatorSupplier;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/facebook/cache/disk/DiskStorage$Entry;Lcom/facebook/cache/disk/DiskStorage$Entry;)I
    .locals 5
    .param p1, "e1"    # Lcom/facebook/cache/disk/DiskStorage$Entry;
    .param p2, "e2"    # Lcom/facebook/cache/disk/DiskStorage$Entry;

    .prologue
    .line 21
    invoke-interface {p1}, Lcom/facebook/cache/disk/DiskStorage$Entry;->getTimestamp()J

    move-result-wide v0

    .line 22
    .local v0, "time1":J
    invoke-interface {p2}, Lcom/facebook/cache/disk/DiskStorage$Entry;->getTimestamp()J

    move-result-wide v2

    .line 23
    .local v2, "time2":J
    cmp-long v4, v0, v2

    if-gez v4, :cond_0

    const/4 v4, -0x1

    :goto_0
    return v4

    :cond_0
    cmp-long v4, v2, v0

    if-nez v4, :cond_1

    const/4 v4, 0x0

    goto :goto_0

    :cond_1
    const/4 v4, 0x1

    goto :goto_0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 18
    check-cast p1, Lcom/facebook/cache/disk/DiskStorage$Entry;

    check-cast p2, Lcom/facebook/cache/disk/DiskStorage$Entry;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/cache/disk/DefaultEntryEvictionComparatorSupplier$1;->compare(Lcom/facebook/cache/disk/DiskStorage$Entry;Lcom/facebook/cache/disk/DiskStorage$Entry;)I

    move-result v0

    return v0
.end method
