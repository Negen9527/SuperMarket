package com.negen.utils;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组，字符串相互转换
 */
public class Arr2StrUtil {

    /**
     * 数组元素以字符分割拼接成字符串
     * @param srcArr        待拼接数组
     * @param separator     分隔符
     * @return
     */
    public static String arr2Str(List<Object> srcArr, String separator){
        String resultStr = "";
        for (Object obj : srcArr){
            resultStr += obj.toString() + separator;
        }
        resultStr = resultStr.substring(0, (resultStr.length() - 1));
        return resultStr;
    }


    /**
     * 分割字符串为字符数组
     * @param srcStr
     * @param separator
     * @return
     */
    public static String[] str2Arr(String srcStr, String separator){
        return srcStr.split(separator);
    }
}
