package date.me.com.cn.view.controller;
/**
 * Created by wangjiahui on 17-3-12.
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import date.me.com.cn.model.Friend;
import date.me.com.cn.model.Msg;
import date.me.com.cn.model.User;
import date.me.com.cn.service.impl.MsgeSentImpl;
import date.me.com.cn.view.main.MainApp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {
	
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
	
	@FXML
	private void loginclick(){
		user.setUsername(textfield.getText());
		user.setPsd(psdfield.getText());
//		System.out.println(textfield.getText()+"..."+psdfield.getText());
//		LoginCheck lc=new LoginCheck();
//		lc.setUser(user);
//		lc.setType(0);
		
		Msg msg=new Msg();
		msg.setUsername(LoginViewController.user.getUsername());
		msg.setPwd(LoginViewController.user.getPsd());
		msg.setMsgtype(0);
		MsgeSentImpl msgeSentImpl = new MsgeSentImpl();
		Object o=msg;
		int type=0;
		msgeSentImpl.sent(o, type);
		application.gotoshow();
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
}

		 


	
