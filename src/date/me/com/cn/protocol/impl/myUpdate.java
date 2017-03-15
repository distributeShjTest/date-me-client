package date.me.com.cn.protocol.impl;
import date.me.com.cn.net.*;
import date.me.com.cn.net.impl.myNetTranslation;

import java.util.List;

import org.json.JSONObject;

public class myUpdate {
	public myUpdate(){
		
	}
	public void UpdateFriend () throws Exception{
		JSONObject sendJson=new JSONObject();
		sendJson.put("pid", 1);
		myNetTranslation mynettranslation=new myNetTranslation();
		//myNetTranslation.setSocket();
		//myNetTranslation.setInputStream();
		mynettranslation.SendJsonObject(sendJson);
	}
}
