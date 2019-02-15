package com.negen.controller;

import com.alibaba.fastjson.JSONObject;
import com.negen.entity.Product;
import com.negen.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("product相关API")
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
    @ApiOperation(value = "添加商品信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productName", value = "商品名称", required = true, dataType = "string"),
            @ApiImplicitParam(name = "productBarCode", value = "商品条码", required = true, dataType = "string"),
            @ApiImplicitParam(name = "productPrice", value = "商品价格", required = true, dataType = "double"),
            @ApiImplicitParam(name = "productCount", value = "商品数量", required = true, dataType = "int")
    })
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
