package date.me.com.cn.protocol.impl;

import date.me.com.cn.net.*;
import date.me.com.cn.net.impl.myNetTranslation;

import java.sql.Time;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;

public class mySendMsg {
	public Long time;
	public List id;
	public int msgtype;
	public String msg;

	public mySendMsg(List id, int msgtype, String msg, Long time) {
		this.id = id;
		this.msgtype = msgtype;
		this.msg = msg;
		this.time = time;
	}

	public void SendMessage() throws Exception {
		myNetTranslation mynettranslation = new myNetTranslation();
		// myNetTranslation.setSocket();
		// myNetTranslation.setInputStream();
		JSONObject myJson = new JSONObject();
		JSONArray myJsonArray = new JSONArray();
		for (int len = 0; len < id.size(); len++) {
			JSONObject bufferJson = new JSONObject();
			myJsonArray.put(bufferJson.put("id", id.get(len)));
		}
		myJson.put("frlist", myJsonArray);
		myJson.put("time", time);
		myJson.put("pid", 2);
		myJson.put("msg", msg);
		myJson.put("msgtype", msgtype);
		mynettranslation.SendJsonObject(myJson);
	}
}
