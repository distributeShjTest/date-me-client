package date.me.com.cn.net;
import java.io.InputStream;
import java.net.Socket;

import org.json.*;

public interface NetTranslation {
	JSONObject getJSONObject () throws Exception;  //获得Json
	int SendJsonObject(JSONObject myJson) throws Exception;//发送Json
	
           
}
