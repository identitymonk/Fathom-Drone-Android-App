.class public final enum Lcom/facebook/react/views/scroll/ScrollEventType;
.super Ljava/lang/Enum;
.source "ScrollEventType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/facebook/react/views/scroll/ScrollEventType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/facebook/react/views/scroll/ScrollEventType;

.field public static final enum BEGIN_DRAG:Lcom/facebook/react/views/scroll/ScrollEventType;

.field public static final enum END_DRAG:Lcom/facebook/react/views/scroll/ScrollEventType;

.field public static final enum MOMENTUM_BEGIN:Lcom/facebook/react/views/scroll/ScrollEventType;

.field public static final enum MOMENTUM_END:Lcom/facebook/react/views/scroll/ScrollEventType;

.field public static final enum SCROLL:Lcom/facebook/react/views/scroll/ScrollEventType;


# instance fields
.field private final mJSEventName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 16
    new-instance v0, Lcom/facebook/react/views/scroll/ScrollEventType;

    const-string v1, "BEGIN_DRAG"

    const-string v2, "topScrollBeginDrag"

    invoke-direct {v0, v1, v3, v2}, Lcom/facebook/react/views/scroll/ScrollEventType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/facebook/react/views/scroll/ScrollEventType;->BEGIN_DRAG:Lcom/facebook/react/views/scroll/ScrollEventType;

    .line 17
    new-instance v0, Lcom/facebook/react/views/scroll/ScrollEventType;

    const-string v1, "END_DRAG"

    const-string v2, "topScrollEndDrag"

    invoke-direct {v0, v1, v4, v2}, Lcom/facebook/react/views/scroll/ScrollEventType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/facebook/react/views/scroll/ScrollEventType;->END_DRAG:Lcom/facebook/react/views/scroll/ScrollEventType;

    .line 18
    new-instance v0, Lcom/facebook/react/views/scroll/ScrollEventType;

    const-string v1, "SCROLL"

    const-string v2, "topScroll"

    invoke-direct {v0, v1, v5, v2}, Lcom/facebook/react/views/scroll/ScrollEventType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/facebook/react/views/scroll/ScrollEventType;->SCROLL:Lcom/facebook/react/views/scroll/ScrollEventType;

    .line 19
    new-instance v0, Lcom/facebook/react/views/scroll/ScrollEventType;

    const-string v1, "MOMENTUM_BEGIN"

    const-string v2, "topMomentumScrollBegin"

    invoke-direct {v0, v1, v6, v2}, Lcom/facebook/react/views/scroll/ScrollEventType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/facebook/react/views/scroll/ScrollEventType;->MOMENTUM_BEGIN:Lcom/facebook/react/views/scroll/ScrollEventType;

    .line 20
    new-instance v0, Lcom/facebook/react/views/scroll/ScrollEventType;

    const-string v1, "MOMENTUM_END"

    const-string v2, "topMomentumScrollEnd"

    invoke-direct {v0, v1, v7, v2}, Lcom/facebook/react/views/scroll/ScrollEventType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/facebook/react/views/scroll/ScrollEventType;->MOMENTUM_END:Lcom/facebook/react/views/scroll/ScrollEventType;

    .line 15
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/facebook/react/views/scroll/ScrollEventType;

    sget-object v1, Lcom/facebook/react/views/scroll/ScrollEventType;->BEGIN_DRAG:Lcom/facebook/react/views/scroll/ScrollEventType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/facebook/react/views/scroll/ScrollEventType;->END_DRAG:Lcom/facebook/react/views/scroll/ScrollEventType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/facebook/react/views/scroll/ScrollEventType;->SCROLL:Lcom/facebook/react/views/scroll/ScrollEventType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/facebook/react/views/scroll/ScrollEventType;->MOMENTUM_BEGIN:Lcom/facebook/react/views/scroll/ScrollEventType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/facebook/react/views/scroll/ScrollEventType;->MOMENTUM_END:Lcom/facebook/react/views/scroll/ScrollEventType;

    aput-object v1, v0, v7

    sput-object v0, Lcom/facebook/react/views/scroll/ScrollEventType;->$VALUES:[Lcom/facebook/react/views/scroll/ScrollEventType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "jsEventName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 25
    iput-object p3, p0, Lcom/facebook/react/views/scroll/ScrollEventType;->mJSEventName:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/facebook/react/views/scroll/ScrollEventType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 15
    const-class v0, Lcom/facebook/react/views/scroll/ScrollEventType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/views/scroll/ScrollEventType;

    return-object v0
.end method

.method public static values()[Lcom/facebook/react/views/scroll/ScrollEventType;
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/facebook/react/views/scroll/ScrollEventType;->$VALUES:[Lcom/facebook/react/views/scroll/ScrollEventType;

    invoke-virtual {v0}, [Lcom/facebook/react/views/scroll/ScrollEventType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/facebook/react/views/scroll/ScrollEventType;

    return-object v0
.end method


# virtual methods
.method public getJSEventName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/facebook/react/views/scroll/ScrollEventType;->mJSEventName:Ljava/lang/String;

    return-object v0
.end method
