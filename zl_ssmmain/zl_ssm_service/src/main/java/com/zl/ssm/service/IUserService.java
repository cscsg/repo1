package com.zl.ssm.service;

import com.zl.ssm.dao.Role;
import com.zl.ssm.dao.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {


    public List<Users> findAll()throws Exception;

    public void save(Users users)throws Exception;

    public Users findById(Integer userid)throws Exception;

    List<Role> findOtherRoles(Integer userid);

    List<Role> findRoles(Integer userid);

    void addRoleToUser(Integer userId, Integer[] roleIds);

    void deleteRoleToUser(Integer userId, Integer[] roleIds);
}
