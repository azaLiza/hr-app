package com.openclassrooms.webapp;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.webapp.repository.CustomProperties;

import lombok.Data;

@Data
@SpringBootApplication
//@RestController
public class WebappApplication /*implements CommandLineRunner */ {

    @Autowired
    private CustomProperties properties;
    
  /*   @RequestMapping("/")
	public String home() {
		return "Hello Docker !";
	} */

    public static void main(String[] args) {
        SpringApplication.run(WebappApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(( properties).getApiUrl());
//    }

}