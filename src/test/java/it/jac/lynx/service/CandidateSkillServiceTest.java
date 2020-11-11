package it.jac.lynx.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.entity.CandidateSkill;
import it.jac.lynx.pk.PkCandidateSkill;

@SpringBootTest
public class CandidateSkillServiceTest {
	
	@Autowired
	private CandidateSkillService candidateSkillService;
	
	@Test
	public void createCandidateSkillTest() {
		
		CandidateSkill candidateSkill = new CandidateSkill();
		candidateSkill.setIdCandidate(2);
		candidateSkill.setIdSkill(3);
		
		assertEquals(true, candidateSkillService.createCandidateSkill(candidateSkill).isResultTest());
	
	}
	
	@Test 
	public void deleteCandidateSkillByIdQuestionTest() {	
		
			PkCandidateSkill pk = new PkCandidateSkill();
			pk.setIdCandidate(2);
			pk.setIdSkill(3);
			
			assertEquals(true, candidateSkillService.deleteCandidateSkillById(pk).isResultTest());
	
	}
	
	@Test
	public void findAllCandidateSkillsTest() {

		assertEquals(true, candidateSkillService.findAllCandidateSkills().isResultTest());

	}
	
	@Test
	public void findCandidateAnswerByIdTest() {
		
		PkCandidateSkill pk = new PkCandidateSkill();
		pk.setIdCandidate(2);
		pk.setIdSkill(1);

		assertEquals(true, candidateSkillService.findCandidateSkillById(pk).isResultTest());

	}
	
	@Test
	public void updateCandidateSkillTest() {
		
		PkCandidateSkill pk = new PkCandidateSkill();
		pk.setIdCandidate(2);
		pk.setIdSkill(1);

		assertEquals(true, candidateSkillService.updateCandidateSkill(pk, 3).isResultTest());
	
	}

}
