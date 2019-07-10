.class public final Lcom/facebook/fbui/textlayoutbuilder/R$styleable;
.super Ljava/lang/Object;
.source "R.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/fbui/textlayoutbuilder/R;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "styleable"
.end annotation


# static fields
.field public static final TextAppearance:[I

.field public static final TextAppearance_android_shadowColor:I = 0x4

.field public static final TextAppearance_android_shadowDx:I = 0x5

.field public static final TextAppearance_android_shadowDy:I = 0x6

.field public static final TextAppearance_android_shadowRadius:I = 0x7

.field public static final TextAppearance_android_textColor:I = 0x3

.field public static final TextAppearance_android_textSize:I = 0x0

.field public static final TextAppearance_android_textStyle:I = 0x2

.field public static final TextStyle:[I

.field public static final TextStyle_android_ellipsize:I = 0x4

.field public static final TextStyle_android_maxLines:I = 0x5

.field public static final TextStyle_android_shadowColor:I = 0x7

.field public static final TextStyle_android_shadowDx:I = 0x8

.field public static final TextStyle_android_shadowDy:I = 0x9

.field public static final TextStyle_android_shadowRadius:I = 0xa

.field public static final TextStyle_android_singleLine:I = 0x6

.field public static final TextStyle_android_textAppearance:I = 0x0

.field public static final TextStyle_android_textColor:I = 0x3

.field public static final TextStyle_android_textSize:I = 0x1

.field public static final TextStyle_android_textStyle:I = 0x2


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const/16 v0, 0x9

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextAppearance:[I

    .line 19
    const/16 v0, 0xb

    new-array v0, v0, [I

    fill-array-data v0, :array_1

    sput-object v0, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle:[I

    return-void

    .line 11
    nop

    :array_0
    .array-data 4
        0x1010095
        0x1010096
        0x1010097
        0x1010098
        0x1010161
        0x1010162
        0x1010163
        0x1010164
        0x7f010028
    .end array-data

    .line 19
    :array_1
    .array-data 4
        0x1010034
        0x1010095
        0x1010097
        0x1010098
        0x10100ab
        0x1010153
        0x101015d
        0x1010161
        0x1010162
        0x1010163
        0x1010164
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
