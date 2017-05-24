package controller;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import org.apache.struts2.ServletActionContext;
import service.impl.StudentServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public class StudentAction extends ActionSupport {
    //服务层变量
    private StudentServiceImpl studentService;
    public void setStudentService(StudentServiceImpl studentService) {this.studentService = studentService;}
    public StudentServiceImpl getStudentService() {return studentService;}
    //视图变量
    //订单
    private List<OrderStu> orderstuList;
    //评论
    private List<Comment> commentList;
    //菜单
    private List<Dish> dishList;
    private List<Floor> floorList;
    private List<Window> first_windows;
    private List<Window> second_windows;
    private int dishsize;

    public void setOrderstuList(List<OrderStu> orderstuList) {
        this.orderstuList = orderstuList;
    }
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    public List<Comment> getCommentList() {return commentList;}
    public List<OrderStu> getOrderstuList() {return orderstuList;}
    public List<Dish> getDishList() {return dishList;}
    public void setDishList(List<Dish> dishList) {this.dishList = dishList;}
    public List<Floor> getFloorList() {return floorList;}
    public void setFloorList(List<Floor> floorList) {this.floorList = floorList;}

    public List<Window> getFirst_windows() {
        return first_windows;
    }
    public void setFirst_windows(List<Window> first_windows) {
        this.first_windows = first_windows;
    }
    public List<Window> getSecond_windows() {
        return second_windows;
    }
    public void setSecond_windows(List<Window> second_windows) {
        this.second_windows = second_windows;
    }
    public int getDishsize() {return dishsize;}
    public void setDishsize(int dishsize) {this.dishsize = dishsize;}

    // 从Session中获取当前登录用户的id
    public String getUserFromSession(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        return (String)session.getAttribute("userID");
    }

    //查看餐品
    public String turnDishInfo() throws Exception{
        floorList = studentService.getAllFloor();
        dishList = studentService.getAllDishes();
        dishsize=dishList.size();
        try{
            first_windows = studentService.getWindowByFloorId(floorList.get(0).getFid());
            second_windows = studentService.getWindowByFloorId(floorList.get(1).getFid());
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    //查看订单
    public String turnOrderInfo() throws Exception{
        String sid=getUserFromSession();
        Student stu=studentService.getStu(sid);
        try{
            orderstuList =studentService.getOrderStu(sid);
        } catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }


    //查看评论
    public String turnCommentInfo() throws Exception{
        String sid=getUserFromSession();
        try{
            commentList=studentService.getComment(sid);
        }catch(Exception e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }
}
