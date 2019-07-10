.class public final enum Lcom/facebook/yoga/YogaDimension;
.super Ljava/lang/Enum;
.source "YogaDimension.java"


# annotations
.annotation build Lcom/facebook/proguard/annotations/DoNotStrip;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/facebook/yoga/YogaDimension;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/facebook/yoga/YogaDimension;

.field public static final enum HEIGHT:Lcom/facebook/yoga/YogaDimension;

.field public static final enum WIDTH:Lcom/facebook/yoga/YogaDimension;


# instance fields
.field private mIntValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 16
    new-instance v0, Lcom/facebook/yoga/YogaDimension;

    const-string v1, "WIDTH"

    invoke-direct {v0, v1, v2, v2}, Lcom/facebook/yoga/YogaDimension;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/facebook/yoga/YogaDimension;->WIDTH:Lcom/facebook/yoga/YogaDimension;

    .line 17
    new-instance v0, Lcom/facebook/yoga/YogaDimension;

    const-string v1, "HEIGHT"

    invoke-direct {v0, v1, v3, v3}, Lcom/facebook/yoga/YogaDimension;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/facebook/yoga/YogaDimension;->HEIGHT:Lcom/facebook/yoga/YogaDimension;

    .line 14
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/facebook/yoga/YogaDimension;

    sget-object v1, Lcom/facebook/yoga/YogaDimension;->WIDTH:Lcom/facebook/yoga/YogaDimension;

    aput-object v1, v0, v2

    sget-object v1, Lcom/facebook/yoga/YogaDimension;->HEIGHT:Lcom/facebook/yoga/YogaDimension;

    aput-object v1, v0, v3

    sput-object v0, Lcom/facebook/yoga/YogaDimension;->$VALUES:[Lcom/facebook/yoga/YogaDimension;

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
    .line 21
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 22
    iput p3, p0, Lcom/facebook/yoga/YogaDimension;->mIntValue:I

    .line 23
    return-void
.end method

.method public static fromInt(I)Lcom/facebook/yoga/YogaDimension;
    .locals 3
    .param p0, "value"    # I

    .prologue
    .line 30
    packed-switch p0, :pswitch_data_0

    .line 33
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

    .line 31
    :pswitch_0
    sget-object v0, Lcom/facebook/yoga/YogaDimension;->WIDTH:Lcom/facebook/yoga/YogaDimension;

    .line 32
    :goto_0
    return-object v0

    :pswitch_1
    sget-object v0, Lcom/facebook/yoga/YogaDimension;->HEIGHT:Lcom/facebook/yoga/YogaDimension;

    goto :goto_0

    .line 30
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/facebook/yoga/YogaDimension;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    const-class v0, Lcom/facebook/yoga/YogaDimension;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/facebook/yoga/YogaDimension;

    return-object v0
.end method

.method public static values()[Lcom/facebook/yoga/YogaDimension;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/facebook/yoga/YogaDimension;->$VALUES:[Lcom/facebook/yoga/YogaDimension;

    invoke-virtual {v0}, [Lcom/facebook/yoga/YogaDimension;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/facebook/yoga/YogaDimension;

    return-object v0
.end method


# virtual methods
.method public intValue()I
    .locals 1

    .prologue
    .line 26
    iget v0, p0, Lcom/facebook/yoga/YogaDimension;->mIntValue:I

    return v0
.end method
