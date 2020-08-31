package com.zl.ssm.service.impl;

import com.zl.ssm.dao.IProductDao;
import com.zl.ssm.dao.Product;
import com.zl.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    /**
     * 根据id查询产品
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Product findById(Integer id) throws Exception {
        Product byId = iProductDao.findById(id);
        return byId;
    }

    /**
     * 查询操作
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findAll() throws Exception{
        return iProductDao.findAll();
    }

    /**
     * 保存操作
     * @param product 产品
     * @throws Exception
     */
    @Override
    public void save(Product product)throws Exception {
        iProductDao.save(product);
    }

    /**
     * 更新操作
     * @param  产品
     * @throws Exception
     */
    @Override
    public void updateById(String proudctNum, String productName, String cityName, Date departureTime, Double productPrice, String productDesc, Integer productStatus,Integer id)throws Exception {
        iProductDao.updateById(proudctNum,productName,cityName,departureTime,productPrice,productDesc,productStatus,id);
    }
}
