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

import it.jac.javadb.dao.ProdottoRepository;
import it.jac.javadb.dao.UserActivityRepository;
import it.jac.javadb.dto.ProdottoDTO;
import it.jac.javadb.entity.Prodotto;
import it.jac.javadb.entity.UserActivity;

//Annotazione che indica a spring che questo bean è un service
@Service
public class ProdottoService {

	private static final Logger log = LogManager.getLogger(ProdottoService.class);

	@Autowired
	private ProdottoRepository repository;
	/* @Autoweird è l'annotazione utilizzata da spring per creare i vari collegamenti tra tutti
	 * gli oggetti del nostro applicativo.
	 * in questo caso crea il primo collegamento alla Repository, quello con il service
	 * che richiama i vari metodi presenti, nel nostro caso, nel CrudRepository
	 */

	@Autowired
	private UserActivityRepository userActivityRepository;


	public String testConnessione() {

		log.info("Test connessione");

		boolean test = this.repository.testConnection();
		if (test) {
			log.info("Test OK");
		}
		return test ? "ok" : "ko";
	}

	public List<ProdottoDTO> findAll(String username) {

		log.info("Tutti i prodotti");
		List<ProdottoDTO> result = new ArrayList<>();
		//creiao un Array nel quale poi aggiungiamo ogni riga rilevata dal nostro db

		Iterator<Prodotto> iterator = this.repository.findAll().iterator();
		while(iterator.hasNext()) {

			Prodotto prodotto = iterator.next();
			result.add(ProdottoDTO.build(prodotto));
		}

		//User activity
		String descrizione = "Richiesta lista di tutti i prodotti";
		attivitaUtente(username, descrizione);

		return result;
	}

	public ProdottoDTO findProdottoById(Integer id, String username) {

		log.info("Trova prodotto attraverso Id");
		Prodotto entity = this.repository.findById(id).get();

		//User activity
		String descrizione = "Richiesto dettaglio prodotto con id: " + id;
		attivitaUtente(username, descrizione);

		return ProdottoDTO.build(entity);
	}

	//metodo utilizzato all'interno dei metodi di modifica/delete
	public ProdottoDTO findProdottoById(Integer id) {

		log.info("Trova prodotto attraverso Id");
		Prodotto entity = this.repository.findById(id).get();

		return ProdottoDTO.build(entity);
	}

	/* Con l'annotazione Transactionl possiamo stabilire se bloccare o meno l'autocommit
	 * dopo ogni richiesta di operazione. In questo caso lasciamo ogni operazione in sospeso
	 * fino a che tutte avranno risposta 'ok', in quel caso verrà eseguito il commit, in alternativa
	 * se anche solo un'operazione darà 'ko', verrà eseguito il rollback.
	 * Queste vengono chiamate operazioni atomiche.
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void creaProdotto(Prodotto prod) {

		this.repository.save(prod);

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

		Prodotto prod = this.repository.findById(id).get();

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

		this.repository.save(prod);

		//User activity
		String descrizione = "Modificato prodotto con id: " + prod.getId();
		attivitaUtente(updateUser, descrizione, updateTime);
		
	}

	public void deleteProdotto(int id, String username) {

		this.repository.delete(this.repository.findById(id).get());

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
