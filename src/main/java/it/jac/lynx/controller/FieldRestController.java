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
import it.jac.lynx.entity.Field;

import it.jac.lynx.service.FieldService;


@RestController
@RequestMapping("/rest/field")
public class FieldRestController {
	
	private static Logger log = LoggerFactory.getLogger(FieldRestController.class);
	
	@Autowired
	private FieldService fieldService;
	
	@PostMapping("/create")
	public Response<?> createField(
			@RequestBody Field field) {

		log.info("Ricevuta richiesta di creazione nuovo candidato");

		return fieldService.createField(field);

	}
	
	@PostMapping(path = "/delete")
	public Response<?> deleteFieldById(
			@RequestBody int id) {

		log.info("Richiesta delete.");

		return fieldService.deleteFieldById(id);
		
	}
	
	@GetMapping(path="/findAll")
	public Response<?> findAllFields() {
		
		log.info("richiesta di find all.");
		
		return fieldService.findAllFields();
		
	}
	
}
