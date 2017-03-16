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
	public static Label label;

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
	private VBox vbox;

	private FriendLabelClickAction friendLabelClickAction = new FriendLabelClickAction();
	public static List<Friend> Friends=new ArrayList();//所有好友的列表
	public static List<Friend> friends=new ArrayList();//收信好友的列表
	
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

		UpdateFrListRunnable updateFrListRunnable = new UpdateFrListRunnable(this.friendLabelClickAction,this.vbox,list);
		Platform.runLater(updateFrListRunnable);
	}

	@FXML
	//Ⱥ����Ϣ
	public void sentMutipleMsg() {

		List<Integer> frids = this.friendLabelClickAction.getIsChosenFrId();
		System.out.println("there is a Friend"+Friends);
		for(Friend fr:Friends){
			for(int i:frids)
				if(i==fr.getId()){
    			 ShowView.friends.add(fr);
    		}
    	}
		System.out.println("there is a bug"+friends);
		if (frids == null)
			return;
		System.out.println(frids);
		application.gototalk();
		
	}
	
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
