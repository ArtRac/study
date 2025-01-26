package study.spring.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
@GetMapping - Odczytuje dane zasobu
@PostMapping - Tworzy zasób
@PutMapping - Aktualizuje zasób
@PatchMapping - Aktualizuje zasób
@DeleteMapping - Usuwa zasób
@RequestMapping - Ogólnego przeznaczenia obsługa żądania: metoda HTTP podana w atrybucie method
*/

@RestController
@RequestMapping(path = "/my", produces = "application/json")
@CrossOrigin(origins = "*")// Pozwala na żądania między domenami.
public class MyRestController {

    @GetMapping("/get")
    public List<String> myGet1() {
        var result = new ArrayList<String>();
        result.add("test");
        return result;
    }

    @GetMapping("/getid/{text}")
    public List<String> myGet2(@PathVariable("text") String text) {
        var result = new ArrayList<String>();
        result.add(text.toUpperCase());
        return result;
    }

}
