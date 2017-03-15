package date.me.com.cn.view.controller;
/**
 * Created by wangjiahui on 17-3-12.
 */
import java.util.List;

import date.me.com.cn.model.Friend;
import date.me.com.cn.model.Msg;
import date.me.com.cn.model.User;

public class UpdateList implements FriendUpdate{
	private User u;
	private int type;
	private List friends;
	
	public void sendUpdaterequest(Object O,int type){
		O=u;
		type=0;
		this.sendUpdaterequest(O,0);
	}
	
	@Override
	public void update(List<Friend> friends) {
		this.update(friends);		
	}
	
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List getFriends() {
		return friends;
	}

	public void setFriends(List friends) {
		this.friends = friends;
	}

	
	
	

}
