package br.com.sanfelice.microservices.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.sanfelice.microservices.user.entity.User;
import br.com.sanfelice.microservices.user.kafka.producer.Sender;
import br.com.sanfelice.microservices.user.repository.UserRepository;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("${spring.kafka.topic.userCreated}")
    private String USER_CREATED_TOPIC;

    private final UserRepository userRepository;
    private final Sender sender;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Sender sender) {
        this.userRepository = userRepository;
        this.sender = sender;
    }


    @Override
    public User registerUser(User input) {
       User createdUser = userRepository.save(input);
       sender.send(USER_CREATED_TOPIC, createdUser);
       return createdUser;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    
}