package com.csuylg.modules.system.controller;

import com.csuylg.modules.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * @author dyf
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 响应用户浏览过了通知
     */
    @GetMapping("/ReadServlet")
    public void readNotice(String openid){
        userService.updateStatus(openid, "1");
    }
}
