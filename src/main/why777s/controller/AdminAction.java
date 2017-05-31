package controller;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import javassist.expr.Instanceof;
import org.apache.struts2.ServletActionContext;
import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by why777s on 2017/5/20.
 */
public class AdminAction extends ActionSupport {
    private AdminServiceImpl adminService;
    private List<Floor> floors;
    private List<Floor> floorList;
    private List<Window> windows;
    private List<Window> first_windows;
    private List<Window> second_windows;
    private List<Window> all_windows;
    private List<Dish> dishes;
    private List<OrderStu> finished_orders;
    private List<Comment> comments;

    private List<DishOrder> dishOrders;
    private int oid_for_dishOrder;
    private OrderStu orderByOid;

    private String ad_downmenu_wid;

    private Window windowByWid;


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public OrderStu getOrderByOid() {
        return orderByOid;
    }

    public void setOrderByOid(OrderStu orderByOid) {
        this.orderByOid = orderByOid;
    }

    public int  getOid_for_dishOrder() {
        return oid_for_dishOrder;
    }

    public void setOid_for_dishOrder(int oid_for_dishOrder) {
        this.oid_for_dishOrder = oid_for_dishOrder;
    }

    private List<String> changed_dnames;
    private List<Double> changed_dprices;
    private List<Integer> dids;

    public List<DishOrder> getDishOrders() {
        return dishOrders;
    }

    public void setDishOrders(List<DishOrder> dishOrders) {
        this.dishOrders = dishOrders;
    }

    public List<OrderStu> getFinished_orders() {
        return finished_orders;
    }

    public void setFinished_orders(List<OrderStu> finished_orders) {
        this.finished_orders = finished_orders;
    }

    public List<Window> getAll_windows() {
        return all_windows;
    }

    public void setAll_windows(List<Window> all_windows) {
        this.all_windows = all_windows;
    }

    private String message;

    public Window getWindowByWid() {
        return windowByWid;
    }

    public void setWindowByWid(Window windowByWid) {
        this.windowByWid = windowByWid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Integer> getDids() {
        return dids;
    }

    public void setDids(List<Integer> dids) {
        this.dids = dids;
    }

    public List<String> getChanged_dnames() {
        return changed_dnames;
    }

    public void setChanged_dnames(List<String> changed_dnames) {
        this.changed_dnames = changed_dnames;
    }

    public List<Double> getChanged_dprices() {
        return changed_dprices;
    }

    public void setChanged_dprices(List<Double> changed_dprices) {
        this.changed_dprices = changed_dprices;
    }

    public String getAd_downmenu_wid() {
        return ad_downmenu_wid;
    }

    public void setAd_downmenu_wid(String ad_downmenu_wid) {
        this.ad_downmenu_wid = ad_downmenu_wid;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    private Admin admin;

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

    public List<Window> getWindows() {
        return windows;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public void setAdminService(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    // 从Session中获取当前登录用户的id
    public String getUserFromSession(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        return (String)session.getAttribute("userID");
    }


    /**
     * 跳转到canteenInfo.jsp的Action的method
     * 传List<Floor>、当前登录的Admin到前端
     */
    public String turnCanteenInfo() throws Exception{
        String aid = getUserFromSession();
        admin = adminService.getAdmin(aid);
        floors = adminService.getFloorByAdminId(aid);
        return SUCCESS;
    }

    /**
     * 跳转到dishInfo.jsp的Action的method
     * 传两个List<Window>到前端 分别表示一层和二层的所有窗口
     */
    public String turnDishInfo() throws Exception{
        ad_downmenu_wid = "";
        String aid = getUserFromSession();
        admin = adminService.getAdmin(aid);
        floorList = adminService.getFloorByAdminId(aid);
        dishes = adminService.getAllDishes();
        System.out.println("xixii");
        System.out.println(dishes.get(0).getDname());
        try{
            first_windows = adminService.getWindowByFloorId(floorList.get(0).getFid());

            second_windows = adminService.getWindowByFloorId(floorList.get(1).getFid());
        }catch (NullPointerException e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }


    /**
     * 跳转到dishUpdate.jsp的Action的处理方法
     *
     */
    public String turnDishUpdate() throws Exception{
        message = null;
        String aid = getUserFromSession();
        admin = adminService.getAdmin(aid);
        floorList = adminService.getFloorByAdminId(aid);
        dishes = adminService.getAllDishes();
        System.out.println(ad_downmenu_wid);
        try{
            first_windows = adminService.getWindowByFloorId(floorList.get(0).getFid());
            second_windows = adminService.getWindowByFloorId(floorList.get(1).getFid());

//            返回全部窗口
//            all_windows = new ArrayList<Window>();
//            all_windows.addAll(first_windows);
//            all_windows.addAll(second_windows);
//            System.out.println("全部窗口");
//            for (int i =0;i< all_windows.size();i++){
//                System.out.println(all_windows.get(i).getWname());
//                System.out.println(all_windows.get(i) instanceof Window);
//            }

        }catch (NullPointerException e){
            e.printStackTrace();
            return ERROR;
        }
        if (ad_downmenu_wid!=null) {
            windowByWid = adminService.getWindowByWid(ad_downmenu_wid);
        }
        return SUCCESS;
    }


    /**
     * 修改dish
     * 修改完之后返回新的dishes至前端
     */
    public String dishUpdate() throws Exception{
        System.out.println("更新后的餐品信息：");
        System.out.println(dids);
        System.out.println(changed_dnames);
        System.out.println(changed_dprices);
        System.out.println("以上");

        for (int i=0;i<dids.size();i++){
            Dish dish = adminService.getDishByDid((Integer)dids.get(i));
            try {
                dish.setDname(changed_dnames.get(i));
                dish.setDprice(changed_dprices.get(i));
                adminService.updateDish(dish);
                dishes = adminService.getAllDishes();

            }catch (NullPointerException e){
                e.printStackTrace();
                message = "修改失败!";
            }
        }
        message = "修改成功！";
        return SUCCESS;
    }

    /**
     * 跳转到订单查询页面的处理Action
     * 传List<OrderStu> finished_orders 到前台
     */
    public String turnOrderInfo() throws Exception{
        finished_orders = adminService.getOrderByOrderStatus("FINISH");
        return SUCCESS;
    }

    /**
     * 查看某订单的详细信息的Action
     * 根据从前台收到的订单号得到其List<DishOrder>（为了向前台显示该订单的餐品信息）
     * 根据从前台收到的订单号获得订单完整实体（为了向前台显示该订单的学生信息）
     */
    public String turnDishOrderInfo() throws Exception{
        //计算订单的总额   暂且放在这边，暂且！
        adminService.updateOrderPrice(oid_for_dishOrder);
        dishOrders = adminService.getDishOrderByOid(oid_for_dishOrder);
        orderByOid = adminService.getOrderByOid(oid_for_dishOrder);
        return SUCCESS;
    }

    /**
     * 跳转到查看评论页面的Action的处理类
     */
    public String turnAllCommentInfo() throws Exception{
        comments = adminService.getAllComment();
        return SUCCESS;
    }
}
