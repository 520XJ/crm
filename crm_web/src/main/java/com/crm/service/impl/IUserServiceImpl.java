package com.crm.service.impl;

import com.crm.dao.PermissionDao;
import com.crm.dao.RoleDao;
import com.crm.dao.UserDao;
import com.crm.dao.UserRoleDao;
import com.crm.framework.constant.CrmConstant;
import com.crm.model.Permission;
import com.crm.model.Role;
import com.crm.model.User;
import com.crm.model.UserRole;
import com.crm.service.IUserService;
import com.crm.utils.Md5Util;
import com.crm.utils.ResultInfo;
import com.crm.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired(required = false)
    private HttpSession session;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RoleDao roleDao;

    // 用户登陆
    @Override
    public ResultInfo userLogin(String userName,String userPwd) {
        ResultInfo resultInfo = new ResultInfo();
        if(StringUtil.isEmpty(userName)){
            resultInfo.setCode(500);
            resultInfo.setMsg("用户名不能为空");
            return resultInfo;
        } else if (StringUtil.isEmpty(userPwd)) {
            resultInfo.setCode(500);
            resultInfo.setMsg("用户密码不能为空");
            return resultInfo;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("isValid", 1);
        User user = userDao.findOne(map);
        if (user == null) {
            resultInfo.setCode(500);
            resultInfo.setMsg("该用户不存在");
        }
        //加密比对密码
        System.out.println(user.getUserPwd());
        System.out.println(Md5Util.encode(userPwd));
        if (!user.getUserPwd().equals(Md5Util.encode(userPwd))) {
            resultInfo.setCode(500);
            resultInfo.setMsg("用户密码错误");
            return resultInfo;
        }
        queryUserPrivileges(user.getId());  //查询用户权限
        session.setAttribute("userName", userName);
        session.setAttribute("trueName",user.getTrueName());
        return resultInfo;
    }


    /**
     *
     * 1, 通过 userId 查询 user_role 表 得到 roleId
     * 2,通过 roleId 查询 用户角色
     * 3，通过role角色id 查询t_permission表 得到角色的所有权限
     * @param userId
     * @return
     */
    public void queryUserPrivileges(Integer userId){

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        UserRole userRole = userRoleDao.findOne(map);

        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("id",userRole.getRoleId());
        roleMap.put("isValid", 1);
        Role role = roleDao.findOne(roleMap);
        Map<String, Object> permissionMap = new HashMap<>();
        permissionMap.put("roleId", role.getId());
        List<Permission> permissions = permissionDao.find(permissionMap);

        //创建集合接收权限值
        List<String> permissionList = new ArrayList<>();

        //迭代器
        Iterator<Permission> iterator = permissions.iterator();

        while (iterator.hasNext()) {
            Permission permission = iterator.next();
            permissionList.add(permission.getAclValue());
        }

        //把该用户的权限值写入 session
        session.setAttribute(CrmConstant.USER_PERMISSIONS, permissionList);
    }



}
