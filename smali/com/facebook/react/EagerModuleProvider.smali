.class public Lcom/facebook/react/EagerModuleProvider;
.super Ljava/lang/Object;
.source "EagerModuleProvider.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/facebook/react/bridge/NativeModule;",
        ">;"
    }
.end annotation


# instance fields
.field private final mModule:Lcom/facebook/react/bridge/NativeModule;


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/NativeModule;)V
    .locals 0
    .param p1, "module"    # Lcom/facebook/react/bridge/NativeModule;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/facebook/react/EagerModuleProvider;->mModule:Lcom/facebook/react/bridge/NativeModule;

    .line 18
    return-void
.end method


# virtual methods
.method public get()Lcom/facebook/react/bridge/NativeModule;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/facebook/react/EagerModuleProvider;->mModule:Lcom/facebook/react/bridge/NativeModule;

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 12
    invoke-virtual {p0}, Lcom/facebook/react/EagerModuleProvider;->get()Lcom/facebook/react/bridge/NativeModule;

    move-result-object v0

    return-object v0
.end method
