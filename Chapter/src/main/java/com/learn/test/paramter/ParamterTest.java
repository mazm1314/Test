package com.learn.test.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//5.13参数测试
public class ParamterTest {
    @Test
    @Parameters({"name","age"})
    public void parameterCase1(String name,int age){
        System.out.println("name="+name+";  age="+age);
    }
}
