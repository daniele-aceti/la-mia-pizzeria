package pizzeria.spring_la_mia_pizzeria_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import ch.qos.logback.core.model.Model;
import pizzeria.spring_la_mia_pizzeria_crud.repository.RoleRepository;
import pizzeria.spring_la_mia_pizzeria_crud.repository.UserRepository;

/* 
 * QUESTA CLASSE E' STATA CREATA SOLO PER SCOPO DIDATTICO 
 */


@Controller
public class CheckDbController {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    CheckDbController(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/loading")
    public String postMethodName(Model model) {
   
        
        return "pizze/loading";
    }
    

}
