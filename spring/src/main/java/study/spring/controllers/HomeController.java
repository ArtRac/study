package study.spring.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    //Obsługa żądań kierowanych do katalogu głównego ścieżki dostępu.
    @GetMapping("/")
    public String home() {
        // Wartością zwrotną jest nazwa widoku/szablonu.
        log.info("test--------------------------");
        return "home";
    }
}
