package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "v1",description = "用户管理系统的增删改查")
@RequestMapping(value = "v1")
@Log4j
public class UserManager {

    @Autowired
    public static SqlSessionTemplate template;

    @ApiOperation(value = "登陆接口",httpMethod= "POST" )
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public boolean login(HttpServletResponse response, @RequestBody User user){
        int i=template.selectOne("login",user);
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        log.info("查询到的结果是"+i);
        if(i>=1){
            log.info("查询成功"+user.getUserName());
            return true;
        }
        return false;
    }

}
