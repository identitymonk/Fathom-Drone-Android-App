.class public final enum Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;
.super Ljava/lang/Enum;
.source "MessageQueueThreadSpec.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401c
    name = "ThreadType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

.field public static final enum MAIN_UI:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

.field public static final enum NEW_BACKGROUND:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 24
    new-instance v0, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    const-string v1, "MAIN_UI"

    invoke-direct {v0, v1, v2}, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;->MAIN_UI:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    .line 25
    new-instance v0, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    const-string v1, "NEW_BACKGROUND"

    invoke-direct {v0, v1, v3}, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;->NEW_BACKGROUND:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    .line 23
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    sget-object v1, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;->MAIN_UI:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;->NEW_BACKGROUND:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;->$VALUES:[Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 23
    const-class v0, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    return-object v0
.end method

.method public static values()[Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;->$VALUES:[Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    invoke-virtual {v0}, [Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;

    return-object v0
.end method
