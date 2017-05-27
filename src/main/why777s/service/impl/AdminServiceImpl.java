package service.impl;

import dao.impl.*;
import entity.*;
import org.springframework.transaction.annotation.Transactional;
import service.AdminService;

import java.util.List;

/**
 * Created by why777s on 2017/5/18.
 */
public class AdminServiceImpl implements AdminService {
    private AdminDaoImpl adminDao;
    private CanteenDaoImpl canteenDao;
    private FloorDaoImpl floorDao;
    private WindowDaoImpl windowDao;
    private DishDaoImpl dishDao;
    private OrderDaoImpl orderDao;
    private DishOrderDaoImpl dishOrderDao;
    private CommentDaoImpl commentDao;

    public void setCommentDao(CommentDaoImpl commentDao) {
        this.commentDao = commentDao;
    }

    public void setDishOrderDao(DishOrderDaoImpl dishOrderDao) {
        this.dishOrderDao = dishOrderDao;
    }
    public void setOrderDao(OrderDaoImpl orderDao) {
        this.orderDao = orderDao;
    }

    public void setDishDao(DishDaoImpl dishDao) {
        this.dishDao = dishDao;
    }

    public void setWindowDao(WindowDaoImpl windowDao) {
        this.windowDao = windowDao;
    }

    public void setAdminDao(AdminDaoImpl adminDao) {
        this.adminDao = adminDao;
    }

    public void setCanteenDao(CanteenDaoImpl canteenDao) {
        this.canteenDao = canteenDao;
    }

    public void setFloorDao(FloorDaoImpl floorDao) {
        this.floorDao = floorDao;
    }

    @Transactional
    public boolean login(Admin admin) {
        Admin target_admin = adminDao.get(Admin.class,admin.getAid());
        if (target_admin ==null)
            return false;
        else
            return target_admin.getApassword().equals(admin.getApassword());
//        return (target_admin==null) && target_admin.getApassword().equals(admin.getApassword());
    }


    @Transactional
    public List<Floor> getFloorByAdminId(String aid) {
        Admin admin = adminDao.get(Admin.class,aid);
        String hql = "from Floor " +
                "where canteen_id = ? ";
        return floorDao.find_withOnePara(hql,admin.getCanteenByCanteenId().getCanteenId());
    }

    @Transactional
    public Admin getAdmin(String aid) {
        return adminDao.get(Admin.class,aid);
    }

    @Transactional
    public List<Window> getWindowByFloorId(String fid) {
        String hql = "from Window " +
                "where fid=?";
        return windowDao.find_withOnePara(hql,fid);
    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findall(Dish.class);
    }


    @Transactional
    public void updateDish(Dish dish) {
        dishDao.update(dish);
    }

    @Transactional
    public Dish getDishByDid(int did) {
        return dishDao.get(Dish.class,did);
    }

    @Transactional
    public Window getWindowByWid(String wid) {
        return windowDao.get(Window.class,wid);
    }

    @Transactional
    public List<OrderStu> getOrderByOrderStatus(String status) {
        String hql = "from OrderStu " +
                "where orderStatus=?";
        return orderDao.find_withOnePara(hql,status);
    }

    @Transactional
    public List<DishOrder> getDishOrderByOid(int oid) {
        String hql = "from DishOrder " +
                "where  oid=?";
        return dishOrderDao.find_withOnePara(hql,oid);
    }

    @Transactional
    public OrderStu getOrderByOid(int oid) {
        return orderDao.get(OrderStu.class,oid);
    }

    @Transactional
    public void updateOrderPrice(int oid) {
        Double sum = 0.0;
        OrderStu order = getOrderByOid(oid);
        List<DishOrder> dishOrders = getDishOrderByOid(oid);
        for (DishOrder dishOrder:dishOrders){
            Dish dish = getDishByDid(dishOrder.getDid());
            sum+= dish.getDprice() * dishOrder.getDnum();
        }
        order.setOprice(sum);
        orderDao.update(order);
    }

    @Transactional
    public List<Comment> getAllComment() {
        return commentDao.findall(Comment.class);
    }


}
