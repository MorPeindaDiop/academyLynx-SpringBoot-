package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dao.CandidateAnswerRepository;
import it.jac.lynx.dao.CandidateRepository;
import it.jac.lynx.dao.CandidateSkillRepository;
import it.jac.lynx.dto.CandidateDTO;
import it.jac.lynx.dto.Response;

import it.jac.lynx.entity.Candidate;
import it.jac.lynx.entity.CandidateAnswer;
import it.jac.lynx.entity.CandidateSkill;


@Service
public class CandidateService {
	
	private static Logger log = LoggerFactory.getLogger(CandidateService.class);
	
	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private CandidateAnswerRepository candidateAnswerRepository;
	
	@Autowired
	private CandidateSkillRepository candidateSkillRepository;
	
	public Response<Candidate> createCandidate(Candidate candidate) {

		Response<Candidate> response = new Response<Candidate>();

		try {

			this.candidateRepository.save(candidate);

			response.setResult(candidate);
			response.setResultTest(true);

		}catch(Exception e) {

			response.setError("Candidato non creato");

		}

		return response;

	}


	public Response<String> deleteCandidateById(int id) {

		Response<String> response = new Response<String>();
		
		List<CandidateAnswer> candidateAnswers = new ArrayList<CandidateAnswer>();
		
		List<CandidateSkill> candidateSkills = new ArrayList<CandidateSkill>();

		try {

			candidateAnswers = this.candidateAnswerRepository.findByIdCandidate(id);
			if (candidateAnswers != null) {
				
				for (CandidateAnswer ca: candidateAnswers) {
					
					this.candidateAnswerRepository.delete(ca);
					
				}
				
			}
			
			candidateSkills = this.candidateSkillRepository.findByIdCandidate(id);
			if (candidateSkills != null) {
				
				for (CandidateSkill cs: candidateSkills) {
					
					this.candidateSkillRepository.delete(cs);
					
				}
				
			}
			
			this.candidateRepository.deleteById(id);			

			response.setResult("Candidato eliminato.");
			response.setResultTest(true);

		}catch(Exception e){

			response.setError("Candidato non eliminato correttamente.");

		}

		return response;

	}


	public Response<List<CandidateDTO>> findAllCandidates() {

		Response<List<CandidateDTO>> response = new Response<List<CandidateDTO>>();

		List<CandidateDTO> result = new ArrayList<>();

		try {

			Iterator<Candidate> iterator = this.candidateRepository.findAll().iterator();

			while(iterator.hasNext()) {

				Candidate candidate = iterator.next();
				result.add(CandidateDTO.build(candidate));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<CandidateDTO> findCandidateById(int id) {

		Response<CandidateDTO> response = new Response<CandidateDTO>();


		try {

			Candidate candidate = this.candidateRepository.findById(id).get();

			response.setResult(CandidateDTO.build(candidate));
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}

		return response;
		
	}

	public Response<CandidateDTO> updateCandidate(
			int id,
			String name,
			String surname,
			Date dataTest,
			int idSeniority,
			int nCorrectAnswer,
			int weightedScore,
			int arithmeticScore,
			int time) {

		Response<CandidateDTO> response = new Response<CandidateDTO>();

		try {
			Candidate candidate = this.candidateRepository.findById(id).get();

			if (name != null)
				candidate.setName(name);
			
			if (surname != null)
				candidate.setSurname(surname);
			
			if (dataTest != null)
				candidate.setDataTest(dataTest);
			
			if (idSeniority > 0)
				candidate.setIdSeniority(idSeniority);
			
			if (nCorrectAnswer > 0)
				candidate.setNCorrectAnswer(nCorrectAnswer);
			
			if (weightedScore > 0)
				candidate.setWeightedScore(weightedScore);
			
			if (arithmeticScore > 0)
				candidate.setArithmeticScore(arithmeticScore);
			
			if (time > 0)
				candidate.setTime(time);

			this.candidateRepository.save(candidate);
			
			response.setResult(CandidateDTO.build(candidate));
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}	

		return response;

	}


	public Response<List<CandidateDTO>> findCandidatesByIdSeniority(int seniority) {

		Response<List<CandidateDTO>> response = new Response<List<CandidateDTO>>();
		
		List<CandidateDTO> result = new ArrayList<>();

		try {
			
			Iterator<Candidate> iterator = this.candidateRepository.findByidSeniority(seniority).iterator();
			
			while(iterator.hasNext()) {

				Candidate candidate = iterator.next();
				result.add(CandidateDTO.build(candidate));
				
			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e ) {
			
			response.setError("Nessun elemento trovato.");
			
		}

		return response;
		
	}
	
	public Response<CandidateDTO> setCandidateScoreAndTime(
			int id,
			int nCorrectAnswer,
			int weightedScore,
			int arithmeticScore,
			int time) {
		
		log.info("PRIMO STEP DEL METODO");
		Response<CandidateDTO> response = new Response<CandidateDTO>();

		try {
			
			log.info("ENTRA NEL TRY");
			log.info("id "+id);
			log.info("n correct answer "+nCorrectAnswer);
			log.info("weightedScore "+weightedScore);
			log.info("arithmeticScore "+arithmeticScore);
			log.info("time "+time);
			
			Candidate candidate = this.candidateRepository.findById(id).get();
			log.info("TROVA CANDIDATO DA CANDIDATE REPOSITORY");
			if (nCorrectAnswer > 0)
				candidate.setNCorrectAnswer(nCorrectAnswer);
			
			if (weightedScore > 0)
				candidate.setWeightedScore(weightedScore);
			
			if (arithmeticScore > 0)
				candidate.setArithmeticScore(arithmeticScore);
			
			if (time > 0) {	
				log.info("ENTRA IN TIME");
				Calendar c = Calendar.getInstance();
				double millsTime=c.getTime().getMinutes();
				log.info("MILLIS: "+millsTime);
				long testStart=candidate.getDataTest().getMinutes();
				log.info("TEST START: "+testStart);
				int effecctiveTime=(int)(testStart-millsTime);
				log.info("EFFECTIVE TIME: "+effecctiveTime);
				candidate.setTime(effecctiveTime);
			}
				
			
			this.candidateRepository.save(candidate);
			log.info("CANDIDATE SALVATO NELLA REPOSITORY");
			response.setResult(CandidateDTO.build(candidate));
			log.info("CANDIDATO SALVATO IN DTO");
			response.setResultTest(true);
			log.info("RISULTATO SETTATO A TRUE");
		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}	

		return response;

	}

}
