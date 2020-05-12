import com.example.test.springMVC.constant.enums.Gender;
import com.example.test.springMVC.model.param.UserParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Package: PACKAGE_NAME
 * @Author: Mr.Waves
 * @Date: 2020-04-20 10:43
 * @Description: SpringMVC集成测试
 **/
public class SpringMVCMockTest extends BaseJunit{

    @Test
    public void baseTypeTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/baseType")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("alias", "30"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data").value(30))
            .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void boxTypeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/boxType")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("age", "15"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(15))
                .andReturn();
    }

    @Test
    public void arrayTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/array")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("names", "Jack","Tome","Lucy"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0]").value("Jack"))
                .andReturn();
    }

    @Test
    public void plainTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/plain")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("age", "20")
                .param("name","Jack")
                .param("createTime","2020-04-22 13:30:00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value("Jack"))
                .andReturn();
    }

    @Test
    public void nestedTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/nested")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("age", "20")
                .param("name","Jack")
                .param("createTime","2020-04-22 13:30:00")
                .param("contact.phone","15000000000")
                .param("contact.address","上海市"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.contact.phone").value("15000000000"))
                .andReturn();
    }

    @Test
    public void listTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/list")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("list[0].name", "Jack")
                .param("list[0].age", "20")
                .param("list[1].name", "Tom")
                .param("list[1].age", "15"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list[0].name").value("Jack"))
                .andReturn();
    }

    @Test
    public void mapTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/map")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("map['Jack'].name", "Jack")
                .param("map['Jack'].age", "20")
                .param("map['Tom'].name", "Tom")
                .param("map['Tom'].age", "15"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data['Jack'].name").value("Jack"))
                .andReturn();
    }

    @Test
    public void date1Test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/binder")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("date", "2020-04-20 15:30:00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("2020-04-20 15:30:00"))
                .andReturn();
    }

    @Test
    public void date2Test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/date")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("date", "2020-04-20 15:30:00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.date").value("2020-04-20 15:30:00"))
                .andReturn();
    }

    @Test
    public void jsonTest() throws Exception {
        UserParam param = new UserParam();
        param.setAge(20);
        param.setName("Jack");

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String content = writer.writeValueAsString(param);

        mockMvc.perform(MockMvcRequestBuilders.get("/json")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.age").value("20"));
    }

    @Test
    public void enumTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/enumTest")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("gender","1")
                .param("name","Jack")
                .param("age","20"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gender").value("boy"));
    }

}
