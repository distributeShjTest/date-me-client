package date.me.com.cn.protocol;
import java.util.List;

import org.json.*;

public interface Myprotocol {
	int GetPidType(JSONObject myJson);  //获得协议特征码
	String GetUsername(JSONObject myJson);  //获得用户名
	int GetID(JSONObject myJson);           //获得ID
	List GetFrlist(JSONObject myJson);     //获得好友列表
	int GetMsgType(JSONObject myJson);     //获得消息类型
	String GetMsg(JSONObject myJson);      //获得消息
	int GetJsonObject0(int pidtype,String username,String psw);  //登陆封包
	int GetJsonObject1(int pidtype);                           //更新好友列表封包
	int GetJsonObject2(int pidtype,String username,String psw,List frlist,int msgtype,String msg);//发消息封包
}
