package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@EnableSwagger2
public class HibernetMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernetMappingApplication.class, args);
	}

}
