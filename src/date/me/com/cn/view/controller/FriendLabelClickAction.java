package date.me.com.cn.view.controller;
/**
 * Created by wangjiahui on 17-3-12.
 */
import date.me.com.cn.view.widget.FriendLabel;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 17-3-12.
 */
public class FriendLabelClickAction implements EventHandler {
    private List<FriendLabel> friendLabels;
    private int isClicked;

    public FriendLabelClickAction() {
        this.friendLabels = new ArrayList<>();
        this.isClicked = 0;
    }

    @Override
    public void handle(Event event) {
        for(FriendLabel l:friendLabels){
            if(l==event.getSource()){
                System.out.println(l.getId());
                if(l.getIschosen()%2==0){
                    l.setTextFill(Color.RED);
                }else {
                    l.setTextFill(Color.BLACK);
                }
                l.setIschosen((l.getIschosen()+1)%2);

                return;
            }

        }
    }

    public void addLabel(FriendLabel l){
        this.friendLabels.add(l);
    }

    public List<Integer> getIsChosenFrId(){
        List<Integer> list =new ArrayList<>();
        for(FriendLabel f:this.friendLabels){
            if(f.getIschosen()%2==1){
                list.add(Integer.parseInt(f.getId()));
            }
        }
        if(list.size()==0)
            return null;
        return list;
    }


}
