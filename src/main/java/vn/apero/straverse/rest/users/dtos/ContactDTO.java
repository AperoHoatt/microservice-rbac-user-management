package vn.apero.straverse.rest.users.dtos;

import vn.apero.straverse.rest.users.entities.Contact;

public class ContactDTO implements java.io.Serializable {
    private String email;
    private String phone;
    private String skype;
    private String facebook;
    private String linkedin;
    private String website;
    private String contactNote;

    public ContactDTO() {
        // empty constructor
    }

    public ContactDTO(String email, String phone, String skype, String facebook, String linkedin, String website, String contactNote) {
        this.email = email;
        this.phone = phone;
        this.skype = skype;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.website = website;
        this.contactNote = contactNote;
    }

    public ContactDTO(Contact contact) {
        if (contact != null) {
            this.email = contact.getEmail();
            this.phone = contact.getPhone();
            this.skype = contact.getSkype();
            this.facebook = contact.getFacebook();
            this.linkedin = contact.getLinkedin();
            this.website = contact.getWebsite();
            this.contactNote = contact.getNote();
        }
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
}
