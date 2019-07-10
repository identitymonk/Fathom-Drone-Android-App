package okhttp3;

import okio.ByteString;

public abstract class WebSocketListener
{
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
  }

  public void onClosing(WebSocket paramWebSocket, int paramInt, String paramString)
  {
  }

  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, Response paramResponse)
  {
  }

  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
  }

  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
  }

  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.WebSocketListener
 * JD-Core Version:    0.6.0
 */