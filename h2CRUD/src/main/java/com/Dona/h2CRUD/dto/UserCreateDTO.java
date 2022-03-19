package com.Dona.h2CRUD.dto;


import com.Dona.h2CRUD.validator.UniqueUserName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class UserCreateDTO {

    @NotNull(message = "{Dona.constraints.lastname.NotNull.message}")
    @Size(min = 5, max = 30, message = "{Dona.constraints.username.Size.message}")
    @UniqueUserName
    private String userName;

    @NotNull(message = "{Dona.constraints.firstname.NotNull.message}")
    @Size(min = 5, max = 30, message = "{Dona.constraints.firstname.Size.message}")
    private String firstName;

    @NotNull(message = "{Dona.constraints.lastname.NotNull.message}")
    @Size(min = 5, max = 30, message = "{Dona.constraints.lastname.Size.message}")
    private String lastName;

}
