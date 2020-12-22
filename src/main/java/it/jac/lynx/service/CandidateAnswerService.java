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
import it.jac.lynx.dto.CandidateDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.CandidateAnswer;
import it.jac.lynx.pk.PkCandidateAnswer;

@Service
public class CandidateAnswerService {

	private static Logger log = LoggerFactory.getLogger(CandidateAnswerService.class);
	
	@Autowired
	private CandidateAnswerRepository candidateAnswerRepository;

	public Response<Integer> createCandidateAnswer(CandidateAnswer candidateAnswer) {
		CandidateDTO cDTO =new CandidateDTO();
		Response<Integer> response = new Response<Integer>();

		try {

			this.candidateAnswerRepository.save(candidateAnswer);

			response.setResult(candidateAnswer.getIdCandidate());
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
	
	public Response<List<CandidateAnswerDTO>> findCandidateAnswerByIdCandidate(int idCandidate) {

		Response<List<CandidateAnswerDTO>> response = new Response<List<CandidateAnswerDTO>>();
		
		List<CandidateAnswerDTO> result = new ArrayList<CandidateAnswerDTO>();

		try {

			List<CandidateAnswer> candidateAnswerList = this.candidateAnswerRepository.findByIdCandidate(idCandidate);
			log.info(candidateAnswerList.toString());

			for (CandidateAnswer candidateAnswer: candidateAnswerList) {
				
				result.add(CandidateAnswerDTO.build(candidateAnswer));
				
			}
			
			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}
}
