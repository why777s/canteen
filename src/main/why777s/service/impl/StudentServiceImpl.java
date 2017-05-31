package service.impl;

import dao.impl.*;
import entity.*;
import org.springframework.transaction.annotation.Transactional;
import service.StudentService;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public class StudentServiceImpl implements StudentService {
    private StudentDaoImpl studentDao;
    private OrderStuDaoImpl orderStuDao;
    private CommentDaoImpl commentDao;
    private CanteenDaoImpl canteenDao;
    private FloorDaoImpl floorDao;
    private WindowDaoImpl windowDao;
    private DishDaoImpl dishDao;
    private DishOrderDaoImpl dishorderDao;

    public void setOrderStuDao(OrderStuDaoImpl orderStuDao) {
        this.orderStuDao = orderStuDao;
    }

    public void setStudentDao(StudentDaoImpl studentDao) {this.studentDao = studentDao;}
    public void setCommentDao(CommentDaoImpl commentDao) {this.commentDao = commentDao;}
    public void setDishDao(DishDaoImpl dishDao) {this.dishDao = dishDao;}
    public void setCanteenDao(CanteenDaoImpl canteenDao) {this.canteenDao = canteenDao;}
    public void setFloorDao(FloorDaoImpl floorDao) {this.floorDao = floorDao;}
    public void setWindowDao(WindowDaoImpl windowDao) {this.windowDao = windowDao;}
    public void setDishorderDao(DishOrderDaoImpl dishorderDao) {this.dishorderDao = dishorderDao;}

    @Transactional
    public boolean login(Student stu) {
        Student target_stu = studentDao.get(Student.class,stu.getSid());
        if (target_stu ==null) {
            return false;
        } else{
            return target_stu.getSpassword().equals(stu.getSpassword());
        }
    }

    //共享复用userid?
    @Transactional
    public Student getStu(String sid){
        return studentDao.get(Student.class,sid);
    }

    //查学生订单
    @Transactional
    public List<OrderStu> getOrder(String sid){
        System.out.print("学号"+sid+"\n");
        String hql="from OrderStu where sid=?";
        return orderStuDao.find_withOnePara(hql,"stu01");
    }

    //查学生评论
    @Transactional
    public List<Comment> getComment(String sid){
        String hql="from Comment"+
                " where sid = ?";
        return commentDao.find_withOnePara(hql,sid);
    }

    //查餐品
    @Transactional
    public List<Canteen> getAllCanteen(){return canteenDao.findall(Canteen.class);}

    @Transactional
    public List<Floor> getFloorByCanteenId(String canteenid) {
        String hql = "from Floor " +
                "where canteen_id = ? ";
        return floorDao.find_withOnePara(hql,canteenid);
    }
    @Transactional
    public List<Window> getWindowByFloorId(String fid) {
        String hql = "from Window " +
                "where fid=?";
        return windowDao.find_withOnePara(hql,fid);
    }

    //在jsp等值显示还是查询时就限制？
    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findall(Dish.class);
    }

}