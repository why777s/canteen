package service;

import entity.Admin;

/**
 * Created by why777s on 2017/5/18.
 */
public interface AdminService {
    /**
     * Login boolean.
     * 管理员登录验证
     * @param admin the admin
     * @return the boolean
     */
    boolean login(Admin admin);
}
