package service.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.impl.CommentDaoImpl;
import dao.impl.DishDaoImpl;
import dao.impl.EmployeeDaoImpl;
import dao.impl.OrderDaoImpl;
import entity.Employee;
import entity.OrderStu;
import org.springframework.transaction.annotation.Transactional;
import service.EmployeeService;

import java.util.List;

/**
 * Created by why777s on 2017/5/23.
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDaoImpl employeeDao;
    private OrderDaoImpl orderDao;
    private CommentDaoImpl commentDao;
    private DishDaoImpl dishDao;
    private OrderStu orderStu;

    public void setOrderStu(OrderStu orderStu) {
        this.orderStu = orderStu;
    }

    public void setEmployeeDao(EmployeeDaoImpl employeeDao) {this.employeeDao = employeeDao;}
    public void setOrderDao(OrderDaoImpl orderDao) {this.orderDao = orderDao;}
    public void setCommentDao(CommentDaoImpl commentDao) {this.commentDao = commentDao;}
    public void setDishDao(DishDaoImpl dishDao) {this.dishDao = dishDao;}

    @Transactional
    public boolean login(Employee emp){
        Employee target_emp=employeeDao.get(Employee.class,emp.getEid());
        if(target_emp==null){
            return false;
        }else{
            return target_emp.getEpassword().equals(emp.getEpassword());
        }
    }

    @Transactional
    public List<OrderStu> getAllNewOrder() {
        String status = "NEW";
        String hql = "from OrderStu " +
                "where orderStatus = ?";
        return orderDao.find_withOnePara(hql,status);
    }

    @Transactional
    public List<OrderStu> getAllOrder() {
        return orderDao.findall(OrderStu.class);
    }

    @Transactional
    public List<OrderStu> getAllOrderByStatus(String status) {
        String hql = "from OrderStu " +
                "where orderStatus = ?";
        return orderDao.find_withOnePara(hql,status);
    }

    @Transactional
    public OrderStu getOrderByOid(int oid) {
        return orderDao.get(OrderStu.class,oid);
    }

    @Transactional
    public void setOrderStatus(int oid,String new_status) {
        OrderStu orderStu = orderDao.get(OrderStu.class,oid);
        if (!orderStu.getOrderStatus().equals(new_status)){
            orderStu.setOrderStatus(new_status);
            orderDao.update(orderStu);
        }
    }


    @Transactional
    public String getCanteenStatusByCanteenID(String cid) {
        return null;
    }
}