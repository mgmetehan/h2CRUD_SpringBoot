package com.Dona.h2CRUD.service;

import com.Dona.h2CRUD.dto.UserCreateDTO;
import com.Dona.h2CRUD.dto.UserUpdateDTO;
import com.Dona.h2CRUD.dto.UserViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    UserViewDTO getUserById(Long id);

    UserViewDTO createUser(UserCreateDTO userCreateDTO);

    List<UserViewDTO> getUsers();

    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    void deleteUser(Long id);

    List<UserViewDTO> slice(Pageable pageable);
}
