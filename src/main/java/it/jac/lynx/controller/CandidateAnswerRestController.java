package it.jac.lynx.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.CandidateResponseDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.CandidateAnswer;
import it.jac.lynx.pk.PkCandidateAnswer;


import it.jac.lynx.service.CandidateAnswerService;
import it.jac.lynx.service.ScoreService;

@RestController
@RequestMapping("/rest/candidateAnswer")
public class CandidateAnswerRestController {

	private static Logger log = LoggerFactory.getLogger(CandidateAnswerRestController.class);
 
	@Autowired
	private CandidateAnswerService candidateAnswerService;
	
	@Autowired
	private ScoreService scoreService;

	@PostMapping("/create")
	public Response<?> createCandidateAnswer(
			@RequestBody List<CandidateResponseDTO> lista) {

		log.info("Ricevuta richiesta di creazione nuova domanda candidato");

		return scoreService.setCandidateResponse(lista);

	}
	
	@PostMapping("/createTest")
	public Response<?> setTestQuestion(
			@RequestBody List<CandidateAnswer> candidateAnswer) {

		log.info("Ricevuta richiesta di creazione nuova domanda candidato");

		return candidateAnswerService.createCandidateTest(candidateAnswer);

	}

	@DeleteMapping(path = "/delete")
	public Response<?> deleteCandidateAnswerById(@RequestParam int idCandidate, @RequestParam int idQuestion) {

		log.info("Richiesta delete.");

		PkCandidateAnswer id = new PkCandidateAnswer();

		id.setIdCandidate(idCandidate);
		id.setIdQuestion(idQuestion);

		return candidateAnswerService.deleteCandidateAnswerById(id);

	}

	@GetMapping(path="/findAll")
	public Response<?> findAllCandidateAnswers() {

		log.info("richiesta di find all.");

		return candidateAnswerService.findAllCandidateAnswers();

	}


	@GetMapping(path="/detail")
	public Response<?> findCandidateAnswerById(
			@RequestParam int idCandidate,
			@RequestParam int idQuestion) {

		log.info("trova da id");
		
		PkCandidateAnswer id = new PkCandidateAnswer();

		id.setIdCandidate(idCandidate);
		id.setIdQuestion(idQuestion);

		return candidateAnswerService.findCandidateAnswerById(id);

	}
	
	@GetMapping(path="/currentCandidateAnswer")
	public Response<?> findCandidateAnswerByIdCandidate(
			@PathVariable(name = "idCandidate") int idCandidate) {

		log.info("trova da id");
		
		return candidateAnswerService.findCandidateAnswerByIdCandidate(idCandidate);

	}

}
