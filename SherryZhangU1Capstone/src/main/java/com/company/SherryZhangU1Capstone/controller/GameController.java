package com.company.SherryZhangU1Capstone.controller;

import com.company.SherryZhangU1Capstone.exception.NotFoundException;
import com.company.SherryZhangU1Capstone.service.PurchaseItemService;
import com.company.SherryZhangU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    PurchaseItemService purchaseItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel gameViewModel) {
        return purchaseItemService.saveGame(gameViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") int id) {
        GameViewModel gameViewModel = purchaseItemService.findGameById(id);
        if (gameViewModel == null)
            throw new NotFoundException("Game could not be retrieved for id " + id);
        return gameViewModel;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") int id) {
        purchaseItemService.removeGame(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void updateGame(@RequestBody @Valid GameViewModel gameViewModel) {
        purchaseItemService.updateGame(gameViewModel);
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getConsoleBystudio(@PathVariable("studio") String studio) {
        List<GameViewModel> gameViewModelList = purchaseItemService.findGameByStudio(studio);
        if (studio != null && gameViewModelList.size() == 0)
            throw new NotFoundException("game could not be retrieved for studio " + studio);
        return gameViewModelList;
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getConsoleBytitle(@PathVariable("title") String title) {
        List<GameViewModel> gameViewModelList = purchaseItemService.findGameByTitle(title);
        if (title != null && gameViewModelList.size() == 0)
            throw new NotFoundException("game could not be retrieved for title " + title);
        return gameViewModelList;
    }

    @GetMapping("/ESRB/{ESRB}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getConsoleByRating(@PathVariable("ESRB") String ESRB) {
        List<GameViewModel> gameViewModelList = purchaseItemService.findGameByRating(ESRB);
        if (ESRB != null && gameViewModelList.size() == 0)
            throw new NotFoundException("game could not be retrieved for ESRB " + ESRB);
        return gameViewModelList;
    }
}
