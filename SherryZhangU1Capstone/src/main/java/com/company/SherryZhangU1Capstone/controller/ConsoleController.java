package com.company.SherryZhangU1Capstone.controller;


import com.company.SherryZhangU1Capstone.exception.NotFoundException;
import com.company.SherryZhangU1Capstone.service.PurchaseItemService;
import com.company.SherryZhangU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    PurchaseItemService purchaseItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createController(@RequestBody @Valid ConsoleViewModel consoleViewModel) {
        return purchaseItemService.saveConsole(consoleViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") int id) {
        ConsoleViewModel consoleViewModel = purchaseItemService.findConsoleById(id);
        if (consoleViewModel == null)
            throw new NotFoundException("Item could not be retrieved for id " + id);
        return consoleViewModel;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int id) {
        purchaseItemService.removeConsole(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void updateConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel) {
//        if (consoleViewModel.getGameId() == 0)
//            consoleViewModel.setGameId(id);
//        if (id != consoleViewModel.getGameId()) {
//            throw new IllegalArgumentException("Console ID on path must match the ID in the Console object");
//        }
        purchaseItemService.updateConsole(consoleViewModel);
    }

    @GetMapping("/manufacturer/{manu}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoleByManu(@PathVariable("manu") String manu) {
        List<ConsoleViewModel> consoleViewModelList = purchaseItemService.findConsoleByManu(manu);
        if (manu != null && consoleViewModelList.size() == 0)
            throw new NotFoundException("console could not be retrieved for manufacturer " + manu);
        return consoleViewModelList;
    }
}
