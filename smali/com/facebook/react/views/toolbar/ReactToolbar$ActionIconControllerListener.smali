.class Lcom/facebook/react/views/toolbar/ReactToolbar$ActionIconControllerListener;
.super Lcom/facebook/react/views/toolbar/ReactToolbar$IconControllerListener;
.source "ReactToolbar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/toolbar/ReactToolbar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ActionIconControllerListener"
.end annotation


# instance fields
.field private final mItem:Landroid/view/MenuItem;

.field final synthetic this$0:Lcom/facebook/react/views/toolbar/ReactToolbar;


# direct methods
.method constructor <init>(Lcom/facebook/react/views/toolbar/ReactToolbar;Landroid/view/MenuItem;Lcom/facebook/drawee/view/DraweeHolder;)V
    .locals 0
    .param p2, "item"    # Landroid/view/MenuItem;
    .param p3, "holder"    # Lcom/facebook/drawee/view/DraweeHolder;

    .prologue
    .line 94
    iput-object p1, p0, Lcom/facebook/react/views/toolbar/ReactToolbar$ActionIconControllerListener;->this$0:Lcom/facebook/react/views/toolbar/ReactToolbar;

    .line 95
    invoke-direct {p0, p1, p3}, Lcom/facebook/react/views/toolbar/ReactToolbar$IconControllerListener;-><init>(Lcom/facebook/react/views/toolbar/ReactToolbar;Lcom/facebook/drawee/view/DraweeHolder;)V

    .line 96
    iput-object p2, p0, Lcom/facebook/react/views/toolbar/ReactToolbar$ActionIconControllerListener;->mItem:Landroid/view/MenuItem;

    .line 97
    return-void
.end method


# virtual methods
.method protected setDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 101
    iget-object v0, p0, Lcom/facebook/react/views/toolbar/ReactToolbar$ActionIconControllerListener;->mItem:Landroid/view/MenuItem;

    invoke-interface {v0, p1}, Landroid/view/MenuItem;->setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;

    .line 102
    iget-object v0, p0, Lcom/facebook/react/views/toolbar/ReactToolbar$ActionIconControllerListener;->this$0:Lcom/facebook/react/views/toolbar/ReactToolbar;

    invoke-virtual {v0}, Lcom/facebook/react/views/toolbar/ReactToolbar;->requestLayout()V

    .line 103
    return-void
.end method
