package com.negen.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.negen.entity.Sold;
import com.negen.repository.SoldRepository;
import com.negen.service.SoldService;
import com.negen.utils.Arr2StrUtil;
import com.negen.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

public class SoldServiceImpl implements SoldService {
    @Autowired
    SoldRepository soldRepository;

    @Override
    public JSONArray listAllSold() {
        JSONArray resultJson = new JSONArray();
        List<Sold> solds = soldRepository.findAll();
        for (Sold sold:solds){
            JSONObject soldJson = new JSONObject();
            Long id = sold.getId();
            String soldProductBars = sold.getSoldProductBars();
            String soldSoldProductName = sold.getSoldProductName();
            String soldSoldProductPrice = sold.getSoldProductPrice();
            String soldProductCount = sold.getSoldProductCount();
            double soldTotalMoney = sold.getSoldTotalMoney();
            Timestamp soldTime = sold.getSoldTime();

            String timeStr = DateUtil.timestamp2Str(soldTime);
            String[] soldProductBarsArr = Arr2StrUtil.str2Arr(soldProductBars, ",");
            String[] soldProductNameArr = Arr2StrUtil.str2Arr(soldSoldProductName, ",");
            String[] soldProductPriceArr = Arr2StrUtil.str2Arr(soldSoldProductPrice, ",");
            String[] soldProductCountArr = Arr2StrUtil.str2Arr(soldProductCount, ",");
            JSONArray allSoldProductDataJsonArr = new JSONArray();
            for (int i=0; i<soldProductBarsArr.length; i++){
                JSONObject productDetailJson = new JSONObject();
                productDetailJson.put("productBarCode", soldProductBarsArr[i]);
                productDetailJson.put("productBarName", soldProductNameArr[i]);
                productDetailJson.put("productBarPrice", soldProductPriceArr[i]);
                productDetailJson.put("productBarCount", soldProductCountArr[i]);
                productDetailJson.put("productTotal",
                        Integer.parseInt(soldProductCountArr[i])*Double.parseDouble(soldProductPriceArr[i]));
                allSoldProductDataJsonArr.add(productDetailJson);
            }

            soldJson.put("id", id);
            soldJson.put("soldTime", soldTime);
            soldJson.put("productNameStr", soldSoldProductName);
            soldJson.put("totalMoney", soldTotalMoney);
            soldJson.put("allProductData", allSoldProductDataJsonArr);
            resultJson.add(soldJson);
        }
        return resultJson;
    }
}
