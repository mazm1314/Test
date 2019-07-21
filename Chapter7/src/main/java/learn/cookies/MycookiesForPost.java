package learn.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MycookiesForPost {
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
    public void test() throws IOException {
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
    //必须依赖上一个方法的原因是，第一个get方法返回了cookies信息  要想访问这个post方法，必须带着这个cookies信息
    @Test(dependsOnMethods ={"test"} )
    public void testPostMethod() throws IOException {
        String url=bundle.getString("postcookies");
//        拼接最终测试地址
        String testurl=this.uil+url;
//        声明一个client对象，用来进行方法的执行
        DefaultHttpClient client=new DefaultHttpClient();
//        声明一个方法，这个方法就是post方法
        HttpPost post=new HttpPost(testurl);
//        添加参数
        JSONObject parm=new JSONObject();
        parm.put("name","lala");
        parm.put("age","12");
//        设置请求头信息  设置header
        post.setHeader("content-type","application/json");//可设置多个
//        将参数信息添加到方法中
        StringEntity entity=new StringEntity(parm.toString(),"utf-8");
        post.setEntity(entity);
//        声明一个对象来进行响应结果的存储
        String result;
//        设置cookies信息
        client.setCookieStore(this.cookieStore);
//        执行post请求
        HttpResponse response=client.execute(post);
//        获取响应结果
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
//        处理结果，判断返回结果是否符合预期结果
//        将返回的响应结果字符串转化为json对象
        JSONObject resultJson=new JSONObject(result);

//        获取到结果值
        String success= (String) resultJson.get("lala");
        String status= (String) resultJson.get("status");
        // 具体判断返回的结果的值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }

}
