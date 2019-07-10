.class Lcom/google/android/gms/internal/zzaps$7;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzapx;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzaps;->zzc(Ljava/lang/reflect/Type;Ljava/lang/Class;)Lcom/google/android/gms/internal/zzapx;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/internal/zzapx",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final synthetic boR:Lcom/google/android/gms/internal/zzaps;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzaps;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzaps$7;->boR:Lcom/google/android/gms/internal/zzaps;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bj()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    new-instance v0, Ljava/util/TreeSet;

    invoke-direct {v0}, Ljava/util/TreeSet;-><init>()V

    return-object v0
.end method
