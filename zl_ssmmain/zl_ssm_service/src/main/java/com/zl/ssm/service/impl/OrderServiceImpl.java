package com.zl.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.zl.ssm.dao.IOrderDao;
import com.zl.ssm.dao.Orders;
import com.zl.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao iOrderDao;


    @Override
    public List<Orders> findAll(Integer page,Integer size) throws Exception{
        //参数pageNum是页码值,参数pageSize表示每页显示条数
        PageHelper.startPage(page,size);
        return iOrderDao.findAll();
    }

    @Override
    public Orders findById(Integer id) throws Exception {
        return iOrderDao.findById(id);
    }
}
