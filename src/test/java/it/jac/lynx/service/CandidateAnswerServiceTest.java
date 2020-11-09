package it.jac.lynx.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.entity.CandidateAnswer;
import it.jac.lynx.entity.PkCandidateAnswer;

@SpringBootTest
public class CandidateAnswerServiceTest {

	@Autowired
	private CandidateAnswerService candidateAnswerService;


	@Test
	public void createCandidateTest() {

		CandidateAnswer candidateAnswer = new CandidateAnswer();
		candidateAnswer.setIdCandidate(2);
		candidateAnswer.setIdQuestion(1);
		candidateAnswer.setAnswer(true);

		assertEquals(true, candidateAnswerService.createCandidateAnswer(candidateAnswer).isResultTest());

	}

	@Test 
	public void deleteCandidateAnswerByIdQuestionTest() {

		PkCandidateAnswer pk = new PkCandidateAnswer();
		pk.setIdQuestion(1);
		pk.setIdCandidate(2);

		assertEquals("Candidato eliminato.", candidateAnswerService.deleteCandidateAnswerById(pk).getResult());

	}

	@Test
	public void findAllCandidateAnswersTest() {

		assertEquals(true, candidateAnswerService.findAllCandidateAnswers().getResult());

	}
	
	@Test
	public void findCandidateAnswerByIdTest() {
		
		PkCandidateAnswer pk = new PkCandidateAnswer();
		pk.setIdQuestion(1);
		pk.setIdCandidate(2);

		assertEquals(true, candidateAnswerService.findCandidateAnswerById(pk).getResult());

	}
	
	@Test
	public void updateCandidateAnswerTest() {
		
		PkCandidateAnswer pk = new PkCandidateAnswer();
		pk.setIdQuestion(1);
		pk.setIdCandidate(2);

		assertEquals(true, candidateAnswerService.updateCandidateAnswer(pk, false).getResult());
	
	}

}
