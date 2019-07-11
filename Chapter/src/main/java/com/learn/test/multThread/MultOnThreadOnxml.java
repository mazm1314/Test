package com.learn.test.multThread;

import org.testng.annotations.Test;

//5.16xml文件实现多线程
public class MultOnThreadOnxml {
    @Test
    public void test1(){
        System.out.printf("线程id: %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.printf("线程id: %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.printf("线程id: %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test4(){
        System.out.printf("线程id: %s%n",Thread.currentThread().getId());
    }
}

