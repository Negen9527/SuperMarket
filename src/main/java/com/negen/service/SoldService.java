package com.negen.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface SoldService {
    //获取所有的销售记录
    JSONArray listAllSold();
}
