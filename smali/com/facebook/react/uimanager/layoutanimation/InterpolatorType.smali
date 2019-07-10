.class final enum Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;
.super Ljava/lang/Enum;
.source "InterpolatorType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

.field public static final enum EASE_IN:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

.field public static final enum EASE_IN_EASE_OUT:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

.field public static final enum EASE_OUT:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

.field public static final enum LINEAR:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

.field public static final enum SPRING:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;


# instance fields
.field private final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 9
    new-instance v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    const-string v1, "LINEAR"

    const-string v2, "linear"

    invoke-direct {v0, v1, v3, v2}, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->LINEAR:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    .line 10
    new-instance v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    const-string v1, "EASE_IN"

    const-string v2, "easeIn"

    invoke-direct {v0, v1, v4, v2}, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->EASE_IN:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    .line 11
    new-instance v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    const-string v1, "EASE_OUT"

    const-string v2, "easeOut"

    invoke-direct {v0, v1, v5, v2}, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->EASE_OUT:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    .line 12
    new-instance v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    const-string v1, "EASE_IN_EASE_OUT"

    const-string v2, "easeInEaseOut"

    invoke-direct {v0, v1, v6, v2}, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->EASE_IN_EASE_OUT:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    .line 13
    new-instance v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    const-string v1, "SPRING"

    const-string v2, "spring"

    invoke-direct {v0, v1, v7, v2}, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->SPRING:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    .line 8
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    sget-object v1, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->LINEAR:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->EASE_IN:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->EASE_OUT:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->EASE_IN_EASE_OUT:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->SPRING:Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    aput-object v1, v0, v7

    sput-object v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->$VALUES:[Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 18
    iput-object p3, p0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->mName:Ljava/lang/String;

    .line 19
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;
    .locals 5
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 22
    invoke-static {}, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->values()[Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    move-result-object v2

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 23
    .local v0, "type":Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;
    invoke-virtual {v0}, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 24
    return-object v0

    .line 22
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 27
    .end local v0    # "type":Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;
    :cond_1
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unsupported interpolation type : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 8
    const-class v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    return-object v0
.end method

.method public static values()[Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;
    .locals 1

    .prologue
    .line 8
    sget-object v0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->$VALUES:[Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    invoke-virtual {v0}, [Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;->mName:Ljava/lang/String;

    return-object v0
.end method
