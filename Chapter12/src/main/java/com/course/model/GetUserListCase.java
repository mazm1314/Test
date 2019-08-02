package com.course.model;

import lombok.Data;

@Data
public class GetUserListCase {
    private String userName;
    private int age;
    private String sex;
    private String expected;

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getExpected() {
        return expected;
    }
}
