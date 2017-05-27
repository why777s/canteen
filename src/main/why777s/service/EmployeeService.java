package service;

import entity.Employee;
import entity.OrderStu;

import javax.persistence.criteria.Order;
import java.util.List;

/**
 * Created by why777s on 2017/5/23.
 */
public interface EmployeeService {
    /**
     * Login boolean.
     * 员工登录验证
     */
    boolean login(Employee employee);

    /**
     * Gets all new order.
     * 获取所有新的订单
     */
    List<OrderStu> getAllNewOrder();

    /**
     * 获取全部订单
     */
    List<OrderStu> getAllOrder();

    /**
     * 根据订单状态获取
     */
    List<OrderStu> getAllOrderByStatus(String status);


    /**
     * 根据订单id获取订单实体
     */
    OrderStu getOrderByOid(int oid);

    /**
     * 根据订单id修改订单状态
     */
    void setOrderStatus(int oid, String new_status);


    /**
     * 根据id返回食堂当前营业状态
     */
    String getCanteenStatusByCanteenID(String cid);
}
