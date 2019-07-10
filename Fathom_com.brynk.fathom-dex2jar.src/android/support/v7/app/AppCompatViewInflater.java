package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintContextWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

class AppCompatViewInflater
{
  private static final String LOG_TAG = "AppCompatViewInflater";
  private static final String[] sClassPrefixList;
  private static final Map<String, Constructor<? extends View>> sConstructorMap;
  private static final Class<?>[] sConstructorSignature = { Context.class, AttributeSet.class };
  private static final int[] sOnClickAttrs = { 16843375 };
  private final Object[] mConstructorArgs = new Object[2];

  static
  {
    sClassPrefixList = new String[] { "android.widget.", "android.view.", "android.webkit." };
    sConstructorMap = new ArrayMap();
  }

  private void checkOnClickListener(View paramView, AttributeSet paramAttributeSet)
  {
    Object localObject = paramView.getContext();
    if ((!(localObject instanceof ContextWrapper)) || ((Build.VERSION.SDK_INT >= 15) && (!ViewCompat.hasOnClickListeners(paramView))))
      return;
    paramAttributeSet = ((Context)localObject).obtainStyledAttributes(paramAttributeSet, sOnClickAttrs);
    localObject = paramAttributeSet.getString(0);
    if (localObject != null)
      paramView.setOnClickListener(new DeclaredOnClickListener(paramView, (String)localObject));
    paramAttributeSet.recycle();
  }

  private View createView(Context paramContext, String paramString1, String paramString2)
    throws ClassNotFoundException, InflateException
  {
    Constructor localConstructor = (Constructor)sConstructorMap.get(paramString1);
    Object localObject = localConstructor;
    if (localConstructor == null);
    try
    {
      localObject = paramContext.getClassLoader();
      if (paramString2 != null);
      for (paramContext = paramString2 + paramString1; ; paramContext = paramString1)
      {
        localObject = ((ClassLoader)localObject).loadClass(paramContext).asSubclass(View.class).getConstructor(sConstructorSignature);
        sConstructorMap.put(paramString1, localObject);
        ((Constructor)localObject).setAccessible(true);
        paramContext = (View)((Constructor)localObject).newInstance(this.mConstructorArgs);
        return paramContext;
      }
    }
    catch (java.lang.Exception paramContext)
    {
    }
    return (View)null;
  }

  private View createViewFromTag(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    String str = paramString;
    if (paramString.equals("view"))
      str = paramAttributeSet.getAttributeValue(null, "class");
    try
    {
      this.mConstructorArgs[0] = paramContext;
      this.mConstructorArgs[1] = paramAttributeSet;
      if (-1 == str.indexOf('.'))
      {
        int i = 0;
        while (i < sClassPrefixList.length)
        {
          paramString = createView(paramContext, str, sClassPrefixList[i]);
          if (paramString != null)
            return paramString;
          i += 1;
        }
        return null;
      }
      paramContext = createView(paramContext, str, null);
      return paramContext;
    }
    catch (java.lang.Exception paramContext)
    {
      return null;
    }
    finally
    {
      this.mConstructorArgs[0] = null;
      this.mConstructorArgs[1] = null;
    }
    throw paramContext;
  }

  private static Context themifyContext(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View, 0, 0);
    int i = 0;
    if (paramBoolean1)
      i = paramAttributeSet.getResourceId(R.styleable.View_android_theme, 0);
    int j = i;
    if (paramBoolean2)
    {
      j = i;
      if (i == 0)
      {
        i = paramAttributeSet.getResourceId(R.styleable.View_theme, 0);
        j = i;
        if (i != 0)
        {
          Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
          j = i;
        }
      }
    }
    paramAttributeSet.recycle();
    paramAttributeSet = paramContext;
    if (j != 0)
      if ((paramContext instanceof ContextThemeWrapper))
      {
        paramAttributeSet = paramContext;
        if (((ContextThemeWrapper)paramContext).getThemeResId() == j);
      }
      else
      {
        paramAttributeSet = new ContextThemeWrapper(paramContext, j);
      }
    return paramAttributeSet;
  }

  public final View createView(View paramView, String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject = paramContext;
    if (paramBoolean1)
    {
      localObject = paramContext;
      if (paramView != null)
        localObject = paramView.getContext();
    }
    if (!paramBoolean2)
    {
      paramView = (View)localObject;
      if (!paramBoolean3);
    }
    else
    {
      paramView = themifyContext((Context)localObject, paramAttributeSet, paramBoolean2, paramBoolean3);
    }
    localObject = paramView;
    if (paramBoolean4)
      localObject = TintContextWrapper.wrap(paramView);
    paramView = null;
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
      switch (i)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      }
    case -938935918:
    case 1125864064:
    case 2001146706:
    case 1666676343:
    case -339785223:
    case -937446323:
    case 1601505219:
    case 776382189:
    case -1455429095:
    case 1413872058:
    case -1346021293:
    case -1946472170:
    case -658531749:
    }
    while (true)
    {
      View localView = paramView;
      if (paramView == null)
      {
        localView = paramView;
        if (paramContext != localObject)
          localView = createViewFromTag((Context)localObject, paramString, paramAttributeSet);
      }
      if (localView != null)
        checkOnClickListener(localView, paramAttributeSet);
      return localView;
      if (!paramString.equals("TextView"))
        break;
      i = 0;
      break;
      if (!paramString.equals("ImageView"))
        break;
      i = 1;
      break;
      if (!paramString.equals("Button"))
        break;
      i = 2;
      break;
      if (!paramString.equals("EditText"))
        break;
      i = 3;
      break;
      if (!paramString.equals("Spinner"))
        break;
      i = 4;
      break;
      if (!paramString.equals("ImageButton"))
        break;
      i = 5;
      break;
      if (!paramString.equals("CheckBox"))
        break;
      i = 6;
      break;
      if (!paramString.equals("RadioButton"))
        break;
      i = 7;
      break;
      if (!paramString.equals("CheckedTextView"))
        break;
      i = 8;
      break;
      if (!paramString.equals("AutoCompleteTextView"))
        break;
      i = 9;
      break;
      if (!paramString.equals("MultiAutoCompleteTextView"))
        break;
      i = 10;
      break;
      if (!paramString.equals("RatingBar"))
        break;
      i = 11;
      break;
      if (!paramString.equals("SeekBar"))
        break;
      i = 12;
      break;
      paramView = new AppCompatTextView((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatImageView((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatButton((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatEditText((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatSpinner((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatImageButton((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatCheckBox((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatRadioButton((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatCheckedTextView((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatAutoCompleteTextView((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatMultiAutoCompleteTextView((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatRatingBar((Context)localObject, paramAttributeSet);
      continue;
      paramView = new AppCompatSeekBar((Context)localObject, paramAttributeSet);
    }
  }

  private static class DeclaredOnClickListener
    implements View.OnClickListener
  {
    private final View mHostView;
    private final String mMethodName;
    private Context mResolvedContext;
    private Method mResolvedMethod;

    public DeclaredOnClickListener(@NonNull View paramView, @NonNull String paramString)
    {
      this.mHostView = paramView;
      this.mMethodName = paramString;
    }

    @NonNull
    private void resolveMethod(@Nullable Context paramContext, @NonNull String paramString)
    {
      while (paramContext != null)
        try
        {
          if (!paramContext.isRestricted())
          {
            paramString = paramContext.getClass().getMethod(this.mMethodName, new Class[] { View.class });
            if (paramString != null)
            {
              this.mResolvedMethod = paramString;
              this.mResolvedContext = paramContext;
              return;
            }
          }
        }
        catch (java.lang.NoSuchMethodException paramString)
        {
          if ((paramContext instanceof ContextWrapper))
          {
            paramContext = ((ContextWrapper)paramContext).getBaseContext();
            continue;
          }
          paramContext = null;
        }
      int i = this.mHostView.getId();
      if (i == -1);
      for (paramContext = ""; ; paramContext = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(i) + "'")
        throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.mHostView.getClass() + paramContext);
    }

    public void onClick(@NonNull View paramView)
    {
      if (this.mResolvedMethod == null)
        resolveMethod(this.mHostView.getContext(), this.mMethodName);
      try
      {
        this.mResolvedMethod.invoke(this.mResolvedContext, new Object[] { paramView });
        return;
      }
      catch (java.lang.IllegalAccessException paramView)
      {
        throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
      }
      catch (java.lang.reflect.InvocationTargetException paramView)
      {
      }
      throw new IllegalStateException("Could not execute method for android:onClick", paramView);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.app.AppCompatViewInflater
 * JD-Core Version:    0.6.0
 */