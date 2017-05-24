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
    //视图接收变量
    private int dishInfo_did;
    //视图显示变量
    //订单
    private List<OrderStu> orderstuList;
    //评论
    private List<Comment> commentList;
    private List<Comment> dish_commentList;
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

    public int getDishInfo_did() {return dishInfo_did;}
    public void setDishInfo_did(int dishInfo_did) {this.dishInfo_did = dishInfo_did;}
    public List<Comment> getDish_commentList() {return dish_commentList;}
    public void setDish_commentList(List<Comment> dish_commentList) {this.dish_commentList = dish_commentList;}

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

        dish_commentList=studentService.getAllDishComment();
        for (Comment cm:dish_commentList) {
                System.out.print("评论："+cm.getCommentContent()+"\n");
        }

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

    //查看自己评论
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

    //查看菜品的评论
//    public String DishComment() throws Exception{
//        try{
//            dish_commentList=studentService.getDishComment(dishInfo_did);
//            for (Comment cm:dish_commentList) {
//                System.out.print("评论："+cm.getCommentContent()+"\n");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return ERROR;
//        }
//        return SUCCESS;
//    }


}
