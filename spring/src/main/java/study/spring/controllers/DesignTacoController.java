package study.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.spring.models.Ingredient;
import study.spring.models.Ingredient.Type;
import study.spring.models.Taco;

import java.util.Arrays;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping // obsługuje żądania GET http
    public String showDesignForm(Model model) {

        var ingredients = Arrays.asList(
                new Ingredient("FLTO", "pszenna", Type.WRAP),
                new Ingredient("COTO", "kukurydziana", Type.WRAP),
                new Ingredient("GRBF", "mielona wołowina ", Type.PROTEIN),
                new Ingredient("CARN", "kawałki mięsa", Type.PROTEIN),
                new Ingredient("TMTO", "pomidory pokrojone w kostkę", Type.VEGGIES),
                new Ingredient("LETC", "sałata", Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterey Jack", Type.CHEESE),
                new Ingredient("SLSA", "pikantny sos pomidorowy", Type.SAUCE),
                new Ingredient("SRCR", "śmietana", Type.SAUCE)
        );

        var types = Ingredient.Type.values();

        for (var type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    ingredients.stream()
                    .filter(i -> i.getType().equals(type))
                    .toList());
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(Taco design) {
        // Zapisanie projektu przygotowanego taco…
        // Tym się zajmiesz w rozdziale 3.
        log.info("Przetwarzanie projektu taco: " + design);
        return "redirect:/orders/current";

    }
}