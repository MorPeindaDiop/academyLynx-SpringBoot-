package it.jac.lynx.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.entity.Seniority;


@SpringBootTest
public class SeniorityServiceTest {
	
	@Autowired
	private SeniorityService seniorityService;
	
	@Test
	public void createSeniorityTest() {
		
		Seniority seniority = new Seniority();
		seniority.setDescription("difficile");
		seniority.setMinDifficulty(2);
		seniority.setMaxDifficulty(5);
		
		assertEquals(true, seniorityService.createSeniority(seniority).isResultTest());
	
	}
	
	@Test 
	public void deleteSeniorityByIdTest() {
		
		assertEquals("Seniority eliminata.", seniorityService.deleteSeniorityById(2).getResult());
	
	}
	
	@Test
	public void findAllSenioritiesTest() {
		
		assertEquals(true, seniorityService.findAllSeniorities().isResultTest());
	
	}
	
	@Test
	public void findSeniorityByIdTest() {
		
		assertEquals(true, seniorityService.findSeniorityById(1).isResultTest());
	
	}
	
	@Test
	public void updateSeniorityTest() {
		
		assertEquals(true, seniorityService.updateSeniority(1, "Junior", 1, 2).isResultTest());
	
	}
	
	@Test
	public void findSeniorityByMinDifficultyTest() {
		
		assertEquals(true, seniorityService.findSeniorityByMinDifficuly(1).isResultTest());
	
	}
	
	@Test
	public void findSeniorityByMaxDifficultyTest() {
		
		assertEquals(true, seniorityService.findSeniorityByMaxDifficuly(1).isResultTest());
	
	}
	
	

}
