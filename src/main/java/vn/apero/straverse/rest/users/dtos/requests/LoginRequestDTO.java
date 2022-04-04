package vn.apero.straverse.rest.users.dtos.requests;

import java.io.Serializable;

/**
 * User account login
 */
public class LoginRequestDTO implements Serializable {

    private String username;
    private String password;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}