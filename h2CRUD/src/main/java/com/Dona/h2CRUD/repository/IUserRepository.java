package com.Dona.h2CRUD.repository;

import com.Dona.h2CRUD.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
//işlem yapılacak sınıf türü UserEntity ve id tipi long olduğu için böyle
    //JpaRepository içinde bir çok jpa fonksiyonu içeriyor

    boolean existsUserByUsername(String username);

}