package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ElasticsearchTestApplicationTests {

	@Test
	void contextLoads() {
		
		int a = 100;
		int result = 0;
		
		for(int i=1; i<3; i++) {
			result = a >> i;
			result = result + 1;
		}
		
		System.out.println(result);
	}
	
	@Test
	public void test() {
		
		int a = 100;
		int result = 0;
		
		for(int i=1; i<3; i++) {
			result = a >> i;
			System.out.println("첫 result : " + result);
			result = result + 1;
			System.out.println("result+1 : " + result);
		}
		
		System.out.println(result);
		
	}

}
