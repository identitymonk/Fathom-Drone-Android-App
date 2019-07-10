.class Lcom/facebook/react/devsupport/RedBoxDialog$StackAdapter$FrameViewHolder;
.super Ljava/lang/Object;
.source "RedBoxDialog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/devsupport/RedBoxDialog$StackAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FrameViewHolder"
.end annotation


# instance fields
.field private final mFileView:Landroid/widget/TextView;

.field private final mMethodView:Landroid/widget/TextView;


# direct methods
.method private constructor <init>(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 121
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 122
    sget v0, Lcom/facebook/react/R$id;->rn_frame_method:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/facebook/react/devsupport/RedBoxDialog$StackAdapter$FrameViewHolder;->mMethodView:Landroid/widget/TextView;

    .line 123
    sget v0, Lcom/facebook/react/R$id;->rn_frame_file:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/facebook/react/devsupport/RedBoxDialog$StackAdapter$FrameViewHolder;->mFileView:Landroid/widget/TextView;

    .line 124
    return-void
.end method

.method synthetic constructor <init>(Landroid/view/View;Lcom/facebook/react/devsupport/RedBoxDialog$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/view/View;
    .param p2, "x1"    # Lcom/facebook/react/devsupport/RedBoxDialog$1;

    .prologue
    .line 117
    invoke-direct {p0, p1}, Lcom/facebook/react/devsupport/RedBoxDialog$StackAdapter$FrameViewHolder;-><init>(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$1000(Lcom/facebook/react/devsupport/RedBoxDialog$StackAdapter$FrameViewHolder;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/devsupport/RedBoxDialog$StackAdapter$FrameViewHolder;

    .prologue
    .line 117
    iget-object v0, p0, Lcom/facebook/react/devsupport/RedBoxDialog$StackAdapter$FrameViewHolder;->mFileView:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$900(Lcom/facebook/react/devsupport/RedBoxDialog$StackAdapter$FrameViewHolder;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/devsupport/RedBoxDialog$StackAdapter$FrameViewHolder;

    .prologue
    .line 117
    iget-object v0, p0, Lcom/facebook/react/devsupport/RedBoxDialog$StackAdapter$FrameViewHolder;->mMethodView:Landroid/widget/TextView;

    return-object v0
.end method
