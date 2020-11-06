package it.jac.lynx.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.entity.CandidateAnswer;
import it.jac.lynx.entity.PkUserAnswer;

@SpringBootTest
public class CandidateAnswerServiceTest {
	
	@Autowired
	private CandidateAnswerService candidateAnswerService;
	
	
	@Test
	public void createCandidateTest() {
		CandidateAnswer candidateAnswer = new CandidateAnswer();
		candidateAnswer.setIdUser(2);
		candidateAnswer.setIdQuestion(1);
		candidateAnswer.setAnswer(true);
		assertEquals(true, candidateAnswerService.createCandidateAnswer(candidateAnswer).isResultTest());
	}
	
	@Test 
	public void deleteCandidateAnswerByIdQuestionTest() {	
			PkUserAnswer pk=new PkUserAnswer();
			pk.setIdQuestion(1);
			pk.setIdUser(2);
			assertEquals("Candidato eliminato.", candidateAnswerService.deleteCandidateAnswerById(pk).getResult());
	}
	
	

}
