package com.facebook.imagepipeline.image;

public class ImmutableQualityInfo
  implements QualityInfo
{
  public static final QualityInfo FULL_QUALITY = of(2147483647, true, true);
  boolean mIsOfFullQuality;
  boolean mIsOfGoodEnoughQuality;
  int mQuality;

  private ImmutableQualityInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mQuality = paramInt;
    this.mIsOfGoodEnoughQuality = paramBoolean1;
    this.mIsOfFullQuality = paramBoolean2;
  }

  public static QualityInfo of(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new ImmutableQualityInfo(paramInt, paramBoolean1, paramBoolean2);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof ImmutableQualityInfo))
        return false;
      paramObject = (ImmutableQualityInfo)paramObject;
    }
    while ((this.mQuality == paramObject.mQuality) && (this.mIsOfGoodEnoughQuality == paramObject.mIsOfGoodEnoughQuality) && (this.mIsOfFullQuality == paramObject.mIsOfFullQuality));
    return false;
  }

  public int getQuality()
  {
    return this.mQuality;
  }

  public int hashCode()
  {
    int j = 0;
    int k = this.mQuality;
    if (this.mIsOfGoodEnoughQuality);
    for (int i = 4194304; ; i = 0)
    {
      if (this.mIsOfFullQuality)
        j = 8388608;
      return i ^ k ^ j;
    }
  }

  public boolean isOfFullQuality()
  {
    return this.mIsOfFullQuality;
  }

  public boolean isOfGoodEnoughQuality()
  {
    return this.mIsOfGoodEnoughQuality;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.image.ImmutableQualityInfo
 * JD-Core Version:    0.6.0
 */