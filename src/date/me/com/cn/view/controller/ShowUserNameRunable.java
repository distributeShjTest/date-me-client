package date.me.com.cn.view.controller;

import date.me.com.cn.model.Msg;
import date.me.com.cn.model.User;
import javafx.scene.control.Label;

public class ShowUserNameRunable implements Runnable{
	private Label label1;
	private Label label2;
	private Msg msg;
	public ShowUserNameRunable(Label label1,Label label2, Msg msg) {
		super();
		this.label1 = label1;
		this.label2 = label2;
		this.msg = msg;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		label1.setText(msg.getUsername());
		label2.setText(msg.getContent());
		System.out.println(ShowView.label.getText());
	}
	
	
}
