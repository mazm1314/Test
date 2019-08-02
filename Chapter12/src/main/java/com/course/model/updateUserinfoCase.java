package com.course.model;
import lombok.Data;
@Data
public class updateUserinfoCase {
        private int id;
        private int userId;
        private String userName;
        private int age;
        private String sex;
        private int permission;
        private int isDelete;
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

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public int getPermission() {
        return permission;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public String getExpected() {
        return expected;
    }
}
