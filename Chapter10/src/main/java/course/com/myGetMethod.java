package course.com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class myGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
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

}
