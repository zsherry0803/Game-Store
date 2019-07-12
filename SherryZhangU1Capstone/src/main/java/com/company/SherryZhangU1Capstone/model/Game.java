package com.company.SherryZhangU1Capstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Game {
//    game_id int(11) not null auto_increment primary key,
//    title varchar(50) not null,
//    ersb_rating varchar(50) not null,
//    description varchar(255) not null,
//    price decimal(5, 2) not null,
//    studio varchar(50) not null,
//    quantity int(11)

    private int gameId;
    private String title;
    private String ersbRating;
    private String description;
    private BigDecimal price;
    private String studio;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return gameId == game.gameId &&
                title.equals(game.title) &&
                ersbRating.equals(game.ersbRating) &&
                description.equals(game.description) &&
                price.equals(game.price) &&
                studio.equals(game.studio) &&
                Objects.equals(quantity, game.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, title, ersbRating, description, price, studio, quantity);
    }
}
