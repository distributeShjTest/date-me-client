package date.me.com.cn.protocol.impl;

import java.util.List;

public class LoadSucceed {
         int Type=0;
         List id;
         List name;
		public int getType() {
			return Type;
		}
		public void setType(int type) {
			Type = type;
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
		@Override
		public String toString() {
			return "LoadSucceed [Type=" + Type + ", id=" + id + ", name=" + name + "]";
		}

         
}
