package io.vov.vitamio;

import android.util.Log;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class EGL
{
  private EGLConfigChooser mEGLConfigChooser = new SimpleEGLConfigChooser();
  private EGLContextFactory mEGLContextFactory = new EGLContextFactory(null);
  private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory = new EGLWindowSurfaceFactory(null);
  private EGL10 mEgl;
  private EGLConfig mEglConfig;
  private EGLContext mEglContext;
  private EGLDisplay mEglDisplay;
  private EGLSurface mEglSurface;

  private void throwEglException(String paramString)
  {
    throwEglException(paramString, this.mEgl.eglGetError());
  }

  private void throwEglException(String paramString, int paramInt)
  {
    paramString = String.format("%s failed: %x", new Object[] { paramString, Integer.valueOf(paramInt) });
    Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + paramString);
    throw new RuntimeException(paramString);
  }

  public GL createSurface(Surface paramSurface)
  {
    if (this.mEgl == null)
      throw new RuntimeException("egl not initialized");
    if (this.mEglDisplay == null)
      throw new RuntimeException("eglDisplay not initialized");
    if (this.mEglConfig == null)
      throw new RuntimeException("mEglConfig not initialized");
    if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
    {
      this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
    }
    this.mEglSurface = this.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, paramSurface);
    if ((this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE))
    {
      int i = this.mEgl.eglGetError();
      if (i == 12299)
      {
        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
        return null;
      }
      throwEglException("createWindowSurface", i);
    }
    if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))
      throwEglException("eglMakeCurrent");
    return this.mEglContext.getGL();
  }

  public void destroySurface()
  {
    if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
    {
      this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
      this.mEglSurface = null;
    }
  }

  public void finish()
  {
    if (this.mEglContext != null)
    {
      this.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
      this.mEglContext = null;
    }
    if (this.mEglDisplay != null)
    {
      this.mEgl.eglTerminate(this.mEglDisplay);
      this.mEglDisplay = null;
    }
  }

  public boolean initialize(Surface paramSurface)
  {
    start();
    return createSurface(paramSurface) != null;
  }

  public void release()
  {
    destroySurface();
    finish();
  }

  public void start()
  {
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY)
      throw new RuntimeException("eglGetDisplay failed");
    int[] arrayOfInt = new int[2];
    if (!this.mEgl.eglInitialize(this.mEglDisplay, arrayOfInt))
      throw new RuntimeException("eglInitialize failed");
    this.mEglConfig = this.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
    this.mEglContext = this.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
    if ((this.mEglContext == null) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
    {
      this.mEglContext = null;
      throwEglException("createContext");
    }
    this.mEglSurface = null;
  }

  public boolean swap()
  {
    int j = 0;
    int i;
    if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface))
      i = this.mEgl.eglGetError();
    switch (i)
    {
    case 12300:
    default:
      throwEglException("eglSwapBuffers", i);
    case 12302:
    case 12299:
      while (true)
      {
        j = 1;
        return j;
        Log.e("EglHelper", "eglSwapBuffers returned EGL_BAD_NATIVE_WINDOW. tid=" + Thread.currentThread().getId());
      }
    case 12301:
    }
    Log.e("EglHelper", "eglSwapBuffers returned EGL_BAD_SURFACE. tid=" + Thread.currentThread().getId());
    return false;
  }

  private class ComponentSizeChooser extends EGL.EGLConfigChooser
  {
    protected int mAlphaSize;
    protected int mBlueSize;
    protected int mDepthSize;
    protected int mGreenSize;
    protected int mRedSize;
    protected int mStencilSize;
    private int[] mValue = new int[1];

    public ComponentSizeChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int arg7)
    {
      super(new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, i, 12344 });
      this.mRedSize = paramInt1;
      this.mGreenSize = paramInt2;
      this.mBlueSize = paramInt3;
      this.mAlphaSize = paramInt4;
      this.mDepthSize = paramInt5;
      this.mStencilSize = i;
    }

    private int findConfigAttrib(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
    {
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.mValue))
        paramInt2 = this.mValue[0];
      return paramInt2;
    }

    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      int j = paramArrayOfEGLConfig.length;
      int i = 0;
      while (i < j)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
        int m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
        if ((k >= this.mDepthSize) && (m >= this.mStencilSize))
        {
          k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
          m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
          int n = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
          int i1 = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
          if ((k == this.mRedSize) && (m == this.mGreenSize) && (n == this.mBlueSize) && (i1 == this.mAlphaSize))
            return localEGLConfig;
        }
        i += 1;
      }
      return null;
    }
  }

  private abstract class EGLConfigChooser
  {
    protected int[] mConfigSpec;

    public EGLConfigChooser(int[] arg2)
    {
      int[] arrayOfInt;
      this.mConfigSpec = filterConfigSpec(arrayOfInt);
    }

    private int[] filterConfigSpec(int[] paramArrayOfInt)
    {
      int i = paramArrayOfInt.length;
      int[] arrayOfInt = new int[i + 2];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
      arrayOfInt[(i - 1)] = 12352;
      arrayOfInt[i] = 4;
      arrayOfInt[(i + 1)] = 12344;
      return arrayOfInt;
    }

    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, null, 0, arrayOfInt))
        throw new IllegalArgumentException("eglChooseConfig failed");
      int i = arrayOfInt[0];
      if (i <= 0)
        throw new IllegalArgumentException("No configs match configSpec");
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, arrayOfEGLConfig, i, arrayOfInt))
        throw new IllegalArgumentException("eglChooseConfig#2 failed");
      paramEGL10 = chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      if (paramEGL10 == null)
        throw new IllegalArgumentException("No config chosen");
      return paramEGL10;
    }

    abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
  }

  private class EGLContextFactory
  {
    private int EGL_CONTEXT_CLIENT_VERSION = 12440;

    private EGLContextFactory()
    {
    }

    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int i = this.EGL_CONTEXT_CLIENT_VERSION;
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    }

    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        Log.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
        throw new RuntimeException("eglDestroyContext failed: ");
      }
    }
  }

  private static class EGLWindowSurfaceFactory
  {
    public EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      return paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
    }

    public void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    }
  }

  private class SimpleEGLConfigChooser extends EGL.ComponentSizeChooser
  {
    public SimpleEGLConfigChooser()
    {
      super(5, 6, 5, 0, 0, 0);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.EGL
 * JD-Core Version:    0.6.0
 */