.class public Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout;
.super Landroid/widget/FrameLayout;
.source "SizeMonitoringFrameLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout$OnSizeChangedListener;
    }
.end annotation


# instance fields
.field private mOnSizeChangedListener:Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout$OnSizeChangedListener;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 32
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 33
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 36
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 37
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 40
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 41
    return-void
.end method


# virtual methods
.method protected onSizeChanged(IIII)V
    .locals 1
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 49
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/FrameLayout;->onSizeChanged(IIII)V

    .line 51
    iget-object v0, p0, Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout;->mOnSizeChangedListener:Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout$OnSizeChangedListener;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout;->mOnSizeChangedListener:Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout$OnSizeChangedListener;

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout$OnSizeChangedListener;->onSizeChanged(IIII)V

    .line 54
    :cond_0
    return-void
.end method

.method public setOnSizeChangedListener(Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout$OnSizeChangedListener;)V
    .locals 0
    .param p1, "onSizeChangedListener"    # Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout$OnSizeChangedListener;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout;->mOnSizeChangedListener:Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout$OnSizeChangedListener;

    .line 45
    return-void
.end method
