package date.me.com.cn.protocol.impl;
import date.me.com.cn.net.impl.myNetTranslation;
import org.json.JSONObject;

public class myLogining  {
	public String username;
    public String pwd;
	private Lisener lisener;
	public myLogining(String username,String pwd){
		this.username=username;
	    this.pwd=pwd;
	}

	public myLogining() {
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
		if(this.lisener==null)
			throw new NullPointerException("listen is null");
		new Thread(this.lisener).start();
		mynettranslation.SendJsonObject(myJson);
		
		//new Thread(new Lisener()).start();

	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public void setLisener(Lisener lisener) {
		this.lisener = lisener;
	}
}
