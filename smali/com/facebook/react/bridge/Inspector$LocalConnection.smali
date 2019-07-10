.class public Lcom/facebook/react/bridge/Inspector$LocalConnection;
.super Ljava/lang/Object;
.source "Inspector.java"


# annotations
.annotation build Lcom/facebook/proguard/annotations/DoNotStrip;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/bridge/Inspector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LocalConnection"
.end annotation


# instance fields
.field private final mHybridData:Lcom/facebook/jni/HybridData;


# direct methods
.method private constructor <init>(Lcom/facebook/jni/HybridData;)V
    .locals 0
    .param p1, "hybridData"    # Lcom/facebook/jni/HybridData;

    .prologue
    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    iput-object p1, p0, Lcom/facebook/react/bridge/Inspector$LocalConnection;->mHybridData:Lcom/facebook/jni/HybridData;

    .line 93
    return-void
.end method


# virtual methods
.method public native disconnect()V
.end method

.method public native sendMessage(Ljava/lang/String;)V
.end method
