package pojo.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import pojo.model.BasePOJO;

/**
 * @author yitiansong
 * 角色表
 */
@TableName("ei_role")
public class EIRole extends BasePOJO {
    private String name;
    private String info;

    @Override
    public String toString() {
        return "EIRole{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
