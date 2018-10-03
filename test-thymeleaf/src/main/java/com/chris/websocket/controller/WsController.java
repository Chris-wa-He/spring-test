package com.chris.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.chris.websocket.obj.WebSocketReceiveMessageObj;
import com.chris.websocket.obj.WebSocketSendMessageObj;

@Controller
public class WsController {

	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WebSocketSendMessageObj say(WebSocketReceiveMessageObj messageObj) throws Exception {
		Thread.sleep(3000);
		return new WebSocketSendMessageObj("Hello " + messageObj.getName() + "!");
	}

}
