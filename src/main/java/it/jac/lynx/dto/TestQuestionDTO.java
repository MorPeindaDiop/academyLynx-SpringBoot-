package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.TestQuestion;
import lombok.Data;

@Data
public class TestQuestionDTO {
	
	
	private int idTest;
	private int idCandidate;
	
	
	public static TestQuestionDTO build(TestQuestion test) {

		TestQuestionDTO result = new TestQuestionDTO();
		BeanUtils.copyProperties(test, result);

		return result;
	}
}
