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
import it.jac.lynx.entity.Seniority;

import it.jac.lynx.service.SeniorityService;

@RestController
@RequestMapping("/rest/seniority")

public class SeniorityRestController {

	private static Logger log = LoggerFactory.getLogger(SeniorityRestController.class);

	@Autowired
	private SeniorityService seniorityService;


	@PostMapping("/create")
	public Response<?> createSeniority(@RequestParam int id){

		log.info("Ricevuta richiesta di creazione nuova seniority");

		Seniority seniority= new Seniority();
		seniority.setId(id);

		return seniorityService.createSeniority(seniority);

	}
	
	@DeleteMapping(path = "/delete/{id}")
	public Response<?> deleteSeniorityById(@RequestParam int id) {

		log.info("Richiesta delete.");

		return seniorityService.deleteSeniorityById(id);
	}
	@GetMapping(path="/findAll")
	public Response<?> findAllSkills(){
		
		log.info("richiesta di find all.");
		
		return seniorityService.findAllSeniority();
	}
	
	@GetMapping(path="/findById/{id}")
	public Response<?> findSeniorityById(@RequestParam int id){
		log.info("trova da id");
		
		return seniorityService.findSeniorityById(id);
	}
	
	//da qua
	@GetMapping(path="/findByMinDifficulty/{id}")
	public Response<?> findSeniorityByMinDifficulty(@RequestParam int difficulty){
		log.info("ricerca da minima difficoltà");
		return seniorityService.findSeniorityByMinDifficuly(difficulty);
	}
	
	@GetMapping(path="/findByMaxDifficulty/{id}")
	public Response<?> findSeniorityByMaxnDifficulty(@RequestParam int difficulty){
		log.info("ricerca da massima difficoltà");
		return seniorityService.findSeniorityByMaxDifficuly(difficulty);
	}

}
