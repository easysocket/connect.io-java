package com.ikimuhendis.connectio.example;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIOException;

import org.json.JSONObject;

import com.ikimuhendis.connectio.ConnectIO;

public class Example {

	public static void main(String[] args) {

		try {

			ConnectIO c = new ConnectIO("http://pc.minikod.com:8081");
			c.connect(new IOCallback() {

				@Override
				public void onMessage(JSONObject json, IOAcknowledge ack) {
					System.out.println("EXP_ on message json : "
							+ json.toString());
				}

				@Override
				public void onMessage(String data, IOAcknowledge ack) {
					System.out.println("EXP_ on message string : " + data);
				}

				@Override
				public void onError(SocketIOException socketIOException) {
					System.out.println("EXP_ error : "
							+ socketIOException.toString());
				}

				@Override
				public void onDisconnect() {
					System.out.println("EXP_ disconnect : ");
				}

				@Override
				public void onConnect() {
					System.out.println("EXP_ connect : ");
				}

				@Override
				public void on(String event, IOAcknowledge ack, Object... args) {
					System.out.println("EXP_ on Event : " + event);
				}
			});
			
			JSONObject obj=new JSONObject();
			obj.put("method", "add_topic");
			obj.put("data", "asdasdasds");
			
			c.sendJSON("socketEvent", obj);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
