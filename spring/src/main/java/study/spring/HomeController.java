package study.spring;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //Obsługa żądań kierowanych do katalogu głównego ścieżki dostępu.
    @GetMapping("/")
    public String home() {
        // Wartością zwrotną jest nazwa widoku/szablonu.
        return "home";
    }
}
