package date.me.com.cn.view.controller;
/**
 * Created by wangjiahui on 17-3-12.
 */
import date.me.com.cn.model.Friend;
import date.me.com.cn.model.Msg;
import date.me.com.cn.service.MsgeSent;
import date.me.com.cn.view.main.MainApp;
import date.me.com.cn.view.widget.FriendLabel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public  class ShowView extends AbstractController implements FriendUpdate {
	// public class ShowView extends Application{

	private MainApp application;
	public void setApp(MainApp application) {
		this.application = application;
	}
	@FXML
	private HBox hbox;

	@FXML
	private Button FriList;

	@FXML
	private Button UpdateList;

	@FXML
	private Button GroupChat;

	@FXML
	private Button button1;

	@FXML
	private Button button2;

	@FXML
	private Button button3;

	@FXML
	private Label passwd;

	@FXML
	private VBox vbox;


	private FriendLabelClickAction friendLabelClickAction = new FriendLabelClickAction();
	public static List<Friend> Friends = new ArrayList<>();//所有好友的列表
	public static List<Friend> friends = new ArrayList<>();//收信好友的列表
	@FXML
	public void handleupdate(){
		Msg msg=new Msg();
		msg.setUserid(LoginViewController.user.getUserid());
		msg.setUsername(LoginViewController.user.getUsername());
		msg.setMsgtype(1);
		Object o=msg;
		int type=2;
		msgeSent.sent(o, type);
	}
	

    
    
//    private Label setlabel(String s){   
//    	Label label = new Label();
//    	label.setText(s);
//    	this.hbox.getChildren().addAll(label);
//        return label;
//   	}
    
    //LoginViewController.user.getUsername()

        
	private FriendLabel setLabel(Integer id, String text) {
		FriendLabel label = new FriendLabel();
		label.setId(id.toString());
		label.setText(text);
		label.setOnMouseClicked(this.friendLabelClickAction);
		label.setTextFill(Color.BLACK);
		return label;
	}
	
	//���º����б�
	public void updatelist(List<Friend> list) {
		
//		UpdateList updatelist=new UpdateList();	
//		updatelist.setU(LoginViewController.user);
//		updatelist.setType(0);
//		Object oj=LoginViewController.user;
//		updatelist.sendUpdaterequest(oj, 0);
//		
//		List<Friend> fr=updatelist.getFriends();
		
//	   List<Friend> fr=new ArrayList<Friend>();
//	   Friend f_1 = new Friend();
//       Friend f_2 = new Friend();
//       Friend f_3 = new Friend();
//       f_1.setId(1);
//       f_1.setName("shj");
//       f_2.setId(2);
//       f_2.setName("deadfish");
//       f_3.setId(6);
//       f_3.setName("dongzhao84");
//       fr.add(f_1);
//       fr.add(f_2);
//       fr.add(f_3);
//		if (list== null)
//			return;
//		for (Friend f : list) {
//			FriendLabel l = this.setLabel(f.getId(), f.getName());
//			System.out.println(this.vbox);
//			this.vbox.getChildren().add(l);
//			this.friendLabelClickAction.addLabel(l);
//		}
		UpdateFrListRunnable updateFrListRunnable = new UpdateFrListRunnable(this.friendLabelClickAction,this.vbox,list);
		Platform.runLater(updateFrListRunnable);
	}

//	public  void updateListRunlater(List<Friend> list){
//		if (list== null)
//			return;
//		for (Friend f : list) {
//			FriendLabel l = this.setLabel(f.getId(), f.getName());
//			System.out.println(this.vbox);
//			this.vbox.getChildren().add(l);
//			this.friendLabelClickAction.addLabel(l);
//		}
//	}




	@FXML
	//Ⱥ����Ϣ
	public void sentMutipleMsg() {
//		System.out.println(this.friendLabelClickAction);
		List<Integer> frids = this.friendLabelClickAction.getIsChosenFrId();
		for(Friend fr:Friends){
			for(int i:frids)
				if(i==fr.getId()){
    			 friends.add(fr);
    		}
    	}
		if (frids == null)
			return;
		System.out.println(frids);
		application.gototalk();
		
	}

	//显示接收消息
//	public void AcquireMessage(List<Friend> f,String content){
//			GetMsg gm=new GetMsg();
//			Msg m=gm.getMsg();
//			int type=m.getMsgtype();
//			String text=m.getContent();
//			if(type==1){
//				ConversitionViewController1.label5.setText(text);
//				application.gototalk();
//			}else if(type==2){
//				MainApp.shake();
//			}
//		}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(List<Friend> friends) {
		// TODO Auto-generated method stub
		
	}


	public MsgeSent getMsgeSent() {
		return msgeSent;
	}

	public void setMsgeSent(MsgeSent msgeSent) {
		this.msgeSent = msgeSent;
	}



}
