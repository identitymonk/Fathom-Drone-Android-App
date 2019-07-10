package com.facebook.common.util;

import com.facebook.infer.annotation.Functional;

public enum TriState
{
  static
  {
    NO = new TriState("NO", 1);
    UNSET = new TriState("UNSET", 2);
    $VALUES = new TriState[] { YES, NO, UNSET };
  }

  @Functional
  public static TriState fromDbValue(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return UNSET;
    case 1:
      return YES;
    case 2:
    }
    return NO;
  }

  @Functional
  public static TriState valueOf(Boolean paramBoolean)
  {
    if (paramBoolean != null)
      return valueOf(paramBoolean.booleanValue());
    return UNSET;
  }

  @Functional
  public static TriState valueOf(boolean paramBoolean)
  {
    if (paramBoolean)
      return YES;
    return NO;
  }

  @Functional
  public boolean asBoolean()
  {
    switch (1.$SwitchMap$com$facebook$common$util$TriState[ordinal()])
    {
    default:
      throw new IllegalStateException("Unrecognized TriState value: " + this);
    case 1:
      return true;
    case 2:
      return false;
    case 3:
    }
    throw new IllegalStateException("No boolean equivalent for UNSET");
  }

  @Functional
  public boolean asBoolean(boolean paramBoolean)
  {
    switch (1.$SwitchMap$com$facebook$common$util$TriState[ordinal()])
    {
    default:
      throw new IllegalStateException("Unrecognized TriState value: " + this);
    case 1:
      paramBoolean = true;
    case 3:
      return paramBoolean;
    case 2:
    }
    return false;
  }

  @Functional
  public Boolean asBooleanObject()
  {
    switch (1.$SwitchMap$com$facebook$common$util$TriState[ordinal()])
    {
    default:
      throw new IllegalStateException("Unrecognized TriState value: " + this);
    case 1:
      return Boolean.TRUE;
    case 2:
      return Boolean.FALSE;
    case 3:
    }
    return null;
  }

  @Functional
  public int getDbValue()
  {
    switch (1.$SwitchMap$com$facebook$common$util$TriState[ordinal()])
    {
    default:
      return 3;
    case 1:
      return 1;
    case 2:
    }
    return 2;
  }

  @Functional
  public boolean isSet()
  {
    return this != UNSET;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.TriState
 * JD-Core Version:    0.6.0
 */