package com.facebook.imagepipeline.common;

import javax.annotation.Nullable;

public enum Priority
{
  static
  {
    HIGH = new Priority("HIGH", 2);
    $VALUES = new Priority[] { LOW, MEDIUM, HIGH };
  }

  public static Priority getHigherPriority(@Nullable Priority paramPriority1, @Nullable Priority paramPriority2)
  {
    if (paramPriority1 == null);
    do
    {
      return paramPriority2;
      if (paramPriority2 == null)
        return paramPriority1;
    }
    while (paramPriority1.ordinal() <= paramPriority2.ordinal());
    return paramPriority1;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.common.Priority
 * JD-Core Version:    0.6.0
 */