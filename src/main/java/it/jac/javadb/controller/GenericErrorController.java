package it.jac.javadb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//Bean che consente di gestire le eccezioni dell'intero applicativo
@ControllerAdvice
public class GenericErrorController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception ex) {
		//errore nella formulazione della richiesta http
		return ResponseEntity.status(500).build();
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity handleAccessDeniedException(Exception ex) {
		//negato accesso in base al ruolo
		return ResponseEntity.status(403).build();
	}

}
