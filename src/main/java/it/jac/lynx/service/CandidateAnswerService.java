package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.jac.lynx.dao.CandidateAnswerRepository;
import it.jac.lynx.dto.CandidateAnswerDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.CandidateAnswer;
import it.jac.lynx.pk.PkCandidateAnswer;

@Service
public class CandidateAnswerService {
	
	private static Logger log = LoggerFactory.getLogger(CandidateAnswerService.class);
	
	@Autowired
	private CandidateAnswerRepository candidateAnswerRepository;

	public Response<Boolean> createCandidateAnswer(CandidateAnswer candidateAnswer) {

		Response<Boolean> response = new Response<Boolean>();

		try {

			this.candidateAnswerRepository.save(candidateAnswer);

			response.setResult(true);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Answer non creata");

		}

		return response;

	}

	public Response<String> deleteCandidateAnswerById(PkCandidateAnswer id) {

		Response<String> response = new Response<String>();

		try {

			this.candidateAnswerRepository.deleteById(id);

			response.setResult("Candidato eliminato.");
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Candidato non eliminato correttamente.");

		}

		return response;

	}


	public Response<List<CandidateAnswerDTO>> findAllCandidateAnswers() {

		Response<List<CandidateAnswerDTO>> response = new Response<List<CandidateAnswerDTO>>();

		List<CandidateAnswerDTO> result = new ArrayList<>();

		try {

			Iterator<CandidateAnswer> iterator = this.candidateAnswerRepository.findAll().iterator();

			while(iterator.hasNext()) {

				CandidateAnswer candidateAnswer = iterator.next();
				result.add(CandidateAnswerDTO.build(candidateAnswer));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}
	
	public Response<List<CandidateAnswerDTO>> findAllCandidateAnswersById(int idCandidate) {

		Response<List<CandidateAnswerDTO>> response = new Response<List<CandidateAnswerDTO>>();
		CandidateAnswer candidateAnswer=new CandidateAnswer();
		List<CandidateAnswerDTO> result = new ArrayList<>();
		
		boolean flag=false;

		try {

			Iterator<CandidateAnswer> iterator = this.candidateAnswerRepository.findAll().iterator();

			while(iterator.hasNext()) {
				
				if(candidateAnswer.getIdCandidate()==idCandidate) {
					log.info("LOG SERVICE CANDIDATE ANSWER: "+CandidateAnswerDTO.build(candidateAnswer).toString());
					result.add(CandidateAnswerDTO.build(candidateAnswer));	
					flag=true;
				}
				candidateAnswer = iterator.next();

			}
			
			if(flag)
				response.setResultTest(true);
			
			response.setResult(result);
			

		} catch (Exception e) {
			response.setResultTest(false);
			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<CandidateAnswerDTO> findCandidateAnswerById(PkCandidateAnswer id) {

		Response<CandidateAnswerDTO> response = new Response<CandidateAnswerDTO>();

		try {

			CandidateAnswer candidateAnswer = this.candidateAnswerRepository.findById(id).get();

			response.setResult(CandidateAnswerDTO.build(candidateAnswer));
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<CandidateAnswerDTO> updateCandidateAnswer(PkCandidateAnswer id, String answer) {

		Response<CandidateAnswerDTO> response = new Response<CandidateAnswerDTO>();

		try {

			CandidateAnswer candidateAnswer = this.candidateAnswerRepository.findById(id).get();

			if (!answer.contentEquals(candidateAnswer.getAnswer())) //non so di preciso cazzo sia però occhei
				candidateAnswer.setAnswer(answer);

			this.candidateAnswerRepository.save(candidateAnswer);

			response.setResult(CandidateAnswerDTO.build(candidateAnswer));
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}
}
