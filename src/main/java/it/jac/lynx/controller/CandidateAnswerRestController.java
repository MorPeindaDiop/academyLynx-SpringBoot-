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
import it.jac.lynx.entity.CandidateAnswer;
import it.jac.lynx.entity.PkCandidateAnswer;
import it.jac.lynx.service.CandidateAnswerService;

@RestController
@RequestMapping("/rest/candidateAnswer")
public class CandidateAnswerRestController {
	
	private static Logger log = LoggerFactory.getLogger(CandidateAnswerRestController.class);

	
	private CandidateAnswerService candidateAnswerService;
	
	@PostMapping("/create")
	public Response<?> createCandidateAnswer(@RequestParam int id){

		log.info("Ricevuta richiesta di creazione nuova domanda candidato");

		CandidateAnswer candidateAnswer= new CandidateAnswer();
		candidateAnswer.setIdUser(id);

		return candidateAnswerService.createCandidateAnswer(candidateAnswer);

	}
	
	
	//@DeleteMapping(path = "/delete/{id}")
	@DeleteMapping(path = "/delete")
	public Response<?> deleteCandidateAnswerById(@RequestParam int idUtente, @RequestParam int idQuestion) {

		log.info("Richiesta delete.");
		
		PkCandidateAnswer id=new PkCandidateAnswer();
		
		id.setIdUser(idUtente);
		id.setIdQuestion(idQuestion);

		return candidateAnswerService.deleteCandidateAnswerById(id);
	}
	
	@GetMapping(path="/findAll")
	public Response<?> findAllCandidateAnswerss(){
		
		log.info("richiesta di find all.");
		
		return candidateAnswerService.findAllCandidateAnswers();
	}
	
	
	@GetMapping(path="/findById/{id}")
	public Response<?> findSeniorityById(@PathVariable PkCandidateAnswer id){
		log.info("trova da id");
		
		return candidateAnswerService.findCandidateAnswerById(id);
	}
	
}
