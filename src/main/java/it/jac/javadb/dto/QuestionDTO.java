package it.jac.javadb.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import it.jac.javadb.entity.Question;
import it.jac.javadb.entity.Seniority;

public class QuestionDTO {

	private int id;

	private Seniority idSeniority;

	private String type;
	//tipo di domanda, se crocette, aperta, ecc

	private String question;

	private boolean correctAnswerBoolean;

	private String correctAnswerText;

	private List<String> wrongAnswers = new ArrayList<>();
	//per le checkbox

	private int difficulty;

	private Date creationTime;

	private Date updateTime;

	private String creationUser;

	private String updateUser;

	public static QuestionDTO build(Question question) {

		QuestionDTO result = new QuestionDTO();
		BeanUtils.copyProperties(question, result);

		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Seniority getIdSeniority() {
		return idSeniority;
	}

	public void setIdSeniority(Seniority idSeniority) {
		this.idSeniority = idSeniority;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isCorrectAnswerBoolean() {
		return correctAnswerBoolean;
	}

	public void setCorrectAnswerBoolean(boolean correctAnswerBoolean) {
		this.correctAnswerBoolean = correctAnswerBoolean;
	}

	public String getCorrectAnswerText() {
		return correctAnswerText;
	}

	public void setCorrectAnswerText(String correctAnswerText) {
		this.correctAnswerText = correctAnswerText;
	}

	public List<String> getWrongAnswers() {
		return wrongAnswers;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public void setWrongAnswers(List<String> wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
