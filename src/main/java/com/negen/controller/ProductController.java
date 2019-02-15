package com.negen.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.negen.entity.Product;
import com.negen.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            //添加成功
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
            //添加失败
            resultJson.put("result","error");
            resultJson.put("status","0");
        }
        return resultJson;
    }


    /**
     * 根据id删除商品
     * @param id
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public JSONObject deleteProduct(@RequestParam("id") String id){
        JSONObject resultJson = new JSONObject();
        resultJson.put("result","success");
        resultJson.put("status","1");
        try {
            //删除成功
            productRepository.deleteById(Long.parseLong(id));
        }catch (Exception e){
            //删除失败
            resultJson.put("result","error");
            resultJson.put("status","0");
        }
        return resultJson;
    }

    /**
     * 列出所有商品
     * @return
     */
    @RequestMapping(value = "allProduct")
    public JSONObject listAllProduct(){
        JSONObject resultJson = new JSONObject();
        resultJson.put("result","success");
        resultJson.put("status","1");
        try {
            JSONArray resultJsonArr = new JSONArray();
            List<Product> products = productRepository.findAll();
            if(null != products && 0 != products.size()){
                for (Product product:products) {
                    JSONObject productJson = new JSONObject();
                    productJson.put("productId", product.getId());
                    productJson.put("productName", product.getProductName());
                    productJson.put("productBarCode", product.getProductBarCode());
                    productJson.put("productPrice", product.getProductPrice());
                    productJson.put("productCount", product.getProductCount());
                    resultJsonArr.add(productJson);
                }
            }
            resultJson.put("data", resultJsonArr);
        }catch (Exception e){
            resultJson.put("result","error");
            resultJson.put("status","0");
            resultJson.put("data",new JSONArray());
        }
        return resultJson;
    }

}
