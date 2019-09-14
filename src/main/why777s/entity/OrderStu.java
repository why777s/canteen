package entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by why777s on 2017/5/22.
 */
@Entity
@Table(name = "order_stu", schema = "canteen", catalog = "")
public class OrderStu {
    private int oid;
    private String sid;
    private Date orderTime;
    private Double oprice;
    private String orderStatus;
    //
    private Student studentBySid;

    public OrderStu() {
    }

    @Id
    @Column(name = "oid", nullable = false)
    public int getOid() {
        return oid;
    }
    public void setOid(int oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "sid",nullable = false)
    public String getSid() {return sid;}
    public void setSid(String sid) {this.sid = sid;}

    @Basic
    @Column(name = "order_time", nullable = false)
    public Date getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "oprice", nullable = true, precision = 0)
    public Double getOprice() {
        return oprice;
    }
    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    @Basic
    @Column(name = "order_status", nullable = true, length = 45)
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderStu orderStu = (OrderStu) o;

        if (oid != orderStu.oid) return false;
        if (orderTime != null ? !orderTime.equals(orderStu.orderTime) : orderStu.orderTime != null) return false;
        if (oprice != null ? !oprice.equals(orderStu.oprice) : orderStu.oprice != null) return false;
        if (orderStatus != null ? !orderStatus.equals(orderStu.orderStatus) : orderStu.orderStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + (orderTime != null ? orderTime.hashCode() : 0);
        result = 31 * result + (oprice != null ? oprice.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sid",referencedColumnName = "sid",nullable = false,insertable = false,updatable = false)
    public Student getStudentBySid() {return studentBySid;}
    public void setStudentBySid(Student studentBySid) {
        this.studentBySid = studentBySid;
    }
}
