package com.Dona.h2CRUD.service;

import com.Dona.h2CRUD.dto.UserCreateDTO;
import com.Dona.h2CRUD.dto.UserUpdateDTO;
import com.Dona.h2CRUD.dto.UserViewDTO;
import com.Dona.h2CRUD.exception.NotFoundException;
import com.Dona.h2CRUD.model.UserEntity;
import com.Dona.h2CRUD.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public UserViewDTO getUserById(Long id) {
        final UserEntity user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return UserViewDTO.of(user);
    }

    @Override
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        //final UserEntity user = userRepository.save(new UserEntity(userCreateDTO.getUserName(), userCreateDTO.getFirstName(), userCreateDTO.getLastName()));
        final UserEntity user = userRepository.save(new UserEntity(userCreateDTO.getUserName(), userCreateDTO.getFirstName(), userCreateDTO.getLastName()));
        return UserViewDTO.of(user);
    }

    @Override
    public List<UserViewDTO> getUsers() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final UserEntity user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception!"));

        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());

        final UserEntity updateUser = userRepository.save(user);
        return UserViewDTO.of(updateUser);


    }

    @Override
    public void deleteUser(Long id) {
        final UserEntity user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception!"));
        userRepository.deleteById(user.getId());
    }

    @Override
    public List<UserViewDTO> slice(Pageable pageable) {
        return userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());
    }
}
