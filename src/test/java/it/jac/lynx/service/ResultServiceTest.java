package it.jac.lynx.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.dto.CandidateResponseDTO;

@SpringBootTest
public class ResultServiceTest {
	
	@Autowired
	private ResultService resultService;
	
	@Test
	public void findCandidateMathScoreTest() {
		CandidateResponseDTO candidateResponseDTO=new CandidateResponseDTO();
		CandidateResponseDTO candidateResponseDTO2=new CandidateResponseDTO();
		
		candidateResponseDTO.setIdQuestion(3);
		candidateResponseDTO2.setIdQuestion(4);
		candidateResponseDTO.setCandidateResponse("5");
		candidateResponseDTO2.setCandidateResponse("12");
		
		List<CandidateResponseDTO> lista=new ArrayList<CandidateResponseDTO>();
		
		lista.add(candidateResponseDTO);
		lista.add(candidateResponseDTO2);
		assertEquals(true, resultService.setCandidateResponse(lista).isResultTest());
	
	}
	
//	
//	@Test
//	public void findAllCandidateAnswersById() {
//		int id=1;
//		assertEquals(true, resultService.findAllCandidateAnswersById(id).isResultTest());
//	}
}
