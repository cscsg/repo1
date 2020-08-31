package com.zl.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.zl.ssm.dao.ISysLogDao;
import com.zl.ssm.dao.SysLog;
import com.zl.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ISysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao iSysLogDao;
    @Override
    public List<SysLog> findAll(Integer page,Integer size) throws Exception {
        //参数pageNum是页码值,参数pageSize表示每页显示条数
        PageHelper.startPage(page,size);
        return iSysLogDao.findAll();
    }

    @Override
    public void save(SysLog sysLog) throws Exception {
        iSysLogDao.save(sysLog);
    }
}
