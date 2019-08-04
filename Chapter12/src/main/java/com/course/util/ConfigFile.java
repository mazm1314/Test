package com.course.util;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * 这个工具类的作用是拼接我们要访问的接口全部链接
 * 后期用到的时候直接可以进行访问
 */
public class ConfigFile {

//    加载配置文件
    public static ResourceBundle bundle=ResourceBundle.getBundle("application",Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String address=bundle.getString("test.url");
        String uri="";
        //最终的url
        if(name==InterfaceName.ADDUSERINFO){
            uri=bundle.getString("addUser.uri");
        }
        if(name==InterfaceName.GETUSERINFO){
            uri=bundle.getString("getUserInfo.uri");
        }
        if(name==InterfaceName.GETUSERLIST){
            uri=bundle.getString("getUserList.uri");
        }
        if(name==InterfaceName.UPDATEUSERINFO){
            uri=bundle.getString("updateUserInfo.uri");
        }
        if(name==InterfaceName.LOGIN){
            uri=bundle.getString("login.uri");
        }
        String testUrl = address + uri;
        return testUrl;
    }
}
