package com.negen.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.negen.entity.Sold;
import com.negen.repository.SoldRepository;
import com.negen.service.SoldService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SoldServiceImpl implements SoldService {
    @Autowired
    SoldRepository soldRepository;

    @Override
    public JSONObject listAllSold() {
        JSONObject resultJson = new JSONObject();
        List<Sold> solds = soldRepository.findAll();
        for (Sold sold:solds){

        }
        return null;
    }
}
