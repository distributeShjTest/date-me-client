package date.me.com.cn.view.controller;
/**
 * Created by wangjiahui on 17-3-12.
 */
import date.me.com.cn.model.Friend;
import date.me.com.cn.model.Msg;
import date.me.com.cn.model.User;
import date.me.com.cn.service.MsgeSent;
import date.me.com.cn.view.main.MainApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginViewController extends AbstractController {
	
	private static MainApp application=new MainApp();
    public void setApp(MainApp application){  
        this.application = application;  
    }  


    public static User user=new User();
    
	@FXML
	private TextField textfield;
	
	@FXML
	private PasswordField psdfield;
	
	@FXML
	private Label username;
	
	@FXML
	private Label passwd;
	
	@FXML
	private Button login;

	private Msg msg=new Msg();	
	
	@FXML
	private void loginclick(){
		user.setUsername(textfield.getText());
		user.setPsd(psdfield.getText());
	
		//Msg msg=new Msg();
		msg.setUsername(LoginViewController.user.getUsername());
		msg.setPwd(LoginViewController.user.getPsd());
		msg.setMsgtype(0);

		Object o=msg;
		int type=0;
	
		msgeSent.sent(o, type);
		application.gotoshow();
		ShowView.label=new Label();
//		ShowUserNameRunable showname=new ShowUserNameRunable(ShowView.label,null,this.msg);
//		Platform.runLater(showname);
		//application.userlogin(lc.getLoginsuccess());
	}
	
	 public static void loginreturn(List<Friend> frilist,Boolean bl){
			if(bl==true){
				application.gotoshow();
			}	else{
				application.gotoerror();
			}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
				
	}


	public static MainApp getApplication() {

		return application;
	}

	public static void setApplication(MainApp application) {
		LoginViewController.application = application;
	}


	public MsgeSent getMsgeSent() {
		return msgeSent;
	}

	public void setMsgeSent(MsgeSent msgeSent) {
		this.msgeSent = msgeSent;
	}
}

		 


	
