package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Comment;
import entity.OrderStu;
import entity.Student;
import org.apache.struts2.ServletActionContext;
import service.impl.StudentServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/21.
 */
public class StudentAction extends ActionSupport {
    //服务层变量
    private StudentServiceImpl studentService;
    public void setStudentService(StudentServiceImpl studentService) {this.studentService = studentService;}
    public StudentServiceImpl getStudentService() {return studentService;}
    //视图变量
    private List<OrderStu> orderList;
    private List<Comment> commentList;
    public void setOrderList(List<OrderStu> orderList) {
        this.orderList = orderList;
    }
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    public List<Comment> getCommentList() {return commentList;}
    public List<OrderStu> getOrderList() {return orderList;}

    // 从Session中获取当前登录用户的id
    public String getUserFromSession(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        return (String)session.getAttribute("userID");
    }

    //将订单号传入Session 暂时的方法
    public void putOidToSession(int oid){
        ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        session.put("orderID",oid);
    }



    //查看订单
    public String turnOrderInfo() throws Exception{
        String sid=getUserFromSession();
        System.out.print("学号："+sid+"\n");
        Student stu=studentService.getStu(sid);
        try{
            orderList=studentService.getOrder(sid);
        } catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
        putOidToSession(1);
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
