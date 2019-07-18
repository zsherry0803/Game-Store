package com.company.SherryZhangU1Capstone.viewmodel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {

    private int gameId;
    @NotEmpty(message = "Please supply a value for model")
    private String model;
    @NotEmpty(message = "Please supply a value for manufacturer")
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    @NotNull(message = "Please supply a value for price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal price;
    @NotNull(message = "Please supply a value for quantity")
    @Min(0)
    private Integer quantity;


    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
        if (!(o instanceof ConsoleViewModel)) return false;
        ConsoleViewModel that = (ConsoleViewModel) o;
        return gameId == that.gameId &&
                model.equals(that.model) &&
                manufacturer.equals(that.manufacturer) &&
                Objects.equals(memoryAmount, that.memoryAmount) &&
                Objects.equals(processor, that.processor) &&
                price.equals(that.price) &&
                quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
