package com.zl.ssm.service.impl;

import com.zl.ssm.dao.IUserDao;
import com.zl.ssm.dao.Role;
import com.zl.ssm.dao.Users;
import com.zl.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("iUserService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        Users users= null;
        try {
            users = iUserDao.fingByUsername(username);
            System.out.println("======================================================================");
            System.out.println(users.getUsername()+users.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
          User user=new User(users.getUsername(),users.getPassword(),getAuthority(users.getRoles()));
        return user;
    }
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> authoritys = new ArrayList<>();
        for(Role role : roles) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authoritys;
    }


    @Override
    public List<Users> findAll() throws Exception{
        return iUserDao.findAll();
    }

    @Override
    public void save(Users users) throws Exception {
        //对密码进行加密
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        iUserDao.save(users);
    }

    @Override
    public Users findById(Integer userid) throws Exception {
        return iUserDao.findById(userid);
    }

    @Override
    public List<Role> findOtherRoles(Integer userid) {
        return iUserDao.findOtherRoles(userid);
    }

    @Override
    public List<Role> findRoles(Integer userid) {
        return iUserDao.findRoles(userid);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] roleIds) {
        for(Integer roleId : roleIds){
            iUserDao.addRoleToUser(userId,roleId);
        }
    }

    @Override
    public void deleteRoleToUser(Integer userId, Integer[] roleIds) {
        for(Integer roleId : roleIds){
            iUserDao.deleteRoleToUser(userId,roleId);
        }
    }
}
