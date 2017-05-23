package controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/5/21.
 */
public class EmployeeAction extends ActionSupport{
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    // 从Session中获取当前登录用户的id
    public String getUserFromSession(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        return (String)session.getAttribute("userID");
    }
}