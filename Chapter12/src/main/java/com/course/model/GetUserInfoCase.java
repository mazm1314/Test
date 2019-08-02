package com.course.model;

import lombok.Data;

@Data
public class GetUserInfoCase {

    private int userId;
    private String expected;

    public int getUserId() {
        return userId;
    }

    public String getExpected() {
        return expected;
    }
}
