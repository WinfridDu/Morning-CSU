package com.csuylg.modules.signin.controller;

import com.csuylg.modules.signin.domain.Badge;
import com.csuylg.modules.signin.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 徽章信息操作处理
 *
 * @author dyf
 */
@RestController
public class BadgeController {
    @Autowired
    private BadgeService badgeService;

    @GetMapping("/BadageServlet")
    public Map<String, Object> getInfo(String openid){
        Badge badge = badgeService.selectBadge(openid);
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("badge", badge);
        return map;
    }
}
