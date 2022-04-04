package com.giassi.microservice.demo2.rest.users.dtos;

import java.util.ArrayList;

/**
 * DTO for the List of users
 */
public class UserListDTO implements java.io.Serializable {

    private ArrayList<UserDTO> userList;

    public UserListDTO() {
        userList = new ArrayList<>();
    }

    public UserListDTO(ArrayList<UserDTO> userList) {
        this.userList = userList;
    }

    public ArrayList<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserDTO> userList) {
        this.userList = userList;
    }
}
