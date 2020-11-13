package it.jac.lynx.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.dto.CandidateResponseDTO;

@SpringBootTest
public class ScoreServiceTest {

	@Autowired
	private ScoreService scoreService;
	
	@Test
	public void setCandidateResponseTest() {
		
		CandidateResponseDTO candidateResponse = new CandidateResponseDTO();
		candidateResponse.setIdQuestion(1);
		candidateResponse.setCandidateResponse("hola");
		
		CandidateResponseDTO candidateResponse2 = new CandidateResponseDTO();
		candidateResponse2.setIdQuestion(2);
		candidateResponse2.setCandidateResponse("hola");
		
		List<CandidateResponseDTO> lista = new ArrayList<CandidateResponseDTO>();
		lista.add(candidateResponse);
		lista.add(candidateResponse2);
		
		assertEquals(true, scoreService.setCandidateResponse(lista, 1).isResultTest());
	
	}
	
	@Test
	public void setScoreCandidateTest() {
		
		assertEquals(true, scoreService.setScoreCandidate(1).isResultTest());
	
	}
	
}
