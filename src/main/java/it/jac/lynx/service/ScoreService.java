package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dto.CandidateAnswerDTO;
import it.jac.lynx.dto.CandidateResponseDTO;
import it.jac.lynx.dto.QuestionDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.CandidateAnswer;

@Service
public class ScoreService {
	//private static Logger log = LoggerFactory.getLogger(ResultService.class);

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private CandidateAnswerService candidateAnswerService;
	
//	@Autowired
//	private CandidateService candidateService;	
	
	public Response<List<CandidateAnswerDTO>> setCandidateResponse(List<CandidateResponseDTO> lista){
		
		Response<List<CandidateAnswerDTO>> response = new Response <List<CandidateAnswerDTO>>();
		
		List<CandidateAnswerDTO> listaReturn= new ArrayList<CandidateAnswerDTO>();
		
		
		for (CandidateResponseDTO candidateResponseDTO : lista) {
			CandidateAnswer ca=new CandidateAnswer();
			QuestionDTO qDTO=questionService.findQuestionById(candidateResponseDTO.getIdQuestion()).getResult();
			ca.setIdCandidate(1);
			ca.setIdQuestion(qDTO.getId());
			
			if(candidateResponseDTO.getCandidateResponse().equalsIgnoreCase(qDTO.getCorrectAnswerText())) {
				ca.setAnswer(true);
			}else {
				ca.setAnswer(false);
			}
			
			candidateAnswerService.createCandidateAnswer(ca);
			listaReturn.add(CandidateAnswerDTO.build(ca));
		}
		
		response.setResult(listaReturn);
		response.setResultTest(true);
		
		
		return response;
		
	}

}
