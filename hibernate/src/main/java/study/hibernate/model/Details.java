package study.hibernate.model;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

/*
* Ta klasa zostanie połączona do
* */
@Embeddable
public class Details {

    private String description;
    private BigDecimal price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
