package com.example.demo;


import com.example.demo.utils.FTPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication

@MapperScan(basePackages = "com.example.demo.mapper")
@ComponentScan(basePackages = {"com.example.demo","com.example.demo.utils"})
public class SpringinactioncodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringinactioncodeApplication.class, args);
	}
}
