package com.openclassrooms.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.helloworld.model.HelloWorld;
import com.openclassrooms.helloworld.service.BusinessService;

@SpringBootApplication
public class HelloworldApplication implements CommandLineRunner {
	
	@Autowired
	private BusinessService bs;

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		HelloWorld hw = bs.getHelloWorld();
		System.out.println(hw);
		
	}

}
