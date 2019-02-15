package com.negen.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.negen.entity.Cigar;
import com.negen.entity.Product;
import com.negen.repository.CigarRepository;
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
public class CigarController {
    @Autowired
    CigarRepository cigarRepository;

    /**
     * 添加卷烟信息
     * @param jsonParam
     * @return
     */
    @ApiOperation(value = "添加卷烟信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cigarName", value = "卷烟名称", required = true, dataType = "string"),
            @ApiImplicitParam(name = "cigarBarCode", value = "卷烟条码", required = true, dataType = "string"),
            @ApiImplicitParam(name = "singleCigarPrice", value = "卷烟价格", required = true, dataType = "double"),
            @ApiImplicitParam(name = "cigarPrice", value = "卷烟数量", required = true, dataType = "double")
    })
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public JSONObject addCigar(@RequestBody JSONObject jsonParam){
        JSONObject resultJson = new JSONObject();
        resultJson.put("result","success");
        resultJson.put("status","1");
        try {
            //添加成功
            String cigarName = jsonParam.getString("cigarName");
            String cigarBarCode = jsonParam.getString("cigarBarCode");
            double singleCigarPrice = jsonParam.getDouble("singleCigarPrice");
            double cigarPrice = jsonParam.getInteger("cigarPrice");
            Cigar cigar = new Cigar();
            cigar.setCigarName(cigarName);
            cigar.setCigarBarCode(cigarBarCode);
            cigar.setSingleCigarPrice(singleCigarPrice);
            cigar.setCigarPrice(cigarPrice);
            cigarRepository.save(cigar);
        }catch (Exception e){
            //添加失败
            resultJson.put("result","error");
            resultJson.put("status","0");
        }
        return resultJson;
    }


    /**
     * 根据id删除卷烟
     * @param id
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public JSONObject deleteCigar(@RequestParam("id") String id){
        JSONObject resultJson = new JSONObject();
        resultJson.put("result","success");
        resultJson.put("status","1");
        try {
            //删除成功
            cigarRepository.deleteById(Long.parseLong(id));
        }catch (Exception e){
            //删除失败
            resultJson.put("status","0");
            resultJson.put("result","error");
        }
        return resultJson;
    }

    /**
     * 列出所有卷烟
     * @return
     */
    @RequestMapping(value = "allProduct")
    public JSONObject listAllCigar(){
        JSONObject resultJson = new JSONObject();
        resultJson.put("result","success");
        resultJson.put("status","1");
        try {
            JSONArray resultJsonArr = new JSONArray();
            List<Cigar> cigars = cigarRepository.findAll();
            if(null != cigars && 0 != cigars.size()){
                for (Cigar cigar:cigars) {
                    JSONObject productJson = new JSONObject();
                    productJson.put("cigarId", cigar.getId());
                    productJson.put("cigarName", cigar.getCigarName());
                    productJson.put("cigarBarCode", cigar.getCigarBarCode());
                    productJson.put("singleCigarPrice", cigar.getSingleCigarPrice());
                    productJson.put("cigarPrice", cigar.getCigarPrice());
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
