package controller;

import com.opensymphony.xwork2.ActionSupport;
import entity.OrderStu;
import org.apache.struts2.ServletActionContext;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public class EmployeeAction extends ActionSupport{
    private EmployeeService employeeService;
    //
    private List<OrderStu> new_orders;
    private List<OrderStu> ready_orders;
    private List<OrderStu> finished_orders;
    private List<OrderStu> all_orders;


    private String message;

    private int oidForAlter;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOidForAlter() {
        return oidForAlter;
    }

    public void setOidForAlter(int oidForAlter) {
        this.oidForAlter = oidForAlter;
    }

    public List<OrderStu> getReady_orders() {
        return ready_orders;
    }

    public void setReady_orders(List<OrderStu> ready_orders) {
        this.ready_orders = ready_orders;
    }

    public List<OrderStu> getNew_orders() {
        return new_orders;
    }

    public void setNew_orders(List<OrderStu> new_orders) {
        this.new_orders = new_orders;
    }

    public List<OrderStu> getAll_orders() {
        return all_orders;
    }

    public void setAll_orders(List<OrderStu> all_orders) {
        this.all_orders = all_orders;
    }

    public List<OrderStu> getFinished_orders() {
        return finished_orders;
    }

    public void setFinished_orders(List<OrderStu> finished_orders) {
        this.finished_orders = finished_orders;
    }

    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    // 从Session中获取当前登录用户的id
    public String getUserFromSession(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        return (String)session.getAttribute("userID");
    }


    /**
     * 跳转订单处理"orderInfo.jsp"的Action的处理方法
     */
    public String turnOrderProcess() throws Exception{
        message = null;
        new_orders = employeeService.getAllOrderByStatus("NEW");
        ready_orders = employeeService.getAllOrderByStatus("READY");
        finished_orders = employeeService.getAllOrderByStatus("FINISH");
        all_orders = employeeService.getAllOrder();
        return SUCCESS;
    }

    /**
     * 使订单状态从new变成ready
     *
     */
    public String alterOrderToReady() throws Exception{
        try {
            employeeService.setOrderStatus(oidForAlter, "FINISH");
        }catch (Exception e){
            e.printStackTrace();
            message = "通知失败";
        }

        new_orders = employeeService.getAllOrderByStatus("NEW");
        ready_orders = employeeService.getAllOrderByStatus("READY");
        finished_orders = employeeService.getAllOrderByStatus("FINISH");
        all_orders = employeeService.getAllOrder();

        message = "通知成功";

        return SUCCESS;

    }
}