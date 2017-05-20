package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by why777s on 2017/5/20.
 */
@Entity
public class Order {
    private int oid;
    private Timestamp orderTime;
    private Dish dishByDid;

    @Id
    @Column(name = "oid", nullable = false)
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "order_time", nullable = false)
    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (oid != order.oid) return false;
        if (orderTime != null ? !orderTime.equals(order.orderTime) : order.orderTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + (orderTime != null ? orderTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "did", referencedColumnName = "did", nullable = false)
    public Dish getDishByDid() {
        return dishByDid;
    }

    public void setDishByDid(Dish dishByDid) {
        this.dishByDid = dishByDid;
    }
}
