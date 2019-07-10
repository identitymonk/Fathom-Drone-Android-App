.class final Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;
.super Ljava/lang/Object;
.source "FlatUIViewOperationQueue.java"

# interfaces
.implements Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/flat/FlatUIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "SetPadding"
.end annotation


# instance fields
.field private final mPaddingBottom:I

.field private final mPaddingLeft:I

.field private final mPaddingRight:I

.field private final mPaddingTop:I

.field private final mReactTag:I

.field final synthetic this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IIIII)V
    .locals 0
    .param p2, "reactTag"    # I
    .param p3, "paddingLeft"    # I
    .param p4, "paddingTop"    # I
    .param p5, "paddingRight"    # I
    .param p6, "paddingBottom"    # I

    .prologue
    .line 186
    iput-object p1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 187
    iput p2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->mReactTag:I

    .line 188
    iput p3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->mPaddingLeft:I

    .line 189
    iput p4, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->mPaddingTop:I

    .line 190
    iput p5, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->mPaddingRight:I

    .line 191
    iput p6, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->mPaddingBottom:I

    .line 192
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IIIIILcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    .param p2, "x1"    # I
    .param p3, "x2"    # I
    .param p4, "x3"    # I
    .param p5, "x4"    # I
    .param p6, "x5"    # I
    .param p7, "x6"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;

    .prologue
    .line 173
    invoke-direct/range {p0 .. p6}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IIIII)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 6

    .prologue
    .line 196
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->mReactTag:I

    iget v2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->mPaddingLeft:I

    iget v3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->mPaddingTop:I

    iget v4, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->mPaddingRight:I

    iget v5, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;->mPaddingBottom:I

    invoke-virtual/range {v0 .. v5}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->setPadding(IIIII)V

    .line 202
    return-void
.end method
