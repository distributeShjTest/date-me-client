package date.me.com.cn.view.controller;

import date.me.com.cn.model.Msg;
import date.me.com.cn.service.MsgeSent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ShowMsgRunable implements Runnable {
	private Label label1;
	private Label label2;
	private Label label3;
	private Label label4;
	private TextArea textarea;
	private Msg msg;
	private MsgeSent msgeSent;

	public ShowMsgRunable(Label label1, Label label2, Label label3, Label label4, TextArea textarea, Msg msg,
			MsgeSent msgeSent) {
		super();
		this.label1 = label1;
		this.label2 = label2;
		this.label3 = label3;
		this.label4 = label4;
		this.textarea = textarea;
		this.msg = msg;
		this.msgeSent = msgeSent;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (msg.getContent() == null&&msg.getContent().isEmpty()) {
			this.textarea.setText("信息不能为空");
			System.out.println(this.textarea.getText());
		} else {
			String text = msg.getContent();
			this.textarea.clear();
			if (label1.getText() == null) {
				this.label1.setText(text);
				this.textarea.clear();
			} else {
				this.label4.setText(label3.getText());
				this.label3.setText(label2.getText());
				this.label2.setText(label1.getText());
				this.label1.setText(text);
				this.textarea.clear();
			}
		}

		// Object o=msg;
		// int type=1;
		// this.msgeSent.sent(o, type);
	}

}
