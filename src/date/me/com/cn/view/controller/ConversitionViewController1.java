package date.me.com.cn.view.controller;
/**
 * Created by wangjiahui on 17-3-12.
 */
import date.me.com.cn.model.Friend;
import date.me.com.cn.model.Msg;
import date.me.com.cn.view.main.MainApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ConversitionViewController1 extends AbstractController implements Message{
	public static Stage stage;

	private MainApp application;

//	private MsgeSent msgeSent;
    public void setApp(MainApp application){
        this.application = application;
    }
    @FXML
    private Label label1;
    
    @FXML
    private Label label2;
    
    @FXML
    private Label label3;
    
    @FXML
    private Label label4;
    
    @FXML
    private Label label5;
    
    @FXML
    private Button button1;
    
    @FXML
    private Button button2;
    
    @FXML
    private Button button3;
    
    @FXML
    private Button button4;
    
    @FXML
    private TextArea textarea;
    
    @FXML
    private SplitPane splitpane;
    
    @FXML
    private void shake(){
		new ShakeThread().start();
	}
    private Msg msg=new Msg();
    
    @FXML
    //发送窗口抖动
    public void handleshake(){
    	//Msg msg=new Msg();
    	msg.setUserid(LoginViewController.user.getUserid());
    	msg.setUsername(LoginViewController.user.getUsername());
    	msg.setContent(null);
    	msg.setFrlist(ShowView.friends);
    	msg.setMsgtype(0);
//    	MessageSent ms=new MessageSent();
//    	ms.setMsg(msg);
//    	ms.setType(2); 
//    	System.out.println(msg);
		Object o=msg;
		int type=1;
    	msgeSent.sent(o, type);
    }
    
    @FXML
    //发送文本消息
	private void handlesend() {
    	
    	//Msg msg=new Msg();
//    	if(textarea.getText()==null){
//    		return;
//    		textarea.setText("信息不能为空");
//    		ShowMsgRunable showmsgrunable=new ShowMsgRunable(this.label5,this.label4,this.label3,this.label2,this.textarea,this.msg,this.msgeSent);
//	    	Platform.runLater(showmsgrunable);
//    	}else{
	    	msg.setTime(new Date().getTime());
	    	msg.setContent(textarea.getText());
	    	msg.setFrlist(ShowView.friends);
	    	System.out.println(ShowView.friends+"................");
	    	msg.setMsgtype(1);
	    	msg.setUsername(LoginViewController.user.getUsername());
	    	msg.setUserid(LoginViewController.user.getUserid());
	    	Object o=msg;
			int type=1;		
			this.msgeSent.sent(o, type);
	    	ShowMsgRunable showmsgrunable=new ShowMsgRunable(this.label5,this.label4,this.label3,this.label2,this.textarea,this.msg,this.msgeSent);
	    	Platform.runLater(showmsgrunable); 
    //	}
    	
    	
//    	ShowMsgRunable showmsgrunable=new ShowMsgRunable(label5,textarea,msg,this.msgeSent);
//    	Platform.runLater(showmsgrunable);
//		Object o=msg;
//		int type=1;		
//    	this.msgeSent.sent(o, type);
//    	
//    	String text=textarea.getText();
//		label5.setText(text);
//		textarea.setText("");

    	
		
	}
	
	@FXML
	//取消发送
	private void handlecancel(){
		textarea.setText(null);	}
	
	@FXML
	//返回主界面
	private void handlereturn(){		
		application.gotoshow();
	}
	
	//显示接收消息
	public  void AcquireMessage(List<Friend> f,Msg msg){
//		GetMsg gm=new GetMsg();
//		Msg m=gm.getMsg();
//		int type=m.getMsgtype();
		if(msg.getMsgtype()==1)
			System.out.println("gototalk");
		application.gototalk();
		ShowUserNameRunable showname=new ShowUserNameRunable(null,this.label5,msg);
		Platform.runLater(showname);
		
		
	}
//	public void sentMutipleMsg() {
//		MsgMutipleSent msgMutipleSent = new MsgMutipleSent();
//		msgMutipleSent.setTime((new Date()).getTime());
//		msgMutipleSent.setFrlist(null);
//		msgMutipleSent.setContent(this.textarea.getText());
//		System.out.println(msgMutipleSent);
//	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}	
}
