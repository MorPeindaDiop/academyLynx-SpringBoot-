package it.jac.lynx.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.Mail;
import it.jac.lynx.service.SendEmailSMTPService;

@RestController
@RequestMapping("/rest/mail")
public class SendEmailSMTPController {
	
	private static Logger log = LoggerFactory.getLogger(SendEmailSMTPController.class);
	
	
	@Autowired
	private SendEmailSMTPService sendEmailSMTPService;
	
	@PostMapping("/send")
	public Response<?> sendMail(@RequestBody Mail mail) {

		log.info("Ricevuta richiesta di creazione nuova mail\n\n\n"+mail+"\n\n\n\n");

		return sendEmailSMTPService.send(mail);

	}
}
