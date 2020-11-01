package com.csuylg.modules.system.service.impl;

import com.csuylg.modules.system.domain.Admin;
import com.csuylg.modules.system.mapper.AdminMapper;
import com.csuylg.modules.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员表业务层接口实现类
 *
 * @author dyf
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin selectAdmin(Admin admin) {
        return adminMapper.selectOne(admin);
    }
}
