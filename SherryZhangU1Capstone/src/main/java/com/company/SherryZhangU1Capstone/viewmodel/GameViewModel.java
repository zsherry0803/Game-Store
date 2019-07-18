package com.company.SherryZhangU1Capstone.viewmodel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {

    private int gameId;
    @NotEmpty(message = "Please supply a value for title")
    private String title;
    @NotEmpty(message = "Please supply a value for ersbRating")
    private String ersbRating;
    @NotEmpty(message = "Please supply a value for description")
    private String description;
    @NotEmpty(message = "Please supply a value for studio")
    private String studio;
    @NotNull(message = "Please supply a value for price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal price;
    @Min(0)
    private Integer quantity;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getErsbRating() {
        return ersbRating;
    }

    public void setErsbRating(String ersbRating) {
        this.ersbRating = ersbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        if (!(o instanceof GameViewModel)) return false;
        GameViewModel that = (GameViewModel) o;
        return gameId == that.gameId &&
                title.equals(that.title) &&
                ersbRating.equals(that.ersbRating) &&
                description.equals(that.description) &&
                studio.equals(that.studio) &&
                price.equals(that.price) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, title, ersbRating, description, studio, price, quantity);
    }
}
