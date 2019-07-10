.class public Lcom/brynk/fathom/helpers/DivelogEntry;
.super Ljava/lang/Object;
.source "DivelogEntry.java"


# instance fields
.field private isConverted:Z

.field private name:Ljava/lang/String;

.field private startTime:Ljava/lang/String;

.field private stopTime:Ljava/lang/String;

.field private when:Ljava/lang/String;

.field private where:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "when"    # Ljava/lang/String;
    .param p3, "startTime"    # Ljava/lang/String;
    .param p4, "stopTime"    # Ljava/lang/String;
    .param p5, "where"    # Ljava/lang/String;
    .param p6, "isConverted"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->name:Ljava/lang/String;

    .line 17
    iput-object p2, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->when:Ljava/lang/String;

    .line 18
    iput-object p3, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->startTime:Ljava/lang/String;

    .line 19
    iput-object p4, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->stopTime:Ljava/lang/String;

    .line 20
    iput-object p5, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->where:Ljava/lang/String;

    .line 23
    :try_start_0
    invoke-static {p6}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->isConverted:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 29
    :goto_0
    return-void

    .line 25
    :catch_0
    move-exception v0

    .line 26
    .local v0, "e":Ljava/lang/Exception;
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->isConverted:Z

    goto :goto_0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getStartTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->startTime:Ljava/lang/String;

    return-object v0
.end method

.method public getStopTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->stopTime:Ljava/lang/String;

    return-object v0
.end method

.method public getWhen()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->when:Ljava/lang/String;

    return-object v0
.end method

.method public getWhere()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->where:Ljava/lang/String;

    return-object v0
.end method

.method public isConverted()Z
    .locals 1

    .prologue
    .line 73
    iget-boolean v0, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->isConverted:Z

    return v0
.end method

.method public setConverted(Z)V
    .locals 0
    .param p1, "converted"    # Z

    .prologue
    .line 77
    iput-boolean p1, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->isConverted:Z

    .line 78
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->name:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setStartTime(Ljava/lang/String;)V
    .locals 0
    .param p1, "startTime"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->startTime:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setStopTime(Ljava/lang/String;)V
    .locals 0
    .param p1, "stopTime"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->stopTime:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public setWhen(Ljava/lang/String;)V
    .locals 0
    .param p1, "when"    # Ljava/lang/String;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->when:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setWhere(Ljava/lang/String;)V
    .locals 0
    .param p1, "where"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/brynk/fathom/helpers/DivelogEntry;->where:Ljava/lang/String;

    .line 61
    return-void
.end method
