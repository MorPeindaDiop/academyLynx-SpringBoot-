package it.jac.lynx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.CandidateSkill;
import it.jac.lynx.entity.PkCandidateSkill;
import it.jac.lynx.service.CandidateSkillService;

@RestController
@RequestMapping("/rest/candidateSkill")
public class CandidateSkillRestController {
	
private static Logger log = LoggerFactory.getLogger(CandidateSkillRestController.class);

	
	private CandidateSkillService candidateSkillService;
	
	@PostMapping("/create")
	public Response<?> createCandidateSkill(@RequestParam int id){

		log.info("Ricevuta richiesta di creazione nuova domanda candidato");

		CandidateSkill candidateSkill= new CandidateSkill();
		candidateSkill.setIdUser(id);

		return candidateSkillService.createCandidateSkill(candidateSkill);

	}
	
	@DeleteMapping(path = "/delete")
	public Response<?> deleteCandidateSkillById(@RequestParam int idUtente, @RequestParam int idSkill) {

		log.info("Richiesta delete.");
		
		PkCandidateSkill id=new PkCandidateSkill();
		
		id.setIdUser(idUtente);
		id.setIdSkill(idSkill);

		return candidateSkillService.deleteCandidateSkillById(id);
	}
	
	@GetMapping(path="/findAll")
	public Response<?> findAllCandidateSkillss(){
		
		log.info("richiesta di find all.");
		
		return candidateSkillService.findAllCandidateSkills();
	}
	
	
	@GetMapping(path="/findById/{id}")
	public Response<?> findSeniorityById(@PathVariable PkCandidateSkill id){
		log.info("trova da id");
		
		return candidateSkillService.findCandidateSkillById(id);
	}
	
	

}
