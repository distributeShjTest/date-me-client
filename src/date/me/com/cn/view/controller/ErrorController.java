package date.me.com.cn.view.controller;
/**
 * Created by wangjiahui on 17-3-12.
 */
import date.me.com.cn.view.main.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorController extends AbstractController {
	public static Stage stage;
	private MainApp application;  
    public void setApp(MainApp application){  
        this.application = application;  
    }
    
    @FXML
    private Label label;
    
    @FXML
    private Button button;
    
    @FXML
    private void handleclick(){
    	application.gotologin();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}  
}
