package it.jac.lynx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.jac.lynx.dao.SkillRepository;
import it.jac.lynx.dto.Response;
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
		}catch(Exception e){
			response.setError("Skill non eliminata correttamente.");
		}
		return response;
		
	}

}
