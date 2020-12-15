package it.jac.lynx.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.entity.TestQuestion;

@SpringBootTest
public class TestServiceTest {
	
	@Autowired
	private TestQuestionService testService;
	
	@Test
	public void createTest() {
		TestQuestion test=new TestQuestion();
		
		test.setIdTest(1);
		test.setIdCandidate(4);
		assertEquals(true, testService.createTestQuestion(test).isResultTest());
	}

}
