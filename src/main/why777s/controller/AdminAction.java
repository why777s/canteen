package controller;

import com.opensymphony.xwork2.ActionSupport;
import entity.Admin;
import entity.Dish;
import entity.Floor;
import entity.Window;
import org.apache.struts2.ServletActionContext;
import service.impl.AdminServiceImpl;

import javax.servlet.http.HttpSession;
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
    private List<Dish> dishes;



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
        String aid = getUserFromSession();
        admin = adminService.getAdmin(aid);
        floorList = adminService.getFloorByAdminId(aid);
        dishes = adminService.getAllDishes();
        System.out.println("xixii");
        System.out.println(dishes.get(0).getDname());
        for (int i =0;i<floorList.size();i++){
            System.out.println(i);
            System.out.println(floorList.get(i).getFid());
        }
        try{
            first_windows = adminService.getWindowByFloorId(floorList.get(0).getFid());
            second_windows = adminService.getWindowByFloorId(floorList.get(1).getFid());
        }catch (NullPointerException e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }
}
