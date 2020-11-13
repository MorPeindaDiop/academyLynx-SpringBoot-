package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dao.CandidateSkillRepository;
import it.jac.lynx.dto.CandidateSkillDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.CandidateSkill;
import it.jac.lynx.pk.PkCandidateSkill;

@Service
public class CandidateSkillService {
	
	@Autowired
	private CandidateSkillRepository candidateSkillRepository;

	public Response<Boolean> createCandidateSkill(CandidateSkill candidateSkill) {

		Response<Boolean> response = new Response<Boolean>();

		try {

			this.candidateSkillRepository.save(candidateSkill);

			response.setResult(true);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Skill non creata");

		}

		return response;

	}
	
	
	public Response<String> deleteCandidateSkillById(PkCandidateSkill id) {

		Response<String> response = new Response<String>();

		try {

			this.candidateSkillRepository.deleteById(id);

			response.setResult("Candidato eliminato.");
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Candidato non eliminato correttamente.");

		}

		return response;
	}
	
	
	public Response<List<CandidateSkillDTO>> findAllCandidateSkills() {

		Response<List<CandidateSkillDTO>> response = new Response<List<CandidateSkillDTO>>();

		List<CandidateSkillDTO> result = new ArrayList<>();

		try {

			Iterator<CandidateSkill> iterator = this.candidateSkillRepository.findAll().iterator();

			while(iterator.hasNext()) {

				CandidateSkill candidateSkill = iterator.next();
				result.add(CandidateSkillDTO.build(candidateSkill));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;
	}
	
	public Response<CandidateSkillDTO> findCandidateSkillById(PkCandidateSkill id) {

		Response<CandidateSkillDTO> response = new Response<CandidateSkillDTO>();

		try {

			CandidateSkill candidateSkill = this.candidateSkillRepository.findById(id).get();

			response.setResult(CandidateSkillDTO.build(candidateSkill));
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}
	
	public Response<CandidateSkillDTO> updateCandidateSkill(PkCandidateSkill id, int idSkill) {

		Response<CandidateSkillDTO> response = new Response<CandidateSkillDTO>();

		try {

			CandidateSkill candidateSkill = this.candidateSkillRepository.findById(id).get();

			candidateSkill.setIdSkill(idSkill);

			this.candidateSkillRepository.save(candidateSkill);

			response.setResult(CandidateSkillDTO.build(candidateSkill));
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

}
