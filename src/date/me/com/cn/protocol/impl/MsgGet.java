package date.me.com.cn.protocol.impl;

import java.sql.Date;
import java.util.List;

public class MsgGet {
        int msgtype;
        int id;
        String msg;
        Long time;
		public Long getTime() {
			return time;
		}
		public void setTime(Long time) {
			this.time = time;
		}

		public int getMsgtype() {
			return msgtype;
		}
		@Override
		public String toString() {
			return "MsgGet [msgtype=" + msgtype + ", id=" + id + ", msg=" + msg + ", time=" + time + "]";
		}
		public void setMsgtype(int msgtype) {
			this.msgtype = msgtype;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
}
