.class public Lcom/facebook/quicklog/identifiers/ActionId;
.super Ljava/lang/Object;
.source "ActionId.java"


# static fields
.field public static CANCEL:S

.field public static DRAW_COMPLETE:S

.field public static ERROR:S

.field public static FAIL:S

.field public static FINALLY:S

.field public static PAUSE:S

.field public static QUEUED:S

.field public static RESUME:S

.field public static START:S

.field public static SUCCESS:S

.field public static UNDEFINED:S


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 19
    sput-short v0, Lcom/facebook/quicklog/identifiers/ActionId;->UNDEFINED:S

    .line 22
    sput-short v0, Lcom/facebook/quicklog/identifiers/ActionId;->START:S

    .line 25
    sput-short v0, Lcom/facebook/quicklog/identifiers/ActionId;->SUCCESS:S

    .line 28
    sput-short v0, Lcom/facebook/quicklog/identifiers/ActionId;->FAIL:S

    .line 31
    sput-short v0, Lcom/facebook/quicklog/identifiers/ActionId;->CANCEL:S

    .line 34
    sput-short v0, Lcom/facebook/quicklog/identifiers/ActionId;->DRAW_COMPLETE:S

    .line 37
    sput-short v0, Lcom/facebook/quicklog/identifiers/ActionId;->PAUSE:S

    .line 40
    sput-short v0, Lcom/facebook/quicklog/identifiers/ActionId;->RESUME:S

    .line 43
    sput-short v0, Lcom/facebook/quicklog/identifiers/ActionId;->QUEUED:S

    .line 46
    sput-short v0, Lcom/facebook/quicklog/identifiers/ActionId;->ERROR:S

    .line 49
    sput-short v0, Lcom/facebook/quicklog/identifiers/ActionId;->FINALLY:S

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
