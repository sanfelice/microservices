package br.com.sanfelice.microservices.user.service;

import br.com.sanfelice.microservices.user.entity.User;

/**
 * UserService
 */
public interface UserService {
    User registerUser(User input);
    Iterable<User> findAll();
}