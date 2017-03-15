package date.me.com.cn.view.controller;

import date.me.com.cn.service.MsgeSent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by shj on 17-3-15.
 */
public class AbstractController implements Initializable {
    protected MsgeSent msgeSent;


    public MsgeSent getMsgeSent() {
        return msgeSent;
    }

    public void setMsgeSent(MsgeSent msgeSent) {
        this.msgeSent = msgeSent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
