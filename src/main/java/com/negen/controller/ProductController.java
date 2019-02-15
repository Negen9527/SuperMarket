package com.negen.controller;

import com.alibaba.fastjson.JSONObject;
import com.negen.entity.Product;
import com.negen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    /**
     * 添加商品信息
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public JSONObject addProduct(@RequestBody JSONObject jsonParam){
        JSONObject resultJson = new JSONObject();
        resultJson.put("result","success");
        resultJson.put("status","1");
        try {
            String productName = jsonParam.getString("productName");
            String productBarCode = jsonParam.getString("productBarCode");
            double productPrice = jsonParam.getDouble("productPrice");
            int productCount = jsonParam.getInteger("productCount");
            Product product = new Product();
            product.setProductName(productName);
            product.setProductBarCode(productBarCode);
            product.setProductPrice(productPrice);
            product.setProductCount(productCount);
            productRepository.save(product);

        }catch (Exception e){
            resultJson.put("result","error");
            resultJson.put("status","0");
        }
        return resultJson;
    }
}
