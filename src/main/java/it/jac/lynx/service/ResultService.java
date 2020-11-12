package it.jac.lynx.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.jac.lynx.pk.PkCandidateAnswer;
import it.jac.lynx.dao.CandidateAnswerRepository;
import it.jac.lynx.dao.CandidateRepository;
import it.jac.lynx.dao.QuestionRepository;
import it.jac.lynx.dto.QuestionDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.CandidateAnswer;
import it.jac.lynx.entity.Question;

@Service
public class ResultService {
	
	private static Logger log = LoggerFactory.getLogger(ResultService.class);

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private CandidateAnswerRepository candidateAnswerRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	
	
	
	public Response<QuestionDTO> checkQuestionAnswerById(int idQuestion, PkCandidateAnswer pk) {

		log.info("controlla se la risposta alla question è giusta attraverso Id");

		Response<QuestionDTO> response = new Response<QuestionDTO>();

		Optional<Question> question = this.questionRepository.findById(idQuestion);
		Optional<CandidateAnswer> answer = this.candidateAnswerRepository.findById(pk);
		


		try {

			if (question.isPresent()) {
				log.info("ricevuta richiesta check domanda");
				log.info("risposta data: "+question.get().getAnswer());
				log.info("risposta corretta: "+question.get().getCorrectAnswerText().toLowerCase());
				String correctAnswer=question.get().getCorrectAnswerText().toLowerCase();
				String candidateAnswer=question.get().getAnswer().toLowerCase();

				if(candidateAnswer.equals(correctAnswer)) { //controlla se nella risposta del candidato è contenuta la risposta corretta					
					response.setResultTest(true);
					question.get().setCorrectAnswerBoolean("true");
					response.setResult(QuestionDTO.build(question.get()));
				}else {
					response.setError("risposta errata");
					response.setResultTest(false);
					question.get().setCorrectAnswerBoolean("false");
					response.setResult(QuestionDTO.build(question.get()));
				}
			}

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	
	
	
}
