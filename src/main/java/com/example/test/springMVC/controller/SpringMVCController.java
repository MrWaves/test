package com.example.test.springMVC.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.example.test.springMVC.model.RespondData;
import com.example.test.springMVC.model.param.*;
import com.example.test.springMVC.model.result.DateResult;
import com.example.test.springMVC.model.result.UserResult;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package: com.example.test.springMVC
 * @Author: Mr.Waves
 * @Date: 2019/12/16 09:48
 * @Description:
 **/
@RestController
public class SpringMVCController {

    /*
     * 基本数据类型数据绑定
     * http://localhost:8080/baseType?alias=30
     * @RequestParam 用于入参的别名映射、是否必传和设默认值，不需要这些可以不用该注解
     */
    @GetMapping("baseType")
    public RespondData baseType(@RequestParam(name = "alias", defaultValue = "15") int age) {
        return new RespondData(200, "操作成功！", age);
    }

    /*
     * 包装类数据绑定
     * http://localhost:8080/boxType?age=25
     */
    @GetMapping("boxType")
    public RespondData boxType(@RequestParam(defaultValue = "10") Integer age) {
        return new RespondData(200, "操作成功！", age);
    }

    /*
     * 数组数据绑定
     * http://localhost:8080/array?names=waves&names=lucy&names=jim
     */
    @GetMapping("array")
    public RespondData array(String[] names) {
        return new RespondData(200, "操作成功！", names);
    }

    /*
     * 简单领域模型数据绑定
     * http://localhost:8080/plain?name=waves&age=12
     */
    @GetMapping("plain")
    public RespondData plain(UserParam param) {
        UserResult result = new UserResult();
        BeanUtil.copyProperties(param, result, CopyOptions.create().ignoreError().ignoreNullValue());
        return new RespondData(200, "操作成功！", result);
    }

    /*
     * 嵌套领域模型数据绑定
     * http://localhost:8080/nested?name=Jack&contact.phone=123456&contact.address=上海市
     */
    @GetMapping("nested")
    public RespondData nested(NestedUserParam param) {
        return new RespondData(200, "操作成功！", param);
    }

    /*
     * list数据绑定
     * http://localhost:8080/list?list[0].name=aa&list[1].name=bb
     * 列表索引必须是连续的，否则会浪费后台资源
     */
    @GetMapping("list")
    public RespondData list(UserListParam param) {
        return new RespondData(200, "操作成功！", param);
    }

    /*
     * map数据绑定
     * http://localhost:8080/map?map['Jack'].name=Jack&map['Tom'].name=Tom
     */
    @GetMapping("map")
    public RespondData map(UserMapParam param) {
        return new RespondData(200, "操作成功！", param.getMap());
    }


    /*
     * 请求体(json)数据绑定
     * @RequestBody用于从request body中获取需要绑定的数据
     *
     * {
     *  "name":"Jack",
     *  "age":20
     * }
     */

    @GetMapping("json")
    public UserParam json(@RequestBody UserParam param) {
        return param;
    }

    /*
     * 请求体(xml)数据绑定
     *
     * <admin>
     *  <Age>23</Age>
     *  <Name>Jack</Name>
     * </admin>
     */
    @GetMapping("xml")
    public String xml(@RequestBody AdminParam param) {
        return param.toString();
    }

    /*
     * 借助@InitBinder进行日期格式转换
     */
    @GetMapping("binder")
    public String date1(Date date) {
        return String.format("%tF %<tT", date);
    }

    /*
     * @InitBinder通过入参名称进行绑定
     */
    @InitBinder("date")
    public void initDate(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    /*
     * 借助 @JsonFormat 将Date对象转换成具有特定格式的日期字符串
     */
    @GetMapping("date")
    public DateResult date2(DateParam dateParam) {
        DateResult dateResult = new DateResult();
        dateResult.setDate(dateParam.getDate());
        return dateResult;  //"date": "2019-12-16 19:54:32"
    }

    /*
     * @PathVariable : 从url中获取数据
     */
    @GetMapping(path = "subject/{id}")
    public String subject(@PathVariable("id") String id) {
        return "This is a get method , id: " + id;
    }

    //TODO: 借助自定义Formatter或者Converter实现类进行全局类型转换
    /*
     * 借助 ConverterFactory 将请求中的某种状态值反序列化成对应的枚举
     * 借助 @JSONField 将枚举序列化为toString()方法返回值
     */
    @GetMapping(path = "enumTest")
    public UserResult enumTest(UserParam param) {
        UserResult result = new UserResult();
        BeanUtil.copyProperties(param,result,CopyOptions.create().ignoreNullValue().ignoreError());
        return result;
    }
}
