package it.jac.lynx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Response<?> createCandidate(@RequestParam int id){

		log.info("Ricevuta richiesta di creazione nuovo candidato");

		Candidate candidate= new Candidate();
		candidate.setId(id);

		return candidateService.createCandidate(candidate);

	}
	
	
	@DeleteMapping(path = "/delete/{id}")
	public Response<?> deleteCandidateById(@RequestParam int id) {

		log.info("Richiesta delete.");

		return candidateService.deleteCandidateById(id);
	}
	
	
	@GetMapping(path="/findAll")
	public Response<?> findAllCandidates(){
		
		log.info("richiesta di find all.");
		
		return candidateService.findAllCandidates();
	}
	
	
	@GetMapping(path="/findById/{id}")
	public Response<?> findSeniorityById(@RequestParam int id){
		log.info("trova da id");
		
		return candidateService.findCandidateById(id);
	}
	
	@GetMapping(path="/findBySeniority/{id}")
	public Response<?> findCandidatesBySenioirty(@RequestParam int idSeniority){
		log.info("trova da seniority");
		
		return candidateService.findCandidatesByidSeniority(idSeniority);
	}

}
