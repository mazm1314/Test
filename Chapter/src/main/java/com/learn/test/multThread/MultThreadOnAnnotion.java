package com.learn.test.multThread;

import org.testng.annotations.Test;
//5.15 注解实现多线程
public class MultThreadOnAnnotion {

    @Test(invocationCount=10,threadPoolSize =3)
    public void test(){
        System.out.println();
        System.out.printf("线程id: %s%n",Thread.currentThread().getId());
    }
}
