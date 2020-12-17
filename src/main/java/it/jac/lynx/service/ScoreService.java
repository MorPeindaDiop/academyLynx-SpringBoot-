package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dao.CandidateRepository;
import it.jac.lynx.dto.CandidateAnswerDTO;
import it.jac.lynx.dto.CandidateDTO;
import it.jac.lynx.dto.CandidateResponseDTO;
import it.jac.lynx.dto.QuestionDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.Candidate;
import it.jac.lynx.entity.CandidateAnswer;
import jdk.internal.org.jline.utils.Log;

@Service
public class ScoreService {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private CandidateAnswerService candidateAnswerService;

	@Autowired
	private CandidateService candidateService;	
	
	@Autowired
	private CandidateRepository candidateRepository;

	
	private static Logger log = LoggerFactory.getLogger(ScoreService.class);
	
	public Response<Integer> setCandidateResponse(List<CandidateResponseDTO> candidateResponse){

		Response<Integer> response = new Response <Integer>();

		List<CandidateAnswerDTO> listaReturn= new ArrayList<CandidateAnswerDTO>();
		
		
		CandidateDTO cand=new CandidateDTO();
		
		try {

			for (CandidateResponseDTO candidateResponseDTO : candidateResponse) {
				
				CandidateAnswer ca = new CandidateAnswer();
				cand.setId(candidateService.findCandidateById(candidateResponseDTO.getIdCandidate()).getResult().getId());
				Candidate candidato=candidateRepository.findById(cand.getId()).get();
				QuestionDTO qDTO = questionService.findQuestionById(candidateResponseDTO.getIdQuestion()).getResult();
				ca.setIdCandidate(candidateResponseDTO.getIdCandidate());
				ca.setIdQuestion(qDTO.getId());
				ca.setIdTest(candidato.getIdTest());			
				ca.setAnswer(candidateResponseDTO.getCandidateResponse());
				
				
				switch (qDTO.getType()) {
				case "aperta":
					ca.setCorrect(candidateResponseDTO.getCandidateResponse().equalsIgnoreCase(qDTO.getCorrectAnswerText()) ? true : false);
					break;
				case "vf":
					Boolean answer = candidateResponseDTO.getCandidateResponse().equalsIgnoreCase("true") ? true : false;
					ca.setCorrect(answer);
					break;
				case "crocette":
					ca.setCorrect(candidateResponseDTO.getCandidateResponse().equalsIgnoreCase(qDTO.getCorrectAnswerText()) ? true : false);
					break;
				}

				candidateAnswerService.createCandidateAnswer(ca);
				listaReturn.add(CandidateAnswerDTO.build(ca));

			}
			log.info("ID CAND: \n\n\n\n"+cand.getId()+"\n\n\n\n");
			log.info("ID TEST: \n\n\n\n"+cand.getIdTest()+"\n\n\n\n");
			response.setResult(listaReturn.get(0).getIdCandidate());
			response.setResultTest(true);

		} catch (Exception e ) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<CandidateDTO> setScoreCandidate(int idCandidate) {

		Response<CandidateDTO> response = new Response <CandidateDTO>();

		List<CandidateAnswerDTO> candidateTest = new ArrayList<CandidateAnswerDTO>();

		double nCorrectAnswer = 0;

		double weightedScore = 0;

		double arithmeticScore = 0;

		double totalWeightedScoreTest = 0;

		try { 

			CandidateDTO candidate = candidateService.findCandidateById(idCandidate).getResult();

			candidateTest = candidateAnswerService.findCandidateAnswerByIdCandidate(idCandidate).getResult();

			for (CandidateAnswerDTO answer: candidateTest) {

				QuestionDTO question = questionService.findQuestionById(answer.getIdQuestion()).getResult();

				totalWeightedScoreTest += question.getDifficulty();

				if (answer.isCorrect()) {

					nCorrectAnswer += 1;

					weightedScore += question.getDifficulty();

				}

			}

			arithmeticScore =  (( nCorrectAnswer / (double) candidateTest.size() ) * 100);

			weightedScore =  (( weightedScore / totalWeightedScoreTest ) * 100);

			candidateService.setCandidateScoreAndTime(candidate.getId(), (int) nCorrectAnswer, (int) weightedScore, (int) arithmeticScore, 50);
			
			CandidateDTO candidate2 = candidateService.findCandidateById(idCandidate).getResult();
			
			response.setResult(candidate2);
			response.setResultTest(true);

		} catch (Exception e ) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

}
