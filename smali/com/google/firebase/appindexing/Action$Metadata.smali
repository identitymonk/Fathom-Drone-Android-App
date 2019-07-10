.class public interface abstract Lcom/google/firebase/appindexing/Action$Metadata;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/firebase/appindexing/Action;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Metadata"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/firebase/appindexing/Action$Metadata$Builder;
    }
.end annotation


# static fields
.field public static final aWr:Lcom/google/firebase/appindexing/internal/ActionImpl$MetadataImpl;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/Action$Metadata$Builder;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/Action$Metadata$Builder;-><init>()V

    invoke-virtual {v0}, Lcom/google/firebase/appindexing/Action$Metadata$Builder;->zzcny()Lcom/google/firebase/appindexing/internal/ActionImpl$MetadataImpl;

    move-result-object v0

    sput-object v0, Lcom/google/firebase/appindexing/Action$Metadata;->aWr:Lcom/google/firebase/appindexing/internal/ActionImpl$MetadataImpl;

    return-void
.end method
