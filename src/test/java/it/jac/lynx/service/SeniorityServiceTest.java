package it.jac.lynx.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.jac.lynx.entity.Seniority;

public class SeniorityServiceTest {
	
	@Autowired
	private SeniorityService seniorityService;
	
	@Test
	public void createSeniorityTest() {
		
		Seniority seniority = new Seniority();
		seniority.setId(2);
		seniority.setDescription("medio");
		
		assertEquals(true, seniorityService.createSeniority(seniority).isResultTest());
	}
	

}
