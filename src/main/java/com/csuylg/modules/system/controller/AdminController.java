package com.csuylg.modules.system.controller;

import com.csuylg.common.web.CommonResponse;
import com.csuylg.modules.system.domain.Admin;
import com.csuylg.modules.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员表控制层
 *
 * @author dyf
 */

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 响应用户点击上传文件和管理员登录时的密码验证
     */
    @PostMapping("/VerifyServlet")
    public CommonResponse verify(@RequestParam("user") String username, @RequestParam("num") String password){
        Admin admin = adminService.selectAdmin(new Admin(username));
        if(admin != null && admin.getPassword().equals(password)){
            return CommonResponse.success();
        }else{
            return CommonResponse.fail();
        }
    }
}
