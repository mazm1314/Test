package com.learn.test;

import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut = 3000)//单位为毫秒值
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)   //等待时间是2秒
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);   //但是我睡了3秒
}
}
