package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class FingerprintManagerCompatApi23
{
  public static void authenticate(Context paramContext, CryptoObject paramCryptoObject, int paramInt, Object paramObject, AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    getFingerprintManager(paramContext).authenticate(wrapCryptoObject(paramCryptoObject), (CancellationSignal)paramObject, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
  }

  private static FingerprintManager getFingerprintManager(Context paramContext)
  {
    return (FingerprintManager)paramContext.getSystemService(FingerprintManager.class);
  }

  public static boolean hasEnrolledFingerprints(Context paramContext)
  {
    return getFingerprintManager(paramContext).hasEnrolledFingerprints();
  }

  public static boolean isHardwareDetected(Context paramContext)
  {
    return getFingerprintManager(paramContext).isHardwareDetected();
  }

  private static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null);
    do
    {
      return null;
      if (paramCryptoObject.getCipher() != null)
        return new CryptoObject(paramCryptoObject.getCipher());
      if (paramCryptoObject.getSignature() != null)
        return new CryptoObject(paramCryptoObject.getSignature());
    }
    while (paramCryptoObject.getMac() == null);
    return new CryptoObject(paramCryptoObject.getMac());
  }

  private static FingerprintManager.AuthenticationCallback wrapCallback(AuthenticationCallback paramAuthenticationCallback)
  {
    return new FingerprintManager.AuthenticationCallback(paramAuthenticationCallback)
    {
      public void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
      {
        this.val$callback.onAuthenticationError(paramInt, paramCharSequence);
      }

      public void onAuthenticationFailed()
      {
        this.val$callback.onAuthenticationFailed();
      }

      public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
      {
        this.val$callback.onAuthenticationHelp(paramInt, paramCharSequence);
      }

      public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAuthenticationResult)
      {
        this.val$callback.onAuthenticationSucceeded(new FingerprintManagerCompatApi23.AuthenticationResultInternal(FingerprintManagerCompatApi23.access$000(paramAuthenticationResult.getCryptoObject())));
      }
    };
  }

  private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null);
    do
    {
      return null;
      if (paramCryptoObject.getCipher() != null)
        return new FingerprintManager.CryptoObject(paramCryptoObject.getCipher());
      if (paramCryptoObject.getSignature() != null)
        return new FingerprintManager.CryptoObject(paramCryptoObject.getSignature());
    }
    while (paramCryptoObject.getMac() == null);
    return new FingerprintManager.CryptoObject(paramCryptoObject.getMac());
  }

  public static abstract class AuthenticationCallback
  {
    public void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
    {
    }

    public void onAuthenticationFailed()
    {
    }

    public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
    {
    }

    public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal paramAuthenticationResultInternal)
    {
    }
  }

  public static final class AuthenticationResultInternal
  {
    private FingerprintManagerCompatApi23.CryptoObject mCryptoObject;

    public AuthenticationResultInternal(FingerprintManagerCompatApi23.CryptoObject paramCryptoObject)
    {
      this.mCryptoObject = paramCryptoObject;
    }

    public FingerprintManagerCompatApi23.CryptoObject getCryptoObject()
    {
      return this.mCryptoObject;
    }
  }

  public static class CryptoObject
  {
    private final Cipher mCipher;
    private final Mac mMac;
    private final Signature mSignature;

    public CryptoObject(Signature paramSignature)
    {
      this.mSignature = paramSignature;
      this.mCipher = null;
      this.mMac = null;
    }

    public CryptoObject(Cipher paramCipher)
    {
      this.mCipher = paramCipher;
      this.mSignature = null;
      this.mMac = null;
    }

    public CryptoObject(Mac paramMac)
    {
      this.mMac = paramMac;
      this.mCipher = null;
      this.mSignature = null;
    }

    public Cipher getCipher()
    {
      return this.mCipher;
    }

    public Mac getMac()
    {
      return this.mMac;
    }

    public Signature getSignature()
    {
      return this.mSignature;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23
 * JD-Core Version:    0.6.0
 */