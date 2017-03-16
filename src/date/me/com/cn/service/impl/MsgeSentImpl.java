package date.me.com.cn.service.impl;

import java.util.List;

import date.me.com.cn.model.Friend;
/**
 * Created by lipenghui on 17-3-12.
 */
import date.me.com.cn.model.Msg;
import date.me.com.cn.protocol.impl.myLogining;
import date.me.com.cn.protocol.impl.mySendMsg;
import date.me.com.cn.protocol.impl.myUpdate;
import date.me.com.cn.service.MsgeSent;
import date.me.com.cn.view.controller.ShowView;

public class MsgeSentImpl implements MsgeSent {

	private myLogining myLogining;

	@Override
	public void sent(Object o, int type) {
		
		System.out.println(type);
		myUpdate update = new myUpdate();
		//myLogining in2 = new myLogining(null, null);
		mySendMsg msm = new mySendMsg();

		// 登陆 显示好友列表
		if (type == 0) {
			if (o instanceof Msg) {
				Msg msg = (Msg) o;
				System.out.println(msg.getUsername()+","+msg.getPwd());
//				myLogining in=new myLogining(msg.getUsername(),msg.getPwd());
				this.myLogining.setUsername(msg.getUsername());
				this.myLogining.setPwd(msg.getPwd());
				try {
					this.myLogining.Loginin();
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
				System.out.println(msg.toString());
				List<Friend> list=msg.getFrlist();
				//System.out.println("this is a friends"+list);
				msm.getId().clear();
				for(Friend f:list){
					msm.id.add(f.getId());
				}
//				msm.id .add(e) msg.getFrlist().g;
				msm.msgtype = msg.getMsgtype();
				msm.msg = msg.getContent();
				msm.time = msg.getTime();
				System.out.println("msm:"+msm);
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

	public date.me.com.cn.protocol.impl.myLogining getMyLogining() {
		return myLogining;
	}

	public void setMyLogining(date.me.com.cn.protocol.impl.myLogining myLogining) {
		this.myLogining = myLogining;
	}
}
