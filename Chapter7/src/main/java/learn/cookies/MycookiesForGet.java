package learn.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MycookiesForGet {
        private String uil;
//        读取配置文件中文件
        private ResourceBundle bundle;
//        用来存储cookies信息的变量
        private CookieStore cookieStore;

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
            DefaultHttpClient client=new DefaultHttpClient();
            HttpResponse response=client.execute(get);
            result=EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);

            //获取cookis信息  9.4
            this.cookieStore=client.getCookieStore();
            List<Cookie> cookieList=cookieStore.getCookies();
            for(Cookie cookie:cookieList){
                String name=cookie.getName();
                String value=cookie.getValue();
//                打印出来的最后一个cookies信息
                System.out.println("cookies name:"+name+";cookies value:"+value);
            }
        }
        @Test(dependsOnMethods ={"test2"} )
        public void testGetWithCookies() throws IOException {
            String result;
            String URL=bundle.getString("getWithCookies");
            HttpGet get=new HttpGet(this.uil+URL);
            DefaultHttpClient client=new DefaultHttpClient();

//            设置cookies信息
            client.setCookieStore(this.cookieStore);

            HttpResponse response=client.execute(get);
//            获取响应的状态码
            int statusCode=response.getStatusLine().getStatusCode();
            if(statusCode==200) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println("cookies:" + result + "\n"+"状态码" + statusCode);
            }
            else {
                System.out.println("/n"+"执行失败了呢" );
            }

        }



}
