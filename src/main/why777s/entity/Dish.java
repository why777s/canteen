package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by why777s on 2017/5/18.
 */
@Entity
public class Dish {
    private String did;
    private String dname;
    private double dprice;

    @Id
    @Column(name = "did", nullable = false, length = 45)
    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

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

        if (Double.compare(dish.dprice, dprice) != 0) return false;
        if (did != null ? !did.equals(dish.did) : dish.did != null) return false;
        if (dname != null ? !dname.equals(dish.dname) : dish.dname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = did != null ? did.hashCode() : 0;
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        temp = Double.doubleToLongBits(dprice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
