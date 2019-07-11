package com.learn.test.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataPrivider {
    //    与定义的DataProvidername一致
    @Test(dataProvider = "data")
    public void testDataPrivider(String name, int age) {
        System.out.println("name=" + name + ";  age=" + age);
    }

    @DataProvider(name = "data")
    public Object[][] prividerData() {
        Object[][] o = new Object[][]{
                {"张三", 10}, {"李四", 11}, {"王五", 12}
        };
        return o;
    }

    @Test(dataProvider = "proMethod")
    public void test1(String name, int age) {
        System.out.print("name:" + name + ";age:" + age+"    ");
    }

    @Test(dataProvider = "proMethod")
    public void test2(String name, int age) {
        System.out.print("name:" + name + ";age:" + age +"   ");
    }

    @DataProvider(name = "proMethod")
    public Object[][] proMethodCase(Method method) {
        Object[][] result = null;
        if (method.getName().equals("test1")) {
            result = new Object[][]{
                    {"王麻子", 30},
            {"李宁", 89}
            };
        }
        else if (method.getName().equals("test2")) {
            result = new Object[][]{
                    {"哈哈", 30},
                    {"嘻嘻", 89}
            };
        }
        return result;
    }
}

