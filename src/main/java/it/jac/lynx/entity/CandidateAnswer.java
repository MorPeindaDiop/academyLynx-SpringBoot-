package it.jac.lynx.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "candidateAnswer")
@IdClass(PkCandidateAnswer.class)
@Data
public class CandidateAnswer {

	@Id
	@Column(name = "idCandidate")
	private int idCandidate;
	//private User idUser;

	@Id
	@Column(name = "idQuestion")
	private int idQuestion;
	//private Question idQuestion;

	@Column(name = "answer")
	private boolean answer;

	
	@Override
	public String toString() {
		return "Candidate Answer [id utente=" + idCandidate + ", id question=" + idQuestion + ", answer=" + answer +  "]";
	}
	
	
	
	
}
