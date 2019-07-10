package android.support.v4.print;

import android.content.Context;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;

class PrintHelperApi23 extends PrintHelperApi20
{
  PrintHelperApi23(Context paramContext)
  {
    super(paramContext);
    this.mIsMinMarginsHandlingCorrect = false;
  }

  protected PrintAttributes.Builder copyAttributes(PrintAttributes paramPrintAttributes)
  {
    PrintAttributes.Builder localBuilder = super.copyAttributes(paramPrintAttributes);
    if (paramPrintAttributes.getDuplexMode() != 0)
      localBuilder.setDuplexMode(paramPrintAttributes.getDuplexMode());
    return localBuilder;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.print.PrintHelperApi23
 * JD-Core Version:    0.6.0
 */