package it.jac.lynx.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.QuestionDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.Question;
import it.jac.lynx.service.QuestionService;

@RestController
@RequestMapping("/rest/question")
public class QuestionRestController {
	
	private static Logger log = LoggerFactory.getLogger(QuestionRestController.class);
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping(path = "/findAll")
	public Response<?> findAllQuestions() {

		log.info("Ricevuta richiesta della lista di tutti i prodotti");
		
		return questionService.findAllQuestions();
		
	}
	
	@PostMapping("/create")
	public Response<?> createQuestion(
			@RequestParam String type,
			@RequestParam String questionText,
			@RequestParam (required = false) String correctAnswerBoolean,
			@RequestParam (required = false) String correctAnswerText,
			@RequestParam (required = false) String wrongAnswers,
			@RequestParam int difficulty) {
		
		log.info("Ricevuta richiesta di creazione nuovo prodotto");
		
		Question question = new Question();
		question.setType(type);
		question.setDifficulty(difficulty);
		question.setQuestionText(questionText);
		question.setCorrectAnswerBoolean(correctAnswerBoolean.equalsIgnoreCase("true") ? true : false);
		question.setCorrectAnswerText(correctAnswerText);
		question.setWrongAnswers(wrongAnswers);
		
		return questionService.createQuestion(question);
		
	}

	@GetMapping(path = "/detail/{id}")
	public Response<?> detail(@PathVariable(name = "id") int id) {
		
		log.info("Ricevuta richiesta di dettaglio di un prodotto");
		
		return questionService.findQuestionById(id);
		
	}

	@PutMapping(path = "/update/{id}")
	public Response<?> update(
			@PathVariable(name = "id") int id,
			@RequestParam (required = false) String type,
			@RequestParam (required = false) String questionText,
			@RequestParam (required = false) String correctAnswerBoolean,
			@RequestParam (required = false) String correctAnswerText,
			@RequestParam (required = false) String wrongAnswers,
			@RequestParam (required = false) int difficulty) {

		return questionService.updateQuestion(id, type, questionText, correctAnswerBoolean, correctAnswerText, wrongAnswers, difficulty);
	
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public Response<?> delete(@PathVariable(name = "id") Integer id) {

		log.info("Ricevuta richiesta di eliminazione di un prodotto");

		return questionService.deleteQuestionById(id);
		
	}
	
}
