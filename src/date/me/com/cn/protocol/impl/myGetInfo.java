package date.me.com.cn.protocol.impl;
import java.util.ArrayList;
import java.util.List;

import org.json.*;
import org.json.JSONObject;

import date.me.com.cn.net.*;
import date.me.com.cn.net.impl.myNetTranslation;
public class myGetInfo {
	 int type=5; 
	 Checkout checkout=new Checkout();
	 MsgGet msgget=new MsgGet();
	 int msgtype;
	 public Checkout getCheckout() {
		return checkout;
	}

	public void setCheckout(Checkout checkout) {
		this.checkout = checkout;
	}

	public MsgGet getMsgget() {
		return msgget;
	}

	public void setMsgget(MsgGet msgget) {
		this.msgget = msgget;
	}


	LoadSucceed loadsucceed=new LoadSucceed();
	 LoadFalse loadfalse=new LoadFalse();
	 UpdateSucceed updatesucceed=new UpdateSucceed();
	 
	 public int gettype(){
		 return type;
	 }
	 
	 public LoadSucceed getLoadsucceed() {
		return loadsucceed;
	}
	 
	public void setLoadsucceed(LoadSucceed loadsucceed) {
		this.loadsucceed = loadsucceed;
	}
	
	public LoadFalse getLoadfalse() {
		return loadfalse;
	}
	
	public void setLoadfalse(LoadFalse loadfalse) {
		this.loadfalse = loadfalse;
	}
	
	public UpdateSucceed getUpdatesucceed() {
		return updatesucceed;
	}
	
	public void setUpdatesucceed(UpdateSucceed updatesucceed) {
		this.updatesucceed = updatesucceed;
	}
	
	
	void GetInfomation()throws Exception{
		 myNetTranslation mynettranslation=new myNetTranslation();
		 JSONObject netJson=mynettranslation.getJSONObject();
		// System.out.println(netJson.toString());
		 int pidtype=netJson.getInt("pid"); 
	     List<String>id=new ArrayList<String>();
	     List<String>name=new ArrayList<String>();
	     
		 switch(pidtype){
		 case 0: type=0;
		 JSONArray myJsonarray =netJson.getJSONArray("frlist");
		 for (int len=0;len<myJsonarray.length();len++){
			id.add(myJsonarray.getJSONObject(len).getString("id"));
			name.add(myJsonarray.getJSONObject(len).getString("name"));
		 }
         loadsucceed.setType(type);
         loadsucceed.setId(id);
         loadsucceed.setName(name);
         this.setLoadsucceed(loadsucceed);
         //System.out.println(loadsucceed.toString());
		 break;
		 
		 case 1: type=1;
		 int mtype=netJson.getInt("msgtype");
		 msgget.setId(netJson.getInt("frid"));
		 msgget.setMsgtype(mtype);
		 msgget.setTime(netJson.getLong("time"));
		 msgget.setMsg(netJson.getString("content"));
		// System.out.println(msgget.toString());
		 break;
		 case 2: type=2;
         loadfalse.setType(type);
		 break;
		 case 3:type=3;
		 checkout.setType(type); 
		 default:break;
		 }	 
	 }
}