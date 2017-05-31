package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by why777s on 2017/5/23.
 */
@Entity
public class Employee {
    private String eid;
    private String epassword;
    private String ename;
    private String esex;

    @Id
    @Column(name = "eid", nullable = false, length = 45)
    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "epassword", nullable = true, length = 45)
    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }

    @Basic
    @Column(name = "ename", nullable = true, length = 45)
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "esex", nullable = true, length = 45)
    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (eid != null ? !eid.equals(employee.eid) : employee.eid != null) return false;
        if (epassword != null ? !epassword.equals(employee.epassword) : employee.epassword != null) return false;
        if (ename != null ? !ename.equals(employee.ename) : employee.ename != null) return false;
        if (esex != null ? !esex.equals(employee.esex) : employee.esex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid != null ? eid.hashCode() : 0;
        result = 31 * result + (epassword != null ? epassword.hashCode() : 0);
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (esex != null ? esex.hashCode() : 0);
        return result;
    }
}
