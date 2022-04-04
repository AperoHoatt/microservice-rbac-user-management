package com.giassi.microservice.demo2.rest.users.dtos;

import com.giassi.microservice.demo2.rest.users.entities.Permission;

public class PermissionDTO implements java.io.Serializable {

    private Long id;
    private String permission;
    private boolean enabled;
    private String note;

    public PermissionDTO() {
    }

    public PermissionDTO(Long id, String permission, boolean enabled, String note) {
        this.id = id;
        this.permission = permission;
        this.enabled = enabled;
        this.note = note;
    }

    public PermissionDTO(Permission permission) {
        this.id = permission.getId();
        this.permission = permission.getPermission();
        this.enabled = permission.isEnabled();
        this.note = permission.getNote();
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
}
