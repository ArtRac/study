package study.spring.models;

import java.util.List;
import lombok.Data;

@Data
public class Taco {

    private String name;
    private List<String> ingredients;

}