package controller;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import org.apache.struts2.ServletActionContext;
import service.impl.StudentServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
    //点评
    private String content;
    private int cmt_did;
    //下单
    private OrderStu orderStu;
    private List<DishOrder> dishOrderList;
//视图显示变量
    //订单
    private List<OrderStu> orderstuList;
    private List<DishOrder> dishOrderList_look;
    //评论
    private List<Comment> commentList;
    private List<Comment> dish_commentList;
    //菜单
    private List<Floor> floorList;
//    private List<Window> windowList;
    private List<Dish> dishList;
    private int dishsize;
    //
    private List<Window> first_windows;
    private List<Window> second_windows;


   //个人评论
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    public List<Comment> getCommentList() {return commentList;}
    //菜单
    public List<Floor> getFloorList() {return floorList;}
    public void setFloorList(List<Floor> floorList) {this.floorList = floorList;}
//    public List<Window> getWindowList() {return windowList;}
//    public void setWindowList(List<Window> windowList) {this.windowList = windowList;}
    public List<Dish> getDishList() {return dishList;}
    public void setDishList(List<Dish> dishList) {this.dishList = dishList;}
    //
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
    //菜品评论
    public List<Comment> getDish_commentList() {return dish_commentList;}
    public void setDish_commentList(List<Comment> dish_commentList) {this.dish_commentList = dish_commentList;}
    //点评
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getCmt_did() {
        return cmt_did;
    }
    public void setCmt_did(int cmt_did) {
        this.cmt_did = cmt_did;
    }
    //下单
    public OrderStu getOrderStu() {
        return orderStu;
    }
    public void setOrderStu(OrderStu orderStu) {
        this.orderStu = orderStu;
    }
    public List<DishOrder> getDishOrderList() {
        return dishOrderList;
    }
    public void setDishOrderList(List<DishOrder> dishOrderList) {
        this.dishOrderList = dishOrderList;
    }
    //查单
    public void setOrderstuList(List<OrderStu> orderstuList) {
        this.orderstuList = orderstuList;
    }
    public List<OrderStu> getOrderstuList() {return orderstuList;}
    public List<DishOrder> getDishOrderList_look() {return dishOrderList_look;}
    public void setDishOrderList_look(List<DishOrder> dishOrderList_look) {this.dishOrderList_look = dishOrderList_look;}

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
        //菜品评论
        dish_commentList=studentService.getAllDishComment();
        try{
            //用循环控制tab切换？
            first_windows = studentService.getWindowByFloorId(floorList.get(0).getFid());
            second_windows = studentService.getWindowByFloorId(floorList.get(1).getFid());
//            windowList=studentService.getAllWindow();
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    //查看订单
    public String turnOrderInfo() throws Exception{
        String sid=getUserFromSession();
        try{
            orderstuList =studentService.getOrderStu(sid);
            dishOrderList_look=studentService.getAllDishOrder();
        } catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    //查看个人评论
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

    //点评
    public String saveComment() throws Exception{
        if(!getContent().equals("")) {
            Comment comment = new Comment();
            comment.setDid(getCmt_did());
            comment.setCommentContent(getContent());
            comment.setSid(getUserFromSession());
            comment.setCommentTime(new java.sql.Date(new Date().getTime()));
            try {
                studentService.saveComment(comment);
                dish_commentList=studentService.getAllDishComment();
            } catch (Exception e) {
                e.printStackTrace();
                return ERROR;
            }
        }
        return SUCCESS;
    }

    //下单
    public String saveOrder() throws Exception{
        //set:sid,order_time,oprice,order_status
        orderStu.setSid(getUserFromSession());
        orderStu.setOrderTime(new java.sql.Date(new Date().getTime()));
        orderStu.setOrderStatus("NEW");
        //下单号
        int oid=studentService.getAllOrderStu().size()+1;
        System.out.print("下单号："+oid+"\n");
        //set:oid,did,dnum
        for (DishOrder dishorder:dishOrderList) {
            dishorder.setOid(oid);
            System.out.print("菜名："+dishorder.getDid()+"\n");
            System.out.print("数量："+dishorder.getDnum()+"\n");
        }
        try{
            studentService.saveOrder(orderStu,dishOrderList);
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

}
