package br.com.sanfelice.microservices.mail.service;

import br.com.sanfelice.microservices.mail.entity.dto.UserDTO;

/**
 * EmailService
 */
public interface EmailService {

    void sendSimpleMessage(UserDTO input);
}