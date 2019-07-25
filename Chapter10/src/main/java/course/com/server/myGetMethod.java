package course.com.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我所有的cookies请求")
public class myGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "返回响应的cookies请求",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        /**
         * //HttpServerletRequest 装请求信息的类
         * //HttpServerletResponse  装响应信息的类
         * 把响应的cookies信息返回，在浏览器中可查到返回的信息
         */
        Cookie cookie=new Cookie("passport","demo");
//        Cookie cookie1=new Cookie("passport1","demo1");
        response.addCookie(cookie);
//        response.addCookie(cookie1);
        return "成功返回cookies信息";
    }

    /**
     * 要求客户端携带cookies访问
     * get的方法
     */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
       Cookie[] cookies=request.getCookies();
       if(Objects.isNull(cookies)){
           return "访问我需要携带cookies信息来,你是空的";
       }
       for(Cookie cookie:cookies){
           if(cookie.getName().equals("passport") && cookie.getValue().equals("demo")){
                    return "我成功带着cookies信息来访问你了";
           }
       }
       return "访问我需要携带cookies信息来";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求。
     * 第一种实现方式 url: key=value&key=value
     * 我们来模拟获取商品列表
     *
     * 浏览器访问方式：http://localhost:8888/getDemoPara?start=10&end=18
     */
    @RequestMapping(value = "/getDemoPara",method = RequestMethod.GET)
    @ApiOperation(value = "第一种实现：需要携带参数才能访问的get请求",httpMethod = "GET")
     public Map<String,Integer> getList(@RequestParam Integer start,
                                        @RequestParam Integer end){
         Map<String,Integer> mylist=new HashMap<>();
         mylist.put("方便面",12);
         mylist.put("拉条",2);
         mylist.put("老干妈",21);
         return mylist;
     }

    /**
     * 第二种需要携带参数访问的get请求
     * url:ip:port/get/with/param/10/20
     *
     * 浏览器访问地址：http://localhost:8888/getDemoPara/10/18
     */
    @RequestMapping(value = "/getDemoPara/{start}/{end}")
    @ApiOperation(value = "第二种实现：需要携带参数才能访问的get请求",httpMethod = "GET")
    public  Map myGetList(@PathVariable Integer start,
                          @PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();

        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return  myList;

    }




}
