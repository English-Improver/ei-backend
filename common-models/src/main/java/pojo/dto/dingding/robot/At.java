package pojo.dto.dingding.robot;

import java.util.List;

/**
 * @author yitiansong
 * @since 11/14/24
 */
public class At {
    private List<String> atMobiles;
    private List<String> atUserIds;
    private boolean isAtAll;

    public List<String> getAtMobiles() {
        return atMobiles;
    }

    public void setAtMobiles(List<String> atMobiles) {
        this.atMobiles = atMobiles;
    }

    public List<String> getAtUserIds() {
        return atUserIds;
    }

    public void setAtUserIds(List<String> atUserIds) {
        this.atUserIds = atUserIds;
    }

    public boolean isAtAll() {
        return isAtAll;
    }

    public void setAtAll(boolean atAll) {
        isAtAll = atAll;
    }
}
