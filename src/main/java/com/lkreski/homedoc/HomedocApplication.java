package com.lkreski.homedoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.lkreski.homedoc", "com.lkreski.homedoc.model", "com.lkreski.homedoc.dao","com.lkreski.homedoc.service"
})
public class HomedocApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomedocApplication.class, args);
	}

}

