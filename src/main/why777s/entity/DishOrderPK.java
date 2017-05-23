package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by why777s on 2017/5/22.
 */
public class DishOrderPK implements Serializable {
    private int oid;
    private int did;

    @Column(name = "oid", nullable = false)
    @Id
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Column(name = "did", nullable = false)
    @Id
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishOrderPK that = (DishOrderPK) o;

        if (oid != that.oid) return false;
        if (did != that.did) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + did;
        return result;
    }
}
