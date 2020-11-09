package it.jac.lynx.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.entity.CandidateSkill;
import it.jac.lynx.entity.PkCandidateSkill;

@SpringBootTest
public class CandidateSkillServiceTest {
	
	@Autowired
	private CandidateSkillService candidateSkillService;
	
	
	@Test
	public void createCandidateTest() {
		CandidateSkill candidateSkill = new CandidateSkill();
		candidateSkill.setIdUser(2);
		candidateSkill.setIdSkill(3);
		assertEquals(true, candidateSkillService.createCandidateSkill(candidateSkill).isResultTest());
	}
	
	@Test 
	public void deleteCandidateAnswerByIdQuestionTest() {	
			PkCandidateSkill pk=new PkCandidateSkill();
			pk.setIdUser(2);
			pk.setIdUser(3);
			assertEquals("Candidato eliminato.", candidateSkillService.deleteCandidateSkillById(pk).getResult());
	}
	
	

}
