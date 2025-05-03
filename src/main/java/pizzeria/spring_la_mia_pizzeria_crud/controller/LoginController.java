package pizzeria.spring_la_mia_pizzeria_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pizzeria.spring_la_mia_pizzeria_crud.repository.UserRepository;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String getMethodName(Model model) {
        if (userRepository.findAll().isEmpty()) {
            return "/registrazioneAdmin";
        }
        return "pizze/login";
    }

}
