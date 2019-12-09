package com.example.test.network;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.Charset;
import java.util.*;
/**
  *@Author: Mr.Waves
  *@Date: 2019/12/9 11:30
  *@Package: com.example.test.network
  *@Description: RestTemplate测试
  **/
public class RestTemplateTest {
    public static void main(String[] args) {
        test1();
    }

    //getForEntity
    private static void test1(){
        Map<String, Object> map = new HashMap<>();
        String startdt = String.format("%tF",new Date(118,2,7));
        String enddt=String.format("%tF",new Date(118,2,7));;
        int page=1;
        int size=1000;
        map.put("startdt",startdt);
        map.put("enddt",enddt);
        map.put("page",page);
        map.put("size",size);

        String url="http://192.168.119.84:8084/track/getTenantOutList?startdt={startdt}&enddt={enddt}&page={page}&size={size}";
        RestTemplate restTemplate=new RestTemplate(Arrays.asList(new StringHttpMessageConverter(Charset.forName("UTF-8"))));
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class,map );

        JSONObject responseBody=new JSONObject(responseEntity.getBody());
        JSONObject result = responseBody.getJSONObject("result");
        JSONArray items=result.getJSONArray("item");

        for (int i=0;i<items.length();i++){
            JSONObject jsonObject = items.getJSONObject(i);
            System.out.println(jsonObject);
        }
    }
}
