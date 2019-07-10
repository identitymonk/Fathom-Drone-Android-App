.class public Lcom/brynk/fathom/helpers/DivelogAdapter;
.super Landroid/widget/BaseAdapter;
.source "DivelogAdapter.java"


# instance fields
.field private DRONE_IP:Ljava/lang/String;

.field private mContext:Landroid/content/Context;

.field private mDataSource:[Lcom/brynk/fathom/helpers/DivelogEntry;

.field private mInflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Landroid/content/Context;[Lcom/brynk/fathom/helpers/DivelogEntry;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "items"    # [Lcom/brynk/fathom/helpers/DivelogEntry;

    .prologue
    .line 25
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mContext:Landroid/content/Context;

    .line 27
    iput-object p2, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mDataSource:[Lcom/brynk/fathom/helpers/DivelogEntry;

    .line 28
    iget-object v0, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mContext:Landroid/content/Context;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 29
    new-instance v0, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v0}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {v0, p1}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->DRONE_IP:Ljava/lang/String;

    .line 30
    return-void
.end method

.method static synthetic access$000(Lcom/brynk/fathom/helpers/DivelogAdapter;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/helpers/DivelogAdapter;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->DRONE_IP:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/brynk/fathom/helpers/DivelogAdapter;)[Lcom/brynk/fathom/helpers/DivelogEntry;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/helpers/DivelogAdapter;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mDataSource:[Lcom/brynk/fathom/helpers/DivelogEntry;

    return-object v0
.end method

.method static synthetic access$200(Lcom/brynk/fathom/helpers/DivelogAdapter;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/helpers/DivelogAdapter;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mDataSource:[Lcom/brynk/fathom/helpers/DivelogEntry;

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 40
    iget-object v0, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mDataSource:[Lcom/brynk/fathom/helpers/DivelogEntry;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 45
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 51
    iget-object v5, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mInflater:Landroid/view/LayoutInflater;

    const v6, 0x7f040047

    const/4 v7, 0x0

    invoke-virtual {v5, v6, p3, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 53
    .local v0, "rowView":Landroid/view/View;
    const v5, 0x7f0f0107

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 54
    .local v4, "tv_where":Landroid/widget/TextView;
    const v5, 0x7f0f0106

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 57
    .local v3, "tv_when":Landroid/widget/TextView;
    iget-object v5, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mDataSource:[Lcom/brynk/fathom/helpers/DivelogEntry;

    aget-object v5, v5, p1

    invoke-virtual {v5}, Lcom/brynk/fathom/helpers/DivelogEntry;->getWhere()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 58
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v6, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mDataSource:[Lcom/brynk/fathom/helpers/DivelogEntry;

    aget-object v6, v6, p1

    invoke-virtual {v6}, Lcom/brynk/fathom/helpers/DivelogEntry;->getWhen()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mDataSource:[Lcom/brynk/fathom/helpers/DivelogEntry;

    aget-object v6, v6, p1

    invoke-virtual {v6}, Lcom/brynk/fathom/helpers/DivelogEntry;->getStartTime()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 60
    const v5, 0x7f0f0108

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 61
    .local v2, "tv_recording_link":Landroid/widget/TextView;
    new-instance v5, Lcom/brynk/fathom/helpers/DivelogAdapter$1;

    invoke-direct {v5, p0, p1}, Lcom/brynk/fathom/helpers/DivelogAdapter$1;-><init>(Lcom/brynk/fathom/helpers/DivelogAdapter;I)V

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 74
    iget-object v5, p0, Lcom/brynk/fathom/helpers/DivelogAdapter;->mDataSource:[Lcom/brynk/fathom/helpers/DivelogEntry;

    aget-object v5, v5, p1

    invoke-virtual {v5}, Lcom/brynk/fathom/helpers/DivelogEntry;->isConverted()Z

    move-result v5

    if-nez v5, :cond_0

    .line 75
    const/4 v5, 0x4

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 78
    :cond_0
    const v5, 0x7f0f0109

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 79
    .local v1, "tv_delete_recording":Landroid/widget/TextView;
    new-instance v5, Lcom/brynk/fathom/helpers/DivelogAdapter$2;

    invoke-direct {v5, p0}, Lcom/brynk/fathom/helpers/DivelogAdapter$2;-><init>(Lcom/brynk/fathom/helpers/DivelogAdapter;)V

    invoke-virtual {v1, v5}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 87
    return-object v0
.end method
