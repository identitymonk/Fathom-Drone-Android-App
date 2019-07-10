.class public final enum Lcom/facebook/yoga/YogaOverflow;
.super Ljava/lang/Enum;
.source "YogaOverflow.java"


# annotations
.annotation build Lcom/facebook/proguard/annotations/DoNotStrip;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/facebook/yoga/YogaOverflow;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/facebook/yoga/YogaOverflow;

.field public static final enum HIDDEN:Lcom/facebook/yoga/YogaOverflow;

.field public static final enum SCROLL:Lcom/facebook/yoga/YogaOverflow;

.field public static final enum VISIBLE:Lcom/facebook/yoga/YogaOverflow;


# instance fields
.field private mIntValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 16
    new-instance v0, Lcom/facebook/yoga/YogaOverflow;

    const-string v1, "VISIBLE"

    invoke-direct {v0, v1, v2, v2}, Lcom/facebook/yoga/YogaOverflow;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/facebook/yoga/YogaOverflow;->VISIBLE:Lcom/facebook/yoga/YogaOverflow;

    .line 17
    new-instance v0, Lcom/facebook/yoga/YogaOverflow;

    const-string v1, "HIDDEN"

    invoke-direct {v0, v1, v3, v3}, Lcom/facebook/yoga/YogaOverflow;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/facebook/yoga/YogaOverflow;->HIDDEN:Lcom/facebook/yoga/YogaOverflow;

    .line 18
    new-instance v0, Lcom/facebook/yoga/YogaOverflow;

    const-string v1, "SCROLL"

    invoke-direct {v0, v1, v4, v4}, Lcom/facebook/yoga/YogaOverflow;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/facebook/yoga/YogaOverflow;->SCROLL:Lcom/facebook/yoga/YogaOverflow;

    .line 14
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/facebook/yoga/YogaOverflow;

    sget-object v1, Lcom/facebook/yoga/YogaOverflow;->VISIBLE:Lcom/facebook/yoga/YogaOverflow;

    aput-object v1, v0, v2

    sget-object v1, Lcom/facebook/yoga/YogaOverflow;->HIDDEN:Lcom/facebook/yoga/YogaOverflow;

    aput-object v1, v0, v3

    sget-object v1, Lcom/facebook/yoga/YogaOverflow;->SCROLL:Lcom/facebook/yoga/YogaOverflow;

    aput-object v1, v0, v4

    sput-object v0, Lcom/facebook/yoga/YogaOverflow;->$VALUES:[Lcom/facebook/yoga/YogaOverflow;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "intValue"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 23
    iput p3, p0, Lcom/facebook/yoga/YogaOverflow;->mIntValue:I

    .line 24
    return-void
.end method

.method public static fromInt(I)Lcom/facebook/yoga/YogaOverflow;
    .locals 3
    .param p0, "value"    # I

    .prologue
    .line 31
    packed-switch p0, :pswitch_data_0

    .line 35
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown enum value: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 32
    :pswitch_0
    sget-object v0, Lcom/facebook/yoga/YogaOverflow;->VISIBLE:Lcom/facebook/yoga/YogaOverflow;

    .line 34
    :goto_0
    return-object v0

    .line 33
    :pswitch_1
    sget-object v0, Lcom/facebook/yoga/YogaOverflow;->HIDDEN:Lcom/facebook/yoga/YogaOverflow;

    goto :goto_0

    .line 34
    :pswitch_2
    sget-object v0, Lcom/facebook/yoga/YogaOverflow;->SCROLL:Lcom/facebook/yoga/YogaOverflow;

    goto :goto_0

    .line 31
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/facebook/yoga/YogaOverflow;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    const-class v0, Lcom/facebook/yoga/YogaOverflow;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/facebook/yoga/YogaOverflow;

    return-object v0
.end method

.method public static values()[Lcom/facebook/yoga/YogaOverflow;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/facebook/yoga/YogaOverflow;->$VALUES:[Lcom/facebook/yoga/YogaOverflow;

    invoke-virtual {v0}, [Lcom/facebook/yoga/YogaOverflow;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/facebook/yoga/YogaOverflow;

    return-object v0
.end method


# virtual methods
.method public intValue()I
    .locals 1

    .prologue
    .line 27
    iget v0, p0, Lcom/facebook/yoga/YogaOverflow;->mIntValue:I

    return v0
.end method
