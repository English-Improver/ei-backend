package pojo.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import pojo.model.BasePOJO;

/**
 * @author yitiansong
 * 用户角色关联表
 */
@TableName("ei_user_role")
public class EIUserRole extends BasePOJO {
    private Integer userId;
    private Integer roleId;

    @Override
    public String toString() {
        return "EIUserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
