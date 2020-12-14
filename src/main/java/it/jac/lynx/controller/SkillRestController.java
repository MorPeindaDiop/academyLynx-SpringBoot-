package it.jac.lynx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.jac.lynx.dto.Response;

import it.jac.lynx.entity.Skill;
import it.jac.lynx.service.SkillService;


@RestController
@RequestMapping("/rest/skill")
public class SkillRestController {

	private static Logger log = LoggerFactory.getLogger(SkillRestController.class);

	@Autowired
	private SkillService skillService;

	@PostMapping("/create")
	public Response<?> createSkill(
			@RequestBody Skill skill) {

		log.info("Ricevuta richiesta di creazione nuova skill");

		return skillService.createSkill(skill);

	}

	@PostMapping(path = "/delete")
	public Response<?> deleteSkillById(
			@RequestBody int id) {

		log.info("Richiesta delete.");

		return skillService.deleteSkillById(id);

	}

	@GetMapping(path="/findAll")
	public Response<?> findAllSkills(){

		log.info("richiesta di find all.");

		return skillService.findAllSkills();

	}

//	@GetMapping(path="/detail/{id}")
//	public Response<?> findSkillById(@PathVariable(name = "id") Integer id){log.info("trova da id");
//
//	return skillService.findSkillById(id);
//
//	}

	@GetMapping(path="/findByDescription/{descriprion}")
	public Response<?> findSkillByDescription(@PathVariable String description){

		log.info("richiesta di ricerca da descrizione");

		return skillService.findSkillByDescription(description);

	}

//	@PutMapping(path = "/update/{id}")
//	public Response<?> updateSkill(
//			@PathVariable(name = "id") int id,
//			@RequestParam (required = false) String description) {
//
//		return skillService.updateSkill(id, description);
//		
//	}

}
