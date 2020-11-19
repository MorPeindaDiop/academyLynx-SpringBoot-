package it.jac.lynx.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.entity.Candidate;



@SpringBootTest
public class CandidateServiceTest {

	@Autowired
	private CandidateService candidateService;

	@Test
	public void createCandidateTest() {
		
		Candidate candidate = new Candidate();
		candidate.setName("marco");
		candidate.setSurname("rossi");
		candidate.setDataTest(new Date());
		candidate.setIdSeniority(3);
		candidate.setArithmeticScore(60);
		candidate.setWeightedScore(70);
		candidate.setNCorrectAnswer(6);
		
		
		assertEquals(true, candidateService.createCandidate(candidate).isResultTest());
	
	}

	@Test
	public void updateCandidateTest() {
		
		assertEquals(true, candidateService.updateCandidate(1, "ciao", null, null, 2, 2, 0, 5, 0).isResultTest());
	
	}

	@Test 
	public void deleteCandidateByIdTest() {	
		
		assertEquals("Candidate eliminata.", candidateService.deleteCandidateById(2).getResult());
	
	}

	@Test
	public void findAllCandidateTest() {
		
		assertEquals(true, candidateService.findAllCandidates().isResultTest());
	
	}

	@Test
	public void findCandidateByIdTest() {
		
		assertEquals(true, candidateService.findCandidateById(1).isResultTest());
	
	}

	@Test
	public void findCandidatesByIdSeniority() {
		
		assertEquals(true, candidateService.findCandidatesByIdSeniority(3).isResultTest());
	
	}
	
	@Test
	public void setCandidateScoreAndTimeTest() {
		
		assertEquals(true, candidateService.setCandidateScoreAndTime(2, 0, 0, 0, 1).isResultTest());
	
	}

}
