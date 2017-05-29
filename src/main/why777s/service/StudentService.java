package service;

import com.sun.org.apache.xpath.internal.operations.Or;
import entity.*;

import java.util.List;

/**
 * Created by why777s on 2017/5/22.
 */
public interface StudentService {


    /**
     * Login boolean.
     * 判断学生用户登录结果
     *
     * @param student the student
     * @return the boolean
     */
    boolean login(Student student);

    /**
     * Gets stu.
     * 根据学生id，获得学生实体
     * @param sid the sid
     * @return the stu
     */
    Student getStu(String sid);

    /**
     * Gets order.
     * 查询学生订单
     * @param sid the sid
     * @return the order
     */
    List<OrderStu> getOrderStu(String sid);

    /**
     * Gets comment.
     * 查询学生评论
     * @param sid the sid
     * @return the comment
     */
    List<Comment> getComment(String sid);

    /**
     * Gets all canteen.
     * 查询食堂吧..
     * @return the all canteen
     */
    List<Canteen> getAllCanteen();

    /**
     * Gets window by floor id.
     * 获得各窗口实体
     * @param fid the fid
     * @return the window by floor id
     */
    List<Window> getWindowByFloorId(String fid);

    /**
     * Gets all dishes.
     * 查询所有餐品
     * @return the all dishes
     */
    List<Dish> getAllDishes();


}
