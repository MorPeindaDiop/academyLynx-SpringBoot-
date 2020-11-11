package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dao.QuestionRepository;
import it.jac.lynx.dto.QuestionDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.Question;


@Service
public class QuestionService {

	private static Logger log = LoggerFactory.getLogger(QuestionService.class);

	@Autowired
	private QuestionRepository questionRepository;

	public Response<List<QuestionDTO>> findAllQuestions() {

		Response<List<QuestionDTO>> response = new Response<List<QuestionDTO>>();

		List<QuestionDTO> result = new ArrayList<>();

		try {

			Iterator<Question> iterator = this.questionRepository.findAll().iterator();

			while(iterator.hasNext()) {

				Question question = iterator.next();
				result.add(QuestionDTO.build(question));
			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<QuestionDTO> checkQuestionAnswerById(int id) {

		log.info("Trova question attraverso Id");

		Response<QuestionDTO> response = new Response<QuestionDTO>();

		Optional<Question> question = this.questionRepository.findById(id);


		try {

			if (question.isPresent()) {
				log.info("ricevuta richiesta check domanda");
				log.info("risposta data: "+question.get().getAnswer());
				log.info("risposta corretta: "+question.get().getCorrectAnswerText().toLowerCase());
				String correctAnswer=question.get().getCorrectAnswerText().toLowerCase();
				String candidateAnswer=question.get().getAnswer().toLowerCase();

				if(candidateAnswer.equals(correctAnswer)) { //controlla se nella risposta del candidato è contenuta la risposta corretta
					response.setResult(QuestionDTO.build(question.get()));
					response.setResultTest(true);
					question.get().setCorrectAnswerBoolean(true);
					
				}else {
					response.setError("risposta errata");
					response.setResultTest(false);
				}



			}

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<QuestionDTO> findQuestionById(int id) {

		log.info("Trova question attraverso Id");

		Response<QuestionDTO> response = new Response<QuestionDTO>();

		Optional<Question> question = this.questionRepository.findById(id);

		try {

			if (question.isPresent()) {

				response.setResult(QuestionDTO.build(question.get()));
				response.setResultTest(true);

			}

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
			response.setResultTest(true);

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
			response.setResultTest(true);

		} catch (Exception e ) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}



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

	public Response<QuestionDTO> updateQuestion(
			int id,
			String type,
			String questionText,
			String correctAnswerBoolean,
			String correctAnswerText,
			String wrongAnswers,
			int difficulty) {

		Response<QuestionDTO> response = new Response<QuestionDTO>();

		try {

			Question question = this.questionRepository.findById(id).get();

			if (type != null)
				question.setType(type);

			if (question != null)
				question.setQuestionText(questionText);

			if (correctAnswerBoolean != null)
				question.setCorrectAnswerBoolean(correctAnswerBoolean.equalsIgnoreCase("true") ? true : false);

			if (correctAnswerText != null)
				question.setCorrectAnswerText(correctAnswerText);

			if (wrongAnswers != null)
				question.setWrongAnswers(wrongAnswers);

			if (difficulty >=1 || difficulty <=10)
				question.setDifficulty(difficulty);

			this.questionRepository.save(question);

			response.setResult(QuestionDTO.build(question));
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Question non modificata.");

		}

		return response;

	}

	public Response<String> deleteQuestionById(int id) {

		Response<String> response = new Response<String>();

		try {

			this.questionRepository.deleteById(id);

			response.setResult("Question eliminata.");
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Question non eliminata correttamente.");

		}

		return response;

	}
}

