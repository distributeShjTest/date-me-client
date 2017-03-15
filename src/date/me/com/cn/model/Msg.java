package date.me.com.cn.model;

import java.util.List;

public class Msg {
	String content;
	private List<Friend> frlist;	
	String pwd;	
	String username;
	int msgtype;
	Long Time;
	List<String> userid;

	public List<String> getUserid() {
		return userid;
	}

	public void setUserid(List<String> userid) {
		this.userid = userid;
	}

	public Long getTime() {
		return Time;
	}

	public void setTime(Long time) {
		Time = time;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Friend> getFrlist() {
		return frlist;
	}

	public void setFrlist(List<Friend> frlist) {
		this.frlist = frlist;
	}
	
	public int getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(int msgtype) {
		this.msgtype = msgtype;
	}
	
	@Override
	public String toString(){
		return "Msg [msgtype=" + msgtype + ", userid=" + userid +", acceptors=" + frlist+ ", content=" + content + ", Time=" + Time + "]";
	}
	
}
