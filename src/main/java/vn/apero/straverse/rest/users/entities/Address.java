package vn.apero.straverse.rest.users.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToOne
    @MapsId
    private User user;

    public Address() {
    }

    public Address(Long userId, String address, String address2, String city, String country, String zipCode, User user) {
        this.userId = userId;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(userId, address1.userId) && Objects.equals(address, address1.address) && Objects.equals(address2, address1.address2) && Objects.equals(city, address1.city) && Objects.equals(country, address1.country) && Objects.equals(zipCode, address1.zipCode) && Objects.equals(user, address1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, address, address2, city, country, zipCode, user);
    }

    @Override
    public String toString() {
        return "Address{" +
                "userId=" + userId +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", user=" + user +
                '}';
    }
}
