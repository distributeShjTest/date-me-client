package date.me.com.cn.service.impl;

/**
 * Created by lipenghui on 17-3-12.
 */
import java.util.ArrayList;
import java.util.List;

import date.me.com.cn.model.Friend;
import date.me.com.cn.model.Msg;
import date.me.com.cn.protocol.Update;
import date.me.com.cn.protocol.impl.Checkout;
import date.me.com.cn.protocol.impl.LoadFalse;
import date.me.com.cn.protocol.impl.LoadSucceed;
import date.me.com.cn.protocol.impl.MsgGet;
import date.me.com.cn.protocol.impl.mySendMsg;
import date.me.com.cn.service.MsgSent;
import date.me.com.cn.view.controller.ConversitionViewController1;
import date.me.com.cn.view.controller.GetMsg;
import date.me.com.cn.view.controller.LoginCheck;
import date.me.com.cn.view.controller.LoginViewController;
import date.me.com.cn.view.controller.ShowList;
import date.me.com.cn.view.controller.ShowView;
import date.me.com.cn.view.controller.UpdateList;
import date.me.com.cn.view.main.MainApp;

public class MsgSentlmpl implements MsgSent {
     ShowView showview = new ShowView();
	public ShowView getShowview() {
		return showview;
	}
	public void setShowview(ShowView showview) {
		this.showview = showview;
	}
	@Override
	public void sent(Object o, int type) {

		// 协议特征码可改进为使用枚举
		// 登陆成功
		if (type == 0) {
			if (o instanceof LoadSucceed) {
			//if()
				LoadSucceed loadSucceed = (LoadSucceed) o;
//				LoginCheck  logincheck=new LoginCheck();
//				Boolean loginok=true;
				
//				UpdateList updateList = new UpdateList();
				
				Friend friend = new Friend();
				List<Friend> list = new ArrayList();
				for (int i = 0; i < loadSucceed.getId().size(); i++) {
					Integer a = Integer.parseInt(loadSucceed.getId().get(i).toString());
					String b = (String) loadSucceed.getName().get(i);
					friend.setId(a);
					friend.setName(b);
					list.add(friend);
				}
				System.out.println(list.get(1).getName()+list.get(1).getId());
			//	ShowView.Friends = list;
				showview.updatelist(list);
//				LoginViewController.loginreturn(list,loginok);
							
				
				
				
//				o = list;
//				ShowView showview = new ShowView();
//				showview.updatelist(list);
			}
		}

		// 登录失败
		if (type == 1) {
			if (o instanceof LoadFalse) {
				MainApp mainApp = new MainApp();
				mainApp.gotoerror();
			}
		}
		if (type == 2) {
			MsgGet msgGet = (MsgGet) o;

			// 收到窗口抖动消息
			if (msgGet.getMsgtype() == 2) {
				MainApp mainApp = new MainApp();
				mainApp.shake();
			}

			// 收到文本消息
			else if (msgGet.getMsgtype() == 1) {
//				ConversitionViewController1 c = new ConversitionViewController1();
				ShowView sv=new ShowView();
				List<Friend> l = ShowView.Friends;
//				List<Friend> l = ShowView.Friends;
				String name = null;
				for (Friend f : l) {
					if (f.getId() == msgGet.getId()) {
						name = f.getName();
					}
				}
//				sv.AcquireMessage(name, msgGet.getMsg());
//				c.AcquireMessage(name, msgGet.getMsg());
			}
		}

		// 好友下线
		// if (type == 3) {
		// if (o instanceof Checkout) {
		//
		// }
		// }
	}
	
	
	
}

