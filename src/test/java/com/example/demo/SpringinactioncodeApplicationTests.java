package com.example.demo;

import com.example.demo.dao.RedisDaoImpl;
import com.example.demo.dao.SpitterDao;
import com.example.demo.model.Spitter;
import com.example.demo.model.User;
import com.example.demo.utils.FTPUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringinactioncodeApplicationTests {

	@Autowired
	ApplicationContext ac;

	@Autowired
	@Qualifier("stringRedisTemplate")
	RedisOperations redisOperations;
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
	@Test
	public void testRedis(){
		redisOperations.opsForValue().set("my_test_key","my_test_value");

	}
	@Test
	public void testRedis1(){
		if (redisOperations.hasKey("my_test_key")){
			String value = (String)redisOperations.opsForValue().get("my_test_key");
			System.out.println(value);
		}
	}
	@Test
	public void testRedisDao(){
		RedisDaoImpl redisDao = (RedisDaoImpl)ac.getBean("redisDaoImpl");
		String value = redisDao.add("my_test_key2","my_test_value2");
		System.out.println(value);
	}
	@Test
	public void testRedisList(){
		redisOperations.opsForList();
	}
	@Test
	public void test(){
		FTPUtils.connect();
		FTPUtils.login();
		List<String> filenames = FTPUtils.listFiles("");
		System.out.println(filenames.toArray());
	}
}
