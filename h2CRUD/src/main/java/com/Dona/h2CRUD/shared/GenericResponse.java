package com.Dona.h2CRUD.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public final class GenericResponse {
    //Kullanıcı kayıt olunca karşısına çıkacak mesaj.ör/kayıt başarılı gibi
    private String message;
}
