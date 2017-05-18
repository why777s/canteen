package entity;

import javax.persistence.*;

/**
 * Created by why777s on 2017/5/18.
 */
@Entity
public class Admin {
    private String aid;
    private String aname;
    private String apassword;
    private Canteen canteenByCanteenId;


    public Admin() {
    }


    public Admin(String aid, String apassword) {
        this.aid = aid;
        this.apassword = apassword;
    }

    @Id
    @Column(name = "aid", nullable = false, length = 45)
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "aname", nullable = true, length = 45)
    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (aid != null ? !aid.equals(admin.aid) : admin.aid != null) return false;
        if (aname != null ? !aname.equals(admin.aname) : admin.aname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid != null ? aid.hashCode() : 0;
        result = 31 * result + (aname != null ? aname.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "apassword", nullable = false, length = 45)
    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
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
