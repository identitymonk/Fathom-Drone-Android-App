.class public Lcom/facebook/react/module/model/ReactModuleInfo;
.super Ljava/lang/Object;
.source "ReactModuleInfo.java"


# instance fields
.field private final mCanOverrideExistingModule:Z

.field private final mHasConstants:Z

.field private final mName:Ljava/lang/String;

.field private final mNeedsEagerInit:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;ZZZ)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "canOverrideExistingModule"    # Z
    .param p3, "needsEagerInit"    # Z
    .param p4, "hasConstants"    # Z

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/facebook/react/module/model/ReactModuleInfo;->mName:Ljava/lang/String;

    .line 22
    iput-boolean p2, p0, Lcom/facebook/react/module/model/ReactModuleInfo;->mCanOverrideExistingModule:Z

    .line 23
    iput-boolean p3, p0, Lcom/facebook/react/module/model/ReactModuleInfo;->mNeedsEagerInit:Z

    .line 24
    iput-boolean p4, p0, Lcom/facebook/react/module/model/ReactModuleInfo;->mHasConstants:Z

    .line 25
    return-void
.end method


# virtual methods
.method public canOverrideExistingModule()Z
    .locals 1

    .prologue
    .line 32
    iget-boolean v0, p0, Lcom/facebook/react/module/model/ReactModuleInfo;->mCanOverrideExistingModule:Z

    return v0
.end method

.method public hasConstants()Z
    .locals 1

    .prologue
    .line 40
    iget-boolean v0, p0, Lcom/facebook/react/module/model/ReactModuleInfo;->mHasConstants:Z

    return v0
.end method

.method public name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/facebook/react/module/model/ReactModuleInfo;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public needsEagerInit()Z
    .locals 1

    .prologue
    .line 36
    iget-boolean v0, p0, Lcom/facebook/react/module/model/ReactModuleInfo;->mNeedsEagerInit:Z

    return v0
.end method
