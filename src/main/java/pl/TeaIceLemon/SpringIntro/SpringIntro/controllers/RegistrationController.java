package pl.TeaIceLemon.SpringIntro.SpringIntro.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.User;
import pl.TeaIceLemon.SpringIntro.SpringIntro.repositories.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final static Logger log = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder= passwordEncoder;
    }



    @GetMapping
    public String prepareRegistrationPage(){
        return "/WEB-INF/views/registration.jsp";
    }

    @PostMapping
    public String processRegistrationPage(String username,String password, String firstName, String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setActive(true);

        userRepository.save(user);
        log.info("User:" + user + "was saved in database");
        return "redirect:/";
    }
}
