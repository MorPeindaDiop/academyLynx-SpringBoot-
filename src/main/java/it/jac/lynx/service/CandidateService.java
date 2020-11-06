package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

	public Response<Boolean> createCandidate(Candidate candidate){

		Response<Boolean> response=new Response<Boolean>();

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

		Optional<Candidate> candidate = this.candidateRepository.findById(id);
		try {
			if (candidate.isPresent()) {
				response.setResult(CandidateDTO.build(candidate.get()));
				response.setResultTest(true);
			}

		} catch (Exception e) {
			response.setError("Nessun elemento trovato.");
		}

		return response;
	}

	//da qua
	//ho pensato che in una tabella candidato ci potesse stare aggiornare la sua seniority
	public Response<CandidateDTO> updateCandidateSeniorityById(int id, int seniority) {

		Response<CandidateDTO> response = new Response<CandidateDTO>();

		try {
			Candidate candidate = this.candidateRepository.findById(id).get();

			if (candidate != null)
				candidate.setIdSeniority(seniority);

			this.candidateRepository.save(candidate);
			response.setResult(CandidateDTO.build(candidate));
			response.setResultTest(true);

		}catch (Exception e){
			response.setError("Nessun elemento trovato.");
		}	

		return response;


	}


	public Response<List<CandidateDTO>> findCandidatesByidSeniority(int seniority) {

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



}
