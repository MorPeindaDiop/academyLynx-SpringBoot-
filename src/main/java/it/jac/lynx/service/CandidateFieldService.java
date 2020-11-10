package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dao.CandidateFieldRepository;
import it.jac.lynx.dto.CandidateFieldDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.CandidateField;
import it.jac.lynx.pk.PkCandidateField;

@Service
public class CandidateFieldService {

	@Autowired
	private CandidateFieldRepository candidateFieldRepository;

	public Response<Boolean> createCandidateField(CandidateField candidateField) {

		Response<Boolean> response = new Response<Boolean>();

		try {

			this.candidateFieldRepository.save(candidateField);

			response.setResult(true);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Answer non creata");

		}

		return response;

	}

	public Response<String> deleteCandidateFieldById(PkCandidateField id) {

		Response<String> response = new Response<String>();

		try {

			this.candidateFieldRepository.deleteById(id);

			response.setResult("Candidato eliminato.");
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Candidato non eliminato correttamente.");

		}

		return response;

	}


	public Response<List<CandidateFieldDTO>> findAllCandidateFields() {

		Response<List<CandidateFieldDTO>> response = new Response<List<CandidateFieldDTO>>();

		List<CandidateFieldDTO> result = new ArrayList<>();

		try {

			Iterator<CandidateField> iterator = this.candidateFieldRepository.findAll().iterator();

			while(iterator.hasNext()) {

				CandidateField candidateField = iterator.next();
				result.add(CandidateFieldDTO.build(candidateField));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<CandidateFieldDTO> findCandidateFieldById(PkCandidateField id) {

		Response<CandidateFieldDTO> response = new Response<CandidateFieldDTO>();

		try {

			CandidateField candidateField = this.candidateFieldRepository.findById(id).get();

			response.setResult(CandidateFieldDTO.build(candidateField));
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<CandidateFieldDTO> updateCandidateField(PkCandidateField id, String value) {

		Response<CandidateFieldDTO> response = new Response<CandidateFieldDTO>();

		try {

			CandidateField candidateField = this.candidateFieldRepository.findById(id).get();

			if (value != null)
				candidateField.setValue(value);

			this.candidateFieldRepository.save(candidateField);

			response.setResult(CandidateFieldDTO.build(candidateField));
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}
}
