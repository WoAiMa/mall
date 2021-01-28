package com.demo.malls2basic.service;

import com.demo.malls2basic.dto.UmsAdminLoginParam;
import com.demo.malls2basic.mbg.model.UmsAdmin;
import com.demo.malls2basic.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员service
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return
     */
    UmsAdmin getUmsAdminByUserName(String username);

    /**
     * 注册功能
     * @return
     * @param umsAdmin
     */
    UmsAdmin register(UmsAdminLoginParam umsAdmin);

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     * @param adminid
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminid);
}
