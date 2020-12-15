package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dto.CandidateDTO;
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
	
	@Autowired
	private CandidateService candidateService;
	
	public Response<Integer>createTestFromControler(List<TestDTO> test){
		Response<Integer> response = new Response <Integer>();
		List<TestDTO> listaReturn=new ArrayList<TestDTO>();
		
		try {
			for(TestDTO testDTO: test) {
				TestQuestion t=new TestQuestion();
				CandidateDTO cDTO= candidateService.findCandidateById(testDTO.getIdCandidate()).getResult();
				t.setIdCandidate(cDTO.getId());
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
	
	public Response<TestQuestion> createTestQuestion(TestQuestion test){
		Response<TestQuestion> response = new Response<TestQuestion>();
		try {

			this.testRepository.save(test);

			response.setResult(test);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Test non creato");

		}

		return response;

	}
	
	public Response<List<TestDTO>> findAllTests() {

		Response<List<TestDTO>> response = new Response<List<TestDTO>>();

		List<TestDTO> result = new ArrayList<>();

		try {

			Iterator<TestQuestion> iterator = this.testRepository.findAll().iterator();

			while(iterator.hasNext()) {

				TestQuestion testQuestion = iterator.next();
				result.add(TestDTO.build(testQuestion));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}
	

	
	
}
