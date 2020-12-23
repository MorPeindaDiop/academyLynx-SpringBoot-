package it.jac.lynx.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.Response;
import it.jac.lynx.dto.TestQuestionDTO;
import it.jac.lynx.entity.TestQuestion;
import it.jac.lynx.service.TestQuestionService;

@RestController
@RequestMapping("/rest/testQuestion")
public class TestQuestionController {
	
	private static Logger log = LoggerFactory.getLogger(TestQuestionController.class);
	
	@Autowired
	private TestQuestionService testQuestionService;
	
	@PostMapping("/create")
	public Response<?> createTestQuestion(@RequestBody TestQuestion test){
		log.info("creazione test BRO");
		
		
		log.info("TEST --->"+test);

		
		return testQuestionService.createTestQuestion(test);
		
	}
	
//	@PostMapping(path = "/delete")
//	public Response<?> deleteSeniorityById(
//			@RequestBody int id) {
//
//		log.info("Richiesta delete.");
//
//		return testQuestionService.deleteSeniorityById(id);
//	}
	
	@GetMapping(path="/findAll")
	public Response<?> findAllSkills() {
		
		log.info("richiesta di find all.");
		
		return testQuestionService.findAllTests();
	}

}
