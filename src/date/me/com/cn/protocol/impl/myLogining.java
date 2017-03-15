package date.me.com.cn.protocol.impl;
import date.me.com.cn.net.impl.myNetTranslation;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.json.JSONObject;

public class myLogining  {
	public String username;
    public String pwd;
	public myLogining(String username,String pwd){
		this.username=username;
	    this.pwd=pwd;
	}
	public void SetSocket(){
	}
	public void Loginin() throws Exception{
        JSONObject myJson=new JSONObject();
		myJson.put("pid", 0);
		myJson.put("username", username);
		myJson.put("pwd", pwd);
		myNetTranslation mynettranslation =new myNetTranslation();
		myNetTranslation.setmymsg(myJson);
		myNetTranslation.setSocket();
		//BufferedReader reader=new BufferedReader(new InputStreamReader(myNetTranslation.getIn()));
		new Thread(new Lisener()).start();
		mynettranslation.SendJsonObject(myJson);
		
		//new Thread(new Lisener()).start();

	}

}
