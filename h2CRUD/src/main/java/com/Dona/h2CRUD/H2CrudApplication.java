package com.Dona.h2CRUD;

import com.Dona.h2CRUD.dto.UserCreateDTO;
import com.Dona.h2CRUD.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class H2CrudApplication {

    public static void main(String[] args) {

        SpringApplication.run(H2CrudApplication.class, args);
    }

    @Bean
    CommandLineRunner createInitialUser(IUserService userService) {
        return (args) -> {
            UserCreateDTO user1 = new UserCreateDTO();
            user1.setUserName("User1");
            user1.setFirstName("Metehan1");
            user1.setLastName("Gültekin1");

            userService.createUser(user1);

            UserCreateDTO user2 = new UserCreateDTO();
            user2.setUserName("User2");
            user2.setFirstName("Metehan2");
            user2.setLastName("Gültekin2");

            userService.createUser(user2);

            UserCreateDTO user3 = new UserCreateDTO();
            user3.setUserName("User3");
            user3.setFirstName("Metehan3");
            user3.setLastName("Gültekin3");

            userService.createUser(user3);
        };
    }

}
