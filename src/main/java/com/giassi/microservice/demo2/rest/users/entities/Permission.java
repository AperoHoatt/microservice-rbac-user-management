package com.giassi.microservice.demo2.rest.users.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private Long id;

    @Column(name = "permission", nullable = false)
    private String permission;

    // enabled as default
    @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT(1) default 1")
    private boolean enabled = true;

    @Column(name = "note")
    private String note;

    public Permission() {
    }

    public Permission(Long id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public Permission(Long id, String permission, boolean enabled, String note) {
        this.id = id;
        this.permission = permission;
        this.enabled = enabled;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", enabled=" + enabled +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return enabled == that.enabled && Objects.equals(id, that.id) && Objects.equals(permission, that.permission) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, permission, enabled, note);
    }
}
