.class public Lcom/facebook/debug/holder/PrinterHolder;
.super Ljava/lang/Object;
.source "PrinterHolder.java"


# static fields
.field private static sPrinter:Lcom/facebook/debug/holder/Printer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 8
    sget-object v0, Lcom/facebook/debug/holder/NoopPrinter;->INSTANCE:Lcom/facebook/debug/holder/NoopPrinter;

    sput-object v0, Lcom/facebook/debug/holder/PrinterHolder;->sPrinter:Lcom/facebook/debug/holder/Printer;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getPrinter()Lcom/facebook/debug/holder/Printer;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/facebook/debug/holder/PrinterHolder;->sPrinter:Lcom/facebook/debug/holder/Printer;

    return-object v0
.end method

.method public static setPrinter(Lcom/facebook/debug/holder/Printer;)V
    .locals 1
    .param p0, "printer"    # Lcom/facebook/debug/holder/Printer;

    .prologue
    .line 11
    if-nez p0, :cond_0

    .line 12
    sget-object v0, Lcom/facebook/debug/holder/NoopPrinter;->INSTANCE:Lcom/facebook/debug/holder/NoopPrinter;

    sput-object v0, Lcom/facebook/debug/holder/PrinterHolder;->sPrinter:Lcom/facebook/debug/holder/Printer;

    .line 16
    :goto_0
    return-void

    .line 14
    :cond_0
    sput-object p0, Lcom/facebook/debug/holder/PrinterHolder;->sPrinter:Lcom/facebook/debug/holder/Printer;

    goto :goto_0
.end method
