package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.impl.EmployeeServiceImpl;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by why777s on 2017/5/24.
 */
public class testAction extends ActionSupport {


    private EmployeeServiceImpl employeeService;

    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    private boolean flag = false;


    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String rate;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public String execute() throws Exception {
        System.out.println("收到的表单数据:");
        flag = false;
        System.out.println(rate);
        int oid = Integer.parseInt(rate);
        result = employeeService.getOrderByOid(oid).getOrderStatus();
        return SUCCESS;
    }



//    private String oid;
//
//    public String getOid() {
//        return oid;
//    }
//
//    public void setOid(String oid) {
//        this.oid = oid;
//    }
//
//
//    @Override
//    public String execute() throws Exception {
//        System.out.println("嘻嘻嘻");
//        HttpServletRequest request=(HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
//        HttpServletResponse response=(HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out=response.getWriter();
////        out.write(request.getParameter("s"));
////        out.write(request.getParameter("oid"));
//        System.out.println("s:");
//        System.out.println(request.getParameter("s"));
//        System.out.println("a:");
//        System.out.println(request.getParameter("a"));
//        System.out.println("订单号:");
//        System.out.println(request.getParameter("oid"));
//
//
////        out.flush();
////        out.close();
//
//
//        return SUCCESS;
//    }
}
