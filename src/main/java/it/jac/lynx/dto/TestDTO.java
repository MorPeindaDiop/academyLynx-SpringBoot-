package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.TestQuestion;
import lombok.Data;

@Data
public class TestDTO {
	
	
	private int idTest;
	private int idCandidate;
	
	
	public static TestDTO build(TestQuestion test) {

		TestDTO result = new TestDTO();
		BeanUtils.copyProperties(test, result);

		return result;
	}
}
