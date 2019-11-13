package br.com.sanfelice.microservices.mail.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.mail.SimpleMailMessage;

/**
 * Mail
 */
@Entity
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    @Size(min = 1, message = "Please, set an email address to send the message to it")
    private String to;
    private String subject;
    private String text;


    public Long getId() {
        return this.id;
    }

    public String getTo() {
        return this.to;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getText() {
        return this.text;
    }


    public Mail id(Long id) {
        this.id = id;
        return this;
    }

    public Mail to(String to) {
        this.to = to;
        return this;
    }

    public Mail subject(String subject) {
        this.subject = subject;
        return this;
    }

    public Mail text(String text) {
        this.text = text;
        return this;
    }

    public SimpleMailMessage getSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(this.to);
        message.setSubject(this.subject);
        message.setText(this.text);

        return message;
    }
}