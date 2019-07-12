package com.company.SherryZhangU1Capstone.dao;


import com.company.SherryZhangU1Capstone.model.Game;

import java.util.List;

//a. Perform standard CRUD operations for Games
//        b. Search for Games by Studio
//        c. Search for Games by ESRB Rating
//        d. Search for Games by Title
//        e. You must create a separate DAO for Games
public interface GameDao {

    Game addGame(Game game);
    Game getGame(int id);
    void updateGame(Game game);
    void deleteGame(int id);
    List<Game> getAllGames();
    List<Game> getGameByStudio(String studio);
    List<Game> getGameByRating(String rating);
    List<Game> getGameByTitle(String title);


}
