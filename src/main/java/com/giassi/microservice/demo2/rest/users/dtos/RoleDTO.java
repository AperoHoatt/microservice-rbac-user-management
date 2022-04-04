package com.giassi.microservice.demo2.rest.users.dtos;

import com.giassi.microservice.demo2.rest.users.entities.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoleDTO implements Serializable {

    private Long id;
    private String role;

    private List<PermissionDTO> permissions = new ArrayList<>();

    public RoleDTO() {
    }

    public RoleDTO(Long id, String role, List<PermissionDTO> permissions) {
        this.id = id;
        this.role = role;
        this.permissions = permissions;
    }

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.role = role.getRole();

        // permissions
        role.getPermissions().stream().forEach(e -> permissions.add(new PermissionDTO(e)));
    }

    public RoleDTO(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<PermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDTO> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleDTO)) return false;
        return id != null && id.equals(((RoleDTO) o).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, permissions);
    }
}
