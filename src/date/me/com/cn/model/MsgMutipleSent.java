package date.me.com.cn.model;

import java.util.List;

/**
 * Created by shj on 17-3-12.
 */
public class MsgMutipleSent {
    private Long time;
    private String content;
    private List<Integer> frlist;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MsgMutipleSent that = (MsgMutipleSent) o;

        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return frlist != null ? frlist.equals(that.frlist) : that.frlist == null;

    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (frlist != null ? frlist.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MsgMutipleSent{" +
                "time=" + time +
                ", content='" + content + '\'' +
                ", frlist=" + frlist +
                '}';
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Integer> getFrlist() {
        return frlist;
    }

    public void setFrlist(List<Integer> frlist) {
        this.frlist = frlist;
    }
}
