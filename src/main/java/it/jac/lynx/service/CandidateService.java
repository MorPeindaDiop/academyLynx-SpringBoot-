package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dao.CandidateRepository;
import it.jac.lynx.dto.CandidateDTO;
import it.jac.lynx.dto.Response;

import it.jac.lynx.entity.Candidate;


@Service
public class CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	public Response<Boolean> createCandidate(Candidate candidate) {

		Response<Boolean> response = new Response<Boolean>();

		try {

			this.candidateRepository.save(candidate);

			response.setResult(true);
			response.setResultTest(true);

		}catch(Exception e) {

			response.setError("Candidato non creato");

		}

		return response;

	}


	public Response<String> deleteCandidateById(int id) {

		Response<String> response = new Response<String>();

		try {

			this.candidateRepository.deleteById(id);

			response.setResult("Candidato eliminato.");
			response.setResultTest(true);

		}catch(Exception e){

			response.setError("Candidato non eliminato correttamente.");

		}

		return response;

	}


	public Response<List<CandidateDTO>> findAllCandidates() {

		Response<List<CandidateDTO>> response = new Response<List<CandidateDTO>>();

		List<CandidateDTO> result = new ArrayList<>();

		try {

			Iterator<Candidate> iterator = this.candidateRepository.findAll().iterator();

			while(iterator.hasNext()) {

				Candidate candidate = iterator.next();
				result.add(CandidateDTO.build(candidate));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<CandidateDTO> findCandidateById(int id) {

		Response<CandidateDTO> response = new Response<CandidateDTO>();


		try {

			Candidate candidate = this.candidateRepository.findById(id).get();

			response.setResult(CandidateDTO.build(candidate));
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}

		return response;
		
	}

	public Response<CandidateDTO> updateCandidate(
			int id,
			String name,
			String surname,
			Date dataTest,
			int idSeniority,
			int score,
			int time) {

		Response<CandidateDTO> response = new Response<CandidateDTO>();

		try {
			Candidate candidate = this.candidateRepository.findById(id).get();

			if (name != null)
				candidate.setName(name);
			
			if (surname != null)
				candidate.setSurname(surname);
			
			if (dataTest != null)
				candidate.setDataTest(dataTest);
			
			if (idSeniority > 0)
				candidate.setIdSeniority(idSeniority);
			
			if (score > 0)
				candidate.setScore(score);
			
			if (time > 0)
				candidate.setTime(time);

			this.candidateRepository.save(candidate);
			
			response.setResult(CandidateDTO.build(candidate));
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}	

		return response;

	}


	public Response<List<CandidateDTO>> findCandidatesByIdSeniority(int seniority) {

		Response<List<CandidateDTO>> response = new Response<List<CandidateDTO>>();
		
		List<CandidateDTO> result = new ArrayList<>();

		try {
			
			Iterator<Candidate> iterator = this.candidateRepository.findByidSeniority(seniority).iterator();
			
			while(iterator.hasNext()) {

				Candidate candidate = iterator.next();
				result.add(CandidateDTO.build(candidate));
				
			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e ) {
			
			response.setError("Nessun elemento trovato.");
			
		}

		return response;
		
	}
	
	public Response<CandidateDTO> setCandidateScoreAndTime(
			int id,
			int score,
			int time) {

		Response<CandidateDTO> response = new Response<CandidateDTO>();

		try {
			Candidate candidate = this.candidateRepository.findById(id).get();

			if (score > 0)
				candidate.setScore(score);
			
			if (time > 0)
				candidate.setTime(time);

			this.candidateRepository.save(candidate);
			
			response.setResult(CandidateDTO.build(candidate));
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}	

		return response;

	}

}
