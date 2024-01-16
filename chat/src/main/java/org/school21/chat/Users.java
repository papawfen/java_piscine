package org.school21.chat;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    public User() {}
    public User(String login, String passwd) {
        this.login = login;
        password = passwd;
    }
    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}
