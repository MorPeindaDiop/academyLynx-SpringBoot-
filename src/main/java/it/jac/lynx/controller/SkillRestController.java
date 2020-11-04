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
			@RequestParam String description) {

		log.info("Ricevuta richiesta di creazione nuovo prodotto");
		
		Skill skill = new Skill();
		skill.setDescription(description);

		return skillService.createSkill(skill);
	}

	@DeleteMapping(path = "/delete/{id}")
	public Response<?> deleteSkillById(@RequestParam int id) {

		log.info("Richiesta delete.");

		return skillService.deleteSkillById(id);
	}
	
	@GetMapping(path="/findAll")
	public Response<?> findAllSkills(){
		
		log.info("richiesta di find all.");
		
		return skillService.findAllSkills();
		
	}


}
