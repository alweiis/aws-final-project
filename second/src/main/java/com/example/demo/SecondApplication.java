package com.example.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan
@ComponentScan(basePackages = {"upload", "spring.mybatis", "websocket", "board.spring.mybatis", "dbsecure"})
@MapperScan(basePackages = {"spring.mybatis", "board.spring.mybatis"})
public class SecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}

}
