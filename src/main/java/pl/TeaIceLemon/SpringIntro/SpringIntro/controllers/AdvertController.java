package pl.TeaIceLemon.SpringIntro.SpringIntro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.Advert;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.User;
import pl.TeaIceLemon.SpringIntro.SpringIntro.repositories.AdvertRepository;
import pl.TeaIceLemon.SpringIntro.SpringIntro.repositories.UserRepository;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class AdvertController {
    private UserRepository userRepository;
    private AdvertRepository advertRepository;

    public AdvertController(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    @PostMapping("/add-advert")
    public String addAdvert(String title, String description, Principal principal){
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        Advert advert = new Advert();
        advert.setDescription(description);
        advert.setOwner(user);
        advert.setPosted(LocalDateTime.now());
        advert.setTitle(title);
        advertRepository.save(advert);
        return "redirect:/";
    }
}
