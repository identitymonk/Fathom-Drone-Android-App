.class public Lcom/facebook/quicklog/QuickPerformanceLogger;
.super Ljava/lang/Object;
.source "QuickPerformanceLogger.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public currentMonotonicTimestamp()J
    .locals 2

    .prologue
    .line 102
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public markerAnnotate(IILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "instanceKey"    # I
    .param p3, "annotationKey"    # Ljava/lang/String;
    .param p4, "annotationValue"    # Ljava/lang/String;

    .prologue
    .line 99
    return-void
.end method

.method public markerAnnotate(ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "annotationKey"    # Ljava/lang/String;
    .param p3, "annotationValue"    # Ljava/lang/String;

    .prologue
    .line 92
    return-void
.end method

.method public markerCancel(I)V
    .locals 0
    .param p1, "markerId"    # I

    .prologue
    .line 70
    return-void
.end method

.method public markerCancel(II)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "instanceKey"    # I

    .prologue
    .line 75
    return-void
.end method

.method public markerEnd(IIS)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "instanceKey"    # I
    .param p3, "actionId"    # S

    .prologue
    .line 41
    return-void
.end method

.method public markerEnd(IISJ)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "instanceKey"    # I
    .param p3, "actionId"    # S
    .param p4, "timestamp"    # J

    .prologue
    .line 48
    return-void
.end method

.method public markerEnd(IS)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "actionId"    # S

    .prologue
    .line 35
    return-void
.end method

.method public markerNote(IIS)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "instanceKey"    # I
    .param p3, "actionId"    # S

    .prologue
    .line 59
    return-void
.end method

.method public markerNote(IISJ)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "instanceKey"    # I
    .param p3, "actionId"    # S
    .param p4, "timestamp"    # J

    .prologue
    .line 66
    return-void
.end method

.method public markerNote(IS)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "actionId"    # S

    .prologue
    .line 53
    return-void
.end method

.method public markerStart(I)V
    .locals 0
    .param p1, "markerId"    # I

    .prologue
    .line 19
    return-void
.end method

.method public markerStart(II)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "instnaceKey"    # I

    .prologue
    .line 24
    return-void
.end method

.method public markerStart(IIJ)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "instnaceKey"    # I
    .param p3, "timestamp"    # J

    .prologue
    .line 30
    return-void
.end method

.method public markerTag(IILjava/lang/String;)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "instanceKey"    # I
    .param p3, "tag"    # Ljava/lang/String;

    .prologue
    .line 86
    return-void
.end method

.method public markerTag(ILjava/lang/String;)V
    .locals 0
    .param p1, "markerId"    # I
    .param p2, "tag"    # Ljava/lang/String;

    .prologue
    .line 80
    return-void
.end method
