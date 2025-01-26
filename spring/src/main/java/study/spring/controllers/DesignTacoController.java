package study.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.spring.data.IngredientRepository;
import study.spring.models.Ingredient;
import study.spring.models.Taco;

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping // obsługuje żądania GET http
    public String showDesignForm(Model model) {
        var ingredients = new ArrayList<Ingredient>();
        ingredientRepo.findAll().forEach(ingredients::add);
        var types = Ingredient.Type.values();

        for (var type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    ingredients.stream()
                            .filter(i -> i.getType().equals(type))
                            .toList());
        }
        return "design";
    }

    @PostMapping
    public String processDesign(Taco design) {
        log.info("Przetwarzanie projektu taco: " + design);
        return "redirect:/orders/current";
    }
}