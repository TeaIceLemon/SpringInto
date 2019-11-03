package pl.TeaIceLemon.SpringIntro.SpringIntro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.Advert;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.User;
import pl.TeaIceLemon.SpringIntro.SpringIntro.repositories.AdvertRepository;
import pl.TeaIceLemon.SpringIntro.SpringIntro.repositories.UserRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class UserAdvertsController {
    private AdvertRepository advertRepository;
    private UserRepository userRepository;

    @Autowired
    public UserAdvertsController(AdvertRepository advertRepository, UserRepository userRepository) {
        this.advertRepository = advertRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/user-adverts")
    public String getUserAdverts(Model model, Principal principal){
        String name = principal.getName();
        User user = userRepository.findByUsername(name);
        List<Advert> userAdverts = advertRepository.findAllByOwner(user);
        for(Advert advert : userAdverts){
            System.out.println(advert.getOwner());
        }
        model.addAttribute("userAdverts", userAdverts);
        return "/WEB-INF/views/user-adverts-page.jsp";

    }

}
