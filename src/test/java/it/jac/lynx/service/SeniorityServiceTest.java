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
		assertEquals(true, seniorityService.createSeniority(seniority).isResultTest());
	}
	
	@Test 
	public void deleteSenioritylByIdTest() {
		assertEquals("Seniority eliminata.", seniorityService.deleteSeniorityById(2).getResult());
	}
	
	@Test
	public void findAllSeniorityTest() {
		assertEquals(true, seniorityService.findAllSeniority().isResultTest());
	}
	
	@Test
	public void findSeniorityByIdTest() {
		assertEquals(true, seniorityService.findSeniorityById(1).isResultTest());
	}
	
	@Test
	public void updateSeniorityTest(){
		assertEquals(true, seniorityService.updateSeniority(1, "Junior", 1, 2).isResultTest());
	}
	
	@Test
	public void findSeniorityByMinDifficulty(){
		assertEquals(true, seniorityService.findSeniorityByMinDifficuly(1).isResultTest());
	}
	
	@Test
	public void findSeniorityByMaxDifficulty(){
		assertEquals(true, seniorityService.findSeniorityByMaxDifficuly(1).isResultTest());
	}
	
	

}