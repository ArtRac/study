package study.spring.others;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class AnyBean {

    private static int count = 0;

    @Value(value = "jakiś tekst")
    private String name;
    private int id = 0;

    public AnyBean() {
        this.id = count;
        ++count;
    }

}
