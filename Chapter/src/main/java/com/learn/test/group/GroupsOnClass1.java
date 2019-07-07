package com.learn.test.group;

import org.testng.annotations.Test;

//5.10类的测试，可以在类上边做测试用例
@Test(groups = "stu")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println("GroupsOnClass1中的stu111执行");
    }
    public void stu2(){
        System.out.println("GroupsOnClass1中的stu2222执行");
    }
}
