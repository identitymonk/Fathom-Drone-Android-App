.class Lcom/facebook/react/views/text/ReactFontManager$FontFamily;
.super Ljava/lang/Object;
.source "ReactFontManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/text/ReactFontManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FontFamily"
.end annotation


# instance fields
.field private mTypefaceSparseArray:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/graphics/Typeface;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 122
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 123
    new-instance v0, Landroid/util/SparseArray;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v0, p0, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;->mTypefaceSparseArray:Landroid/util/SparseArray;

    .line 124
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/views/text/ReactFontManager$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/views/text/ReactFontManager$1;

    .prologue
    .line 118
    invoke-direct {p0}, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;-><init>()V

    return-void
.end method


# virtual methods
.method public getTypeface(I)Landroid/graphics/Typeface;
    .locals 1
    .param p1, "style"    # I

    .prologue
    .line 127
    iget-object v0, p0, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;->mTypefaceSparseArray:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Typeface;

    return-object v0
.end method

.method public setTypeface(ILandroid/graphics/Typeface;)V
    .locals 1
    .param p1, "style"    # I
    .param p2, "typeface"    # Landroid/graphics/Typeface;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/facebook/react/views/text/ReactFontManager$FontFamily;->mTypefaceSparseArray:Landroid/util/SparseArray;

    invoke-virtual {v0, p1, p2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 132
    return-void
.end method
