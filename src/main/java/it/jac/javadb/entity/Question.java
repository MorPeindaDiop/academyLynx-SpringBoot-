package it.jac.javadb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idSeniority")
	private Seniority idSeniority;

	@Column(name = "type")
	private String type;

	@Column(name = "question")
	private String question;

	@Column(name = "correctAnswerBoolean")
	private boolean correctAnswerBoolean;

	@Column(name = "correctAnswerText")
	private String correctAnswerText;

	@Column(name = "wrongAnswer")
	private List<String> wrongAnswers = new ArrayList<>();
	//per le checkbox

	@Column(name = "score")
	private int score;

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
		return "Question [id=" + id + ", question type=" + type + ", question text=" + question + ", correct answer=" + (correctAnswerText != "" ? correctAnswerText : correctAnswerBoolean) + ", score=" + score + "]";
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

	public List<String> getWrongAnswer() {
		return wrongAnswers;
	}

	public void setWrongAnswer(List<String> wrongAnswer) {
		this.wrongAnswers = wrongAnswer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
