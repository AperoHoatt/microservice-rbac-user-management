package com.giassi.microservice.demo2.rest.users.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "skype")
    private String skype;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "website")
    private String website;

    @Column(name = "note")
    private String note;

    @OneToOne
    @MapsId
    private User user;

    public Contact() {
    }

    public Contact(Long userId, String email, String phone, String skype, String facebook, String linkedin, String website, String note, User user) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.skype = skype;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.website = website;
        this.note = note;
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", skype='" + skype + '\'' +
                ", facebook='" + facebook + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", website='" + website + '\'' +
                ", note='" + note + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(userId, contact.userId) && Objects.equals(email, contact.email) && Objects.equals(phone, contact.phone) && Objects.equals(skype, contact.skype) && Objects.equals(facebook, contact.facebook) && Objects.equals(linkedin, contact.linkedin) && Objects.equals(website, contact.website) && Objects.equals(note, contact.note) && Objects.equals(user, contact.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, phone, skype, facebook, linkedin, website, note, user);
    }
}
