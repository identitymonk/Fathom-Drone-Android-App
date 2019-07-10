package com.facebook.react.bridge;

import javax.annotation.Nullable;

public class SoftAssertions
{
  public static void assertCondition(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
      throw new AssertionException(paramString);
  }

  public static <T> T assertNotNull(@Nullable T paramT)
  {
    if (paramT == null)
      throw new AssertionException("Expected object to not be null!");
    return paramT;
  }

  public static void assertUnreachable(String paramString)
  {
    throw new AssertionException(paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.SoftAssertions
 * JD-Core Version:    0.6.0
 */