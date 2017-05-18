package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by why777s on 2017/5/18.
 */
@Entity
public class Canteen {
    private String canteenId;
    private String canteenCname;

    @Id
    @Column(name = "canteen_id", nullable = false, length = 45)
    public String getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(String canteenId) {
        this.canteenId = canteenId;
    }

    @Basic
    @Column(name = "canteen_cname", nullable = false, length = 45)
    public String getCanteenCname() {
        return canteenCname;
    }

    public void setCanteenCname(String canteenCname) {
        this.canteenCname = canteenCname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Canteen canteen = (Canteen) o;

        if (canteenId != null ? !canteenId.equals(canteen.canteenId) : canteen.canteenId != null) return false;
        if (canteenCname != null ? !canteenCname.equals(canteen.canteenCname) : canteen.canteenCname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = canteenId != null ? canteenId.hashCode() : 0;
        result = 31 * result + (canteenCname != null ? canteenCname.hashCode() : 0);
        return result;
    }
}
