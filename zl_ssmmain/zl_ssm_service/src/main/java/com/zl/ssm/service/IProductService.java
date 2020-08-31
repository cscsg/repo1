package com.zl.ssm.service;

import com.zl.ssm.dao.Product;

import java.util.Date;
import java.util.List;

public interface IProductService {

    public Product findById(Integer id) throws Exception;

    public List<Product> findAll() throws Exception;

    void save(Product product)throws Exception;

    void updateById(String proudctNum, String productName, String cityName, Date departureTime,Double productPrice,String productDesc,Integer productStatus,Integer id)throws Exception;
}
