package pojo.model.sentence;


import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
/**
 * @author yitiansong
 */
@TableName("ei_pos")
public class EIPosDO {
    private Integer id;
    private Integer posId;
    private Date createTime;
    private String name;
    private String pos;
    private String color;

    @Override
    public String toString() {
        return "EIPosDO{" +
                "id=" + id +
                ", posId=" + posId +
                ", createTime=" + createTime +
                ", name='" + name + '\'' +
                ", pos='" + pos + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
