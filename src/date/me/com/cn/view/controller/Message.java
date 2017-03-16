package date.me.com.cn.view.controller;

import java.util.List;

import date.me.com.cn.model.Friend;
import date.me.com.cn.model.Msg;

public interface Message {
	public  void AcquireMessage(List<Friend> f,Msg msg);
}
