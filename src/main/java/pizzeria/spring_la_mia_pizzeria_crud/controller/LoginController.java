package pizzeria.spring_la_mia_pizzeria_crud.controller;

import org.springframework.stereotype.Controller;

import pizzeria.spring_la_mia_pizzeria_crud.repository.UserRepository;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
