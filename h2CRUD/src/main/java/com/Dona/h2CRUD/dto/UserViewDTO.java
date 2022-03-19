package com.Dona.h2CRUD.dto;

import com.Dona.h2CRUD.model.UserEntity;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserViewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String firstName;

    private final String lastName;

    private UserViewDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserViewDTO of(UserEntity user) {
        return new UserViewDTO(user.getFirstName(), user.getLastName());
    }

}
