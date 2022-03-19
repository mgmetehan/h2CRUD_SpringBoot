package com.Dona.h2CRUD.controller;


import com.Dona.h2CRUD.dto.UserCreateDTO;
import com.Dona.h2CRUD.dto.UserUpdateDTO;
import com.Dona.h2CRUD.dto.UserViewDTO;
import com.Dona.h2CRUD.service.IUserService;
import com.Dona.h2CRUD.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
/*RequiredArgsConstructor yazmazsan bunu oluşturman gerek
public UserApi(IUserService userService) {
        this.userService = userService;
    }
 */ public class UserApi {

    private final IUserService userService;

    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable("id") Long id) {
        final UserViewDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("v1/users")
    public ResponseEntity<List<UserViewDTO>> getUsers() {
        final List<UserViewDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User Created."));
    }

    @PutMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> updateUser(@Valid @PathVariable("id") Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
        final UserViewDTO user = userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("v1/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User Deleted!"));
    }

    @GetMapping("v1/user/slice")
    public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable) {
        final List<UserViewDTO> users = userService.slice(pageable);
        return ResponseEntity.ok(users);
    }


}
