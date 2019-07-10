.class Lcom/facebook/react/animated/NativeAnimatedModule$4;
.super Ljava/lang/Object;
.source "NativeAnimatedModule.java"

# interfaces
.implements Lcom/facebook/react/animated/NativeAnimatedModule$UIThreadOperation;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/animated/NativeAnimatedModule;->startListeningToAnimatedNodeValue(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/animated/NativeAnimatedModule;

.field final synthetic val$listener:Lcom/facebook/react/animated/AnimatedNodeValueListener;

.field final synthetic val$tag:I


# direct methods
.method constructor <init>(Lcom/facebook/react/animated/NativeAnimatedModule;ILcom/facebook/react/animated/AnimatedNodeValueListener;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/animated/NativeAnimatedModule;

    .prologue
    .line 211
    iput-object p1, p0, Lcom/facebook/react/animated/NativeAnimatedModule$4;->this$0:Lcom/facebook/react/animated/NativeAnimatedModule;

    iput p2, p0, Lcom/facebook/react/animated/NativeAnimatedModule$4;->val$tag:I

    iput-object p3, p0, Lcom/facebook/react/animated/NativeAnimatedModule$4;->val$listener:Lcom/facebook/react/animated/AnimatedNodeValueListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public execute(Lcom/facebook/react/animated/NativeAnimatedNodesManager;)V
    .locals 2
    .param p1, "animatedNodesManager"    # Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    .prologue
    .line 214
    iget v0, p0, Lcom/facebook/react/animated/NativeAnimatedModule$4;->val$tag:I

    iget-object v1, p0, Lcom/facebook/react/animated/NativeAnimatedModule$4;->val$listener:Lcom/facebook/react/animated/AnimatedNodeValueListener;

    invoke-virtual {p1, v0, v1}, Lcom/facebook/react/animated/NativeAnimatedNodesManager;->startListeningToAnimatedNodeValue(ILcom/facebook/react/animated/AnimatedNodeValueListener;)V

    .line 215
    return-void
.end method
