package com.company.SherryZhangU1Capstone.dao;

import com.company.SherryZhangU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        List<Game> list = gameDao.getAllGames();
        for(Game game : list){
            gameDao.deleteGame(game.getGameId());
        }
    }

    @Test
    public void addGetDeleteGame() {
        Game game = new Game();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setQuantity(50);

        game = gameDao.addGame(game);
        Game game1 = gameDao.getGame(game.getGameId());

        assertEquals(game,game1);
        gameDao.deleteGame(game.getGameId());
        game1 = gameDao.getGame(game.getGameId());

        assertNull(game1);
    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setQuantity(50);

        game = gameDao.addGame(game);

        game.setErsbRating("M16+");
        game.setPrice(new BigDecimal("40.00").setScale(2));
        gameDao.updateGame(game);
        Game game1 = gameDao.getGame(game.getGameId());

        assertEquals(game,game1);
    }

    @Test
    public void getAllGames() {
        Game game = new Game();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setStudio("studio");
        game.setQuantity(50);

        gameDao.addGame(game);
        game.setTitle("newTitle");
        gameDao.addGame(game);
        List<Game> list = gameDao.getAllGames();

        assertEquals(2,list.size());
    }

    @Test
    public void getGameByStudio() {
        Game game = new Game();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setQuantity(50);

        gameDao.addGame(game);
        game.setTitle("newTitle");
        gameDao.addGame(game);
        game.setStudio("EA");
        gameDao.addGame(game);
        List<Game> list = gameDao.getGameByStudio("SE");
        assertEquals(2,list.size());
//
        list = gameDao.getGameByStudio("EA");
        assertEquals(1, list.size());
    }

    @Test
    public void getGameByRating() {
        Game game = new Game();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setQuantity(50);

        gameDao.addGame(game);
        game.setTitle("newTitle");
        gameDao.addGame(game);
        game.setErsbRating("M16+");
        gameDao.addGame(game);
        List<Game> list = gameDao.getGameByRating("M18+");
        assertEquals(2,list.size());

        list = gameDao.getGameByRating("M16+");
        assertEquals(1, list.size());
    }

    @Test
    public void getGameByTitle() {
        Game game = new Game();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setQuantity(50);

        gameDao.addGame(game);
        game.setErsbRating("newRating");
        gameDao.addGame(game);
        game.setTitle("newTitle");
        gameDao.addGame(game);
        List<Game> list = gameDao.getGameByTitle("FF 14");
        assertEquals(2,list.size());

        list = gameDao.getGameByTitle("newTitle");
        assertEquals(1, list.size());
    }
}