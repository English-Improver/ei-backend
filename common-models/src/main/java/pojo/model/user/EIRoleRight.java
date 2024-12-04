package pojo.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import pojo.model.BasePOJO;

/**
 * @author yitiansong
 * 角色权限关联表
 */
@TableName("ei_role_right")
public class EIRoleRight extends BasePOJO {

    private Integer roleId;
    private Integer rightId;

    @Override
    public String toString() {
        return "EIRoleRight{" +
                "roleId=" + roleId +
                ", rightId=" + rightId +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }
}
