.class Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;
.super Ljava/lang/Object;
.source "TimePickerDialogModule.java"

# interfaces
.implements Landroid/app/TimePickerDialog$OnTimeSetListener;
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TimePickerDialogListener"
.end annotation


# instance fields
.field private final mPromise:Lcom/facebook/react/bridge/Promise;

.field private mPromiseResolved:Z

.field final synthetic this$0:Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;


# direct methods
.method public constructor <init>(Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;Lcom/facebook/react/bridge/Promise;)V
    .locals 1
    .param p2, "promise"    # Lcom/facebook/react/bridge/Promise;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;->this$0:Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;->mPromiseResolved:Z

    .line 68
    iput-object p2, p0, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;->mPromise:Lcom/facebook/react/bridge/Promise;

    .line 69
    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 85
    iget-boolean v1, p0, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;->mPromiseResolved:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;->this$0:Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;

    invoke-static {v1}, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;->access$100(Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;)Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/react/bridge/ReactApplicationContext;->hasActiveCatalystInstance()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 86
    new-instance v0, Lcom/facebook/react/bridge/WritableNativeMap;

    invoke-direct {v0}, Lcom/facebook/react/bridge/WritableNativeMap;-><init>()V

    .line 87
    .local v0, "result":Lcom/facebook/react/bridge/WritableMap;
    const-string v1, "action"

    const-string v2, "dismissedAction"

    invoke-interface {v0, v1, v2}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    iget-object v1, p0, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;->mPromise:Lcom/facebook/react/bridge/Promise;

    invoke-interface {v1, v0}, Lcom/facebook/react/bridge/Promise;->resolve(Ljava/lang/Object;)V

    .line 89
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;->mPromiseResolved:Z

    .line 91
    .end local v0    # "result":Lcom/facebook/react/bridge/WritableMap;
    :cond_0
    return-void
.end method

.method public onTimeSet(Landroid/widget/TimePicker;II)V
    .locals 3
    .param p1, "view"    # Landroid/widget/TimePicker;
    .param p2, "hour"    # I
    .param p3, "minute"    # I

    .prologue
    .line 73
    iget-boolean v1, p0, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;->mPromiseResolved:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;->this$0:Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;

    invoke-static {v1}, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;->access$000(Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;)Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/react/bridge/ReactApplicationContext;->hasActiveCatalystInstance()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 74
    new-instance v0, Lcom/facebook/react/bridge/WritableNativeMap;

    invoke-direct {v0}, Lcom/facebook/react/bridge/WritableNativeMap;-><init>()V

    .line 75
    .local v0, "result":Lcom/facebook/react/bridge/WritableMap;
    const-string v1, "action"

    const-string v2, "timeSetAction"

    invoke-interface {v0, v1, v2}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    const-string v1, "hour"

    invoke-interface {v0, v1, p2}, Lcom/facebook/react/bridge/WritableMap;->putInt(Ljava/lang/String;I)V

    .line 77
    const-string v1, "minute"

    invoke-interface {v0, v1, p3}, Lcom/facebook/react/bridge/WritableMap;->putInt(Ljava/lang/String;I)V

    .line 78
    iget-object v1, p0, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;->mPromise:Lcom/facebook/react/bridge/Promise;

    invoke-interface {v1, v0}, Lcom/facebook/react/bridge/Promise;->resolve(Ljava/lang/Object;)V

    .line 79
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;->mPromiseResolved:Z

    .line 81
    .end local v0    # "result":Lcom/facebook/react/bridge/WritableMap;
    :cond_0
    return-void
.end method
