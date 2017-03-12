package date.me.com.cn.view.widget;

import javafx.scene.control.Label;

/**
 * Created by shj on 17-3-12.
 */
public class FriendLabel extends Label {
    private Integer ischosen;

    public FriendLabel() {
        this.ischosen = 0;
    }

    public Integer getIschosen() {
        return ischosen;
    }

    public void setIschosen(Integer ischosen) {
        this.ischosen = ischosen;
    }
}
