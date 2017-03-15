package date.me.com.cn.net.impl;
import java.util.Properties;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetService {
        static public int port;
        static public String ip;
        

		public static String getIp() {
			return ip;
		}
		public static int getPort() {
			return port;
		}
		public static void setPort() throws IOException {
			Properties prop=new Properties();
			try {
				InputStream fin=GetService.class.getResourceAsStream("/a.properties");  
				prop.load(fin);
				port=Integer.valueOf(prop.getProperty("port"));
				fin.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void setIp() throws IOException {
			Properties prop=new Properties();
			try {
				InputStream fin=GetService.class.getResourceAsStream("/a.properties");  
				prop.load(fin);
				ip=prop.getProperty("ip");
				fin.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        
}
