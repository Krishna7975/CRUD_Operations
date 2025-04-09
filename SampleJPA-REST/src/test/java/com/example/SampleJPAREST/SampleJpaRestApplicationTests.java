package com.example.SampleJPAREST;

import com.example.SampleJPAREST.entities.Samples;
import com.example.SampleJPAREST.service.SampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleJpaRestApplicationTests {

	@Test
	void contextLoads() {
	}
    @Autowired
	private SampleService sampleService;

//	void testCase(){
//		sampleService.addBook(1,"abcs","truigntjgbnr",123);
//	}
}
