package com.noteworthy.noteworthybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories("com.noteworthy.noteworthybackend.repository")
@EntityScan("com.noteworthy.noteworthybackend.entity")
public class NoteworthyBackendApplication {

	public static void main(String[] args) {

		System.out.println("Project is deployed at: "+ new Date());
		SpringApplication.run(NoteworthyBackendApplication.class, args);
	}

}
