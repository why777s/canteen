package entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by why777s on 2017/5/22.
 */
@Entity
public class Comment {
    private int commentId;
    private String commentContent;
    private String commentTime;

    private int did;
    private String sid;
    private Dish dishByDid;
    private Student studentBySid;

    public Comment() {
    }

    @Id
    @Column(name = "comment_id", nullable = false)
    public int getCommentId() {return commentId;}
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "did",nullable = false)
    public int getDid() {return did;}
    public void setDid(int did) {this.did = did;}

    @Basic
    @Column(name = "sid",nullable = false)
    public String getSid() {return sid;}
    public void setSid(String sid) {this.sid = sid;}

    @Basic
    @Column(name = "comment_content", nullable = false, length = 45)
    public String getCommentContent() {
        return commentContent;
    }
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Basic
    @Column(name = "comment_time")
    public String getCommentTime() {return commentTime;}
    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentId != comment.commentId) return false;
        if (commentContent != null ? !commentContent.equals(comment.commentContent) : comment.commentContent != null)
            return false;
        if (commentTime != null ? !commentTime.equals(comment.commentTime) : comment.commentTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + (commentContent != null ? commentContent.hashCode() : 0);
        result = 31 * result + (commentTime != null ? commentTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sid",referencedColumnName = "sid",nullable = false,insertable = false,updatable = false)
    public Student getStudentBySid() {
        return studentBySid;
    }

    public void setStudentBySid(Student studentBySid) {
        this.studentBySid = studentBySid;
    }

    @ManyToOne
    @JoinColumn(name = "did", referencedColumnName = "did", nullable = false,insertable = false,updatable = false)
    public Dish getDishByDid() {return dishByDid;}
    public void setDishByDid(Dish dishByDid) {
        this.dishByDid = dishByDid;
    }
}
