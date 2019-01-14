package com.lkreski.homedoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.lkreski.homedoc"})
public class HomedocApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomedocApplication.class, args);
	}

}

