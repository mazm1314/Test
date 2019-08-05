package com.course.model;
import lombok.Data;
@Data
public class UpdateUserInfoCase {
        private int id;
        private int userId;
        private String userName;
        private String age;
        private String sex;
        private String permission;
        private String isDelete;
        private String expected;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
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
