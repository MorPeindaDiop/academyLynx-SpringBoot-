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
import it.jac.lynx.entity.CandidateSkill;
import it.jac.lynx.pk.PkCandidateSkill;
import it.jac.lynx.service.CandidateSkillService;

@RestController
@RequestMapping("/rest/candidateSkill")
public class CandidateSkillRestController {

	private static Logger log = LoggerFactory.getLogger(CandidateSkillRestController.class);

	private CandidateSkillService candidateSkillService;

	@PostMapping("/create")
	public Response<?> createCandidateSkill(
			@RequestParam int idCandidate,
			@RequestParam int idSkill) {

		log.info("Ricevuta richiesta di creazione nuova domanda candidato");

		CandidateSkill candidateSkill= new CandidateSkill();
		candidateSkill.setIdCandidate(idCandidate);
		candidateSkill.setIdSkill(idSkill);

		return candidateSkillService.createCandidateSkill(candidateSkill);

	}

	@DeleteMapping(path = "/delete")
	public Response<?> deleteCandidateSkillById(
			@RequestParam int idCandidate,
			@RequestParam int idSkill) {

		log.info("Richiesta delete.");

		PkCandidateSkill id = new PkCandidateSkill();

		id.setIdCandidate(idCandidate);
		id.setIdSkill(idSkill);

		return candidateSkillService.deleteCandidateSkillById(id);
	}

	@GetMapping(path="/findAll")
	public Response<?> findAllCandidateSkills() {

		log.info("richiesta di find all.");

		return candidateSkillService.findAllCandidateSkills();

	}

	@GetMapping(path="/detail")
	public Response<?> findCandidateSkillById(
			@RequestParam int idCandidate,
			@RequestParam int idSkill) {

		log.info("trova da id");

		PkCandidateSkill id = new PkCandidateSkill();
		id.setIdCandidate(idCandidate);
		id.setIdSkill(idSkill);

		return candidateSkillService.findCandidateSkillById(id);
	}

	@PutMapping(path = "/update")
	public Response<?> updateCandidateSkill(
			@RequestParam int idCandidate,
			@RequestParam int idSkill,
			@RequestParam int newIdSkill) {

		PkCandidateSkill id = new PkCandidateSkill();

		id.setIdCandidate(idCandidate);
		id.setIdSkill(idSkill);

		return candidateSkillService.updateCandidateSkill(id, newIdSkill);

	}

}
