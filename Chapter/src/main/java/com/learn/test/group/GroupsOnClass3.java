package com.learn.test.group;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void stu1(){
        System.out.println("GroupsOnClass3中的stu111执行");
    }
    public void stu2(){
        System.out.println("GroupsOnClass3中的stu2222执行");
    }
}
