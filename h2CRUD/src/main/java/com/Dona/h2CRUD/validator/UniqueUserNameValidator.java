package com.Dona.h2CRUD.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import com.Dona.h2CRUD.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    private final IUserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return !userRepository.existsUserByUsername(username);
    }

}