package it.jac.lynx.service;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.entity.Skill;

@SpringBootTest
public class SkillServiceTest {

	@Autowired
	private SkillService skillService;
	
	@Test
	public void createSkillTest() {
		
		Skill skill = new Skill();
		skill.setId(2);
		skill.setDescription("Java");
		
		//skillService.save(skill);
		
		assertEquals(true, skillService.createSkill(skill).getResult());
	}
}