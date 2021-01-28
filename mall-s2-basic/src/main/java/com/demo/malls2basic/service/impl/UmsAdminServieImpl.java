package com.demo.malls2basic.service.impl;

import com.demo.malls2basic.dao.UmsAdminRoleRelationDao;
import com.demo.malls2basic.dto.UmsAdminLoginParam;
import com.demo.malls2basic.mbg.mapper.UmsAdminMapper;
import com.demo.malls2basic.mbg.model.UmsAdmin;
import com.demo.malls2basic.mbg.model.UmsAdminExample;
import com.demo.malls2basic.mbg.model.UmsPermission;
import com.demo.malls2basic.service.UmsAdminService;
import com.demo.malls2basic.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UmsAdminServieImpl implements UmsAdminService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UmsAdminServieImpl.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;

    @Override
    public UmsAdmin getUmsAdminByUserName(String username) {
        UmsAdminExample umsAdminExample = new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(umsAdminExample);
        if (umsAdminList != null && umsAdminList.size() > 0) {
            return umsAdminList.get(0);
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdminLoginParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        // 查询数据库是否记录
        UmsAdminExample umsAdminExample = new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(umsAdminExample);
        if (umsAdminList != null && umsAdminList.size() > 0) {
            return null;
        }
        // 密码进行加密
        String encodePassword = passwordEncoder.encode(umsAdminParam.getPassword());
        umsAdmin.setPassword(encodePassword);
        int count = umsAdminMapper.insert(umsAdmin);
        return count > 0 ? umsAdmin : null;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetail = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password,userDetail.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetail,null,userDetail.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetail);
        } catch (AuthenticationException e) {
            LOGGER.error("Login exception", e);
        }
        return token;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminid) {
        return umsAdminRoleRelationDao.getPermissionList(adminid);
    }
}
