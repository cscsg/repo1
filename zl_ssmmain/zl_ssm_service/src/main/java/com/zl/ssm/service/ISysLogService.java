package com.zl.ssm.service;

import com.zl.ssm.dao.SysLog;

import java.util.List;

public interface ISysLogService {

    public List<SysLog> findAll(Integer page,Integer size)throws Exception;

    public void save(SysLog sysLog)throws Exception;
}
