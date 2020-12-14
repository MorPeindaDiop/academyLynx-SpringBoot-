package it.jac.lynx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.Seniority;

import it.jac.lynx.service.SeniorityService;

@RestController
@RequestMapping("/rest/seniority")

public class SeniorityRestController {

	private static Logger log = LoggerFactory.getLogger(SeniorityRestController.class);

	@Autowired
	private SeniorityService seniorityService;


	@PostMapping("/create")
	public Response<?> createSeniority(
			@RequestBody Seniority seniority) {

		log.info("Ricevuta richiesta di creazione nuova seniority");

		return seniorityService.createSeniority(seniority);

	}
	
	@PostMapping(path = "/delete")
	public Response<?> deleteSeniorityById(
			@RequestBody int id) {

		log.info("Richiesta delete.");

		return seniorityService.deleteSeniorityById(id);
	}
	
	@GetMapping(path="/findAll")
	public Response<?> findAllSkills() {
		
		log.info("richiesta di find all.");
		
		return seniorityService.findAllSeniorities();
	}
	
//	@GetMapping(path="/detail/{id}")
//	public Response<?> findSeniorityById(@PathVariable(name = "id") int id) {
//		
//		log.info("trova da id");
//		
//		return seniorityService.findSeniorityById(id);
//	
//	}
//	
//	@GetMapping(path="/findByMinDifficulty/{minDifficulty}")
//	public Response<?> findSeniorityByMinDifficulty(@PathVariable(name = "minDifficulty") int minDifficulty) {
//		
//		log.info("ricerca da minima difficoltà");
//		
//		return seniorityService.findSeniorityByMinDifficuly(minDifficulty);
//	
//	}
//	
//	@GetMapping(path="/findByMaxDifficulty/{maxDifficulty}")
//	public Response<?> findSeniorityByMaxnDifficulty(@PathVariable(name = "maxDifficulty") int maxDifficulty){
//		
//		log.info("ricerca da massima difficoltà");
//		
//		return seniorityService.findSeniorityByMaxDifficuly(maxDifficulty);
//	
//	}

}
