package com.company.SherryZhangU1Capstone.controller;

import com.company.SherryZhangU1Capstone.exception.NotFoundException;
import com.company.SherryZhangU1Capstone.service.PurchaseItemService;
import com.company.SherryZhangU1Capstone.viewmodel.GameViewModel;
import com.company.SherryZhangU1Capstone.viewmodel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tshirt")
public class TshirtController {
    @Autowired
    PurchaseItemService purchaseItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TshirtViewModel createTshirt(@RequestBody @Valid TshirtViewModel tshirtViewModel) {
        return purchaseItemService.saveTshirt(tshirtViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TshirtViewModel getTshirt(@PathVariable("id") int id) {
        TshirtViewModel tshirtViewModel = purchaseItemService.findTshirtById(id);
        if (tshirtViewModel == null)
            throw new NotFoundException("Tshirt could not be retrieved for id " + id);
        return tshirtViewModel;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable("id") int id) {
        purchaseItemService.removeTshirt(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void updateTshirt(@RequestBody @Valid TshirtViewModel tshirtViewModel) {
        purchaseItemService.updateTshirt(tshirtViewModel);
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getTshirtByColor(@PathVariable("color") String color) {
        List<TshirtViewModel> tshirtViewModelList = purchaseItemService.findTshirtByColor(color);
        if (color != null && tshirtViewModelList.size() == 0)
            throw new NotFoundException("Tshirt could not be retrieved for studio " + color);
        return tshirtViewModelList;
    }

    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getTshirtBySize(@PathVariable("size") String size) {
        List<TshirtViewModel> tshirtViewModelList = purchaseItemService.findTshirtBySize(size);
        if (size != null && tshirtViewModelList.size() == 0)
            throw new NotFoundException("Tshirt could not be retrieved for title " + size);
        return tshirtViewModelList;
    }

}
