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
	public void createQuestionApertaTest() {
		
		Question question = new Question();
		question.setType("aperta");
		question.setQuestionText("ciao");
		question.setCorrectAnswerText("hola");
		question.setDifficulty(5);
		
		assertEquals(true, questionService.createQuestion(question).getResult());
	
	}
	
	@Test
	public void createQuestionVFTest() {
		
		Question question = new Question();
		question.setType("vf");
		question.setQuestionText("ciao1");
		question.setCorrectAnswerBoolean(true);
		question.setDifficulty(3);
		
		assertEquals(true, questionService.createQuestion(question).getResult());
	
	}
	
	@Test
	public void createQuestionCrocetteTest() {
		
		Question question = new Question();
		question.setType("crocette");
		question.setQuestionText("ciao2");
		question.setDifficulty(9);
		question.setCorrectAnswerText("hola2");
		question.setWrongAnswers("hola3;hola4;hola5");
		
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
