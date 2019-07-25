package course.com.bean;


import lombok.Data;

@Data   //lombok.Data进行标注
public class User {
    private String userName;
    private String password;
    private String name;
    private String age;
    private String sex;
}
