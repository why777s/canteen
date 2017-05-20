package service;

import entity.*;

import java.util.List;

/**
 * Created by why777s on 2017/5/18.
 */
public interface AdminService {
    /**
     * Login boolean.
     * 管理员登录验证
     *
     * @param admin the admin
     * @return the boolean
     */
    boolean login(Admin admin);

    /**
     * Gets admin.
     * 根据id获取Admin实体
     *
     * @param aid the aid
     * @return the admin
     */
    Admin getAdmin(String aid);

    /**
     * Gets canteen by admin id.
     * 根据管理员id获取其管理的餐厅各楼层实体
     *
     * @param aid 管理员id
     * @return the floor by admin id
     */
    List<Floor> getFloorByAdminId(String aid);


    /**
     * Gets window by floor id.
     * 根据楼层id获得该层的所有窗口实体
     *
     * @param fid the fid
     * @return the window by floor id
     */
    List<Window> getWindowByFloorId(String fid);


    /**
     * Get all dishes list.
     * 获取所有Dish实体
     * @return the list
     */
    List<Dish> getAllDishes();

}
