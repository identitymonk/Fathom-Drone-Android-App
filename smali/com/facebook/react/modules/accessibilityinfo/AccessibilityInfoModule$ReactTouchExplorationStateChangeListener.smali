.class Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule$ReactTouchExplorationStateChangeListener;
.super Ljava/lang/Object;
.source "AccessibilityInfoModule.java"

# interfaces
.implements Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x13
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ReactTouchExplorationStateChangeListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule;


# direct methods
.method private constructor <init>(Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule$ReactTouchExplorationStateChangeListener;->this$0:Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule;Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule;
    .param p2, "x1"    # Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule$1;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule$ReactTouchExplorationStateChangeListener;-><init>(Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule;)V

    return-void
.end method


# virtual methods
.method public onTouchExplorationStateChanged(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 34
    iget-object v0, p0, Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule$ReactTouchExplorationStateChangeListener;->this$0:Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule;

    invoke-static {v0, p1}, Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule;->access$000(Lcom/facebook/react/modules/accessibilityinfo/AccessibilityInfoModule;Z)V

    .line 35
    return-void
.end method
