package pizzeria.spring_la_mia_pizzeria_crud.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import pizzeria.spring_la_mia_pizzeria_crud.model.Role;
import pizzeria.spring_la_mia_pizzeria_crud.model.Shop;
import pizzeria.spring_la_mia_pizzeria_crud.model.User;
import pizzeria.spring_la_mia_pizzeria_crud.repository.RoleRepository;
import pizzeria.spring_la_mia_pizzeria_crud.repository.ShopRepository;
import pizzeria.spring_la_mia_pizzeria_crud.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShopRepository shopRepository;

    @GetMapping("/create")
    public String formCreaUser(Model model) {
        model.addAttribute("user", new User());
        return "/user/create";
    }

    @PostMapping("/create")
    public String creaUser(@Valid @ModelAttribute("user") User formUser,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        if (userRepository.count() == 0) {
            model.addAttribute("errorUser", "Il sito è in manutenzione riprova più tardi!");
            return "user/create";
        }
        formUser.setPassword("{noop}" + formUser.getPassword());
        userRepository.save(formUser); //salva l'user
        Shop newShop = new Shop();
        Role ruolo = roleRepository.findById(2L).get();
        formUser.setRoles(List.of(ruolo));
        newShop.setDataDiCreazione(LocalDate.now());
        newShop.setUser(formUser);
        shopRepository.save(newShop);//salva lo shop
        formUser.setShop(newShop);

        return "redirect:/pizze";
    }

}
