package br.com.sanfelice.microservices.mail.service;

import org.apache.kafka.clients.producer.internals.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.sanfelice.microservices.mail.entity.Mail;
import br.com.sanfelice.microservices.mail.entity.dto.UserDTO;
import br.com.sanfelice.microservices.mail.repository.MailRepository;

/**
 * EmailServiceImpl
 */
@Service
public class EmailServiceImpl implements EmailService {

    public final JavaMailSender emailSender;
    public final MailRepository mailRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    
    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender, MailRepository mailRepository) {
        this.emailSender = emailSender;
        this.mailRepository = mailRepository;
    }
    

    @Override
    public void sendSimpleMessage(UserDTO input) {
        try {

            Mail email = new Mail();
            email.to(input.getUsername())
                .subject("TestSubject")
                .text("TestText");

            mailRepository.save(email);
            // emailSender.send(email.getSimpleMessage());
            LOGGER.info("sending email='{}'", input);
        } catch (MailException exception) {
            exception.printStackTrace();
        }

    }
}

    