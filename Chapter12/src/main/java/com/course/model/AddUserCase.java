package com.course.model;

import lombok.Data;

@Data
public class AddUserCase {
    private String userName;
    private String password;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public String getPermission() {
        return permission;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public String getExpected() {
        return expected;
    }
}
