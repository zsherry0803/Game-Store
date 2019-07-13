package com.company.SherryZhangU1Capstone.dao;

import com.company.SherryZhangU1Capstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoTemplateImpl implements GameDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_GAME_SQL =
            "insert into game (title, ersb_rating, description, price, studio, quantity) values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_GAME_SQL =
            "select * from game where game_id = ?";

    private static final String SELECT_ALL_GAMES_BY_TITLE_SQL =
            "select * from game where title = ?";

    private static final String SELECT_ALL_GAMES_BY_STUDIO_SQL =
            "select * from game where studio = ?";

    private static final String SELECT_ALL_GAMES_BY_RATING_SQL =
            "select * from game where ersb_rating = ?";

    private static final String SELECT_ALL_GAMES_SQL =
            "select * from game";

    private static final String UPDATE_GAME_SQL =
            "update game set title = ?, ersb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? where game_id = ?";

    private static final String DELETE_GAME_SQL =
            "delete from game where game_id = ?";

    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setErsbRating(rs.getString("ersb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));

        return game;
    }


    @Override
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getTitle(),
                game.getErsbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        game.setGameId(id);
        return game;
    }

    @Override
    public Game getGame(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this invoice id, return null
            return null;
        }
    }

    @Override
    public void updateGame(Game game) {

        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getTitle(),
                game.getErsbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getGameId());

    }

    @Override
    public void deleteGame(int id) {
        jdbcTemplate.update(DELETE_GAME_SQL,id);
    }

    @Override
    public List<Game> getAllGames() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public List<Game> getGameByStudio(String studio) {
        return jdbcTemplate.query(SELECT_ALL_GAMES_BY_STUDIO_SQL, this::mapRowToGame, studio);
    }

    @Override
    public List<Game> getGameByRating(String rating) {
        return jdbcTemplate.query(SELECT_ALL_GAMES_BY_RATING_SQL, this::mapRowToGame, rating);
    }

    @Override
    public List<Game> getGameByTitle(String title) {
        return jdbcTemplate.query(SELECT_ALL_GAMES_BY_TITLE_SQL, this::mapRowToGame, title);
    }
}
