package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dto.QuestionDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.dto.TestDTO;
import it.jac.lynx.entity.TestQuestion;
import it.jac.lynx.dao.TestRepository;

@Service
public class TestQuestionService {
	
	private static Logger log = LoggerFactory.getLogger(TestQuestionService.class);
	

	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private QuestionService questionService;
	
	public Response<Integer>createTestFromControler(List<TestDTO> test){
		Response<Integer> response = new Response <Integer>();
		List<TestDTO> listaReturn=new ArrayList<TestDTO>();
		
		try {
			for(TestDTO testDTO: test) {
				TestQuestion t=new TestQuestion();
				QuestionDTO qDTO = questionService.findQuestionById(testDTO.getIdQuestion()).getResult();
				t.setIdQuestion(qDTO.getId());
				t.setIdTest(testDTO.getIdTest());
				this.createTest(t);
				listaReturn.add(testDTO.build(t));
			}
			response.setResult(listaReturn.get(0).getIdTest());
			response.setResultTest(true);
		}catch(Exception e) {
			response.setError("nessuna question trovata");
		}
		return response;
		
		
	}
	
	
	
	public Response<Integer> createTest(TestQuestion test){
		Response<Integer> response = new Response<Integer>();
		try {

			this.testRepository.save(test);

			response.setResult(test.getIdTest());
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Test non creato");

		}

		return response;

	}
	

	
	
}
