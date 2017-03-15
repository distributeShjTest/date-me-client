package date.me.com.cn.view.widget;
/**
 * Created by shj on 17-3-12.
 */
import javafx.scene.control.Label;

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
