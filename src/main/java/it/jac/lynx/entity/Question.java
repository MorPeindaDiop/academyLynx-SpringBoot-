package it.jac.lynx.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "question")
@Data
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "type")
	private String type;

	@Column(name = "questionText")
	private String questionText;

	@Column(name = "correct_answer_boolean")
	private Boolean correctAnswerBoolean;

	@Column(name = "correct_answer_text")
	private String correctAnswerText;

	@Column(name = "wrong_answers")
	private String wrongAnswers;

	@Column(name = "difficulty")
	private int difficulty;	
	
	@Column(name = "img_url")
	private String imgUrl;
	
	@Column(name = "id_skill")
	private int idSkill;
	
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", question type=" + type + ", question text=" + questionText + ", correct answer=" + (correctAnswerText != "" ? correctAnswerText : correctAnswerBoolean) + ", difficulty=" + difficulty + "]";
	}

}
