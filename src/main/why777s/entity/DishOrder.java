package entity;

import javax.persistence.*;

/**
 * Created by why777s on 2017/5/22.
 */
@Entity
@Table(name = "dish_order", schema = "canteen", catalog = "")
@IdClass(DishOrderPK.class)
public class DishOrder {
    private int oid;
    private int did;
    private Integer dnum;
    //
    private Dish dishByDid;
    private OrderStu orderStuByOid;

    public DishOrder() {}

    @Id
    @Column(name = "oid", nullable = false)
    public int getOid() {
        return oid;
    }
    public void setOid(int oid) {
        this.oid = oid;
    }

    @Id
    @Column(name = "did", nullable = false)
    public int getDid() {
        return did;
    }
    public void setDid(int did) {
        this.did = did;
    }

    @Basic
    @Column(name = "dnum", nullable = true)
    public Integer getDnum() {
        return dnum;
    }
    public void setDnum(Integer dnum) {
        this.dnum = dnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishOrder dishOrder = (DishOrder) o;

        if (oid != dishOrder.oid) return false;
        if (did != dishOrder.did) return false;
        if (dnum != null ? !dnum.equals(dishOrder.dnum) : dishOrder.dnum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + did;
        result = 31 * result + (dnum != null ? dnum.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "did",referencedColumnName = "did",nullable = false,insertable = false,updatable = false)
    public Dish getDishByDid() {return dishByDid;}
    public void setDishByDid(Dish dishByDid) {this.dishByDid = dishByDid;}

    @ManyToOne
    @JoinColumn(name = "oid",referencedColumnName = "oid",nullable = false,insertable = false,updatable = false)
    public OrderStu getOrderStuByOid() {return orderStuByOid;}
    public void setOrderStuByOid(OrderStu orderStuByOid) {this.orderStuByOid = orderStuByOid;}
}
