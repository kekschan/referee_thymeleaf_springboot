package ru.dnsbo.referee.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dnsbo.referee.models.Referee;
import ru.dnsbo.referee.repository.RefereeRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private RefereeRepository refereeRepository;
    @GetMapping("/profile")
    public String PageProfile() {
        return "html/page/account/profile";
    }
    @GetMapping("/login")
    public String PageLogin() {
        return "html/page/account/login";
    }

    @PostMapping("/login")
    public String SignIn( Authentication authentication, HttpServletRequest request, Model model) {
        return "redirect:/account/profile";
    }

    @GetMapping("/registration")
    public String PageRegistration() {
        return "html/page/account/registration";
    }

    @PostMapping("/registration")
    public String newAccount(@RequestParam String secondName, @RequestParam String firstName,
                             @RequestParam String email, @RequestParam String password,
                             Model model) {
        Referee newReferee = new Referee(secondName,firstName,email,password);
        refereeRepository.save(newReferee);
        return "redirect:/home";
    }

    @GetMapping("/admin")
    public String PageAdmin(Model model) {

        //сделать проверку ввода и выводить на страницу админа

        model.addAttribute("usersFromServer",refereeRepository.findAll());
        return "html/page/account/admin";
    }

}
