package date.me.com.cn.view.main;
/**
 * Created by wangjiahui on 17-3-12.
 */
import date.me.com.cn.model.PageController;
import date.me.com.cn.model.PageEnum;
import date.me.com.cn.protocol.impl.Lisener;
import date.me.com.cn.service.MsgeSent;
import date.me.com.cn.service.impl.MsgSentlmpl;
import date.me.com.cn.service.impl.MsgeSentImpl;
import date.me.com.cn.view.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import date.me.com.cn.protocol.impl.myLogining;

import java.awt.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainApp extends Application {
	private Stage stage;
	private final double MINIMUM_WINDOW_WIDTH = 400.0;
	private final double MINIMUM_WINDOW_HEIGHT = 250.0;
	private MsgeSentImpl msgeSentImpl;
	private MsgSentlmpl msgSentlmpl;
	private Lisener lisener;
	private myLogining myLogining;
	private LoginViewController LoginViewController;
	private ErrorController ErrorController;
	private ShowView showView;
	private ConversitionViewController1 ConversitionViewController1;
	private HashMap<String,PageController> pageMap;
	public static Logger logger = Logger.getLogger(MainApp.class.getName());
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.serverInit();
		System.out.println(this.pageMap);
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
//			System.out.println(this.pageMap);
			LoginViewController login = (LoginViewController)this.pageMap.get(PageEnum.LOGINPAGE.getValue()).getInitializable();
			this.stage.setScene(this.pageMap.get(PageEnum.LOGINPAGE.getValue()).getScene());
			this.stageSizeToScene();
			login.setApp(this);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, e);
		}

	}
	public  void gotoerror() {
		try {
			ErrorController main = (ErrorController)this.pageMap.get(PageEnum.ERRORPAGE.getValue()).getInitializable();
			this.stage.setScene(this.pageMap.get(PageEnum.ERRORPAGE.getValue()).getScene());
			this.stageSizeToScene();
			main.setApp(this);
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	public  void gotoshow() {
		try {
			ShowView main = (ShowView)this.pageMap.get(PageEnum.SHOWVIEW.getValue()).getInitializable();
			this.stage.setScene(this.pageMap.get(PageEnum.SHOWVIEW.getValue()).getScene());
			this.stageSizeToScene();
			main.setApp(this);

			this.msgSentlmpl.setShowview(main);
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public  void gototalk() {
		try {
			ConversitionViewController1 main = (ConversitionViewController1)this.pageMap.get(PageEnum.CONVERSATIONPAGE.getValue()).getInitializable();
			this.stage.setScene(this.pageMap.get(PageEnum.CONVERSATIONPAGE.getValue()).getScene());
			this.stageSizeToScene();
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

	public void stageSizeToScene(){
		this.stage.sizeToScene();
	}


	private PageController replaceSceneContentForPageController(String fxml) throws Exception {

		FXMLLoader loader = new FXMLLoader();
		InputStream in = MainApp.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(MainApp.class.getResource(fxml));
		Initializable Initializable = loader.getController();

		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}

		PageController pageController = new PageController();
		Scene scene = new Scene(page, 600, 400);
		pageController.setScene(scene);
		pageController.setInitializable(Initializable);
		return pageController;
	}

	private PageController replaceSceneContentForPageController(String fxml, MsgeSent msgeSent) throws Exception {

		FXMLLoader loader = new FXMLLoader();
		InputStream in = MainApp.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(MainApp.class.getResource(fxml));


		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}
		Initializable initializable = loader.getController();
		System.out.println(initializable);
		PageController pageController = new PageController();
		Scene scene = new Scene(page, 600, 400);
		pageController.setScene(scene);
		((AbstractController)initializable).setMsgeSent(msgeSent);
		pageController.setInitializable(initializable);
		return pageController;
	}


	private void pageChange(String name,Scene scene){
		this.stage.setScene(this.pageMap.get(name).getScene());
	}


	private void serverInit(){
		this.msgeSentImpl = new MsgeSentImpl();
		this.msgSentlmpl = new MsgSentlmpl();
		this.lisener = new Lisener();
		this.lisener.setMgsend(this.msgSentlmpl);
		this.myLogining = new myLogining();
		this.myLogining.setLisener(this.lisener);
		this.msgeSentImpl.setMyLogining(this.myLogining);
		this.pageMap = new HashMap<>();
		try {
			this.pageMap.put("loginPage",this.replaceSceneContentForPageController("../../resource/frame/LoginView.fxml",this.msgeSentImpl));
			this.pageMap.put("showView",this.replaceSceneContentForPageController("../../resource/frame/ShowView-1.fxml",this.msgeSentImpl));
			this.pageMap.put("ConversitionPage",this.replaceSceneContentForPageController("../../resource/frame/ConversitionView-1.fxml",this.msgeSentImpl));
			this.pageMap.put("errorPage",this.replaceSceneContentForPageController("../../resource/frame/Error.fxml",this.msgeSentImpl));
		}catch (Exception e){
			e.printStackTrace();
			logger.warning(e.getMessage());
		}

	}


	public static void main(String[] args) {
		launch(args);
		//System.out.println(ShowView.getVbox());
	}
	
	
	

	
}