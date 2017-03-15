package date.me.com.cn.view.controller;
import java.util.ArrayList;
/**
 * Created by wangjiahui on 17-3-12.
 */
import java.util.List;

import date.me.com.cn.model.Friend;
import date.me.com.cn.model.User;

public class LoginCheck  {
	
	User user;
	int type;
	ArrayList<Friend> frilist;
	Boolean loginsuccess;
	
	public Boolean getLoginsuccess() {
		return loginsuccess;
	}

	public void setLoginsuccess(Boolean loginsuccess) {
		this.loginsuccess = loginsuccess;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ArrayList<Friend> getFrilist() {
		return frilist;
	}

	public void setFrilist(ArrayList<Friend> frilist) {
		this.frilist = frilist;
	}

	@Override
	public String toString(){
		return "Msg [msgtype=" + type + ", user=" + user +", frilist=" + frilist+"]";
	}
	


}
