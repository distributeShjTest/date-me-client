package date.me.com.cn.net;
import java.io.InputStream;

import org.json.*;

public interface NetTranslation {
	JSONObject GetJsonObject(InputStream inputstream);//输入流转换为Json
	int SendJsonObject(JSONObject myJson);       //发送Json
           
}
