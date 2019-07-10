.class final Lcom/facebook/react/flat/ElementsList$Scope;
.super Ljava/lang/Object;
.source "ElementsList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/flat/ElementsList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Scope"
.end annotation


# instance fields
.field elements:[Ljava/lang/Object;

.field index:I

.field size:I


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/flat/ElementsList$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/flat/ElementsList$1;

    .prologue
    .line 66
    invoke-direct {p0}, Lcom/facebook/react/flat/ElementsList$Scope;-><init>()V

    return-void
.end method
