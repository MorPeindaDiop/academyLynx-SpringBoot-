package it.jac.lynx.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dao.MailDAO;
import it.jac.lynx.dto.MailDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.Mail;


@Service
public class SendEmailSMTPService {
	private static Logger log = LoggerFactory.getLogger(SendEmailSMTPService.class);
	
	@Autowired
	private MailDAO mailRepository;
	
	
	public Response<MailDTO> send(Mail mail) {

		Response<MailDTO> response = new Response<MailDTO>();

		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", mail.getSmtpServer()); //optional, defined in SMTPTransport
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587"); //port 25-465-587-2525
		prop.put("mail.smtp.starttls.enable", "true"); //TLS
		prop.put("mail.smtp.ssl.trust", mail.getSmtpServer());
		log.info("SETTA COSE SERVER");
		
		
		Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mail.getUsername(), mail.getPassword());
                    }
                });
		try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail.getMittente()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail.getDestinatario())
            );
            message.setSubject(mail.getOggetto());
            message.setText(mail.getTesto());

            Transport.send(message);

            System.out.println("Done");
            response.setResultTest(true);
          
            this.mailRepository.save(mail);

        } catch (MessagingException e) {
            e.printStackTrace();
            response.setResultTest(false);
        }
    
		return response;


	}

}
