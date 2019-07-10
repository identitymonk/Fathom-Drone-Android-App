.class Lcom/facebook/react/devsupport/WindowOverlayCompat;
.super Ljava/lang/Object;
.source "WindowOverlayCompat.java"


# static fields
.field private static final ANDROID_OREO:I = 0x1a

.field private static final TYPE_APPLICATION_OVERLAY:I = 0x7f6

.field static final TYPE_SYSTEM_ALERT:I

.field static final TYPE_SYSTEM_OVERLAY:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/16 v1, 0x7f6

    const/16 v2, 0x1a

    .line 15
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge v0, v2, :cond_1

    const/16 v0, 0x7d3

    :goto_0
    sput v0, Lcom/facebook/react/devsupport/WindowOverlayCompat;->TYPE_SYSTEM_ALERT:I

    .line 16
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge v0, v2, :cond_0

    const/16 v1, 0x7d6

    :cond_0
    sput v1, Lcom/facebook/react/devsupport/WindowOverlayCompat;->TYPE_SYSTEM_OVERLAY:I

    return-void

    :cond_1
    move v0, v1

    .line 15
    goto :goto_0
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
