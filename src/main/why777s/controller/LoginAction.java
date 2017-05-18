package controller;

import com.opensymphony.xwork2.ActionSupport;
import entity.Admin;
import service.impl.AdminServiceImpl;


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

    @Override
    public String execute() throws Exception {
        Admin admin = new Admin();
        admin.setAid(getUsername());
        admin.setApassword(getPassword());
        if (adminService.login(admin))
            return SUCCESS;
        else
            return ERROR;
    }
}
