.class public interface abstract Lcom/facebook/react/devsupport/interfaces/DevSupportManager;
.super Ljava/lang/Object;
.source "DevSupportManager.java"

# interfaces
.implements Lcom/facebook/react/bridge/NativeModuleCallExceptionHandler;


# virtual methods
.method public abstract addCustomDevOption(Ljava/lang/String;Lcom/facebook/react/devsupport/interfaces/DevOptionHandler;)V
.end method

.method public abstract downloadBundleResourceFromUrlSync(Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end method

.method public abstract getDevSettings()Lcom/facebook/react/modules/debug/interfaces/DeveloperSettings;
.end method

.method public abstract getDevSupportEnabled()Z
.end method

.method public abstract getDownloadedJSBundleFile()Ljava/lang/String;
.end method

.method public abstract getJSBundleURLForRemoteDebugging()Ljava/lang/String;
.end method

.method public abstract getLastErrorStack()[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end method

.method public abstract getLastErrorTitle()Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end method

.method public abstract getSourceMapUrl()Ljava/lang/String;
.end method

.method public abstract getSourceUrl()Ljava/lang/String;
.end method

.method public abstract handleReloadJS()V
.end method

.method public abstract hasUpToDateJSBundleInCache()Z
.end method

.method public abstract hideRedboxDialog()V
.end method

.method public abstract isPackagerRunning(Lcom/facebook/react/devsupport/interfaces/PackagerStatusCallback;)V
.end method

.method public abstract onNewReactContextCreated(Lcom/facebook/react/bridge/ReactContext;)V
.end method

.method public abstract onReactInstanceDestroyed(Lcom/facebook/react/bridge/ReactContext;)V
.end method

.method public abstract registerErrorCustomizer(Lcom/facebook/react/devsupport/interfaces/ErrorCustomizer;)V
.end method

.method public abstract reloadJSFromServer(Ljava/lang/String;)V
.end method

.method public abstract reloadSettings()V
.end method

.method public abstract setDevSupportEnabled(Z)V
.end method

.method public abstract showDevOptionsDialog()V
.end method

.method public abstract showNewJSError(Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;I)V
.end method

.method public abstract showNewJavaError(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public abstract startInspector()V
.end method

.method public abstract stopInspector()V
.end method

.method public abstract updateJSError(Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;I)V
.end method
