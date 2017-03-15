package date.me.com.cn.service.impl;

/**
 * Created by lipenghui on 17-3-12.
 */
import java.util.List;

import date.me.com.cn.model.Msg;
import date.me.com.cn.protocol.impl.myLogining;
import date.me.com.cn.protocol.impl.mySendMsg;
import date.me.com.cn.protocol.impl.myUpdate;
import date.me.com.cn.service.MsgeSent;
import date.me.com.cn.view.controller.ConversitionViewController1;
import date.me.com.cn.view.controller.LoginCheck;
import date.me.com.cn.view.controller.ShakeThread;

public class MsgeSentImpl implements MsgeSent {

	@Override
	public void sent(Object o, int type) {
		
		System.out.println(type);
		myUpdate update = new myUpdate();
		//myLogining in2 = new myLogining(null, null);
		mySendMsg msm = new mySendMsg(null, type, null, null);

		// 登陆 显示好友列表
		if (type == 0) {
			if (o instanceof Msg) {
				Msg msg = (Msg) o;
				System.out.println(msg.getUsername()+","+msg.getPwd());
				myLogining in=new myLogining(msg.getUsername(),msg.getPwd());
				try {
					in.Loginin();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 此种写法不好，会重复启线程
				// new
				// myLogining(loginCheck.getUser().getUsername(),loginCheck.getUser().getPsd()).Loginin();

				System.out.println("haha");
			}
		}

		// 发送消息
		if (type == 1) {
			if (o instanceof Msg) {
				Msg msg = (Msg) o;
				msm.id = msg.getUserid();
				msm.msgtype = msg.getMsgtype();
				msm.msg = msg.getContent();
				msm.time = msg.getTime();
				try {
					msm.SendMessage();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 问题同上
				// mySendMsg mySendMsg = new
				// mySendMsg(msg.getUserid(),msg.getMsgtype(), msg.getContent(),
				// msg.getTime());
			}
		}

		if(type==2){
			if(o instanceof Msg){
				try {
					update.UpdateFriend();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
