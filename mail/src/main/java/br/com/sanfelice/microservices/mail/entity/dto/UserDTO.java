package br.com.sanfelice.microservices.mail.entity.dto;

/**
 * UserDTO
 */
public class UserDTO {

    private Long id;
    private String username;
    private String password;


    public UserDTO id(Long id) {
        this.id = id;
        return this;
    }

    public UserDTO username(String username) {
        this.username = username;
        return this;
    }

    public UserDTO password(String password) {
        this.password = password;
        return this;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }


}