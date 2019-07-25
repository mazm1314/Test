package course.com.server;


import course.com.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "这是我全部的post请求")
@RequestMapping("/v1")//起到的效果是访问的方法全部前边得加v1
public class myPostMethod {
//    这是用来装我们的cookies信息的
    private static Cookie cookie;
//    用户登陆成功获取到cookies，然后再访问其他接口获取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登陆接口，成功后获取cookies信息",httpMethod = "post")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "password",required = true)  String password){
        if(userName.equals("zhangsan") && password.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登陆成功了!";
        }
        return "用户名或者是密码错误！";

    }

    /**
     * 这里有两个问题：返回码：415:需要添加头信息：Content-Type：application/json
     * 浏览器访问地址：localhost:8888/v1/getUserList
     * @param request
     * @param u
     * @return
     */
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody User u){

        User user;
        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookies是否合法
        for(Cookie c : cookies){
            if(c.getName().equals("passport")
                    && c.getValue().equals("demo")
                    && u.getUserName().equals("zhangsan")
                    && u.getPassword().equals("123456")
                    ){
                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return  user.toString();
            }

        }

        return "参数不合法";
    }
}
