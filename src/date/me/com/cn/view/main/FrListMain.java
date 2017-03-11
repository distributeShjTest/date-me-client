package date.me.com.cn.view.main;

import date.me.com.cn.view.controller.FrListController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class FrListMain extends Application {
    //测试代码，可注释
    public static FrListController frListController;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Platform.setImplicitExit(true);
//        Parent root = FXMLLoader.load(getClass().getResource("../../resource/frame/frList.fxml"));
        URL location = getClass().getResource("../../resource/frame/frList.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        javafx.scene.Parent root = (javafx.scene.Parent) fxmlLoader.load(location.openStream());
        //测试代码，可注释
        frListController = (FrListController)fxmlLoader.getController();
        primaryStage.setTitle("sb检测系统");
        primaryStage.setX(800);
        primaryStage.setY(20);
        FrListController.stage = primaryStage;
        Scene scene = new Scene(root, 250, 500);
        primaryStage.setScene(scene);
//        GridPane grid = new GridPane();//网格式布局，由行列网格控制
//        grid.setAlignment(Pos.CENTER);//对齐方式，默认靠左对齐，当前设置居中对齐
//        grid.setHgap(10);//设置水平间隔
//        grid.setVgap(10);//设置垂直间隔
//        grid.setPadding(new Insets(25, 25, 25, 25));//设置Padding，顺序是：上、右、下、左
//
//        Text scenetitle = new Text("欢迎标题");
//        //scenetitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
//        grid.add(scenetitle, 0, 0, 2, 1);
//
//        //创建Label对象，放到第0列，第1行
//        Label userName = new Label("用户名：");
//        grid.add(userName, 0, 1);
//
//        //创建文本输入框，放到第1列，第1行
//        TextField userTextField = new TextField();
//        grid.add(userTextField, 1, 1);
//
//        Label pw = new Label("密 码：");
//        grid.add(pw, 0, 2);
//
//        PasswordField pwBox = new PasswordField();
//        grid.add(pwBox, 1, 2);
//
//        Button btn = new Button("登录");
//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtn.getChildren().add(btn);//将按钮控件作为子节点
//        grid.add(hbBtn, 1, 4);//将HBox pane放到grid中的第1列，第4行
//
//
//
//        final Text actiontarget = new Text();//增加用于显示信息的文本
//
//
//        btn.setOnAction(new EventHandler<ActionEvent>() {//注册事件handler
//            @Override
//            public void handle(ActionEvent e) {
//                actiontarget.setFill(Color.FIREBRICK);//将文字颜色变成 firebrick red
//                actiontarget.setText("登录中...");
//            }
//        });
//        scenetitle.setId("welcome-text");
//        actiontarget.setId("actiontarget");
//
//        grid.add(actiontarget, 1, 6);
//
//        Scene scene = new Scene(grid, 300, 275);//新建Scene，并将网格式Panel置于其中
//        scene.getStylesheets().add(Main.class.getResource("testCase.css").toExternalForm());
        primaryStage.show();
        primaryStage.hide();
        primaryStage.show();
    }


    public static void main(String[] args) {


        launch(args);

    }
}
