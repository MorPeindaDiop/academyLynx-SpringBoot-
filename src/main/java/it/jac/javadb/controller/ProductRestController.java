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

@RestController
@RequestMapping("/rest")
@Secured("ROLE_USER")
public class ProductRestController {

	private static Logger log = LoggerFactory.getLogger(ProductRestController.class);
/*
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private QuestionService service;
	
	private String getUsername(HttpServletRequest req) {
		final String requestTokenHeader = req.getHeader("Authorization");
		String jwtToken = requestTokenHeader.substring("Bearer ".length());
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		
		return username;
	}

	@GetMapping(path = "/allProducts")
	public ResponseEntity<List<QuestionDTO>> allProducts(HttpServletRequest req) {

		log.info("Ricevuta richiesta della lista di tutti i prodotti");

		String username = getUsername(req);
		log.info("Rilevato utente che ha eseguito la richiesta");
		
		List<QuestionDTO> prodotto = service.findAll();

		if (prodotto == null) {
			log.info("Lista prodotti vuota");
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(prodotto);
	}

	@GetMapping(path = "/detail/{id}")
	public ResponseEntity<QuestionDTO> detail(@PathVariable(name = "id") Integer id, HttpServletRequest req) {
		
		log.info("Ricevuta richiesta di dettaglio di un prodotto");
		
		log.info("Rilevato utente che ha eseguito la richiesta di dettaglio");

		QuestionDTO prodotto = service.findQuestionById(id);

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
		
		log.info("Ricevuta richiesta di creazione nuovo prodotto");

		log.info("Rilevato utente di creazione");
		

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

		QuestionDTO prodotto = service.findQuestionById(id);

		if (prodotto == null) {
			log.info("Nessun prodotto con id = " + id + " rilevato");
			return ResponseEntity.notFound().build();
		}

		//service.updateQuestion(id, codProd, prezzo, dataArr, updateTime, updateUser);

		return ResponseEntity.ok(ResponseMessage.ok(prodotto.getId()));
	}

	@DeleteMapping(path = "/delete/{id}")
	@Secured("ROLE_DELETE")
	public ResponseEntity<ResponseMessage> delete(@PathVariable(name = "id") Integer id, HttpServletRequest req) {

		log.info("Ricevuta richiesta di eliminazione di un prodotto");
		
		log.info("Rilevato utente di modifica");

		QuestionDTO prodotto = service.findQuestionById(id);

		if (prodotto == null) {
			log.info("Nessun prodotto con id = " + id + " rilevato");
			return ResponseEntity.notFound().build();
		}

		service.deleteQuestion(id);

		return ResponseEntity.ok(ResponseMessage.ok(prodotto.getId()));
	}
*/
}
