.class public final Lcom/google/android/gms/internal/zzsk;
.super Landroid/widget/ImageView;


# instance fields
.field private Dc:Landroid/net/Uri;

.field private Dd:I


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 0

    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    return-void
.end method

.method protected onMeasure(II)V
    .locals 0

    invoke-super {p0, p1, p2}, Landroid/widget/ImageView;->onMeasure(II)V

    return-void
.end method

.method public zzauy()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzsk;->Dd:I

    return v0
.end method

.method public zzgi(I)V
    .locals 0

    iput p1, p0, Lcom/google/android/gms/internal/zzsk;->Dd:I

    return-void
.end method

.method public zzr(Landroid/net/Uri;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzsk;->Dc:Landroid/net/Uri;

    return-void
.end method
