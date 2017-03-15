package date.me.com.cn.view.main;
/**
 * Created by wangjiahui on 17-3-12.
 */
import java.awt.List;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import date.me.com.cn.model.Friend;
import date.me.com.cn.model.Msg;
import date.me.com.cn.view.controller.ConversitionViewController1;
import date.me.com.cn.view.controller.ErrorController;
import date.me.com.cn.view.controller.GetMsg;
import date.me.com.cn.view.controller.LoginViewController;
import date.me.com.cn.view.controller.ShakeThread;
import date.me.com.cn.view.controller.ShowView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainApp extends Application {
	private Stage stage;
	private final double MINIMUM_WINDOW_WIDTH = 400.0;
	private final double MINIMUM_WINDOW_HEIGHT = 250.0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		final List list;
		
		stage = primaryStage;
		stage.setTitle("Login Sample");
		stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
		stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
		
//		this.stage.setX(10);
//		this.stage.setY(500);
		
		gotologin();
//		gotoshow();
//		gototalk();
		stage.show();

	}

	public void gotologin() {

		try {
			LoginViewController login = (LoginViewController) replaceSceneContent("../../resource/frame/LoginView.fxml");
			login.setApp(this);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, e);
		}

	}
	public  void gotoerror() {
		try {
			ErrorController main = (ErrorController) replaceSceneContent("../../resource/frame/Error.fxml");
			main.setApp(this);
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public  void gotoshow() {
		try {
			ShowView main = (ShowView) replaceSceneContent("../../resource/frame/ShowView-1.fxml");
			main.setApp(this);
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public  void gototalk() {
		try {
			ConversitionViewController1 main = (ConversitionViewController1) replaceSceneContent("../../resource/frame/ConversitionView-1.fxml");
			main.setApp(this);
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	 
	public  void userlogin(Boolean b) {
		if(b==true){
			gotoshow();
		}
		
		// ��ȡ�յ����û���Ϣ
//		User user=new User();
//		user.setUsername(uname);
//		user.setPsd(pwd);
//		
		
//		Logincl.Logincheck();
//		if (uname.equals(123) && pwd.equals(123)) {
//			gotoshow();
//		}
	}

	
//	public void getmessage(){
//		GetMsg sm=new GetMsg();
//		Msg m=sm.getMsg();
//		int type=m.getMsgtype();
//		String friname=m.getUsername();
//		String content=m.getContent();
//		gototalk();
//		
//	}

	public static void shake() {
		new ShakeThread().start();
	}

	private Initializable replaceSceneContent(String fxml) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = MainApp.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(MainApp.class.getResource(fxml));
		ShowView showview = loader.getController();
		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}
		Scene scene = new Scene(page, 600, 400);
		stage.setScene(scene);
		ConversitionViewController1.stage = stage;
		stage.sizeToScene();
		return (Initializable) loader.getController();
	}

	public static void main(String[] args) {
		launch(args);
		//System.out.println(ShowView.getVbox());
	}
	
	
	

	
}