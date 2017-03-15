package date.me.com.cn.model;

import java.util.List;

public class User {
	String username;
	String pwd;
	List<String> userid;
		
	public List<String> getUserid() {
		return userid;
	}
	public void setUserid(List<String> userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsd() {
		return pwd;
	}
	public void setPsd(String psd) {
		this.pwd = psd;
	}

	
}
