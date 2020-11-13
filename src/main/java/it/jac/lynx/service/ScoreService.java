package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.List;

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
	//private static Logger log = LoggerFactory.getLogger(ResultService.class);

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

				if (candidateResponseDTO.getCandidateResponse().equalsIgnoreCase(qDTO.getCorrectAnswerText())) {

					ca.setAnswer(true);

				} else {

					ca.setAnswer(false);

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

		Response<CandidateDTO> response = new Response <CandidateDTO>();
		
		List<CandidateAnswerDTO> candidateTest = new ArrayList<CandidateAnswerDTO>();
		
		int nCorrectAnswer = 0;

		try {
			
			CandidateDTO candidate = candidateService.findCandidateById(idCandidate).getResult();
			
			candidateTest = candidateAnswerService.findCandidateAnswerByIdCandidate(idCandidate).getResult();
			
			for (CandidateAnswerDTO answer: candidateTest) {
				
				if (answer.isAnswer())
					nCorrectAnswer += 1;
				
			}
			
			candidateService.setCandidateScoreAndTime(candidate.getId(), nCorrectAnswer, 20, 50);
			
			response.setResult(candidate);
			response.setResultTest(true);

		} catch (Exception e ) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

}
