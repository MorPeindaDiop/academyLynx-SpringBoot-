package it.jac.lynx.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Question;
import lombok.Data;

@Data
public class QuestionDTO {

	private int id;

	private String type;
	//tipo di domanda, se crocette, aperta, ecc

	private String questionText;

	private Boolean correctAnswerBoolean;

	private String correctAnswerText;

	private String wrongAnswers;
	//per le checkbox

	private int difficulty;
	
	private String imgUrl;
	
	private int idSkill;

	public static QuestionDTO build(Question question) {

		QuestionDTO result = new QuestionDTO();
		BeanUtils.copyProperties(question, result);

		return result;
	}

}
