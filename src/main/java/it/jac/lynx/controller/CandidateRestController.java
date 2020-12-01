package it.jac.lynx.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.Candidate;

import it.jac.lynx.service.CandidateService;


@RestController
@RequestMapping("/rest/candidate")
public class CandidateRestController {
	
	private static Logger log = LoggerFactory.getLogger(CandidateRestController.class);
	
	@Autowired
	private CandidateService candidateService;
	
	@PostMapping("/create")
	public Response<?> createCandidate(
			@RequestBody Candidate candidate
			) {
		
		candidate.setDataTest(new Date());

		return candidateService.createCandidate(candidate);

	}
	
	@PostMapping(path = "/delete")
	public Response<?> deleteCandidateById(
			@RequestBody int id) {

		log.info("Richiesta delete.");

		return candidateService.deleteCandidateById(id);
		
	}
	
	@GetMapping(path="/findAll")
	public Response<?> findAllCandidates() {
		
		log.info("richiesta di find all.");
		
		return candidateService.findAllCandidates();
		
	}
	
	@GetMapping(path="/detail/{id}")
	public Response<?> findSeniorityById(@PathVariable(name = "id") int id) {
		
		log.info("trova da id");
		
		return candidateService.findCandidateById(id);
		
	}
	
	@PutMapping(path = "/update/{id}")
	public Response<?> updateCandidate(
			@PathVariable(name = "id") int id,
			@RequestParam String name,
			@RequestParam String surname,
			@RequestParam Date dataTest,
			@RequestParam int idSeniority,
			@RequestParam (required = false) int nCorrectAnswer,
			@RequestParam (required = false) int weightedScore,
			@RequestParam (required = false) int arithmeticScore,
			@RequestParam (required = false) int time) {

		return candidateService.updateCandidate(id, name, surname, dataTest, idSeniority, nCorrectAnswer, weightedScore, arithmeticScore, time);
	
	}
	
	@GetMapping(path="/findByIdSeniority/{id}")
	public Response<?> findCandidatesByIdSenioirty(@PathVariable(name = "id") int idSeniority) {
		
		log.info("trova da seniority");
		
		return candidateService.findCandidatesByIdSeniority(idSeniority);
		
	}
	
	@GetMapping(path = "/updateDataTest/{id}")
	public Response<?> setCandidateScoreAndTime(
			@PathVariable(name = "id") int id) {

		return candidateService.setCandidateScoreAndTime(id);
	
	}
	
}
