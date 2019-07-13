package com.company.SherryZhangU1Capstone.model;

import java.math.BigDecimal;
import java.util.Objects;

//game_id int(11) not null auto_increment primary key,
//        model varchar(50) not null,
//        manufacturer varchar(50) not null,
//        memory_amount varchar(20),
//        processor varchar(20),
//        price decimal(5, 2) not null,
//        quantity int(11) not null
public class Console {

    private int gameId;
    private String model;
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    private BigDecimal price;
    private int quantity;


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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Console)) return false;
        Console console = (Console) o;
        return gameId == console.gameId &&
                quantity == console.quantity &&
                model.equals(console.model) &&
                manufacturer.equals(console.manufacturer) &&
                Objects.equals(memoryAmount, console.memoryAmount) &&
                Objects.equals(processor, console.processor) &&
                price.equals(console.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
