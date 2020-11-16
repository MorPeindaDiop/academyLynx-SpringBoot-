package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dto.CandidateAnswerDTO;
import it.jac.lynx.dto.CandidateDTO;
import it.jac.lynx.dto.CandidateResponseDTO;
import it.jac.lynx.dto.QuestionDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.CandidateAnswer;

@Service
public class ScoreService {
	private static Logger log = LoggerFactory.getLogger(ScoreService.class);

	@Autowired
	private QuestionService questionService;

	@Autowired
	private CandidateAnswerService candidateAnswerService;

	@Autowired
	private CandidateService candidateService;	

	public Response<List<CandidateAnswerDTO>> setCandidateResponse(List<CandidateResponseDTO> lista, int idCandidate){

		Response<List<CandidateAnswerDTO>> response = new Response <List<CandidateAnswerDTO>>();

		List<CandidateAnswerDTO> listaReturn= new ArrayList<CandidateAnswerDTO>();

		try {

			for (CandidateResponseDTO candidateResponseDTO : lista) {

				CandidateAnswer ca = new CandidateAnswer();
				QuestionDTO qDTO=questionService.findQuestionById(candidateResponseDTO.getIdQuestion()).getResult();
				ca.setIdCandidate(idCandidate);
				ca.setIdQuestion(qDTO.getId());

				switch (qDTO.getType()) {
				case "aperta":
					ca.setAnswer(candidateResponseDTO.getCandidateResponse().equalsIgnoreCase(qDTO.getCorrectAnswerText()) ? true : false);
					break;
				case "vf":
					Boolean answer = candidateResponseDTO.getCandidateResponse().equalsIgnoreCase("true") ? true : false;
					ca.setAnswer(answer ? true : false);
					break;
				case "crocette":
					ca.setAnswer(candidateResponseDTO.getCandidateResponse().equalsIgnoreCase(qDTO.getCorrectAnswerText()) ? true : false);
					break;
				}

				candidateAnswerService.createCandidateAnswer(ca);
				listaReturn.add(CandidateAnswerDTO.build(ca));

			}

			response.setResult(listaReturn);
			response.setResultTest(true);

		} catch (Exception e ) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<CandidateDTO> setScoreCandidate(int idCandidate) {
		log.info("entra nel metodo");

		Response<CandidateDTO> response = new Response <CandidateDTO>();

		List<CandidateAnswerDTO> candidateTest = new ArrayList<CandidateAnswerDTO>();

		int nCorrectAnswer = 0;

		int weightedScore = 0;

		int arithmeticScore = 0;

		int totalWeightedScoreTest = 0;

		try {
			log.info("entra nel try");
			CandidateDTO candidate = candidateService.findCandidateById(idCandidate).getResult();

			candidateTest = candidateAnswerService.findCandidateAnswerByIdCandidate(idCandidate).getResult();

			for (CandidateAnswerDTO answer: candidateTest) {

				QuestionDTO question = questionService.findQuestionById(answer.getIdQuestion()).getResult();

				totalWeightedScoreTest += question.getDifficulty();

				if (answer.isAnswer()) {

					nCorrectAnswer += 1;

					weightedScore += question.getDifficulty();

				}

			}

			arithmeticScore = (int) (( nCorrectAnswer / candidateTest.size() ) * 100);
			log.info("entra nel arithmetic score");
			weightedScore = (int) (( weightedScore / totalWeightedScoreTest ) * 100);
			log.info("entra nel weightedScore");
			
			
			candidateService.setCandidateScoreAndTime(candidate.getId(), nCorrectAnswer,  weightedScore,  arithmeticScore, 50);
			
			
			log.info("setta nel candidateService");
			response.setResult(candidate);
			log.info("setta result(candidate)");
			response.setResultTest(true);
			log.info("setta a true");

		} catch (Exception e ) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

}
