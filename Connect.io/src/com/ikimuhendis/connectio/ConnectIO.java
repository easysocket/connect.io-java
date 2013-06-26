package com.ikimuhendis.connectio;

import io.socket.IOCallback;
import io.socket.SocketIO;

import org.json.JSONObject;

public class ConnectIO {

	private String url;
	private SocketIO socket = null;

	public ConnectIO(String url) {
		this.url = url;
	}

	public void connect(IOCallback callBack) throws Exception {
		if (socket == null)
			socket = new SocketIO();
		if (!socket.isConnected())
			socket.connect(url, callBack);
	}

	public void disconnect() throws Exception {
		if (socket != null && socket.isConnected())
			socket.disconnect();
	}

	public void sendJSON(String action, JSONObject json) throws Exception {
		if (TextUtil.isEmpty(action))
			throw new Exception("Action is empty");

		if (socket == null)
			throw new Exception("Connect First ");

		socket.emit(action, json);
	}

}
