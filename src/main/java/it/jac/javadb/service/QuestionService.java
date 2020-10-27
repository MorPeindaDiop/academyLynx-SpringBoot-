package it.jac.javadb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import it.jac.javadb.dao.QuestionRepository;
import it.jac.javadb.dao.SeniorityRepository;
import it.jac.javadb.dao.UserActivityRepository;
import it.jac.javadb.dto.QuestionDTO;
import it.jac.javadb.entity.Question;
import it.jac.javadb.entity.Seniority;
import it.jac.javadb.entity.UserActivity;

@Service
public class QuestionService {

	private static final Logger log = LogManager.getLogger(QuestionService.class);

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private SeniorityRepository seniorityRepository;

	@Autowired
	private UserActivityRepository userActivityRepository;


	/*public List<QuestionDTO> findAll(String username) {

		log.info("Tutti i prodotti");
		List<QuestionDTO> result = new ArrayList<>();

		Iterator<Question> iterator = this.questionRepository.findAll().iterator();
		while(iterator.hasNext()) {

			Question prodotto = iterator.next();
			result.add(QuestionDTO.build(prodotto));
		}

		//User activity
		String descrizione = "Richiesta lista di tutti i prodotti";
		attivitaUtente(username, descrizione);

		return result;
	}*/

	public List<QuestionDTO> findAll() {

		log.info("Tutte le domande");
		List<QuestionDTO> result = new ArrayList<>();

		Iterator<Question> iterator = this.questionRepository.findAll().iterator();
		while(iterator.hasNext()) {

			Question question = iterator.next();
			result.add(QuestionDTO.build(question));
		}

		return result;
	}

	public QuestionDTO findQuestionById(Integer id) {

		log.info("Trova question attraverso Id");
		Question question = this.questionRepository.findById(id).get();

		return QuestionDTO.build(question);
	}
	
	public List<QuestionDTO> findQuestionByIdSeniority(Seniority idSeniority) {

		log.info("Tutte le domande tramite Id Seniority");
		List<QuestionDTO> result = new ArrayList<>();
		
		//Question question = this.questionRepository.findById(idSeniority).get();
		
		Iterator<Question> iterator = this.questionRepository.findByIdSeniority(idSeniority).iterator();
		while(iterator.hasNext()) {

			Question question = iterator.next();
			result.add(QuestionDTO.build(question));
		}

		return result;
	}
	
	public QuestionDTO findQuestionByType(String type) {

		log.info("Trova question attraverso Id");
		Question questionType = this.questionRepository.findByType(type).get;

		return QuestionDTO.build(question);
	}
	

	@Transactional(propagation = Propagation.REQUIRED)
	public void creaProdotto(Question prod) {

		this.questionRepository.save(prod);

		//User activity
		String descrizione = "Inserito prodotto con id: " + prod.getId();
		attivitaUtente(prod.getCreationUser(), descrizione, prod.getCreationTime());

	}

	public void modificaProdotto(
			int id,
			String codProd,
			Integer prezzo,
			Date dataArr,
			Date updateTime,
			String updateUser) {

		Question prod = this.questionRepository.findById(id).get();

		if (codProd != null)
			prod.setCodProd(codProd);

		if (prezzo != null)
			prod.setPrezzo(prezzo);

		if (dataArr != null)
			prod.setDataArr(dataArr);

		//Se non è stata apportata alcuna modifica, non modifica gli attibuti updateTime e updateUser
		if (codProd != null || prezzo != null || dataArr != null) {
			prod.setUpdateTime(updateTime);
			prod.setUpdateUser(updateUser);
		}

		this.questionRepository.save(prod);

		//User activity
		String descrizione = "Modificato prodotto con id: " + prod.getId();
		attivitaUtente(updateUser, descrizione, updateTime);

	}

	public void deleteProdotto(int id, String username) {

		this.questionRepository.delete(this.questionRepository.findById(id).get());

		//User activity
		String descrizione = "Eliminato prodotto con id: " + id;
		attivitaUtente(username, descrizione);

	}

	//metodi per inserire le informazioni nella tabella user_activity
	//senza data come parametro
	private UserActivity attivitaUtente(String username, String descrizione) {
		UserActivity attivitaUtente = new UserActivity();
		attivitaUtente.setUsername(username);
		attivitaUtente.setActivityDesc(descrizione);
		attivitaUtente.setActivityTime(new Date());

		log.info("Aggiunta attività nella tabella user_activity");

		return this.userActivityRepository.save(attivitaUtente);
	}

	//con data come parametro
	private UserActivity attivitaUtente(String username, String descrizione, Date data) {
		UserActivity attivitaUtente = new UserActivity();
		attivitaUtente.setUsername(username);
		attivitaUtente.setActivityDesc(descrizione);
		attivitaUtente.setActivityTime(data);

		log.info("Aggiunta attività nella tabella user_activity");

		return this.userActivityRepository.save(attivitaUtente);
	}

}
