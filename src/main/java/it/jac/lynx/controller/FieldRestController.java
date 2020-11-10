package it.jac.lynx.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
			@RequestParam String page,
			@RequestParam String fieldName,
			@RequestParam String reg_exp,
			@RequestParam boolean enabled) {

		log.info("Ricevuta richiesta di creazione nuovo candidato");

		Field field= new Field();
		field.setPage(page);
		field.setFieldName(fieldName);
		field.setReg_exp(reg_exp);
		field.setEnabled(enabled);

		return fieldService.createField(field);

	}
	
	@DeleteMapping(path = "/delete/{id}")
	public Response<?> deleteFieldById(@PathVariable(name = "id") int id) {

		log.info("Richiesta delete.");

		return fieldService.deleteFieldById(id);
		
	}
	
	@GetMapping(path="/findAll")
	public Response<?> findAllFields() {
		
		log.info("richiesta di find all.");
		
		return fieldService.findAllFields();
		
	}
	
	@PutMapping(path = "/update/{id}")
	public Response<?> updateCandidate(
			@PathVariable(name = "id") int id,
			@RequestParam (required = false) String page,
			@RequestParam (required = false) String fieldName,
			@RequestParam (required = false) String reg_exp,
			@RequestParam (required = false) boolean enabled) {

		return fieldService.updateField(id, page, fieldName, reg_exp, enabled);
	
	}
	
}
