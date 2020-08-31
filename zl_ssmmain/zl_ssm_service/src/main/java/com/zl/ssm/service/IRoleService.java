package com.zl.ssm.service;

import com.zl.ssm.dao.Permission;
import com.zl.ssm.dao.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll()throws Exception;

    public Role findById(Integer id)throws Exception;

    void save(Role role);

    List<Permission> findOtherPermissions(Integer id)throws Exception;

    void addPermissionToRole(Integer roleId, Integer[] permissionIds);
}
