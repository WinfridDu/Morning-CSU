package com.csuylg.modules.system.service;

import com.csuylg.modules.system.domain.Admin;

/**
 * 管理员表业务层接口
 *
 * @author dyf
 */
public interface AdminService {
    /**
     * 查询管理员
     * @param admin 管理员条件
     * @return 管理员
     */
    Admin selectAdmin(Admin admin);
}
