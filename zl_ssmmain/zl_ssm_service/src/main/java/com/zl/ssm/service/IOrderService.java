package com.zl.ssm.service;

import com.zl.ssm.dao.Orders;

import java.util.List;

public interface IOrderService {

    public List<Orders> findAll(Integer page,Integer size)throws Exception;

    Orders findById(Integer id)throws Exception;
}
