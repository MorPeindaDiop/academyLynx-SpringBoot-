package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dao.SeniorityRepository;
import it.jac.lynx.dto.Response;
import it.jac.lynx.dto.SeniorityDTO;

import it.jac.lynx.entity.Seniority;

@Service
public class SeniorityService {

	@Autowired
	private SeniorityRepository seniorityRepository;


	public Response<Boolean> createSeniority(Seniority seniority){

		Response<Boolean> response=new Response<Boolean>();

		try {

			this.seniorityRepository.save(seniority);

			response.setResult(true);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Seniority non creata");
		}

		return response;

	}

	public Response<String> deleteSeniorityById(int id) {

		Response<String> response = new Response<String>();

		try {

			this.seniorityRepository.deleteById(id);

			response.setResult("Seniority eliminata.");
			response.setResultTest(true);

		} catch (Exception e) {
			response.setError("Seniority non eliminata correttamente.");
		}
		return response;
	}

	public Response<List<SeniorityDTO>> findAllSeniority() {

		Response<List<SeniorityDTO>> response = new Response<List<SeniorityDTO>>();

		List<SeniorityDTO> result = new ArrayList<>();

		try {

			Iterator<Seniority> iterator = this.seniorityRepository.findAll().iterator();

			while(iterator.hasNext()) {

				Seniority seniority = iterator.next();
				result.add(SeniorityDTO.build(seniority));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}


	public Response<SeniorityDTO> findSeniorityById(int id) {

		Response<SeniorityDTO> response = new Response<SeniorityDTO>();

		try {

			Seniority seniority = this.seniorityRepository.findById(id).get();

			response.setResult(SeniorityDTO.build(seniority));
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<List<SeniorityDTO>> findSeniorityByDescription(String description) {

		Response<List<SeniorityDTO>> response = new Response<List<SeniorityDTO>>();

		List<SeniorityDTO> result = new ArrayList<>();

		try {

			Iterator<Seniority> iterator = this.seniorityRepository.findByDescription(description).iterator();

			while(iterator.hasNext()) {

				Seniority seniority = iterator.next();
				result.add(SeniorityDTO.build(seniority));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<SeniorityDTO> updateSeniority(int id, String description, int minDifficulty, int maxDifficulty) {

		Response<SeniorityDTO> response = new Response<SeniorityDTO>();

		try {

			Seniority seniority = this.seniorityRepository.findById(id).get();

			if (description != null)
				seniority.setDescription(description);

			if (minDifficulty > 0 && minDifficulty < seniority.getMaxDifficulty())
				seniority.setMinDifficulty(minDifficulty);

			if (maxDifficulty > 0 && maxDifficulty > seniority.getMinDifficulty())
				seniority.setMaxDifficulty(maxDifficulty);

			this.seniorityRepository.save(seniority);

			response.setResult(SeniorityDTO.build(seniority));
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}	

		return response;

	}

	public Response<List<SeniorityDTO>> findSeniorityByMinDifficuly(int minDifficulty) {

		Response<List<SeniorityDTO>> response = new Response<List<SeniorityDTO>>();

		List<SeniorityDTO> result = new ArrayList<>();

		try {

			Iterator<Seniority> iterator = this.seniorityRepository.findByMinDifficulty(minDifficulty).iterator();
			
			while(iterator.hasNext()) {

				Seniority seniority = iterator.next();
				result.add(SeniorityDTO.build(seniority));
			
			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e ) {
			
			response.setError("Nessun elemento trovato.");
			
		}

		return response;
		
	}

	public Response<List<SeniorityDTO>> findSeniorityByMaxDifficuly(int difficulty) {

		Response<List<SeniorityDTO>> response = new Response<List<SeniorityDTO>>();

		List<SeniorityDTO> result = new ArrayList<>();

		try {

			Iterator<Seniority> iterator = this.seniorityRepository.findByMaxDifficulty(difficulty).iterator();
			
			while(iterator.hasNext()) {

				Seniority seniority = iterator.next();
				result.add(SeniorityDTO.build(seniority));
				
			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}

		return response;
		
	}

}
