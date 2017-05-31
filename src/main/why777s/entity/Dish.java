package entity;

import javax.persistence.*;

/**
 * Created by why777s on 2017/5/20.
 */
@Entity
public class Dish {
    private int did;
    private String dname;
    private double dprice;
    private String wid;
    //
    private Window windowByWid;

    public Dish() {
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
    @Column(name = "wid",nullable = false,length = 45)
    public String getWid() {return wid;}
    public void setWid(String wid) {this.wid = wid;}

    @Basic
    @Column(name = "dname", nullable = false, length = 45)
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }

    @Basic
    @Column(name = "dprice", nullable = false, precision = 0)
    public double getDprice() {
        return dprice;
    }
    public void setDprice(double dprice) {
        this.dprice = dprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (did != dish.did) return false;
        if (Double.compare(dish.dprice, dprice) != 0) return false;
        if (dname != null ? !dname.equals(dish.dname) : dish.dname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = did;
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        temp = Double.doubleToLongBits(dprice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "wid" ,referencedColumnName = "wid",nullable = false,insertable = false,updatable = false)
    public Window getWindowByWid() {
        return windowByWid;
    }
    public void setWindowByWid(Window windowByWid) {
        this.windowByWid = windowByWid;
    }

}
