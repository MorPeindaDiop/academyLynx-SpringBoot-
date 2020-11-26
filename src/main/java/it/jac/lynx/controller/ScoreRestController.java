package it.jac.lynx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.Response;
import it.jac.lynx.service.ScoreService;

@RestController
@RequestMapping("/rest/score")
public class ScoreRestController {
	
	private static Logger log = LoggerFactory.getLogger(ScoreRestController.class);
	
	@Autowired
	private ScoreService scoreService;
	
	@GetMapping(path = "/createScore")
	public Response<?> createCandidateScore(@RequestParam int idCandidate) {
		
		return scoreService.setScoreCandidate(idCandidate);
		
	}
}
