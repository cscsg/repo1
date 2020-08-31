package com.zl.ssm.service.impl;

import com.zl.ssm.dao.IRoleDao;
import com.zl.ssm.dao.Permission;
import com.zl.ssm.dao.Role;
import com.zl.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return iRoleDao.findAll();
    }

    @Override
    public Role findById(Integer id) throws Exception {
        return iRoleDao.findById(id);
    }

    @Override
    public void save(Role role) {
        iRoleDao.save(role);
    }

    @Override
    public List<Permission> findOtherPermissions(Integer id) throws Exception {
        return iRoleDao.findOtherPermissions(id);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] permissionIds) {
        for(Integer permissionId : permissionIds){
            iRoleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
