package it.jac.lynx.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.service.ResultService;

@RestController
@RequestMapping("/rest/result")
public class ResultRestController {
	
	private static Logger log = LoggerFactory.getLogger(ResultRestController.class);

	

	private ResultService resultService;
	
	
	
}
