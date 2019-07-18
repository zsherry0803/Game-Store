package com.company.SherryZhangU1Capstone.viewmodel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class TshirtViewModel {

    private int tshirtId;
    @NotEmpty(message = "Please supply a value for size")
    private String size;
    @NotEmpty(message = "Please supply a value for color")
    private String color;
    @NotEmpty(message = "Please supply a value for description")
    private String description;
    @NotNull(message = "Please supply a value for price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal price;
    @NotNull(message = "Please supply a value for quantity")
    @Min(0)
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
        if (!(o instanceof TshirtViewModel)) return false;
        TshirtViewModel that = (TshirtViewModel) o;
        return tshirtId == that.tshirtId &&
                size.equals(that.size) &&
                color.equals(that.color) &&
                description.equals(that.description) &&
                price.equals(that.price) &&
                quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tshirtId, size, color, description, price, quantity);
    }
}
