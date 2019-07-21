package learn.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MycookiesForGet {
        private String uil;
//        读取配置文件中文件
        private ResourceBundle bundle;
        @BeforeTest
        public  void  before(){
            bundle=ResourceBundle.getBundle("application",Locale.CHINA);//后者标识编码问题
            uil=bundle.getString("test.url");
        }
        @Test
        public void test2() throws IOException {
            String result;
//            从配置文件中 拼接测试的url
            String url=bundle.getString("getcookies.uri");
            HttpGet get=new HttpGet(this.uil+url);
//            测试逻辑代码的书写
            HttpClient client=new DefaultHttpClient();
            HttpResponse response=client.execute(get);
            result=EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }

}
