package com.course.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@Api(value = "v1",description = "这是我的第一个版本的demo")
@RequestMapping("v1")
public class Demo {
//    首先获得一个执行sql的对象

    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

}
