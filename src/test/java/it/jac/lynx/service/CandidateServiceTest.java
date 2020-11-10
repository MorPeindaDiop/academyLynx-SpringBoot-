package it.jac.lynx.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.mockito.internal.util.reflection.Fields;
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
		candidate.setName("pippo");
		candidate.setSurname("pluto");
		candidate.setDataTest(new Date());
		candidate.setIdSeniority(3);
		
		assertEquals(true, candidateService.createCandidate(candidate).isResultTest());
	
	}

	@Test
	public void updateCandidateTest() {
		
		assertEquals(true, candidateService.updateCandidate(1, "ciao", null, null, 2, 0, 0).isResultTest());
	
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
		
		assertEquals(true, candidateService.setCandidateScoreAndTime(1, 150, 20).isResultTest());
	
	}
	
	@Test
	public void createCandidateTest1() {
		
		Candidate candidate = new Candidate();
		candidate.setName("Andrea");
		candidate.setSurname("pluto");
		candidate.setDataTest(new Date());
		candidate.setIdSeniority(3);
		
		Field field=new Field();
		field.setEnabled(false);
		field.setFieldName("campo1");
		field.setId(4);
		field.setPage("index.html");
		field.setReg_exp("A-Za-z");
		
		HashMap<Field, String> campi = new HashMap<>();
		campi.put(field, "ciao");
		
		candidate.setFields(campi);
		
		
		assertEquals(true, candidateService.createCandidate(candidate).isResultTest());
	
	}

}
