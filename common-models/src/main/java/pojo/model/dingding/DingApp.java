package pojo.model.dingding;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author yitiansong
 * @since 11/14/24
 */
@TableName("dingApp")
public class DingApp {
    private String appKey;
    private String appSecret;
    private String appName;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
