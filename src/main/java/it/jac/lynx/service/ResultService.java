package it.jac.lynx.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.jac.lynx.dto.CandidateAnswerDTO;
import it.jac.lynx.dto.CandidateResponseDTO;
import it.jac.lynx.dto.QuestionDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.dto.ResultDTO;
import it.jac.lynx.entity.CandidateAnswer;


@Service
public class ResultService {
	
	private static Logger log = LoggerFactory.getLogger(ResultService.class);

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private CandidateAnswerService candidateAnswerService;
	
	@Autowired
	private CandidateService candidateService;
	
	
	
	
	public Response<List<CandidateAnswerDTO>> setCandidateResponse(List<CandidateResponseDTO> lista){
		
		Response<List<CandidateAnswerDTO>> response = new Response <List<CandidateAnswerDTO>>();
		
		List<CandidateAnswerDTO> listaReturn= new ArrayList<CandidateAnswerDTO>();
		
		
		for (CandidateResponseDTO candidateResponseDTO : lista) {
			CandidateAnswer ca=new CandidateAnswer();
			QuestionDTO qDTO=questionService.findQuestionById(candidateResponseDTO.getIdQuestion()).getResult();
			ca.setIdCandidate(1);
			ca.setIdQuestion(qDTO.getId());
			
			if(candidateResponseDTO.getCandidateResponse().equalsIgnoreCase(qDTO.getCorrectAnswerText())) {
				qDTO.setAnswer("true");
			}else {
				qDTO.setAnswer("false");
			}
			
			candidateAnswerService.createCandidateAnswer(ca);
			listaReturn.add(CandidateAnswerDTO.build(ca));
		}
		
		response.setResult(listaReturn);
		response.setResultTest(true);
		
		
		return response;
		
	}
	
	
	
	public Response<ResultDTO> findCandidateMathScore(int idCandidate){
		
		log.info("inizio metodo");
		Response<ResultDTO> result=new Response<ResultDTO>();
		
		CandidateAnswer ca=new CandidateAnswer();
		Response<List<CandidateAnswerDTO>> resCandAnsDTO = new Response<List<CandidateAnswerDTO>>();
		ca.setIdCandidate(idCandidate);
		
		//serve per ciclare
		resCandAnsDTO=candidateAnswerService.findAllCandidateAnswersById(idCandidate);
		
		log.info("LOG RISULTATO ris: "+resCandAnsDTO.getResult().get(0).getAnswer());
		
		
		result.setResultTest(true);
		
		return result;
		
	}

	
	
	
}
