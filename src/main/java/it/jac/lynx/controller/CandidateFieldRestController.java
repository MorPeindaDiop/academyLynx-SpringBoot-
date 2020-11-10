package it.jac.lynx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.CandidateField;
import it.jac.lynx.pk.PkCandidateField;
import it.jac.lynx.service.CandidateFieldService;

@RestController
@RequestMapping("/rest/candidateField")
public class CandidateFieldRestController {

	private static Logger log = LoggerFactory.getLogger(CandidateFieldRestController.class);

	@Autowired
	private CandidateFieldService candidateFieldService;

	@PostMapping("/create")
	public Response<?> createCandidateField(
			@RequestParam int idCandidate,
			@RequestParam int idField,
			@RequestParam String value) {

		log.info("Ricevuta richiesta di creazione nuova domanda candidato");

		CandidateField candidateField= new CandidateField();
		candidateField.setIdCandidate(idCandidate);
		candidateField.setIdField(idField);
		candidateField.setValue(value);

		return candidateFieldService.createCandidateField(candidateField);

	}

	//@DeleteMapping(path = "/delete/{id}")
	@DeleteMapping(path = "/delete")
	public Response<?> deleteCandidateFieldById(@RequestParam int idCandidate, @RequestParam int idField) {

		log.info("Richiesta delete.");

		PkCandidateField id = new PkCandidateField();

		id.setIdCandidate(idCandidate);
		id.setIdField(idField);

		return candidateFieldService.deleteCandidateFieldById(id);

	}

	@GetMapping(path="/findAll")
	public Response<?> findAllCandidateFields() {

		log.info("richiesta di find all.");

		return candidateFieldService.findAllCandidateFields();

	}

	@GetMapping(path="/detail")
	public Response<?> findCandidateFieldById(
			@RequestParam int idCandidate,
			@RequestParam int idField) {

		log.info("trova da id");
		
		PkCandidateField id = new PkCandidateField();

		id.setIdCandidate(idCandidate);
		id.setIdField(idField);

		return candidateFieldService.findCandidateFieldById(id);

	}

	@PutMapping(path = "/update")
	public Response<?> updateCandidateField(
			@RequestParam int idCandidate,
			@RequestParam int idField,
			@RequestParam (required = false) String value) {

		PkCandidateField id = new PkCandidateField();

		id.setIdCandidate(idCandidate);
		id.setIdField(idField);

		return candidateFieldService.updateCandidateField(id, value);

	}

}
