package com.zl.ssm.service;

import com.zl.ssm.dao.Permission;

import java.util.List;

public interface IPermissionService {
    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    public List<Permission> findAll()throws Exception;

    void save(Permission permission);
}
