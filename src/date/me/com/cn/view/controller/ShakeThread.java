package date.me.com.cn.view.controller;

/**
 * Created by shj on 17-3-12.
 */
public class ShakeThread extends Thread {

    @Override
    public void run() {
//        double x = FrListController.stage.getX();
//        double y = FrListController.stage.getY();
//
//        for(int i=0;i<50;i++){
//            x-=5;
//            System.out.println(x);
//            FrListController.stage.setX(x);
//            System.out.println(FrListController.stage.getX());
//            try {
//                Thread.sleep(10);
//            }catch (Exception e){
//
//            }
//
//        }

        double x = ConversitionViewController1.stage.getX();
        double y = ConversitionViewController1.stage.getY();
        for (int i = 0; i < 20; i++) {
            if ((i & 1) == 0) {
                x += 3;
                y += 3;
            } else {
                x -= 3;
                y -= 3;
            }
            ConversitionViewController1.stage.setX(x);
            ConversitionViewController1.stage.setY(y);
            try {
                Thread.sleep(50);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
