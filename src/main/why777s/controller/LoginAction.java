package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Admin;
import service.impl.AdminServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * The type Login action.
 * @author why777s
 */

public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    private AdminServiceImpl adminService;

    public void setAdminService(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 将当前登录的用户id保存到Session中
    public void putUserToSession(String userid){
        ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        session.put("userID",userid);
    }


    //  处理用户登录Action的方法
    public String login() throws Exception {
        Admin admin = new Admin();
        admin.setAid(getUsername());
        admin.setApassword(getPassword());
        // 判断密码是否正确
        if (adminService.login(admin)){
            // 若登录成功 将用户id保存到Session
            putUserToSession(getUsername());
            return SUCCESS;
        }
        else
            return ERROR;
    }
}
