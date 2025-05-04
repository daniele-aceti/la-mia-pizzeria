package pizzeria.spring_la_mia_pizzeria_crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import ch.qos.logback.core.model.Model;
import pizzeria.spring_la_mia_pizzeria_crud.model.Role;
import pizzeria.spring_la_mia_pizzeria_crud.model.User;
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
            if(roleRepository.findAll().isEmpty()){
            Role ruoloAdmin = new Role();
            ruoloAdmin.setName("ADMIN");
            roleRepository.save(ruoloAdmin);
            Role ruoloUser = new Role();
            ruoloUser.setName("USER");
            roleRepository.save(ruoloUser);
        }

        if(userRepository.findAll().isEmpty()){
            User user = new User();
            user.setNome("admin");
            user.setCognome("admin");
            user.setPassword("admin");
            user.setUsername("admin");
            Role role = roleRepository.findByName("ADMIN").get();
            user.setRoles(List.of(role));//faccio una lista con un solo elemento
            userRepository.save(user);

        }
        
        return "pizze/loading";
    }
    

}
