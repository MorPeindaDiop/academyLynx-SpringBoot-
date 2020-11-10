package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dao.FieldRepository;
import it.jac.lynx.dto.FieldDTO;
import it.jac.lynx.dto.Response;

import it.jac.lynx.entity.Field;


@Service
public class FieldService {

	@Autowired
	private FieldRepository fieldRepository;

	public Response<Boolean> createField(Field field) {

		Response<Boolean> response = new Response<Boolean>();

		try {

			this.fieldRepository.save(field);

			response.setResult(true);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Field non creato");

		}

		return response;

	}


	public Response<String> deleteFieldById(int id) {

		Response<String> response = new Response<String>();

		try {

			this.fieldRepository.deleteById(id);

			response.setResult("Field eliminato.");
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Field non eliminato correttamente.");

		}

		return response;

	}


	public Response<List<FieldDTO>> findAllFields() {

		Response<List<FieldDTO>> response = new Response<List<FieldDTO>>();

		List<FieldDTO> result = new ArrayList<>();

		try {

			Iterator<Field> iterator = this.fieldRepository.findAll().iterator();

			while(iterator.hasNext()) {

				Field field = iterator.next();
				result.add(FieldDTO.build(field));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<FieldDTO> findFieldById(int id) {

		Response<FieldDTO> response = new Response<FieldDTO>();


		try {

			Field field = this.fieldRepository.findById(id).get();

			response.setResult(FieldDTO.build(field));
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}

		return response;
		
	}

	public Response<FieldDTO> updateField(
			int id,
			String page,
			String fieldName,
			String reg_exp,
			boolean enabled) {

		Response<FieldDTO> response = new Response<FieldDTO>();

		try {
			Field field = this.fieldRepository.findById(id).get();

			if (page != null)
				field.setPage(page);
			
			if (fieldName != null)
				field.setFieldName(fieldName);
			
			if (reg_exp != null)
				field.setReg_exp(reg_exp);
			
			if (enabled != field.isEnabled())
				field.setEnabled(enabled);
			
			this.fieldRepository.save(field);
			
			response.setResult(FieldDTO.build(field));
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}	

		return response;

	}
	
}
