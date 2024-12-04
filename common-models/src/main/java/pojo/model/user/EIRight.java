package pojo.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import pojo.model.BasePOJO;

/**
 * @author yitiansong
 * 权限表
 */
@TableName("ei_right")
public class EIRight extends BasePOJO {
    private String permission;
    private String info;

    @Override
    public String toString() {
        return "EIRight{" +
                "permission='" + permission + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
