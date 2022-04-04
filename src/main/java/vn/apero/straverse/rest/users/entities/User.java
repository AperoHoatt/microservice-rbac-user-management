package vn.apero.straverse.rest.users.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Enumerated
    @Column(columnDefinition = "tinyint")
    private Gender gender;

    // Birth date without a time-zone in the ISO-8601 calendar system, such as 2007-12-03
    @Column(name = "birth_date")
    private java.time.LocalDate birthDate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Contact contact;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @Column(name = "enabled", columnDefinition = "TINYINT(1) default 1")
    private boolean enabled;

    @Column(name = "note")
    private String note;

    @Basic
    private java.time.LocalDateTime creationDt;

    @Basic
    private java.time.LocalDateTime updatedDt;

    @Basic
    private java.time.LocalDateTime loginDt;

    @Column(name = "secured", columnDefinition = "TINYINT(1) default 1")
    private boolean secured;

    public User() {
    }

    public User(Long id, String username, String password, String name, String surname, Gender gender, LocalDate birthDate, Contact contact, Address address, boolean enabled, String note, LocalDateTime creationDt, LocalDateTime updatedDt, LocalDateTime loginDt, boolean secured) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.contact = contact;
        this.address = address;
        this.enabled = enabled;
        this.note = note;
        this.creationDt = creationDt;
        this.updatedDt = updatedDt;
        this.loginDt = loginDt;
        this.secured = secured;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(LocalDateTime creationDt) {
        this.creationDt = creationDt;
    }

    public LocalDateTime getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(LocalDateTime updatedDt) {
        this.updatedDt = updatedDt;
    }

    public LocalDateTime getLoginDt() {
        return loginDt;
    }

    public void setLoginDt(LocalDateTime loginDt) {
        this.loginDt = loginDt;
    }

    public boolean isSecured() {
        return secured;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", contact=" + contact +
                ", address=" + address +
                ", enabled=" + enabled +
                ", note='" + note + '\'' +
                ", creationDt=" + creationDt +
                ", updatedDt=" + updatedDt +
                ", loginDt=" + loginDt +
                ", secured=" + secured +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled && secured == user.secured && Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && gender == user.gender && Objects.equals(birthDate, user.birthDate) && Objects.equals(contact, user.contact) && Objects.equals(address, user.address) && Objects.equals(note, user.note) && Objects.equals(creationDt, user.creationDt) && Objects.equals(updatedDt, user.updatedDt) && Objects.equals(loginDt, user.loginDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, surname, gender, birthDate, contact, address, enabled, note, creationDt, updatedDt, loginDt, secured);
    }
}
