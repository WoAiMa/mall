package com.demo.malls2basic.dao;

import com.demo.malls2basic.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 后台用户角色和权限管理
 * Created by Aima on 2020/11/23/11:33
 */
//@Component
public interface UmsAdminRoleRelationDao {

    List<UmsPermission> getPermissionList(@Param("adminId")Long adminId);

}
