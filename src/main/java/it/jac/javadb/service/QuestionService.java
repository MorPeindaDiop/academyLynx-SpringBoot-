package it.jac.javadb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import it.jac.javadb.dao.QuestionRepository;
import it.jac.javadb.dao.SeniorityRepository;
import it.jac.javadb.dao.UserActivityRepository;
import it.jac.javadb.dto.QuestionDTO;
import it.jac.javadb.dto.Response;
import it.jac.javadb.entity.Question;
import it.jac.javadb.entity.Seniority;
import it.jac.javadb.entity.UserActivity;

@Service
public class QuestionService {

	private static final Logger log = LogManager.getLogger(QuestionService.class);

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private UserActivityRepository userActivityRepository;

	public Response<List<QuestionDTO>> findAll() {

		log.info("Tutte le domande");

		Response<List<QuestionDTO>> response = new Response<List<QuestionDTO>>();

		List<QuestionDTO> result = new ArrayList<>();

		try {
			Iterator<Question> iterator = this.questionRepository.findAll().iterator();
			while(iterator.hasNext()) {

				Question question = iterator.next();
				result.add(QuestionDTO.build(question));
			}

			response.setResult(result);
		} catch (Exception e) {
			response.setError("Nessun elemento trovato.");
		}

		return response;
	}

	public Response<QuestionDTO> findQuestionById(Integer id) {

		log.info("Trova question attraverso Id");
		Response<QuestionDTO> response = new Response<QuestionDTO>();

		Optional<Question> question = this.questionRepository.findById(id);
		try {
			if (question.isPresent());
			response.setResult(QuestionDTO.build(question.get()));
		} catch (Exception e) {
			response.setError("Nessun elemento trovato.");
		}

		return response;
	}

	public Response<List<QuestionDTO>> findQuestionByDifficulty(int difficulty) {

		log.info("Tutte le domande tramite la difficoltà");

		Response<List<QuestionDTO>> response = new Response<List<QuestionDTO>>();

		List<QuestionDTO> result = new ArrayList<>();

		try {

			Iterator<Question> iterator = this.questionRepository.findByDifficulty(difficulty).iterator();
			while(iterator.hasNext()) {

				Question question = iterator.next();
				result.add(QuestionDTO.build(question));
			}

			response.setResult(result);

		} catch (Exception e ) {
			response.setError("Nessun elemento trovato.");
		}

		return response;
	}

	public Response<List<QuestionDTO>> findQuestionByType(String type) {

		log.info("Tutte le domande tramite il tipo");

		Response<List<QuestionDTO>> response = new Response<List<QuestionDTO>>();

		List<QuestionDTO> result = new ArrayList<>();

		try  {
			Iterator<Question> iterator = this.questionRepository.findByType(type).iterator();
			while(iterator.hasNext()) {
				Question question = iterator.next();
				result.add(QuestionDTO.build(question));
			}
			response.setResult(result);
		} catch (Exception e ) {
			response.setError("Nessun elemento trovato.");
		}

		return response;
	}



	@Transactional(propagation = Propagation.REQUIRED)
	public Response<Boolean> createQuestion(Question question) {

		Response<Boolean> response = new Response<Boolean>();
		
		try {
			this.questionRepository.save(question);
			response.setResult(true);
		} catch (Exception e) {
			response.setError("Nessun elemento trovato.");
		}

		return response;
	}

	public void updateQuestion(
			int id,
			String newType,
			String newQuestion,
			String newCorrectAnswerBoolean,
			String newCorrectAnswerText,
			List<String> newWrongAnswers,
			int newDifficulty) {

		Question question = this.questionRepository.findById(id).get();

		if (newType != null)
			question.setType(newType);

		if (question != null)
			question.setQuestion(newQuestion);

		if (newCorrectAnswerBoolean != null)
			question.setCorrectAnswerBoolean(newCorrectAnswerBoolean.equalsIgnoreCase("true") ? true : false);

		if (newCorrectAnswerText != null)
			question.setCorrectAnswerText(newCorrectAnswerText);

		if (newWrongAnswers.size() != 0)
			question.setWrongAnswers(newWrongAnswers);

		if (newDifficulty >=1 || newDifficulty <=10)
			question.setDifficulty(newDifficulty);

		this.questionRepository.save(question);

	}

	public void deleteQuestion(int id) {

		this.questionRepository.delete(this.questionRepository.findById(id).get());

	}

}
