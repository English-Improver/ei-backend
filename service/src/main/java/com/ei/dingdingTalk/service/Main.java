package com.ei.dingdingTalk.service;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import java.util.Arrays;

/**
 * @author yitiansong
 * @since 11/14/24
 */

public class Main {

    private String url = "https://oapi.dingtalk.com/robot/send?access_token=882ca1cdc9e725b62a37937add93da064bb9f9888f0bbc93e80cda7f7cecab07";

    public static void main(String[] args) throws ApiException {
        sendMessageWebhook();
    }
    public static void sendMessageWebhook() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=882ca1cdc9e725b62a37937add93da064bb9f9888f0bbc93e80cda7f7cecab07");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("测试文本消息");
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
//        at.setAtUserIds(Arrays.asList("4525xxxxxxxxx7041"));
        at.setIsAtAll(true);
        request.setAt(at);
        OapiRobotSendResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
}
