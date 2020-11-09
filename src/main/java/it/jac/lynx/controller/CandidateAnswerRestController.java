package it.jac.lynx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Response<?> createCandidateAnswer(
			@RequestParam int idCandidate,
			@RequestParam int idQuestion,
			@RequestParam boolean answer) {

		log.info("Ricevuta richiesta di creazione nuova domanda candidato");

		CandidateAnswer candidateAnswer= new CandidateAnswer();
		candidateAnswer.setIdCandidate(idCandidate);
		candidateAnswer.setIdQuestion(idQuestion);
		candidateAnswer.setAnswer(answer);

		return candidateAnswerService.createCandidateAnswer(candidateAnswer);

	}

	//@DeleteMapping(path = "/delete/{id}")
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

	@PutMapping(path = "/update")
	public Response<?> updateCandidateAnswer(
			@RequestParam int idCandidate,
			@RequestParam int idQuestion,
			@RequestParam (required = false) boolean answer) {

		PkCandidateAnswer id = new PkCandidateAnswer();

		id.setIdCandidate(idCandidate);
		id.setIdQuestion(idQuestion);

		return candidateAnswerService.updateCandidateAnswer(id, answer);

	}

}
