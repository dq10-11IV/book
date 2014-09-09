package com.turtledove.bookdrift.web.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.common.agent.LogServiceAgent;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.User;
import com.turtledove.bookdrift.domain.entity.UserInfo;



public class LoginController  extends AbstractController{

    private String email;
    private String passwd;
    private String wechatNum;
    
    private String name;

    @Autowired
    UserService userService;
    public String login() throws Exception{
        if(LoginUtils.isAExistUser()){
        	UserInfo info = LoginUtils.getCurrentUserInfo();
        	setSuccessResult(info);
        }else 
        	setFailureResult("please register");
        return SUCCESS;
    }
    public String needLogin(){
        
        setFailureResult("need login");
        return SUCCESS;
    }
    public String register(){
       try{
           User user = new User();
           user.setUserEmail(email);
           user.setUserName(name);
           user.setUserPwd(passwd);
           user.setWechatNum(wechatNum);
           user.setCreateDate(new Date());
           user.setLastUpdateDate(new Date());
           if(userService.validateEmail(email))
               setFailureResult("email is existed");
           else {
               userService.insert(user);
               setSuccessResult("register success");
           }
               
       }catch(Exception e){
           LogServiceAgent.error("register fail", e);
           setFailureResult("register fail");
       }
       return SUCCESS;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
  


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getWechatNum() {
        return wechatNum;
    }


    public void setWechatNum(String wechatNum) {
        this.wechatNum = wechatNum;
    }


    public UserService getUserService() {
        return userService;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
