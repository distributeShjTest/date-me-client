package date.me.com.cn.net.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.*;

import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

import date.me.com.cn.net.NetTranslation;

public class myNetTranslation implements NetTranslation{        
	        public static Socket socket=null;
	        public static InputStream in;
	        public static JSONObject mymsg;
	        public static void setmymsg(JSONObject mymg){
	        	mymsg=mymg;
	        }
            public static void setSocket (){
            	try {
            		GetService.setIp();
            		GetService.setPort();
					socket=new Socket(GetService.getIp(),GetService.getPort());
					in=socket.getInputStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            public static Socket getSocket() {
				return socket;
			}
			public static InputStream getIn() {
				return in;
			}
			public static void setInputStream(){
            	try {
            		//System.out.println(socket);
            		in=socket.getInputStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
	        public JSONObject getJSONObject() throws JSONException  {
	        	//String mystring=null;
	            BufferedReader reader=new BufferedReader(new InputStreamReader(myNetTranslation.getIn()));
	           // System.out.println(in);
	            String mystring =null;
				try {
					mystring = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					try {
						Socket socket2=new Socket(GetService.getIp(),GetService.getPort());
						BufferedWriter bufferwriter2=new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));
						bufferwriter2.write(mymsg.toString());
						InputStream in2=socket2.getInputStream();
						BufferedReader reader2=new BufferedReader(new InputStreamReader(in2));
						mystring=reader2.readLine();
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				System.out.println(mystring);
	            JSONObject myJson=new JSONObject(mystring);
	            return myJson;
	            }
	        public int SendJsonObject(JSONObject myJson) throws IOException {
	        	BufferedWriter bufferedWriter = null;
				try {
					bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					try {
						Socket socket2=new Socket(GetService.getIp(),GetService.getPort());
						bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));
						bufferedWriter.write(mymsg.toString());
						bufferedWriter.newLine();
						bufferedWriter.flush();
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
	        	String mystring=myJson.toString();
	        	System.out.println(mystring);
	        	bufferedWriter.write(mystring);
	        	bufferedWriter.newLine();
	        	bufferedWriter.flush();
	        	//out.close();
	        	return 0;
	        }
}
