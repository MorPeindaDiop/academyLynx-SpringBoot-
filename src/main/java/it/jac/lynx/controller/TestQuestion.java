package it.jac.lynx.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.Response;
import it.jac.lynx.dto.TestDTO;
import it.jac.lynx.service.TestQuestionService;

@RestController
@RequestMapping("/rest/testQuestion")
public class TestQuestion {
	
	private static Logger log = LoggerFactory.getLogger(TestQuestion.class);
	
	@Autowired
	private TestQuestionService testQuestionService;
	
	@PostMapping("/create")
	public Response<?> createTestQuestion(@RequestBody List<TestDTO> test){
		log.info("creazione test BRO");
		return testQuestionService.createTestFromControler(test);
		
	}

}
