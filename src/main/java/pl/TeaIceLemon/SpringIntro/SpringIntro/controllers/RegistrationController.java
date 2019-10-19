package pl.TeaIceLemon.SpringIntro.SpringIntro.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/register")
public class RegistrationController {
    @GetMapping
    public String prepareRegistrationPage(){
        return "/WEB-INF/views/registration.jsp";
    }

    @PostMapping
    public String processRegistrationPage(){

        return "";
    }
}
