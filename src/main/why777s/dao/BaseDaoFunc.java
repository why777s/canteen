package dao;

import org.hibernate.EntityMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public class BaseDaoFunc<T> implements BaseDao<T> {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //根据id加载实体
    @SuppressWarnings("unchecked")
    public T get(Class<T> entityClass, Serializable id) {
        return (T)getSessionFactory().getCurrentSession().get(entityClass,id);
    }

    //保存实体
    public Serializable save(T entity) {
        return getSessionFactory().getCurrentSession().save(entity);
    }

    //更新实体
    public void update(T entity) {
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    //删除实体
    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    //根据ID删除实体
    public void delete(Class<T> entityClass, Serializable id) {
        getSessionFactory().getCurrentSession()
                .createQuery("delete"+entityClass.getSimpleName()
                    + "en where en.id = ?")
                .setParameter("0",id)
                .executeUpdate();
    }

    //根据HQL语言查询实体
    @SuppressWarnings("unchecked")
    public List<T> find(String hql){
        return (List<T>)getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .list();
    }


    @SuppressWarnings("unchecked")
    public List<T> find_withOnePara(String hql, String para) {
        return (List<T>)getSessionFactory().getCurrentSession()
                .createQuery(hql).setParameter(0,para)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<T> find_withOnePara(String hql, int para) {
        return (List<T>)getSessionFactory().getCurrentSession()
                .createQuery(hql).setParameter(0,para)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<T> find_withTwoPara(String hql, String para1, String para2) {
        return (List<T>)getSessionFactory().getCurrentSession()
                .createQuery(hql).setParameter(0,para1).setParameter(1,para2)
                .list();
    }

    //获取所有实体
//   有问题好像
    public List<T> findall(Class<T> entityClass) {
//        return find("select en from "+entityClass.getSimpleName()+" en");
        return find("from "+entityClass.getSimpleName());
    }

    public long findCount(Class<T> entityClass) {
        List<?> l = find("select count(*) from "
                        + entityClass.getSimpleName());
        //返回查询得到的实体总数
        if (l != null && l.size() ==1 ){
            return (Long)l.get(0);
        }
        return 0;
    }
}
