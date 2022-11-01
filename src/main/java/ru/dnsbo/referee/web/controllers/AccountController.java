package ru.dnsbo.referee.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dnsbo.referee.repository.RefereeRepository;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private RefereeRepository refereeRepository;

    @GetMapping("/login")
    public String PageLogin() {
        return "html/page/account/login";
    }

    @GetMapping("/profile")
    public String PageProfile() {
        return "html/page/account/profile";
    }

    @PostMapping("/login")
    public String SignIn(Model model) {

        //сделать проверку ввода

        return "redirect:/account/profile";
    }

    @GetMapping("/registration")
    public String PageRegistration() {
        return "html/page/account/registration";
    }

    @PostMapping("/registration")
    public String newAccount(Model model) {
        return "redirect:/home";
    }

    @GetMapping("/admin")
    public String PageAdmin(Model model) {

        //сделать проверку ввода и выводить на страницу админа

        model.addAttribute("usersFromServer",refereeRepository.findAll());
        return "html/page/account/admin";
    }

}
