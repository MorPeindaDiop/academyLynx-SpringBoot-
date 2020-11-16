package it.jac.lynx.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.CandidateResponseDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.service.ScoreService;

@RestController
@RequestMapping("/rest/score")
public class ScoreRestController {
	
	private static Logger log = LoggerFactory.getLogger(ScoreRestController.class);
	
	@Autowired
	private ScoreService scoreService;
	
	public Response<?> createCandidateResponse(
			@RequestParam int idQuestion,
			@RequestParam String answer,
			@RequestParam int idCandidate) {
		
		log.info("Ricevuta richiesta di creazione candidate response");
		
		List<CandidateResponseDTO> lista=new ArrayList<>();
		CandidateResponseDTO CandResDTO=new CandidateResponseDTO();
		CandResDTO.setCandidateResponse(answer);
		CandResDTO.setIdQuestion(idQuestion);
		lista.add(CandResDTO);
		return scoreService.setCandidateResponse(lista, idCandidate);
		
	}
	
}
