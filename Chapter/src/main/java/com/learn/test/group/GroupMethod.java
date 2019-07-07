package com.learn.test.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

//5.9testNG的组测试
public class GroupMethod {

    @Test(groups = "sever")
    public void test1(){
        System.out.println("这是服务端的的测试方法1111");
    }
    @Test(groups = "sever")
    public void test2(){
        System.out.println("这是服务端的的测试方法2222");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端的的测试方法3333");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端的的测试方法4444");
    }
    @BeforeGroups("sever")
    public void test5(){
        System.out.println("这是服务端组之前执行的");
    }
    @AfterGroups("sever")
    public void test6(){
        System.out.println("这是服务端组之后执行的");
    }
    @BeforeGroups("client")
    public void test7(){
        System.out.println("这是客户端组之前执行的");
    }
    @AfterGroups("client")
    public void test8(){
        System.out.println("这是客户端组之后执行的");
    }
}
