package com.example.test;

import com.example.test.java.StuDao;
import com.example.test.java.StuDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	private StuDao stuDao;

	@Test
	public void contextLoads() throws ParseException {
		StuDTO stu = new StuDTO("wangwu");
		stuDao.insert(stu);
		System.out.println(stu.getId());
	}

}