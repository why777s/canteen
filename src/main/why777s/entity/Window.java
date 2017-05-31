package entity;

import javax.persistence.*;

/**
 * Created by why777s on 2017/5/18.
 */
@Entity
public class Window {
    private String wid;
    private String wname;
    //
    private Floor floorByFid;

    @Id
    @Column(name = "wid", nullable = false, length = 45)
    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    @Basic
    @Column(name = "wname", nullable = false, length = 45)
    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Window window = (Window) o;

        if (wid != null ? !wid.equals(window.wid) : window.wid != null) return false;
        if (wname != null ? !wname.equals(window.wname) : window.wname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = wid != null ? wid.hashCode() : 0;
        result = 31 * result + (wname != null ? wname.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fid", referencedColumnName = "fid", nullable = false)
    public Floor getFloorByFid() {
        return floorByFid;
    }
    public void setFloorByFid(Floor floorByFid) {
        this.floorByFid = floorByFid;
    }
}
