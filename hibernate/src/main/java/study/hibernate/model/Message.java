package study.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String text;

    /*
    Klucz główny nigdy się nie zmienia, dlatego nie należy, pozwalać na modyfikowanie tej wartości
    więc nie powinno się dla niej tworzyć setera.
    */

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
