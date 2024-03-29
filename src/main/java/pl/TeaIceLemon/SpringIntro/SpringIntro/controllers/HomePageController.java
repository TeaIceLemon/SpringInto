package pl.TeaIceLemon.SpringIntro.SpringIntro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.Advert;
import pl.TeaIceLemon.SpringIntro.SpringIntro.repositories.AdvertRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController {
    private final AdvertRepository advertRepository;

    @Autowired
    public HomePageController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping
    public String prepareHomePage(Model model){
        List<Advert> advertList = advertRepository.findAllByOrderByPostedDesc();
        model.addAttribute("adverts" , advertList);
        return "/WEB-INF/views/home-page.jsp";
    }
}
