package me.sjl.paser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Collection;

public class JSONToSQL {


    public static void main(String[] args) {
        String str = "(pojo.settleOffice !=pojo.actualSettleOffice && pojo.actualSettleOffice != null && pojo.rpFlag == 'P' && (!(pojo.supplierRole.contains( '海外代理(空运)')) && !(pojo.supplierRole.contains( '海外代理(空运)')) && !(pojo.supplierRole.contains( '海外代理（空运）')) && !(pojo.supplierRole.contains( '海外代理(海运)'))) && pojo.buOffice ==pojo.orderBuOffice)\t";
        String s = toUnderlineCase(str);
        System.out.println(s);

    }


    public static String toUnderlineCase(String camelCaseStr) {
        if (camelCaseStr == null) {
            return null;
        }
        // 将驼峰字符串转换成数组
        char[] charArray = camelCaseStr.toCharArray();
        StringBuffer buffer = new StringBuffer();
        //处理字符串
        for (int i = 0, l = charArray.length; i < l; i++) {
            if (charArray[i] >= 65 && charArray[i] <= 90) {
                buffer.append("_").append(charArray[i] += 32);
            } else {
                buffer.append(charArray[i]);
            }
        }
        return buffer.toString();
    }


}
