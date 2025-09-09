package com.liyue.weixin.httpRequest.domain.entity;

/**
 * 微信登录接口返回结果
 */
public class WxLoginResponse {

    private String openid;      // 用户唯一标识
    private String session_key;  // 会话密钥
    private String unionid;     // 微信开放平台唯一标识（可选）
    private Integer errcode;    // 错误码（非0表示失败）
    private String errmsg;      // 错误信息

    // Getter 和 Setter 方法
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    /**
     * 是否请求成功（errcode == 0）
     */
    public boolean isSuccess() {
        return errcode == null || errcode == 0;
    }
}
