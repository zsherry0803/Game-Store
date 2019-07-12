package com.company.SherryZhangU1Capstone.model;

//t_shirt_id int(11) not null auto_increment primary
//        key,
//        size varchar(20) not null,
//        color varchar(20) not null,
//        description varchar(255) not null,
//        price decimal(5,2) not null,
//        quantity int(11) not null

import java.math.BigDecimal;
import java.util.Objects;

public class Tshirt {
    private int tshirtId;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private Integer quantity;


    public int getTshirtId() {
        return tshirtId;
    }

    public void setTshirtId(int tshirtId) {
        this.tshirtId = tshirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tshirt)) return false;
        Tshirt tshirt = (Tshirt) o;
        return tshirtId == tshirt.tshirtId &&
                size.equals(tshirt.size) &&
                color.equals(tshirt.color) &&
                description.equals(tshirt.description) &&
                price.equals(tshirt.price) &&
                quantity.equals(tshirt.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tshirtId, size, color, description, price, quantity);
    }
}
