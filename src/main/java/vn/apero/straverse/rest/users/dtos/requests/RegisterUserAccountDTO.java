package vn.apero.straverse.rest.users.dtos.requests;

import java.io.Serializable;

/**
 * Support the creation of a new user account with a minimum set of required data
 */
public class RegisterUserAccountDTO implements Serializable {

    private String username;
    private String password;

    private String name;
    private String surname;
    private String email;
    private String gender;

    public RegisterUserAccountDTO() {
    }

    public RegisterUserAccountDTO(String username, String password, String name, String surname, String email, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static final class Builder {
        private String username;
        private String password;

        private String name;
        private String surname;
        private String email;
        private String gender;

        public Builder() {
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public RegisterUserAccountDTO build() {
            return new RegisterUserAccountDTO(username, password, name, surname, email, gender);
        }
    }
}
