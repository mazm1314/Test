package com.learn.test.depend;

import org.testng.annotations.Test;

public class dependTest {
    @Test
    public void stu1(){
        System.out.println("这是第一个case");
//        假设被依赖case1失败 依赖的的case就被忽略
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = "stu1")
    public void stu2(){
        System.out.println("这是依赖第一个测试");
    }
}
