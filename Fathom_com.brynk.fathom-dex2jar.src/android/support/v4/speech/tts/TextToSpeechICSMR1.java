package android.support.v4.speech.tts;

import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.speech.tts.UtteranceProgressListener;
import java.util.Locale;
import java.util.Set;

class TextToSpeechICSMR1
{
  public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
  public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";

  static Set<String> getFeatures(TextToSpeech paramTextToSpeech, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 15)
      return paramTextToSpeech.getFeatures(paramLocale);
    return null;
  }

  static void setUtteranceProgressListener(TextToSpeech paramTextToSpeech, UtteranceProgressListenerICSMR1 paramUtteranceProgressListenerICSMR1)
  {
    if (Build.VERSION.SDK_INT >= 15)
    {
      paramTextToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener(paramUtteranceProgressListenerICSMR1)
      {
        public void onDone(String paramString)
        {
          this.val$listener.onDone(paramString);
        }

        public void onError(String paramString)
        {
          this.val$listener.onError(paramString);
        }

        public void onStart(String paramString)
        {
          this.val$listener.onStart(paramString);
        }
      });
      return;
    }
    paramTextToSpeech.setOnUtteranceCompletedListener(new TextToSpeech.OnUtteranceCompletedListener(paramUtteranceProgressListenerICSMR1)
    {
      public void onUtteranceCompleted(String paramString)
      {
        this.val$listener.onStart(paramString);
        this.val$listener.onDone(paramString);
      }
    });
  }

  static abstract interface UtteranceProgressListenerICSMR1
  {
    public abstract void onDone(String paramString);

    public abstract void onError(String paramString);

    public abstract void onStart(String paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.speech.tts.TextToSpeechICSMR1
 * JD-Core Version:    0.6.0
 */