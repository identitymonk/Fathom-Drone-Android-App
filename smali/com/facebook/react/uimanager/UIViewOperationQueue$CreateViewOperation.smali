.class final Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;
.source "UIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "CreateViewOperation"
.end annotation


# instance fields
.field private final mClassName:Ljava/lang/String;

.field private final mInitialProps:Lcom/facebook/react/uimanager/ReactStylesDiffMap;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mThemedContext:Lcom/facebook/react/uimanager/ThemedReactContext;

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method public constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/uimanager/ThemedReactContext;ILjava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 4
    .param p2, "themedContext"    # Lcom/facebook/react/uimanager/ThemedReactContext;
    .param p3, "tag"    # I
    .param p4, "className"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p5, "initialProps"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;

    .prologue
    .line 142
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 143
    invoke-direct {p0, p1, p3}, Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I)V

    .line 144
    iput-object p2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;->mThemedContext:Lcom/facebook/react/uimanager/ThemedReactContext;

    .line 145
    iput-object p4, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;->mClassName:Ljava/lang/String;

    .line 146
    iput-object p5, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;->mInitialProps:Lcom/facebook/react/uimanager/ReactStylesDiffMap;

    .line 147
    const-wide/16 v0, 0x0

    const-string v2, "createView"

    iget v3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;->mTag:I

    invoke-static {v0, v1, v2, v3}, Lcom/facebook/systrace/Systrace;->startAsyncFlow(JLjava/lang/String;I)V

    .line 148
    return-void
.end method


# virtual methods
.method public execute()V
    .locals 5

    .prologue
    .line 152
    const-wide/16 v0, 0x0

    const-string v2, "createView"

    iget v3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;->mTag:I

    invoke-static {v0, v1, v2, v3}, Lcom/facebook/systrace/Systrace;->endAsyncFlow(JLjava/lang/String;I)V

    .line 153
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;->mThemedContext:Lcom/facebook/react/uimanager/ThemedReactContext;

    iget v2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;->mTag:I

    iget-object v3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;->mClassName:Ljava/lang/String;

    iget-object v4, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$CreateViewOperation;->mInitialProps:Lcom/facebook/react/uimanager/ReactStylesDiffMap;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->createView(Lcom/facebook/react/uimanager/ThemedReactContext;ILjava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 158
    return-void
.end method
