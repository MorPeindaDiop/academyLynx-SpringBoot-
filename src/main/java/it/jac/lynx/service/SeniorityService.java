package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import it.jac.lynx.dao.SeniorityRepository;
import it.jac.lynx.dto.Response;
import it.jac.lynx.dto.SeniorityDTO;

import it.jac.lynx.entity.Seniority;


public class SeniorityService {

	@Autowired
	private SeniorityRepository seniorityRepository;


	public Response<Boolean> createSeniority(Seniority seniority){

		Response<Boolean> response=new Response<Boolean>();

		try {
			this.seniorityRepository.save(seniority);
			response.setResult(true);
			response.setResultTest(true);

		}catch(Exception e) {
			response.setError("Seniority non creata");
		}

		return response;
	}

	public Response<String> deleteSeniorityById(int id) {
		Response<String> response = new Response<String>();
		try {
			this.seniorityRepository.deleteById(id);
			response.setResult("Skill eliminata.");
			response.setResultTest(true);
		}catch(Exception e){
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

		Optional<Seniority> seniority = this.seniorityRepository.findById(id);
		try {
			if (seniority.isPresent()) {
				response.setResult(SeniorityDTO.build(seniority.get()));
				response.setResultTest(true);
			}

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

		} catch (Exception e ) {
			response.setError("Nessun elemento trovato.");
		}

		return response;
	}




	public Response<SeniorityDTO> updateSeniorityDescription(int id, String description) {

		Response<SeniorityDTO> response = new Response<SeniorityDTO>();

		try {
			Seniority seniority = this.seniorityRepository.findById(id).get();

			if (description != null)
				seniority.setDescription(description);

			this.seniorityRepository.save(seniority);
			response.setResult(SeniorityDTO.build(seniority));
			response.setResultTest(true);

		}catch (Exception e){
			response.setError("Nessun elemento trovato.");
		}	

		return response;


	}
	
	//da qua 
	public Response<List<SeniorityDTO>> findSeniorityByMinDifficuly(int difficulty) {

		Response<List<SeniorityDTO>> response = new Response<List<SeniorityDTO>>();

		List<SeniorityDTO> result = new ArrayList<>();

		try {

			Iterator<Seniority> iterator = this.seniorityRepository.findByMinDifficulty(difficulty).iterator();
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

		} catch (Exception e ) {
			response.setError("Nessun elemento trovato.");
		}

		return response;
	}

	
	
	
	
	


}
