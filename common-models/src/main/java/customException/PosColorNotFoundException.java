package customException;

/**
 * @author yitiansong
 */
public class PosColorNotFoundException extends Exception{
    public PosColorNotFoundException() {
        super("对应词性及其颜色不存在，请通知管理员进行设置");
    }
}
