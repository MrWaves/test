package com.example.test.springMVC;

import com.example.test.springMVC.vo.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Package: com.example.test.springMVC
 * @Author: Mr.Waves
 * @Date: 2019/12/16 09:48
 * @Description:
 **/
@RestController
public class TestController {

    //基本数据类型数据绑定
    //http://localhost:8080/baseType?alias=30
    //@RequestParam用于参数的别名映射、是否必传和设默认值，不需要这些可以不用该注解
    @GetMapping("baseType")
    public String baseType(@RequestParam(name = "alias",defaultValue = "15") int age) {
        return "age："+age;
    }

    //包装类型数据绑定
    //http://localhost:8080/boxType?age=25
    @GetMapping("boxType")
    public String boxType(@RequestParam(defaultValue = "10") Integer age) {
        return "age："+age;
    }

    //数组数据绑定
    //http://localhost:8080/array?name=waves&name=lucy&name=jim
    @GetMapping("array")
    public String array(String[] name) {
        return Arrays.toString(name);
    }

    //简单对象数据绑定
    //http://localhost:8080/object?name=waves&age=12
    @GetMapping("object")
    public String object(UserVO userVO) {
        return userVO.toString();
    }

    //多层级对象数据绑定
    //http://localhost:8080/object2?name=avc&contactInfo.phoneNum=123456&contactInfo.address=上海市
    @GetMapping("object2")
    public String object2(UserVO2 userVO2) {
        return userVO2.toString();
    }

    //list数据绑定
    //http://localhost:8080/list?users[0].name=aa&users[1].name=bb
    //列表索引必须是连续的，否则会浪费后台资源
    @GetMapping("list")
    public String list(UserListVO userList) {
        return userList.toString();
    }

    //map数据绑定
    //http://localhost:8080/map?users['a'].name=aa&users['b'].name=bb
    @GetMapping("map")
    public String map(UserMapVO userMap) {
        return userMap.toString();
    }


    //json数据绑定
    //@RequestBody用于从request body中获取需要绑定的数据
//    {
//        "name":"Jack",
//        "age":15
//    }
    @GetMapping("json")
    public String json(@RequestBody UserVO user) {
        return user.toString();
    }

    //xml数据绑定
//    <admin>
//      <age>23</age>
//      <name>waaves</name>
//    </admin>
    @GetMapping("xml")
    public String xml(@RequestBody AdminVO admin) {
        return admin.toString();
    }

    //将前端传来的特定格式的日期字符串转化为Date类型的数据
    //借助PropertyEditor的子孙类，尤其是PropertyEditorSupport的子孙类进行转换
    @GetMapping("propertyEditor")
    public String date1(Date date1) {
        return date1.toString();
    }

    //@InitBinder通过参数对象名进行绑定
    @InitBinder("date1")
    public void initDate1(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),true));
    }

    //@DateTimeFormat(pattern='xxx') : 将传入的具有特定格式的日期字符串转换成Date对象
    //@JsonFormat(pattern='xxx',timezone='GMT+8') : 将Date对象转换成具有特定格式的日期字符串
    @GetMapping("date")
    public DateVO date(DateVO dateVO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateVO.getDate());  //Thu Dec 19 19:46:30 CST 2019
        System.out.println(sdf.format(dateVO.getDate()));  //2019-12-19 19:46:30

        DateVO result = new DateVO();
        result.setDate(new Date());
        return result;  //"date": "2019-12-16 19:54:32"
    }

    //TODO: 借助自定义Formatter或者Converter实现类进行全局类型转换

}
