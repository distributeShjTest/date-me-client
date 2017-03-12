package date.me.com.cn.view.controller;

import date.me.com.cn.model.Friend;
import date.me.com.cn.model.MsgMutipleSent;
import date.me.com.cn.view.widget.FriendLabel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by shj on 17-3-12.
 */
public class FrListController implements Initializable,FriendUpdate{



    public static Stage stage;
    @FXML
    private VBox vBox;

    @FXML
    private GridPane gridPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextArea textArea;

    private FriendLabelClickAction friendLabelClickAction;
    private static List<Friend> friends = new ArrayList<>();

    public FrListController() {
        this.friendLabelClickAction = new FriendLabelClickAction();
    }

//    public void addFrlist(){
//        Friend f_1 = new Friend();
//        Friend f_2 = new Friend();
//        Friend f_3 = new Friend();
//        f_1.setId(1);
//        f_1.setName("shj");
//        f_2.setId(2);
//        f_2.setName("deadfish");
//        f_3.setId(6);
//        f_3.setName("dongzhao84");
//        friends.add(f_1);
//        friends.add(f_2);
//        friends.add(f_3);
//
//    }


    private FriendLabel setLabel(Integer id, String text){
        FriendLabel label = new FriendLabel();
        label.setId(id.toString());
        label.setText(text);
        label.setOnMouseClicked(this.friendLabelClickAction);
        label.setTextFill(Color.BLACK);
        return label;
    }

    public void sentMutipleMsg(){
        List<Integer> frids =  this.friendLabelClickAction.getIsChosenFrId();
        if(frids==null)
            return;
        if(this.textArea.getText().equals(""))
            return;
        MsgMutipleSent msgMutipleSent = new MsgMutipleSent();
        msgMutipleSent.setTime((new Date()).getTime());
        msgMutipleSent.setFrlist(frids);
        msgMutipleSent.setContent(this.textArea.getText());
        System.out.println(msgMutipleSent);
    }



    public void shake(){
        new ShakeThread().start();
    }



    public void clickMe(){
        System.out.println(1);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void testAddFriend(){
        List<Friend> friends = new ArrayList<>();
        Friend f_1 = new Friend();
        Friend f_2 = new Friend();
        Friend f_3 = new Friend();
        f_1.setId(1);
        f_1.setName("shj");
        f_2.setId(2);
        f_2.setName("deadfish");
        f_3.setId(6);
        f_3.setName("dongzhao84");
        friends.add(f_1);
        friends.add(f_2);
        friends.add(f_3);
        this.update(friends);
    }


    @Override
    public void update(List<Friend> friends) {
        if(friends==null)
            return;
        for(Friend f:friends){
            FriendLabel l = this.setLabel(f.getId(),f.getName());
            this.vBox.getChildren().add(l);
            this.friendLabelClickAction.addLabel(l);

        }
        stage.show();
    }
}
