package com.chris.websocket.obj;

public class WebSocketSendMessageObj {

	private String respMsg;

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public WebSocketSendMessageObj(String respMsg) {
		super();
		this.respMsg = respMsg;
	}

}
