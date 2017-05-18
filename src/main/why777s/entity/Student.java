package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by why777s on 2017/5/18.
 */
@Entity
public class Student {
    private String sid;
    private String sname;
    private String spassword;

    @Id
    @Column(name = "sid", nullable = false, length = 45)
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "sname", nullable = true, length = 45)
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "spassword", nullable = false, length = 45)
    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (sid != null ? !sid.equals(student.sid) : student.sid != null) return false;
        if (sname != null ? !sname.equals(student.sname) : student.sname != null) return false;
        if (spassword != null ? !spassword.equals(student.spassword) : student.spassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (spassword != null ? spassword.hashCode() : 0);
        return result;
    }
}
