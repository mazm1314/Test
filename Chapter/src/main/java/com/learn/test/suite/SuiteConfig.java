package com.learn.test.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//一些公用的东西
public class SuiteConfig {
    //是类运行之前和之后进行运行
    @BeforeSuite
    public void beforeSuites1(){
        System.out.println("BeforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuites2(){
        System.out.println("afterSuite测试套件");
    }

//    是每个测试用例之前运行
    @BeforeTest
    public void  beforeTest(){
        System.out.println("beforeTest");
    }

    @AfterTest
    public void  afterTest(){
        System.out.println("afterTest");
    }
}
