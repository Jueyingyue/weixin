package com.liyue.weixin.httpRequest.utils;

/**
 * 微信小程序相关接口 URL 常量类
 * 用于集中管理所有微信官方 API 的请求地址，便于维护和统一调用
 */
public class WxApiUrls {

    // ===================== 【基础登录与用户信息】 ==============// ...省略其他代码...


// ==== 修改后代码 ====

    /**
     * 微信小程序登录接口：通过 code 换取 openid、session_key、unionid
     * 请求方式：GET
     * 官方文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
     */
    public static final String JS_CODE_2_SESSION = "https://api.weixin.qq.com/sns/jscode2session";

    // ===================== 【模板消息 / 订阅消息】 ==============// ...省略其他代码...


// ==== 修改后代码 ====

    /**
     * 发送模板消息接口（已逐渐被订阅消息替代）
     * 请求方式：POST
     * 官方文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/template-message/sendTemplateMessage.html
     */
    public static final String SEND_TEMPLATE_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/template/send";

    /**
     * 发送订阅消息接口（小程序订阅消息推送）
     * 请求方式：POST
     * 官方文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/send.html
     */
    public static final String SEND_SUBSCRIBE_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send";

    // ===================== 【客服消息】 ==============// ...省略其他代码...


// ==== 修改后代码 ====

    /**
     * 客服消息接口（用于接收和主动发送客服消息）
     * 请求方式：POST
     * 官方文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/customer-message/customerServiceMessage.send.html
     */
    public static final String CUSTOMER_SERVICE_MESSAGE_SEND = "https://api.weixin.qq.com/cgi-bin/message/custom/send";

    // ===================== 【小程序码 / 二维码】 ==============// ...省略其他代码...


// ==== 修改后代码 ====

    /**
     * 获取小程序码（无数量限制，永久有效，推荐使用）
     * 请求方式：POST
     * 参数需放在请求体中，以 form-data 或 application/json 传参
     * 官方文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/qr-code/wxacode.getUnlimited.html
     */
    public static final String GET_WXA_CODE_UNLIMIT = "https://api.weixin.qq.com/wxa/getwxacodeunlimit";

    /**
     * 获取小程序二维码（数量有限制，适用于普通场景）
     * 请求方式：GET
     * 官方文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/qr-code/wxacode.createQRCode.html
     */
    public static final String GET_WXA_CODE = "https://api.weixin.qq.com/wxa/createwxaqrcode";

    /**
     * 获取小程序普通链接二维码（小程序首页或指定页面）
     * 请求方式：GET
     * 官方文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/qr-code/wxacode.get.html
     */
    public static final String GET_WXA_QRCODE = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode";

    // ===================== 【支付相关】 ==============// ...省略其他代码...


// ==== 修改后代码 ====

    /**
     * 统一下单接口（微信支付）
     * 请求方式：POST
     * 官方文档：https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_1.shtml
     * 注意：微信支付相关接口通常由商户服务器调用，域名是 api.mch.weixin.qq.com
     */
    public static final String WECHAT_PAY_UNIFIEDORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    // ===================== 【其他常用接口】 ==============// ...省略其他代码...


// ==== 修改后代码 ====

    /**
     * 获取小程序全局唯一后台接口调用凭据（access_token）
     * 请求方式：GET
     * 官方文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/access-token/auth.getAccessToken.html
     */
    public static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";

    /**
     * 小程序发送订阅消息的 access_token 也是通过这个接口获取
     * （与公众号共用 access_token 获取接口）
     */

    /**
     * 数据分析相关接口（如获取访问数据等）
     * 比如：获取用户访问小程序数据日报表
     */
    // 示例（具体按需添加）:
     public static final String GET_DAILY_VISIT_TREND = "https://api.weixin.qq.com/datacube/getweanalysisappiddailystatvisitpage/";


    /**
     * 硅基流动
     */
    public static final String[] Qwen_QwQ_32B={"https://api.siliconflow.cn/v1/chat/completions","https://open.bigmodel.cn/api/paas/v4/chat/completions"};




}
