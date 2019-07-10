package com.google.android.gms.common;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.dynamic.zzg.zza;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_AUTO = 2;
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  private int mColor;
  private int mSize;
  private View xi;
  private View.OnClickListener xj = null;

  public SignInButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public SignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    zzb(paramContext, paramAttributeSet);
    setStyle(this.mSize, this.mColor);
  }

  private static Button zza(Context paramContext, int paramInt1, int paramInt2)
  {
    zzaf localzzaf = new zzaf(paramContext);
    localzzaf.zza(paramContext.getResources(), paramInt1, paramInt2);
    return localzzaf;
  }

  private void zzb(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.SignInButton, 0, 0);
    try
    {
      this.mSize = paramContext.getInt(R.styleable.SignInButton_buttonSize, 0);
      this.mColor = paramContext.getInt(R.styleable.SignInButton_colorScheme, 2);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
    throw paramAttributeSet;
  }

  private void zzbw(Context paramContext)
  {
    if (this.xi != null)
      removeView(this.xi);
    try
    {
      this.xi = zzae.zzb(paramContext, this.mSize, this.mColor);
      addView(this.xi);
      this.xi.setEnabled(isEnabled());
      this.xi.setOnClickListener(this);
      return;
    }
    catch (zzg.zza localzza)
    {
      while (true)
      {
        Log.w("SignInButton", "Sign in button not found, using placeholder instead");
        this.xi = zza(paramContext, this.mSize, this.mColor);
      }
    }
  }

  public void onClick(View paramView)
  {
    if ((this.xj != null) && (paramView == this.xi))
      this.xj.onClick(this);
  }

  public void setColorScheme(int paramInt)
  {
    setStyle(this.mSize, paramInt);
  }

  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.xi.setEnabled(paramBoolean);
  }

  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.xj = paramOnClickListener;
    if (this.xi != null)
      this.xi.setOnClickListener(this);
  }

  @Deprecated
  public void setScopes(Scope[] paramArrayOfScope)
  {
    setStyle(this.mSize, this.mColor);
  }

  public void setSize(int paramInt)
  {
    setStyle(paramInt, this.mColor);
  }

  public void setStyle(int paramInt1, int paramInt2)
  {
    this.mSize = paramInt1;
    this.mColor = paramInt2;
    zzbw(getContext());
  }

  @Deprecated
  public void setStyle(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    setStyle(paramInt1, paramInt2);
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ButtonSize
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ColorScheme
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.SignInButton
 * JD-Core Version:    0.6.0
 */