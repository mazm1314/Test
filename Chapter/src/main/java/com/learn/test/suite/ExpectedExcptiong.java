package com.learn.test.suite;

import org.testng.annotations.Test;


//5.11异常测试
public class ExpectedExcptiong {
//    @Test(expectedExceptions = RuntimeException.class)
//    public void exceptCase1(){
//        System.out.println("这是一个异常的测试");
//    }

    @Test(expectedExceptions = RuntimeException.class)
    public void exceptCase2(){
        System.out.println("这是一个抛出异常的测试");
        throw new RuntimeException();
    }
}
