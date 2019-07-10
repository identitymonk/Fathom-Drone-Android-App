package com.google.android.gms.internal;

import java.io.Reader;
import java.io.StringReader;

public final class zzapd
{
  public zzaoy zza(Reader paramReader)
    throws zzaoz, zzaph
  {
    zzaoy localzzaoy;
    try
    {
      paramReader = new zzaqp(paramReader);
      localzzaoy = zzh(paramReader);
      if ((!localzzaoy.aY()) && (paramReader.bq() != zzaqq.brK))
        throw new zzaph("Did not consume the entire document.");
    }
    catch (zzaqs paramReader)
    {
      throw new zzaph(paramReader);
    }
    catch (java.io.IOException paramReader)
    {
      throw new zzaoz(paramReader);
    }
    catch (java.lang.NumberFormatException paramReader)
    {
      throw new zzaph(paramReader);
    }
    return localzzaoy;
  }

  // ERROR //
  public zzaoy zzh(zzaqp paramzzaqp)
    throws zzaoz, zzaph
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 63	com/google/android/gms/internal/zzaqp:isLenient	()Z
    //   4: istore_2
    //   5: aload_1
    //   6: iconst_1
    //   7: invokevirtual 67	com/google/android/gms/internal/zzaqp:setLenient	(Z)V
    //   10: aload_1
    //   11: invokestatic 70	com/google/android/gms/internal/zzapz:zzh	(Lcom/google/android/gms/internal/zzaqp;)Lcom/google/android/gms/internal/zzaoy;
    //   14: astore_3
    //   15: aload_1
    //   16: iload_2
    //   17: invokevirtual 67	com/google/android/gms/internal/zzaqp:setLenient	(Z)V
    //   20: aload_3
    //   21: areturn
    //   22: astore_3
    //   23: aload_1
    //   24: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   27: astore 4
    //   29: new 78	com/google/android/gms/internal/zzapc
    //   32: dup
    //   33: new 80	java/lang/StringBuilder
    //   36: dup
    //   37: aload 4
    //   39: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   42: invokevirtual 84	java/lang/String:length	()I
    //   45: bipush 36
    //   47: iadd
    //   48: invokespecial 87	java/lang/StringBuilder:<init>	(I)V
    //   51: ldc 89
    //   53: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 4
    //   58: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 95
    //   63: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: aload_3
    //   70: invokespecial 102	com/google/android/gms/internal/zzapc:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   73: athrow
    //   74: astore_3
    //   75: aload_1
    //   76: iload_2
    //   77: invokevirtual 67	com/google/android/gms/internal/zzaqp:setLenient	(Z)V
    //   80: aload_3
    //   81: athrow
    //   82: astore_3
    //   83: aload_1
    //   84: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   87: astore 4
    //   89: new 78	com/google/android/gms/internal/zzapc
    //   92: dup
    //   93: new 80	java/lang/StringBuilder
    //   96: dup
    //   97: aload 4
    //   99: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   102: invokevirtual 84	java/lang/String:length	()I
    //   105: bipush 36
    //   107: iadd
    //   108: invokespecial 87	java/lang/StringBuilder:<init>	(I)V
    //   111: ldc 89
    //   113: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 4
    //   118: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 95
    //   123: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: aload_3
    //   130: invokespecial 102	com/google/android/gms/internal/zzapc:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   10	15	22	java/lang/StackOverflowError
    //   10	15	74	finally
    //   23	74	74	finally
    //   83	134	74	finally
    //   10	15	82	java/lang/OutOfMemoryError
  }

  public zzaoy zzuq(String paramString)
    throws zzaph
  {
    return zza(new StringReader(paramString));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzapd
 * JD-Core Version:    0.6.0
 */