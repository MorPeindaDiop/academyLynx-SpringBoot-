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

		}catch(Exception e) {
			response.setError("Seniority non creata");
		}

		return null;
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

	public Response<List<SeniorityDTO>> findAllSkills() {

		Response<List<SeniorityDTO>> response = new Response<List<SeniorityDTO>>();

		List<SeniorityDTO> result = new ArrayList<>();

		try {
			Iterator<Seniority> iterator = this.seniorityRepository.findAll().iterator();
			while(iterator.hasNext()) {

				Seniority skill = iterator.next();
				result.add(SeniorityDTO.build(skill));
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

		Optional<Seniority> skill = this.seniorityRepository.findById(id);
		try {
			if (skill.isPresent()) {
				response.setResult(SeniorityDTO.build(skill.get()));
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

				Seniority skill = iterator.next();
				result.add(SeniorityDTO.build(skill));
			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e ) {
			response.setError("Nessun elemento trovato.");
		}

		return response;
	}




	public Response<SeniorityDTO> updateSkill(int id, String description) {

		Response<SeniorityDTO> response = new Response<SeniorityDTO>();

		try {
			Seniority skill = this.seniorityRepository.findById(id).get();

			if (description != null)
				skill.setDescription(description);

			this.seniorityRepository.save(skill);
			response.setResult(SeniorityDTO.build(skill));
			response.setResultTest(true);

		}catch (Exception e){
			response.setError("Nessun elemento trovato.");
		}	

		return response;


	}
	
	
	
	
	


}
