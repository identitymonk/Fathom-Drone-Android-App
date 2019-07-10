.class Lcom/facebook/react/views/picker/ReactPickerManager$ReactPickerAdapter;
.super Landroid/widget/ArrayAdapter;
.source "ReactPickerManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/picker/ReactPickerManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ReactPickerAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/facebook/react/bridge/ReadableMap;",
        ">;"
    }
.end annotation


# instance fields
.field private final mInflater:Landroid/view/LayoutInflater;

.field private mPrimaryTextColor:Ljava/lang/Integer;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;[Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "data"    # [Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    .line 103
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 105
    const-string v0, "layout_inflater"

    .line 106
    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 105
    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/facebook/react/views/picker/ReactPickerManager$ReactPickerAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 107
    return-void
.end method

.method private getView(ILandroid/view/View;Landroid/view/ViewGroup;Z)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;
    .param p4, "isDropdown"    # Z

    .prologue
    .line 120
    invoke-virtual {p0, p1}, Lcom/facebook/react/views/picker/ReactPickerManager$ReactPickerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/bridge/ReadableMap;

    .line 122
    .local v0, "item":Lcom/facebook/react/bridge/ReadableMap;
    if-nez p2, :cond_0

    .line 123
    if-eqz p4, :cond_2

    const v1, 0x1090009

    .line 126
    .local v1, "layoutResId":I
    :goto_0
    iget-object v3, p0, Lcom/facebook/react/views/picker/ReactPickerManager$ReactPickerAdapter;->mInflater:Landroid/view/LayoutInflater;

    const/4 v4, 0x0

    invoke-virtual {v3, v1, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .end local v1    # "layoutResId":I
    :cond_0
    move-object v2, p2

    .line 129
    check-cast v2, Landroid/widget/TextView;

    .line 130
    .local v2, "textView":Landroid/widget/TextView;
    const-string v3, "label"

    invoke-interface {v0, v3}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 131
    if-nez p4, :cond_3

    iget-object v3, p0, Lcom/facebook/react/views/picker/ReactPickerManager$ReactPickerAdapter;->mPrimaryTextColor:Ljava/lang/Integer;

    if-eqz v3, :cond_3

    .line 132
    iget-object v3, p0, Lcom/facebook/react/views/picker/ReactPickerManager$ReactPickerAdapter;->mPrimaryTextColor:Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 137
    :cond_1
    :goto_1
    return-object p2

    .line 123
    .end local v2    # "textView":Landroid/widget/TextView;
    :cond_2
    const v1, 0x1090008

    goto :goto_0

    .line 133
    .restart local v2    # "textView":Landroid/widget/TextView;
    :cond_3
    const-string v3, "color"

    invoke-interface {v0, v3}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    const-string v3, "color"

    invoke-interface {v0, v3}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 134
    const-string v3, "color"

    invoke-interface {v0, v3}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1
.end method


# virtual methods
.method public getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 116
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/facebook/react/views/picker/ReactPickerManager$ReactPickerAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 111
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/facebook/react/views/picker/ReactPickerManager$ReactPickerAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public setPrimaryTextColor(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "primaryTextColor"    # Ljava/lang/Integer;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 141
    iput-object p1, p0, Lcom/facebook/react/views/picker/ReactPickerManager$ReactPickerAdapter;->mPrimaryTextColor:Ljava/lang/Integer;

    .line 142
    invoke-virtual {p0}, Lcom/facebook/react/views/picker/ReactPickerManager$ReactPickerAdapter;->notifyDataSetChanged()V

    .line 143
    return-void
.end method
