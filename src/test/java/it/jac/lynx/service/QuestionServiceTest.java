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
<<<<<<< HEAD
		question.setQuestionText("ti piace la nutella?");
=======
		question.setQuestionText("ciao");
		question.setCorrectAnswerText("hola");
>>>>>>> branch 'campiDinamici' of https://github.com/MorPeindaDiop/academyLynxSpringBoot
		question.setType("aperta");
		question.setAnswer("si");
		question.setCorrectAnswerText("si");
		
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
	
//	@Test
//	public void checkAnswerQuestionByIdTest() {
//		
//		assertEquals(true, questionService.checkQuestionAnswerById(7).isResultTest());
//	
//	}
	
}
