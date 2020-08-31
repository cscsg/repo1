package com.zl.ssm.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many=@Many(select="com.zl.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public Users fingByUsername(String username);

    @Select("select * from users")
    public List<Users> findAll()throws Exception;

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(Users users)throws Exception;

    @Select("select * from users where id=#{userid}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property ="status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.zl.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    Users findById(Integer userid)throws Exception;

    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(Integer userId);

    @Select("select * from role where id  in (select roleId from users_role where userId=#{userId})")
    List<Role> findRoles(Integer userId);

    /**
     * 为用户添加角色
     * @param userId
     * @param roleId
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    /**
     * 为用户删除角色
     * @param userId
     * @param roleId
     */
    @Delete("delete from users_role where userid=#{userId} and roleId=#{roleId}")
    public void deleteRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
}
