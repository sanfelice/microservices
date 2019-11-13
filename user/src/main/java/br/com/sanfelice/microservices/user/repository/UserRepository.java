package br.com.sanfelice.microservices.user.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.sanfelice.microservices.user.entity.User;

/**
 * UserRepository
 */
public interface UserRepository extends CrudRepository<User, Long> {

    
}