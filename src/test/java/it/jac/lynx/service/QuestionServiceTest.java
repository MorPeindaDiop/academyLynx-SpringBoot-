package it.jac.lynx.service;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.entity.Question;

@SpringBootTest
public class QuestionServiceTest {

	@Autowired
	private QuestionService questionService;
	
	@Test
	public void createQuestionTest() {
		
		Question question = new Question();
		question.setQuestionText("ciao");
		question.setCorrectAnswerText("hola");
		question.setType("aperta");
		
		assertEquals(true, questionService.createQuestion(question).getResult());
	
	}
	
	@Test 
	public void deleteQuestionByIdTest() {
	
		assertEquals("Skill eliminata.", questionService.deleteQuestionById(1).getResult());
		
	}
	
	@Test
	public void findAllQuestionsTest() {
		
		assertEquals(true, questionService.findAllQuestions().isResultTest());
		
	}
	
	@Test
	public void findQuestionByIdTest() {
		
		assertEquals(true, questionService.findQuestionById(2).isResultTest());
	
	}
	
	@Test
	public void updateQuestionTest() {
		
		assertEquals(true, questionService.updateQuestion(2, "nuova descrizione", null, null, null, null, 0).isResultTest());
	
	}
	
}
