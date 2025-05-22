package com.openclassrooms.helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.helloworld.service.BusinessService;

@SpringBootTest
class HelloworldApplicationTests {
	
	@Autowired
	private BusinessService bs;
	
	

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetHelloWorld() {
		
		String expected = "Hi world";
		String result = bs.getHelloWorld().getValue();
		
		assertEquals(expected , result);
	}

}
