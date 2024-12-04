package pojo.dto.dingding.robot;

/**
 * @author yitiansong
 * @since 11/14/24
 * 机器人文本类型🤖
 */

public class TextType {
    private At at;
    private Text text;
    private final String msgType = "text";

    public At getAt() {
        return at;
    }

    public void setAt(At at) {
        this.at = at;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}

