package com.csuylg.config;

import com.alibaba.fastjson.JSONObject;
import com.csuylg.common.utils.HttpUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 小程序配置类
 *
 * @author dyf
 */
@Configuration
@ConfigurationProperties(prefix = "weixin")
public class WeixinConfig {
    public final static String URL = "https://api.weixin.qq.com/sns/jscode2session";

    private String appid;
    private String secret;
    private String grantType;

    public String oauth2GetOpenid(String code){
        String rspStr = HttpUtils.sendGet(URL, "appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=" + grantType);
        JSONObject obj = JSONObject.parseObject(rspStr);
        return obj.getString("openid");
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}
