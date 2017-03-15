package date.me.com.cn.protocol.impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.json.JSONObject;

import date.me.com.cn.net.*;
import date.me.com.cn.service.impl.MsgSentlmpl;
public class Lisener implements Runnable {
	   List id;
	   List name;
	   String msg;
	   int msgtype;
	   int i=0;
       Checkout checkout=new Checkout();
	   MsgGet msgget=new MsgGet();
	   LoadSucceed loadsucceed=new LoadSucceed();
	   LoadFalse loadfalse=new LoadFalse();
	   UpdateSucceed updatesucceed=new UpdateSucceed();
	   myGetInfo mygetinfo=new myGetInfo();
	   MsgSentlmpl mgsend=new MsgSentlmpl();
       @Override
       public void run(){
    	   while(true){
    		   System.out.println("jiangyin");
					try {
						mygetinfo.GetInfomation();
						//System.out.println(mygetinfo.toString());
						//Thread.sleep(10000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	   
                 int type = mygetinfo.gettype();
                 switch(type){
                 case 0:
                	 if(i==0){
                		 i=i+1;
                	 }
                	 else{
                	 Object o0=mygetinfo.getLoadsucceed();
                	 mgsend.sent(o0,0);
                	 System.out.println(o0.toString());
                	 }
                	 break;
                 
                
                 case 1:
                	 this.msgget=mygetinfo.getMsgget();
                	 Object o1=mygetinfo.getMsgget();
                	 System.out.println(o1.toString());
                	 mgsend.sent(o1, 2);
                	 break;
                 case 2:
                	 Object o2=mygetinfo.getLoadfalse();
                	 mgsend.sent(o2, 1);
                	 System.out.println(o2.toString());
                	 break;
                 case 3:
                	 Object o3=mygetinfo.getCheckout();
                	 mgsend.sent(o3, 3);
                	 System.out.println(o3.toString());
                	 break;
                 default:break;
                 }
                 
    	   }
       }
}