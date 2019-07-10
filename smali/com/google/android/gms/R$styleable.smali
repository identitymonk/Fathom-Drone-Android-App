.class public final Lcom/google/android/gms/R$styleable;
.super Ljava/lang/Object;
.source "R.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/R;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "styleable"
.end annotation


# static fields
.field public static final AppDataSearch:[I

.field public static final Corpus:[I

.field public static final Corpus_contentProviderUri:I = 0x2

.field public static final Corpus_corpusId:I = 0x0

.field public static final Corpus_corpusVersion:I = 0x1

.field public static final Corpus_documentMaxAgeSecs:I = 0x6

.field public static final Corpus_perAccountTemplate:I = 0x7

.field public static final Corpus_schemaOrgType:I = 0x4

.field public static final Corpus_semanticallySearchable:I = 0x5

.field public static final Corpus_trimmable:I = 0x3

.field public static final FeatureParam:[I

.field public static final FeatureParam_paramName:I = 0x0

.field public static final FeatureParam_paramValue:I = 0x1

.field public static final GlobalSearch:[I

.field public static final GlobalSearchCorpus:[I

.field public static final GlobalSearchCorpus_allowShortcuts:I = 0x0

.field public static final GlobalSearchSection:[I

.field public static final GlobalSearchSection_sectionContent:I = 0x1

.field public static final GlobalSearchSection_sectionType:I = 0x0

.field public static final GlobalSearch_defaultIntentAction:I = 0x3

.field public static final GlobalSearch_defaultIntentActivity:I = 0x5

.field public static final GlobalSearch_defaultIntentData:I = 0x4

.field public static final GlobalSearch_searchEnabled:I = 0x0

.field public static final GlobalSearch_searchLabel:I = 0x1

.field public static final GlobalSearch_settingsDescription:I = 0x2

.field public static final IMECorpus:[I

.field public static final IMECorpus_inputEnabled:I = 0x0

.field public static final IMECorpus_sourceClass:I = 0x1

.field public static final IMECorpus_toAddressesSection:I = 0x5

.field public static final IMECorpus_userInputSection:I = 0x3

.field public static final IMECorpus_userInputTag:I = 0x2

.field public static final IMECorpus_userInputValue:I = 0x4

.field public static final LoadingImageView:[I

.field public static final LoadingImageView_circleCrop:I = 0x2

.field public static final LoadingImageView_imageAspectRatio:I = 0x1

.field public static final LoadingImageView_imageAspectRatioAdjust:I = 0x0

.field public static final Section:[I

.field public static final SectionFeature:[I

.field public static final SectionFeature_featureType:I = 0x0

.field public static final Section_indexPrefixes:I = 0x4

.field public static final Section_noIndex:I = 0x2

.field public static final Section_schemaOrgProperty:I = 0x6

.field public static final Section_sectionFormat:I = 0x1

.field public static final Section_sectionId:I = 0x0

.field public static final Section_sectionWeight:I = 0x3

.field public static final Section_subsectionSeparator:I = 0x5

.field public static final SignInButton:[I

.field public static final SignInButton_buttonSize:I = 0x0

.field public static final SignInButton_colorScheme:I = 0x1

.field public static final SignInButton_scopeUris:I = 0x2


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x6

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 159
    new-array v0, v2, [I

    sput-object v0, Lcom/google/android/gms/R$styleable;->AppDataSearch:[I

    .line 160
    const/16 v0, 0x8

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/google/android/gms/R$styleable;->Corpus:[I

    .line 169
    new-array v0, v4, [I

    fill-array-data v0, :array_1

    sput-object v0, Lcom/google/android/gms/R$styleable;->FeatureParam:[I

    .line 172
    new-array v0, v6, [I

    fill-array-data v0, :array_2

    sput-object v0, Lcom/google/android/gms/R$styleable;->GlobalSearch:[I

    .line 173
    new-array v0, v3, [I

    const v1, 0x7f0100ed

    aput v1, v0, v2

    sput-object v0, Lcom/google/android/gms/R$styleable;->GlobalSearchCorpus:[I

    .line 175
    new-array v0, v4, [I

    fill-array-data v0, :array_3

    sput-object v0, Lcom/google/android/gms/R$styleable;->GlobalSearchSection:[I

    .line 184
    new-array v0, v6, [I

    fill-array-data v0, :array_4

    sput-object v0, Lcom/google/android/gms/R$styleable;->IMECorpus:[I

    .line 191
    new-array v0, v5, [I

    fill-array-data v0, :array_5

    sput-object v0, Lcom/google/android/gms/R$styleable;->LoadingImageView:[I

    .line 195
    const/4 v0, 0x7

    new-array v0, v0, [I

    fill-array-data v0, :array_6

    sput-object v0, Lcom/google/android/gms/R$styleable;->Section:[I

    .line 196
    new-array v0, v3, [I

    const v1, 0x7f010123

    aput v1, v0, v2

    sput-object v0, Lcom/google/android/gms/R$styleable;->SectionFeature:[I

    .line 205
    new-array v0, v5, [I

    fill-array-data v0, :array_7

    sput-object v0, Lcom/google/android/gms/R$styleable;->SignInButton:[I

    return-void

    .line 160
    nop

    :array_0
    .array-data 4
        0x7f0100b3
        0x7f0100b4
        0x7f0100b5
        0x7f0100b6
        0x7f0100b7
        0x7f0100b8
        0x7f0100b9
        0x7f0100ba
    .end array-data

    .line 169
    :array_1
    .array-data 4
        0x7f0100c6
        0x7f0100c7
    .end array-data

    .line 172
    :array_2
    .array-data 4
        0x7f0100e7
        0x7f0100e8
        0x7f0100e9
        0x7f0100ea
        0x7f0100eb
        0x7f0100ec
    .end array-data

    .line 175
    :array_3
    .array-data 4
        0x7f0100ee
        0x7f0100ef
    .end array-data

    .line 184
    :array_4
    .array-data 4
        0x7f0100f0
        0x7f0100f1
        0x7f0100f2
        0x7f0100f3
        0x7f0100f4
        0x7f0100f5
    .end array-data

    .line 191
    :array_5
    .array-data 4
        0x7f0100f9
        0x7f0100fa
        0x7f0100fb
    .end array-data

    .line 195
    :array_6
    .array-data 4
        0x7f01011c
        0x7f01011d
        0x7f01011e
        0x7f01011f
        0x7f010120
        0x7f010121
        0x7f010122
    .end array-data

    .line 205
    :array_7
    .array-data 4
        0x7f010124
        0x7f010125
        0x7f010126
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 158
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
