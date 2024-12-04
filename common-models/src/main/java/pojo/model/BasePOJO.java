package pojo.model;


import java.io.Serial;
import java.util.Date;

/**
 * 基础POJO
 * {@code @Author:} yitiansong
 */
public class BasePOJO implements java.io.Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BasePOJO{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
