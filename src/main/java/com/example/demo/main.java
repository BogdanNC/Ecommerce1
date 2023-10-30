package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class main {

	//private static Login instance = new Login();

	public static void main(String[] args) {
		SpringApplication.run(main.class, args);
		//instance.showAllUsers();
	}

}
