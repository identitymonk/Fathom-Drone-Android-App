.class public Lcom/facebook/debug/tags/ReactDebugOverlayTags;
.super Ljava/lang/Object;
.source "ReactDebugOverlayTags.java"


# static fields
.field public static final BRIDGE_CALLS:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

.field public static final NATIVE_MODULE:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

.field public static final NAVIGATION:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

.field public static final PERFORMANCE:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

.field public static final RELAY:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

.field public static final RN_CORE:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

.field public static final UI_MANAGER:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/16 v7, 0x80

    const/4 v6, 0x0

    .line 11
    new-instance v0, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    const-string v1, "Performance"

    const-string v2, "Markers for Performance"

    const v3, -0xff0100

    invoke-direct {v0, v1, v2, v3}, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/debug/tags/ReactDebugOverlayTags;->PERFORMANCE:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    .line 13
    new-instance v0, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    const-string v1, "Navigation"

    const-string v2, "Tag for navigation"

    const/16 v3, 0x9c

    const/16 v4, 0x27

    const/16 v5, 0xb0

    .line 14
    invoke-static {v3, v4, v5}, Landroid/graphics/Color;->rgb(III)I

    move-result v3

    invoke-direct {v0, v1, v2, v3}, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/debug/tags/ReactDebugOverlayTags;->NAVIGATION:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    .line 15
    new-instance v0, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    const-string v1, "RN Core"

    const-string v2, "Tag for React Native Core"

    const/high16 v3, -0x1000000

    invoke-direct {v0, v1, v2, v3}, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/debug/tags/ReactDebugOverlayTags;->RN_CORE:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    .line 17
    new-instance v0, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    const-string v1, "Bridge Calls"

    const-string v2, "JS to Java calls (warning: this is spammy)"

    const v3, -0xff01

    invoke-direct {v0, v1, v2, v3}, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/debug/tags/ReactDebugOverlayTags;->BRIDGE_CALLS:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    .line 20
    new-instance v0, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    const-string v1, "Native Module"

    const-string v2, "Native Module init"

    .line 21
    invoke-static {v7, v6, v7}, Landroid/graphics/Color;->rgb(III)I

    move-result v3

    invoke-direct {v0, v1, v2, v3}, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/debug/tags/ReactDebugOverlayTags;->NATIVE_MODULE:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    .line 22
    new-instance v0, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    const-string v1, "UI Manager"

    const-string v2, "UI Manager View Operations (requires restart\nwarning: this is spammy)"

    const v3, -0xff0001

    invoke-direct {v0, v1, v2, v3}, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/debug/tags/ReactDebugOverlayTags;->UI_MANAGER:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    .line 27
    new-instance v0, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    const-string v1, "Relay"

    const-string v2, "including prefetching"

    const/16 v3, 0xff

    const/16 v4, 0x99

    .line 28
    invoke-static {v3, v4, v6}, Landroid/graphics/Color;->rgb(III)I

    move-result v3

    invoke-direct {v0, v1, v2, v3}, Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/debug/tags/ReactDebugOverlayTags;->RELAY:Lcom/facebook/debug/debugoverlay/model/DebugOverlayTag;

    .line 27
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
