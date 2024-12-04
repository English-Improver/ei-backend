//package com.ei.dingdingTalk.service;
//
//import com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenResponse;
//import com.ei.config.DingdingConfig;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.aliyun.tea.*;
//
///**
// * @author yitiansong
// * @since 11/13/24
// */
//@Service
//@Slf4j
//public class DingdingTalkService implements DingTaklService{
//    @Autowired
//    private DingdingConfig dingConfig;
//    private static String robotId = "dingquta6glbcz2ops1g";
//    private static String accessToken = "b2575a6fd63f3f4bb91ebf2f42943b39";
//    private static String appkey = "dingquta6glbcz2ops1g";
//    private static String appSecret = "sckhBNUwUZUh_IuuShthYuA_1loi3MWYix1P1BopZKas-obe5HV3LyctLcI9KCzu";
//    @Override
//    public void talk(String msg) throws Exception {
//
//    }
//    /**
//     * 使用 Token 初始化账号Client
//     * @return Client
//     * @throws Exception
//     */
//    public static com.aliyun.dingtalkrobot_1_0.Client createClient() throws Exception {
//        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config();
//        config.protocol = "https";
//        config.regionId = "central";
//        return new com.aliyun.dingtalkrobot_1_0.Client(config);
//    }
//
//    public static void main(String[] args_) throws Exception {
//        java.util.List<String> args = java.util.Arrays.asList(args_);
//        com.aliyun.dingtalkrobot_1_0.Client client = DingdingTalkService.createClient();
//        com.aliyun.dingtalkrobot_1_0.models.PrivateChatSendHeaders privateChatSendHeaders = new com.aliyun.dingtalkrobot_1_0.models.PrivateChatSendHeaders();
//        // get access token
//        var res = getAccessToken();
//        privateChatSendHeaders.xAcsDingtalkAccessToken = res;
//        // get  conversation id openConversationId
//        com.aliyun.dingtalkrobot_1_0.models.PrivateChatSendRequest privateChatSendRequest = new com.aliyun.dingtalkrobot_1_0.models.PrivateChatSendRequest()
//                .setMsgParam("{\"content\":\"钉钉，让进步发生\"}")
//                .setMsgKey("sampleText")
//                .setOpenConversationId("cid6******==")
//                .setRobotCode(robotId)
//                .setCoolAppCode("75d9f280-ad7e-4f57-9f41-aebb0a2f1632");
//        try {
//           var result =  client.privateChatSendWithOptions(privateChatSendRequest, privateChatSendHeaders, new com.aliyun.teautil.models.RuntimeOptions());
//           System.out.println("wait");
//        } catch (TeaException err) {
//            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
//                // err 中含有 code 和 message 属性，可帮助开发定位问题
//                System.out.println(err.code);
//                System.out.println(err.message);
//            }
//
//        } catch (Exception _err) {
//            TeaException err = new TeaException(_err.getMessage(), _err);
//            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
//                // err 中含有 code 和 message 属性，可帮助开发定位问题
//            }
//
//        }
//    }
//
//    public static String getAccessToken() throws Exception {
////        java.util.List<String> args = java.util.Arrays.asList(args_);
//        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config();
//        config.protocol = "https";
//        config.regionId = "central";
//
//        com.aliyun.dingtalkoauth2_1_0.Client client = new com.aliyun.dingtalkoauth2_1_0.Client(config);;
//        com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenRequest getAccessTokenRequest = new com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenRequest()
//                .setAppKey(appkey)
//                .setAppSecret(appSecret);
//        try {
//            GetAccessTokenResponse tokenResponse = client.getAccessToken(getAccessTokenRequest);
//            String token = tokenResponse.getBody().getAccessToken();
////            System.out.println(tokenResponse);
//            return token;
//        } catch (TeaException err) {
//            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
//                // err 中含有 code 和 message 属性，可帮助开发定位问题
//            }
//
//        } catch (Exception _err) {
//            TeaException err = new TeaException(_err.getMessage(), _err);
//            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
//                // err 中含有 code 和 message 属性，可帮助开发定位问题
//            }
//
//        }
//        return "1";
//    }
//
//
//}
