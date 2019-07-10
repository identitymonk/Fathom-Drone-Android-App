.class public Lio/vov/vitamio/EGL;
.super Ljava/lang/Object;
.source "EGL.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/vov/vitamio/EGL$SimpleEGLConfigChooser;,
        Lio/vov/vitamio/EGL$ComponentSizeChooser;,
        Lio/vov/vitamio/EGL$EGLConfigChooser;,
        Lio/vov/vitamio/EGL$EGLContextFactory;,
        Lio/vov/vitamio/EGL$EGLWindowSurfaceFactory;
    }
.end annotation


# instance fields
.field private mEGLConfigChooser:Lio/vov/vitamio/EGL$EGLConfigChooser;

.field private mEGLContextFactory:Lio/vov/vitamio/EGL$EGLContextFactory;

.field private mEGLWindowSurfaceFactory:Lio/vov/vitamio/EGL$EGLWindowSurfaceFactory;

.field private mEgl:Ljavax/microedition/khronos/egl/EGL10;

.field private mEglConfig:Ljavax/microedition/khronos/egl/EGLConfig;

.field private mEglContext:Ljavax/microedition/khronos/egl/EGLContext;

.field private mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

.field private mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    new-instance v0, Lio/vov/vitamio/EGL$SimpleEGLConfigChooser;

    invoke-direct {v0, p0}, Lio/vov/vitamio/EGL$SimpleEGLConfigChooser;-><init>(Lio/vov/vitamio/EGL;)V

    iput-object v0, p0, Lio/vov/vitamio/EGL;->mEGLConfigChooser:Lio/vov/vitamio/EGL$EGLConfigChooser;

    .line 45
    new-instance v0, Lio/vov/vitamio/EGL$EGLContextFactory;

    invoke-direct {v0, p0, v1}, Lio/vov/vitamio/EGL$EGLContextFactory;-><init>(Lio/vov/vitamio/EGL;Lio/vov/vitamio/EGL$1;)V

    iput-object v0, p0, Lio/vov/vitamio/EGL;->mEGLContextFactory:Lio/vov/vitamio/EGL$EGLContextFactory;

    .line 46
    new-instance v0, Lio/vov/vitamio/EGL$EGLWindowSurfaceFactory;

    invoke-direct {v0, v1}, Lio/vov/vitamio/EGL$EGLWindowSurfaceFactory;-><init>(Lio/vov/vitamio/EGL$1;)V

    iput-object v0, p0, Lio/vov/vitamio/EGL;->mEGLWindowSurfaceFactory:Lio/vov/vitamio/EGL$EGLWindowSurfaceFactory;

    .line 47
    return-void
.end method

.method private throwEglException(Ljava/lang/String;)V
    .locals 1
    .param p1, "function"    # Ljava/lang/String;

    .prologue
    .line 154
    iget-object v0, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    invoke-interface {v0}, Ljavax/microedition/khronos/egl/EGL10;->eglGetError()I

    move-result v0

    invoke-direct {p0, p1, v0}, Lio/vov/vitamio/EGL;->throwEglException(Ljava/lang/String;I)V

    .line 155
    return-void
.end method

.method private throwEglException(Ljava/lang/String;I)V
    .locals 6
    .param p1, "function"    # Ljava/lang/String;
    .param p2, "error"    # I

    .prologue
    .line 158
    const-string v1, "%s failed: %x"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 159
    .local v0, "message":Ljava/lang/String;
    const-string v1, "EglHelper"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "throwEglException tid="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Thread;->getId()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 160
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method


# virtual methods
.method public createSurface(Landroid/view/Surface;)Ljavax/microedition/khronos/opengles/GL;
    .locals 7
    .param p1, "surface"    # Landroid/view/Surface;

    .prologue
    .line 83
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    if-nez v2, :cond_0

    .line 84
    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "egl not initialized"

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 85
    :cond_0
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    if-nez v2, :cond_1

    .line 86
    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "eglDisplay not initialized"

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 87
    :cond_1
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEglConfig:Ljavax/microedition/khronos/egl/EGLConfig;

    if-nez v2, :cond_2

    .line 88
    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "mEglConfig not initialized"

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 90
    :cond_2
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    sget-object v3, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_SURFACE:Ljavax/microedition/khronos/egl/EGLSurface;

    if-eq v2, v3, :cond_3

    .line 91
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v3, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    sget-object v4, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_SURFACE:Ljavax/microedition/khronos/egl/EGLSurface;

    sget-object v5, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_SURFACE:Ljavax/microedition/khronos/egl/EGLSurface;

    sget-object v6, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_CONTEXT:Ljavax/microedition/khronos/egl/EGLContext;

    invoke-interface {v2, v3, v4, v5, v6}, Ljavax/microedition/khronos/egl/EGL10;->eglMakeCurrent(Ljavax/microedition/khronos/egl/EGLDisplay;Ljavax/microedition/khronos/egl/EGLSurface;Ljavax/microedition/khronos/egl/EGLSurface;Ljavax/microedition/khronos/egl/EGLContext;)Z

    .line 92
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEGLWindowSurfaceFactory:Lio/vov/vitamio/EGL$EGLWindowSurfaceFactory;

    iget-object v3, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v4, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    iget-object v5, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    invoke-virtual {v2, v3, v4, v5}, Lio/vov/vitamio/EGL$EGLWindowSurfaceFactory;->destroySurface(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;Ljavax/microedition/khronos/egl/EGLSurface;)V

    .line 95
    :cond_3
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEGLWindowSurfaceFactory:Lio/vov/vitamio/EGL$EGLWindowSurfaceFactory;

    iget-object v3, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v4, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    iget-object v5, p0, Lio/vov/vitamio/EGL;->mEglConfig:Ljavax/microedition/khronos/egl/EGLConfig;

    invoke-virtual {v2, v3, v4, v5, p1}, Lio/vov/vitamio/EGL$EGLWindowSurfaceFactory;->createWindowSurface(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;Ljavax/microedition/khronos/egl/EGLConfig;Ljava/lang/Object;)Ljavax/microedition/khronos/egl/EGLSurface;

    move-result-object v2

    iput-object v2, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    .line 97
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    if-eqz v2, :cond_4

    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    sget-object v3, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_SURFACE:Ljavax/microedition/khronos/egl/EGLSurface;

    if-ne v2, v3, :cond_6

    .line 98
    :cond_4
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    invoke-interface {v2}, Ljavax/microedition/khronos/egl/EGL10;->eglGetError()I

    move-result v0

    .line 99
    .local v0, "error":I
    const/16 v2, 0x300b

    if-ne v0, v2, :cond_5

    .line 100
    const-string v2, "EglHelper"

    const-string v3, "createWindowSurface returned EGL_BAD_NATIVE_WINDOW."

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 101
    const/4 v1, 0x0

    .line 112
    .end local v0    # "error":I
    :goto_0
    return-object v1

    .line 103
    .restart local v0    # "error":I
    :cond_5
    const-string v2, "createWindowSurface"

    invoke-direct {p0, v2, v0}, Lio/vov/vitamio/EGL;->throwEglException(Ljava/lang/String;I)V

    .line 106
    .end local v0    # "error":I
    :cond_6
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v3, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    iget-object v4, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    iget-object v5, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    iget-object v6, p0, Lio/vov/vitamio/EGL;->mEglContext:Ljavax/microedition/khronos/egl/EGLContext;

    invoke-interface {v2, v3, v4, v5, v6}, Ljavax/microedition/khronos/egl/EGL10;->eglMakeCurrent(Ljavax/microedition/khronos/egl/EGLDisplay;Ljavax/microedition/khronos/egl/EGLSurface;Ljavax/microedition/khronos/egl/EGLSurface;Ljavax/microedition/khronos/egl/EGLContext;)Z

    move-result v2

    if-nez v2, :cond_7

    .line 107
    const-string v2, "eglMakeCurrent"

    invoke-direct {p0, v2}, Lio/vov/vitamio/EGL;->throwEglException(Ljava/lang/String;)V

    .line 110
    :cond_7
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEglContext:Ljavax/microedition/khronos/egl/EGLContext;

    invoke-virtual {v2}, Ljavax/microedition/khronos/egl/EGLContext;->getGL()Ljavax/microedition/khronos/opengles/GL;

    move-result-object v1

    .line 112
    .local v1, "gl":Ljavax/microedition/khronos/opengles/GL;
    goto :goto_0
.end method

.method public destroySurface()V
    .locals 5

    .prologue
    .line 135
    iget-object v0, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    sget-object v1, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_SURFACE:Ljavax/microedition/khronos/egl/EGLSurface;

    if-eq v0, v1, :cond_0

    .line 136
    iget-object v0, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v1, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    sget-object v2, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_SURFACE:Ljavax/microedition/khronos/egl/EGLSurface;

    sget-object v3, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_SURFACE:Ljavax/microedition/khronos/egl/EGLSurface;

    sget-object v4, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_CONTEXT:Ljavax/microedition/khronos/egl/EGLContext;

    invoke-interface {v0, v1, v2, v3, v4}, Ljavax/microedition/khronos/egl/EGL10;->eglMakeCurrent(Ljavax/microedition/khronos/egl/EGLDisplay;Ljavax/microedition/khronos/egl/EGLSurface;Ljavax/microedition/khronos/egl/EGLSurface;Ljavax/microedition/khronos/egl/EGLContext;)Z

    .line 137
    iget-object v0, p0, Lio/vov/vitamio/EGL;->mEGLWindowSurfaceFactory:Lio/vov/vitamio/EGL$EGLWindowSurfaceFactory;

    iget-object v1, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    iget-object v3, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    invoke-virtual {v0, v1, v2, v3}, Lio/vov/vitamio/EGL$EGLWindowSurfaceFactory;->destroySurface(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;Ljavax/microedition/khronos/egl/EGLSurface;)V

    .line 138
    const/4 v0, 0x0

    iput-object v0, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    .line 140
    :cond_0
    return-void
.end method

.method public finish()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 143
    iget-object v0, p0, Lio/vov/vitamio/EGL;->mEglContext:Ljavax/microedition/khronos/egl/EGLContext;

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lio/vov/vitamio/EGL;->mEGLContextFactory:Lio/vov/vitamio/EGL$EGLContextFactory;

    iget-object v1, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    iget-object v3, p0, Lio/vov/vitamio/EGL;->mEglContext:Ljavax/microedition/khronos/egl/EGLContext;

    invoke-virtual {v0, v1, v2, v3}, Lio/vov/vitamio/EGL$EGLContextFactory;->destroyContext(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;Ljavax/microedition/khronos/egl/EGLContext;)V

    .line 145
    iput-object v4, p0, Lio/vov/vitamio/EGL;->mEglContext:Ljavax/microedition/khronos/egl/EGLContext;

    .line 147
    :cond_0
    iget-object v0, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    if-eqz v0, :cond_1

    .line 148
    iget-object v0, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v1, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    invoke-interface {v0, v1}, Ljavax/microedition/khronos/egl/EGL10;->eglTerminate(Ljavax/microedition/khronos/egl/EGLDisplay;)Z

    .line 149
    iput-object v4, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    .line 151
    :cond_1
    return-void
.end method

.method public initialize(Landroid/view/Surface;)Z
    .locals 1
    .param p1, "surface"    # Landroid/view/Surface;

    .prologue
    .line 50
    invoke-virtual {p0}, Lio/vov/vitamio/EGL;->start()V

    .line 51
    invoke-virtual {p0, p1}, Lio/vov/vitamio/EGL;->createSurface(Landroid/view/Surface;)Ljavax/microedition/khronos/opengles/GL;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public release()V
    .locals 0

    .prologue
    .line 55
    invoke-virtual {p0}, Lio/vov/vitamio/EGL;->destroySurface()V

    .line 56
    invoke-virtual {p0}, Lio/vov/vitamio/EGL;->finish()V

    .line 57
    return-void
.end method

.method public start()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 60
    invoke-static {}, Ljavax/microedition/khronos/egl/EGLContext;->getEGL()Ljavax/microedition/khronos/egl/EGL;

    move-result-object v1

    check-cast v1, Ljavax/microedition/khronos/egl/EGL10;

    iput-object v1, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    .line 61
    iget-object v1, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    sget-object v2, Ljavax/microedition/khronos/egl/EGL10;->EGL_DEFAULT_DISPLAY:Ljava/lang/Object;

    invoke-interface {v1, v2}, Ljavax/microedition/khronos/egl/EGL10;->eglGetDisplay(Ljava/lang/Object;)Ljavax/microedition/khronos/egl/EGLDisplay;

    move-result-object v1

    iput-object v1, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    .line 63
    iget-object v1, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    sget-object v2, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_DISPLAY:Ljavax/microedition/khronos/egl/EGLDisplay;

    if-ne v1, v2, :cond_0

    .line 64
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "eglGetDisplay failed"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 67
    :cond_0
    const/4 v1, 0x2

    new-array v0, v1, [I

    .line 68
    .local v0, "version":[I
    iget-object v1, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    invoke-interface {v1, v2, v0}, Ljavax/microedition/khronos/egl/EGL10;->eglInitialize(Ljavax/microedition/khronos/egl/EGLDisplay;[I)Z

    move-result v1

    if-nez v1, :cond_1

    .line 69
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "eglInitialize failed"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 71
    :cond_1
    iget-object v1, p0, Lio/vov/vitamio/EGL;->mEGLConfigChooser:Lio/vov/vitamio/EGL$EGLConfigChooser;

    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v3, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    invoke-virtual {v1, v2, v3}, Lio/vov/vitamio/EGL$EGLConfigChooser;->chooseConfig(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;)Ljavax/microedition/khronos/egl/EGLConfig;

    move-result-object v1

    iput-object v1, p0, Lio/vov/vitamio/EGL;->mEglConfig:Ljavax/microedition/khronos/egl/EGLConfig;

    .line 73
    iget-object v1, p0, Lio/vov/vitamio/EGL;->mEGLContextFactory:Lio/vov/vitamio/EGL$EGLContextFactory;

    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v3, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    iget-object v4, p0, Lio/vov/vitamio/EGL;->mEglConfig:Ljavax/microedition/khronos/egl/EGLConfig;

    invoke-virtual {v1, v2, v3, v4}, Lio/vov/vitamio/EGL$EGLContextFactory;->createContext(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;Ljavax/microedition/khronos/egl/EGLConfig;)Ljavax/microedition/khronos/egl/EGLContext;

    move-result-object v1

    iput-object v1, p0, Lio/vov/vitamio/EGL;->mEglContext:Ljavax/microedition/khronos/egl/EGLContext;

    .line 74
    iget-object v1, p0, Lio/vov/vitamio/EGL;->mEglContext:Ljavax/microedition/khronos/egl/EGLContext;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lio/vov/vitamio/EGL;->mEglContext:Ljavax/microedition/khronos/egl/EGLContext;

    sget-object v2, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_CONTEXT:Ljavax/microedition/khronos/egl/EGLContext;

    if-ne v1, v2, :cond_3

    .line 75
    :cond_2
    iput-object v5, p0, Lio/vov/vitamio/EGL;->mEglContext:Ljavax/microedition/khronos/egl/EGLContext;

    .line 76
    const-string v1, "createContext"

    invoke-direct {p0, v1}, Lio/vov/vitamio/EGL;->throwEglException(Ljava/lang/String;)V

    .line 79
    :cond_3
    iput-object v5, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    .line 80
    return-void
.end method

.method public swap()Z
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 116
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    iget-object v3, p0, Lio/vov/vitamio/EGL;->mEglDisplay:Ljavax/microedition/khronos/egl/EGLDisplay;

    iget-object v4, p0, Lio/vov/vitamio/EGL;->mEglSurface:Ljavax/microedition/khronos/egl/EGLSurface;

    invoke-interface {v2, v3, v4}, Ljavax/microedition/khronos/egl/EGL10;->eglSwapBuffers(Ljavax/microedition/khronos/egl/EGLDisplay;Ljavax/microedition/khronos/egl/EGLSurface;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 117
    iget-object v2, p0, Lio/vov/vitamio/EGL;->mEgl:Ljavax/microedition/khronos/egl/EGL10;

    invoke-interface {v2}, Ljavax/microedition/khronos/egl/EGL10;->eglGetError()I

    move-result v0

    .line 118
    .local v0, "error":I
    packed-switch v0, :pswitch_data_0

    .line 128
    :pswitch_0
    const-string v1, "eglSwapBuffers"

    invoke-direct {p0, v1, v0}, Lio/vov/vitamio/EGL;->throwEglException(Ljava/lang/String;I)V

    .line 131
    .end local v0    # "error":I
    :cond_0
    :goto_0
    const/4 v1, 0x1

    :goto_1
    :pswitch_1
    return v1

    .line 122
    .restart local v0    # "error":I
    :pswitch_2
    const-string v1, "EglHelper"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "eglSwapBuffers returned EGL_BAD_NATIVE_WINDOW. tid="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Thread;->getId()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 125
    :pswitch_3
    const-string v2, "EglHelper"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "eglSwapBuffers returned EGL_BAD_SURFACE. tid="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Thread;->getId()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 118
    nop

    :pswitch_data_0
    .packed-switch 0x300b
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_1
    .end packed-switch
.end method
