package date.me.com.cn.model;

/**
 * Created by shj on 17-3-15.
 */
public enum PageEnum {
    LOGINPAGE("loginPage"),SHOWVIEW("showView"),CONVERSATIONPAGE("ConversitionPage"),ERRORPAGE("errorPage");

    private String value;

    private PageEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
