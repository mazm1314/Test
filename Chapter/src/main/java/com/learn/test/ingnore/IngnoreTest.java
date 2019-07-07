package com.learn.test.ingnore;

import org.testng.annotations.Test;

//5.8 忽略测试
public class IngnoreTest {
    @Test
    public  void  ingnoreCase(){
        System.out.println("忽略测试：想要执行");
    }

    @Test(enabled = false)
    public void ingnoreCase2(){
        System.out.println("忽略测试：不想被执行");
    }

    @Test(enabled = true)
    public void ingnoreCase3(){
        System.out.println("忽略测试：控制想执行");
    }
}
