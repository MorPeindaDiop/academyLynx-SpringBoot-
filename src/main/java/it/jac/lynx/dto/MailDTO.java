package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Mail;
import lombok.Data;

@Data
public class MailDTO {
	
	//server data
	private String smtpServer;
	private String username;
	private String password;
	
	
	//user
	private String mittente;
	private String destinatario;
	private String cc;
	
	//mail
	private String oggetto;
	private String testo;
	
	
	public static MailDTO build(Mail mail) {

		MailDTO result = new MailDTO();
		BeanUtils.copyProperties(mail, result);

		return result;
	}

}
