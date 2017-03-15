package date.me.com.cn.protocol.impl;

import java.util.List;

public class UpdateSucceed {
           int type;
           @Override
		public String toString() {
			return "UpdateSucceed [type=" + type + ", id=" + id + ", name=" + name + "]";
		}
		List id;
           List name;
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		public List getId() {
			return id;
		}
		public void setId(List id) {
			this.id = id;
		}
		public List getName() {
			return name;
		}
		public void setName(List name) {
			this.name = name;
		}
}
