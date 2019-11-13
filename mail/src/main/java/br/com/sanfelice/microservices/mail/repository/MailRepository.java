package br.com.sanfelice.microservices.mail.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.sanfelice.microservices.mail.entity.Mail;

/**
 * MailRepository
 */
public interface MailRepository extends CrudRepository<Mail, Long> {

    
}