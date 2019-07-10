package com.facebook.debug.holder;

public class PrinterHolder
{
  private static Printer sPrinter = NoopPrinter.INSTANCE;

  public static Printer getPrinter()
  {
    return sPrinter;
  }

  public static void setPrinter(Printer paramPrinter)
  {
    if (paramPrinter == null)
    {
      sPrinter = NoopPrinter.INSTANCE;
      return;
    }
    sPrinter = paramPrinter;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.debug.holder.PrinterHolder
 * JD-Core Version:    0.6.0
 */