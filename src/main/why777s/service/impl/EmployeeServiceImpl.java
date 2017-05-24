package service.impl;

import dao.impl.CommentDaoImpl;
import dao.impl.DishDaoImpl;
import dao.impl.EmployeeDaoImpl;
import dao.impl.OrderStuDaoImpl;
import entity.Employee;
import org.springframework.transaction.annotation.Transactional;
import service.EmployeeService;

/**
 * Created by why777s on 2017/5/23.
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDaoImpl employeeDao;
    private OrderStuDaoImpl orderstuDao;
    private CommentDaoImpl commentDao;
    private DishDaoImpl dishDao;

    public void setEmployeeDao(EmployeeDaoImpl employeeDao) {this.employeeDao = employeeDao;}
    public void setOrderstuDao(OrderStuDaoImpl orderstuDao) {this.orderstuDao = orderstuDao;}
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
}