package com.learn.test;

import org.testng.annotations.*;

public class BasicAnnotation {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是在测试方法之前执行");
    }

    @Test
    public void testCase1(){
        System.out.println("第一个测试");
    }
    @Test
    public void testCase2(){
        System.out.println("第二个测试");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是在测试方法之后执行");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("这是在类运行之前执行");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("这是在类运行之后执行");
    }
    //是类运行之前和之后进行运行
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("BeforeSuite测试套件");
    }


}
