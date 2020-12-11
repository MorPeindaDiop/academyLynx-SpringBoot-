package it.jac.lynx.service;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.dto.MailDTO;
import it.jac.lynx.entity.Mail;

@SpringBootTest
public class SendEmailSMTPServiceTest {
	
	@Autowired
	private SendEmailSMTPService sendEmailSMTPService;
	
	@Test
	public void sendEmailTest() {
		Mail mail=new Mail();
		
		mail.setSmtpServer("smtp.gmail.com");
		mail.setUsername("gruppolynx@gmail.com");
		mail.setPassword("Gruppolynx1234!");
		
		mail.setMittente("gruppolynx@gmail.com");
		mail.setDestinatario("pietro.locatelli00@gmail.com");
		
		mail.setOggetto("prova java");
		mail.setTesto("testo email bello");
		
		assertEquals(true, sendEmailSMTPService.send(mail).isResultTest());
		
	}

}
