package date.me.com.cn.view.controller;

import date.me.com.cn.model.Friend;
import date.me.com.cn.view.widget.FriendLabel;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by shj on 17-3-15.
 */
public class UpdateFrListRunnable implements Runnable {
    private FriendLabelClickAction friendLabelClickAction;
    private VBox vbox;
    private List<Friend> list;


    public UpdateFrListRunnable(FriendLabelClickAction friendLabelClickAction, VBox vbox,List<Friend> list) {
        this.friendLabelClickAction = friendLabelClickAction;
        this.vbox = vbox;
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println(list);
        this.vbox.getChildren().clear();
        if (list== null)
            return;
        for (Friend f : list) {
            FriendLabel l = this.setLabel(f.getId(), f.getName());
            System.out.println(this.vbox);
            this.vbox.getChildren().add(l);
            this.friendLabelClickAction.addLabel(l);
        }
    }


    private FriendLabel setLabel(Integer id, String text) {
        FriendLabel label = new FriendLabel();
        label.setId(id.toString());
        label.setText(text);
        label.setOnMouseClicked(this.friendLabelClickAction);
        label.setTextFill(Color.BLACK);
        return label;
    }


}
