package it.jac.javadb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import it.jac.javadb.dto.ResponseMessage;
import it.jac.javadb.dto.QuestionDTO;
import it.jac.javadb.entity.Question;
import it.jac.javadb.service.QuestionService;
import it.jac.javadb.util.JwtTokenUtil;

/* Annotazione che indica a spring che questo bean è di tipo RestController
 * accessibile dal path localhost:8080/esame/rest
 * la prima parte del path è stato impostato nel file application.properties
 */
@RestController
@RequestMapping("/rest")
@Secured("ROLE_USER")
public class ProductRestController {

	private static Logger log = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	// Il repository comunica con il service, che a sua volta comunica con il controller
	//sempre con l'Autowired creiamo questo legame tra service e controller
	@Autowired
	private QuestionService service;
	
	//metodo per rilevare l'utente dal token di autenticazione
	private String getUsername(HttpServletRequest req) {
		final String requestTokenHeader = req.getHeader("Authorization");
		String jwtToken = requestTokenHeader.substring("Bearer ".length());
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		
		return username;
	}

	//@Secured --> autorizzazione ulteriore ad una serie di API, perchè una volta che sei loggato e va tutto bene
	//non è detto che si possa fare tutto nell'applicativo
	//si assegnano dei ruoli all'utente
	//quindi per fare questa operazione vi è bisogno di avere quel ruolo come utente

	//i path inseriti all'inizio di ogni richiesta saranno da aggiungere a quello principale
	//localhost:8080/esame/rest
	@GetMapping(path = "/allProducts")
	public ResponseEntity<List<QuestionDTO>> allProducts(HttpServletRequest req) {

		log.info("Ricevuta richiesta della lista di tutti i prodotti");

		String username = getUsername(req);
		log.info("Rilevato utente che ha eseguito la richiesta");
		
		List<QuestionDTO> prodotto = service.findAll(username);

		if (prodotto == null) {
			log.info("Lista prodotti vuota");
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(prodotto);
	}

	@GetMapping(path = "/detail/{id}")
	public ResponseEntity<QuestionDTO> detail(@PathVariable(name = "id") Integer id, HttpServletRequest req) {
		//con l'annotazione @PathVarible indichiamo che quel parametro del metono deve essere preso dall'url

		log.info("Ricevuta richiesta di dettaglio di un prodotto");
		
		log.info("Rilevato utente che ha eseguito la richiesta di dettaglio");

		QuestionDTO prodotto = service.findQuestionById(id, getUsername(req));

		if (prodotto == null) {
			log.info("Nessun prodotto con id = " + id + " rilevato");
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(prodotto);
	}

	@PostMapping("/create")
	@Secured("ROLE_EDIT")
	public ResponseEntity<ResponseMessage> createDocumento(
			@RequestParam String codProd,
			@RequestParam int prezzo,
			@RequestParam Date dataArr,
			HttpServletRequest req) {
		//con l'annotazione @RequestParam indichiamo che quel parametro deve essere passato come parametro nell'url, 
		//con l'utilizzo dei query params, ad esempio-->create?codProd=ciao

		log.info("Ricevuta richiesta di creazione nuovo prodotto");

		log.info("Rilevato utente di creazione");
		/* Con le tre righe sopra prendiamo le informazioni inerenti all'utente che sono necessarie
		 * per settare l'attributo creationUser e successivamente updateUser
		 */

		Question prodotto = new Question();
		//prodotto.setCodProd(codProd);
		//prodotto.setPrezzo(prezzo);
		//prodotto.setDataArr(dataArr);
		prodotto.setCreationTime(new Date());
		log.info("Rilevata data di creazione");
		prodotto.setCreationUser(getUsername(req));

		this.service.createQuestion(prodotto);

		return ResponseEntity.ok(ResponseMessage.ok(prodotto.getId()));
	}

	@PutMapping(path = "/update/{id}")
	@Secured("ROLE_EDIT")
	public ResponseEntity<ResponseMessage> update(
			@PathVariable(name = "id") Integer id,
			@RequestParam (required = false) String codProd,
			@RequestParam (required = false) Integer prezzo,
			@RequestParam (required = false) Date dataArr,
			HttpServletRequest req) {

		log.info("Ricevuta richiesta di update di un prodotto");

		String updateUser = getUsername(req);
		log.info("Rilevato utente di modifica");

		Date updateTime = new Date();
		log.info("Rilevata data di modifica");

		QuestionDTO prodotto = service.findProdottoById(id);

		if (prodotto == null) {
			log.info("Nessun prodotto con id = " + id + " rilevato");
			return ResponseEntity.notFound().build();
		}

		service.updateQuestion(id, codProd, prezzo, dataArr, updateTime, updateUser);

		return ResponseEntity.ok(ResponseMessage.ok(prodotto.getId()));
	}

	@DeleteMapping(path = "/delete/{id}")
	@Secured("ROLE_DELETE")
	public ResponseEntity<ResponseMessage> delete(@PathVariable(name = "id") Integer id, HttpServletRequest req) {

		log.info("Ricevuta richiesta di eliminazione di un prodotto");
		
		log.info("Rilevato utente di modifica");

		QuestionDTO prodotto = service.findProdottoById(id);

		if (prodotto == null) {
			log.info("Nessun prodotto con id = " + id + " rilevato");
			return ResponseEntity.notFound().build();
		}

		service.deleteQuestion(id, getUsername(req));

		return ResponseEntity.ok(ResponseMessage.ok(prodotto.getId()));
	}

}
