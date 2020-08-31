package com.zl.ssm.dao;

import org.apache.ibatis.annotations.Select;

public interface IMemberDao {


    @Select("select * from member where id=#{id}")
    public Member findById(Integer id);
}
