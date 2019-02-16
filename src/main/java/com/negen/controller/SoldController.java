package com.negen.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.negen.entity.Sold;
import com.negen.repository.SoldRepository;
import com.negen.utils.Arr2StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

@RequestMapping(value = "sold")
public class SoldController {
    @Autowired
    SoldRepository soldRepository;
    /**
     * 添加销售记录
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "add")
    public JSONObject addSold(@RequestBody JSONObject jsonParam){
        JSONObject resultJson = new JSONObject();
        resultJson.put("result","success");
        resultJson.put("status","1");
        try {
            JSONArray soldProductBars = jsonParam.getJSONArray("soldProductBars");
            JSONArray soldProductCount = jsonParam.getJSONArray("soldProductCount");
            JSONArray soldProductName = jsonParam.getJSONArray("soldProductName");
            double soldTotalMoney = jsonParam.getDouble("soldTotalMoney");
            String soldProductBarsStr = Arr2StrUtil.arr2Str(soldProductBars, ",");
            String soldProductCountStr = Arr2StrUtil.arr2Str(soldProductCount, ",");
            String soldProductNameStr = Arr2StrUtil.arr2Str(soldProductName, ",");

            Sold sold = new Sold();
            sold.setSoldTime(new Timestamp(System.currentTimeMillis()));
            sold.setSoldProductBars(soldProductBarsStr);
            sold.setSoldProductCount(soldProductCountStr);
            sold.setSoldProductName(soldProductNameStr);
            sold.setSoldTotalMoney(soldTotalMoney);
            soldRepository.save(sold);
        }catch (Exception e){
            //添加失败
            resultJson.put("result","error");
            resultJson.put("status","0");
        }
        return resultJson;
    }


    /**
     * 所有销售记录
     * @return
     */
    public JSONObject listAllSold(){
        List<Sold> solds = soldRepository.findAll();

        return null;
    }

}
