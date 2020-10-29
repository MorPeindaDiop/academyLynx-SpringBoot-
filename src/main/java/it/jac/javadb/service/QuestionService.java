package it.jac.javadb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import it.jac.javadb.dao.QuestionRepository;
import it.jac.javadb.dao.SeniorityRepository;
import it.jac.javadb.dao.UserActivityRepository;
import it.jac.javadb.dto.QuestionDTO;
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

	public List<QuestionDTO> findAll() {

		log.info("Tutte le domande");
		List<QuestionDTO> result = new ArrayList<>();

		Iterator<Question> iterator = this.questionRepository.findAll().iterator();
		while(iterator.hasNext()) {

			Question question = iterator.next();
			result.add(QuestionDTO.build(question));
		}

		return result;
	}

	public QuestionDTO findQuestionById(Integer id) {

		log.info("Trova question attraverso Id");
		Optional<Question> question = this.questionRepository.findById(id);
		if (question.isPresent())
			return QuestionDTO.build(question.get());
		
		return 
	}

	public List<QuestionDTO> findQuestionByDifficulty(int difficulty) {

		log.info("Tutte le domande tramite la difficoltà");
		List<QuestionDTO> result = new ArrayList<>();

		Iterator<Question> iterator = this.questionRepository.findByDifficulty(difficulty).iterator();
		while(iterator.hasNext()) {

			Question question = iterator.next();
			result.add(QuestionDTO.build(question));
		}

		return result;
	}

	public List<QuestionDTO> findQuestionByType(String type) {

		log.info("Tutte le domande tramite il tipo");
		List<QuestionDTO> result = new ArrayList<>();

		Iterator<Question> iterator = this.questionRepository.findByType(type).iterator();
		while(iterator.hasNext()) {

			Question question = iterator.next();
			result.add(QuestionDTO.build(question));
		}

		return result;
	}



	@Transactional(propagation = Propagation.REQUIRED)
	public void createQuestion(Question question) {

		this.questionRepository.save(question);

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
