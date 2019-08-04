package com.course.model;


import lombok.Data;

@Data
public class User {

    private int id;
    private String userName;
    private String password;
    private int age;
    private  String sex;
    private  int permission;
    private int isDelete;


    /**
     * 以json格式输出
     * @return
     */
    @Override
    public String toString(){
        return(
                "{id:"+id+","+
                        "userName:"+userName+","+
                        "password:"+password+","+
                        "age:"+age+","+
                        "sex:"+sex+","+
                        "permission:"+permission+","+
                        "isDelete:"+isDelete+"}"
        );
    }
}
