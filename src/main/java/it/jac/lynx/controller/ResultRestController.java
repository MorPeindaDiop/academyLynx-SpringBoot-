package it.jac.lynx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.service.CandidateAnswerService;
import it.jac.lynx.service.CandidateService;
import it.jac.lynx.service.QuestionService;

@RestController
@RequestMapping("/rest/result")
public class ResultRestController {
	
	private static Logger log = LoggerFactory.getLogger(ResultRestController.class);

	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private CandidateAnswerService candidateAnswerService;
	
	@Autowired
	private CandidateService candidateService;
}
