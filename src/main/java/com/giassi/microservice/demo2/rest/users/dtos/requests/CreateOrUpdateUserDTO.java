package com.giassi.microservice.demo2.rest.users.dtos.requests;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Create or modify user data
 */
public class CreateOrUpdateUserDTO implements Serializable {
    private String username;
    private String password;

    private String name;
    private String surname;
    private String gender;
    private java.time.LocalDate birthDate;

    private boolean enabled;
    private boolean secured;

    private String note;

    // contact information
    private String email;
    private String phone;
    private String skype;
    private String facebook;
    private String linkedin;
    private String website;
    private String contactNote;

    // address information
    private String address;
    private String address2;
    private String city;
    private String country;
    private String zipCode;

    public CreateOrUpdateUserDTO() {
    }

    public CreateOrUpdateUserDTO(String username, String password, String name, String surname, String gender, LocalDate birthDate, boolean enabled, boolean secured, String note, String email, String phone, String skype, String facebook, String linkedin, String website, String contactNote, String address, String address2, String city, String country, String zipCode) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.enabled = enabled;
        this.secured = secured;
        this.note = note;
        this.email = email;
        this.phone = phone;
        this.skype = skype;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.website = website;
        this.contactNote = contactNote;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isSecured() {
        return secured;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactNote() {
        return contactNote;
    }

    public void setContactNote(String contactNote) {
        this.contactNote = contactNote;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public static final class Builder {
        private String username;
        private String password;

        private String name;
        private String surname;
        private String gender;
        private java.time.LocalDate birthDate;

        private boolean enabled;
        private boolean secured;

        private String note;

        // contact information
        private String email;
        private String phone;
        private String skype;
        private String facebook;
        private String linkedin;
        private String website;
        private String contactNote;

        // address information
        private String address;
        private String address2;
        private String city;
        private String country;
        private String zipCode;

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

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder setSecured(boolean secured) {
            this.secured = secured;
            return this;
        }

        public Builder setNote(String note) {
            this.note = note;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setSkype(String skype) {
            this.skype = skype;
            return this;
        }

        public Builder setFacebook(String facebook) {
            this.facebook = facebook;
            return this;
        }

        public Builder setLinkedin(String linkedin) {
            this.linkedin = linkedin;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder setContactNote(String contactNote) {
            this.contactNote = contactNote;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setAddress2(String address2) {
            this.address2 = address2;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public CreateOrUpdateUserDTO build() {
            return new CreateOrUpdateUserDTO(username, password, name, surname, gender, birthDate, enabled, secured,
                    note, email, phone, skype, facebook, linkedin, website, contactNote, address, address2, city,
                    country, zipCode);
        }
    }
}
