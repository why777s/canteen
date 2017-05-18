package service.impl;

import dao.impl.AdminDaoImpl;
import entity.Admin;
import org.springframework.transaction.annotation.Transactional;
import service.AdminService;

/**
 * Created by why777s on 2017/5/18.
 */
public class AdminServiceImpl implements AdminService {
    private AdminDaoImpl adminDao;

    public void setAdminDao(AdminDaoImpl adminDao) {
        this.adminDao = adminDao;
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
}
