package org.example.library.jbel.controller;

//import com.example.registrationlogindemo.dto.UserDto;
//import com.example.registrationlogindemo.entity.User;
//import com.example.registrationlogindemo.service.UserService;
import jakarta.validation.Valid;
import org.example.library.jbel.dto.UserDto;
import org.example.library.jbel.entity.User;
import org.example.library.jbel.service.UserService;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.thymeleaf.context.Context;

import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public String home(@ModelAttribute User form, Model model){

        Context context = new Context();
        context.setVariable("name", form.getName()+"gf");
        model.addAttribute("text", form.getName());
        System.out.println(context);
        System.out.println(model);



        return "index";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute(new User());
        return "login";

    }


    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
//        return "redirect:/register?success";
        return "redirect:/login";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/demandeconge")
    public String demandeconge(){

        return "DEMANDECONGE";
    }
    @GetMapping("/demandeaug")
    public String demandeaug(){

        return "demandeAugm";
    }
    @GetMapping("/demandesortie")
    public String demandesortie(){


        return "demandeSortie";
    }
    @GetMapping("/demandemobilite")
    public String demandemobilite(){


        return "demandeMobilite";
    }


////    @Override
//@GetMapping("/")
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/")
//                .setViewName("forward:/login.html");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }

}
