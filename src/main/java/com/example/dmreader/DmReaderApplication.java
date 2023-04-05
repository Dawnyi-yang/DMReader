package com.example.dmreader;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.dmreader.mapper")
public class DmReaderApplication {

	public static void main(String[] args) {

		SpringApplication.run(DmReaderApplication.class, args);
	}

}
