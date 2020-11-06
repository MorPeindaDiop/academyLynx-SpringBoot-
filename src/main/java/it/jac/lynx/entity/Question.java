package it.jac.lynx.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@Column(name = "question")
	private String questionText;

	@Column(name = "correctAnswerBoolean")
	private boolean correctAnswerBoolean;

	@Column(name = "correctAnswerText")
	private String correctAnswerText;

	@Column(name = "wrongAnswers")
	private String wrongAnswers;
	//private List<String> wrongAnswers = new ArrayList<>();
	//per le checkbox

	@Column(name = "difficulty")
	private int difficulty;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_time")
	private Date creationTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	private Date updateTime;
	
	@Column(name = "creation_user")
	private String creationUser;
	
	@Column(name = "update_user")
	private String updateUser;
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", question type=" + type + ", question text=" + questionText + ", correct answer=" + (correctAnswerText != "" ? correctAnswerText : correctAnswerBoolean) + ", difficulty=" + difficulty + "]";
	}

}
