package com.zl.ssm.controller;


import com.zl.ssm.dao.Product;
import com.zl.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private IProductService iProductService;

    @RequestMapping("/updateById.do")
    public String updateById(Product product) throws Exception {
        iProductService.updateById(product.getProductNum(),product.getProductName(),product.getCityName(),product.getDepartureTime(),product.getProductPrice(),product.getProductDesc(),product.getProductStatus(),product.getId());
        return "redirect:findAll.do";
    }

    @RequestMapping("/take.do")
    public ModelAndView take(Integer id) throws Exception {
        ModelAndView mv=new ModelAndView();
        Product product = iProductService.findById(id);
        mv.addObject("product",product);
        mv.setViewName("product-update");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        System.out.println(product);
        iProductService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id) throws Exception {
        ModelAndView mv=new ModelAndView();
        Product product=iProductService.findById(id);
        mv.addObject("productList",product);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Product>  ps = iProductService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        return mv;
    }
}
