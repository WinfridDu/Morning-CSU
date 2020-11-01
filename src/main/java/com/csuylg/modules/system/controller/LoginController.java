package com.csuylg.modules.system.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuylg.config.WeixinConfig;
import com.csuylg.modules.system.dto.LoginResponse;
import com.csuylg.modules.system.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录验证
 *
 * @author dyf
 */
@RestController
public class LoginController {

    @Autowired
    private WeixinConfig weixinConfig;

    @Autowired
    private LoginService loginService;

    /**
     * 响应用户登录小程序时发送的请求
     */
    @GetMapping("/Servlet")
    public String login(String code){
        if (StringUtils.isEmpty(code)) {
            return "Error: Miss parameter 'code'.";
        }
        String openid = weixinConfig.oauth2GetOpenid(code);

        LoginResponse loginResponse = loginService.login(openid);
        // 关闭引用检测
        return JSON.toJSONString(loginResponse, SerializerFeature.DisableCircularReferenceDetect);
    }
}
