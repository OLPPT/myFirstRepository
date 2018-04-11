package com.example.demo;

import com.example.demo.dao.SpitterDao;
import com.example.demo.model.Spitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringinactioncodeApplicationTests {

	@Autowired
	ApplicationContext ac;
	@Test
	public void contextLoads() {
		SpitterDao spitterDao = (SpitterDao) ac.getBean("spitterDaoImpl");
		Spitter spitter = new Spitter();
		spitter.setId(1);
		spitter.setUsername("test");
		spitter.setPassword("test");
		spitter.setFirstName("test");
		spitter.setLastName("test");
		spitter.setEmail("test");
		Spitter spitter1 = spitterDao.save(spitter);
		System.out.println(spitter1);
	}
	@Test
	public void testSelect(){
		SpitterDao spitterDao = (SpitterDao) ac.getBean("spitterDaoImpl");
		Spitter spitter = spitterDao.findById(1);
		System.out.println(spitter);
	}

}
