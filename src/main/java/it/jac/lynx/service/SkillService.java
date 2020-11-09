package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.jac.lynx.dao.SkillRepository;
import it.jac.lynx.dto.Response;
import it.jac.lynx.dto.SkillDTO;
import it.jac.lynx.entity.Skill;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	public Response<Boolean> createSkill(Skill skill) {
		Response<Boolean> response = new Response<Boolean>();

		try {

			this.skillRepository.save(skill);

			response.setResult(true);

		} catch (Exception e) {

			response.setError("Elemento non creato.");

		}

		return response;

	}

	public Response<String> deleteSkillById(int id) {

		Response<String> response = new Response<String>();

		try {

			this.skillRepository.deleteById(id);

			response.setResult("Skill eliminata.");
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Skill non eliminata correttamente.");

		}

		return response;

	}

	public Response<List<SkillDTO>> findAllSkills() {

		Response<List<SkillDTO>> response = new Response<List<SkillDTO>>();

		List<SkillDTO> result = new ArrayList<>();

		try {

			Iterator<Skill> iterator = this.skillRepository.findAll().iterator();

			while(iterator.hasNext()) {

				Skill skill = iterator.next();
				result.add(SkillDTO.build(skill));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<SkillDTO> findSkillById(int id) {

		Response<SkillDTO> response = new Response<SkillDTO>();

		try {

			Skill skill = this.skillRepository.findById(id).get();

			response.setResult(SkillDTO.build(skill));
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}

		return response;
	}

	public Response<List<SkillDTO>> findSkillByDescription(String description) {

		Response<List<SkillDTO>> response = new Response<List<SkillDTO>>();

		List<SkillDTO> result = new ArrayList<>();

		try {

			Iterator<Skill> iterator = this.skillRepository.findByDescription(description).iterator();
			
			while (iterator.hasNext()) {

				Skill skill = iterator.next();
				result.add(SkillDTO.build(skill));
				
			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}

		return response;
		
	}

	public Response<SkillDTO> updateSkill(int id, String description) {

		Response<SkillDTO> response = new Response<SkillDTO>();

		try {
			
			Skill skill = this.skillRepository.findById(id).get();

			if (description != null)
				skill.setDescription(description);

			this.skillRepository.save(skill);
			
			response.setResult(SkillDTO.build(skill));
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}	

		return response;

	}

}
