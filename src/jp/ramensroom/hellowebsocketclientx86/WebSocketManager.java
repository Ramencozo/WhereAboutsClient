package jp.ramensroom.hellowebsocketclientx86;


import java.net.URI;
import java.net.URISyntaxException;

import de.roderick.weberknecht.WebSocket;
import de.roderick.weberknecht.WebSocketConnection;
import de.roderick.weberknecht.WebSocketEventHandler;
import de.roderick.weberknecht.WebSocketException;


public class WebSocketManager{
	private WebSocket webSocket;
	private boolean connectState;

	public WebSocketManager() {
		connectState = false;
	}
	
	public void connect(String url, WebSocketEventHandler handler){
		try {
			URI uri = new URI(url);
			webSocket = new WebSocketConnection(uri);
			webSocket.setEventHandler(handler);
			webSocket.connect();
			
			connectState = true;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebSocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send(String message){
		try {
			webSocket.send(message);
		} catch (WebSocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			webSocket.close();
			connectState = false;
		} catch (WebSocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isConnected(){
		return connectState;
	}
}