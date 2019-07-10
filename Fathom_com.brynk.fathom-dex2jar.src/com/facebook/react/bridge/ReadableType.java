package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum ReadableType
{
  static
  {
    Boolean = new ReadableType("Boolean", 1);
    Number = new ReadableType("Number", 2);
    String = new ReadableType("String", 3);
    Map = new ReadableType("Map", 4);
    Array = new ReadableType("Array", 5);
    $VALUES = new ReadableType[] { Null, Boolean, Number, String, Map, Array };
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableType
 * JD-Core Version:    0.6.0
 */