package entity;

import javax.persistence.*;

/**
 * Created by why777s on 2017/5/18.
 */
@Entity
public class Floor {
    private String fid;
    private String fname;
    private Canteen canteenByCanteenId;

    @Id
    @Column(name = "fid", nullable = false, length = 45)
    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "fname", nullable = false, length = 45)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Floor floor = (Floor) o;

        if (fid != null ? !fid.equals(floor.fid) : floor.fid != null) return false;
        if (fname != null ? !fname.equals(floor.fname) : floor.fname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fid != null ? fid.hashCode() : 0;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "canteen_id", referencedColumnName = "canteen_id", nullable = false)
    public Canteen getCanteenByCanteenId() {
        return canteenByCanteenId;
    }

    public void setCanteenByCanteenId(Canteen canteenByCanteenId) {
        this.canteenByCanteenId = canteenByCanteenId;
    }
}
