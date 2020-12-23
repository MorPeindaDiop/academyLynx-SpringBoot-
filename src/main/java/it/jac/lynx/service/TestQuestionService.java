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
import it.jac.lynx.dto.TestQuestionDTO;
import it.jac.lynx.entity.TestQuestion;
import junit.framework.Test;
import it.jac.lynx.dao.TestQuestionRepository;

@Service
public class TestQuestionService {
	
	private static Logger log = LoggerFactory.getLogger(TestQuestionService.class);
	

	@Autowired
	private TestQuestionRepository testRepository;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private CandidateService candidateService;
	
	public Response<Integer>createTestFromControler(List<TestQuestionDTO> test){
		Response<Integer> response = new Response <Integer>();
		List<TestQuestionDTO> listaReturn=new ArrayList<TestQuestionDTO>();
		
		try {
			for(TestQuestionDTO testDTO: test) {
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
	
	
	
	public Response<TestQuestion> createTest(TestQuestion test){
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
	
	public Response<TestQuestion> createTestQuestion(TestQuestion test){
		Response<TestQuestion> response = new Response<TestQuestion>();
		
		
		int lastId=this.findAllTestsByIdCandidate(test.getIdCandidate()).getResult().size();
		
		
		//se non c'è l'id test incrementa di 1 l'ultimo nel db (per lo stesso candidato)
		if(test.getIdTest()==0) {
			test.setIdTest(lastId);
		}
		
		
		
		log.info("\n\n\n\nTEST RICEVUTO\n\n\n\n\n"+test+"\n\n\n\n\n");
		try {

			this.testRepository.save(test);

			response.setResult(test);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Test non creato");

		}

		return response;

	}
	
	public Response<List<TestQuestionDTO>> findAllTests() {

		Response<List<TestQuestionDTO>> response = new Response<List<TestQuestionDTO>>();

		List<TestQuestionDTO> result = new ArrayList<>();

		try {

			Iterator<TestQuestion> iterator = this.testRepository.findAll().iterator();

			while(iterator.hasNext()) {

				TestQuestion testQuestion = iterator.next();
				result.add(TestQuestionDTO.build(testQuestion));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}
	public Response<List<TestQuestionDTO>> findAllTestsByIdCandidate(int idCandidate) {

		Response<List<TestQuestionDTO>> response = new Response<List<TestQuestionDTO>>();

		List<TestQuestionDTO> result = new ArrayList<>();

		try {

			Iterator<TestQuestion> iterator = this.testRepository.findAll().iterator();

			while(iterator.hasNext()) {
				
				
				TestQuestion testQuestion = iterator.next();
				if(testQuestion.getIdCandidate()==idCandidate) {					
					result.add(TestQuestionDTO.build(testQuestion));
				}

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}
	

	
	
}
