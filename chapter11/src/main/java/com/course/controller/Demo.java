package com.course.controller;


import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@Api(value = "v1",description = "这是我的第一个版本的demo")
@RequestMapping("v1")
public class Demo {
//    首先获得一个执行sql的对象

//    这个注解的作用是启动类加载，就是demo启动起来，这个类就被加载
    @Autowired
    private SqlSessionTemplate template;

    /**
     * http://localhost:8888/v1/getUserCount
     * @return   返回user表的存的数的个数
     */
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
         int result=template.selectOne("getUserCount");
        return result;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "增加用户",httpMethod = "POST")
    public int  addUser(@RequestBody User user){
        int result=template.insert("addUser",user);
        return  result;
    }

    @RequestMapping(value ="/updateUser",method =RequestMethod.POST)
    @ApiOperation(value = "跟新用户信息",httpMethod = "post")
    public int updateUser(@RequestBody User user){
        int result=template.update("updateUser",user);
        return result;
    }

    /**
     *
     * @param id
     * @return  返回删除了几条数据的个数
     */
    @RequestMapping(value ="/deleteUser",method =RequestMethod.GET)
    @ApiOperation(value = "删除用户信息",httpMethod = "GET")
    public int deleteUser(@RequestParam int id){
        int result=template.delete("deleteUser",id);
        return result;
    }


}
